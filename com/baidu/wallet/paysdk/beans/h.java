package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends PayBaseBean<CheckCardInfoResponse> {

    /* renamed from: a  reason: collision with root package name */
    public static int f25511a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f25512b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f25513c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25514d;

    public <T> h(Context context) {
        super(context);
        this.f25512b = null;
        this.f25513c = null;
        this.f25514d = false;
        this.f25513c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private boolean c() {
        BindFastRequest bindFastRequest = this.f25512b;
        if (bindFastRequest != null) {
            return Constants.VIA_REPORT_TYPE_JOININ_GROUP.equals(bindFastRequest.getCardRequestType());
        }
        return false;
    }

    private boolean d() {
        int i;
        BindFastRequest bindFastRequest = this.f25512b;
        return com.baidu.wallet.paysdk.a.b.a() && (bindFastRequest != null && (6 == (i = bindFastRequest.mBindFrom) || 7 == i || 8 == i));
    }

    private List<RestNameValuePair> e() {
        String str;
        if (this.f25512b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25512b.getmBankCard())));
            if (!TextUtils.isEmpty(this.f25512b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("front_bank_code", this.f25512b.getSubBankCode()));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.f25512b.getmName()));
            }
            if (!TextUtils.isEmpty(this.f25512b.getCertificateType())) {
                arrayList.add(new RestNameValuePair("certificate_type", this.f25512b.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmIdCard())) {
                arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CETIFICATE_CODE, PayUtils.encrypt("identity_code", this.f25512b.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmPhone())) {
                arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25512b.getmPhone())));
            }
            CardData.BondCard bondCard = this.f25512b.mBondCard;
            if (bondCard != null && (str = bondCard.account_no) != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", str));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25512b.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmCvv())) {
                arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CVV2, PayUtils.encrypt("cvv2", this.f25512b.getmCvv())));
            }
            arrayList.addAll(PayDataCache.getInstance().getSessionData());
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, this.f25512b.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public void a() {
        this.f25514d = true;
    }

    public boolean b() {
        BindFastRequest bindFastRequest;
        int i;
        return this.f25514d || (bindFastRequest = this.f25512b) == null || !((i = bindFastRequest.mBindFrom) == 1 || i == 3 || i == 4 || i == 5);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(CheckCardInfoResponse.class, ErrorContentResponse.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03f1  */
    @Override // com.baidu.wallet.core.beans.NetworkBean
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<RestNameValuePair> generateRequestParam() {
        int i;
        int i2;
        PayRequest payRequest;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        ErrorContentResponse.MktSolution mktSolution;
        if (c()) {
            return e();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", "3"));
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        if (this.f25514d) {
            arrayList.add(new RestNameValuePair("request_type", "2"));
            PayRequest payRequest2 = this.f25513c;
            if (payRequest2 != null) {
                CardData.BondCard bondCard = payRequest2.mBondCard;
                arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
                arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
                if (bondCard.card_type == 1) {
                    arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", bondCard.verify_code)));
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", bondCard.valid_date)));
                }
                arrayList.add(new RestNameValuePair("true_name", bondCard.true_name));
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", bondCard.mobile)));
                if (!TextUtils.isEmpty(bondCard.certificate_code)) {
                    arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", bondCard.certificate_code)));
                    arrayList.add(new RestNameValuePair("identity_type", bondCard.certificate_type));
                }
                if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
                    arrayList.add(new RestNameValuePair("channel_no", bondCard.account_bank_code));
                }
                if (!TextUtils.isEmpty(bondCard.bank_code)) {
                    arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                }
            }
            arrayList.add(new RestNameValuePair("without_pay", "0"));
        } else {
            BindFastRequest bindFastRequest = this.f25512b;
            if (bindFastRequest == null) {
                return arrayList;
            }
            arrayList.add(new RestNameValuePair("sub_bank_code", bindFastRequest.mBankNo));
            arrayList.add(new RestNameValuePair("request_type", this.f25512b.getCardRequestType()));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25512b.getServiceType()));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25512b.getmBankCard())));
            arrayList.add(new RestNameValuePair("card_type", String.valueOf(this.f25512b.getCardType())));
            if (this.f25512b.getCardType() == 1) {
                if (!TextUtils.isEmpty(this.f25512b.getmValidDate())) {
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25512b.getmValidDate())));
                }
                if (!TextUtils.isEmpty(this.f25512b.getmCvv())) {
                    arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25512b.getmCvv())));
                }
            }
            if (!TextUtils.isEmpty(this.f25512b.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.f25512b.getmName()));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmPhone())) {
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25512b.getmPhone())));
            }
            if (!TextUtils.isEmpty(this.f25512b.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25512b.getmIdCard())));
                arrayList.add(new RestNameValuePair("identity_type", this.f25512b.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f25512b.getChannelNo())) {
                arrayList.add(new RestNameValuePair("channel_no", this.f25512b.getChannelNo()));
            }
            arrayList.add(new RestNameValuePair("without_pay", this.f25512b.getWithoutPay()));
            BindFastRequest bindFastRequest2 = this.f25512b;
            CardData.BondCard bondCard2 = bindFastRequest2.mBondCard;
            ErrorContentResponse errorContentResponse = bindFastRequest2.mCardInfoUpdateContent;
            if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_true_name)) {
                arrayList.add(new RestNameValuePair("need_true_name", bondCard2.need_true_name));
            }
            if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_identity_code)) {
                arrayList.add(new RestNameValuePair("need_identity_code", bondCard2.need_identity_code));
            }
            if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_identity_type)) {
                arrayList.add(new RestNameValuePair("need_identity_type", bondCard2.need_identity_type));
            }
            if (errorContentResponse != null && errorContentResponse.isNeedPhoneNum()) {
                arrayList.add(new RestNameValuePair("need_phone_num", errorContentResponse.need_phone_num));
            } else if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_phone_num)) {
                arrayList.add(new RestNameValuePair("need_phone_num", bondCard2.need_phone_num));
            }
            if (errorContentResponse != null && errorContentResponse.isNeedValidCode()) {
                arrayList.add(new RestNameValuePair("need_cvv2", errorContentResponse.need_cvv2));
            } else if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_cvv2)) {
                arrayList.add(new RestNameValuePair("need_cvv2", bondCard2.need_cvv2));
            }
            if (errorContentResponse != null && errorContentResponse.isNeedValidDate()) {
                arrayList.add(new RestNameValuePair("need_valid_date", errorContentResponse.need_valid_date));
            } else if (bondCard2 != null && !TextUtils.isEmpty(bondCard2.need_valid_date)) {
                arrayList.add(new RestNameValuePair("need_valid_date", bondCard2.need_valid_date));
            }
            BindFastRequest bindFastRequest3 = this.f25512b;
            if (bindFastRequest3 != null && !TextUtils.isEmpty(bindFastRequest3.mBankNo)) {
                arrayList.add(new RestNameValuePair("easypay_channel", this.f25512b.mBankNo));
            }
            if (bondCard2 != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", bondCard2.account_no));
            }
            if (d()) {
                com.baidu.wallet.paysdk.a.b.a(arrayList);
            }
        }
        if (b()) {
            PayRequest payRequest3 = this.f25513c;
            if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mOrderNo)) {
                arrayList.add(new RestNameValuePair("order_no", this.f25513c.mOrderNo));
            }
            PayRequest payRequest4 = this.f25513c;
            if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mSpNO)) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25513c.mSpNO));
            }
            PayRequest payRequest5 = this.f25513c;
            if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.getOrderPrice())) {
                arrayList.add(new RestNameValuePair("total_amount", this.f25513c.getOrderPrice()));
            }
            PayRequest payRequest6 = this.f25513c;
            if (payRequest6 != null && payRequest6.isPayByMktSolution && (mktSolution = payRequest6.mMktSolution) != null) {
                if (!TextUtils.isEmpty(mktSolution.easypay_amount)) {
                    arrayList.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25513c.mMktSolution.easypay_amount));
                }
                if (this.f25513c.getCalcPayment() != null) {
                    String selectedDiscountIds = this.f25513c.getCalcPayment().getSelectedDiscountIds(this.f25513c.mMktSolution.activity_list);
                    if (!TextUtils.isEmpty(selectedDiscountIds)) {
                        arrayList.add(new RestNameValuePair("activity_id", selectedDiscountIds));
                        i = 2;
                        if (this.f25513c.getCalcPayment() != null) {
                            String selectedCouponIds = this.f25513c.getCalcPayment().getSelectedCouponIds(this.f25513c.mMktSolution.coupon_list);
                            if (!TextUtils.isEmpty(selectedCouponIds)) {
                                i++;
                                arrayList.add(new RestNameValuePair("coupon_id", selectedCouponIds));
                            }
                        }
                    }
                }
                i = 1;
                if (this.f25513c.getCalcPayment() != null) {
                }
            } else {
                StringBuilder sb = new StringBuilder();
                if (this.f25514d && (payRequest = this.f25513c) != null) {
                    r7 = payRequest.getCalcPayment() != null ? this.f25513c.getCalcPayment() : null;
                    arrayList.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25513c.getEasyPayAmount()));
                } else {
                    BindFastRequest bindFastRequest4 = this.f25512b;
                    if (bindFastRequest4 != null && bindFastRequest4.mBindFrom == 0) {
                        r7 = bindFastRequest4.getCalcPaymentResponse();
                        arrayList.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25512b.getEasyPayAmount()));
                    } else {
                        PayRequest payRequest7 = this.f25513c;
                        if (payRequest7 != null) {
                            r7 = payRequest7.getCalcPayment() != null ? this.f25513c.getCalcPayment() : null;
                            arrayList.add(new RestNameValuePair(BaiduPay.AMOUNT, this.f25513c.getEasyPayAmount()));
                        }
                    }
                }
                if (r7 != null) {
                    if (TextUtils.isEmpty(r7.getSelectedDiscountIds())) {
                        i2 = 1;
                    } else {
                        sb.append(r7.getSelectedDiscountIds());
                        i2 = 2;
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        arrayList.add(new RestNameValuePair("activity_id", sb.toString()));
                    }
                    if (TextUtils.isEmpty(r7.getSelectedCouponIds())) {
                        i = i2;
                    } else {
                        arrayList.add(new RestNameValuePair("coupon_id", r7.getSelectedCouponIds()));
                        i = i2 + 1;
                    }
                } else {
                    i = 1;
                }
            }
            if (i >= 2) {
                arrayList.add(new RestNameValuePair("composite_flag", "1"));
            } else {
                arrayList.add(new RestNameValuePair("composite_flag", "0"));
            }
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
                String hdTag = easyPay.getHdTag();
                if (!TextUtils.isEmpty(hdTag)) {
                    arrayList.add(new RestNameValuePair("hd_tag", hdTag));
                }
            }
        }
        BindFastRequest bindFastRequest5 = this.f25512b;
        if (bindFastRequest5 != null && bindFastRequest5.getmBindFrom() == 1) {
            PayRequest payRequest8 = this.f25513c;
            if (payRequest8 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest8.getPayFrom())) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25513c.mSpNO));
                if (!TextUtils.isEmpty(this.f25513c.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", this.f25513c.mOrderNo));
                }
            } else if (!TextUtils.isEmpty(this.f25512b.getSp_no())) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25512b.getSp_no()));
            }
        }
        BindFastRequest bindFastRequest6 = this.f25512b;
        if (bindFastRequest6 != null) {
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, bindFastRequest6.getSessionId()));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 5;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "UTF-8";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        f25511a = -1;
        if (c()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_VERIFY_CARDCHECK;
        } else if (d()) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CARD_CHECK;
        } else {
            f25511a = 1;
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CHECK_CARD_INFO;
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25512b = bindFastRequest;
    }
}
