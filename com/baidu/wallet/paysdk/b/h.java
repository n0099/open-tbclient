package com.baidu.wallet.paysdk.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class h extends b {
    public PayRequest r = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);

    public h() {
        LogUtil.d(j.q, "init Controller : 绑卡支付的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean C() {
        return !d();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String D() {
        return (com.baidu.wallet.paysdk.a.b.c() || !d()) ? "" : ResUtils.getString(this.f25121d, "wallet_bindcard_addnewcard_tip");
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        BindFastRequest bindFastRequest = this.f25122e;
        if (bindFastRequest != null) {
            bindFastRequest.setCalcPaymentResponse(null);
        }
        if (strArr.length > 1) {
            this.f25118a.a(strArr[0], "");
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
            this.f25118a.a(easyPay.getService());
        }
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
    public String c() {
        BindFastRequest bindFastRequest = this.f25122e;
        if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f25122e.getmBankInfo().getOneCentsDesc())) {
            return this.f25122e.getmBankInfo().getOneCentsDesc();
        }
        return super.c();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean d() {
        if (i()) {
            return false;
        }
        if (this.f25122e.getmBindFrom() == 6 && com.baidu.wallet.paysdk.a.b.c() && !PayDataCache.getInstance().hasBondCards()) {
            return true;
        }
        if (this.f25122e.getmBindFrom() != 0 || PayDataCache.getInstance().hasMobilePwd() || PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length > 0) {
            return super.d();
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean e() {
        PayRequest payRequest = this.r;
        if (payRequest == null || !payRequest.showCouponListEntry()) {
            return super.e();
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean i() {
        if (!com.baidu.wallet.paysdk.a.b.b() || PayDataCache.getInstance().hasBondCards()) {
            return super.i();
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void o() {
        PayRequest payRequest = this.r;
        if (payRequest == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = this.r.getOrderPrice();
        String discountAmount = this.r.getDiscountAmount();
        String randomDiscountMsg = this.r.getRandomDiscountMsg();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(this.f25121d, "wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(this.f25121d, "wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (z) {
            this.f25121d.updateDiscountTxt(this.r.getGoodsName(), spannableString, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
        } else if (this.r.showCouponListEntry()) {
            this.f25121d.updateDiscountTxt(this.r.getGoodsName(), null, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
        } else {
            this.f25121d.updateDiscountTxt(this.r.getGoodsName(), null, randomDiscountMsg, null, StringUtils.fen2Yuan(needToPayAmount));
        }
        this.f25121d.updateDiscountTitle(this.r.title_url);
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
                this.i = ("1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
                if ("1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z = true;
                }
                this.j = z;
                this.k = "1".equals(this.f25122e.getmBankInfo().channel_info.card_item_required.certificate_type);
            }
            BindFastRequest bindFastRequest2 = this.f25122e;
            if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null && this.f25122e.getmBankInfo().channel_info != null) {
                BindFastRequest bindFastRequest3 = this.f25122e;
                bindFastRequest3.setCalcPaymentResponse(bindFastRequest3.getmBankInfo().channel_info.mkt_info);
            } else {
                this.f25122e.setCalcPaymentResponse(null);
            }
            if (this.f25121d != null) {
                if (this.f25122e.getmBankInfo() != null) {
                    this.f25121d.updateBankCouponDesc(this.f25122e.getmBankInfo().getCardInfoCouponDesc());
                    this.f25121d.updateBankTitleInfo(this.f25122e.getmBankInfo().card_info, true);
                } else {
                    this.f25121d.updateBankTitleInfo(null, true);
                    this.f25121d.updateBankCouponDesc("");
                }
                BindFastRequest bindFastRequest4 = this.f25122e;
                if (bindFastRequest4 != null && bindFastRequest4.getmBankInfo() != null) {
                    this.f25121d.updateProtocolFields(this.f25122e.getmBankInfo().protocol_info);
                } else {
                    this.f25121d.updateProtocolFields(null);
                }
                this.f25121d.updateCardElement(this.f25123f, this.f25125h, this.f25124g, this.i, this.j);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean b() {
        return (d() || i()) ? false : true;
    }

    private String[] b(int i) {
        Authorize authorize;
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.f25121d, "bd_wallet_withhold_title");
        if (i == 0) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null && (authorize = payResponse.authorize) != null && !TextUtils.isEmpty(authorize.top_title)) {
                string = payResponse.authorize.top_title;
            } else {
                string = ResUtils.getString(this.f25121d, "bd_wallet_withhold_title");
            }
        } else if (i == 1) {
            string = ResUtils.getString(this.f25121d, "bd_wallet_bind_card_second");
        }
        String string2 = ResUtils.getString(this.f25121d, "ebpay_pay_checkcard");
        if (i == 0) {
            string2 = ResUtils.getString(this.f25121d, "ebpay_pay_checkcard");
        } else if (i == 1) {
            string2 = ResUtils.getString(this.f25121d, "ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String[] a(int i) {
        if (com.baidu.wallet.paysdk.a.b.a() && (PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length <= 0)) {
            return b(i);
        }
        if (!PayDataCache.getInstance().hasMobilePwd() && PayDataCache.getInstance().getBondCards() != null && PayDataCache.getInstance().getBondCards().length <= 0) {
            String[] strArr = new String[2];
            String string = ResUtils.getString(this.f25121d, "bd_wallet_bind_card_first_pay");
            if (i == 0) {
                string = ResUtils.getString(this.f25121d, "bd_wallet_bind_card_first_pay");
            } else if (i == 1) {
                string = ResUtils.getString(this.f25121d, "bd_wallet_bind_card_second");
            }
            String string2 = ResUtils.getString(this.f25121d, "ebpay_pay_checkcard");
            if (i == 0) {
                string2 = ResUtils.getString(this.f25121d, "ebpay_pay_checkcard");
            } else if (i == 1) {
                string2 = ResUtils.getString(this.f25121d, "ebpay_pay_next");
            }
            strArr[0] = string;
            strArr[1] = string2;
            return strArr;
        }
        return super.a(i);
    }
}
