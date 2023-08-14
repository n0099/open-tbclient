package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mac;
import com.baidu.tieba.oac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class o8c implements h7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public g7c b;
    public PayUIKitConfig c;
    public PayFlowType d;
    public f7c e;
    public int f;
    public int g;
    public long h;

    /* loaded from: classes7.dex */
    public class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;
        public final /* synthetic */ b9c b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ x8c d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ hac f;
        public final /* synthetic */ AppCustomExpand g;
        public final /* synthetic */ oac.b h;
        public final /* synthetic */ o8c i;

        public a(o8c o8cVar, IPayCallback iPayCallback, b9c b9cVar, Activity activity, x8c x8cVar, Dialog dialog, hac hacVar, AppCustomExpand appCustomExpand, oac.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o8cVar, iPayCallback, b9cVar, activity, x8cVar, dialog, hacVar, appCustomExpand, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = o8cVar;
            this.a = iPayCallback;
            this.b = b9cVar;
            this.c = activity;
            this.d = x8cVar;
            this.e = dialog;
            this.f = hacVar;
            this.g = appCustomExpand;
            this.h = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onSuccess(currencyChargeMessage, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onFail(i, str, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                if (purchaseStatus == PurchaseStatus.ORDER_FAIL && this.b.a == PayType.ALI_PAY_SIGN) {
                    RLog.info(this.i.a, "prepareShowPaySignDialog onPayStatus ORDER_FAIL, payWay.payType=PayType.ALI_PAY_SIGN");
                    b9c b9cVar = this.b;
                    b9cVar.a = PayType.ALI_PAY;
                    this.i.e(this.c, this.d, b9cVar, this.e, this.f, this.g, this.h, this.a);
                    return;
                }
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
            }
        }
    }

    public o8c(int i, int i2, g7c g7cVar, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType, f7c f7cVar) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), g7cVar, payUIKitConfig, payFlowType, f7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "PaySignManager";
        this.h = 0L;
        RLog.info("PaySignManager", "create PaySignManager:" + this);
        this.f = i;
        this.g = i2;
        this.b = g7cVar;
        this.c = payUIKitConfig;
        this.d = payFlowType;
        this.e = f7cVar;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
    }

    @Override // com.baidu.tieba.h7c
    public void a(Activity activity, x8c x8cVar, b9c b9cVar, Dialog dialog, hac hacVar, AppCustomExpand appCustomExpand, oac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, x8cVar, b9cVar, dialog, hacVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog:" + this);
            a aVar = new a(this, iPayCallback, b9cVar, activity, x8cVar, dialog, hacVar, appCustomExpand, bVar);
            boolean z = false;
            if (!b9cVar.g) {
                z = w9c.b(activity, this.h + "").a("pay_sp_key_sign_pay_skip_remind", false);
            }
            String str2 = this.a;
            RLog.info(str2, "prepareShowPaySignDialog, isSkipShowSignDialog=" + z);
            if (z) {
                e(activity, x8cVar, b9cVar, dialog, hacVar, appCustomExpand, bVar, aVar);
                return;
            }
            mac.b bVar2 = new mac.b();
            bVar2.a = b9cVar.g;
            bVar2.b = x8cVar;
            bVar2.c = bVar.f;
            mac f = this.b.f(activity, bVar2, this.c);
            f.setCallback(new d8c(activity, d(activity, f, bVar2), this.e, x8cVar, b9cVar, dialog, hacVar, appCustomExpand, bVar, aVar));
        }
    }

    public final Dialog d(Activity activity, mac macVar, mac.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, macVar, bVar)) == null) {
            return xac.b.e(activity, "title", macVar.getContentView(), new c8c(this.f, this.g), bVar.c, PayDialogType.PAY_SIGN_DIALOG, this.d);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, x8c x8cVar, b9c b9cVar, Dialog dialog, hac hacVar, AppCustomExpand appCustomExpand, oac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, x8cVar, b9cVar, dialog, hacVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog startPay payType=" + b9cVar.a);
            this.e.k(activity, b9cVar, x8cVar, dialog, hacVar, appCustomExpand, bVar, iPayCallback);
        }
    }
}
