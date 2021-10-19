package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class l extends BaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f62728a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f62729b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> l(Context context) {
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
        this.f62728a = null;
        this.f62729b = null;
        this.f62729b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f62728a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f62728a.getmBankCard())));
                String handlePwdSimple = PasswordController.handlePwdSimple(this.f62729b.mPayPass);
                String seed = PasswordController.getSeed();
                String handlePwd = PasswordController.handlePwd(this.f62729b.mConfirmPayPass, seed);
                arrayList.add(new RestNameValuePair("mobile_pwd", SecurePay.getInstance().encryptProxy(handlePwdSimple)));
                arrayList.add(new RestNameValuePair("confirm_mobile_pwd", handlePwd));
                arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f62729b.mConfirmPayPass)));
                arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
                arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
                arrayList.add(new RestNameValuePair("sms_token", this.f62728a.getSmsToken()));
                arrayList.add(new RestNameValuePair("session_id", this.f62728a.getSessionId()));
                return arrayList;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD : invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "gbk" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASS_FROM_OLD_CARD_RESETPASS;
        }
        return (String) invokeV.objValue;
    }
}
