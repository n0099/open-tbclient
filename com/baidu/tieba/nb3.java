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
import com.baidu.tieba.ew2;
import com.baidu.tieba.gm4;
import com.baidu.tieba.lb3;
import com.baidu.tieba.ua2;
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
public final class nb3 extends pb3 implements bl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<gm4.a> g;
    public int h;
    public boolean i;
    public final hb3 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nb3 nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var};
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
                gb3.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ int b;

        public b(nb3 nb3Var, ew2 ew2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, ew2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew2Var;
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ nb3 b;

        public c(nb3 nb3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nb3Var;
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
        public final /* synthetic */ nb3 b;

        public d(nb3 nb3Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nb3Var;
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
                if (nb3.n) {
                    nb3.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                x73 e = x73.e();
                z73 z73Var = new z73(17, bundle);
                z73Var.j(5000L);
                e.h(z73Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements eh2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb3 a;

        public e(nb3 nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb3Var;
        }

        @Override // com.baidu.tieba.eh2
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = m43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.eh2
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = m43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (nb3.n) {
                    nb3.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.eh2
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) != null) {
                return;
            }
            this.a.h = 5;
            nb3 nb3Var = this.a;
            nb3Var.b0("KEY_PKG_STATE", "event_pms_check_finish", nb3Var.h);
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (nb3.n) {
                nb3.p0("预制包安装成功");
            }
            nb3.o0(this.a.j0(), pMSAppInfo, false, false);
            this.a.M0(pMSAppInfo);
            this.a.I0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends n73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ nb3 d;

        @Override // com.baidu.tieba.n73, com.baidu.tieba.m73
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        public f(nb3 nb3Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nb3Var;
            this.c = ew2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n73, com.baidu.tieba.o73, com.baidu.tieba.m73
        public void onEvent(@NonNull k73 k73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k73Var) == null) {
                Bundle a = k73Var.a();
                boolean z = false;
                if (a != null) {
                    z = a.getBoolean("isDownloading", false);
                }
                nb3.o0(this.c, this.d.m, true, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends fe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb3 h;

        public g(nb3 nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = nb3Var;
        }

        @Override // com.baidu.tieba.fe2, com.baidu.tieba.cj4
        public void G(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, po4Var) != null) {
                return;
            }
            this.h.c = true;
            gb3.K().p("event_pkg_download_start");
            super.G(po4Var);
        }

        @Override // com.baidu.tieba.fe2
        public void Q(@NonNull an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an3Var) == null) {
                en3.a().f(an3Var);
                this.h.A0(an3Var);
                this.h.t0(false);
            }
        }

        @Override // com.baidu.tieba.fe2
        public void R() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.h.c = false;
            nb3.o0(this.h.j0(), this.h.m, false, false);
            nb3 nb3Var = this.h;
            if (nb3Var.i) {
                i = 3;
            } else {
                i = 4;
            }
            nb3Var.h = i;
            this.h.I0(null);
            nb3 nb3Var2 = this.h;
            nb3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", nb3Var2.h);
        }

        @Override // com.baidu.tieba.fe2, com.baidu.tieba.cj4, com.baidu.tieba.zi4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.h.c = false;
            gb3.K().p("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements qe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ jm4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ nb3 d;

        public h(nb3 nb3Var, boolean z, jm4 jm4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, Boolean.valueOf(z), jm4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nb3Var;
            this.a = z;
            this.b = jm4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.qe2
        public void a(an3 an3Var, boolean z) {
            long a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, an3Var, z) == null) {
                if (an3Var == null) {
                    a = 0;
                } else {
                    a = an3Var.a();
                }
                h82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    ai3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, an3Var)) {
                    return;
                }
                this.d.c = false;
                gb3.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                en3.a().f(an3Var);
                if (z) {
                    nb3 nb3Var = this.d;
                    if (nb3Var.i) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    nb3Var.h = i;
                    nb3 nb3Var2 = this.d;
                    nb3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", nb3Var2.h);
                    this.d.H0(an3Var);
                } else if (an3Var != null && an3Var.h() == 1020) {
                    this.d.A0(an3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (an3Var != null && an3Var.h() == 2203) {
                    h82.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                    if (fk2.a().b(1) == 0) {
                        fk2.a().c();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qe2
        public void b(PMSAppInfo pMSAppInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                h82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    ai3.L("pkg_retry_success", "");
                }
                int i2 = 0;
                this.d.c = false;
                nb3 nb3Var = this.d;
                if (nb3Var.e) {
                    i2 = 2;
                }
                nb3Var.h = i2;
                nb3 nb3Var2 = this.d;
                if (!nb3Var2.i) {
                    i = this.d.h;
                } else {
                    i = 1;
                }
                nb3Var2.h = i;
                nb3 nb3Var3 = this.d;
                nb3Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", nb3Var3.h);
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

    /* loaded from: classes7.dex */
    public class i implements aq3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ nb3 b;

        public i(nb3 nb3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nb3Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (nb3.n) {
                    nb3.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
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

    /* loaded from: classes7.dex */
    public class j extends ie2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ nb3 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(nb3 nb3Var, hb3 hb3Var, boolean z) {
            super(hb3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb3Var, hb3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((hb3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = nb3Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.ie2, com.baidu.tieba.he2, com.baidu.tieba.cj4
        public void G(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, po4Var) == null) {
                h82.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                gb3.K().p("event_pkg_download_start");
                super.G(po4Var);
            }
        }

        @Override // com.baidu.tieba.cj4, com.baidu.tieba.zi4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h82.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                gb3.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(ki3 ki3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nb3.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l extends h73 {
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

        @Override // com.baidu.tieba.h73
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
                boolean j = ri4.j(string);
                boolean k = ri4.k(string);
                if (h73.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996650, "Lcom/baidu/tieba/nb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996650, "Lcom/baidu/tieba/nb3;");
                return;
            }
        }
        n = rr1.a;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            if (w == null || w.isDestroyed()) {
                return ou2.c();
            }
            return w;
        }
        return (Context) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            du2.O(this.j);
        }
    }

    public ew2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j.W();
        }
        return (ew2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return gb3.K().q().W().c("property_web_mode_degrade");
        }
        return invokeV.booleanValue;
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

    public synchronized void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                v0(true, null);
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

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nb3(hb3 hb3Var) {
        super(hb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((kb3) newInitContext.callArgs[0]);
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
        this.j = hb3Var;
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            z43.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final an3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            an3 an3Var = new an3();
            switch (i2) {
                case 10001:
                    an3Var.k(10L);
                    an3Var.i(2902L);
                    an3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    an3Var.k(10L);
                    an3Var.i(27L);
                    an3Var.f("category not match");
                    break;
                case 10003:
                    an3Var.k(10L);
                    an3Var.i(2107L);
                    an3Var.d("app forbiddeon");
                    break;
                case 10004:
                    an3Var.k(10L);
                    an3Var.i(48L);
                    an3Var.d("path forbiddeon");
                    break;
            }
            return an3Var;
        }
        return (an3) invokeI.objValue;
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final void H0(an3 an3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, an3Var) == null) && F0(an3Var)) {
            ii3 ii3Var = new ii3();
            ii3Var.p(an3Var);
            ii3Var.r(j0());
            ai3.R(ii3Var);
        }
    }

    public void J0(Set<gm4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
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
            if (i3 <= -1 && G != i3) {
                return 10002;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void g0(Set<gm4.a> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            gm4 gm4Var = new gm4(set);
            gm4Var.d("3");
            g gVar = new g(this);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            gVar.L(i2);
            ri4.d(gm4Var, gVar);
        }
    }

    public final void N0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pMSAppInfo, hybridUbcFlow) == null) && pMSAppInfo != null && hybridUbcFlow != null) {
            M0(pMSAppInfo);
            c0(this.m);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
            ubcFlowEvent.a(true);
            hybridUbcFlow.F(ubcFlowEvent);
        }
    }

    public static void n0(ki3 ki3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, ki3Var, str, str2) == null) {
            JSONObject k2 = ai3.k(str);
            ki3Var.d(str2);
            ki3Var.b(k2);
            ai3.onEvent(ki3Var);
        }
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            gb3.K().v(str2, bundle);
        }
    }

    public static String i0(Context context, an3 an3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, an3Var)) == null) {
            return String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01d2), bp3.D(), mk3.i(uw2.T().getCoreVersion(), gb3.K().q().k()), String.valueOf(an3Var.a()));
        }
        return (String) invokeLL.objValue;
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
                    h82.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    lb3.a aVar = (lb3.a) new lb3.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    ai3.V(z, str);
                }
                if (n) {
                    mw2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public static void o0(hw2 hw2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{hw2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            Bundle s0 = hw2Var.s0();
            String str3 = "1";
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            s0.putString("aiapp_extra_need_download", str);
            Bundle s02 = hw2Var.s0();
            if (z2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            s02.putString("aiapp_extra_pkg_downloading", str2);
            ki3 ki3Var = new ki3();
            ki3Var.a = ai3.n(hw2Var.G());
            ki3Var.h(hw2Var);
            ki3Var.b = "launch";
            if (!z) {
                str3 = "0";
            }
            ki3Var.o = str3;
            if (pMSAppInfo != null) {
                ki3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            a53.e().d(new k(ki3Var, hw2Var.W(), hw2Var.s0().getString("ubc")), "launchStatistic", true);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, ew2 ew2Var, boolean z, String str, an3 an3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, ew2Var, Boolean.valueOf(z), str, an3Var}) != null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(ew2Var, str, i0(context, an3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        if (z) {
            str2 = "type_path_forbidden";
        } else {
            str2 = "type_app_forbidden";
        }
        bw2.l(context, str2, an3Var, forbiddenInfo, ew2Var.D());
        ki3 ki3Var = new ki3();
        ki3Var.a = ai3.n(ew2Var.G());
        ki3Var.b = "launch";
        ki3Var.e = "success";
        ki3Var.i(ew2Var);
        ki3Var.a("status", "2");
        ki3Var.d(ew2Var.s0().getString("ubc"));
        ai3.onEvent(ki3Var);
    }

    public final void A0(an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, an3Var) == null) {
            m43.k(an3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !qn3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            ew2 j0 = j0();
            int G = j0.G();
            if (!an3Var.l()) {
                ii3 ii3Var = new ii3();
                ii3Var.q(ai3.n(G));
                ii3Var.p(an3Var);
                ii3Var.m(getAppId());
                ii3Var.t(j0.T());
                ai3.R(ii3Var);
                an3Var.n();
            }
            if (!vw2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                bp3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            bw2.g(ou2.c(), an3Var, G, getAppId(), true, bundle);
            rh3.m(j0, G, an3Var);
            ou2.p0().flush(false);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            ew2 j0 = j0();
            String c2 = ow2.c(this.m, j0.e0());
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

    public final void G0() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ew2.a W = q().W();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z2 = false;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId) && TextUtils.equals(getAppId(), this.m.appId)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                W.S0(this.m);
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
                    W.u0(i2);
                } else {
                    bp3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final int E0(an3 an3Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, an3Var)) == null) {
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (an3Var == null) {
                    an3Var = new an3();
                    an3Var.k(10L);
                    an3Var.i(2902L);
                    an3Var.f("no pkg was installed");
                }
                en3.a().f(an3Var);
                A0(an3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (ar3.g(an3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    an3 h0 = h0(10003);
                    en3.a().f(h0);
                    z0(false, null, h0);
                    m43.k(h0);
                    ou2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<gm4.a> i2 = o63.i(this.m);
                    if (i2 != null && !i2.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f = z;
                    if (!z) {
                        an3 an3Var2 = new an3();
                        an3Var2.k(17L);
                        an3Var2.i(2909L);
                        an3Var2.f("dependent pkg is missing.");
                        en3.a().f(an3Var2);
                        A0(an3Var2);
                        return -1;
                    }
                }
                uw2 T2 = uw2.T();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (ud3.b().a(h13.d(e0, T2.z()))) {
                        an3 h02 = h0(10004);
                        en3.a().f(h02);
                        z0(true, ud3.b().d(), h02);
                        m43.k(h02);
                        ou2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (an3Var == null) {
                an3Var = h0(Z);
            }
            en3.a().f(an3Var);
            A0(an3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(an3 an3Var) {
        InterceptResult invokeL;
        String str;
        rj2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, an3Var)) == null) {
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(an3Var);
            if (E0 == -1) {
                h82.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                ew2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                if (j0 != null) {
                    str = j0.swanCoreVersionName;
                } else {
                    str = "0";
                }
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (wo3.a(W.k0(), str)) {
                    mk3.n(W.G());
                }
                m43.p("startup").D("launch_type", String.valueOf(W.h("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = tj2.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, pMSAppInfo) == null) && pMSAppInfo != null) {
            lb3.a aVar = (lb3.a) ((lb3.a) new lb3.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
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
    }

    public final void K0() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gb3.K().p("event_pms_check_start");
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            ew2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<gm4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = o63.i(this.m);
                    }
                    Set<gm4.a> set2 = this.g;
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
                int i2 = 4;
                this.h = 4;
                o0(j0, this.m, false, false);
                if (this.i) {
                    i2 = 3;
                }
                this.h = i2;
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
            jm4 jm4Var = new jm4(appId, j0.G());
            jm4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = 0;
            if (pMSAppInfo == null) {
                j2 = 0;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            jm4Var.u(j2);
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                j3 = pMSAppInfo2.appSign;
            }
            jm4Var.o(j3);
            String f2 = zo3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                jm4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((lb3.a) new lb3.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            cw2.b().g(appId);
            f0(jm4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void L0() {
        long j2;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                if (this.m == null) {
                    str = "数据库或本地无主包信息，尝试加载预置包，并下载主包";
                } else {
                    str = "包信息、文件都存在，尝试加载更高版本的预置包";
                }
                p0(str);
            }
            dh2 c2 = gh2.b().c(getAppId());
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
            gh2.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final boolean a0(@NonNull jm4 jm4Var, an3 an3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, jm4Var, an3Var)) == null) {
            String appId = getAppId();
            if (an3Var != null && SwanAppNetworkUtils.i(ou2.c()) && cw2.b().f(appId)) {
                h82.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + an3Var.a());
                if (an3Var.h() == 2101) {
                    cw2.b().a(appId);
                    m43.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(jm4Var, true, an3Var);
                    return true;
                } else if (an3Var.h() == 2205) {
                    tj2.c().d().u(lp3.a(appId), true, 12);
                    cw2.b().a(appId);
                    m43.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(jm4Var, true, an3Var);
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
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                ew2.a W = this.j.W();
                if (!g73.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        mw2.d(V).f("start");
                    }
                    mt2.d("1");
                    HybridUbcFlow p = m43.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(y92.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = ej4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = ow2.e(f0);
                    this.l = e2;
                    if (f0 != null && !e2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.e = z;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        N0(f0, p);
                    }
                    if (!this.l && ow2.f(f0, W.e0())) {
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

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HybridUbcFlow p = m43.p("startup");
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
                if (y92.a().c(getAppId())) {
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

    public final void e0(@NonNull String str, @NonNull n73 n73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, n73Var) == null) {
            c83 Q = c83.Q();
            if (Q == null) {
                k73 k73Var = new k73(n73Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                k73Var.setResult(bundle);
                n73Var.onEvent(k73Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, n73Var);
        }
    }

    public final void f0(@NonNull jm4 jm4Var, boolean z, @Nullable an3 an3Var) {
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jm4Var, Boolean.valueOf(z), an3Var}) == null) {
            HybridUbcFlow p = m43.p("startup");
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            jm4Var.v(j2);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, jm4Var, p));
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jVar.L(i2);
            if (z && an3Var != null) {
                jm4Var.p(an3Var.h());
            }
            ri4.c(jm4Var, jVar);
        }
    }

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = m43.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !bi2.U().m0()) {
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

    public final synchronized void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (ua2.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == gb3.K().q()) {
                    A((lb3.a) new lb3.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    mw2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = m43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                gb3.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, an3 an3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, an3Var}) != null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, an3Var);
    }
}
