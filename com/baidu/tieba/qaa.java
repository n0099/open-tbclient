package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class qaa implements k9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public PayUIKitConfig e;
    public y8a f;
    public d9a g;
    public SparseArray<Integer> h;
    public SparseArray<c9a> i;
    public SparseArray<PayFlowModel> j;

    public qaa(Context context, int i, int i2, y8a y8aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), y8aVar, payUIKitConfig};
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
        this.f = y8aVar;
        this.e = payUIKitConfig;
        this.g = new jaa(i, i2, payUIKitConfig);
        this.h.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.h.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void a(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, payFlowType) == null) {
            synchronized (this) {
                c9a c9aVar = this.i.get(payFlowType.getTypeId());
                if (c9aVar != null) {
                    c9aVar.release();
                }
                this.i.remove(payFlowType.getTypeId());
                this.j.remove(payFlowType.getTypeId());
                n("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + c9aVar);
            }
        }
    }

    public final synchronized void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                int size = this.i.size();
                int size2 = this.j.size();
                String str2 = this.a;
                RLog.info(str2, ("reportPayFlowMapSize from: " + str) + " payFlowHanderMapSize:" + size + " payFlowModelMapSize:" + size2);
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void b(Activity activity, IYYPayWayView.b bVar, taa taaVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, taaVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayChannelDialog viewParams:" + bVar + " openPayParams:" + taaVar);
                if (bVar == null) {
                    bVar = new IYYPayWayView.b();
                }
                PayFlowModel payFlowModel = this.j.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.d = payFlowModel.appCustomExpand;
                    bVar.g = payFlowModel.viewEventListener;
                    bVar.e = payFlowModel.clientInfoExpand;
                }
                String str2 = this.a;
                RLog.info(str2, "startPayChannelDialog payFlowModel:" + payFlowModel);
                c9a c9aVar = this.i.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (c9aVar == null) {
                    RLog.error(this.a, "startPayChannelDialog error walletPayFlowHandler null", new Object[0]);
                    return;
                }
                c9aVar.e().release();
                uaa uaaVar = bVar.c;
                if (uaaVar != null && taaVar != null && taaVar.a == 1 && rba.c(taaVar.b, (int) uaaVar.c())) {
                    o(c9aVar, activity, bVar, iPayCallback);
                } else {
                    c9aVar.b(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                g(activity, null);
            }
        }
    }

    @Override // com.baidu.tieba.a9a
    public synchronized PayFlowModel h(PayFlowType payFlowType) {
        InterceptResult invokeL;
        PayFlowModel payFlowModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, payFlowType)) == null) {
            synchronized (this) {
                payFlowModel = this.j.get(payFlowType.getTypeId());
            }
            return payFlowModel;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k9a
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

    @Override // com.baidu.tieba.k9a
    public synchronized void j(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                int i = intValue - 1;
                RLog.info(this.a, "payActivityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCountt:" + i);
                this.h.put(payFlowType.getTypeId(), Integer.valueOf(i));
            }
        }
    }

    public final void p(PayFlowType payFlowType, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, payFlowType, viewParams) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFlowModel payFlowType :" + payFlowType + " viewParams:" + viewParams);
            if (viewParams == null) {
                RLog.info(this.a, "updatePayFlowModel with value null");
                this.j.put(payFlowType.getTypeId(), null);
                return;
            }
            PayFlowModel k = k(viewParams);
            String str2 = this.a;
            RLog.info(str2, "updatePayFlowModel payFlowModel :" + k);
            if (k != null) {
                this.j.put(payFlowType.getTypeId(), k);
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (i(PayFlowType.WALLET_PAY_FLOW) && i(PayFlowType.DIOALOG_PAY_FLOW)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RLog.info(this.a, "releaseAllPayFlow");
            a(PayFlowType.WALLET_PAY_FLOW);
            a(PayFlowType.DIOALOG_PAY_FLOW);
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                RLog.info(this.a, "release()");
                m();
                this.i.clear();
                this.j.clear();
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                l(PayFlowType.DIOALOG_PAY_FLOW);
                p(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                oaa.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                iaa iaaVar = new iaa(this.d, this.b, this.c, this.f, this.g, new gaa(PayFlowType.DIOALOG_PAY_FLOW, this.g), PayFlowType.DIOALOG_PAY_FLOW, this.e);
                this.i.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), iaaVar);
                n("startPayDialog showPayAmountDialog");
                iaaVar.g(activity, iPayCallback, viewParams);
                aba.b(this.b, this.c, PayUIEventType.purchaseshow);
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized void g(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                l(PayFlowType.WALLET_PAY_FLOW);
                p(PayFlowType.WALLET_PAY_FLOW, viewParams);
                oaa.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.i.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new iaa(this.d, this.b, this.c, this.f, this.g, new gaa(PayFlowType.WALLET_PAY_FLOW, this.g), PayFlowType.WALLET_PAY_FLOW, this.e));
                String e = vaa.e(this.e);
                n("startWalletActivity walletUrl:" + wba.a(e));
                iba.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.e, activity, e, "我的钱包");
                aba.b(this.b, this.c, PayUIEventType.walletshow);
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public synchronized boolean i(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, payFlowType)) == null) {
            synchronized (this) {
                c9a c9aVar = this.i.get(payFlowType.getTypeId());
                boolean z = true;
                if (c9aVar == null) {
                    String str = this.a;
                    RLog.info(str, "isReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (c9aVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.h.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "isReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + c9aVar.v() + " release:" + z);
                    return z;
                } else {
                    int intValue2 = this.h.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || c9aVar.v() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "isReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + c9aVar.v() + " release:" + z);
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public final PayFlowModel k(IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewParams)) == null) {
            if (viewParams != null) {
                PayFlowModel payFlowModel = new PayFlowModel();
                payFlowModel.appCustomExpand = viewParams.appCustomExpand;
                payFlowModel.viewEventListener = viewParams.viewEventListener;
                payFlowModel.clientInfoExpand = viewParams.clientInfoExpand;
                String str = this.a;
                RLog.info(str, "createPayFlowModel PayFlowModel:" + payFlowModel);
                return payFlowModel;
            }
            RLog.info(this.a, "createPayFlowModel but viewParams null");
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public void l(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, payFlowType) == null) {
            String str = this.a;
            RLog.info(str, "innerReleasePayFlow payFlowType:" + payFlowType);
            a(payFlowType);
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                oba.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                oba.b(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.k9a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, windowParams) == null) {
            c9a c9aVar = this.i.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId());
            if (c9aVar != null && windowParams != null) {
                c9aVar.refreshWindow(windowParams);
            }
            String str = this.a;
            RLog.info(str, "refreshWindow windowParams:" + windowParams + " handler:" + c9aVar);
        }
    }

    public final void o(c9a c9aVar, Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, c9aVar, activity, bVar, iPayCallback) == null) {
            String str = this.a;
            RLog.info(str, "showPaySplitOrderView viewParams:" + bVar);
            IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
            viewParams.splitOrderPayScene = "1";
            viewParams.showFaqPage = false;
            viewParams.windowParams = bVar.i;
            viewParams.appCustomExpand = bVar.d;
            viewParams.viewEventListener = bVar.g;
            viewParams.clientInfoExpand = bVar.e;
            viewParams.targetAmount = (int) bVar.c.c();
            c9aVar.a(activity, bVar.c, null, null, PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG, viewParams, iPayCallback);
        }
    }
}
