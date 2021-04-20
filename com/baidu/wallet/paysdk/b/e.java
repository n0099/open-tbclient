package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
public class e extends b {
    public e() {
        LogUtil.d(j.q, "init Controller : 补全不支付的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        if (strArr.length > 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                this.f25118a.a("", strArr[0]);
            } else {
                CardData.BondCard bondCard = this.f25122e.mBondCard;
                if (bondCard != null) {
                    this.f25118a.a(strArr[0], bondCard.account_no);
                } else {
                    this.f25118a.a(strArr[0], "");
                }
            }
        }
        this.f25118a.a("repair_card_info");
        super.a(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        CardData.BondCard bondCard = this.f25122e.getmBondCard();
        if (bondCard != null) {
            str2 = bondCard.true_name;
            str3 = bondCard.certificate_code;
            str = bondCard.mobile;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        if (strArr.length >= 5) {
            if (k()) {
                this.f25122e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.f25122e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.f25122e.setmName(strArr[2]);
            } else {
                this.f25122e.setmName(str2);
            }
            if (m()) {
                this.f25122e.setmIdCard(strArr[3]);
            } else {
                this.f25122e.setmIdCard(str3);
            }
            if (n()) {
                this.f25122e.setmPhone(strArr[4].replaceAll(" ", ""));
            } else {
                this.f25122e.setmPhone(str);
            }
        }
        super.b(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "");
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String p() {
        CardData.BondCard bondCard = this.f25122e.mBondCard;
        if (bondCard == null) {
            this.f25121d.finish();
            return super.p();
        }
        String last4Num = bondCard.getLast4Num();
        if (PayDataCache.getInstance().hasMobilePwd()) {
            if (this.f25122e.mBondCard.card_type == 2) {
                return this.f25122e.mBondCard.bank_name + " " + ResUtils.getString(this.f25121d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f25121d, "ebpay_last_nums") + last4Num;
            }
            return this.f25122e.mBondCard.bank_name + " " + ResUtils.getString(this.f25121d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f25121d, "ebpay_last_nums") + last4Num;
        }
        return String.format(ResUtils.getString(this.f25121d, "ebpay_hint_last4num"), last4Num);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean q() {
        return !PayDataCache.getInstance().hasMobilePwd();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.f25122e;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null && this.f25122e.getmBankInfo().channel_info.card_item_required != null) {
                this.f25123f = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.valid_code);
                this.f25124g = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.true_name);
                this.f25125h = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.i = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code);
                this.j = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
            }
            if (this.f25121d != null) {
                if (this.f25122e.getmBankInfo() != null) {
                    this.f25121d.updateBankTitleInfo(this.f25122e.getmBankInfo().card_info, true);
                } else {
                    this.f25121d.updateBankTitleInfo(null, true);
                }
                if (this.f25122e.getmBankInfo() != null) {
                    this.f25121d.updateProtocolFields(this.f25122e.getmBankInfo().protocol_info);
                } else {
                    this.f25121d.updateProtocolFields(null);
                }
                this.f25121d.updateCardElement(this.f25123f, this.f25125h, this.f25124g, this.i, this.j);
            }
        }
    }
}
