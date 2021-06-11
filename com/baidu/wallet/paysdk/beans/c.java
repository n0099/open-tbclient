package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends PayBaseBean<CalcPaymentResponse> {

    /* renamed from: a  reason: collision with root package name */
    public DirectPayContentResponse f25242a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25243b;

    /* renamed from: c  reason: collision with root package name */
    public int f25244c;

    /* renamed from: d  reason: collision with root package name */
    public int f25245d;

    /* renamed from: e  reason: collision with root package name */
    public String f25246e;

    /* renamed from: f  reason: collision with root package name */
    public PayTypeItemView.PayTypeItemViewData f25247f;

    public c(Context context) {
        super(context);
        this.f25242a = PayDataCache.getInstance().getPayResponse();
        this.f25243b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private String b() {
        if (2 == this.f25244c) {
            return this.f25243b.getCalcPayment().getCouponJsonParams(this.f25245d, this.f25246e);
        }
        return this.f25243b.getCalcPayment().getCouponJsonParams();
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        this.f25247f = payTypeItemViewData;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CalcPaymentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        String str;
        PayData.DirectPayBalance directPayBalance;
        ArrayList arrayList = new ArrayList();
        if (this.f25242a != null && this.f25243b != null) {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f25243b.mSpNO));
            arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
            arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
            arrayList.add(new RestNameValuePair("total_amount", this.f25243b.getOrderPrice()));
            CardData.BondCard bondCard = null;
            if (this.f25243b.hasDiscountOrCoupon()) {
                str = a();
                if (!TextUtils.isEmpty(b())) {
                    arrayList.add(new RestNameValuePair("coupon_list", b()));
                }
            } else {
                str = null;
            }
            UserData.UserModel userModel = this.f25242a.user;
            String str2 = "0";
            if (userModel != null && userModel.isSupportBalance()) {
                PayData.DirectPayPay directPayPay = this.f25242a.pay;
                if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                }
            } else {
                arrayList.add(new RestNameValuePair("balance_amount", "0"));
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f25247f;
            String str3 = "1";
            if (payTypeItemViewData != null) {
                PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData.type;
                if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                    str2 = "1";
                    str3 = "0";
                } else if (itemViewType != PayTypeItemView.ItemViewType.CREDIT) {
                    bondCard = payTypeItemViewData.card;
                    str3 = "0";
                }
            } else {
                str2 = this.f25243b.getBalanceSelectStatus();
                str3 = this.f25243b.getCreditPaySelectStatus();
                bondCard = this.f25243b.mBondCard;
            }
            arrayList.add(new RestNameValuePair("need_calc_balance", str2));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("activity_list", str));
            }
            arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
            arrayList.add(new RestNameValuePair("umoney_amount", this.f25243b.getCreditTotalAmount()));
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
            }
            if (this.f25243b.getCalcPayment() != null) {
                arrayList.add(new RestNameValuePair("activity_map", this.f25243b.getCalcPayment().getDiscountMapJsonParams()));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 16;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        if (com.baidu.wallet.paysdk.a.b.a()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CALC_PAYMENT;
        }
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CALC_PAYMENT;
    }

    public void a(int i2, int i3, String str) {
        this.f25244c = i2;
        this.f25245d = i3;
        this.f25246e = str;
    }

    private String a() {
        if (1 == this.f25244c) {
            return this.f25243b.getCalcPayment().getActivitiesJsonParams(this.f25245d, this.f25246e);
        }
        return this.f25243b.getCalcPayment().getActivitiesJsonParams();
    }
}
