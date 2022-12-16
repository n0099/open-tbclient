package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class maa implements f9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9a a;
    public PayFlowType b;
    public waa c;
    public c9a d;
    public PayUIKitConfig e;
    public int f;
    public int g;

    public maa(d9a d9aVar, PayFlowType payFlowType, c9a c9aVar, int i, int i2, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9aVar, payFlowType, c9aVar, Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d9aVar;
        this.b = payFlowType;
        this.d = c9aVar;
        this.f = i;
        this.g = i2;
        this.e = payUIKitConfig;
    }

    @Override // com.baidu.tieba.f9a
    public void a(Activity activity, uaa uaaVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        WindowParams windowParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, uaaVar, list, str, paySplitOrderViewSource, viewParams, iPayCallback}) == null) {
            if (eba.b(this.f, this.g) == null) {
                RLog.error("PaySplitOrderManager", "prepareShowSplitOrderDialog error appPayService null", new Object[0]);
                return;
            }
            dca.b bVar = new dca.b();
            bVar.a = uaaVar;
            bVar.h = paySplitOrderViewSource;
            bVar.c = this.b;
            AbsViewEventHandler absViewEventHandler = null;
            if (viewParams != null) {
                windowParams = viewParams.windowParams;
            } else {
                windowParams = null;
            }
            bVar.b = windowParams;
            bVar.d = list;
            bVar.e = str;
            bVar.f = viewParams;
            if (viewParams != null) {
                absViewEventHandler = viewParams.viewEventListener;
            }
            bVar.g = absViewEventHandler;
            e(activity, bVar, iPayCallback);
        }
    }

    @Override // com.baidu.tieba.f9a
    public waa b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (waa) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f9a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info("PaySplitOrderManager", "release mPaySplitOrderInfo:" + this.c);
            this.c = null;
        }
    }

    @Override // com.baidu.tieba.f9a
    public void c(waa waaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, waaVar) == null) {
            RLog.info("PaySplitOrderManager", "setPaySplitOrderInfo info:" + waaVar);
            this.c = waaVar;
        }
    }

    public Dialog d(Activity activity, dca dcaVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, dcaVar, absViewEventHandler)) == null) {
            RLog.info("PaySplitOrderManager", "createSplitOrderDialog");
            this.d.k(absViewEventHandler, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
            return kca.b.e(activity, activity.getString(R.string.pay_ui_pay_split_order_dialog_title), dcaVar.getContentView(), new baa(this.f, this.g, activity, absViewEventHandler, this.d, dcaVar), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG, this.b, this.e, true);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, dca.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, bVar, iPayCallback) == null) {
            RLog.info("PaySplitOrderManager", "pay_dialog_show_flow:showSplitOrderDialog splitOrderViewParams:" + bVar);
            dca h = this.a.h(activity, this.e, bVar, this);
            h.refreshView();
            Dialog d = d(activity, h, bVar.g);
            h.setCallback(new caa(activity, d, bVar, iPayCallback, this.d));
            this.d.q(h, d);
        }
    }
}
