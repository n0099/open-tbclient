package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class y extends PayBaseBean<PayResponse> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25364a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f25365b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f25366c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25367d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25368e;

    public y(Context context) {
        super(context);
        this.f25364a = null;
        this.f25365b = null;
        this.f25366c = null;
        this.f25367d = false;
        this.f25368e = false;
        this.f25364a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.f25365b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f25366c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private List<RestNameValuePair> a() {
        ArrayList arrayList = new ArrayList();
        CardData.BondCard bondCard = this.f25366c.mBondCard;
        arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
        arrayList.add(new RestNameValuePair("bind_flag", "1"));
        arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
        arrayList.add(new RestNameValuePair("true_name", bondCard.true_name));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.f25366c.mSmsCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25366c.mSmsCode));
            this.f25366c.mSmsCode = null;
        }
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        arrayList.add(new RestNameValuePair("bank_code", this.f25366c.mChannelNo));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        PwdRequest pwdRequest = this.f25365b;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f25365b.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
        } else if (!PayDataCache.getInstance().isPassFree() && this.f25366c != null && !com.baidu.wallet.paysdk.a.b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f25366c.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                arrayList.add(new RestNameValuePair("f_token_code", SafePay.getInstance().encrypt(generateOTPKey)));
                arrayList.add(new RestNameValuePair("f_serial_num", SafePay.getInstance().encrypt(sn)));
            }
        }
        return arrayList;
    }

    private List<RestNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        CardData.BondCard bondCard = this.f25364a.mBondCard;
        arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
        arrayList.add(new RestNameValuePair("bind_flag", "1"));
        arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
        arrayList.add(new RestNameValuePair("true_name", bondCard.true_name));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.f25364a.getmSmsVCode())) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25364a.getmSmsVCode()));
            this.f25364a.mSmsVCode = null;
        }
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        arrayList.add(new RestNameValuePair("bank_code", this.f25364a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        if (this.f25365b == null) {
            return arrayList;
        }
        a(arrayList);
        return arrayList;
    }

    private List<RestNameValuePair> c(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("card_type", String.valueOf(z ? 1 : 2)));
        arrayList.add(new RestNameValuePair("bind_flag", "0"));
        arrayList.add(new RestNameValuePair("need_bind_card", "1"));
        if (!TextUtils.isEmpty(this.f25364a.mSmsVCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25364a.mSmsVCode));
            this.f25364a.mSmsVCode = null;
        }
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25364a.mBankCard)));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.f25364a.getmName())) {
            arrayList.add(new RestNameValuePair("true_name", this.f25364a.getmName()));
        }
        if (!TextUtils.isEmpty(this.f25364a.getCertificateType())) {
            arrayList.add(new RestNameValuePair("identity_type", this.f25364a.getCertificateType()));
        }
        if (!TextUtils.isEmpty(this.f25364a.getmIdCard())) {
            arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25364a.getmIdCard())));
        }
        if (!TextUtils.isEmpty(this.f25364a.getmPhone())) {
            arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.f25364a.getmPhone())));
        }
        if (!TextUtils.isEmpty(this.f25364a.getmValidDate())) {
            arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25364a.getmValidDate())));
        }
        if (!TextUtils.isEmpty(this.f25364a.getmCvv())) {
            arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25364a.getmCvv())));
        }
        arrayList.add(new RestNameValuePair("account_bank_code", this.f25364a.getChannelNo()));
        arrayList.add(new RestNameValuePair("bank_code", this.f25364a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", this.f25364a.mBankNo));
        if (this.f25365b == null) {
            return arrayList;
        }
        a(arrayList);
        return arrayList;
    }

    private List<RestNameValuePair> d(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (PayDataCache.getInstance().hasMobilePwd()) {
            arrayList.add(new RestNameValuePair("bind_flag", "1"));
            arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        } else {
            arrayList.add(new RestNameValuePair("bind_flag", "0"));
            arrayList.add(new RestNameValuePair("need_bind_card", "1"));
        }
        BindFastRequest bindFastRequest = this.f25364a;
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
            if (!TextUtils.isEmpty(this.f25364a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25364a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.f25364a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25364a.getmCvv())));
            }
        } else {
            arrayList.add(new RestNameValuePair("card_type", String.valueOf(2)));
        }
        if (!TextUtils.isEmpty(this.f25364a.mSmsVCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25364a.mSmsVCode));
            this.f25364a.mSmsVCode = null;
        }
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.f25364a.getmPhone())));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25364a.mBankCard)));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.f25364a.getmName())) {
            arrayList.add(new RestNameValuePair("true_name", this.f25364a.getmName()));
        }
        if (!TextUtils.isEmpty(this.f25364a.getCertificateType())) {
            arrayList.add(new RestNameValuePair("identity_type", this.f25364a.getCertificateType()));
        }
        if (!TextUtils.isEmpty(this.f25364a.getmIdCard())) {
            arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25364a.getmIdCard())));
        }
        arrayList.add(new RestNameValuePair("bank_code", this.f25364a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        if (this.f25365b == null) {
            return arrayList;
        }
        a(arrayList);
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(PayResponse.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> c2;
        CalcPaymentResponse calcPaymentResponse;
        PayRequest payRequest;
        ErrorContentResponse.MktSolution mktSolution;
        int i2 = 1;
        if (this.f25367d) {
            c2 = a();
        } else {
            BindFastRequest bindFastRequest = this.f25364a;
            if (bindFastRequest == null) {
                return new ArrayList();
            }
            int i3 = bindFastRequest.mBindFrom;
            if (i3 == 0 || i3 == 6) {
                c2 = c(this.f25364a.getCardType() == 1);
            } else if (i3 == 2 || i3 == 7) {
                c2 = d(this.f25364a.getCardType() == 1);
            } else if (i3 == 8) {
                c2 = b();
            } else {
                return new ArrayList();
            }
        }
        PayRequest payRequest2 = this.f25366c;
        if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.mUseVcodeToPay)) {
            c2.add(new RestNameValuePair("use_vcode_to_pay", this.f25366c.mUseVcodeToPay));
        }
        PayRequest payRequest3 = this.f25366c;
        if (payRequest3 != null && payRequest3.isPayByMktSolution && (mktSolution = payRequest3.mMktSolution) != null) {
            if (!TextUtils.isEmpty(mktSolution.easypay_amount)) {
                c2.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25366c.mMktSolution.easypay_amount));
            }
            if (this.f25366c.getCalcPayment() != null) {
                String selectedDiscountIds = this.f25366c.getCalcPayment().getSelectedDiscountIds(this.f25366c.mMktSolution.activity_list);
                if (!TextUtils.isEmpty(selectedDiscountIds)) {
                    c2.add(new RestNameValuePair("activity_id", selectedDiscountIds));
                    i2 = 2;
                }
                String selectedCouponIds = this.f25366c.getCalcPayment().getSelectedCouponIds(this.f25366c.mMktSolution.coupon_list);
                if (!TextUtils.isEmpty(selectedCouponIds)) {
                    i2++;
                    c2.add(new RestNameValuePair("coupon_id", selectedCouponIds));
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            if (this.f25367d && (payRequest = this.f25366c) != null) {
                calcPaymentResponse = payRequest.getCalcPayment() != null ? this.f25366c.getCalcPayment() : null;
                c2.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25366c.getEasyPayAmount()));
            } else {
                BindFastRequest bindFastRequest2 = this.f25364a;
                if (bindFastRequest2 != null && bindFastRequest2.mBindFrom == 0) {
                    calcPaymentResponse = bindFastRequest2.getCalcPaymentResponse();
                    c2.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25364a.getEasyPayAmount()));
                } else {
                    PayRequest payRequest4 = this.f25366c;
                    if (payRequest4 != null) {
                        calcPaymentResponse = payRequest4.getCalcPayment() != null ? this.f25366c.getCalcPayment() : null;
                        c2.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25366c.getEasyPayAmount()));
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
        PayRequest payRequest5 = this.f25366c;
        if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.withholding_auth)) {
            c2.add(new RestNameValuePair("need_open_authorize", this.f25366c.withholding_auth));
        }
        PayRequest payRequest6 = this.f25366c;
        if (payRequest6 != null && !TextUtils.isEmpty(payRequest6.mSecurityParams)) {
            c2.add(new RestNameValuePair("security_sdk_param", this.f25366c.mSecurityParams));
        }
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
            c2.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f25366c.getOpenPassFreeFlag())));
        }
        if (!TextUtils.isEmpty(this.f25366c.getmBankCardNumber())) {
            c2.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f25366c.getmBankCardNumber())));
        }
        if (!TextUtils.isEmpty(this.f25366c.getmCvv2())) {
            c2.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f25366c.getmCvv2())));
        }
        if (!TextUtils.isEmpty(this.f25366c.getmIdCard())) {
            c2.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f25366c.getmIdCard())));
        }
        this.f25366c.setmBankCardNumber("");
        this.f25366c.setmCvv2("");
        this.f25366c.setmIdCard("");
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f25366c);
        if (this.f25368e) {
            c2.add(new RestNameValuePair("is_pay_sms", "1"));
        }
        PayRequest payRequest7 = this.f25366c;
        if (payRequest7 != null && !TextUtils.isEmpty(payRequest7.mLivingKey)) {
            c2.add(new RestNameValuePair("living_key", this.f25366c.mLivingKey));
            this.f25366c.mLivingKey = null;
        }
        PayRequest payRequest8 = this.f25366c;
        if (payRequest8 != null && !TextUtils.isEmpty(payRequest8.mLivingResultCode)) {
            c2.add(new RestNameValuePair("living_result_code", this.f25366c.mLivingResultCode));
            this.f25366c.mLivingResultCode = null;
        }
        PayDataCache.getInstance().setPrePayRequestParams(c2);
        return c2;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 13;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "UTF-8";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        if (com.baidu.wallet.paysdk.a.b.a()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CONTRACT_PAY;
        }
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_DO_PAY;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        return true;
    }

    public void b(boolean z) {
        this.f25368e = z;
    }

    private void a(List<RestNameValuePair> list) {
        if (list == null || this.f25365b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mPwdRequest == null ");
        sb.append(this.f25365b == null);
        LogUtil.d(sb.toString());
        if (!TextUtils.isEmpty(this.f25365b.mPayPass)) {
            if (!TextUtils.isEmpty(this.f25365b.mConfirmPayPass)) {
                list.add(new RestNameValuePair("mobilepwd", SafePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.f25365b.mPayPass))));
            } else {
                String seed = PasswordController.getSeed();
                list.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f25365b.mPayPass, seed)));
                list.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
            }
        } else if (!PayDataCache.getInstance().isPassFree() && this.f25366c != null && !com.baidu.wallet.paysdk.a.b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f25366c.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                list.add(new RestNameValuePair("f_token_code", SafePay.getInstance().encrypt(generateOTPKey)));
                list.add(new RestNameValuePair("f_serial_num", SafePay.getInstance().encrypt(sn)));
            }
        }
        if (TextUtils.isEmpty(this.f25365b.mConfirmPayPass)) {
            return;
        }
        String seed2 = PasswordController.getSeed();
        list.add(new RestNameValuePair("confirm_mobilepwd", PasswordController.handlePwd(this.f25365b.mConfirmPayPass, seed2)));
        list.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed2)));
        list.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25365b.mConfirmPayPass)));
    }

    public void a(boolean z) {
        this.f25367d = z;
    }
}
