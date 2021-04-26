package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
public class a extends b {
    public a() {
        LogUtil.d(j.q, "init Controller : 主动绑卡的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        if (strArr.length > 1) {
            this.f25894a.a(strArr[0], "");
        }
        this.f25894a.a(QueryResponse.Options.BIND_CARD);
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
                this.f25898e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.f25898e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.f25898e.setmName(strArr[2]);
            } else if (this.f25898e.getmBankInfo() != null && this.f25898e.getmBankInfo().channel_info != null && this.f25898e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.true_name)) {
                this.f25898e.setmName(userName);
            } else {
                this.f25898e.setmName("");
            }
            if (m()) {
                this.f25898e.setmIdCard(strArr[3]);
            } else if (this.f25898e.getmBankInfo() != null && this.f25898e.getmBankInfo().channel_info != null && this.f25898e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                this.f25898e.setmIdCard(userId);
            } else {
                this.f25898e.setmIdCard("");
            }
            if (TextUtils.isEmpty(strArr[4])) {
                if (this.f25898e.getmBankInfo() != null && this.f25898e.getmBankInfo().channel_info != null && this.f25898e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.mobile)) {
                    this.f25898e.setmPhone(str);
                } else {
                    this.f25898e.setmPhone("");
                }
            } else {
                this.f25898e.setmPhone(strArr[4].replaceAll(" ", ""));
            }
            if (m()) {
                if (this.k) {
                    this.f25898e.setCertificateType(strArr[5]);
                } else {
                    this.f25898e.setCertificateType("");
                }
            } else if (this.k) {
                this.f25898e.setCertificateType(certificateType);
            } else {
                this.f25898e.setCertificateType("");
            }
        }
        super.b(strArr);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean b() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String c() {
        BindFastRequest bindFastRequest = this.f25898e;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f25898e.getmBankInfo().getOneCentsDesc())) {
            return this.f25898e.getmBankInfo().getOneCentsDesc();
        }
        return super.c();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.f25898e;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f25898e.getmBankInfo().channel_info != null && this.f25898e.getmBankInfo().channel_info.card_item_required != null) {
            this.f25899f = "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.valid_code);
            boolean z = false;
            this.f25900g = "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
            this.f25901h = "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.valid_date);
            this.f25902i = ("1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
            if ("1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                z = true;
            }
            this.j = z;
            this.k = "1".equals(this.f25898e.getmBankInfo().channel_info.card_item_required.certificate_type);
        }
        if (this.f25897d != null) {
            BindFastRequest bindFastRequest2 = this.f25898e;
            if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                this.f25897d.updateBankTitleInfo(this.f25898e.getmBankInfo().card_info, true);
            } else {
                this.f25897d.updateBankTitleInfo(null, true);
            }
            BindFastRequest bindFastRequest3 = this.f25898e;
            if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
                this.f25897d.updateProtocolFields(this.f25898e.getmBankInfo().protocol_info);
            } else {
                this.f25897d.updateProtocolFields(null);
            }
            this.f25897d.updateCardElement(this.f25899f, this.f25901h, this.f25900g, this.f25902i, this.j);
        }
    }
}
