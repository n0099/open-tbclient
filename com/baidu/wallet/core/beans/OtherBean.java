package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class OtherBean<T> extends NetworkBean<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24851a = "OtherBaseBean";
    public transient /* synthetic */ FieldHolder $fh;
    public int mRetCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherBean(Context context) {
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
        this.mRetCode = -1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
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
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, restResponseEntity) == null) {
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EbpayHttpRequestInterceptor());
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new b());
        }
    }
}
