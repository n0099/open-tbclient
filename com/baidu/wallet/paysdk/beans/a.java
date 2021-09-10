package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseBean<BalancePayResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f62393a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f62394b;

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
        this.f62393a = null;
        this.f62394b = null;
        this.f62393a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f62394b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(BalancePayResponse.class, ErrorContentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            StatHelper.cacheCardType("0");
            StatHelper.cacheBankCode("0");
            arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, ""));
            PwdRequest pwdRequest = this.f62393a;
            if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
                String seed = PasswordController.getSeed();
                arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f62393a.mPayPass, seed)));
                arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
            } else if (!PayDataCache.getInstance().isPassFree() && this.f62394b != null && !com.baidu.wallet.paysdk.a.b.a()) {
                String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f62394b.otp_seed);
                String sn = WalletFingerprint.getInstance(this.mContext).getSN();
                if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                    arrayList.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                    arrayList.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
                }
            }
            PayRequest payRequest = this.f62394b;
            if (payRequest != null && !TextUtils.isEmpty(payRequest.mSmsCode)) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f62394b.mSmsCode));
                this.f62394b.mSmsCode = null;
            }
            arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
            if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
                arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
            }
            PayRequest payRequest2 = this.f62394b;
            if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.withholding_auth)) {
                arrayList.add(new RestNameValuePair("need_open_authorize", this.f62394b.withholding_auth));
            }
            PayRequest payRequest3 = this.f62394b;
            if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSecurityParams)) {
                arrayList.add(new RestNameValuePair("security_sdk_param", this.f62394b.mSecurityParams));
            }
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
                arrayList.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f62394b.getOpenPassFreeFlag())));
            }
            if (!TextUtils.isEmpty(this.f62394b.getmBankCardNumber())) {
                arrayList.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f62394b.getmBankCardNumber())));
            }
            if (!TextUtils.isEmpty(this.f62394b.getmCvv2())) {
                arrayList.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f62394b.getmCvv2())));
            }
            if (!TextUtils.isEmpty(this.f62394b.getmIdCard())) {
                arrayList.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f62394b.getmIdCard())));
            }
            this.f62394b.setmBankCardNumber("");
            this.f62394b.setmCvv2("");
            this.f62394b.setmIdCard("");
            PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f62394b);
            PayRequest payRequest4 = this.f62394b;
            if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mLivingKey)) {
                arrayList.add(new RestNameValuePair("living_key", this.f62394b.mLivingKey));
                this.f62394b.mLivingKey = null;
            }
            PayRequest payRequest5 = this.f62394b;
            if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.mLivingResultCode)) {
                arrayList.add(new RestNameValuePair("living_result_code", this.f62394b.mLivingResultCode));
                this.f62394b.mLivingResultCode = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 14;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_DO_PAY;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BaseBean, com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
