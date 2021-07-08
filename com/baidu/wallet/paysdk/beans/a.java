package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PayBaseBean<BalancePayResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25951a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25952b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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
        this.f25951a = null;
        this.f25952b = null;
        this.f25951a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f25952b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(BalancePayResponse.class, ErrorContentResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("bank_code", ""));
            PwdRequest pwdRequest = this.f25951a;
            if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
                String seed = PasswordController.getSeed();
                arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f25951a.mPayPass, seed)));
                arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
            } else if (!PayDataCache.getInstance().isPassFree() && this.f25952b != null && !com.baidu.wallet.paysdk.a.b.a()) {
                String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f25952b.otp_seed);
                String sn = WalletFingerprint.getInstance(this.mContext).getSN();
                if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                    arrayList.add(new RestNameValuePair("f_token_code", SafePay.getInstance().encrypt(generateOTPKey)));
                    arrayList.add(new RestNameValuePair("f_serial_num", SafePay.getInstance().encrypt(sn)));
                }
            }
            PayRequest payRequest = this.f25952b;
            if (payRequest != null && !TextUtils.isEmpty(payRequest.mSmsCode)) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f25952b.mSmsCode));
                this.f25952b.mSmsCode = null;
            }
            arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
            if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
                arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
            }
            PayRequest payRequest2 = this.f25952b;
            if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.withholding_auth)) {
                arrayList.add(new RestNameValuePair("need_open_authorize", this.f25952b.withholding_auth));
            }
            PayRequest payRequest3 = this.f25952b;
            if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSecurityParams)) {
                arrayList.add(new RestNameValuePair("security_sdk_param", this.f25952b.mSecurityParams));
            }
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
                arrayList.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f25952b.getOpenPassFreeFlag())));
            }
            if (!TextUtils.isEmpty(this.f25952b.getmBankCardNumber())) {
                arrayList.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f25952b.getmBankCardNumber())));
            }
            if (!TextUtils.isEmpty(this.f25952b.getmCvv2())) {
                arrayList.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f25952b.getmCvv2())));
            }
            if (!TextUtils.isEmpty(this.f25952b.getmIdCard())) {
                arrayList.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f25952b.getmIdCard())));
            }
            this.f25952b.setmBankCardNumber("");
            this.f25952b.setmCvv2("");
            this.f25952b.setmIdCard("");
            PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f25952b);
            PayRequest payRequest4 = this.f25952b;
            if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mLivingKey)) {
                arrayList.add(new RestNameValuePair("living_key", this.f25952b.mLivingKey));
                this.f25952b.mLivingKey = null;
            }
            PayRequest payRequest5 = this.f25952b;
            if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.mLivingResultCode)) {
                arrayList.add(new RestNameValuePair("living_result_code", this.f25952b.mLivingResultCode));
                this.f25952b.mLivingResultCode = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 14;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_DO_PAY;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
