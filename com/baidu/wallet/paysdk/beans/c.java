package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseBean<CalcPaymentResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DirectPayContentResponse f62021a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f62022b;

    /* renamed from: c  reason: collision with root package name */
    public int f62023c;

    /* renamed from: d  reason: collision with root package name */
    public int f62024d;

    /* renamed from: e  reason: collision with root package name */
    public String f62025e;

    /* renamed from: f  reason: collision with root package name */
    public PayTypeItemView.PayTypeItemViewData f62026f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        this.f62021a = PayDataCache.getInstance().getPayResponse();
        this.f62022b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (2 == this.f62023c) {
                return this.f62022b.getCalcPayment().getCouponJsonParams(this.f62024d, this.f62025e);
            }
            return this.f62022b.getCalcPayment().getCouponJsonParams();
        }
        return (String) invokeV.objValue;
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payTypeItemViewData) == null) {
            this.f62026f = payTypeItemViewData;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(CalcPaymentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        String str;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f62021a != null && this.f62022b != null) {
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f62022b.mSpNO));
                arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                arrayList.add(new RestNameValuePair("total_amount", this.f62022b.getOrderPrice()));
                CardData.BondCard bondCard = null;
                if (this.f62022b.hasDiscountOrCoupon()) {
                    str = a();
                    if (!TextUtils.isEmpty(b())) {
                        arrayList.add(new RestNameValuePair("coupon_list", b()));
                    }
                } else {
                    str = null;
                }
                UserData.UserModel userModel = this.f62021a.user;
                String str2 = "0";
                if (userModel != null && userModel.isSupportBalance()) {
                    PayData.DirectPayPay directPayPay = this.f62021a.pay;
                    if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                        arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                    }
                } else {
                    arrayList.add(new RestNameValuePair("balance_amount", "0"));
                }
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f62026f;
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
                    str2 = this.f62022b.getBalanceSelectStatus();
                    str3 = this.f62022b.getCreditPaySelectStatus();
                    bondCard = this.f62022b.mBondCard;
                }
                arrayList.add(new RestNameValuePair("need_calc_balance", str2));
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new RestNameValuePair("activity_list", str));
                }
                arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
                arrayList.add(new RestNameValuePair("umoney_amount", this.f62022b.getCreditTotalAmount()));
                if (bondCard != null) {
                    arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                    arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                    arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                }
                if (this.f62022b.getCalcPayment() != null) {
                    arrayList.add(new RestNameValuePair("activity_map", this.f62022b.getCalcPayment().getDiscountMapJsonParams()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 16;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (com.baidu.wallet.paysdk.a.b.a()) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CALC_PAYMENT;
            }
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CALC_PAYMENT;
        }
        return (String) invokeV.objValue;
    }

    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            this.f62023c = i2;
            this.f62024d = i3;
            this.f62025e = str;
        }
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (1 == this.f62023c) {
                return this.f62022b.getCalcPayment().getActivitiesJsonParams(this.f62024d, this.f62025e);
            }
            return this.f62022b.getCalcPayment().getActivitiesJsonParams();
        }
        return (String) invokeV.objValue;
    }
}
