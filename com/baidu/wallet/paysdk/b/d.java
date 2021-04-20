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
            this.f25118a.a(strArr[0], "");
        }
        this.f25118a.a("find_password");
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
                this.f25122e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.f25122e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.f25122e.setmName(strArr[2]);
            } else if (this.f25122e.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null && this.f25122e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.true_name)) {
                this.f25122e.setmName(userName);
            } else {
                this.f25122e.setmName("");
            }
            if (m()) {
                this.f25122e.setmIdCard(strArr[3]);
            } else if (this.f25122e.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null && this.f25122e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                this.f25122e.setmIdCard(userId);
            } else {
                this.f25122e.setmIdCard("");
            }
            if (TextUtils.isEmpty(strArr[4])) {
                if (this.f25122e.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null && this.f25122e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.mobile)) {
                    this.f25122e.setmPhone(str);
                } else {
                    this.f25122e.setmPhone("");
                }
            } else {
                this.f25122e.setmPhone(strArr[4].replaceAll(" ", ""));
            }
            if (m()) {
                if (this.k) {
                    this.f25122e.setCertificateType(strArr[5]);
                } else {
                    this.f25122e.setCertificateType("");
                }
            } else if (this.k) {
                this.f25122e.setCertificateType(certificateType);
            } else {
                this.f25122e.setCertificateType("");
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
        BindFastRequest bindFastRequest = this.f25122e;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null && this.f25122e.getmBankInfo().channel_info.card_item_required != null) {
                this.f25123f = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.valid_code);
                boolean z = false;
                this.f25124g = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                this.f25125h = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.i = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code);
                if ("1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z = true;
                }
                this.j = z;
                this.k = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_type);
            }
            if (this.f25121d != null) {
                if (this.f25122e.getmBankInfo() != null) {
                    this.f25121d.updateBankTitleInfo(this.f25122e.getmBankInfo().card_info, true);
                } else {
                    this.f25121d.updateBankTitleInfo(null, true);
                }
                BindFastRequest bindFastRequest2 = this.f25122e;
                if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                    this.f25121d.updateProtocolFields(this.f25122e.getmBankInfo().protocol_info);
                } else {
                    this.f25121d.updateProtocolFields(null);
                }
                this.f25121d.updateCardElement(this.f25123f, this.f25125h, this.f25124g, this.i, this.j);
            }
        }
    }
}
