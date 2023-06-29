package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n2c;
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
public class s0c implements mzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public PayUIKitConfig e;
    public zyb f;
    public fzb g;
    public SparseArray<Integer> h;
    public SparseArray<ezb> i;
    public SparseArray<PayFlowModel> j;

    public s0c(Context context, int i, int i2, zyb zybVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), zybVar, payUIKitConfig};
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
        this.f = zybVar;
        this.e = payUIKitConfig;
        this.g = new l0c(i, i2, payUIKitConfig);
        this.h.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.h.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.baidu.tieba.mzb
    public synchronized void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // com.baidu.tieba.bzb
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

    @Override // com.baidu.tieba.mzb
    public void m(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            String str = this.a;
            RLog.info(str, "startWebPayActivity currentActivity:" + activity);
            p(activity, null, y0c.e(this.e), "红宝石充值");
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

    @Override // com.baidu.tieba.mzb
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
                t1c.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                t1c.b(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.mzb
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, windowParams) == null) {
            ezb ezbVar = this.i.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId());
            if (ezbVar != null && windowParams != null) {
                ezbVar.refreshWindow(windowParams);
            }
            String str = this.a;
            RLog.info(str, "refreshWindow windowParams:" + windowParams + " handler:" + ezbVar);
        }
    }

    @Override // com.baidu.tieba.mzb
    public synchronized void c(PayFlowType payFlowType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, payFlowType, z) == null) {
            synchronized (this) {
                ezb ezbVar = this.i.get(payFlowType.getTypeId());
                if (ezbVar != null) {
                    ezbVar.b(z);
                }
                this.i.remove(payFlowType.getTypeId());
                this.j.remove(payFlowType.getTypeId());
                r("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + ezbVar + " innerRelease:" + z);
            }
        }
    }

    @Override // com.baidu.tieba.mzb
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

    @Override // com.baidu.tieba.mzb
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

    @Override // com.baidu.tieba.mzb
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

    @Override // com.baidu.tieba.mzb
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
            ezb ezbVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
            if (ezbVar == null) {
                RLog.error(this.a, "innerPayAmountDialogForWeb error walletPayFlowHandler null", new Object[0]);
                return;
            }
            ezbVar.h().release();
            ezbVar.j(activity, iPayCallback, viewParams);
        }
    }

    @Override // com.baidu.tieba.mzb
    public synchronized void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                o(PayFlowType.DIOALOG_PAY_FLOW);
                t(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                q0c.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                k0c k0cVar = new k0c(this.d, this.b, this.c, this.f, this.g, new i0c(PayFlowType.DIOALOG_PAY_FLOW, this.g), PayFlowType.DIOALOG_PAY_FLOW, this.e, this.j.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId()));
                this.i.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), k0cVar);
                r("startPayDialog showPayAmountDialog");
                k0cVar.j(activity, iPayCallback, viewParams);
                f1c.b(this.b, this.c, PayUIEventType.purchaseshow);
            }
        }
    }

    @Override // com.baidu.tieba.mzb
    public synchronized void h(Activity activity, n2c.b bVar, v0c v0cVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, bVar, v0cVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "innerPayWayDialogForWeb viewParams:" + bVar + " openPayParams:" + v0cVar);
                if (bVar == null) {
                    bVar = new n2c.b();
                }
                PayFlowModel payFlowModel = this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.d = payFlowModel.appCustomExpand;
                    bVar.f = payFlowModel.viewEventListener;
                    bVar.e = payFlowModel.clientInfoExpand;
                }
                String str2 = this.a;
                RLog.info(str2, "innerPayWayDialogForWeb payFlowModel:" + payFlowModel);
                ezb ezbVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (ezbVar == null) {
                    RLog.error(this.a, "innerPayWayDialogForWeb error walletPayFlowHandler null", new Object[0]);
                    return;
                }
                ezbVar.h().release();
                w0c w0cVar = bVar.c;
                if (w0cVar != null && v0cVar != null && v0cVar.a == 1 && w1c.c(v0cVar.b, (int) w0cVar.c())) {
                    s(ezbVar, activity, bVar, iPayCallback);
                } else {
                    ezbVar.d(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mzb
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                p(activity, viewParams, y0c.f(this.e), "我的钱包");
            }
        }
    }

    @Override // com.baidu.tieba.mzb
    public synchronized boolean k(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, payFlowType)) == null) {
            synchronized (this) {
                ezb ezbVar = this.i.get(payFlowType.getTypeId());
                boolean z = true;
                if (ezbVar == null) {
                    String str = this.a;
                    RLog.info(str, "isReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (ezbVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "isReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + ezbVar.v() + " release:" + z);
                    return z;
                } else {
                    int intValue2 = this.h.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || ezbVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "isReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + ezbVar.v() + " release:" + z);
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
                q0c.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.i.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new k0c(this.d, this.b, this.c, this.f, this.g, new i0c(PayFlowType.WALLET_PAY_FLOW, this.g), PayFlowType.WALLET_PAY_FLOW, this.e, this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId())));
                r("innerStartWebActivity webUrl:" + d2c.a(str));
                n1c.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.e, activity, str, str2);
                f1c.b(this.b, this.c, PayUIEventType.walletshow);
            }
        }
    }

    public final void s(ezb ezbVar, Activity activity, n2c.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, ezbVar, activity, bVar, iPayCallback) == null) {
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
            ezbVar.a(activity, bVar.c, null, null, PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG, viewParams, iPayCallback);
        }
    }
}
