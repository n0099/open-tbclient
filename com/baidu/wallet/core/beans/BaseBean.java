package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes5.dex */
public abstract class BaseBean<T> extends NetworkBean<T> {
    public static final int COMET_BEAN = 1;
    public static final String TAG = "BeasBean";
    public int beanType;
    public String mHttpContent;

    public BaseBean(Context context) {
        super(context);
        this.beanType = -1;
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        try {
            return (T) JsonUtils.fromJson(str, cls);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getHttpRealContent() {
        return this.mHttpContent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<E> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.baidu.apollon.restnet.RestResponseEntity<? extends com.baidu.apollon.beans.BeanResponseBase> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        String str;
        if (restResponseEntity != 0 && this.mRspCallback != null) {
            handleResponseHeaders(restResponseEntity);
            BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
            if (beanResponseBase != null) {
                handleSession(beanResponseBase.cashdesk);
                int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
                if (serverReturnValue != 0) {
                    if (serverReturnValue == 5003) {
                        DXMSdkSAUtils.onEvent(StatServiceEvent.INVALIDE_LOGIN_STATUS);
                        PayStatisticsUtil.onEvent(StatServiceEvent.INVALIDE_LOGIN_STATUS);
                    }
                    String realResponseErrContent = beanResponseBase.getRealResponseErrContent();
                    this.mHttpContent = realResponseErrContent;
                    if (!TextUtils.isEmpty(realResponseErrContent) && cls2 != 0) {
                        EventBus eventBus = EventBus.getInstance();
                        eventBus.getClass();
                        eventBus.postStickyEvent(new EventBus.Event("ev_bean_execut_err_content", new BeanErrorContent(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg(), extractRealResponse(beanResponseBase.getRealResponseErrContent(), cls2))));
                        return;
                    }
                    this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg());
                    return;
                }
                String token = beanResponseBase.getToken();
                if (!TextUtils.isEmpty(token)) {
                    AccountManager.getInstance(this.mContext).setBfbToken(token);
                }
                LogUtil.d("BeasBean", "execBean. ret       . rsp class = " + cls);
                this.mHttpContent = beanResponseBase.getRealResponseContent();
                try {
                    str = new JSONObject(restResponseEntity.b()).getString(beanResponseBase.getNameOfRealResponseContent());
                    if ((needVerifySignature() || beanResponseBase.needVerifySignature()) && !VerSig.verify(beanResponseBase.signature, str, beanResponseBase.mdAlgorithm)) {
                        DXMSdkSAUtils.onEvent(StatServiceEvent.VERIFY_SIGNATURE_FAILED);
                        PayStatisticsUtil.onEvent(StatServiceEvent.VERIFY_SIGNATURE_FAILED);
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                        return;
                    }
                } catch (com.baidu.wallet.core.lollipop.json.JSONException e2) {
                    LogUtil.e("BeasBean", e2.getMessage(), e2);
                    str = "";
                }
                if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str)) {
                    this.mHttpContent = SafePay.getInstance().decryptProxy(str);
                }
                if (cls != null) {
                    if (JsonUtils.DataType.isString(cls)) {
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), null, this.mHttpContent);
                        return;
                    }
                    T extractRealResponse = extractRealResponse(this.mHttpContent, cls);
                    LogUtil.d("BeasBean", "execBean. ret ok. real response = " + extractRealResponse);
                    if (extractRealResponse != null) {
                        IBeanResponse iBeanResponse = (IBeanResponse) extractRealResponse;
                        if (iBeanResponse.checkResponseValidity()) {
                            iBeanResponse.storeResponse(this.mContext);
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, beanResponseBase.getRealResponseMsg());
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                        return;
                    }
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    return;
                }
                this.mRspCallback.onBeanExecSuccess(getBeanId(), null, beanResponseBase.getRealResponseMsg());
                return;
            }
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
            return;
        }
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
        }
    }

    public void handleSession(BeanResponseBase.Session session) {
        BdWalletUtils.dealCashDesk(session);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        return false;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Object ebpayHttpRequestInterceptor;
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        if (this.beanType == 1) {
            ebpayHttpRequestInterceptor = new CometHttpRequestInterceptor();
        } else {
            ebpayHttpRequestInterceptor = new EbpayHttpRequestInterceptor();
        }
        arrayList.add(ebpayHttpRequestInterceptor);
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
    }

    public void setBeanParams(String... strArr) {
    }

    public BaseBean(Context context, int i) {
        super(context);
        this.beanType = -1;
        this.beanType = i;
    }
}
