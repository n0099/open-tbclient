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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.io2;
import com.baidu.tieba.ke4;
import com.baidu.tieba.p33;
import com.baidu.tieba.y22;
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
/* loaded from: classes5.dex */
public final class r33 extends t33 implements fd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<ke4.a> g;
    public int h;
    public boolean i;
    public final l33 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(r33 r33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var};
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
                k33.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 a;
        public final /* synthetic */ int b;

        public b(r33 r33Var, io2 io2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, io2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = io2Var;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u0(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ r33 b;

        public c(r33 r33Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r33Var;
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

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ r33 b;

        public d(r33 r33Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r33Var;
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
                bundle.putInt("appFrameType", this.b.j0().G());
                bundle.putString("mAppId", this.b.getAppId());
                if (r33.n) {
                    r33.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                b03 e = b03.e();
                d03 d03Var = new d03(17, bundle);
                d03Var.j(5000L);
                e.h(d03Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r33 a;

        public e(r33 r33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r33Var;
        }

        @Override // com.baidu.tieba.i92
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.i92
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.h = 5;
                r33 r33Var = this.a;
                r33Var.b0("KEY_PKG_STATE", "event_pms_check_finish", r33Var.h);
                HybridUbcFlow p = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (r33.n) {
                    r33.p0("预制包安装成功");
                }
                r33.o0(this.a.j0(), pMSAppInfo, false, false);
                this.a.M0(pMSAppInfo);
                this.a.I0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.i92
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (r33.n) {
                    r33.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends rz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 c;
        public final /* synthetic */ r33 d;

        public f(r33 r33Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r33Var;
            this.c = io2Var;
        }

        @Override // com.baidu.tieba.rz2, com.baidu.tieba.qz2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz2, com.baidu.tieba.sz2, com.baidu.tieba.qz2
        public void onEvent(@NonNull oz2 oz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oz2Var) == null) {
                Bundle a = oz2Var.a();
                r33.o0(this.c, this.d.m, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends j62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r33 h;

        public g(r33 r33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = r33Var;
        }

        @Override // com.baidu.tieba.j62, com.baidu.tieba.gb4
        public void G(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tg4Var) == null) {
                this.h.c = true;
                k33.K().p("event_pkg_download_start");
                super.G(tg4Var);
            }
        }

        @Override // com.baidu.tieba.j62
        public void Q(@NonNull ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                if3.a().f(ef3Var);
                this.h.A0(ef3Var);
                this.h.t0(false);
            }
        }

        @Override // com.baidu.tieba.j62
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.h.c = false;
                r33.o0(this.h.j0(), this.h.m, false, false);
                r33 r33Var = this.h;
                r33Var.h = r33Var.i ? 3 : 4;
                this.h.I0(null);
                r33 r33Var2 = this.h;
                r33Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", r33Var2.h);
            }
        }

        @Override // com.baidu.tieba.j62, com.baidu.tieba.gb4, com.baidu.tieba.db4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.h.c = false;
                k33.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements u62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ne4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ r33 d;

        public h(r33 r33Var, boolean z, ne4 ne4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, Boolean.valueOf(z), ne4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r33Var;
            this.a = z;
            this.b = ne4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.u62
        public void a(ef3 ef3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, ef3Var, z) == null) {
                long a = ef3Var == null ? 0L : ef3Var.a();
                l02.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    ea3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, ef3Var)) {
                    return;
                }
                this.d.c = false;
                k33.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if3.a().f(ef3Var);
                if (z) {
                    r33 r33Var = this.d;
                    r33Var.h = r33Var.i ? 3 : 4;
                    r33 r33Var2 = this.d;
                    r33Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", r33Var2.h);
                    this.d.H0(ef3Var);
                } else if (ef3Var != null && ef3Var.h() == 1020) {
                    this.d.A0(ef3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (ef3Var == null || ef3Var.h() != 2203) {
                    return;
                }
                l02.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (jc2.a().b(1) == 0) {
                    jc2.a().c();
                }
            }
        }

        @Override // com.baidu.tieba.u62
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                l02.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    ea3.L("pkg_retry_success", "");
                }
                this.d.c = false;
                r33 r33Var = this.d;
                r33Var.h = r33Var.e ? 2 : 0;
                r33 r33Var2 = this.d;
                r33Var2.h = r33Var2.i ? 1 : this.d.h;
                r33 r33Var3 = this.d;
                r33Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", r33Var3.h);
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.d.M0(pMSAppInfo);
                this.d.F0(null);
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ei3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ r33 b;

        public i(r33 r33Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r33Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (r33.n) {
                    r33.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.b.M0(pMSAppInfo);
                this.b.c0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends m62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ r33 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(r33 r33Var, l33 l33Var, boolean z) {
            super(l33Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r33Var, l33Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l33) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = r33Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.m62, com.baidu.tieba.l62, com.baidu.tieba.gb4
        public void G(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tg4Var) == null) {
                l02.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                k33.K().p("event_pkg_download_start");
                super.G(tg4Var);
            }
        }

        @Override // com.baidu.tieba.gb4, com.baidu.tieba.db4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l02.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                k33.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(oa3 oa3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r33.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends lz2 {
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

        @Override // com.baidu.tieba.lz2
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
                boolean j = va4.j(string);
                boolean k = va4.k(string);
                if (lz2.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070647, "Lcom/baidu/tieba/r33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070647, "Lcom/baidu/tieba/r33;");
                return;
            }
        }
        n = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r33(l33 l33Var) {
        super(l33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((o33) newInitContext.callArgs[0]);
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
        this.j = l33Var;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            return (w == null || w.isDestroyed()) ? sm2.c() : w;
        }
        return (Context) invokeV.objValue;
    }

    public static String i0(Context context, ef3 ef3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, ef3Var)) == null) ? String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01a5), fh3.D(), qc3.i(yo2.U().M(), k33.K().q().k()), String.valueOf(ef3Var.a())) : (String) invokeLL.objValue;
    }

    public static void n0(oa3 oa3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, oa3Var, str, str2) == null) {
            JSONObject k2 = ea3.k(str);
            oa3Var.d(str2);
            oa3Var.b(k2);
            ea3.onEvent(oa3Var);
        }
    }

    public static void o0(lo2 lo2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{lo2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            lo2Var.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            lo2Var.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            oa3 oa3Var = new oa3();
            oa3Var.a = ea3.n(lo2Var.G());
            oa3Var.h(lo2Var);
            oa3Var.b = "launch";
            oa3Var.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                oa3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            ex2.e().d(new k(oa3Var, lo2Var.W(), lo2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, io2 io2Var, boolean z, String str, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, io2Var, Boolean.valueOf(z), str, ef3Var}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(io2Var, str, i0(context, ef3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        fo2.l(context, z ? "type_path_forbidden" : "type_app_forbidden", ef3Var, forbiddenInfo, io2Var.D());
        oa3 oa3Var = new oa3();
        oa3Var.a = ea3.n(io2Var.G());
        oa3Var.b = "launch";
        oa3Var.e = "success";
        oa3Var.i(io2Var);
        oa3Var.a("status", "2");
        oa3Var.d(io2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        ea3.onEvent(oa3Var);
    }

    public final void A0(ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ef3Var) == null) {
            qw2.k(ef3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !uf3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            io2 j0 = j0();
            int G = j0.G();
            if (!ef3Var.l()) {
                ma3 ma3Var = new ma3();
                ma3Var.q(ea3.n(G));
                ma3Var.p(ef3Var);
                ma3Var.m(getAppId());
                ma3Var.t(j0.T());
                ea3.R(ma3Var);
                ef3Var.n();
            }
            if (!zo2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                fh3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            fo2.g(sm2.c(), ef3Var, G, getAppId(), true, bundle);
            v93.m(j0, G, ef3Var);
            sm2.p0().flush(false);
        }
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hm2.O(this.j);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            io2 j0 = j0();
            String c2 = so2.c(this.m, j0.e0());
            j0.F0(true);
            j0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            I0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final int E0(ef3 ef3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ef3Var)) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (ef3Var == null) {
                    ef3Var = new ef3();
                    ef3Var.k(10L);
                    ef3Var.i(2902L);
                    ef3Var.f("no pkg was installed");
                }
                if3.a().f(ef3Var);
                A0(ef3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (ej3.g(ef3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    ef3 h0 = h0(10003);
                    if3.a().f(h0);
                    z0(false, null, h0);
                    qw2.k(h0);
                    sm2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<ke4.a> i2 = sy2.i(this.m);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f = z;
                    if (!z) {
                        ef3 ef3Var2 = new ef3();
                        ef3Var2.k(17L);
                        ef3Var2.i(2909L);
                        ef3Var2.f("dependent pkg is missing.");
                        if3.a().f(ef3Var2);
                        A0(ef3Var2);
                        return -1;
                    }
                }
                yo2 U = yo2.U();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (y53.b().a(lt2.d(e0, U.z()))) {
                        ef3 h02 = h0(10004);
                        if3.a().f(h02);
                        z0(true, y53.b().d(), h02);
                        qw2.k(h02);
                        sm2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (ef3Var == null) {
                ef3Var = h0(Z);
            }
            if3.a().f(ef3Var);
            A0(ef3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(ef3 ef3Var) {
        InterceptResult invokeL;
        vb2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ef3Var)) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(ef3Var);
            if (E0 == -1) {
                l02.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                io2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (ah3.a(W.k0(), str)) {
                    qc3.n(W.G());
                }
                qw2.p("startup").D("launch_type", String.valueOf(W.i("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = xb2.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            io2.a W = q().W();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.m.appId)) ? false : true;
            if (z) {
                W.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                int i2 = (z && pMSAppInfo2.appCategory == 1) ? 1 : 0;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    W.u0(i2);
                } else {
                    fh3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final void H0(ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ef3Var) == null) && F0(ef3Var)) {
            ma3 ma3Var = new ma3();
            ma3Var.p(ef3Var);
            ma3Var.r(j0());
            ea3.R(ma3Var);
        }
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            dx2.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void J0(Set<ke4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k33.K().p("event_pms_check_start");
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            io2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<ke4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = sy2.i(this.m);
                    }
                    Set<ke4.a> set2 = this.g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f = z;
                    if (!z) {
                        g0(this.g);
                        this.g = null;
                        return;
                    }
                }
                if (n) {
                    p0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.h = 4;
                o0(j0, this.m, false, false);
                this.h = this.i ? 3 : 4;
                I0(null);
                b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
                return;
            }
            if (n) {
                p0("不能直接打开小程序，同步从Server拉取新包");
            }
            b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
            e0(this.j.W().H(), new f(this, j0));
            String appId = getAppId();
            ne4 ne4Var = new ne4(appId, j0.G());
            ne4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            ne4Var.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.m;
            ne4Var.o(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = dh3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                ne4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((p33.a) new p33.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            go2.b().g(appId);
            f0(ne4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0(this.m == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            h92 c2 = k92.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.i : -1L;
            boolean z = j3 > j2;
            if (n) {
                p0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                K0();
                return;
            }
            p("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            k92.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.W().c1(pMSAppInfo);
            if (k0()) {
                G0();
                u0();
            }
        }
    }

    public final void N0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        M0(pMSAppInfo);
        c0(this.m);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.F(ubcFlowEvent);
    }

    public final int Z(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int G = j0().G();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean a0(@NonNull ne4 ne4Var, ef3 ef3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, ne4Var, ef3Var)) == null) {
            String appId = getAppId();
            if (ef3Var != null && SwanAppNetworkUtils.i(sm2.c()) && go2.b().f(appId)) {
                l02.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + ef3Var.a());
                if (ef3Var.h() == 2101) {
                    go2.b().a(appId);
                    qw2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(ne4Var, true, ef3Var);
                    return true;
                } else if (ef3Var.h() == 2205) {
                    xb2.c().d().u(ph3.a(appId), true, 12);
                    go2.b().a(appId);
                    qw2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(ne4Var, true, ef3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            k33.K().v(str2, bundle);
        }
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        p33.a aVar = (p33.a) ((p33.a) new p33.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
        if (n) {
            p0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (n) {
                p0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.z("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (n) {
                p0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (n) {
                p0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.z("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.w("app_pay_protected", pMSAppInfo.payProtected);
        aVar.t("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                io2.a W = this.j.W();
                if (!kz2.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        qo2.d(V).f("start");
                    }
                    ql2.d("1");
                    HybridUbcFlow p = qw2.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(c22.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = ib4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = so2.e(f0);
                    this.l = e2;
                    this.e = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        N0(f0, p);
                    }
                    if (!this.l && so2.f(f0, W.e0())) {
                        N0(f0, p);
                        D0();
                    } else {
                        L0();
                    }
                    return;
                }
                t0(true);
            }
        }
    }

    public final void e0(@NonNull String str, @NonNull rz2 rz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, rz2Var) == null) {
            g03 Q = g03.Q();
            if (Q == null) {
                oz2 oz2Var = new oz2(rz2Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                oz2Var.setResult(bundle);
                rz2Var.onEvent(oz2Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, rz2Var);
        }
    }

    public final void f0(@NonNull ne4 ne4Var, boolean z, @Nullable ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{ne4Var, Boolean.valueOf(z), ef3Var}) == null) {
            HybridUbcFlow p = qw2.p("startup");
            ne4Var.v(z ? 1L : 0L);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, ne4Var, p));
            jVar.L(this.i ? 2 : 1);
            if (z && ef3Var != null) {
                ne4Var.p(ef3Var.h());
            }
            va4.c(ne4Var, jVar);
        }
    }

    public final void g0(Set<ke4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            ke4 ke4Var = new ke4(set);
            ke4Var.d("3");
            g gVar = new g(this);
            gVar.L(this.i ? 2 : 1);
            va4.d(ke4Var, gVar);
        }
    }

    public final ef3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            ef3 ef3Var = new ef3();
            switch (i2) {
                case 10001:
                    ef3Var.k(10L);
                    ef3Var.i(2902L);
                    ef3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    ef3Var.k(10L);
                    ef3Var.i(27L);
                    ef3Var.f("category not match");
                    break;
                case 10003:
                    ef3Var.k(10L);
                    ef3Var.i(2107L);
                    ef3Var.d("app forbiddeon");
                    break;
                case 10004:
                    ef3Var.k(10L);
                    ef3Var.i(48L);
                    ef3Var.d("path forbiddeon");
                    break;
            }
            return ef3Var;
        }
        return (ef3) invokeI.objValue;
    }

    public io2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j.W() : (io2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? k33.K().q().W().d("property_web_mode_degrade") : invokeV.booleanValue;
    }

    public synchronized boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = qw2.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !fa2.U().m0()) {
                        p("event_on_still_maintaining");
                    }
                    if (z) {
                        x0();
                    } else {
                        d0();
                    }
                }
            }
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HybridUbcFlow p = qw2.p("startup");
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
                if (c22.a().c(getAppId())) {
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

    public synchronized void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                v0(true, null);
            }
        }
    }

    public final synchronized void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (y22.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == k33.K().q()) {
                    A((p33.a) new p33.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    qo2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public synchronized void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                v0(false, null);
            }
        }
    }

    public synchronized void v0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.J0(true);
                    l02.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    p33.a aVar = (p33.a) new p33.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    ea3.V(z, str);
                }
                if (n) {
                    qo2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h : invokeV.intValue;
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                k33.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, ef3Var}) == null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, ef3Var);
    }
}
