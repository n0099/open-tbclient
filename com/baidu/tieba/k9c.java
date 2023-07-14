package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ibc;
import com.baidu.tieba.kbc;
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
/* loaded from: classes6.dex */
public class k9c implements d8c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public c8c b;
    public PayUIKitConfig c;
    public PayFlowType d;
    public b8c e;
    public int f;
    public int g;
    public long h;

    /* loaded from: classes6.dex */
    public class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;
        public final /* synthetic */ x9c b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ t9c d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ dbc f;
        public final /* synthetic */ AppCustomExpand g;
        public final /* synthetic */ kbc.b h;
        public final /* synthetic */ k9c i;

        public a(k9c k9cVar, IPayCallback iPayCallback, x9c x9cVar, Activity activity, t9c t9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k9cVar, iPayCallback, x9cVar, activity, t9cVar, dialog, dbcVar, appCustomExpand, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = k9cVar;
            this.a = iPayCallback;
            this.b = x9cVar;
            this.c = activity;
            this.d = t9cVar;
            this.e = dialog;
            this.f = dbcVar;
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
                    x9c x9cVar = this.b;
                    x9cVar.a = PayType.ALI_PAY;
                    this.i.e(this.c, this.d, x9cVar, this.e, this.f, this.g, this.h, this.a);
                    return;
                }
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
            }
        }
    }

    public k9c(int i, int i2, c8c c8cVar, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType, b8c b8cVar) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), c8cVar, payUIKitConfig, payFlowType, b8cVar};
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
        this.b = c8cVar;
        this.c = payUIKitConfig;
        this.d = payFlowType;
        this.e = b8cVar;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
    }

    @Override // com.baidu.tieba.d8c
    public void a(Activity activity, t9c t9cVar, x9c x9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, t9cVar, x9cVar, dialog, dbcVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog:" + this);
            a aVar = new a(this, iPayCallback, x9cVar, activity, t9cVar, dialog, dbcVar, appCustomExpand, bVar);
            boolean z = false;
            if (!x9cVar.g) {
                z = sac.b(activity, this.h + "").a("pay_sp_key_sign_pay_skip_remind", false);
            }
            String str2 = this.a;
            RLog.info(str2, "prepareShowPaySignDialog, isSkipShowSignDialog=" + z);
            if (z) {
                e(activity, t9cVar, x9cVar, dialog, dbcVar, appCustomExpand, bVar, aVar);
                return;
            }
            ibc.b bVar2 = new ibc.b();
            bVar2.a = x9cVar.g;
            bVar2.b = t9cVar;
            bVar2.c = bVar.f;
            ibc f = this.b.f(activity, bVar2, this.c);
            f.setCallback(new z8c(activity, d(activity, f, bVar2), this.e, t9cVar, x9cVar, dialog, dbcVar, appCustomExpand, bVar, aVar));
        }
    }

    public final Dialog d(Activity activity, ibc ibcVar, ibc.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, ibcVar, bVar)) == null) {
            return tbc.b.e(activity, "title", ibcVar.getContentView(), new y8c(this.f, this.g), bVar.c, PayDialogType.PAY_SIGN_DIALOG, this.d);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, t9c t9cVar, x9c x9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, t9cVar, x9cVar, dialog, dbcVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog startPay payType=" + x9cVar.a);
            this.e.k(activity, x9cVar, t9cVar, dialog, dbcVar, appCustomExpand, bVar, iPayCallback);
        }
    }
}
