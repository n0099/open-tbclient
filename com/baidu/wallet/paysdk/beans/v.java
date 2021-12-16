package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class v extends BaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f54006b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54007c;

    /* renamed from: d  reason: collision with root package name */
    public String f54008d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> v(Context context) {
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
        this.f54007c = true;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f54006b = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f54008d = str;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.execBean(String.class, ErrorContentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String seed = PasswordController.getSeed();
            String encryptProxy = SecurePay.getInstance().encryptProxy(seed);
            if (this.f54007c) {
                arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.a, seed)));
                arrayList.add(new RestNameValuePair("seed", encryptProxy));
            } else {
                String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f54006b);
                String sn = WalletFingerprint.getInstance(this.mContext).getSN();
                if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                    arrayList.add(new RestNameValuePair("token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                    arrayList.add(new RestNameValuePair("serial_num", SecurePay.getInstance().encrypt(sn)));
                    arrayList.add(new RestNameValuePair("verify_type", "2"));
                }
            }
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            arrayList.add(new RestNameValuePair("scenario", "bindcard"));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("request_type", BindFastRequest.getCardRequestType(1)));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, ""));
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Initiative.name());
            if (!TextUtils.isEmpty(this.f54008d)) {
                arrayList.add(new RestNameValuePair("session_id", this.f54008d));
            } else if (bindFastRequest != null && !TextUtils.isEmpty(bindFastRequest.getSessionId())) {
                arrayList.add(new RestNameValuePair("session_id", bindFastRequest.getSessionId()));
            } else {
                arrayList.add(new RestNameValuePair("session_id", ""));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD : invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_VERIFY_MOBILE_PWD_NEW;
        }
        return (String) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f54007c = z;
        }
    }
}
