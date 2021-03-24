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
    public DirectPayContentResponse f25501a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25502b;

    /* renamed from: c  reason: collision with root package name */
    public int f25503c;

    /* renamed from: d  reason: collision with root package name */
    public int f25504d;

    /* renamed from: e  reason: collision with root package name */
    public String f25505e;

    /* renamed from: f  reason: collision with root package name */
    public PayTypeItemView.PayTypeItemViewData f25506f;

    public c(Context context) {
        super(context);
        this.f25501a = PayDataCache.getInstance().getPayResponse();
        this.f25502b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private String b() {
        if (2 == this.f25503c) {
            return this.f25502b.getCalcPayment().getCouponJsonParams(this.f25504d, this.f25505e);
        }
        return this.f25502b.getCalcPayment().getCouponJsonParams();
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        this.f25506f = payTypeItemViewData;
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
        if (this.f25501a != null && this.f25502b != null) {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f25502b.mSpNO));
            arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
            arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
            arrayList.add(new RestNameValuePair("total_amount", this.f25502b.getOrderPrice()));
            CardData.BondCard bondCard = null;
            if (this.f25502b.hasDiscountOrCoupon()) {
                str = a();
                if (!TextUtils.isEmpty(b())) {
                    arrayList.add(new RestNameValuePair("coupon_list", b()));
                }
            } else {
                str = null;
            }
            UserData.UserModel userModel = this.f25501a.user;
            String str2 = "0";
            if (userModel != null && userModel.isSupportBalance()) {
                PayData.DirectPayPay directPayPay = this.f25501a.pay;
                if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                }
            } else {
                arrayList.add(new RestNameValuePair("balance_amount", "0"));
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f25506f;
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
                str2 = this.f25502b.getBalanceSelectStatus();
                str3 = this.f25502b.getCreditPaySelectStatus();
                bondCard = this.f25502b.mBondCard;
            }
            arrayList.add(new RestNameValuePair("need_calc_balance", str2));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("activity_list", str));
            }
            arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
            arrayList.add(new RestNameValuePair("umoney_amount", this.f25502b.getCreditTotalAmount()));
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
            }
            if (this.f25502b.getCalcPayment() != null) {
                arrayList.add(new RestNameValuePair("activity_map", this.f25502b.getCalcPayment().getDiscountMapJsonParams()));
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

    public void a(int i, int i2, String str) {
        this.f25503c = i;
        this.f25504d = i2;
        this.f25505e = str;
    }

    private String a() {
        if (1 == this.f25503c) {
            return this.f25502b.getCalcPayment().getActivitiesJsonParams(this.f25504d, this.f25505e);
        }
        return this.f25502b.getCalcPayment().getActivitiesJsonParams();
    }
}
