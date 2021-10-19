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
/* loaded from: classes8.dex */
public class r extends BaseBean<GetCardInfoResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62734a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f62735b;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f62736c;

    /* renamed from: d  reason: collision with root package name */
    public String f62737d;

    /* renamed from: e  reason: collision with root package name */
    public String f62738e;

    /* renamed from: f  reason: collision with root package name */
    public String f62739f;

    /* renamed from: g  reason: collision with root package name */
    public DirectPayContentResponse f62740g;

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
        this.f62735b = null;
        this.f62736c = null;
        this.f62737d = "";
        this.f62738e = "";
        this.f62739f = "";
        this.f62734a = true;
        this.f62740g = PayDataCache.getInstance().getPayResponse();
        this.f62736c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            BindFastRequest bindFastRequest = this.f62735b;
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
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f62737d)));
            if (!TextUtils.isEmpty(this.f62735b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("front_bank_code", this.f62735b.getSubBankCode()));
            }
            if (!TextUtils.isEmpty(this.f62738e)) {
                arrayList.add(new RestNameValuePair("card_no_bind", this.f62738e));
            }
            arrayList.addAll(PayDataCache.getInstance().getSessionData());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f62737d = str;
            this.f62738e = str2;
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
            if (this.f62735b != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("request_type", this.f62735b.getCardRequestType()));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f62735b.getServiceType()));
                arrayList.add(new RestNameValuePair("service", this.f62739f));
                if (!TextUtils.isEmpty(this.f62737d)) {
                    arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f62737d)));
                }
                if (this.f62735b.getmBondCard() != null) {
                    arrayList.add(new RestNameValuePair("card_no_bind", this.f62735b.getmBondCard().account_no));
                }
                PayRequest payRequest = this.f62736c;
                if (payRequest != null && this.f62734a) {
                    arrayList.add(new RestNameValuePair("is_transfer", payRequest.isTransfer()));
                } else {
                    if (!this.f62734a) {
                        this.f62734a = true;
                    }
                    arrayList.add(new RestNameValuePair("is_transfer", "0"));
                }
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                if (this.f62735b.getmBindFrom() != 0 && this.f62735b.getmBindFrom() != 2 && !a()) {
                    if (this.f62735b.getmBindFrom() == 1) {
                        PayRequest payRequest2 = this.f62736c;
                        if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                            arrayList.add(new RestNameValuePair("sp_no", this.f62736c.mSpNO));
                            if (!TextUtils.isEmpty(this.f62736c.mOrderNo)) {
                                arrayList.add(new RestNameValuePair("order_no", this.f62736c.mOrderNo));
                            }
                        } else if (!TextUtils.isEmpty(this.f62735b.getSp_no())) {
                            arrayList.add(new RestNameValuePair("sp_no", this.f62735b.getSp_no()));
                        }
                    }
                } else {
                    if (a()) {
                        com.baidu.wallet.paysdk.a.b.a(arrayList);
                    }
                    PayRequest payRequest3 = this.f62736c;
                    if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSpNO)) {
                        arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f62736c.mSpNO));
                        arrayList.add(new RestNameValuePair("sp_no", this.f62736c.mSpNO));
                    }
                    PayRequest payRequest4 = this.f62736c;
                    if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", this.f62736c.mOrderNo));
                    }
                    if (!TextUtils.isEmpty(PayDataCache.getInstance().getInsideTransOrder())) {
                        arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                    }
                    if (!TextUtils.isEmpty(PayDataCache.getInstance().getSellerUserId())) {
                        arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                    }
                    PayRequest payRequest5 = this.f62736c;
                    if (payRequest5 != null) {
                        arrayList.add(new RestNameValuePair("total_amount", payRequest5.getOrderPrice()));
                        arrayList.add(new RestNameValuePair("pay_amount", this.f62736c.getEasyPayAmount()));
                        if (this.f62735b.getmBindFrom() == 0) {
                            arrayList.add(new RestNameValuePair("need_calc_balance", "0"));
                            UserData.UserModel userModel = this.f62740g.user;
                            if (userModel != null && userModel.isSupportBalance()) {
                                PayData.DirectPayPay directPayPay = this.f62740g.pay;
                                if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                                }
                            } else {
                                arrayList.add(new RestNameValuePair("balance_amount", "0"));
                            }
                            arrayList.add(new RestNameValuePair("need_calc_umoney", "0"));
                            arrayList.add(new RestNameValuePair("umoney_amount", this.f62736c.getCreditTotalAmount()));
                            if (this.f62736c.hasDiscountOrCoupon()) {
                                String activitiesJsonParams = this.f62736c.getCalcPayment().getActivitiesJsonParams();
                                String couponJsonParams = this.f62736c.getCalcPayment().getCouponJsonParams();
                                if (!TextUtils.isEmpty(couponJsonParams)) {
                                    arrayList.add(new RestNameValuePair("coupon_list", couponJsonParams));
                                }
                                if (!TextUtils.isEmpty(activitiesJsonParams)) {
                                    arrayList.add(new RestNameValuePair("activity_list", activitiesJsonParams));
                                }
                            }
                        }
                    }
                    CardData.BondCard bondCard = this.f62735b.mBondCard;
                    if (bondCard != null) {
                        arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                    }
                }
                if (!TextUtils.isEmpty(this.f62735b.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.f62735b.getSubBankCode()));
                }
                arrayList.add(new RestNameValuePair("session_id", this.f62735b.getSessionId()));
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
            this.f62739f = str;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            BindFastRequest bindFastRequest = this.f62735b;
            return com.baidu.wallet.paysdk.a.b.a() && (bindFastRequest != null && (6 == (i2 = bindFastRequest.mBindFrom) || 7 == i2 || 8 == i2));
        }
        return invokeV.booleanValue;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.f62735b = bindFastRequest;
        }
    }
}
