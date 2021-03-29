package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class OtherBean<T> extends NetworkBean<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24243a = "OtherBaseBean";
    public int mRetCode;

    public OtherBean(Context context) {
        super(context);
        this.mRetCode = -1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> d2;
        if (getHttpMethod() == 0) {
            d2 = this.mRestTemplate.b(getUrl(), getRequestParams(), getEncode(), cls);
        } else {
            d2 = getHttpMethod() == 1 ? this.mRestTemplate.d(getUrl(), getRequestParams(), getEncode(), cls) : null;
        }
        if (d2 != null && this.mRspCallback != null) {
            Object body = d2.getBody();
            if (body == null) {
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                return;
            }
            if (body instanceof String) {
                try {
                    BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson((String) body, BeanResponseBase.class);
                    if (beanResponseBase != null) {
                        this.mRetCode = beanResponseBase.ret;
                    } else {
                        this.mRetCode = -4;
                    }
                    if (beanResponseBase != null && beanResponseBase.ret == 0 && (beanResponseBase.needVerifySignature() || needVerifySignature())) {
                        String string = new JSONObject(d2.b()).getString(beanResponseBase.getNameOfRealResponseContent());
                        if (!VerSig.verify(beanResponseBase.signature, string, beanResponseBase.mdAlgorithm)) {
                            DXMSdkSAUtils.onEvent(StatServiceEvent.VERIFY_SIGNATURE_FAILED);
                            PayStatisticsUtil.onEvent(StatServiceEvent.VERIFY_SIGNATURE_FAILED);
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                            return;
                        } else if (beanResponseBase.needDecryption()) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject((String) body);
                            if (!TextUtils.isEmpty(string)) {
                                jSONObject.put(beanResponseBase.getNameOfRealResponseContent(), SafePay.getInstance().decryptProxy(string));
                            }
                            body = jSONObject.toString();
                        }
                    }
                } catch (JSONException e2) {
                    LogUtil.e("OtherBaseBean", e2.getMessage(), e2);
                } catch (org.json.JSONException e3) {
                    LogUtil.e("OtherBaseBean", e3.getMessage(), e3);
                }
            }
            this.mRspCallback.onBeanExecSuccess(getBeanId(), body, null);
            return;
        }
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EbpayHttpRequestInterceptor());
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new b());
    }
}
