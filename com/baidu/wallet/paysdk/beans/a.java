package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
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

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25113a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25114b;

    public a(Context context) {
        super(context);
        this.f25113a = null;
        this.f25114b = null;
        this.f25113a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
        this.f25114b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(BalancePayResponse.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("bank_code", ""));
        PwdRequest pwdRequest = this.f25113a;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.f25113a.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
        } else if (!PayDataCache.getInstance().isPassFree() && this.f25114b != null && !com.baidu.wallet.paysdk.a.b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.f25114b.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                arrayList.add(new RestNameValuePair("f_token_code", SafePay.getInstance().encrypt(generateOTPKey)));
                arrayList.add(new RestNameValuePair("f_serial_num", SafePay.getInstance().encrypt(sn)));
            }
        }
        PayRequest payRequest = this.f25114b;
        if (payRequest != null && !TextUtils.isEmpty(payRequest.mSmsCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.f25114b.mSmsCode));
            this.f25114b.mSmsCode = null;
        }
        arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        PayRequest payRequest2 = this.f25114b;
        if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.withholding_auth)) {
            arrayList.add(new RestNameValuePair("need_open_authorize", this.f25114b.withholding_auth));
        }
        PayRequest payRequest3 = this.f25114b;
        if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSecurityParams)) {
            arrayList.add(new RestNameValuePair("security_sdk_param", this.f25114b.mSecurityParams));
        }
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
            arrayList.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.f25114b.getOpenPassFreeFlag())));
        }
        if (!TextUtils.isEmpty(this.f25114b.getmBankCardNumber())) {
            arrayList.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.f25114b.getmBankCardNumber())));
        }
        if (!TextUtils.isEmpty(this.f25114b.getmCvv2())) {
            arrayList.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.f25114b.getmCvv2())));
        }
        if (!TextUtils.isEmpty(this.f25114b.getmIdCard())) {
            arrayList.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.f25114b.getmIdCard())));
        }
        this.f25114b.setmBankCardNumber("");
        this.f25114b.setmCvv2("");
        this.f25114b.setmIdCard("");
        PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, this.f25114b);
        PayRequest payRequest4 = this.f25114b;
        if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mLivingKey)) {
            arrayList.add(new RestNameValuePair("living_key", this.f25114b.mLivingKey));
            this.f25114b.mLivingKey = null;
        }
        PayRequest payRequest5 = this.f25114b;
        if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.mLivingResultCode)) {
            arrayList.add(new RestNameValuePair("living_result_code", this.f25114b.mLivingResultCode));
            this.f25114b.mLivingResultCode = null;
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 14;
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
