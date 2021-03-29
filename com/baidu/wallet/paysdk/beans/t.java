package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class t extends PayBaseBean<GetCardInfoResponse> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f25527a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f25528b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f25529c;

    /* renamed from: d  reason: collision with root package name */
    public String f25530d;

    /* renamed from: e  reason: collision with root package name */
    public String f25531e;

    /* renamed from: f  reason: collision with root package name */
    public String f25532f;

    /* renamed from: g  reason: collision with root package name */
    public DirectPayContentResponse f25533g;

    public <T> t(Context context) {
        super(context);
        this.f25528b = null;
        this.f25529c = null;
        this.f25530d = "";
        this.f25531e = "";
        this.f25532f = "";
        this.f25527a = true;
        this.f25533g = PayDataCache.getInstance().getPayResponse();
        this.f25529c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private boolean b() {
        BindFastRequest bindFastRequest = this.f25528b;
        if (bindFastRequest != null) {
            return Constants.VIA_REPORT_TYPE_JOININ_GROUP.equals(bindFastRequest.getCardRequestType());
        }
        return false;
    }

    private List<RestNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("request_type", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25530d)));
        if (!TextUtils.isEmpty(this.f25528b.getSubBankCode())) {
            arrayList.add(new RestNameValuePair("front_bank_code", this.f25528b.getSubBankCode()));
        }
        if (!TextUtils.isEmpty(this.f25531e)) {
            arrayList.add(new RestNameValuePair("card_no_bind", this.f25531e));
        }
        arrayList.addAll(PayDataCache.getInstance().getSessionData());
        return arrayList;
    }

    public void a(String str, String str2) {
        this.f25530d = str;
        this.f25531e = str2;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(GetCardInfoResponse.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayBalance directPayBalance;
        if (b()) {
            return c();
        }
        if (this.f25528b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", this.f25528b.getCardRequestType()));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25528b.getServiceType()));
            arrayList.add(new RestNameValuePair("service", this.f25532f));
            if (!TextUtils.isEmpty(this.f25530d)) {
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25530d)));
            }
            if (this.f25528b.getmBondCard() != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", this.f25528b.getmBondCard().account_no));
            }
            PayRequest payRequest = this.f25529c;
            if (payRequest != null && this.f25527a) {
                arrayList.add(new RestNameValuePair("is_transfer", payRequest.isTransfer()));
            } else {
                if (!this.f25527a) {
                    this.f25527a = true;
                }
                arrayList.add(new RestNameValuePair("is_transfer", "0"));
            }
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            if (this.f25528b.getmBindFrom() != 0 && this.f25528b.getmBindFrom() != 2 && !a()) {
                if (this.f25528b.getmBindFrom() == 1) {
                    PayRequest payRequest2 = this.f25529c;
                    if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                        arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25529c.mSpNO));
                        if (!TextUtils.isEmpty(this.f25529c.mOrderNo)) {
                            arrayList.add(new RestNameValuePair("order_no", this.f25529c.mOrderNo));
                        }
                    } else if (!TextUtils.isEmpty(this.f25528b.getSp_no())) {
                        arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25528b.getSp_no()));
                    }
                }
            } else {
                if (a()) {
                    com.baidu.wallet.paysdk.a.b.a(arrayList);
                }
                PayRequest payRequest3 = this.f25529c;
                if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSpNO)) {
                    arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f25529c.mSpNO));
                    arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25529c.mSpNO));
                }
                PayRequest payRequest4 = this.f25529c;
                if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", this.f25529c.mOrderNo));
                }
                if (!TextUtils.isEmpty(PayDataCache.getInstance().getInsideTransOrder())) {
                    arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                }
                if (!TextUtils.isEmpty(PayDataCache.getInstance().getSellerUserId())) {
                    arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                }
                PayRequest payRequest5 = this.f25529c;
                if (payRequest5 != null) {
                    arrayList.add(new RestNameValuePair("total_amount", payRequest5.getOrderPrice()));
                    arrayList.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25529c.getEasyPayAmount()));
                    if (this.f25528b.getmBindFrom() == 0) {
                        arrayList.add(new RestNameValuePair("need_calc_balance", "0"));
                        UserData.UserModel userModel = this.f25533g.user;
                        if (userModel != null && userModel.isSupportBalance()) {
                            PayData.DirectPayPay directPayPay = this.f25533g.pay;
                            if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                                arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                            }
                        } else {
                            arrayList.add(new RestNameValuePair("balance_amount", "0"));
                        }
                        arrayList.add(new RestNameValuePair("need_calc_umoney", "0"));
                        arrayList.add(new RestNameValuePair("umoney_amount", this.f25529c.getCreditTotalAmount()));
                        if (this.f25529c.hasDiscountOrCoupon()) {
                            String activitiesJsonParams = this.f25529c.getCalcPayment().getActivitiesJsonParams();
                            String couponJsonParams = this.f25529c.getCalcPayment().getCouponJsonParams();
                            if (!TextUtils.isEmpty(couponJsonParams)) {
                                arrayList.add(new RestNameValuePair("coupon_list", couponJsonParams));
                            }
                            if (!TextUtils.isEmpty(activitiesJsonParams)) {
                                arrayList.add(new RestNameValuePair("activity_list", activitiesJsonParams));
                            }
                        }
                    }
                }
                CardData.BondCard bondCard = this.f25528b.mBondCard;
                if (bondCard != null) {
                    arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                }
            }
            if (!TextUtils.isEmpty(this.f25528b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.f25528b.getSubBankCode()));
            }
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, this.f25528b.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 4;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        if (b()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_VERIFY_CARDINFO;
        } else if (a()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CARD_INFO;
        } else {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_GET_CARD_INFO;
        }
    }

    public void a(String str) {
        this.f25532f = str;
    }

    private boolean a() {
        int i;
        BindFastRequest bindFastRequest = this.f25528b;
        return com.baidu.wallet.paysdk.a.b.a() && (bindFastRequest != null && (6 == (i = bindFastRequest.mBindFrom) || 7 == i || 8 == i));
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25528b = bindFastRequest;
    }
}
