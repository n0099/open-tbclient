package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jkc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class oic implements ihc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public PayUIKitConfig e;
    public vgc f;
    public bhc g;
    public SparseArray<Integer> h;
    public SparseArray<ahc> i;
    public SparseArray<PayFlowModel> j;

    public oic(Context context, int i, int i2, vgc vgcVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), vgcVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "YYPayController";
        this.h = new SparseArray<>(2);
        this.i = new SparseArray<>();
        this.j = new SparseArray<>();
        this.a += "@" + hashCode();
        this.b = i;
        this.d = context;
        this.c = i2;
        this.f = vgcVar;
        this.e = payUIKitConfig;
        this.g = new hic(i, i2, payUIKitConfig);
        this.h.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.h.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // com.baidu.tieba.xgc
    public synchronized PayFlowModel j(PayFlowType payFlowType) {
        InterceptResult invokeL;
        PayFlowModel payFlowModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, payFlowType)) == null) {
            synchronized (this) {
                payFlowModel = this.j.get(payFlowType.getTypeId());
            }
            return payFlowModel;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ihc
    public void m(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            String str = this.a;
            RLog.info(str, "startWebPayActivity currentActivity:" + activity);
            p(activity, null, uic.e(this.e), "红宝石充值");
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            String str = this.a;
            RLog.info(str, "releaseAllPayFlow innerRelease:" + z);
            c(PayFlowType.WALLET_PAY_FLOW, z);
            c(PayFlowType.DIOALOG_PAY_FLOW, z);
        }
    }

    @Override // com.baidu.tieba.ihc
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            String str = this.a;
            RLog.info(str, "release() innerRelease:" + z);
            q(z);
            this.i.clear();
            this.j.clear();
        }
    }

    public void o(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payFlowType) == null) {
            String str = this.a;
            RLog.info(str, "innerReleasePayFlow payFlowType:" + payFlowType);
            c(payFlowType, true);
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                pjc.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                pjc.b(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, windowParams) == null) {
            ahc ahcVar = this.i.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId());
            if (ahcVar != null && windowParams != null) {
                ahcVar.refreshWindow(windowParams);
            }
            String str = this.a;
            RLog.info(str, "refreshWindow windowParams:" + windowParams + " handler:" + ahcVar);
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void c(PayFlowType payFlowType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, payFlowType, z) == null) {
            synchronized (this) {
                ahc ahcVar = this.i.get(payFlowType.getTypeId());
                if (ahcVar != null) {
                    ahcVar.b(z);
                }
                this.i.remove(payFlowType.getTypeId());
                this.j.remove(payFlowType.getTypeId());
                r("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + ahcVar + " innerRelease:" + z);
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void d(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                int i = intValue + 1;
                String str2 = this.a;
                RLog.info(str2, "payActivityVisitRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCount:" + i);
                this.h.put(payFlowType.getTypeId(), Integer.valueOf(i));
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void l(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                int i = intValue - 1;
                RLog.info(this.a, "payActivityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCountt:" + i);
                this.h.put(payFlowType.getTypeId(), Integer.valueOf(i));
            }
        }
    }

    public final void t(PayFlowType payFlowType, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, payFlowType, viewParams) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFlowModel payFlowType :" + payFlowType + " viewParams:" + viewParams);
            if (viewParams == null) {
                RLog.info(this.a, "updatePayFlowModel with value null");
                this.j.put(payFlowType.getTypeId(), null);
                return;
            }
            PayFlowModel n = n(viewParams);
            String str2 = this.a;
            RLog.info(str2, "updatePayFlowModel payFlowModel :" + n);
            if (n != null) {
                this.j.put(payFlowType.getTypeId(), n);
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (k(PayFlowType.WALLET_PAY_FLOW) && k(PayFlowType.DIOALOG_PAY_FLOW)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ihc
    public void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, viewParams, iPayCallback) == null) {
            String str = this.a;
            RLog.info(str, "innerPayAmountDialogForWeb viewParams:" + viewParams);
            if (viewParams == null) {
                viewParams = new IYYPayAmountView.ViewParams();
            }
            PayFlowModel payFlowModel = this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
            if (payFlowModel != null) {
                viewParams.appCustomExpand = payFlowModel.appCustomExpand;
                viewParams.viewEventListener = payFlowModel.viewEventListener;
                viewParams.clientInfoExpand = payFlowModel.clientInfoExpand;
            }
            String str2 = this.a;
            RLog.info(str2, "innerPayAmountDialogForWeb payFlowModel:" + payFlowModel);
            ahc ahcVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
            if (ahcVar == null) {
                RLog.error(this.a, "innerPayAmountDialogForWeb error walletPayFlowHandler null", new Object[0]);
                return;
            }
            ahcVar.h().release();
            ahcVar.j(activity, iPayCallback, viewParams);
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                o(PayFlowType.DIOALOG_PAY_FLOW);
                t(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                mic.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                gic gicVar = new gic(this.d, this.b, this.c, this.f, this.g, new eic(PayFlowType.DIOALOG_PAY_FLOW, this.g), PayFlowType.DIOALOG_PAY_FLOW, this.e, this.j.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId()));
                this.i.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), gicVar);
                r("startPayDialog showPayAmountDialog");
                gicVar.j(activity, iPayCallback, viewParams);
                bjc.b(this.b, this.c, PayUIEventType.purchaseshow);
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void h(Activity activity, jkc.b bVar, ric ricVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, bVar, ricVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "innerPayWayDialogForWeb viewParams:" + bVar + " openPayParams:" + ricVar);
                if (bVar == null) {
                    bVar = new jkc.b();
                }
                PayFlowModel payFlowModel = this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.d = payFlowModel.appCustomExpand;
                    bVar.f = payFlowModel.viewEventListener;
                    bVar.e = payFlowModel.clientInfoExpand;
                }
                String str2 = this.a;
                RLog.info(str2, "innerPayWayDialogForWeb payFlowModel:" + payFlowModel);
                ahc ahcVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (ahcVar == null) {
                    RLog.error(this.a, "innerPayWayDialogForWeb error walletPayFlowHandler null", new Object[0]);
                    return;
                }
                ahcVar.h().release();
                sic sicVar = bVar.c;
                if (sicVar != null && ricVar != null && ricVar.a == 1 && sjc.c(ricVar.b, (int) sicVar.c())) {
                    s(ahcVar, activity, bVar, iPayCallback);
                } else {
                    ahcVar.d(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                p(activity, viewParams, uic.f(this.e), "我的钱包");
            }
        }
    }

    @Override // com.baidu.tieba.ihc
    public synchronized boolean k(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, payFlowType)) == null) {
            synchronized (this) {
                ahc ahcVar = this.i.get(payFlowType.getTypeId());
                boolean z = true;
                if (ahcVar == null) {
                    String str = this.a;
                    RLog.info(str, "isReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (ahcVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "isReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + ahcVar.v() + " release:" + z);
                    return z;
                } else {
                    int intValue2 = this.h.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || ahcVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "isReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + ahcVar.v() + " release:" + z);
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public final PayFlowModel n(IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, viewParams)) == null) {
            if (viewParams != null) {
                PayFlowModel payFlowModel = new PayFlowModel();
                payFlowModel.appCustomExpand = viewParams.appCustomExpand;
                payFlowModel.viewEventListener = viewParams.viewEventListener;
                payFlowModel.clientInfoExpand = viewParams.clientInfoExpand;
                payFlowModel.payResultViewRetryApi = viewParams.payResultViewRetryApi;
                payFlowModel.payFailedRetryCode = viewParams.payFailedRetryCode;
                String str = this.a;
                RLog.info(str, "createPayFlowModel PayFlowModel:" + payFlowModel);
                return payFlowModel;
            }
            RLog.info(this.a, "createPayFlowModel but viewParams null");
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public final synchronized void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            synchronized (this) {
                int size = this.i.size();
                int size2 = this.j.size();
                String str2 = this.a;
                RLog.info(str2, ("reportPayFlowMapSize from: " + str) + " payFlowHanderMapSize:" + size + " payFlowModelMapSize:" + size2);
            }
        }
    }

    public final synchronized void p(Activity activity, IYYPayAmountView.ViewParams viewParams, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, activity, viewParams, str, str2) == null) {
            synchronized (this) {
                o(PayFlowType.WALLET_PAY_FLOW);
                t(PayFlowType.WALLET_PAY_FLOW, viewParams);
                mic.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.i.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new gic(this.d, this.b, this.c, this.f, this.g, new eic(PayFlowType.WALLET_PAY_FLOW, this.g), PayFlowType.WALLET_PAY_FLOW, this.e, this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId())));
                r("innerStartWebActivity webUrl:" + zjc.a(str));
                jjc.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.e, activity, str, str2);
                bjc.b(this.b, this.c, PayUIEventType.walletshow);
            }
        }
    }

    public final void s(ahc ahcVar, Activity activity, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, ahcVar, activity, bVar, iPayCallback) == null) {
            String str = this.a;
            RLog.info(str, "showPaySplitOrderView viewParams:" + bVar);
            IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
            viewParams.splitOrderPayScene = "1";
            viewParams.showFaqPage = false;
            viewParams.windowParams = bVar.h;
            viewParams.appCustomExpand = bVar.d;
            viewParams.viewEventListener = bVar.f;
            viewParams.clientInfoExpand = bVar.e;
            viewParams.targetAmount = (int) bVar.c.c();
            ahcVar.a(activity, bVar.c, null, null, PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG, viewParams, iPayCallback);
        }
    }
}
