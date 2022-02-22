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
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class r extends BaseBean<GetCardInfoResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f52148b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f52149c;

    /* renamed from: d  reason: collision with root package name */
    public String f52150d;

    /* renamed from: e  reason: collision with root package name */
    public String f52151e;

    /* renamed from: f  reason: collision with root package name */
    public String f52152f;

    /* renamed from: g  reason: collision with root package name */
    public DirectPayContentResponse f52153g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> r(Context context) {
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
        this.f52148b = null;
        this.f52149c = null;
        this.f52150d = "";
        this.f52151e = "";
        this.f52152f = "";
        this.a = true;
        this.f52153g = PayDataCache.getInstance().getPayResponse();
        this.f52149c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            BindFastRequest bindFastRequest = this.f52148b;
            if (bindFastRequest != null) {
                return "13".equals(bindFastRequest.getCardRequestType());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private List<RestNameValuePair> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", "13"));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f52150d)));
            if (!TextUtils.isEmpty(this.f52148b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("front_bank_code", this.f52148b.getSubBankCode()));
            }
            if (!TextUtils.isEmpty(this.f52151e)) {
                arrayList.add(new RestNameValuePair("card_no_bind", this.f52151e));
            }
            arrayList.addAll(PayDataCache.getInstance().getSessionData());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f52150d = str;
            this.f52151e = str2;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.execBean(GetCardInfoResponse.class, ErrorContentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (b()) {
                return c();
            }
            if (this.f52148b != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("request_type", this.f52148b.getCardRequestType()));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f52148b.getServiceType()));
                arrayList.add(new RestNameValuePair("service", this.f52152f));
                if (!TextUtils.isEmpty(this.f52150d)) {
                    arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f52150d)));
                }
                if (this.f52148b.getmBondCard() != null) {
                    arrayList.add(new RestNameValuePair("card_no_bind", this.f52148b.getmBondCard().account_no));
                }
                PayRequest payRequest = this.f52149c;
                if (payRequest != null && this.a) {
                    arrayList.add(new RestNameValuePair("is_transfer", payRequest.isTransfer()));
                } else {
                    if (!this.a) {
                        this.a = true;
                    }
                    arrayList.add(new RestNameValuePair("is_transfer", "0"));
                }
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                if (this.f52148b.getmBindFrom() != 0 && this.f52148b.getmBindFrom() != 2 && !a()) {
                    if (this.f52148b.getmBindFrom() == 1) {
                        PayRequest payRequest2 = this.f52149c;
                        if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                            arrayList.add(new RestNameValuePair("sp_no", this.f52149c.mSpNO));
                            if (!TextUtils.isEmpty(this.f52149c.mOrderNo)) {
                                arrayList.add(new RestNameValuePair("order_no", this.f52149c.mOrderNo));
                            }
                        } else if (!TextUtils.isEmpty(this.f52148b.getSp_no())) {
                            arrayList.add(new RestNameValuePair("sp_no", this.f52148b.getSp_no()));
                        }
                    }
                } else {
                    if (a()) {
                        com.baidu.wallet.paysdk.a.b.a(arrayList);
                    }
                    PayRequest payRequest3 = this.f52149c;
                    if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSpNO)) {
                        arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f52149c.mSpNO));
                        arrayList.add(new RestNameValuePair("sp_no", this.f52149c.mSpNO));
                    }
                    PayRequest payRequest4 = this.f52149c;
                    if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", this.f52149c.mOrderNo));
                    }
                    if (!TextUtils.isEmpty(PayDataCache.getInstance().getInsideTransOrder())) {
                        arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                    }
                    if (!TextUtils.isEmpty(PayDataCache.getInstance().getSellerUserId())) {
                        arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                    }
                    PayRequest payRequest5 = this.f52149c;
                    if (payRequest5 != null) {
                        arrayList.add(new RestNameValuePair("total_amount", payRequest5.getOrderPrice()));
                        arrayList.add(new RestNameValuePair("pay_amount", this.f52149c.getEasyPayAmount()));
                        if (this.f52148b.getmBindFrom() == 0) {
                            arrayList.add(new RestNameValuePair("need_calc_balance", "0"));
                            UserData.UserModel userModel = this.f52153g.user;
                            if (userModel != null && userModel.isSupportBalance()) {
                                PayData.DirectPayPay directPayPay = this.f52153g.pay;
                                if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                                }
                            } else {
                                arrayList.add(new RestNameValuePair("balance_amount", "0"));
                            }
                            arrayList.add(new RestNameValuePair("need_calc_umoney", "0"));
                            arrayList.add(new RestNameValuePair("umoney_amount", this.f52149c.getCreditTotalAmount()));
                            if (this.f52149c.hasDiscountOrCoupon()) {
                                String activitiesJsonParams = this.f52149c.getCalcPayment().getActivitiesJsonParams();
                                String couponJsonParams = this.f52149c.getCalcPayment().getCouponJsonParams();
                                if (!TextUtils.isEmpty(couponJsonParams)) {
                                    arrayList.add(new RestNameValuePair("coupon_list", couponJsonParams));
                                }
                                if (!TextUtils.isEmpty(activitiesJsonParams)) {
                                    arrayList.add(new RestNameValuePair("activity_list", activitiesJsonParams));
                                }
                            }
                        }
                    }
                    CardData.BondCard bondCard = this.f52148b.mBondCard;
                    if (bondCard != null) {
                        arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                    }
                }
                if (!TextUtils.isEmpty(this.f52148b.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.f52148b.getSubBankCode()));
                }
                arrayList.add(new RestNameValuePair("session_id", this.f52148b.getSessionId()));
                return arrayList;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (b()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_VERIFY_CARDINFO;
            } else if (a()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CARD_INFO;
            } else {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_GET_CARD_INFO;
            }
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f52152f = str;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            BindFastRequest bindFastRequest = this.f52148b;
            return com.baidu.wallet.paysdk.a.b.a() && (bindFastRequest != null && (6 == (i2 = bindFastRequest.mBindFrom) || 7 == i2 || 8 == i2));
        }
        return invokeV.booleanValue;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.f52148b = bindFastRequest;
        }
    }
}
