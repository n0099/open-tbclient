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
import com.baidu.tieba.aw2;
import com.baidu.tieba.cm4;
import com.baidu.tieba.hb3;
import com.baidu.tieba.qa2;
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
/* loaded from: classes6.dex */
public final class jb3 extends lb3 implements xk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<cm4.a> g;
    public int h;
    public boolean i;
    public final db3 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jb3 jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var};
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
                cb3.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;
        public final /* synthetic */ int b;

        public b(jb3 jb3Var, aw2 aw2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, aw2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ jb3 b;

        public c(jb3 jb3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jb3Var;
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

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ jb3 b;

        public d(jb3 jb3Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jb3Var;
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
                if (jb3.n) {
                    jb3.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                t73 e = t73.e();
                v73 v73Var = new v73(17, bundle);
                v73Var.j(5000L);
                e.h(v73Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ah2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb3 a;

        public e(jb3 jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jb3Var;
        }

        @Override // com.baidu.tieba.ah2
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = i43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.ah2
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = i43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (jb3.n) {
                    jb3.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.ah2
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) != null) {
                return;
            }
            this.a.h = 5;
            jb3 jb3Var = this.a;
            jb3Var.b0("KEY_PKG_STATE", "event_pms_check_finish", jb3Var.h);
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (jb3.n) {
                jb3.p0("预制包安装成功");
            }
            jb3.o0(this.a.j0(), pMSAppInfo, false, false);
            this.a.M0(pMSAppInfo);
            this.a.I0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends j73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 c;
        public final /* synthetic */ jb3 d;

        @Override // com.baidu.tieba.j73, com.baidu.tieba.i73
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        public f(jb3 jb3Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jb3Var;
            this.c = aw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j73, com.baidu.tieba.k73, com.baidu.tieba.i73
        public void onEvent(@NonNull g73 g73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g73Var) == null) {
                Bundle a = g73Var.a();
                boolean z = false;
                if (a != null) {
                    z = a.getBoolean("isDownloading", false);
                }
                jb3.o0(this.c, this.d.m, true, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends be2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb3 h;

        public g(jb3 jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = jb3Var;
        }

        @Override // com.baidu.tieba.be2, com.baidu.tieba.yi4
        public void G(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, lo4Var) != null) {
                return;
            }
            this.h.c = true;
            cb3.K().p("event_pkg_download_start");
            super.G(lo4Var);
        }

        @Override // com.baidu.tieba.be2
        public void Q(@NonNull wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm3Var) == null) {
                an3.a().f(wm3Var);
                this.h.A0(wm3Var);
                this.h.t0(false);
            }
        }

        @Override // com.baidu.tieba.be2
        public void R() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.h.c = false;
            jb3.o0(this.h.j0(), this.h.m, false, false);
            jb3 jb3Var = this.h;
            if (jb3Var.i) {
                i = 3;
            } else {
                i = 4;
            }
            jb3Var.h = i;
            this.h.I0(null);
            jb3 jb3Var2 = this.h;
            jb3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", jb3Var2.h);
        }

        @Override // com.baidu.tieba.be2, com.baidu.tieba.yi4, com.baidu.tieba.vi4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.h.c = false;
            cb3.K().p("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements me2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fm4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ jb3 d;

        public h(jb3 jb3Var, boolean z, fm4 fm4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, Boolean.valueOf(z), fm4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jb3Var;
            this.a = z;
            this.b = fm4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.me2
        public void a(wm3 wm3Var, boolean z) {
            long a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, wm3Var, z) == null) {
                if (wm3Var == null) {
                    a = 0;
                } else {
                    a = wm3Var.a();
                }
                d82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    wh3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, wm3Var)) {
                    return;
                }
                this.d.c = false;
                cb3.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                an3.a().f(wm3Var);
                if (z) {
                    jb3 jb3Var = this.d;
                    if (jb3Var.i) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    jb3Var.h = i;
                    jb3 jb3Var2 = this.d;
                    jb3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", jb3Var2.h);
                    this.d.H0(wm3Var);
                } else if (wm3Var != null && wm3Var.h() == 1020) {
                    this.d.A0(wm3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (wm3Var != null && wm3Var.h() == 2203) {
                    d82.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                    if (bk2.a().b(1) == 0) {
                        bk2.a().c();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.me2
        public void b(PMSAppInfo pMSAppInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                d82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    wh3.L("pkg_retry_success", "");
                }
                int i2 = 0;
                this.d.c = false;
                jb3 jb3Var = this.d;
                if (jb3Var.e) {
                    i2 = 2;
                }
                jb3Var.h = i2;
                jb3 jb3Var2 = this.d;
                if (!jb3Var2.i) {
                    i = this.d.h;
                } else {
                    i = 1;
                }
                jb3Var2.h = i;
                jb3 jb3Var3 = this.d;
                jb3Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", jb3Var3.h);
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

    /* loaded from: classes6.dex */
    public class i implements wp3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ jb3 b;

        public i(jb3 jb3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jb3Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (jb3.n) {
                    jb3.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
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

    /* loaded from: classes6.dex */
    public class j extends ee2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ jb3 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(jb3 jb3Var, db3 db3Var, boolean z) {
            super(db3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, db3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((db3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = jb3Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.ee2, com.baidu.tieba.de2, com.baidu.tieba.yi4
        public void G(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lo4Var) == null) {
                d82.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                cb3.K().p("event_pkg_download_start");
                super.G(lo4Var);
            }
        }

        @Override // com.baidu.tieba.yi4, com.baidu.tieba.vi4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d82.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                cb3.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(gi3 gi3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jb3.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends d73 {
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

        @Override // com.baidu.tieba.d73
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
                boolean j = ni4.j(string);
                boolean k = ni4.k(string);
                if (d73.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947877486, "Lcom/baidu/tieba/jb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947877486, "Lcom/baidu/tieba/jb3;");
                return;
            }
        }
        n = nr1.a;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            if (w == null || w.isDestroyed()) {
                return ku2.c();
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
            zt2.O(this.j);
        }
    }

    public aw2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j.W();
        }
        return (aw2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return cb3.K().q().W().c("property_web_mode_degrade");
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
    public jb3(db3 db3Var) {
        super(db3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {db3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((gb3) newInitContext.callArgs[0]);
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
        this.j = db3Var;
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            v43.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final wm3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            wm3 wm3Var = new wm3();
            switch (i2) {
                case 10001:
                    wm3Var.k(10L);
                    wm3Var.i(2902L);
                    wm3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    wm3Var.k(10L);
                    wm3Var.i(27L);
                    wm3Var.f("category not match");
                    break;
                case 10003:
                    wm3Var.k(10L);
                    wm3Var.i(2107L);
                    wm3Var.d("app forbiddeon");
                    break;
                case 10004:
                    wm3Var.k(10L);
                    wm3Var.i(48L);
                    wm3Var.d("path forbiddeon");
                    break;
            }
            return wm3Var;
        }
        return (wm3) invokeI.objValue;
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final void H0(wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, wm3Var) == null) && F0(wm3Var)) {
            ei3 ei3Var = new ei3();
            ei3Var.p(wm3Var);
            ei3Var.r(j0());
            wh3.R(ei3Var);
        }
    }

    public void J0(Set<cm4.a> set) {
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

    public final void g0(Set<cm4.a> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            cm4 cm4Var = new cm4(set);
            cm4Var.d("3");
            g gVar = new g(this);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            gVar.L(i2);
            ni4.d(cm4Var, gVar);
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

    public static void n0(gi3 gi3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, gi3Var, str, str2) == null) {
            JSONObject k2 = wh3.k(str);
            gi3Var.d(str2);
            gi3Var.b(k2);
            wh3.onEvent(gi3Var);
        }
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            cb3.K().v(str2, bundle);
        }
    }

    public static String i0(Context context, wm3 wm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, wm3Var)) == null) {
            return String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01d2), xo3.D(), ik3.i(qw2.T().getCoreVersion(), cb3.K().q().k()), String.valueOf(wm3Var.a()));
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
                    d82.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    hb3.a aVar = (hb3.a) new hb3.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    wh3.V(z, str);
                }
                if (n) {
                    iw2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public static void o0(dw2 dw2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{dw2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            Bundle s0 = dw2Var.s0();
            String str3 = "1";
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            s0.putString("aiapp_extra_need_download", str);
            Bundle s02 = dw2Var.s0();
            if (z2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            s02.putString("aiapp_extra_pkg_downloading", str2);
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(dw2Var.G());
            gi3Var.h(dw2Var);
            gi3Var.b = "launch";
            if (!z) {
                str3 = "0";
            }
            gi3Var.o = str3;
            if (pMSAppInfo != null) {
                gi3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            w43.e().d(new k(gi3Var, dw2Var.W(), dw2Var.s0().getString("ubc")), "launchStatistic", true);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, aw2 aw2Var, boolean z, String str, wm3 wm3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, aw2Var, Boolean.valueOf(z), str, wm3Var}) != null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aw2Var, str, i0(context, wm3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        if (z) {
            str2 = "type_path_forbidden";
        } else {
            str2 = "type_app_forbidden";
        }
        xv2.l(context, str2, wm3Var, forbiddenInfo, aw2Var.D());
        gi3 gi3Var = new gi3();
        gi3Var.a = wh3.n(aw2Var.G());
        gi3Var.b = "launch";
        gi3Var.e = "success";
        gi3Var.i(aw2Var);
        gi3Var.a("status", "2");
        gi3Var.d(aw2Var.s0().getString("ubc"));
        wh3.onEvent(gi3Var);
    }

    public final void A0(wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wm3Var) == null) {
            i43.k(wm3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !mn3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            aw2 j0 = j0();
            int G = j0.G();
            if (!wm3Var.l()) {
                ei3 ei3Var = new ei3();
                ei3Var.q(wh3.n(G));
                ei3Var.p(wm3Var);
                ei3Var.m(getAppId());
                ei3Var.t(j0.T());
                wh3.R(ei3Var);
                wm3Var.n();
            }
            if (!rw2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                xo3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            xv2.g(ku2.c(), wm3Var, G, getAppId(), true, bundle);
            nh3.m(j0, G, wm3Var);
            ku2.p0().flush(false);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            aw2 j0 = j0();
            String c2 = kw2.c(this.m, j0.e0());
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
            aw2.a W = q().W();
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
                    xo3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final int E0(wm3 wm3Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wm3Var)) == null) {
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (wm3Var == null) {
                    wm3Var = new wm3();
                    wm3Var.k(10L);
                    wm3Var.i(2902L);
                    wm3Var.f("no pkg was installed");
                }
                an3.a().f(wm3Var);
                A0(wm3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (wq3.g(wm3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    wm3 h0 = h0(10003);
                    an3.a().f(h0);
                    z0(false, null, h0);
                    i43.k(h0);
                    ku2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<cm4.a> i2 = k63.i(this.m);
                    if (i2 != null && !i2.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f = z;
                    if (!z) {
                        wm3 wm3Var2 = new wm3();
                        wm3Var2.k(17L);
                        wm3Var2.i(2909L);
                        wm3Var2.f("dependent pkg is missing.");
                        an3.a().f(wm3Var2);
                        A0(wm3Var2);
                        return -1;
                    }
                }
                qw2 T2 = qw2.T();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (qd3.b().a(d13.d(e0, T2.z()))) {
                        wm3 h02 = h0(10004);
                        an3.a().f(h02);
                        z0(true, qd3.b().d(), h02);
                        i43.k(h02);
                        ku2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (wm3Var == null) {
                wm3Var = h0(Z);
            }
            an3.a().f(wm3Var);
            A0(wm3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(wm3 wm3Var) {
        InterceptResult invokeL;
        String str;
        nj2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wm3Var)) == null) {
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(wm3Var);
            if (E0 == -1) {
                d82.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                aw2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                if (j0 != null) {
                    str = j0.swanCoreVersionName;
                } else {
                    str = "0";
                }
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (so3.a(W.k0(), str)) {
                    ik3.n(W.G());
                }
                i43.p("startup").D("launch_type", String.valueOf(W.h("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = pj2.c().d()) != null && d2.m()) {
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
            hb3.a aVar = (hb3.a) ((hb3.a) new hb3.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
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
            cb3.K().p("event_pms_check_start");
            HybridUbcFlow p = i43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            aw2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<cm4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = k63.i(this.m);
                    }
                    Set<cm4.a> set2 = this.g;
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
            fm4 fm4Var = new fm4(appId, j0.G());
            fm4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = 0;
            if (pMSAppInfo == null) {
                j2 = 0;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            fm4Var.u(j2);
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                j3 = pMSAppInfo2.appSign;
            }
            fm4Var.o(j3);
            String f2 = vo3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                fm4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((hb3.a) new hb3.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            yv2.b().g(appId);
            f0(fm4Var, false, null);
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
            HybridUbcFlow p = i43.p("startup");
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
            zg2 c2 = ch2.b().c(getAppId());
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
            ch2.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final boolean a0(@NonNull fm4 fm4Var, wm3 wm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, fm4Var, wm3Var)) == null) {
            String appId = getAppId();
            if (wm3Var != null && SwanAppNetworkUtils.i(ku2.c()) && yv2.b().f(appId)) {
                d82.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + wm3Var.a());
                if (wm3Var.h() == 2101) {
                    yv2.b().a(appId);
                    i43.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(fm4Var, true, wm3Var);
                    return true;
                } else if (wm3Var.h() == 2205) {
                    pj2.c().d().u(hp3.a(appId), true, 12);
                    yv2.b().a(appId);
                    i43.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(fm4Var, true, wm3Var);
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
                aw2.a W = this.j.W();
                if (!c73.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        iw2.d(V).f("start");
                    }
                    it2.d("1");
                    HybridUbcFlow p = i43.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(u92.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = aj4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = kw2.e(f0);
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
                    if (!this.l && kw2.f(f0, W.e0())) {
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
            HybridUbcFlow p = i43.p("startup");
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
                if (u92.a().c(getAppId())) {
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

    public final void e0(@NonNull String str, @NonNull j73 j73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, j73Var) == null) {
            y73 Q = y73.Q();
            if (Q == null) {
                g73 g73Var = new g73(j73Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                g73Var.setResult(bundle);
                j73Var.onEvent(g73Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, j73Var);
        }
    }

    public final void f0(@NonNull fm4 fm4Var, boolean z, @Nullable wm3 wm3Var) {
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{fm4Var, Boolean.valueOf(z), wm3Var}) == null) {
            HybridUbcFlow p = i43.p("startup");
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            fm4Var.v(j2);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, fm4Var, p));
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jVar.L(i2);
            if (z && wm3Var != null) {
                fm4Var.p(wm3Var.h());
            }
            ni4.c(fm4Var, jVar);
        }
    }

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = i43.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !xh2.U().m0()) {
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
                if (qa2.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == cb3.K().q()) {
                    A((hb3.a) new hb3.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    iw2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = i43.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                cb3.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, wm3Var}) != null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, wm3Var);
    }
}
