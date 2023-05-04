package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.meb;
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
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class vcb implements obb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public nbb b;
    public PayUIKitConfig c;
    public PayFlowType d;
    public mbb e;
    public int f;
    public int g;
    public long h;

    /* loaded from: classes6.dex */
    public class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;
        public final /* synthetic */ hdb b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ edb d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ IYYPayWayView f;
        public final /* synthetic */ AppCustomExpand g;
        public final /* synthetic */ IYYPayWayView.b h;
        public final /* synthetic */ vcb i;

        public a(vcb vcbVar, IPayCallback iPayCallback, hdb hdbVar, Activity activity, edb edbVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcbVar, iPayCallback, hdbVar, activity, edbVar, dialog, iYYPayWayView, appCustomExpand, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = vcbVar;
            this.a = iPayCallback;
            this.b = hdbVar;
            this.c = activity;
            this.d = edbVar;
            this.e = dialog;
            this.f = iYYPayWayView;
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
                    hdb hdbVar = this.b;
                    hdbVar.a = PayType.ALI_PAY;
                    this.i.e(this.c, this.d, hdbVar, this.e, this.f, this.g, this.h, this.a);
                    return;
                }
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
            }
        }
    }

    public vcb(int i, int i2, nbb nbbVar, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType, mbb mbbVar) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), nbbVar, payUIKitConfig, payFlowType, mbbVar};
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
        this.b = nbbVar;
        this.c = payUIKitConfig;
        this.d = payFlowType;
        this.e = mbbVar;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
    }

    @Override // com.baidu.tieba.obb
    public void a(Activity activity, edb edbVar, hdb hdbVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, edbVar, hdbVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog:" + this);
            a aVar = new a(this, iPayCallback, hdbVar, activity, edbVar, dialog, iYYPayWayView, appCustomExpand, bVar);
            boolean a2 = aeb.b(activity, this.h + "").a("pay_sp_key_sign_pay_skip_remind", false);
            String str2 = this.a;
            RLog.info(str2, "prepareShowPaySignDialog, isSkipShowSignDialog=" + a2);
            if (a2) {
                e(activity, edbVar, hdbVar, dialog, iYYPayWayView, appCustomExpand, bVar, aVar);
                return;
            }
            meb.b bVar2 = new meb.b();
            bVar2.a = edbVar;
            bVar2.b = bVar.g;
            meb f = this.b.f(activity, bVar2, this.c);
            f.setCallback(new kcb(activity, d(activity, f, bVar2), this.e, edbVar, hdbVar, dialog, iYYPayWayView, appCustomExpand, bVar, aVar));
        }
    }

    public final Dialog d(Activity activity, meb mebVar, meb.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, mebVar, bVar)) == null) {
            return veb.b.e(activity, "title", mebVar.getContentView(), new jcb(this.f, this.g), bVar.b, PayDialogType.PAY_SIGN_DIALOG, this.d);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, edb edbVar, hdb hdbVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, edbVar, hdbVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog startPay payType=" + hdbVar.a);
            this.e.f(activity, hdbVar, edbVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback);
        }
    }
}
