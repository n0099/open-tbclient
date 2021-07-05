package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class c extends PayBaseBean<CalcPaymentResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DirectPayContentResponse f25867a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25868b;

    /* renamed from: c  reason: collision with root package name */
    public int f25869c;

    /* renamed from: d  reason: collision with root package name */
    public int f25870d;

    /* renamed from: e  reason: collision with root package name */
    public String f25871e;

    /* renamed from: f  reason: collision with root package name */
    public PayTypeItemView.PayTypeItemViewData f25872f;

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
        this.f25867a = PayDataCache.getInstance().getPayResponse();
        this.f25868b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (2 == this.f25869c) {
                return this.f25868b.getCalcPayment().getCouponJsonParams(this.f25870d, this.f25871e);
            }
            return this.f25868b.getCalcPayment().getCouponJsonParams();
        }
        return (String) invokeV.objValue;
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payTypeItemViewData) == null) {
            this.f25872f = payTypeItemViewData;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(CalcPaymentResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        String str;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f25867a != null && this.f25868b != null) {
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.f25868b.mSpNO));
                arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                arrayList.add(new RestNameValuePair("total_amount", this.f25868b.getOrderPrice()));
                CardData.BondCard bondCard = null;
                if (this.f25868b.hasDiscountOrCoupon()) {
                    str = a();
                    if (!TextUtils.isEmpty(b())) {
                        arrayList.add(new RestNameValuePair("coupon_list", b()));
                    }
                } else {
                    str = null;
                }
                UserData.UserModel userModel = this.f25867a.user;
                String str2 = "0";
                if (userModel != null && userModel.isSupportBalance()) {
                    PayData.DirectPayPay directPayPay = this.f25867a.pay;
                    if (directPayPay != null && (directPayBalance = directPayPay.balance) != null) {
                        arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                    }
                } else {
                    arrayList.add(new RestNameValuePair("balance_amount", "0"));
                }
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f25872f;
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
                    str2 = this.f25868b.getBalanceSelectStatus();
                    str3 = this.f25868b.getCreditPaySelectStatus();
                    bondCard = this.f25868b.mBondCard;
                }
                arrayList.add(new RestNameValuePair("need_calc_balance", str2));
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new RestNameValuePair("activity_list", str));
                }
                arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
                arrayList.add(new RestNameValuePair("umoney_amount", this.f25868b.getCreditTotalAmount()));
                if (bondCard != null) {
                    arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                    arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                    arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                }
                if (this.f25868b.getCalcPayment() != null) {
                    arrayList.add(new RestNameValuePair("activity_map", this.f25868b.getCalcPayment().getDiscountMapJsonParams()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 16;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
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
            this.f25869c = i2;
            this.f25870d = i3;
            this.f25871e = str;
        }
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (1 == this.f25869c) {
                return this.f25868b.getCalcPayment().getActivitiesJsonParams(this.f25870d, this.f25871e);
            }
            return this.f25868b.getCalcPayment().getActivitiesJsonParams();
        }
        return (String) invokeV.objValue;
    }
}
