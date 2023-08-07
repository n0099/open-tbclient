package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nac;
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
public class s8c implements m7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public PayUIKitConfig e;
    public z6c f;
    public f7c g;
    public SparseArray<Integer> h;
    public SparseArray<e7c> i;
    public SparseArray<PayFlowModel> j;

    public s8c(Context context, int i, int i2, z6c z6cVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), z6cVar, payUIKitConfig};
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
        this.f = z6cVar;
        this.e = payUIKitConfig;
        this.g = new l8c(i, i2, payUIKitConfig);
        this.h.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.h.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.baidu.tieba.m7c
    public synchronized void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // com.baidu.tieba.b7c
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

    @Override // com.baidu.tieba.m7c
    public void m(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            String str = this.a;
            RLog.info(str, "startWebPayActivity currentActivity:" + activity);
            p(activity, null, y8c.e(this.e), "红宝石充值");
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

    @Override // com.baidu.tieba.m7c
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
                t9c.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                t9c.b(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.m7c
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, windowParams) == null) {
            e7c e7cVar = this.i.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId());
            if (e7cVar != null && windowParams != null) {
                e7cVar.refreshWindow(windowParams);
            }
            String str = this.a;
            RLog.info(str, "refreshWindow windowParams:" + windowParams + " handler:" + e7cVar);
        }
    }

    @Override // com.baidu.tieba.m7c
    public synchronized void c(PayFlowType payFlowType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, payFlowType, z) == null) {
            synchronized (this) {
                e7c e7cVar = this.i.get(payFlowType.getTypeId());
                if (e7cVar != null) {
                    e7cVar.b(z);
                }
                this.i.remove(payFlowType.getTypeId());
                this.j.remove(payFlowType.getTypeId());
                r("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + e7cVar + " innerRelease:" + z);
            }
        }
    }

    @Override // com.baidu.tieba.m7c
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

    @Override // com.baidu.tieba.m7c
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

    @Override // com.baidu.tieba.m7c
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

    @Override // com.baidu.tieba.m7c
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
            e7c e7cVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
            if (e7cVar == null) {
                RLog.error(this.a, "innerPayAmountDialogForWeb error walletPayFlowHandler null", new Object[0]);
                return;
            }
            e7cVar.h().release();
            e7cVar.j(activity, iPayCallback, viewParams);
        }
    }

    @Override // com.baidu.tieba.m7c
    public synchronized void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                o(PayFlowType.DIOALOG_PAY_FLOW);
                t(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                q8c.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                k8c k8cVar = new k8c(this.d, this.b, this.c, this.f, this.g, new i8c(PayFlowType.DIOALOG_PAY_FLOW, this.g), PayFlowType.DIOALOG_PAY_FLOW, this.e, this.j.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId()));
                this.i.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), k8cVar);
                r("startPayDialog showPayAmountDialog");
                k8cVar.j(activity, iPayCallback, viewParams);
                f9c.b(this.b, this.c, PayUIEventType.purchaseshow);
            }
        }
    }

    @Override // com.baidu.tieba.m7c
    public synchronized void h(Activity activity, nac.b bVar, v8c v8cVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, bVar, v8cVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "innerPayWayDialogForWeb viewParams:" + bVar + " openPayParams:" + v8cVar);
                if (bVar == null) {
                    bVar = new nac.b();
                }
                PayFlowModel payFlowModel = this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.d = payFlowModel.appCustomExpand;
                    bVar.f = payFlowModel.viewEventListener;
                    bVar.e = payFlowModel.clientInfoExpand;
                }
                String str2 = this.a;
                RLog.info(str2, "innerPayWayDialogForWeb payFlowModel:" + payFlowModel);
                e7c e7cVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (e7cVar == null) {
                    RLog.error(this.a, "innerPayWayDialogForWeb error walletPayFlowHandler null", new Object[0]);
                    return;
                }
                e7cVar.h().release();
                w8c w8cVar = bVar.c;
                if (w8cVar != null && v8cVar != null && v8cVar.a == 1 && w9c.c(v8cVar.b, (int) w8cVar.c())) {
                    s(e7cVar, activity, bVar, iPayCallback);
                } else {
                    e7cVar.d(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.baidu.tieba.m7c
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                p(activity, viewParams, y8c.f(this.e), "我的钱包");
            }
        }
    }

    @Override // com.baidu.tieba.m7c
    public synchronized boolean k(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, payFlowType)) == null) {
            synchronized (this) {
                e7c e7cVar = this.i.get(payFlowType.getTypeId());
                boolean z = true;
                if (e7cVar == null) {
                    String str = this.a;
                    RLog.info(str, "isReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (e7cVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "isReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + e7cVar.v() + " release:" + z);
                    return z;
                } else {
                    int intValue2 = this.h.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || e7cVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "isReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + e7cVar.v() + " release:" + z);
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
                q8c.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.i.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new k8c(this.d, this.b, this.c, this.f, this.g, new i8c(PayFlowType.WALLET_PAY_FLOW, this.g), PayFlowType.WALLET_PAY_FLOW, this.e, this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId())));
                r("innerStartWebActivity webUrl:" + dac.a(str));
                n9c.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.e, activity, str, str2);
                f9c.b(this.b, this.c, PayUIEventType.walletshow);
            }
        }
    }

    public final void s(e7c e7cVar, Activity activity, nac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, e7cVar, activity, bVar, iPayCallback) == null) {
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
            e7cVar.a(activity, bVar.c, null, null, PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG, viewParams, iPayCallback);
        }
    }
}
