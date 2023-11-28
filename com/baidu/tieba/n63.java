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
import com.baidu.tieba.er2;
import com.baidu.tieba.gh4;
import com.baidu.tieba.l63;
import com.baidu.tieba.u52;
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
public final class n63 extends p63 implements bg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<gh4.a> g;
    public int h;
    public boolean i;
    public final h63 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n63 n63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var};
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
                g63.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er2 a;
        public final /* synthetic */ int b;

        public b(n63 n63Var, er2 er2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, er2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = er2Var;
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
        public final /* synthetic */ n63 b;

        public c(n63 n63Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n63Var;
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
        public final /* synthetic */ n63 b;

        public d(n63 n63Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n63Var;
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
                if (n63.n) {
                    n63.q0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                x23 e = x23.e();
                z23 z23Var = new z23(17, bundle);
                z23Var.j(5000L);
                e.h(z23Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ec2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 a;

        public e(n63 n63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n63Var;
        }

        @Override // com.baidu.tieba.ec2
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = mz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.ec2
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = mz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (n63.n) {
                    n63.q0("预制包安装失败");
                }
                this.a.L0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.ec2
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) != null) {
                return;
            }
            this.a.h = 5;
            n63 n63Var = this.a;
            n63Var.b0("KEY_PKG_STATE", "event_pms_check_finish", n63Var.h);
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n63.n) {
                n63.q0("预制包安装成功");
            }
            n63.p0(this.a.k0(), pMSAppInfo, false, false);
            this.a.N0(pMSAppInfo);
            this.a.J0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends n23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er2 c;
        public final /* synthetic */ n63 d;

        @Override // com.baidu.tieba.n23, com.baidu.tieba.m23
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        public f(n63 n63Var, er2 er2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, er2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n63Var;
            this.c = er2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n23, com.baidu.tieba.o23, com.baidu.tieba.m23
        public void onEvent(@NonNull k23 k23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k23Var) == null) {
                Bundle a = k23Var.a();
                boolean z = false;
                if (a != null) {
                    z = a.getBoolean("isDownloading", false);
                }
                n63.p0(this.c, this.d.m, true, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends f92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 h;

        public g(n63 n63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = n63Var;
        }

        @Override // com.baidu.tieba.f92, com.baidu.tieba.ce4
        public void G(pj4 pj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pj4Var) != null) {
                return;
            }
            this.h.c = true;
            g63.K().p("event_pkg_download_start");
            super.G(pj4Var);
        }

        @Override // com.baidu.tieba.f92
        public void Q(@NonNull ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai3Var) == null) {
                ei3.a().f(ai3Var);
                this.h.B0(ai3Var);
                this.h.u0(false);
            }
        }

        @Override // com.baidu.tieba.f92
        public void R() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.h.c = false;
            n63.p0(this.h.k0(), this.h.m, false, false);
            n63 n63Var = this.h;
            if (n63Var.i) {
                i = 3;
            } else {
                i = 4;
            }
            n63Var.h = i;
            this.h.J0(null);
            n63 n63Var2 = this.h;
            n63Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", n63Var2.h);
        }

        @Override // com.baidu.tieba.f92, com.baidu.tieba.ce4, com.baidu.tieba.zd4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.h.c = false;
            g63.K().p("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements q92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ jh4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ n63 d;

        public h(n63 n63Var, boolean z, jh4 jh4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, Boolean.valueOf(z), jh4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n63Var;
            this.a = z;
            this.b = jh4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.q92
        public void a(ai3 ai3Var, boolean z) {
            long a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, ai3Var, z) == null) {
                if (ai3Var == null) {
                    a = 0;
                } else {
                    a = ai3Var.a();
                }
                h32.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    ad3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, ai3Var)) {
                    return;
                }
                this.d.c = false;
                g63.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                ei3.a().f(ai3Var);
                if (z) {
                    n63 n63Var = this.d;
                    if (n63Var.i) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    n63Var.h = i;
                    n63 n63Var2 = this.d;
                    n63Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", n63Var2.h);
                    this.d.I0(ai3Var);
                } else if (ai3Var != null && ai3Var.h() == 1020) {
                    this.d.B0(ai3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (ai3Var != null && ai3Var.h() == 2203) {
                    h32.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                    if (ff2.a().b(1) == 0) {
                        ff2.a().c();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.q92
        public void b(PMSAppInfo pMSAppInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                h32.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    ad3.L("pkg_retry_success", "");
                }
                int i2 = 0;
                this.d.c = false;
                n63 n63Var = this.d;
                if (n63Var.e) {
                    i2 = 2;
                }
                n63Var.h = i2;
                n63 n63Var2 = this.d;
                if (!n63Var2.i) {
                    i = this.d.h;
                } else {
                    i = 1;
                }
                n63Var2.h = i;
                n63 n63Var3 = this.d;
                n63Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", n63Var3.h);
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
    public class i implements al3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ n63 b;

        public i(n63 n63Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n63Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (n63.n) {
                    n63.q0("onAppInfoReceived appInfo=" + pMSAppInfo);
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
    public class j extends i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ n63 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(n63 n63Var, h63 h63Var, boolean z) {
            super(h63Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, h63Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((h63) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = n63Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.i92, com.baidu.tieba.h92, com.baidu.tieba.ce4
        public void G(pj4 pj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pj4Var) == null) {
                h32.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                g63.K().p("event_pkg_download_start");
                super.G(pj4Var);
            }
        }

        @Override // com.baidu.tieba.ce4, com.baidu.tieba.zd4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h32.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                g63.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kd3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(kd3 kd3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kd3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kd3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n63.o0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l extends h23 {
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

        @Override // com.baidu.tieba.h23
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
                boolean j = rd4.j(string);
                boolean k = rd4.k(string);
                if (h23.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947954366, "Lcom/baidu/tieba/n63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947954366, "Lcom/baidu/tieba/n63;");
                return;
            }
        }
        n = sm1.a;
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
            dp2.O(this.j);
        }
    }

    public final Context g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SwanAppActivity w = this.j.w();
            if (w == null || w.isDestroyed()) {
                return op2.c();
            }
            return w;
        }
        return (Context) invokeV.objValue;
    }

    public er2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j.X();
        }
        return (er2) invokeV.objValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return g63.K().q().X().c("property_web_mode_degrade");
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
    public n63(h63 h63Var) {
        super(h63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((k63) newInitContext.callArgs[0]);
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
        this.j = h63Var;
    }

    public final void J0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            G0(null);
            zz2.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final ai3 i0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            ai3 ai3Var = new ai3();
            switch (i2) {
                case 10001:
                    ai3Var.k(10L);
                    ai3Var.i(2902L);
                    ai3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    ai3Var.k(10L);
                    ai3Var.i(27L);
                    ai3Var.f("category not match");
                    break;
                case 10003:
                    ai3Var.k(10L);
                    ai3Var.i(2107L);
                    ai3Var.d("app forbiddeon");
                    break;
                case 10004:
                    ai3Var.k(10L);
                    ai3Var.i(48L);
                    ai3Var.d("path forbiddeon");
                    break;
            }
            return ai3Var;
        }
        return (ai3) invokeI.objValue;
    }

    public static void q0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final void I0(ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ai3Var) == null) && G0(ai3Var)) {
            id3 id3Var = new id3();
            id3Var.p(ai3Var);
            id3Var.r(k0());
            ad3.R(id3Var);
        }
    }

    public void K0(Set<gh4.a> set) {
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

    public final void h0(Set<gh4.a> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, set) == null) {
            gh4 gh4Var = new gh4(set);
            gh4Var.d("3");
            g gVar = new g(this);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            gVar.L(i2);
            rd4.d(gh4Var, gVar);
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

    public static void o0(kd3 kd3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, kd3Var, str, str2) == null) {
            JSONObject k2 = ad3.k(str);
            kd3Var.d(str2);
            kd3Var.b(k2);
            ad3.onEvent(kd3Var);
        }
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            g63.K().v(str2, bundle);
        }
    }

    public static String j0(Context context, ai3 ai3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, ai3Var)) == null) {
            return String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01dc), bk3.D(), mf3.i(ur2.V().getCoreVersion(), g63.K().q().k()), String.valueOf(ai3Var.a()));
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
                    h32.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    l63.a aVar = (l63.a) new l63.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    ad3.V(z, str);
                }
                if (n) {
                    mr2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public static void p0(hr2 hr2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{hr2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            Bundle t0 = hr2Var.t0();
            String str3 = "1";
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            t0.putString("aiapp_extra_need_download", str);
            Bundle t02 = hr2Var.t0();
            if (z2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            t02.putString("aiapp_extra_pkg_downloading", str2);
            kd3 kd3Var = new kd3();
            kd3Var.a = ad3.n(hr2Var.H());
            kd3Var.h(hr2Var);
            kd3Var.b = "launch";
            if (!z) {
                str3 = "0";
            }
            kd3Var.o = str3;
            if (pMSAppInfo != null) {
                kd3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            a03.e().d(new k(kd3Var, hr2Var.X(), hr2Var.t0().getString("ubc")), "launchStatistic", true);
        }
    }

    public static void z0(PMSAppInfo pMSAppInfo, Context context, er2 er2Var, boolean z, String str, ai3 ai3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65559, null, new Object[]{pMSAppInfo, context, er2Var, Boolean.valueOf(z), str, ai3Var}) != null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(er2Var, str, j0(context, ai3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        if (z) {
            str2 = "type_path_forbidden";
        } else {
            str2 = "type_app_forbidden";
        }
        br2.l(context, str2, ai3Var, forbiddenInfo, er2Var.D());
        kd3 kd3Var = new kd3();
        kd3Var.a = ad3.n(er2Var.H());
        kd3Var.b = "launch";
        kd3Var.e = "success";
        kd3Var.i(er2Var);
        kd3Var.a("status", "2");
        kd3Var.d(er2Var.t0().getString("ubc"));
        ad3.onEvent(kd3Var);
    }

    public final void A0(boolean z, String str, ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, ai3Var}) != null) || this.m == null) {
            return;
        }
        z0(this.m, g0(), k0(), z, str, ai3Var);
    }

    public final void B0(ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai3Var) == null) {
            mz2.k(ai3Var);
            Context g0 = g0();
            if ((g0 instanceof SwanAppActivity) && !qi3.d((SwanAppActivity) g0)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            er2 k0 = k0();
            int H = k0.H();
            if (!ai3Var.l()) {
                id3 id3Var = new id3();
                id3Var.q(ad3.n(H));
                id3Var.p(ai3Var);
                id3Var.m(getAppId());
                id3Var.t(k0.U());
                ad3.R(id3Var);
                ai3Var.n();
            }
            if (!vr2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                bk3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", k0.I());
            bundle.putAll(k0.D());
            br2.g(op2.c(), ai3Var, H, getAppId(), true, bundle);
            rc3.m(k0, H, ai3Var);
            op2.p0().flush(false);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            er2 k0 = k0();
            String c2 = or2.c(this.m, k0.f0());
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
            er2.a X = q().X();
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
                    bk3.e0(new b(this, X, i2));
                }
            }
        }
    }

    public final int F0(ai3 ai3Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ai3Var)) == null) {
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                q0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (ai3Var == null) {
                    ai3Var = new ai3();
                    ai3Var.k(10L);
                    ai3Var.i(2902L);
                    ai3Var.f("no pkg was installed");
                }
                ei3.a().f(ai3Var);
                B0(ai3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (am3.g(ai3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                H0();
                if (Z != 0) {
                    ai3 i0 = i0(10003);
                    ei3.a().f(i0);
                    A0(false, null, i0);
                    mz2.k(i0);
                    op2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<gh4.a> i2 = o13.i(this.m);
                    if (i2 != null && !i2.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f = z;
                    if (!z) {
                        ai3 ai3Var2 = new ai3();
                        ai3Var2.k(17L);
                        ai3Var2.i(2909L);
                        ai3Var2.f("dependent pkg is missing.");
                        ei3.a().f(ai3Var2);
                        B0(ai3Var2);
                        return -1;
                    }
                }
                ur2 V = ur2.V();
                String f0 = q().X().f0();
                if (!TextUtils.isEmpty(f0)) {
                    if (u83.b().a(hw2.d(f0, V.A()))) {
                        ai3 i02 = i0(10004);
                        ei3.a().f(i02);
                        A0(true, u83.b().d(), i02);
                        mz2.k(i02);
                        op2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (ai3Var == null) {
                ai3Var = i0(Z);
            }
            ei3.a().f(ai3Var);
            B0(ai3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean G0(ai3 ai3Var) {
        InterceptResult invokeL;
        String str;
        re2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ai3Var)) == null) {
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (l0()) {
                return false;
            }
            int F0 = F0(ai3Var);
            if (F0 == -1) {
                h32.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                u0(false);
                return false;
            } else if (F0 == -2) {
                t0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                er2.a X = this.j.X();
                SwanCoreVersion k0 = X.k0();
                if (k0 != null) {
                    str = k0.swanCoreVersionName;
                } else {
                    str = "0";
                }
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + X.l0() + " ,curSwanVersionName: " + str);
                }
                if (wj3.a(X.l0(), str)) {
                    mf3.n(X.H());
                }
                mz2.p("startup").D("launch_type", String.valueOf(X.h("host_launch_type")));
                if (X.H() == 0) {
                    D0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                u0(true);
                if (ProcessUtils.isMainProcess() && (d2 = te2.c().d()) != null && d2.m()) {
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
            l63.a aVar = (l63.a) ((l63.a) new l63.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
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
            g63.K().p("event_pms_check_start");
            HybridUbcFlow p = mz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            er2 k0 = k0();
            if (n) {
                q0("预置包不可用");
            }
            boolean s0 = s0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + s0);
            }
            if (!s0) {
                if (!this.f) {
                    Set<gh4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = o13.i(this.m);
                    }
                    Set<gh4.a> set2 = this.g;
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
            jh4 jh4Var = new jh4(appId, k0.H());
            jh4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = 0;
            if (pMSAppInfo == null) {
                j2 = 0;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            jh4Var.u(j2);
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                j3 = pMSAppInfo2.appSign;
            }
            jh4Var.o(j3);
            String f2 = zj3.f(k0.f0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                jh4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((l63.a) new l63.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            cr2.b().g(appId);
            f0(jh4Var, false, null);
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
            HybridUbcFlow p = mz2.p("startup");
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
            dc2 c2 = gc2.b().c(getAppId());
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
            gc2.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final boolean a0(@NonNull jh4 jh4Var, ai3 ai3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, jh4Var, ai3Var)) == null) {
            String appId = getAppId();
            if (ai3Var != null && SwanAppNetworkUtils.i(op2.c()) && cr2.b().f(appId)) {
                h32.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + ai3Var.a());
                if (ai3Var.h() == 2101) {
                    cr2.b().a(appId);
                    mz2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(jh4Var, true, ai3Var);
                    return true;
                } else if (ai3Var.h() == 2205) {
                    te2.c().d().u(lk3.a(appId), true, 12);
                    cr2.b().a(appId);
                    mz2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(jh4Var, true, ai3Var);
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
                er2.a X = this.j.X();
                if (!g23.H() && TextUtils.isEmpty(X.h0()) && ((!n || !X.o0()) && !X.q0())) {
                    String W = X.W();
                    this.k = W;
                    if (n) {
                        mr2.d(W).f("start");
                    }
                    mo2.d("1");
                    HybridUbcFlow p = mz2.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(y42.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo g0 = this.j.X().g0();
                    if (g0 == null || g0.isMaxAgeExpires()) {
                        g0 = ee4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = or2.e(g0);
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
                    if (!this.l && or2.f(g0, X.f0())) {
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
            HybridUbcFlow p = mz2.p("startup");
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
                if (y42.a().c(getAppId())) {
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

    public final void e0(@NonNull String str, @NonNull n23 n23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, n23Var) == null) {
            c33 Q = c33.Q();
            if (Q == null) {
                k23 k23Var = new k23(n23Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                k23Var.b(bundle);
                n23Var.onEvent(k23Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, n23Var);
        }
    }

    public final void f0(@NonNull jh4 jh4Var, boolean z, @Nullable ai3 ai3Var) {
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{jh4Var, Boolean.valueOf(z), ai3Var}) == null) {
            HybridUbcFlow p = mz2.p("startup");
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            jh4Var.v(j2);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, jh4Var, p));
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jVar.L(i2);
            if (z && ai3Var != null) {
                jh4Var.p(ai3Var.h());
            }
            rd4.c(jh4Var, jVar);
        }
    }

    public synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !m0() && !n0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = mz2.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.X().H()) {
                        z = false;
                    }
                    if (z || !bd2.V().n0()) {
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
                if (u52.b.a()) {
                    this.j.K0(true);
                }
                if (n) {
                    q0("notifyMaintainFinish: " + z);
                }
                if (q() == g63.K().q()) {
                    A((l63.a) new l63.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    mr2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = mz2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                g63.M().post(new c(this, p));
            }
        }
    }
}
