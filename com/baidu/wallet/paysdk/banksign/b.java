package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PostWebviewActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes8.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            BaiduPayDelegate.getInstance().reOrderPay(context);
        }
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || context == null) {
            return;
        }
        String i2 = com.baidu.wallet.paysdk.banksign.a.a.a().i();
        byte[] k = com.baidu.wallet.paysdk.banksign.a.a.a().k();
        String j2 = com.baidu.wallet.paysdk.banksign.a.a.a().j();
        if (TextUtils.isEmpty(j2)) {
            j2 = ResUtils.getString(context, "dxmpay_banksign_web_title");
        }
        StatisticManager.onEvent("enterBankSign");
        PostWebviewActivity.startPostWebview(context, i2, k, j2);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && context != null && (context instanceof BusinessSignedGuideActivity)) {
            ((BusinessSignedGuideActivity) context).bindcard();
        }
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        PayController.getInstance().gotoPayTypePage(context, true);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, BusinessSignedGuideActivity.class);
        intent.putExtra("isActiveSign", com.baidu.wallet.paysdk.banksign.a.a.a().f());
        context.startActivity(intent);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                j e2 = com.baidu.wallet.paysdk.banksign.a.a.a().e();
                PayTypeActivity d2 = com.baidu.wallet.paysdk.banksign.a.a.a().d();
                if (e2 != null) {
                    e2.f();
                    com.baidu.wallet.paysdk.banksign.a.a.a().a((j) null);
                    return;
                } else if (d2 != null) {
                    d2.jumpPwdPayActivity();
                    d2.finishWithoutAnim();
                    com.baidu.wallet.paysdk.banksign.a.a.a().a((PayTypeActivity) null);
                    return;
                } else {
                    return;
                }
            }
            OrderConfirmActivity c2 = com.baidu.wallet.paysdk.banksign.a.a.a().c();
            if (c2 != null) {
                c2.pay(com.baidu.wallet.paysdk.banksign.a.a.a().h(), com.baidu.wallet.paysdk.banksign.a.a.a().g(), true);
                com.baidu.wallet.paysdk.banksign.a.a.a().a((OrderConfirmActivity) null);
            }
        }
    }
}
