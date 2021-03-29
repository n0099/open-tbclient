package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
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
public class j extends PayBaseBean<PayResponse> {

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25517a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25518b;

    public j(Context context) {
        super(context);
        this.f25517a = null;
        this.f25518b = null;
        this.f25517a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f25518b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(PayResponse.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.CreditInfo creditInfo;
        PayData.InstalmentPlan[] instalmentPlanArr;
        ArrayList arrayList = new ArrayList();
        PwdRequest pwdRequest = this.f25517a;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f25517a.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
        } else if (!PayDataCache.getInstance().isPassFree() && this.f25518b != null && !com.baidu.wallet.paysdk.a.b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f25518b.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                arrayList.add(new RestNameValuePair("f_token_code", SafePay.getInstance().encrypt(generateOTPKey)));
                arrayList.add(new RestNameValuePair("f_serial_num", SafePay.getInstance().encrypt(sn)));
            }
        }
        PayRequest payRequest = this.f25518b;
        if (payRequest != null && !TextUtils.isEmpty(payRequest.mSmsCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25518b.mSmsCode));
            this.f25518b.mSmsCode = null;
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null && (directPayPay = payResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null && (creditInfo = creditPay.credit_info) != null && (instalmentPlanArr = creditInfo.instalment_plan) != null && instalmentPlanArr.length > 0) {
            arrayList.add(new RestNameValuePair("credit_rate", instalmentPlanArr[0].rate));
            arrayList.add(new RestNameValuePair("stage_number", payResponse.pay.credit_pay.credit_info.instalment_plan[0].instalment));
            arrayList.add(new RestNameValuePair("each_repayment", payResponse.pay.credit_pay.credit_info.instalment_plan[0].amount));
        }
        arrayList.addAll(PayDataCache.getInstance().getCreditPayPostInfo());
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        PayRequest payRequest2 = this.f25518b;
        if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.withholding_auth)) {
            arrayList.add(new RestNameValuePair("need_open_authorize", this.f25518b.withholding_auth));
        }
        PayRequest payRequest3 = this.f25518b;
        if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSecurityParams)) {
            arrayList.add(new RestNameValuePair("security_sdk_param", this.f25518b.mSecurityParams));
        }
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
            arrayList.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f25518b.getOpenPassFreeFlag())));
        }
        if (!TextUtils.isEmpty(this.f25518b.getmBankCardNumber())) {
            arrayList.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f25518b.getmBankCardNumber())));
        }
        if (!TextUtils.isEmpty(this.f25518b.getmCvv2())) {
            arrayList.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f25518b.getmCvv2())));
        }
        if (!TextUtils.isEmpty(this.f25518b.getmIdCard())) {
            arrayList.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f25518b.getmIdCard())));
        }
        this.f25518b.setmBankCardNumber("");
        this.f25518b.setmCvv2("");
        this.f25518b.setmIdCard("");
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f25518b);
        PayRequest payRequest4 = this.f25518b;
        if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mLivingKey)) {
            arrayList.add(new RestNameValuePair("living_key", this.f25518b.mLivingKey));
            this.f25518b.mLivingKey = null;
        }
        PayRequest payRequest5 = this.f25518b;
        if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.mLivingResultCode)) {
            arrayList.add(new RestNameValuePair("living_result_code", this.f25518b.mLivingResultCode));
            this.f25518b.mLivingResultCode = null;
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CREDIT_PAY;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "UTF-8";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_DO_PAY;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        return true;
    }
}
