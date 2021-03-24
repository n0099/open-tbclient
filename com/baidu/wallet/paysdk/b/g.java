package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
public class g extends b {
    public g() {
        LogUtil.d(j.q, "init Controller : 补全支付的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean E() {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            BindFastRequest bindFastRequest = this.f25436e;
            if (bindFastRequest.mBondCard != null) {
                ErrorContentResponse errorContentResponse = bindFastRequest.mCardInfoUpdateContent;
                if (errorContentResponse != null && !TextUtils.isEmpty(errorContentResponse.need_send_sms)) {
                    return this.f25436e.mCardInfoUpdateContent.isNeedSendSms();
                }
                return this.f25436e.mBondCard.isNeedSendSms();
            }
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        if (strArr.length > 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                this.f25432a.a("", strArr[0]);
            } else {
                CardData.BondCard bondCard = this.f25436e.mBondCard;
                if (bondCard != null) {
                    this.f25432a.a(strArr[0], bondCard.account_no);
                } else {
                    this.f25432a.a(strArr[0], "");
                }
            }
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
            this.f25432a.a(easyPay.getService());
        }
        super.a(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        CardData.BondCard bondCard = this.f25436e.getmBondCard();
        if (s()) {
            Boolean valueOf = Boolean.valueOf(bondCard != null && PayDataCache.getInstance().hasMobilePwd());
            if (valueOf.booleanValue()) {
                this.f25436e.setmBankCard(bondCard.account_no);
                this.f25436e.setBankType(bondCard.card_type);
            }
            if (bondCard != null && !TextUtils.isEmpty(bondCard.bank_code)) {
                this.f25436e.mBankNo = bondCard.bank_code;
            }
            str2 = (valueOf.booleanValue() && bondCard.hasName()) ? bondCard.true_name : "";
            str3 = (valueOf.booleanValue() && bondCard.hasId()) ? bondCard.certificate_code : "";
            if (bondCard != null && !TextUtils.isEmpty(bondCard.account_bank_code)) {
                this.f25436e.setChannelNo(bondCard.account_bank_code);
            }
            str4 = (!this.n && valueOf.booleanValue() && bondCard.hasMobile()) ? bondCard.mobile : "";
            str5 = (!this.m && valueOf.booleanValue() && bondCard.hasCvv()) ? bondCard.verify_code : "";
            str = (!this.l && valueOf.booleanValue() && bondCard.hasDate()) ? bondCard.valid_date : "";
        } else {
            if (5 <= strArr.length && TextUtils.isDigitsOnly(strArr[4])) {
                str4 = strArr[4];
            } else if (bondCard != null) {
                str4 = bondCard.mobile;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            str = "";
            str2 = str;
            str3 = str2;
            str5 = str3;
        }
        if (strArr.length >= 6) {
            if (k()) {
                this.f25436e.setmCvv(strArr[0]);
            } else if (!TextUtils.isEmpty(str5)) {
                this.f25436e.setmCvv(str5);
            }
            if (l()) {
                this.f25436e.setmValidDate(strArr[1].replaceAll("/", ""));
            } else if (!TextUtils.isEmpty(str)) {
                this.f25436e.setmValidDate(str);
            }
            if (j()) {
                this.f25436e.setmName(strArr[2]);
            } else if (!TextUtils.isEmpty(str2)) {
                this.f25436e.setmName(str2);
            }
            if (m()) {
                this.f25436e.setmIdCard(strArr[3]);
            } else if (!TextUtils.isEmpty(str3)) {
                this.f25436e.setmIdCard(str3);
            }
            if (n()) {
                this.f25436e.setmPhone(strArr[4].replaceAll(" ", ""));
            } else if (!TextUtils.isEmpty(str4)) {
                this.f25436e.setmPhone(str4);
            }
            if (!this.k && TextUtils.isEmpty(strArr[5])) {
                this.f25436e.setCertificateType("");
            } else {
                this.f25436e.setCertificateType(strArr[5]);
            }
        }
        super.b(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        CardData.BondCard bondCard = this.f25436e.mBondCard;
        if (bondCard == null || !"1".equals(bondCard.need_true_name)) {
            return !TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "");
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String p() {
        CardData.BondCard bondCard = this.f25436e.mBondCard;
        if (bondCard == null) {
            this.f25435d.finish();
            return super.p();
        }
        String last4Num = bondCard.getLast4Num();
        if (s()) {
            if (this.f25436e.mBondCard.card_type == 2) {
                return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
            }
            return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
        } else if (PayDataCache.getInstance().hasMobilePwd()) {
            if (this.f25436e.mBondCard.card_type == 2) {
                return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
            }
            return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
        } else if (this.f25436e.mBondCard.card_type == 2) {
            return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
        } else {
            return this.f25436e.mBondCard.bank_name + " " + ResUtils.getString(this.f25435d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f25435d, "ebpay_last_nums") + last4Num;
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean q() {
        return (s() || PayDataCache.getInstance().hasMobilePwd()) ? false : true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean t() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        BindFastRequest bindFastRequest = this.f25436e;
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = null;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() != null && this.f25436e.getmBankInfo().channel_info != null) {
                certificateTypeInfoArr2 = this.f25436e.getmBankInfo().channel_info.certificate_type_info;
            } else {
                ErrorContentResponse errorContentResponse = this.f25436e.mCardInfoUpdateContent;
                if (errorContentResponse == null || (certificateTypeInfoArr = errorContentResponse.certificate_type_info) == null) {
                    if (this.f25436e.getmBondCard() != null) {
                        certificateTypeInfoArr = this.f25436e.getmBondCard().certificate_type_info;
                    }
                }
                certificateTypeInfoArr2 = certificateTypeInfoArr;
            }
        }
        if (certificateTypeInfoArr2 == null || certificateTypeInfoArr2.length == 0) {
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = new GetCardInfoResponse.CertificateTypeInfo();
            certificateTypeInfo.type = "1";
            certificateTypeInfo.description = ResUtils.getString(this.f25435d, "ebpay_certificate");
            return new GetCardInfoResponse.CertificateTypeInfo[]{certificateTypeInfo};
        }
        return certificateTypeInfoArr2;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.f25436e;
        if (bindFastRequest != null) {
            boolean z = false;
            if (bindFastRequest.getmBankInfo() != null && this.f25436e.getmBankInfo().channel_info != null && this.f25436e.getmBankInfo().channel_info.card_item_required != null) {
                this.f25437f = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.valid_code);
                this.f25438g = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.true_name);
                this.f25439h = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.i = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.certificate_code);
                this.j = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                this.k = "1".equals(this.f25436e.getmBankInfo().channel_info.card_item_required.certificate_type);
            } else {
                CardData.BondCard bondCard = this.f25436e.mBondCard;
                if (bondCard != null) {
                    this.f25437f = !bondCard.hasCvv();
                    this.f25438g = !this.f25436e.mBondCard.hasName();
                    this.f25439h = !this.f25436e.mBondCard.hasDate();
                    this.i = !this.f25436e.mBondCard.hasId();
                    this.j = !this.f25436e.mBondCard.hasMobile();
                    this.k = !this.f25436e.mBondCard.hasIdType();
                }
            }
            if (this.f25436e.getmBondCard() != null) {
                this.f25437f = this.f25437f || "1".equals(this.f25436e.getmBondCard().need_cvv2);
                this.f25439h = (this.f25439h || "1".equals(this.f25436e.getmBondCard().need_valid_date)) ? true : true;
            }
        }
        if (this.f25435d != null) {
            if (q()) {
                if (this.f25436e.getmBankInfo() != null) {
                    this.f25435d.updateBankTitleInfo(this.f25436e.getmBankInfo().card_info, true);
                } else {
                    this.f25435d.updateBankTitleInfo(null, true);
                }
            } else {
                this.f25435d.updateBankTitleInfo(null, true);
            }
            this.f25435d.updateCardElement(this.f25437f, this.f25439h, this.f25438g, this.i, this.j);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String[] a(int i) {
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.f25435d, "ebpay_title_complete_info_for_pay");
        if (i == 0) {
            string = ResUtils.getString(this.f25435d, "ebpay_title_complete_info_for_pay");
        } else if (i == 1) {
            string = ResUtils.getString(this.f25435d, "ebpay_title_complete_info_for_pay");
        }
        String string2 = ResUtils.getString(this.f25435d, "ebpay_pay_checkcard");
        if (i == 0) {
            string2 = ResUtils.getString(this.f25435d, "ebpay_pay_checkcard");
        } else if (i == 1) {
            string2 = ResUtils.getString(this.f25435d, "ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }
}
