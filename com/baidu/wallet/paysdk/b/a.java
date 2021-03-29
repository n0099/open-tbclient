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
            this.f25433a.a(strArr[0], "");
        }
        this.f25433a.a(QueryResponse.Options.BIND_CARD);
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
                this.f25437e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.f25437e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.f25437e.setmName(strArr[2]);
            } else if (this.f25437e.getmBankInfo() != null && this.f25437e.getmBankInfo().channel_info != null && this.f25437e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.true_name)) {
                this.f25437e.setmName(userName);
            } else {
                this.f25437e.setmName("");
            }
            if (m()) {
                this.f25437e.setmIdCard(strArr[3]);
            } else if (this.f25437e.getmBankInfo() != null && this.f25437e.getmBankInfo().channel_info != null && this.f25437e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                this.f25437e.setmIdCard(userId);
            } else {
                this.f25437e.setmIdCard("");
            }
            if (TextUtils.isEmpty(strArr[4])) {
                if (this.f25437e.getmBankInfo() != null && this.f25437e.getmBankInfo().channel_info != null && this.f25437e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.mobile)) {
                    this.f25437e.setmPhone(str);
                } else {
                    this.f25437e.setmPhone("");
                }
            } else {
                this.f25437e.setmPhone(strArr[4].replaceAll(" ", ""));
            }
            if (m()) {
                if (this.k) {
                    this.f25437e.setCertificateType(strArr[5]);
                } else {
                    this.f25437e.setCertificateType("");
                }
            } else if (this.k) {
                this.f25437e.setCertificateType(certificateType);
            } else {
                this.f25437e.setCertificateType("");
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
        BindFastRequest bindFastRequest = this.f25437e;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f25437e.getmBankInfo().getOneCentsDesc())) {
            return this.f25437e.getmBankInfo().getOneCentsDesc();
        }
        return super.c();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.f25437e;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f25437e.getmBankInfo().channel_info != null && this.f25437e.getmBankInfo().channel_info.card_item_required != null) {
            this.f25438f = "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.valid_code);
            boolean z = false;
            this.f25439g = "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
            this.f25440h = "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.valid_date);
            this.i = ("1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
            if ("1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                z = true;
            }
            this.j = z;
            this.k = "1".equals(this.f25437e.getmBankInfo().channel_info.card_item_required.certificate_type);
        }
        if (this.f25436d != null) {
            BindFastRequest bindFastRequest2 = this.f25437e;
            if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                this.f25436d.updateBankTitleInfo(this.f25437e.getmBankInfo().card_info, true);
            } else {
                this.f25436d.updateBankTitleInfo(null, true);
            }
            BindFastRequest bindFastRequest3 = this.f25437e;
            if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
                this.f25436d.updateProtocolFields(this.f25437e.getmBankInfo().protocol_info);
            } else {
                this.f25436d.updateProtocolFields(null);
            }
            this.f25436d.updateCardElement(this.f25438f, this.f25440h, this.f25439g, this.i, this.j);
        }
    }
}
