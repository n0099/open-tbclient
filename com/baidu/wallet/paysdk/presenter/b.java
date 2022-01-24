package com.baidu.wallet.paysdk.presenter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.StringUtils;
/* loaded from: classes2.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authorizeSignActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((AuthorizeSignActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.a(z);
            if (z) {
                this.f52140b = 1;
            } else {
                this.f52140b = 2;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void b() {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            AuthorizeSignActivity authorizeSignActivity = this.a;
            if (authorizeSignActivity == null || (payRequest = authorizeSignActivity.getPayRequest()) == null) {
                return;
            }
            String needToPayAmount = payRequest.getNeedToPayAmount();
            String orderPrice = payRequest.getOrderPrice();
            String discountAmount = payRequest.getDiscountAmount();
            String randomDiscountMsg = payRequest.getRandomDiscountMsg();
            boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
            SpannableString spannableString = new SpannableString(ResUtils.getString(this.a.getApplicationContext(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
            if (z) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            String str = "-" + ResUtils.getString(this.a.getApplicationContext(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
            if (z) {
                this.a.updateDiscountTxt(h(), payRequest.getGoodsName(), spannableString, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayController.getInstance().gotoDiscountPage(this.a.a);
                        }
                    }
                });
            } else if (!TextUtils.isEmpty(randomDiscountMsg)) {
                this.a.updateDiscountTxt(true, payRequest.getGoodsName(), null, randomDiscountMsg, null, StringUtils.fen2Yuan(needToPayAmount), null);
            } else {
                this.a.updateDiscountTxt(h(), payRequest.getGoodsName(), null, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayController.getInstance().gotoDiscountPage(this.a.a);
                        }
                    }
                });
            }
            this.a.updateDiscountTitle(payRequest.title_url);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            return payRequest != null && payRequest.showCouponListEntry();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            view.getId();
            ResUtils.id(this.a.getApplicationContext(), "sign_next_btn");
        }
    }
}
