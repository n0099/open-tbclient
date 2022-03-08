package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes6.dex */
public abstract class BaseBean<T> extends NetworkBean<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMET_BEAN = 1;
    public static final String TAG = "BeasBean";
    public transient /* synthetic */ FieldHolder $fh;
    public int beanType;
    public String mHttpContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.beanType = -1;
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, cls)) == null) {
            try {
                return (T) JsonUtils.fromJson(str, cls);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public String getHttpRealContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHttpContent : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<E> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.baidu.apollon.restnet.RestResponseEntity<? extends com.baidu.apollon.beans.BeanResponseBase> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != 0 && this.mRspCallback != null) {
                handleResponseHeaders(restResponseEntity);
                BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
                if (beanResponseBase != null) {
                    handleSession(beanResponseBase.cashdesk);
                    int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
                    if (serverReturnValue != 0) {
                        if (serverReturnValue == 5003) {
                            DXMSdkSAUtils.onEvent("#invalidLoginStatus");
                        }
                        String realResponseErrContent = beanResponseBase.getRealResponseErrContent();
                        this.mHttpContent = realResponseErrContent;
                        if (!TextUtils.isEmpty(realResponseErrContent) && cls2 != 0) {
                            EventBus eventBus = EventBus.getInstance();
                            eventBus.getClass();
                            eventBus.postStickyEvent(new EventBus.Event(eventBus, "ev_bean_execut_err_content", new BeanErrorContent(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg(), extractRealResponse(beanResponseBase.getRealResponseErrContent(), cls2))));
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
                    if (checkSignSame(beanResponseBase.contentSign)) {
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), null, beanResponseBase.getRealResponseMsg());
                        LogUtil.i("BeasBean", "checkSignSame is true,call onBeanExecSuccess directly!!");
                        return;
                    }
                    try {
                        str = new JSONObject(restResponseEntity.b()).getString(beanResponseBase.getNameOfRealResponseContent());
                        if ((needVerifySignature() || beanResponseBase.needVerifySignature()) && !VerSig.verify(beanResponseBase.signature, str, beanResponseBase.mdAlgorithm)) {
                            DXMSdkSAUtils.onEvent("#verify_sign_failed");
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
                    LogUtil.d("BeasBean", "execBean. ret ok. after  mHttpContent text = " + this.mHttpContent);
                    if (cls != null) {
                        if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, this.mHttpContent);
                            return;
                        }
                        LogUtil.d("BeasBean", "execBean. ret ok. real response  text = " + this.mHttpContent);
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
    }

    public void handleSession(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, session) == null) {
            BdWalletUtils.dealCashDesk(session);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Object ebpayHttpRequestInterceptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            if (this.beanType == 1) {
                ebpayHttpRequestInterceptor = new CometHttpRequestInterceptor();
            } else {
                ebpayHttpRequestInterceptor = new EbpayHttpRequestInterceptor();
            }
            arrayList.add(ebpayHttpRequestInterceptor);
            arrayList.add(new a(this.tag[0].booleanValue()));
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
        }
    }

    public void setBeanParams(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strArr) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.beanType = -1;
        this.beanType = i2;
    }
}
