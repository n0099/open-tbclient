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
    public DirectPayContentResponse f25210a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25211b;

    /* renamed from: c  reason: collision with root package name */
    public int f25212c;

    /* renamed from: d  reason: collision with root package name */
    public int f25213d;

    /* renamed from: e  reason: collision with root package name */
    public String f25214e;

    /* renamed from: f  reason: collision with root package name */
    public PayTypeItemView.PayTypeItemViewData f25215f;

    public c(Context context) {
        super(context);
        this.f25210a = PayDataCache.getInstance().getPayResponse();
        this.f25211b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private String b() {
        if (2 == this.f25212c) {
            return this.f25211b.getCalcPayment().getCouponJsonParams(this.f25213d, this.f25214e);
        }
        return this.f25211b.getCalcPayment().getCouponJsonParams();
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        this.f25215f = payTypeItemViewData;
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
        if (this.f25210a != null && this.f25211b != null) {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f25211b.mSpNO));
            arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
            arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
            arrayList.add(new RestNameValuePair("total_amount", this.f25211b.getOrderPrice()));
            CardData.BondCard bondCard = null;
            if (this.f25211b.hasDiscountOrCoupon()) {
                str = a();
                if (!TextUtils.isEmpty(b())) {
                    arrayList.add(new RestNameValuePair("coupon_list", b()));
                }
            } else {
                str = null;
            }
            UserData.UserModel userModel = this.f25210a.user;
            String str2 = "0";
            if (userModel != null && userModel.isSupportBalance()) {
                PayData.DirectPayPay directPayPay = this.f25210a.pay;
                if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                }
            } else {
                arrayList.add(new RestNameValuePair("balance_amount", "0"));
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f25215f;
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
                str2 = this.f25211b.getBalanceSelectStatus();
                str3 = this.f25211b.getCreditPaySelectStatus();
                bondCard = this.f25211b.mBondCard;
            }
            arrayList.add(new RestNameValuePair("need_calc_balance", str2));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("activity_list", str));
            }
            arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
            arrayList.add(new RestNameValuePair("umoney_amount", this.f25211b.getCreditTotalAmount()));
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
            }
            if (this.f25211b.getCalcPayment() != null) {
                arrayList.add(new RestNameValuePair("activity_map", this.f25211b.getCalcPayment().getDiscountMapJsonParams()));
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
        this.f25212c = i2;
        this.f25213d = i3;
        this.f25214e = str;
    }

    private String a() {
        if (1 == this.f25212c) {
            return this.f25211b.getCalcPayment().getActivitiesJsonParams(this.f25213d, this.f25214e);
        }
        return this.f25211b.getCalcPayment().getActivitiesJsonParams();
    }
}
