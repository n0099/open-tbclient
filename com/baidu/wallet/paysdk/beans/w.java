package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
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
public class w extends BaseBean<PayResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f62716a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f62717b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f62718c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62719d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62720e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
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
        this.f62716a = null;
        this.f62717b = null;
        this.f62718c = null;
        this.f62719d = false;
        this.f62720e = false;
        this.f62716a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.f62717b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f62718c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private List<RestNameValuePair> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            ArrayList arrayList = new ArrayList();
            CardData.BondCard bondCard = this.f62718c.mBondCard;
            StatHelper.cacheCardType(String.valueOf(bondCard.card_type));
            StatHelper.cacheBankCode(bondCard.bank_code);
            arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
            arrayList.add(new RestNameValuePair("bind_flag", "1"));
            arrayList.add(new RestNameValuePair("need_bind_card", "0"));
            arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, bondCard.true_name));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.f62718c.mSmsCode)) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f62718c.mSmsCode));
                this.f62718c.mSmsCode = null;
            }
            if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
                arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
            }
            arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.f62718c.mChannelNo));
            arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
            PwdRequest pwdRequest = this.f62717b;
            if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
                String seed = PasswordController.getSeed();
                arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f62717b.mPayPass, seed)));
                arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
            } else if (!PayDataCache.getInstance().isPassFree() && this.f62718c != null && !com.baidu.wallet.paysdk.a.b.a()) {
                String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f62718c.otp_seed);
                String sn = WalletFingerprint.getInstance(this.mContext).getSN();
                if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                    arrayList.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                    arrayList.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private List<RestNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList arrayList = new ArrayList();
            CardData.BondCard bondCard = this.f62716a.mBondCard;
            StatHelper.cacheCardType(String.valueOf(bondCard.card_type));
            StatHelper.cacheBankCode(String.valueOf(bondCard.bank_code));
            arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
            arrayList.add(new RestNameValuePair("bind_flag", "1"));
            arrayList.add(new RestNameValuePair("need_bind_card", "0"));
            arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, bondCard.true_name));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.f62716a.getmSmsVCode())) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f62716a.getmSmsVCode()));
                this.f62716a.mSmsVCode = null;
            }
            if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
                arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
            }
            arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.f62716a.getChannelNo()));
            arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
            if (this.f62717b == null) {
                return arrayList;
            }
            a(arrayList);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private List<RestNameValuePair> c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            String valueOf = String.valueOf(z ? 1 : 2);
            StatHelper.cacheCardType(valueOf);
            StatHelper.cacheBankCode(this.f62716a.mBankNo);
            arrayList.add(new RestNameValuePair("card_type", valueOf));
            arrayList.add(new RestNameValuePair("bind_flag", "0"));
            arrayList.add(new RestNameValuePair("need_bind_card", "1"));
            if (!TextUtils.isEmpty(this.f62716a.mSmsVCode)) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f62716a.mSmsVCode));
                this.f62716a.mSmsVCode = null;
            }
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f62716a.mBankCard)));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.f62716a.getmName())) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.f62716a.getmName()));
            }
            if (!TextUtils.isEmpty(this.f62716a.getCertificateType())) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.f62716a.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f62716a.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f62716a.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.f62716a.getmPhone())) {
                arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.f62716a.getmPhone())));
            }
            if (!TextUtils.isEmpty(this.f62716a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f62716a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.f62716a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f62716a.getmCvv())));
            }
            arrayList.add(new RestNameValuePair("account_bank_code", this.f62716a.getChannelNo()));
            arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.f62716a.getChannelNo()));
            arrayList.add(new RestNameValuePair("sub_bank_code", this.f62716a.mBankNo));
            if (this.f62717b == null) {
                return arrayList;
            }
            a(arrayList);
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    private List<RestNameValuePair> d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (PayDataCache.getInstance().hasMobilePwd()) {
                arrayList.add(new RestNameValuePair("bind_flag", "1"));
                arrayList.add(new RestNameValuePair("need_bind_card", "0"));
            } else {
                arrayList.add(new RestNameValuePair("bind_flag", "0"));
                arrayList.add(new RestNameValuePair("need_bind_card", "1"));
            }
            BindFastRequest bindFastRequest = this.f62716a;
            CardData.BondCard bondCard = bindFastRequest.mBondCard;
            if (bondCard == null) {
                return arrayList;
            }
            ErrorContentResponse errorContentResponse = bindFastRequest.mCardInfoUpdateContent;
            if (!TextUtils.isEmpty(bondCard.need_true_name)) {
                arrayList.add(new RestNameValuePair("need_true_name", bondCard.need_true_name));
            }
            if (!TextUtils.isEmpty(bondCard.need_identity_code)) {
                arrayList.add(new RestNameValuePair("need_identity_code", bondCard.need_identity_code));
            }
            if (!TextUtils.isEmpty(bondCard.need_identity_type)) {
                arrayList.add(new RestNameValuePair("need_identity_type", bondCard.need_identity_type));
            }
            if (errorContentResponse != null && errorContentResponse.isNeedPhoneNum()) {
                arrayList.add(new RestNameValuePair("need_phone_num", errorContentResponse.need_phone_num));
            } else if (!TextUtils.isEmpty(bondCard.need_phone_num)) {
                arrayList.add(new RestNameValuePair("need_phone_num", bondCard.need_phone_num));
            }
            if (z) {
                StatHelper.cacheCardType(String.valueOf(1));
                arrayList.add(new RestNameValuePair("card_type", String.valueOf(1)));
                if (errorContentResponse != null && errorContentResponse.isNeedValidCode()) {
                    arrayList.add(new RestNameValuePair("need_cvv2", errorContentResponse.need_cvv2));
                } else if (!TextUtils.isEmpty(bondCard.need_cvv2)) {
                    arrayList.add(new RestNameValuePair("need_cvv2", bondCard.need_cvv2));
                }
                if (errorContentResponse != null && errorContentResponse.isNeedValidDate()) {
                    arrayList.add(new RestNameValuePair("need_valid_date", errorContentResponse.need_valid_date));
                } else if (!TextUtils.isEmpty(bondCard.need_valid_date)) {
                    arrayList.add(new RestNameValuePair("need_valid_date", bondCard.need_valid_date));
                }
                if (!TextUtils.isEmpty(this.f62716a.getmValidDate())) {
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f62716a.getmValidDate())));
                }
                if (!TextUtils.isEmpty(this.f62716a.getmCvv())) {
                    arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f62716a.getmCvv())));
                }
            } else {
                StatHelper.cacheCardType(String.valueOf(2));
                arrayList.add(new RestNameValuePair("card_type", String.valueOf(2)));
            }
            if (!TextUtils.isEmpty(this.f62716a.mSmsVCode)) {
                arrayList.add(new RestNameValuePair("message_vcode", this.f62716a.mSmsVCode));
                this.f62716a.mSmsVCode = null;
            }
            arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.f62716a.getmPhone())));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f62716a.mBankCard)));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.f62716a.getmName())) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.f62716a.getmName()));
            }
            if (!TextUtils.isEmpty(this.f62716a.getCertificateType())) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.f62716a.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f62716a.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f62716a.getmIdCard())));
            }
            arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.f62716a.getChannelNo()));
            arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
            StatHelper.cacheBankCode(bondCard.bank_code);
            if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
                arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
            }
            if (this.f62717b == null) {
                return arrayList;
            }
            a(arrayList);
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(PayResponse.class, ErrorContentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        List<RestNameValuePair> c2;
        CalcPaymentResponse calcPaymentResponse;
        PayRequest payRequest;
        ErrorContentResponse.MktSolution mktSolution;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = 1;
            if (this.f62719d) {
                c2 = a();
            } else {
                BindFastRequest bindFastRequest = this.f62716a;
                if (bindFastRequest == null) {
                    return new ArrayList();
                }
                int i3 = bindFastRequest.mBindFrom;
                if (i3 == 0 || i3 == 6) {
                    c2 = c(this.f62716a.getCardType() == 1);
                } else if (i3 == 2 || i3 == 7) {
                    c2 = d(this.f62716a.getCardType() == 1);
                } else if (i3 == 8) {
                    c2 = b();
                } else {
                    return new ArrayList();
                }
            }
            PayRequest payRequest2 = this.f62718c;
            if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.mUseVcodeToPay)) {
                c2.add(new RestNameValuePair("use_vcode_to_pay", this.f62718c.mUseVcodeToPay));
            }
            PayRequest payRequest3 = this.f62718c;
            if (payRequest3 != null && payRequest3.isPayByMktSolution && (mktSolution = payRequest3.mMktSolution) != null) {
                if (!TextUtils.isEmpty(mktSolution.easypay_amount)) {
                    c2.add(new RestNameValuePair("pay_amount", this.f62718c.mMktSolution.easypay_amount));
                }
                if (this.f62718c.getCalcPayment() != null) {
                    String selectedDiscountIds = this.f62718c.getCalcPayment().getSelectedDiscountIds(this.f62718c.mMktSolution.activity_list);
                    if (!TextUtils.isEmpty(selectedDiscountIds)) {
                        c2.add(new RestNameValuePair("activity_id", selectedDiscountIds));
                        i2 = 2;
                    }
                    String selectedCouponIds = this.f62718c.getCalcPayment().getSelectedCouponIds(this.f62718c.mMktSolution.coupon_list);
                    if (!TextUtils.isEmpty(selectedCouponIds)) {
                        i2++;
                        c2.add(new RestNameValuePair("coupon_id", selectedCouponIds));
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                if (this.f62719d && (payRequest = this.f62718c) != null) {
                    calcPaymentResponse = payRequest.getCalcPayment() != null ? this.f62718c.getCalcPayment() : null;
                    c2.add(new RestNameValuePair("pay_amount", this.f62718c.getEasyPayAmount()));
                } else {
                    BindFastRequest bindFastRequest2 = this.f62716a;
                    if (bindFastRequest2 != null && bindFastRequest2.mBindFrom == 0) {
                        calcPaymentResponse = bindFastRequest2.getCalcPaymentResponse();
                        c2.add(new RestNameValuePair("pay_amount", this.f62716a.getEasyPayAmount()));
                    } else {
                        PayRequest payRequest4 = this.f62718c;
                        if (payRequest4 != null) {
                            calcPaymentResponse = payRequest4.getCalcPayment() != null ? this.f62718c.getCalcPayment() : null;
                            c2.add(new RestNameValuePair("pay_amount", this.f62718c.getEasyPayAmount()));
                        } else {
                            calcPaymentResponse = null;
                        }
                    }
                }
                if (calcPaymentResponse != null) {
                    if (!TextUtils.isEmpty(calcPaymentResponse.getSelectedDiscountIds())) {
                        sb.append(calcPaymentResponse.getSelectedDiscountIds());
                        i2 = 2;
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        c2.add(new RestNameValuePair("activity_id", sb.toString()));
                    }
                    if (!TextUtils.isEmpty(calcPaymentResponse.getSelectedCouponIds())) {
                        c2.add(new RestNameValuePair("coupon_id", calcPaymentResponse.getSelectedCouponIds()));
                        i2++;
                    }
                }
            }
            if (i2 >= 2) {
                c2.add(new RestNameValuePair("composite_flag", "1"));
            } else {
                c2.add(new RestNameValuePair("composite_flag", "0"));
            }
            c2.addAll(PayDataCache.getInstance().getPayPostInfo());
            if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
                c2.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
            }
            PayRequest payRequest5 = this.f62718c;
            if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.withholding_auth)) {
                c2.add(new RestNameValuePair("need_open_authorize", this.f62718c.withholding_auth));
            }
            PayRequest payRequest6 = this.f62718c;
            if (payRequest6 != null && !TextUtils.isEmpty(payRequest6.mSecurityParams)) {
                c2.add(new RestNameValuePair("security_sdk_param", this.f62718c.mSecurityParams));
            }
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
                c2.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f62718c.getOpenPassFreeFlag())));
            }
            if (!TextUtils.isEmpty(this.f62718c.getmBankCardNumber())) {
                c2.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f62718c.getmBankCardNumber())));
            }
            if (!TextUtils.isEmpty(this.f62718c.getmCvv2())) {
                c2.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f62718c.getmCvv2())));
            }
            if (!TextUtils.isEmpty(this.f62718c.getmIdCard())) {
                c2.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f62718c.getmIdCard())));
            }
            this.f62718c.setmBankCardNumber("");
            this.f62718c.setmCvv2("");
            this.f62718c.setmIdCard("");
            PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f62718c);
            if (this.f62720e) {
                c2.add(new RestNameValuePair("is_pay_sms", "1"));
            }
            PayRequest payRequest7 = this.f62718c;
            if (payRequest7 != null && !TextUtils.isEmpty(payRequest7.mLivingKey)) {
                c2.add(new RestNameValuePair("living_key", this.f62718c.mLivingKey));
                this.f62718c.mLivingKey = null;
            }
            PayRequest payRequest8 = this.f62718c;
            if (payRequest8 != null && !TextUtils.isEmpty(payRequest8.mLivingResultCode)) {
                c2.add(new RestNameValuePair("living_result_code", this.f62718c.mLivingResultCode));
                this.f62718c.mLivingResultCode = null;
            }
            PayDataCache.getInstance().setPrePayRequestParams(c2);
            return c2;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 13;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (com.baidu.wallet.paysdk.a.b.a()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CONTRACT_PAY;
            }
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_DO_PAY;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BaseBean, com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f62720e = z;
        }
    }

    private void a(List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, list) == null) || list == null || this.f62717b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mPwdRequest == null ");
        sb.append(this.f62717b == null);
        sb.toString();
        if (!TextUtils.isEmpty(this.f62717b.mPayPass)) {
            if (!TextUtils.isEmpty(this.f62717b.mConfirmPayPass)) {
                list.add(new RestNameValuePair("mobilepwd", SecurePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.f62717b.mPayPass))));
            } else {
                String seed = PasswordController.getSeed();
                list.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f62717b.mPayPass, seed)));
                list.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
            }
        } else if (!PayDataCache.getInstance().isPassFree() && this.f62718c != null && !com.baidu.wallet.paysdk.a.b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f62718c.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                list.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                list.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
            }
        }
        if (TextUtils.isEmpty(this.f62717b.mConfirmPayPass)) {
            return;
        }
        String seed2 = PasswordController.getSeed();
        list.add(new RestNameValuePair("confirm_mobilepwd", PasswordController.handlePwd(this.f62717b.mConfirmPayPass, seed2)));
        list.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed2)));
        list.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f62717b.mConfirmPayPass)));
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f62719d = z;
        }
    }
}
