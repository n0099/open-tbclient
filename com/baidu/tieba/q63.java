package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.hr2;
import com.baidu.tieba.jh4;
import com.baidu.tieba.o63;
import com.baidu.tieba.x52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class q63 extends s63 implements eg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<jh4.a> g;
    public int h;
    public boolean i;
    public final k63 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(q63 q63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ int b;

        public b(q63 q63Var, hr2 hr2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, hr2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hr2Var;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v0(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ q63 b;

        public c(q63 q63Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q63Var;
            this.a = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.b.d0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ q63 b;

        public d(q63 q63Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q63Var;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.b.k0().H());
                bundle.putString("mAppId", this.b.getAppId());
                if (q63.n) {
                    q63.q0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                a33 e = a33.e();
                c33 c33Var = new c33(17, bundle);
                c33Var.j(5000L);
                e.h(c33Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements hc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q63 a;

        public e(q63 q63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q63Var;
        }

        @Override // com.baidu.tieba.hc2
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = pz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.hc2
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = pz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (q63.n) {
                    q63.q0("预制包安装失败");
                }
                this.a.L0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.hc2
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) != null) {
                return;
            }
            this.a.h = 5;
            q63 q63Var = this.a;
            q63Var.b0("KEY_PKG_STATE", "event_pms_check_finish", q63Var.h);
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (q63.n) {
                q63.q0("预制包安装成功");
            }
            q63.p0(this.a.k0(), pMSAppInfo, false, false);
            this.a.N0(pMSAppInfo);
            this.a.J0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends q23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 c;
        public final /* synthetic */ q63 d;

        @Override // com.baidu.tieba.q23, com.baidu.tieba.p23
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        public f(q63 q63Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = q63Var;
            this.c = hr2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q23, com.baidu.tieba.r23, com.baidu.tieba.p23
        public void onEvent(@NonNull n23 n23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n23Var) == null) {
                Bundle a = n23Var.a();
                boolean z = false;
                if (a != null) {
                    z = a.getBoolean("isDownloading", false);
                }
                q63.p0(this.c, this.d.m, true, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q63 h;

        public g(q63 q63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = q63Var;
        }

        @Override // com.baidu.tieba.i92, com.baidu.tieba.fe4
        public void G(sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, sj4Var) != null) {
                return;
            }
            this.h.c = true;
            j63.K().p("event_pkg_download_start");
            super.G(sj4Var);
        }

        @Override // com.baidu.tieba.i92
        public void Q(@NonNull di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, di3Var) == null) {
                hi3.a().f(di3Var);
                this.h.B0(di3Var);
                this.h.u0(false);
            }
        }

        @Override // com.baidu.tieba.i92
        public void R() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.h.c = false;
            q63.p0(this.h.k0(), this.h.m, false, false);
            q63 q63Var = this.h;
            if (q63Var.i) {
                i = 3;
            } else {
                i = 4;
            }
            q63Var.h = i;
            this.h.J0(null);
            q63 q63Var2 = this.h;
            q63Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", q63Var2.h);
        }

        @Override // com.baidu.tieba.i92, com.baidu.tieba.fe4, com.baidu.tieba.ce4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.h.c = false;
            j63.K().p("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements t92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ mh4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ q63 d;

        public h(q63 q63Var, boolean z, mh4 mh4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, Boolean.valueOf(z), mh4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = q63Var;
            this.a = z;
            this.b = mh4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.t92
        public void a(di3 di3Var, boolean z) {
            long a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, di3Var, z) == null) {
                if (di3Var == null) {
                    a = 0;
                } else {
                    a = di3Var.a();
                }
                k32.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    dd3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, di3Var)) {
                    return;
                }
                this.d.c = false;
                j63.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                hi3.a().f(di3Var);
                if (z) {
                    q63 q63Var = this.d;
                    if (q63Var.i) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    q63Var.h = i;
                    q63 q63Var2 = this.d;
                    q63Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", q63Var2.h);
                    this.d.I0(di3Var);
                } else if (di3Var != null && di3Var.h() == 1020) {
                    this.d.B0(di3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (di3Var != null && di3Var.h() == 2203) {
                    k32.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                    if (if2.a().b(1) == 0) {
                        if2.a().c();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.t92
        public void b(PMSAppInfo pMSAppInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                k32.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    dd3.L("pkg_retry_success", "");
                }
                int i2 = 0;
                this.d.c = false;
                q63 q63Var = this.d;
                if (q63Var.e) {
                    i2 = 2;
                }
                q63Var.h = i2;
                q63 q63Var2 = this.d;
                if (!q63Var2.i) {
                    i = this.d.h;
                } else {
                    i = 1;
                }
                q63Var2.h = i;
                q63 q63Var3 = this.d;
                q63Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", q63Var3.h);
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.d.N0(pMSAppInfo);
                this.d.G0(null);
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements dl3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ q63 b;

        public i(q63 q63Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q63Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (q63.n) {
                    q63.q0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.b.N0(pMSAppInfo);
                this.b.c0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends l92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ q63 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(q63 q63Var, k63 k63Var, boolean z) {
            super(k63Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, k63Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k63) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = q63Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.l92, com.baidu.tieba.k92, com.baidu.tieba.fe4
        public void G(sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sj4Var) == null) {
                k32.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                j63.K().p("event_pkg_download_start");
                super.G(sj4Var);
            }
        }

        @Override // com.baidu.tieba.fe4, com.baidu.tieba.ce4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                k32.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                j63.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(nd3 nd3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q63.o0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l extends k23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.k23
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean j = ud4.j(string);
                boolean k = ud4.k(string);
                if (k23.e) {
                    Log.d("MDelegate-Delegation", "isDownloading: " + j + ", isInQueue: " + k);
                }
                this.d.putBoolean("isDownloading", (j || k) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043739, "Lcom/baidu/tieba/q63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043739, "Lcom/baidu/tieba/q63;");
                return;
            }
        }
        n = vm1.a;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gp2.O(this.j);
        }
    }

    public final Context g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SwanAppActivity w = this.j.w();
            if (w == null || w.isDestroyed()) {
                return rp2.c();
            }
            return w;
        }
        return (Context) invokeV.objValue;
    }

    public hr2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j.X();
        }
        return (hr2) invokeV.objValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return j63.K().q().X().c("property_web_mode_degrade");
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            synchronized (this) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean n0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                w0(true, null);
            }
        }
    }

    public synchronized void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this) {
                w0(false, null);
            }
        }
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q63(k63 k63Var) {
        super(k63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((n63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = -1;
        this.i = false;
        this.k = "";
        this.l = false;
        this.j = k63Var;
    }

    public final void J0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            G0(null);
            c03.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final di3 i0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            di3 di3Var = new di3();
            switch (i2) {
                case 10001:
                    di3Var.k(10L);
                    di3Var.i(2902L);
                    di3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    di3Var.k(10L);
                    di3Var.i(27L);
                    di3Var.f("category not match");
                    break;
                case 10003:
                    di3Var.k(10L);
                    di3Var.i(2107L);
                    di3Var.d("app forbiddeon");
                    break;
                case 10004:
                    di3Var.k(10L);
                    di3Var.i(48L);
                    di3Var.d("path forbiddeon");
                    break;
            }
            return di3Var;
        }
        return (di3) invokeI.objValue;
    }

    public static void q0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final void I0(di3 di3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, di3Var) == null) && G0(di3Var)) {
            ld3 ld3Var = new ld3();
            ld3Var.p(di3Var);
            ld3Var.r(k0());
            dd3.R(ld3Var);
        }
    }

    public void K0(Set<jh4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public void N0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.X().d1(pMSAppInfo);
            if (l0()) {
                H0();
                v0();
            }
        }
    }

    public final int Z(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int H = k0().H();
            int i3 = pMSAppInfo.appCategory;
            if (i3 <= -1 && H != i3) {
                return 10002;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void h0(Set<jh4.a> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, set) == null) {
            jh4 jh4Var = new jh4(set);
            jh4Var.d("3");
            g gVar = new g(this);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            gVar.L(i2);
            ud4.d(jh4Var, gVar);
        }
    }

    public final void O0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pMSAppInfo, hybridUbcFlow) == null) && pMSAppInfo != null && hybridUbcFlow != null) {
            N0(pMSAppInfo);
            c0(this.m);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
            ubcFlowEvent.a(true);
            hybridUbcFlow.F(ubcFlowEvent);
        }
    }

    public static void o0(nd3 nd3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, nd3Var, str, str2) == null) {
            JSONObject k2 = dd3.k(str);
            nd3Var.d(str2);
            nd3Var.b(k2);
            dd3.onEvent(nd3Var);
        }
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            j63.K().v(str2, bundle);
        }
    }

    public static String j0(Context context, di3 di3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, di3Var)) == null) {
            return String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01dc), ek3.D(), pf3.i(xr2.V().getCoreVersion(), j63.K().q().k()), String.valueOf(di3Var.a()));
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void w0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048610, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.K0(true);
                    k32.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    o63.a aVar = (o63.a) new o63.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    dd3.V(z, str);
                }
                if (n) {
                    pr2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public static void p0(kr2 kr2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{kr2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            Bundle t0 = kr2Var.t0();
            String str3 = "1";
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            t0.putString("aiapp_extra_need_download", str);
            Bundle t02 = kr2Var.t0();
            if (z2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            t02.putString("aiapp_extra_pkg_downloading", str2);
            nd3 nd3Var = new nd3();
            nd3Var.a = dd3.n(kr2Var.H());
            nd3Var.h(kr2Var);
            nd3Var.b = "launch";
            if (!z) {
                str3 = "0";
            }
            nd3Var.o = str3;
            if (pMSAppInfo != null) {
                nd3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            d03.e().d(new k(nd3Var, kr2Var.X(), kr2Var.t0().getString("ubc")), "launchStatistic", true);
        }
    }

    public static void z0(PMSAppInfo pMSAppInfo, Context context, hr2 hr2Var, boolean z, String str, di3 di3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65559, null, new Object[]{pMSAppInfo, context, hr2Var, Boolean.valueOf(z), str, di3Var}) != null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(hr2Var, str, j0(context, di3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        if (z) {
            str2 = "type_path_forbidden";
        } else {
            str2 = "type_app_forbidden";
        }
        er2.l(context, str2, di3Var, forbiddenInfo, hr2Var.D());
        nd3 nd3Var = new nd3();
        nd3Var.a = dd3.n(hr2Var.H());
        nd3Var.b = "launch";
        nd3Var.e = "success";
        nd3Var.i(hr2Var);
        nd3Var.a("status", "2");
        nd3Var.d(hr2Var.t0().getString("ubc"));
        dd3.onEvent(nd3Var);
    }

    public final void A0(boolean z, String str, di3 di3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, di3Var}) != null) || this.m == null) {
            return;
        }
        z0(this.m, g0(), k0(), z, str, di3Var);
    }

    public final void B0(di3 di3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, di3Var) == null) {
            pz2.k(di3Var);
            Context g0 = g0();
            if ((g0 instanceof SwanAppActivity) && !ti3.d((SwanAppActivity) g0)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            hr2 k0 = k0();
            int H = k0.H();
            if (!di3Var.l()) {
                ld3 ld3Var = new ld3();
                ld3Var.q(dd3.n(H));
                ld3Var.p(di3Var);
                ld3Var.m(getAppId());
                ld3Var.t(k0.U());
                dd3.R(ld3Var);
                di3Var.n();
            }
            if (!yr2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                ek3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", k0.I());
            bundle.putAll(k0.D());
            er2.g(rp2.c(), di3Var, H, getAppId(), true, bundle);
            uc3.m(k0, H, di3Var);
            rp2.p0().flush(false);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            hr2 k0 = k0();
            String c2 = rr2.c(this.m, k0.f0());
            k0.G0(true);
            k0.W0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            J0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final void H0() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hr2.a X = q().X();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z2 = false;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId) && TextUtils.equals(getAppId(), this.m.appId)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                X.T0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                if (z && pMSAppInfo2.appCategory == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    z2 = true;
                }
                if (z2) {
                    X.v0(i2);
                } else {
                    ek3.e0(new b(this, X, i2));
                }
            }
        }
    }

    public final int F0(di3 di3Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, di3Var)) == null) {
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (di3Var == null) {
                    di3Var = new di3();
                    di3Var.k(10L);
                    di3Var.i(2902L);
                    di3Var.f("no pkg was installed");
                }
                hi3.a().f(di3Var);
                B0(di3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (dm3.g(di3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                H0();
                if (Z != 0) {
                    di3 i0 = i0(10003);
                    hi3.a().f(i0);
                    A0(false, null, i0);
                    pz2.k(i0);
                    rp2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<jh4.a> i2 = r13.i(this.m);
                    if (i2 != null && !i2.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f = z;
                    if (!z) {
                        di3 di3Var2 = new di3();
                        di3Var2.k(17L);
                        di3Var2.i(2909L);
                        di3Var2.f("dependent pkg is missing.");
                        hi3.a().f(di3Var2);
                        B0(di3Var2);
                        return -1;
                    }
                }
                xr2 V = xr2.V();
                String f0 = q().X().f0();
                if (!TextUtils.isEmpty(f0)) {
                    if (x83.b().a(kw2.d(f0, V.A()))) {
                        di3 i02 = i0(10004);
                        hi3.a().f(i02);
                        A0(true, x83.b().d(), i02);
                        pz2.k(i02);
                        rp2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (di3Var == null) {
                di3Var = i0(Z);
            }
            hi3.a().f(di3Var);
            B0(di3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean G0(di3 di3Var) {
        InterceptResult invokeL;
        String str;
        ue2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, di3Var)) == null) {
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (l0()) {
                return false;
            }
            int F0 = F0(di3Var);
            if (F0 == -1) {
                k32.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                u0(false);
                return false;
            } else if (F0 == -2) {
                t0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                hr2.a X = this.j.X();
                SwanCoreVersion k0 = X.k0();
                if (k0 != null) {
                    str = k0.swanCoreVersionName;
                } else {
                    str = "0";
                }
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + X.l0() + " ,curSwanVersionName: " + str);
                }
                if (zj3.a(X.l0(), str)) {
                    pf3.n(X.H());
                }
                pz2.p("startup").D("launch_type", String.valueOf(X.h("host_launch_type")));
                if (X.H() == 0) {
                    D0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                u0(true);
                if (ProcessUtils.isMainProcess() && (d2 = we2.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, pMSAppInfo) == null) && pMSAppInfo != null) {
            o63.a aVar = (o63.a) ((o63.a) new o63.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
            if (n) {
                q0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (n) {
                    q0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.z("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (n) {
                    q0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (n) {
                    q0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.z("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("app_pay_protected", pMSAppInfo.payProtected);
            aVar.t("event_flag_force_post", true);
            A(aVar);
        }
    }

    public final void L0() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            j63.K().p("event_pms_check_start");
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            hr2 k0 = k0();
            if (n) {
                q0("预置包不可用");
            }
            boolean s0 = s0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + s0);
            }
            if (!s0) {
                if (!this.f) {
                    Set<jh4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = r13.i(this.m);
                    }
                    Set<jh4.a> set2 = this.g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f = z;
                    if (!z) {
                        h0(this.g);
                        this.g = null;
                        return;
                    }
                }
                if (n) {
                    q0("可以直接打开小程序，异步从Server拉取新包");
                }
                int i2 = 4;
                this.h = 4;
                p0(k0, this.m, false, false);
                if (this.i) {
                    i2 = 3;
                }
                this.h = i2;
                J0(null);
                b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
                return;
            }
            if (n) {
                q0("不能直接打开小程序，同步从Server拉取新包");
            }
            b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
            e0(this.j.X().I(), new f(this, k0));
            String appId = getAppId();
            mh4 mh4Var = new mh4(appId, k0.H());
            mh4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = 0;
            if (pMSAppInfo == null) {
                j2 = 0;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            mh4Var.u(j2);
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                j3 = pMSAppInfo2.appSign;
            }
            mh4Var.o(j3);
            String f2 = ck3.f(k0.f0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                mh4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((o63.a) new o63.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            fr2.b().g(appId);
            f0(mh4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void M0() {
        long j2;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HybridUbcFlow p = pz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                if (this.m == null) {
                    str = "数据库或本地无主包信息，尝试加载预置包，并下载主包";
                } else {
                    str = "包信息、文件都存在，尝试加载更高版本的预置包";
                }
                q0(str);
            }
            gc2 c2 = jc2.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = -1;
            if (pMSAppInfo == null) {
                j2 = -1;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            if (c2 != null) {
                j3 = c2.i;
            }
            if (j3 > j2) {
                z = true;
            } else {
                z = false;
            }
            if (n) {
                q0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                L0();
                return;
            }
            p("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            jc2.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final boolean a0(@NonNull mh4 mh4Var, di3 di3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, mh4Var, di3Var)) == null) {
            String appId = getAppId();
            if (di3Var != null && SwanAppNetworkUtils.i(rp2.c()) && fr2.b().f(appId)) {
                k32.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + di3Var.a());
                if (di3Var.h() == 2101) {
                    fr2.b().a(appId);
                    pz2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(mh4Var, true, di3Var);
                    return true;
                } else if (di3Var.h() == 2205) {
                    we2.c().d().u(ok3.a(appId), true, 12);
                    fr2.b().a(appId);
                    pz2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(mh4Var, true, di3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void d0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                hr2.a X = this.j.X();
                if (!j23.H() && TextUtils.isEmpty(X.h0()) && ((!n || !X.o0()) && !X.q0())) {
                    String W = X.W();
                    this.k = W;
                    if (n) {
                        pr2.d(W).f("start");
                    }
                    po2.d("1");
                    HybridUbcFlow p = pz2.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(b52.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo g0 = this.j.X().g0();
                    if (g0 == null || g0.isMaxAgeExpires()) {
                        g0 = he4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = rr2.e(g0);
                    this.l = e2;
                    if (g0 != null && !e2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.e = z;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        O0(g0, p);
                    }
                    if (!this.l && rr2.f(g0, X.f0())) {
                        O0(g0, p);
                        E0();
                    } else {
                        M0();
                    }
                    return;
                }
                u0(true);
            }
        }
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            HybridUbcFlow p = pz2.p("startup");
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.D("launch_state", String.valueOf(0));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.m.isMaxAgeExpires()) {
                if (b52.a().c(getAppId())) {
                    if (n) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.D("launch_state", String.valueOf(3));
                    b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (n) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.i = true;
                return true;
            } else {
                p.D("launch_state", String.valueOf(4));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e0(@NonNull String str, @NonNull q23 q23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, q23Var) == null) {
            f33 Q = f33.Q();
            if (Q == null) {
                n23 n23Var = new n23(q23Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                n23Var.b(bundle);
                q23Var.onEvent(n23Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, q23Var);
        }
    }

    public final void f0(@NonNull mh4 mh4Var, boolean z, @Nullable di3 di3Var) {
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{mh4Var, Boolean.valueOf(z), di3Var}) == null) {
            HybridUbcFlow p = pz2.p("startup");
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            mh4Var.v(j2);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, mh4Var, p));
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jVar.L(i2);
            if (z && di3Var != null) {
                mh4Var.p(di3Var.h());
            }
            ud4.c(mh4Var, jVar);
        }
    }

    public synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !m0() && !n0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = pz2.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.X().H()) {
                        z = false;
                    }
                    if (z || !ed2.V().n0()) {
                        p("event_on_still_maintaining");
                    }
                    if (z) {
                        y0();
                    } else {
                        d0();
                    }
                }
            }
        }
    }

    public final synchronized void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (x52.b.a()) {
                    this.j.K0(true);
                }
                if (n) {
                    q0("notifyMaintainFinish: " + z);
                }
                if (q() == j63.K().q()) {
                    A((o63.a) new o63.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    pr2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = pz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j63.M().post(new c(this, p));
            }
        }
    }
}
