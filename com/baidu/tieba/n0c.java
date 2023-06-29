package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l2c;
import com.baidu.tieba.n2c;
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
public class n0c implements gzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public fzb b;
    public PayUIKitConfig c;
    public PayFlowType d;
    public ezb e;
    public int f;
    public int g;
    public long h;

    /* loaded from: classes7.dex */
    public class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;
        public final /* synthetic */ a1c b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ w0c d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ g2c f;
        public final /* synthetic */ AppCustomExpand g;
        public final /* synthetic */ n2c.b h;
        public final /* synthetic */ n0c i;

        public a(n0c n0cVar, IPayCallback iPayCallback, a1c a1cVar, Activity activity, w0c w0cVar, Dialog dialog, g2c g2cVar, AppCustomExpand appCustomExpand, n2c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0cVar, iPayCallback, a1cVar, activity, w0cVar, dialog, g2cVar, appCustomExpand, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = n0cVar;
            this.a = iPayCallback;
            this.b = a1cVar;
            this.c = activity;
            this.d = w0cVar;
            this.e = dialog;
            this.f = g2cVar;
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
                    a1c a1cVar = this.b;
                    a1cVar.a = PayType.ALI_PAY;
                    this.i.e(this.c, this.d, a1cVar, this.e, this.f, this.g, this.h, this.a);
                    return;
                }
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
            }
        }
    }

    public n0c(int i, int i2, fzb fzbVar, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType, ezb ezbVar) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), fzbVar, payUIKitConfig, payFlowType, ezbVar};
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
        this.b = fzbVar;
        this.c = payUIKitConfig;
        this.d = payFlowType;
        this.e = ezbVar;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
    }

    @Override // com.baidu.tieba.gzb
    public void a(Activity activity, w0c w0cVar, a1c a1cVar, Dialog dialog, g2c g2cVar, AppCustomExpand appCustomExpand, n2c.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, w0cVar, a1cVar, dialog, g2cVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog:" + this);
            a aVar = new a(this, iPayCallback, a1cVar, activity, w0cVar, dialog, g2cVar, appCustomExpand, bVar);
            boolean z = false;
            if (!a1cVar.g) {
                z = v1c.b(activity, this.h + "").a("pay_sp_key_sign_pay_skip_remind", false);
            }
            String str2 = this.a;
            RLog.info(str2, "prepareShowPaySignDialog, isSkipShowSignDialog=" + z);
            if (z) {
                e(activity, w0cVar, a1cVar, dialog, g2cVar, appCustomExpand, bVar, aVar);
                return;
            }
            l2c.b bVar2 = new l2c.b();
            bVar2.a = a1cVar.g;
            bVar2.b = w0cVar;
            bVar2.c = bVar.f;
            l2c f = this.b.f(activity, bVar2, this.c);
            f.setCallback(new c0c(activity, d(activity, f, bVar2), this.e, w0cVar, a1cVar, dialog, g2cVar, appCustomExpand, bVar, aVar));
        }
    }

    public final Dialog d(Activity activity, l2c l2cVar, l2c.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, l2cVar, bVar)) == null) {
            return w2c.b.e(activity, "title", l2cVar.getContentView(), new b0c(this.f, this.g), bVar.c, PayDialogType.PAY_SIGN_DIALOG, this.d);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, w0c w0cVar, a1c a1cVar, Dialog dialog, g2c g2cVar, AppCustomExpand appCustomExpand, n2c.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, w0cVar, a1cVar, dialog, g2cVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog startPay payType=" + a1cVar.a);
            this.e.k(activity, a1cVar, w0cVar, dialog, g2cVar, appCustomExpand, bVar, iPayCallback);
        }
    }
}
