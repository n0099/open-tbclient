package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes6.dex */
public class jec implements phc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vdc a;
    public AbsViewEventHandler b;
    public PayUIKitConfig c;
    public Activity d;
    public List<PayWayInfo> e;
    public IYYPayAmountView.ViewParams f;
    public IPayCallback<CurrencyChargeMessage> g;
    public String h;

    public jec(vdc vdcVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, String str, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vdcVar, absViewEventHandler, payUIKitConfig, activity, list, viewParams, str, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountInputDialogListener", "create AmountInputDialogListener");
        this.a = vdcVar;
        this.b = absViewEventHandler;
        this.c = payUIKitConfig;
        this.d = activity;
        this.e = list;
        this.f = viewParams;
        this.g = iPayCallback;
        this.h = str;
    }

    @Override // com.baidu.tieba.phc
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.a.g(cancelType, this.b);
        }
    }

    @Override // com.baidu.tieba.phc
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            nfc a = agc.a((int) (i * 100.0d), this.c);
            if (ngc.b(i)) {
                this.a.a(this.d, a, this.e, this.h, PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG, this.f, this.g);
                RLog.info("AmountInputDialogListener", "confirm but ShowSplitOrderDialog");
                return;
            }
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a);
            this.a.t(this.d, a, this.e, this.h, this.f, this.g);
        }
    }
}
