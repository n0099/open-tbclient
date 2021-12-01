package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class g extends BaseBean<CheckCardInfoResponse> {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f53410b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f53411c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53412d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> g(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53410b = null;
        this.f53411c = null;
        this.f53412d = false;
        this.f53411c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            BindFastRequest bindFastRequest = this.f53410b;
            if (bindFastRequest != null) {
                return "13".equals(bindFastRequest.getCardRequestType());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            BindFastRequest bindFastRequest = this.f53410b;
            return com.baidu.wallet.paysdk.a.b.a() && (bindFastRequest != null && (6 == (i2 = bindFastRequest.mBindFrom) || 7 == i2 || 8 == i2));
        }
        return invokeV.booleanValue;
    }

    private List<RestNameValuePair> e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f53410b != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("request_type", "13"));
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f53410b.getmBankCard())));
                if (!TextUtils.isEmpty(this.f53410b.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("front_bank_code", this.f53410b.getSubBankCode()));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmName())) {
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.f53410b.getmName()));
                }
                if (!TextUtils.isEmpty(this.f53410b.getCertificateType())) {
                    arrayList.add(new RestNameValuePair("certificate_type", this.f53410b.getCertificateType()));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmIdCard())) {
                    arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CETIFICATE_CODE, PayUtils.encrypt("identity_code", this.f53410b.getmIdCard())));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmPhone())) {
                    arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f53410b.getmPhone())));
                }
                CardData.BondCard bondCard = this.f53410b.mBondCard;
                if (bondCard != null && (str = bondCard.account_no) != null) {
                    arrayList.add(new RestNameValuePair("card_no_bind", str));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmValidDate())) {
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f53410b.getmValidDate())));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmCvv())) {
                    arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CVV2, PayUtils.encrypt("cvv2", this.f53410b.getmCvv())));
                }
                arrayList.addAll(PayDataCache.getInstance().getSessionData());
                arrayList.add(new RestNameValuePair("session_id", this.f53410b.getSessionId()));
                return arrayList;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f53412d = true;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        BindFastRequest bindFastRequest;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53412d || (bindFastRequest = this.f53410b) == null || !((i2 = bindFastRequest.mBindFrom) == 1 || i2 == 3 || i2 == 4 || i2 == 5) : invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.execBean(CheckCardInfoResponse.class, ErrorContentResponse.class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0417  */
    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        int i2;
        int i3;
        PayRequest payRequest;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        ErrorContentResponse.MktSolution mktSolution;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (c()) {
                return e();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
                arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
            }
            if (this.f53412d) {
                arrayList.add(new RestNameValuePair("request_type", "2"));
                PayRequest payRequest2 = this.f53411c;
                if (payRequest2 != null) {
                    CardData.BondCard bondCard = payRequest2.mBondCard;
                    arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
                    arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
                    arrayList.add(new RestNameValuePair("card_type", String.valueOf(bondCard.card_type)));
                    StatHelper.cacheBankCode(bondCard.bank_code);
                    StatHelper.cacheCardType(String.valueOf(bondCard.card_type));
                    if (bondCard.card_type == 1) {
                        arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", bondCard.verify_code)));
                        arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", bondCard.valid_date)));
                    }
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, bondCard.true_name));
                    arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", bondCard.mobile)));
                    if (!TextUtils.isEmpty(bondCard.certificate_code)) {
                        arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", bondCard.certificate_code)));
                        arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, bondCard.certificate_type));
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
                BindFastRequest bindFastRequest = this.f53410b;
                if (bindFastRequest == null) {
                    return arrayList;
                }
                arrayList.add(new RestNameValuePair("sub_bank_code", bindFastRequest.mBankNo));
                arrayList.add(new RestNameValuePair("request_type", this.f53410b.getCardRequestType()));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f53410b.getServiceType()));
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f53410b.getmBankCard())));
                arrayList.add(new RestNameValuePair("card_type", String.valueOf(this.f53410b.getCardType())));
                StatHelper.cacheBankCode(this.f53410b.mBankNo);
                StatHelper.cacheCardType(String.valueOf(this.f53410b.getCardType()));
                if (this.f53410b.getCardType() == 1) {
                    if (!TextUtils.isEmpty(this.f53410b.getmValidDate())) {
                        arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f53410b.getmValidDate())));
                    }
                    if (!TextUtils.isEmpty(this.f53410b.getmCvv())) {
                        arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f53410b.getmCvv())));
                    }
                }
                if (!TextUtils.isEmpty(this.f53410b.getmName())) {
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.f53410b.getmName()));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmPhone())) {
                    arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f53410b.getmPhone())));
                }
                if (!TextUtils.isEmpty(this.f53410b.getmIdCard())) {
                    arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f53410b.getmIdCard())));
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.f53410b.getCertificateType()));
                }
                if (!TextUtils.isEmpty(this.f53410b.getChannelNo())) {
                    arrayList.add(new RestNameValuePair("channel_no", this.f53410b.getChannelNo()));
                }
                arrayList.add(new RestNameValuePair("without_pay", this.f53410b.getWithoutPay()));
                BindFastRequest bindFastRequest2 = this.f53410b;
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
                BindFastRequest bindFastRequest3 = this.f53410b;
                if (bindFastRequest3 != null && !TextUtils.isEmpty(bindFastRequest3.mBankNo)) {
                    arrayList.add(new RestNameValuePair("easypay_channel", this.f53410b.mBankNo));
                }
                if (bondCard2 != null) {
                    arrayList.add(new RestNameValuePair("card_no_bind", bondCard2.account_no));
                }
                if (d()) {
                    com.baidu.wallet.paysdk.a.b.a(arrayList);
                }
            }
            if (b()) {
                PayRequest payRequest3 = this.f53411c;
                if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", this.f53411c.mOrderNo));
                }
                PayRequest payRequest4 = this.f53411c;
                if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mSpNO)) {
                    arrayList.add(new RestNameValuePair("sp_no", this.f53411c.mSpNO));
                }
                PayRequest payRequest5 = this.f53411c;
                if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.getOrderPrice())) {
                    arrayList.add(new RestNameValuePair("total_amount", this.f53411c.getOrderPrice()));
                }
                PayRequest payRequest6 = this.f53411c;
                if (payRequest6 != null && payRequest6.isPayByMktSolution && (mktSolution = payRequest6.mMktSolution) != null) {
                    if (!TextUtils.isEmpty(mktSolution.easypay_amount)) {
                        arrayList.add(new RestNameValuePair("pay_amount", this.f53411c.mMktSolution.easypay_amount));
                    }
                    if (this.f53411c.getCalcPayment() != null) {
                        String selectedDiscountIds = this.f53411c.getCalcPayment().getSelectedDiscountIds(this.f53411c.mMktSolution.activity_list);
                        if (!TextUtils.isEmpty(selectedDiscountIds)) {
                            arrayList.add(new RestNameValuePair("activity_id", selectedDiscountIds));
                            i2 = 2;
                            if (this.f53411c.getCalcPayment() != null) {
                                String selectedCouponIds = this.f53411c.getCalcPayment().getSelectedCouponIds(this.f53411c.mMktSolution.coupon_list);
                                if (!TextUtils.isEmpty(selectedCouponIds)) {
                                    i2++;
                                    arrayList.add(new RestNameValuePair("coupon_id", selectedCouponIds));
                                }
                            }
                        }
                    }
                    i2 = 1;
                    if (this.f53411c.getCalcPayment() != null) {
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (this.f53412d && (payRequest = this.f53411c) != null) {
                        r7 = payRequest.getCalcPayment() != null ? this.f53411c.getCalcPayment() : null;
                        arrayList.add(new RestNameValuePair("pay_amount", this.f53411c.getEasyPayAmount()));
                    } else {
                        BindFastRequest bindFastRequest4 = this.f53410b;
                        if (bindFastRequest4 != null && bindFastRequest4.mBindFrom == 0) {
                            r7 = bindFastRequest4.getCalcPaymentResponse();
                            arrayList.add(new RestNameValuePair("pay_amount", this.f53410b.getEasyPayAmount()));
                        } else {
                            PayRequest payRequest7 = this.f53411c;
                            if (payRequest7 != null) {
                                r7 = payRequest7.getCalcPayment() != null ? this.f53411c.getCalcPayment() : null;
                                arrayList.add(new RestNameValuePair("pay_amount", this.f53411c.getEasyPayAmount()));
                            }
                        }
                    }
                    if (r7 != null) {
                        if (TextUtils.isEmpty(r7.getSelectedDiscountIds())) {
                            i3 = 1;
                        } else {
                            sb.append(r7.getSelectedDiscountIds());
                            i3 = 2;
                        }
                        if (!TextUtils.isEmpty(sb.toString())) {
                            arrayList.add(new RestNameValuePair("activity_id", sb.toString()));
                        }
                        if (TextUtils.isEmpty(r7.getSelectedCouponIds())) {
                            i2 = i3;
                        } else {
                            arrayList.add(new RestNameValuePair("coupon_id", r7.getSelectedCouponIds()));
                            i2 = i3 + 1;
                        }
                    } else {
                        i2 = 1;
                    }
                }
                if (i2 >= 2) {
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
            BindFastRequest bindFastRequest5 = this.f53410b;
            if (bindFastRequest5 != null && bindFastRequest5.getmBindFrom() == 1) {
                PayRequest payRequest8 = this.f53411c;
                if (payRequest8 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest8.getPayFrom())) {
                    arrayList.add(new RestNameValuePair("sp_no", this.f53411c.mSpNO));
                    if (!TextUtils.isEmpty(this.f53411c.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", this.f53411c.mOrderNo));
                    }
                } else if (!TextUtils.isEmpty(this.f53410b.getSp_no())) {
                    arrayList.add(new RestNameValuePair("sp_no", this.f53410b.getSp_no()));
                }
            }
            BindFastRequest bindFastRequest6 = this.f53410b;
            if (bindFastRequest6 != null) {
                arrayList.add(new RestNameValuePair("session_id", bindFastRequest6.getSessionId()));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a = -1;
            if (c()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_VERIFY_CARDCHECK;
            } else if (d()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CARD_CHECK;
            } else {
                a = 1;
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CHECK_CARD_INFO;
            }
        }
        return (String) invokeV.objValue;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bindFastRequest) == null) {
            this.f53410b = bindFastRequest;
        }
    }
}
