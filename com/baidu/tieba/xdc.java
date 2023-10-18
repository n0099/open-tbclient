package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.agc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.NetworkUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayStartInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.PayViewState;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public class xdc implements rcc, vcc {
    public static /* synthetic */ Interceptable $ic;
    public static Gson u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public PayUIKitConfig c;
    public AppPayServiceListener d;
    public mcc e;
    public String f;
    public scc g;
    public int h;
    public int i;
    public PayFlowType j;
    public PayDialogType k;
    public pcc l;
    public tcc m;
    public Handler n;
    public ufc o;
    public PayFinishInfo p;
    public boolean q;
    public ucc r;
    public PayFlowModel s;
    public IAppPayService t;

    /* loaded from: classes8.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ tfc c;
        public final /* synthetic */ agc.b d;
        public final /* synthetic */ IPayCallback e;
        public final /* synthetic */ xdc f;

        public a(xdc xdcVar, Activity activity, Dialog dialog, tfc tfcVar, agc.b bVar, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, dialog, tfcVar, bVar, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xdcVar;
            this.a = activity;
            this.b = dialog;
            this.c = tfcVar;
            this.d = bVar;
            this.e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, currencyChargeMessage) != null) {
                return;
            }
            this.f.P(currencyChargeMessage, this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ tfc c;
        public final /* synthetic */ xdc d;

        public b(xdc xdcVar, Activity activity, Dialog dialog, tfc tfcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, dialog, tfcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xdcVar;
            this.a = activity;
            this.b = dialog;
            this.c = tfcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !rfc.a.a(this.a)) {
                return;
            }
            this.d.S(this.b, this.c, false);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ int b;
        public final /* synthetic */ jec c;
        public final /* synthetic */ nec d;
        public final /* synthetic */ IPayCallback e;
        public final /* synthetic */ String f;
        public final /* synthetic */ agc.b g;
        public final /* synthetic */ PayCallBackBean h;
        public final /* synthetic */ Dialog i;
        public final /* synthetic */ xdc j;

        public c(xdc xdcVar, Activity activity, int i, jec jecVar, nec necVar, IPayCallback iPayCallback, String str, agc.b bVar, PayCallBackBean payCallBackBean, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, Integer.valueOf(i), jecVar, necVar, iPayCallback, str, bVar, payCallBackBean, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = xdcVar;
            this.a = activity;
            this.b = i;
            this.c = jecVar;
            this.d = necVar;
            this.e = iPayCallback;
            this.f = str;
            this.g = bVar;
            this.h = payCallBackBean;
            this.i = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.r.release();
                this.j.l.d(null);
                if (!rfc.a.a(this.a)) {
                    return;
                }
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                cVar.a = bVar;
                bVar.a(this.b);
                cVar.e = this.c;
                cVar.g = this.d;
                cVar.h = this.e;
                cVar.i = this.j.q;
                cVar.a.b(this.f);
                cVar.j = this.g;
                cVar.f = this.j.j;
                cVar.l = this.h;
                agc.b bVar2 = this.g;
                if (bVar2 != null) {
                    cVar.b = bVar2.f;
                    cVar.k = bVar2.j;
                }
                this.j.V(this.a, cVar);
                cfc.a(this.i, PayDialogType.PAY_WAY_DIALOG);
                this.j.N(this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ nec b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ tfc d;
        public final /* synthetic */ xdc e;

        public d(xdc xdcVar, Activity activity, nec necVar, Dialog dialog, tfc tfcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, necVar, dialog, tfcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xdcVar;
            this.a = activity;
            this.b = necVar;
            this.c = dialog;
            this.d = tfcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.r.release();
                this.e.l.d(null);
                if (!rfc.a.a(this.a)) {
                    return;
                }
                PayType payType = this.b.a;
                if (payType == null) {
                    RLog.error(this.e.a, "updateViewOnPaySuccess error payType null", new Object[0]);
                } else if (kfc.d(payType.getChannel(), this.b.a.getMethod())) {
                    String str = this.e.a;
                    RLog.info(str, "updateViewOnPaySuccess but h5 not loadding mTraceId:" + this.e.f);
                    this.e.f = null;
                } else {
                    this.e.S(this.c, this.d, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ tfc c;
        public final /* synthetic */ xdc d;

        public e(xdc xdcVar, Activity activity, Dialog dialog, tfc tfcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, dialog, tfcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xdcVar;
            this.a = activity;
            this.b = dialog;
            this.c = tfcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !rfc.a.a(this.a)) {
                return;
            }
            this.d.S(this.b, this.c, true);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ tfc c;
        public final /* synthetic */ xdc d;

        public f(xdc xdcVar, Activity activity, Dialog dialog, tfc tfcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xdcVar, activity, dialog, tfcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xdcVar;
            this.a = activity;
            this.b = dialog;
            this.c = tfcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !rfc.a.a(this.a)) {
                return;
            }
            this.d.S(this.b, this.c, false);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948297970, "Lcom/baidu/tieba/xdc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948297970, "Lcom/baidu/tieba/xdc;");
                return;
            }
        }
        u = new Gson();
    }

    @Override // com.baidu.tieba.rcc
    public ucc h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r;
        }
        return (ucc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rcc
    public PayDialogType v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.k;
        }
        return (PayDialogType) invokeV.objValue;
    }

    public xdc(Context context, int i, int i2, mcc mccVar, scc sccVar, pcc pccVar, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig, PayFlowModel payFlowModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), mccVar, sccVar, pccVar, payFlowType, payUIKitConfig, payFlowModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "PayFlowHandlerImpl";
        this.k = PayDialogType.PAY_NONE_DIALOG;
        this.n = new Handler(Looper.getMainLooper());
        this.o = null;
        this.p = null;
        this.q = false;
        this.a += "@" + hashCode();
        this.b = context;
        this.h = i;
        this.i = i2;
        this.e = mccVar;
        this.c = payUIKitConfig;
        this.g = sccVar;
        this.l = pccVar;
        this.j = payFlowType;
        this.r = new bec(sccVar, payFlowType, this, i, i2, payUIKitConfig);
        this.m = new aec(this.h, this.i, this.g, this.c, payFlowType, this);
        this.s = payFlowModel;
        this.t = wec.b(this.h, this.i);
        RLog.info(this.a, "create PayFlowHandlerImpl: " + this + " mPayFlowType:" + this.j.name() + " mPayFlowModel:" + this.s + " mAppPayService:" + this.t);
    }

    public final void U(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.n.post(runnable);
            }
        }
    }

    public final void Z(PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, payDialogType) == null) {
            if (payDialogType == PayDialogType.PAY_AMOUNT_DIALOG || payDialogType == PayDialogType.PAY_INPUT_DIALOG || payDialogType == PayDialogType.PAY_WAY_DIALOG || payDialogType == PayDialogType.PAY_SPLIT_ORDER_DIALOG) {
                l(dfc.b(payDialogType, 1, "", this.q));
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void l(PayFinishInfo payFinishInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, payFinishInfo) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFinishState old:" + this.p + " new:" + payFinishInfo);
            this.p = payFinishInfo;
        }
    }

    @Override // com.baidu.tieba.rcc
    public void u(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, activity) == null) {
            afc.a(this.j, this.h, this.i, this.c, activity, lec.c(this.c), "帮助中心");
        }
    }

    @Override // com.baidu.tieba.rcc
    public void e(int i, String str, PayCallBackBean payCallBackBean) {
        mcc mccVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048603, this, i, str, payCallBackBean) == null) && (mccVar = this.e) != null) {
            mccVar.a(i, str, payCallBackBean);
        }
    }

    @Override // com.baidu.tieba.rcc
    public boolean s(Activity activity, agc agcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, activity, agcVar, absViewEventHandler)) == null) {
            if (this.l.e(activity, new hdc(agcVar), this, absViewEventHandler)) {
                RLog.info(this.a, "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.rcc
    public boolean c(Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, activity, absViewEventHandler)) == null) {
            if (this.l.b(activity, new jdc(), this, absViewEventHandler)) {
                RLog.info(this.a, "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.rcc
    public void q(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, activity, str) == null) {
            afc.a(this.j, this.h, this.i, this.c, activity, lec.a(str, this.c, 0), "");
        }
    }

    public final void G(boolean z) {
        PayFlowModel payFlowModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String str = this.a;
            RLog.info(str, "checkIfNotifyFinishInfo innerRelease:" + z + " mPayFinishInfo:" + this.p);
            if (!z && this.p != null && (payFlowModel = this.s) != null) {
                if (payFlowModel.viewEventListener != null) {
                    RLog.info(this.a, "checkIfNotifyFinishInfo notifyPayFinishState");
                    Q(this.s.viewEventListener);
                    return;
                }
                return;
            }
            RLog.info(this.a, "checkIfNotifyFinishInfo ignore");
        }
    }

    public final void a0(nec necVar) {
        PayType payType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, necVar) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFrequencyState payWay:" + necVar);
            if (necVar != null && (payType = necVar.a) != null && payType == PayType.ALI_PAY) {
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.h, this.i);
                if (uIKit == null) {
                    RLog.error(this.a, "updatePayFrequencyState error payUIKit null", new Object[0]);
                } else {
                    uIKit.setIsPayFrequency(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            String str = this.a;
            RLog.info(str, "clear:" + this + " innerRelease:" + z + " mPayFlowModel:" + this.s);
            G(z);
            Y();
            this.o = null;
            this.r.release();
            this.k = PayDialogType.PAY_NONE_DIALOG;
            this.p = null;
            this.s = null;
            this.q = false;
        }
    }

    public final boolean H(Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, absViewEventHandler)) == null) {
            if (NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                return true;
            }
            Toast.makeText(activity, "网络不给力,请稍后重试(c)", 1).show();
            RLog.error(this.a, "showPayAmountDialog fail: network error", new Object[0]);
            l(dfc.a(PayDialogType.PAY_AMOUNT_DIALOG, ErrorCode.NETWORK_NO_AVAILABLE, "展示支付面板失败,网络不通无法请求支付服务"));
            g(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void N(jec jecVar, nec necVar) {
        int i;
        double d2;
        PayType payType;
        String str;
        String str2;
        ProductInfo productInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jecVar, necVar) == null) {
            if (jecVar != null && (productInfo = jecVar.a) != null) {
                i = productInfo.cid;
            } else {
                i = 0;
            }
            if (jecVar != null) {
                d2 = jecVar.a();
            } else {
                d2 = 0.0d;
            }
            double d3 = d2;
            if (necVar != null) {
                payType = necVar.a;
            } else {
                payType = null;
            }
            if (payType == null) {
                str = "error";
            } else {
                str = payType.getChannel();
            }
            if (payType == null) {
                str2 = "error";
            } else {
                str2 = payType.getMethod();
            }
            M(str, str2, String.valueOf(i), d3);
        }
    }

    @Override // com.baidu.tieba.rcc
    public void r(ufc ufcVar, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, ufcVar, dialog) == null) {
            String str = this.a;
            RLog.info(str, "refreshCurrentVisibleBottomPayView payView:" + ufcVar + " payDialog:" + dialog);
            if (dialog != null) {
                ufcVar.attachWindow(dialog.getWindow());
            }
            this.o = ufcVar;
        }
    }

    public final Dialog I(Activity activity, IYYPayAmountView iYYPayAmountView, AbsViewEventHandler absViewEventHandler, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, iYYPayAmountView, absViewEventHandler, viewParams)) == null) {
            RLog.info(this.a, "createPayAmountDialog");
            String string = activity.getString(R.string.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            m(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return igc.b.d(activity, string, iYYPayAmountView.getContentView(), new edc(this.h, this.i, this, absViewEventHandler, iYYPayAmountView), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG, this.j, this.c);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    public final void M(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("payChannel", str);
            hashMap.put("payMethod", str2);
            hashMap.put("charge_id", str3);
            hashMap.put(PayUiEventContent.AMOUNT, String.valueOf(d2));
            qec.b(this.h, this.i, this.j, 109, hashMap);
        }
    }

    @Override // com.baidu.tieba.vcc
    public void o(Activity activity, nec necVar, Dialog dialog, tfc tfcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048613, this, activity, necVar, dialog, tfcVar) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPaySuccess mPayFlowType" + this.j.name());
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else {
                U(new d(this, activity, necVar, dialog, tfcVar));
            }
        }
    }

    public final Dialog J(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info(this.a, "createPayResultDialog");
            if (cVar != null) {
                absViewEventHandler = cVar.b;
            } else {
                absViewEventHandler = null;
            }
            AbsViewEventHandler absViewEventHandler2 = absViewEventHandler;
            m(absViewEventHandler2, PayDialogType.PAY_RESULT_DIALOG);
            return igc.b.e(activity, activity.getString(R.string.pay_ui_dialog_pay_title), iYYPayResultView.getContentView(), new mdc(absViewEventHandler2, this, activity, iYYPayResultView), absViewEventHandler2, PayDialogType.PAY_RESULT_DIALOG, this.j, this.c, true);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void S(Dialog dialog, tfc tfcVar, boolean z) {
        PayViewState payViewState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, dialog, tfcVar, z) == null) {
            String str = this.a;
            RLog.info(str, "refreshWorkingPayView isLoading=" + z);
            if (z) {
                payViewState = PayViewState.WAITING_VIEW_STATE;
            } else {
                payViewState = PayViewState.SELECTING_VIEW_STATE;
            }
            if (tfcVar != null) {
                tfcVar.setViewState(payViewState);
            }
            if (z) {
                igc.b.f(dialog);
            } else {
                igc.b.b(dialog);
            }
        }
    }

    public final Dialog K(Activity activity, agc agcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, agcVar, absViewEventHandler)) == null) {
            RLog.info(this.a, "createPayWayDialog");
            m(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return igc.b.d(activity, activity.getString(R.string.pay_ui_dialog_pay_title), agcVar.getContentView(), new sdc(this.h, this.i, activity, agcVar, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG, this.j, this.c);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final boolean L(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, iPayCallback, viewParams)) == null) {
            if (viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_QUICK_PAY) {
                z = true;
            } else {
                z = false;
            }
            String str = this.a;
            RLog.info(str, "fastShowPayWayDialog isQuickPay:" + z);
            if (!z) {
                return false;
            }
            this.q = true;
            if (viewParams.targetAmount > 5.0E7d) {
                viewParams.targetAmount = 50000000;
            }
            t(activity, wec.a(viewParams.targetAmount, this.c), null, null, viewParams, iPayCallback);
            String str2 = this.a;
            RLog.info(str2, "fastShowPayWayDialog targetAmount:" + viewParams.targetAmount);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean c0(CurrencyChargeMessage currencyChargeMessage, Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, currencyChargeMessage, activity, absViewEventHandler)) == null) {
            if (currencyChargeMessage.status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
            List<SplitRecordItem> list = currencyChargeMessage.splitRecordItemList;
            if (list != null && !list.isEmpty()) {
                return true;
            }
            boolean c2 = c(activity, absViewEventHandler);
            String str2 = this.a;
            RLog.info(str2, "willShowPayResultView showPayGiftDialog:" + c2);
            String str3 = null;
            if (currencyChargeMessage.currencyAmount > 0) {
                str3 = new DecimalFormat("#.##").format(currencyChargeMessage.currencyAmount / 100.0d);
            }
            if (str3 != null) {
                if (currencyChargeMessage.currencyType == 4) {
                    str = "Y币";
                } else {
                    str = "";
                }
                Toast.makeText(activity, "成功充值" + str3 + str, 1).show();
            }
            O(currencyChargeMessage);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.rcc
    public void d(Activity activity, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, activity, bVar, iPayCallback) == null) {
            String str = this.a;
            RLog.info(str, "pay_dialog_show_flow:showPayWayDialog viewParams:" + bVar);
            if (this.t == null) {
                RLog.error(this.a, "showPayWayDialog error mAppPayService null", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new agc.b();
            }
            agc.b bVar2 = bVar;
            bVar2.g = this.j;
            agc g = this.g.g(activity, bVar2, this.r);
            g.refreshView();
            if (bVar2 != null) {
                absViewEventHandler = bVar2.f;
            } else {
                absViewEventHandler = null;
            }
            Dialog K = K(activity, g, absViewEventHandler);
            g.setCallback(new tdc(activity, this.q, K, g, bVar2, iPayCallback, this));
            r(g, K);
        }
    }

    @Override // com.baidu.tieba.rcc
    public void j(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, activity, iPayCallback, viewParams) == null) {
            String str = this.a;
            RLog.info(str, "pay_dialog_show_flow:showPayAmountDialog viewParams:" + viewParams);
            if (viewParams == null) {
                viewParams = new IYYPayAmountView.ViewParams();
            }
            IYYPayAmountView.ViewParams viewParams2 = viewParams;
            viewParams2.payFlowType = this.j;
            if (viewParams2 != null) {
                absViewEventHandler = viewParams2.viewEventListener;
            } else {
                absViewEventHandler = null;
            }
            R(absViewEventHandler);
            if (!H(activity, absViewEventHandler) || L(activity, iPayCallback, viewParams2)) {
                return;
            }
            IYYPayAmountView a2 = this.g.a(activity, viewParams2, this.l);
            a2.refreshView();
            Dialog I = I(activity, a2, absViewEventHandler, viewParams2);
            a2.setCallback(new gdc(this.h, this.i, I, viewParams2, activity, iPayCallback, this, a2));
            r(a2, I);
        }
    }

    public final void O(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, currencyChargeMessage) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("payChannel", currencyChargeMessage.payChannel);
            hashMap.put("payMethod", currencyChargeMessage.payMethod);
            hashMap.put("charge_id", String.valueOf(currencyChargeMessage.cid));
            hashMap.put(PayUiEventContent.AMOUNT, String.valueOf(currencyChargeMessage.currencyAmount));
            qec.b(this.h, this.i, this.j, 108, hashMap);
        }
    }

    @Override // com.baidu.tieba.rcc
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, windowParams) == null) {
            String str = this.a;
            RLog.info(str, "refreshWindow mVisibleBottomPayView:" + this.o + " windowParams:" + windowParams);
            ufc ufcVar = this.o;
            if (ufcVar != null && windowParams != null) {
                ufcVar.refreshWindow(windowParams);
            }
        }
    }

    public final void P(CurrencyChargeMessage currencyChargeMessage, Activity activity, Dialog dialog, tfc tfcVar, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{currencyChargeMessage, activity, dialog, tfcVar, bVar, iPayCallback}) == null) {
            String str = currencyChargeMessage.traceid;
            String str2 = this.a;
            RLog.info(str2, "onCurrencyChargeMessage messgaeTraceId:" + str + " message:" + currencyChargeMessage.toString());
            if (!str.equals(this.f)) {
                String str3 = this.a;
                RLog.warn(str3, "messgaeTraceId not equal mTraceId:" + this.f + " messgaeTraceId:" + str);
                return;
            }
            boolean z = true;
            if (currencyChargeMessage.status != 1) {
                z = false;
            }
            this.l.f(currencyChargeMessage.giftBagsInfo);
            l(dfc.e(currencyChargeMessage.status, currencyChargeMessage.message));
            b0(activity, dialog, tfcVar, bVar, currencyChargeMessage, iPayCallback);
            X(currencyChargeMessage);
            if (iPayCallback != null) {
                if (z) {
                    iPayCallback.onSuccess(currencyChargeMessage, null);
                } else {
                    iPayCallback.onFail(currencyChargeMessage.status, "", null);
                }
            }
        }
    }

    public final void Q(AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, absViewEventHandler) == null) {
            if (absViewEventHandler == null) {
                RLog.info(this.a, "notifyPayFinishState but handler null");
                return;
            }
            String str = null;
            try {
                str = u.toJson(this.p);
            } catch (Throwable th) {
                String str2 = this.a;
                RLog.error(str2, "notifyPayFinishState error t:" + th, new Object[0]);
            }
            String str3 = this.a;
            RLog.info(str3, "onPayInfo notifyPayFinishState handler:" + absViewEventHandler + " state:" + this.p + " json:" + str);
            if (str != null) {
                absViewEventHandler.onPayInfo(2, str);
            }
        }
    }

    public final void R(AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, absViewEventHandler) == null) {
            if (absViewEventHandler == null) {
                RLog.info(this.a, "notifyPayStartState but handler null");
                return;
            }
            String str = null;
            try {
                str = u.toJson(new PayStartInfo(1, "支付流程开始"));
            } catch (Throwable th) {
                String str2 = this.a;
                RLog.error(str2, "notifyPayStartState error t:" + th, new Object[0]);
            }
            String str3 = this.a;
            RLog.info(str3, "onPayInfo notifyPayStartState handler:" + absViewEventHandler + " json:" + str);
            if (str != null) {
                absViewEventHandler.onPayInfo(1, str);
            }
        }
    }

    public final void X(CurrencyChargeMessage currencyChargeMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, currencyChargeMessage) == null) {
            boolean z = true;
            if (currencyChargeMessage.status != 1) {
                z = false;
            }
            if (!z) {
                String str2 = this.a;
                RLog.info(str2, "statisticOnCurrencyChargeMessage but pay fail status:" + currencyChargeMessage.status);
                return;
            }
            int i = currencyChargeMessage.cid;
            String str3 = currencyChargeMessage.payChannel;
            String str4 = currencyChargeMessage.payMethod;
            if (this.j == PayFlowType.WALLET_PAY_FLOW) {
                str = "14";
            } else {
                str = "7";
            }
            tec.b(this.h, currencyChargeMessage.usedChannel, str, str3, str4, String.valueOf(i));
            String str5 = this.a;
            RLog.info(str5, "statisticOnCurrencyChargeMessage payChannel:" + str3 + " payMethod:" + str4);
        }
    }

    public void T(Activity activity, Dialog dialog, tfc tfcVar, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048589, this, activity, dialog, tfcVar, bVar, iPayCallback) == null) {
            if (this.t == null) {
                RLog.error(this.a, "registerPayServiceListener error mAppPayService null", new Object[0]);
                return;
            }
            Y();
            a aVar = new a(this, activity, dialog, tfcVar, bVar, iPayCallback);
            this.d = aVar;
            this.t.addPayListener(aVar);
            String str = this.a;
            RLog.info(str, "registerPayServiceListener mPayServiceListener:" + this.d);
        }
    }

    @Override // com.baidu.tieba.rcc
    public void n(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048612, this, activity, list, str, viewParams, iPayCallback) == null) {
            String str2 = this.a;
            RLog.info(str2, "pay_dialog_show_flow:showInputDialog viewParams:" + viewParams);
            this.r.release();
            if (viewParams != null) {
                absViewEventHandler = viewParams.viewEventListener;
            } else {
                absViewEventHandler = null;
            }
            AbsViewEventHandler absViewEventHandler2 = absViewEventHandler;
            m(absViewEventHandler2, PayDialogType.PAY_INPUT_DIALOG);
            mgc.a.f(activity, new fdc(this, absViewEventHandler2, this.c, activity, list, viewParams, str, iPayCallback), absViewEventHandler2, PayDialogType.PAY_INPUT_DIALOG, this.c, this.j);
        }
    }

    public void V(Activity activity, IYYPayResultView.c cVar) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, activity, cVar) == null) {
            RLog.info(this.a, "pay_dialog_show_flow:showPayResultDialog viewParams:" + cVar);
            IPayCallback<CurrencyChargeMessage> iPayCallback = null;
            if (cVar != null) {
                absViewEventHandler = cVar.b;
            } else {
                absViewEventHandler = null;
            }
            if (cVar != null) {
                iPayCallback = cVar.h;
            }
            IPayCallback<CurrencyChargeMessage> iPayCallback2 = iPayCallback;
            IYYPayResultView e2 = this.g.e(activity, cVar, this.l);
            Dialog J = J(activity, cVar, e2);
            e2.setCallback(new ndc(activity, e2, absViewEventHandler, J, this, iPayCallback2, cVar));
            r(e2, J);
        }
    }

    @Override // com.baidu.tieba.rcc
    public void g(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, cancelType, absViewEventHandler) == null) {
            if (cancelType != CancelType.BUTTOM_AREA_CLICK && cancelType != CancelType.EMPTY_AREA_CLICK && cancelType != CancelType.ON_DIALOG_CANCEL && cancelType != CancelType.ON_START_SHOW_FAIL) {
                z = false;
            } else {
                z = true;
            }
            String str = this.a;
            RLog.info(str, "checkNotifyViewFlowClose cancelType:" + cancelType.name() + " shouldNotifyPayFlowChange:" + z);
            if (z) {
                Q(absViewEventHandler);
                m(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
                Y();
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void m(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, absViewEventHandler, payDialogType) == null) {
            if (payDialogType != null) {
                str = payDialogType.name();
            } else {
                str = StringUtil.NULL_STRING;
            }
            String str2 = this.a;
            RLog.info(str2, "notifyPayFlowChange payDialogType:" + str);
            Z(payDialogType);
            this.k = payDialogType;
            dec.c(this.h, this.i, this.j, payDialogType);
            if (absViewEventHandler != null && payDialogType != null) {
                absViewEventHandler.onViewStateChange(payDialogType);
            } else {
                RLog.debug(this.a, "notifyPayFlowChange null");
            }
        }
    }

    public final void W(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, tfc tfcVar, agc.b bVar2, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        List<SplitRecordItem> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, tfcVar, bVar2, iPayCallback}) == null) {
            if (kfc.d(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                S(dialog, tfcVar, false);
                return;
            }
            cfc.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.a = bVar;
            cVar.b = bVar2.f;
            cVar.c = bVar2.h;
            cVar.h = iPayCallback;
            cVar.i = this.q;
            if (currencyChargeMessage != null) {
                list = currencyChargeMessage.splitRecordItemList;
            } else {
                list = null;
            }
            cVar.d = list;
            cVar.j = bVar2;
            cVar.k = bVar2.j;
            cVar.f = this.j;
            V(activity, cVar);
            if (currencyChargeMessage != null && currencyChargeMessage.status != 1) {
                M(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod, String.valueOf(currencyChargeMessage.cid), currencyChargeMessage.currencyAmount);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            String str = this.a;
            RLog.info(str, "unregisterPayServiceListener mPayServiceListener:" + this.d + " mTraceId:" + this.f);
            this.f = null;
            IAppPayService iAppPayService = this.t;
            if (iAppPayService == null) {
                RLog.error(this.a, "unregisterPayServiceListener error mAppPayService null", new Object[0]);
                return;
            }
            AppPayServiceListener appPayServiceListener = this.d;
            if (appPayServiceListener != null) {
                iAppPayService.removePayListener(appPayServiceListener);
                this.d = null;
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void a(Activity activity, jec jecVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{activity, jecVar, list, str, paySplitOrderViewSource, viewParams, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "prepareShowSplitOrderDialog viewParams:" + viewParams);
            this.r.a(activity, jecVar, list, str, paySplitOrderViewSource, viewParams, iPayCallback);
        }
    }

    public void b0(Activity activity, Dialog dialog, tfc tfcVar, agc.b bVar, CurrencyChargeMessage currencyChargeMessage, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        IYYPayResultView.Result result;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{activity, dialog, tfcVar, bVar, currencyChargeMessage, iPayCallback}) == null) && rfc.a.a(activity)) {
            if (currencyChargeMessage.status == 1) {
                result = IYYPayResultView.Result.PAY_SUUCESS;
            } else {
                result = IYYPayResultView.Result.PAY_FAIL;
            }
            IYYPayResultView.b bVar2 = new IYYPayResultView.b(result, currencyChargeMessage);
            if (c0(currencyChargeMessage, activity, bVar.f)) {
                W(activity, currencyChargeMessage, dialog, bVar2, tfcVar, bVar, iPayCallback);
            } else {
                cfc.b(dialog, PayDialogType.PAY_WAY_DIALOG);
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void t(Activity activity, jec jecVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{activity, jecVar, list, str, viewParams, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "showPayWayDialog IYYPayAmountView.ViewParams:" + viewParams);
            d(activity, lfc.a(jecVar, list, str, viewParams), iPayCallback);
        }
    }

    @Override // com.baidu.tieba.vcc
    public void f(Activity activity, Dialog dialog, tfc tfcVar, PurchaseStatus purchaseStatus) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, activity, dialog, tfcVar, purchaseStatus) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayStatus  mPayFlowType" + this.j.name());
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
                return;
            }
            int i = 1;
            if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                l(dfc.d(1, "开始下单"));
                U(new e(this, activity, dialog, tfcVar));
            } else if ((purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_SUCCESS) || purchaseStatus == PurchaseStatus.ORDER_FAIL) {
                if (purchaseStatus != PurchaseStatus.ORDER_SUCCESS) {
                    i = -1;
                }
                if (purchaseStatus == PurchaseStatus.ORDER_SUCCESS) {
                    str = "下单成功";
                } else {
                    str = " 下单失败";
                }
                l(dfc.c(i, str));
                U(new f(this, activity, dialog, tfcVar));
            }
        }
    }

    @Override // com.baidu.tieba.vcc
    public void i(int i, String str, Activity activity, Dialog dialog, tfc tfcVar, agc.b bVar, jec jecVar, nec necVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), str, activity, dialog, tfcVar, bVar, jecVar, necVar, payCallBackBean, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayFail mPayFlowType" + this.j.name() + " payCallBackBean:" + payCallBackBean);
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
                return;
            }
            l(dfc.e(i, str));
            if (i == PayStatus.CANCEL.getCode()) {
                String str3 = this.a;
                RLog.info(str3, "updateViewOnPayFail 用户取消支付 code:" + i);
                U(new b(this, activity, dialog, tfcVar));
                return;
            }
            U(new c(this, activity, i, jecVar, necVar, iPayCallback, str, bVar, payCallBackBean, dialog));
        }
    }

    @Override // com.baidu.tieba.rcc
    public void k(Activity activity, nec necVar, jec jecVar, Dialog dialog, tfc tfcVar, AppCustomExpand appCustomExpand, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Map<String, String> map;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{activity, necVar, jecVar, dialog, tfcVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, " requestPayInternal viewParams:" + bVar);
            T(activity, dialog, tfcVar, bVar, iPayCallback);
            ldc ldcVar = new ldc(this.h, this.i, iPayCallback, activity, dialog, tfcVar, this, necVar, bVar, this, jecVar);
            this.f = TraceIdUtil.newTraceId();
            if (bVar != null) {
                map = bVar.e;
            } else {
                map = null;
            }
            String str2 = this.a;
            RLog.info(str2, " requestPayInternal new mTraceId:" + this.f + " clientInfoExpand:" + map);
            PayType payType = necVar.a;
            if (payType != PayType.DXM_PAY_KJ && payType != PayType.UNION_PAY && payType != PayType.DXM_PAY_H5) {
                b2 = "";
            } else {
                b2 = lec.b(this.c);
            }
            String str3 = b2;
            a0(necVar);
            qbc yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.h, this.i);
            if (yYPayMiddleService != null) {
                yYPayMiddleService.c(activity, this.j, necVar.a, jecVar.a, appCustomExpand, map, ldcVar, this.f, str3, jecVar.b());
            } else {
                RLog.error(this.a, " requestPayInternal error yyPayMiddleService null", new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.rcc
    public void p(Activity activity, jec jecVar, nec necVar, Dialog dialog, tfc tfcVar, AppCustomExpand appCustomExpand, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{activity, jecVar, necVar, dialog, tfcVar, appCustomExpand, bVar, iPayCallback}) == null) {
            if (bVar != null) {
                absViewEventHandler = bVar.f;
            } else {
                absViewEventHandler = null;
            }
            m(absViewEventHandler, PayDialogType.PAY_SIGN_DIALOG);
            this.m.a(activity, jecVar, necVar, dialog, tfcVar, appCustomExpand, bVar, iPayCallback);
        }
    }
}
