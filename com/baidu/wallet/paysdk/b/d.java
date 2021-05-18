package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
public class d extends b {
    public d() {
        LogUtil.d(j.q, "init Controller : 找回密码的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean F() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        if (strArr.length > 1) {
            this.f25139a.a(strArr[0], "");
        }
        this.f25139a.a("find_password");
        super.a(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        String userName = PayDataCache.getInstance().getUserName();
        String userId = PayDataCache.getInstance().getUserId();
        String certificateType = PayDataCache.getInstance().getCertificateType();
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        String str = (userInfo == null || TextUtils.isEmpty(userInfo.mobile_number)) ? "" : userInfo.mobile_number;
        if (strArr.length >= 6) {
            if (k()) {
                this.f25143e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.f25143e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.f25143e.setmName(strArr[2]);
            } else if (this.f25143e.getmBankInfo() != null && this.f25143e.getmBankInfo().channel_info != null && this.f25143e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.true_name)) {
                this.f25143e.setmName(userName);
            } else {
                this.f25143e.setmName("");
            }
            if (m()) {
                this.f25143e.setmIdCard(strArr[3]);
            } else if (this.f25143e.getmBankInfo() != null && this.f25143e.getmBankInfo().channel_info != null && this.f25143e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                this.f25143e.setmIdCard(userId);
            } else {
                this.f25143e.setmIdCard("");
            }
            if (TextUtils.isEmpty(strArr[4])) {
                if (this.f25143e.getmBankInfo() != null && this.f25143e.getmBankInfo().channel_info != null && this.f25143e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.mobile)) {
                    this.f25143e.setmPhone(str);
                } else {
                    this.f25143e.setmPhone("");
                }
            } else {
                this.f25143e.setmPhone(strArr[4].replaceAll(" ", ""));
            }
            if (m()) {
                if (this.k) {
                    this.f25143e.setCertificateType(strArr[5]);
                } else {
                    this.f25143e.setCertificateType("");
                }
            } else if (this.k) {
                this.f25143e.setCertificateType(certificateType);
            } else {
                this.f25143e.setCertificateType("");
            }
        }
        super.b(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        return !TextUtils.isEmpty(h());
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a u() {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.f25143e;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() != null && this.f25143e.getmBankInfo().channel_info != null && this.f25143e.getmBankInfo().channel_info.card_item_required != null) {
                this.f25144f = "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.valid_code);
                boolean z = false;
                this.f25145g = "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                this.f25146h = "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.f25147i = "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.certificate_code);
                if ("1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z = true;
                }
                this.j = z;
                this.k = "1".equals(this.f25143e.getmBankInfo().channel_info.card_item_required.certificate_type);
            }
            if (this.f25142d != null) {
                if (this.f25143e.getmBankInfo() != null) {
                    this.f25142d.updateBankTitleInfo(this.f25143e.getmBankInfo().card_info, true);
                } else {
                    this.f25142d.updateBankTitleInfo(null, true);
                }
                BindFastRequest bindFastRequest2 = this.f25143e;
                if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                    this.f25142d.updateProtocolFields(this.f25143e.getmBankInfo().protocol_info);
                } else {
                    this.f25142d.updateProtocolFields(null);
                }
                this.f25142d.updateCardElement(this.f25144f, this.f25146h, this.f25145g, this.f25147i, this.j);
            }
        }
    }
}
