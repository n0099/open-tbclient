package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ch2;
import com.baidu.tieba.fh2;
import com.baidu.tieba.gi3;
import com.baidu.tieba.uu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class si2 implements nx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile si2 B;
    public static int C;
    public static boolean D;
    public static PreloadState E;
    public static boolean F;
    public static final boolean G;
    public static int H;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion a;
    @Nullable
    public ExtensionCore b;
    public ab2 c;
    public List<s> d;
    public final List<ma2> e;
    public be2<ae2> f;
    public ud2 g;
    public boolean h;
    public ey1<?> i;
    public ey1<?> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, gy1> o;
    public LinkedList<yl2> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public zx1 v;
    public ky1 w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.nx2
    public void a(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gy1Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nx2
    public void c(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gy1Var) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.si2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0457a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0457a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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
                    si2.N0(false);
                }
            }
        }

        public a() {
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

        @Override // com.baidu.tieba.si2.s
        public void c(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si2Var) == null) {
                boolean z = !TextUtils.isEmpty(xb3.K().getAppId());
                y82.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (!z) {
                    xb3.K().y().Y(15);
                    sp3.e0(new RunnableC0457a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends ma2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud2 a;
        public final /* synthetic */ vw2 b;
        public final /* synthetic */ uu2.g c;
        public final /* synthetic */ si2 d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.a;
                    ud2 ud2Var = gVar.a;
                    ey1 ey1Var = gVar.d.j;
                    g gVar2 = this.a;
                    jf3.i(ud2Var, ey1Var, gVar2.b, gVar2.c);
                    si2 si2Var = this.a.d;
                    si2Var.M0(si2Var.i);
                }
            }
        }

        public g(si2 si2Var, ud2 ud2Var, vw2 vw2Var, uu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, ud2Var, vw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = si2Var;
            this.a = ud2Var;
            this.b = vw2Var;
            this.c = gVar;
        }

        @Override // com.baidu.tieba.ma2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.d.r) {
                this.d.l = true;
            }
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            y82.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            sp3.e0(new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ si2 a;

            public a(k kVar, si2 si2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, si2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = si2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.e1();
            }
        }

        public k(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.si2.s
        public void c(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si2Var) == null) {
                if (si2.A) {
                    xq4.b().e();
                    qb3 f = qb3.f(si2.p(), R.string.obfuscated_res_0x7f0f01d7);
                    f.l(1);
                    f.G();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                sp3.a0(new a(this, si2Var));
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                t83.Q().Y(14);
                if (ii2.f() || ii2.g()) {
                    this.a.F0();
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "prepare " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw2 a;
        public final /* synthetic */ uu2.g b;
        public final /* synthetic */ si2 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ si2 a;
            public final /* synthetic */ m b;

            public a(m mVar, si2 si2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, si2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = si2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.m) {
                    return;
                }
                d53.p("startup").F(new UbcFlowEvent("na_pre_load_ok"));
                yh3.d().i("na_pre_load_ok");
                d53.h("preload", "startup");
                m mVar = this.b;
                mVar.c.t0(this.a, mVar.a, mVar.b);
                d53.j(this.b.a, false);
            }
        }

        public m(si2 si2Var, vw2 vw2Var, uu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, vw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = si2Var;
            this.a = vw2Var;
            this.b = gVar;
        }

        @Override // com.baidu.tieba.si2.s
        public void c(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si2Var) == null) {
                sp3.e0(new a(this, si2Var));
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "startFirstPage " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements ab2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ si2 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (si2.A) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.a.b.m);
                    }
                    if (this.a.b.m) {
                        if (si2.A) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.a.b.g1();
                    this.a.b.f1();
                    if (this.a.b.a != null) {
                        q qVar = this.a;
                        qVar.b.E0(qVar.a);
                        this.a.b.L0();
                        return;
                    }
                    PreloadState unused = si2.E = PreloadState.LOAD_FAILED;
                    this.a.b.h0();
                }
            }
        }

        public q(si2 si2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = si2Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.ab2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (si2.A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                sp3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;
        public static final int b;
        public static int c;
        public static int d;
        public static t e;
        public static final Runnable f;
        public static final Runnable g;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || xb3.K().q().y0()) {
                    return;
                }
                if (si2.B.m0()) {
                    y82.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    return;
                }
                boolean z = true;
                if (u.d >= 1) {
                    y82.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                if (!((u.e == null || !u.e.a()) ? false : false)) {
                    if (u.e == null) {
                        t unused = u.e = new t(xb3.K().getMainLooper());
                    }
                    u.e.e(r.d());
                }
                y82.k("SwanAppCoreRuntime", "start retry runtime.");
                si2.P0();
                rn3 rn3Var = new rn3();
                rn3Var.k(5L);
                rn3Var.i(49L);
                rn3Var.f("start retry");
                u.j(rn3Var);
            }
        }

        /* loaded from: classes7.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || xb3.K().q().y0()) {
                    return;
                }
                if (si2.B.m0()) {
                    y82.k("SwanAppCoreRuntime", "Retry: successfully.");
                } else if (u.d >= 1) {
                    y82.k("SwanAppCoreRuntime", "isMasterReady:" + si2.B.k0() + ",isSlaveReady:" + si2.B.n0());
                    rn3 rn3Var = new rn3();
                    rn3Var.k(5L);
                    rn3Var.i(49L);
                    rn3Var.f("retry timeout");
                    u.j(rn3Var);
                    if (mx2.a().b()) {
                        sw2.e(si2.p(), rn3Var, 0, xb3.K().getAppId());
                        ii3.m(xb3.K().q().W(), 0, rn3Var);
                        fv2.p0().flush(false);
                    }
                    ho3.j(xb3.K().w());
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-431398212, "Lcom/baidu/tieba/si2$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-431398212, "Lcom/baidu/tieba/si2$u;");
                    return;
                }
            }
            a = r.b();
            b = r.a();
            c = 0;
            d = 0;
            f = new a();
            g = new b();
        }

        public static /* synthetic */ CopyOnWriteArrayList a() {
            return g();
        }

        public static CopyOnWriteArrayList<s> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                return new CopyOnWriteArrayList<>(si2.B.d);
            }
            return (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                d++;
                y82.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + d);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                d = c;
            }
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) {
                if (bool.booleanValue()) {
                    return a;
                }
                return b;
            }
            return invokeL.intValue;
        }

        public static void j(rn3 rn3Var) {
            yb3 q;
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65546, null, rn3Var) != null) || (q = xb3.K().q()) == null || (k = q.k()) != 0) {
                return;
            }
            zi3 zi3Var = new zi3();
            zi3Var.p(rn3Var);
            zi3Var.r(q.Y());
            zi3Var.q(ri3.n(k));
            zi3Var.m(yb3.g0());
            ri3.R(zi3Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements de2<ae2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public b(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.de2
        /* renamed from: b */
        public void a(boolean z, ae2 ae2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, ae2Var) != null) {
                return;
            }
            this.a.y = z;
            if (z) {
                d53.p("startup").D("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements je2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public c(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.je2
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ma2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public d(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.ma2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                y82.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ma2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public e(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.ma2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                y82.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.v0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ma2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public f(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.ma2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.a.r) {
                this.a.l = true;
            }
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            for (ma2 ma2Var : this.a.e) {
                ma2Var.a(str);
            }
            this.a.e.clear();
            y82.k("SwanAppCoreRuntime", "prepareNaSlave finished");
        }
    }

    /* loaded from: classes7.dex */
    public class h implements rq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public h(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) != null) {
                return;
            }
            this.a.T0(u.h(bool));
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq3 a;

        public i(si2 si2Var, rq3 rq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, rq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = fv2.u0().a();
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a);
                }
                rq3 rq3Var = this.a;
                if (rq3Var != null) {
                    rq3Var.a(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
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
                lo3.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si2 a;

        public l(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si2Var;
        }

        @Override // com.baidu.tieba.si2.s
        public void c(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si2Var) == null) {
                if (ii2.f() || ii2.g()) {
                    this.a.F0();
                }
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(si2 si2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jf3.k(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
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
                jf3.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb3 a;
        public final /* synthetic */ si2 b;

        public p(si2 si2Var, yb3 yb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var, yb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = si2Var;
            this.a = yb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean equals;
            ud2 ud2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ii2.d() && TextUtils.isEmpty(lx2.T().z()) && !ii2.h(this.a)) {
                    if (si2.A) {
                        Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                        return;
                    }
                    return;
                }
                String d = jf3.d(lx2.T(), this.a.Y(), this.a.Q());
                int c = ii2.c(d);
                if (!this.b.O(c)) {
                    ni2.c(11);
                    return;
                }
                ey1 ey1Var = null;
                if (fh2.a.b()) {
                    equals = true;
                } else {
                    SwanAppConfigData Q = this.a.Q();
                    if (Q != null) {
                        str = Q.h(d);
                    } else {
                        str = null;
                    }
                    equals = "main".equals(str);
                    int i = 0;
                    if (str == null) {
                        i = 12;
                    } else if (!equals) {
                        i = 13;
                    }
                    if (i != 0) {
                        ni2.c(i);
                    }
                }
                if (c != 0 || this.b.i == null) {
                    if (c == 1 && this.b.j != null) {
                        ey1Var = this.b.j;
                    }
                } else {
                    ey1Var = this.b.i;
                }
                ey1 ey1Var2 = ey1Var;
                if (ey1Var2 == null) {
                    return;
                }
                if (equals && this.a.Q() != null) {
                    if (si2.G) {
                        ud2Var = ((ae2) this.b.f.e(this.a.W().f0())).i();
                    } else {
                        ud2Var = this.b.g;
                    }
                    gh2.c().b(ud2Var, ey1Var2, this.a.Y(), this.a.Q(), null, true);
                } else if (this.a.Q() == null) {
                    ni2.c(15);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-431398305, "Lcom/baidu/tieba/si2$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-431398305, "Lcom/baidu/tieba/si2$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                fv2.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
                }
                return 6000;
            }
            return invokeV.intValue;
        }

        public static int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                fv2.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                fv2.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (si2.A) {
                    Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                if (c() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                y82.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (a < 0) {
                    fv2.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    a = 0;
                }
                return a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class s implements rq3<si2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void c(si2 si2Var);

        public s() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, si2Var) == null) {
                c(si2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class t extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return hasMessages(1002);
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return hasMessages(1001);
            }
            return invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                removeCallbacksAndMessages(null);
                removeCallbacks(u.f);
                removeCallbacks(u.g);
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                sendEmptyMessageDelayed(1001, i);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                int i = message.what;
                if (i == 1001) {
                    u.f.run();
                } else if (i == 1002) {
                    u.g.run();
                }
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                sendEmptyMessageDelayed(1002, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public static boolean b;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "V8" : i == 0 ? WebView.LOGTAG : "AB" : (String) invokeI.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-431398181, "Lcom/baidu/tieba/si2$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-431398181, "Lcom/baidu/tieba/si2$v;");
                    return;
                }
            }
            boolean x = fv2.g0().x();
            a = x;
            b = x;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
            }
            return (String) invokeV.objValue;
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                b = a;
            }
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (si2.A) {
                    String a2 = a();
                    char c = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -1406842887) {
                        if (hashCode != 2081) {
                            if (hashCode == 2722 && a2.equals("V8")) {
                                c = 0;
                            }
                        } else if (a2.equals("AB")) {
                            c = 2;
                        }
                    } else if (a2.equals(WebView.LOGTAG)) {
                        c = 1;
                    }
                    if (c == 0) {
                        return true;
                    }
                    if (c == 1) {
                        return false;
                    }
                }
                return b;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String a2 = a();
                if (a2.equals("V8")) {
                    return true;
                }
                if (a2.equals("AB")) {
                    return fv2.g0().x();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                a = intent.getBooleanExtra("bundle_key_v8_ab", a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948152301, "Lcom/baidu/tieba/si2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948152301, "Lcom/baidu/tieba/si2;");
                return;
            }
        }
        A = is1.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = yf2.h();
        H = -1;
    }

    public static void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            if (G) {
                if (B.f != null) {
                    B.f.reset();
                }
            } else if (B.g != null) {
                if (B.g instanceof yd2) {
                    B.g.destroy();
                }
                B.g = null;
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ii2.d() && !l0() && this.j == null) {
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, new f(this));
            i0();
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!TextUtils.isEmpty(c0())) {
                return c0() + "runtime/index.js";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                y82.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Y0(dl3.g(0));
            }
        }
    }

    public si2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.p = new LinkedList<>();
        this.q = new Object();
        this.r = new Object();
        this.s = UUID.randomUUID().toString();
        this.x = false;
        this.z = false;
        ox2.e(this);
        this.o = new HashMap<>();
        this.v = fv2.F0();
        this.w = oy1.a().b().a();
        if (G) {
            this.f = new me2();
        }
    }

    public String X() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            g1();
            if (r0()) {
                str = Y();
            } else {
                str = this.a.swanCorePath + File.separator + "master/master.html";
            }
            if (la2.d()) {
                L(str, false);
            } else if (p92.d()) {
                o92.k();
                o92.g().h("loadmaster");
                return p92.a();
            } else {
                la2.g(str);
            }
            return qp3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.x) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                    return;
                }
                return;
            }
            boolean z = true;
            this.x = true;
            xb3 K = xb3.K();
            z = (K == null || !K.E()) ? false : false;
            boolean v2 = fv2.g0().v();
            if (!z && v2) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                di2.n(getContext());
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + v2);
            }
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048641, this) != null) || this.d.isEmpty()) {
            return;
        }
        M();
        E = PreloadState.LOADED;
        u.k();
        R("event_preload_finish");
        d53.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        ne2.i().q();
        for (s sVar : this.d) {
            if (sVar != null) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "onReady result: " + sVar.toString());
                }
                sVar.a(this);
            }
        }
        this.d.clear();
    }

    public static int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return C0().statsCode(F);
        }
        return invokeV.intValue;
    }

    public static PreloadState C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return E;
        }
        return (PreloadState) invokeV.objValue;
    }

    public static synchronized void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (si2.class) {
                y82.k("SwanAppCoreRuntime", "releaseAndRetry");
                O0(false, true);
            }
        }
    }

    public static si2 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (B == null) {
                synchronized (si2.class) {
                    if (B == null) {
                        B = new si2();
                    }
                }
            }
            return B;
        }
        return (si2) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static /* synthetic */ Context p() {
        return getContext();
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H0(new k(this));
        }
    }

    public final void M() {
        be2<ae2> be2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (be2Var = this.f) != null && E != PreloadState.LOADED) {
            be2Var.c(new b(this));
        }
    }

    @Nullable
    public ExtensionCore T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, gy1> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.o;
        }
        return (HashMap) invokeV.objValue;
    }

    public ud2 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (G) {
                if (!this.f.g()) {
                    return null;
                }
                return ((ae2) this.f.a()).i();
            }
            return this.g;
        }
        return (ud2) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            sp3.e0(new o(this));
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.a == null) {
                return "";
            }
            return this.a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.a;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public zx1 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.v;
        }
        return (zx1) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                y82.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                X0(hm2.c(0));
            }
        }
    }

    @Nullable
    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            i0();
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            synchronized (this.q) {
                z = this.h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            synchronized (this.r) {
                z = this.l;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            synchronized (this.q) {
                if (this.h && this.k) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            synchronized (this.q) {
                z = this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (G) {
                return this.f.i();
            }
            return this.g instanceof yd2;
        }
        return invokeV.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048642, this) != null) || this.d.isEmpty() || !m0()) {
            return;
        }
        u0();
    }

    public static synchronized void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            synchronized (si2.class) {
                y82.k("SwanAppCoreRuntime", "release");
                O0(z, false);
            }
        }
    }

    public void K(@NonNull ma2 ma2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ma2Var) == null) {
            this.e.add(ma2Var);
        }
    }

    public final void M0(ey1<?> ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ey1Var) == null) {
            if (ey1Var != null) {
                di2.p(ey1Var);
            }
            this.i = null;
            this.j = null;
        }
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0 && m0() && this.i != null) {
                return true;
            }
            if (i2 == 1 && l0() && this.j != null) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", E.statsCode(F));
            xb3.K().v(str, bundle);
        }
    }

    public final void S(rq3<Boolean> rq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rq3Var) == null) {
            so3.k(new i(this, rq3Var), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    public void W0(@NonNull yb3 yb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, yb3Var) == null) {
            sp3.e0(new p(this, yb3Var));
        }
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            sp3.e0(new n(this, str));
        }
    }

    public void c1(vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, vw2Var) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null) {
                vw2Var.C0(extensionCore);
            } else {
                this.b = vw2Var.O();
            }
        }
    }

    @Override // com.baidu.tieba.nx2
    public void d(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, gy1Var) == null) {
            this.o.put(gy1Var.a(), gy1Var);
        }
    }

    public void d1(vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, vw2Var) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                vw2Var.Z0(swanCoreVersion);
            } else {
                this.a = vw2Var.j0();
            }
        }
    }

    public gy1 e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (!this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                return this.o.get(str);
            }
            return null;
        }
        return (gy1) invokeL.objValue;
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.n = z;
        }
    }

    public void z0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, intent) == null) {
            A0(intent, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.baidu.tieba.si2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void O0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (si2.class) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "release");
                }
                if (B == null) {
                    return;
                }
                E = PreloadState.UNKNOWN;
                B.m = true;
                B.u = null;
                D = false;
                if (z2) {
                    u.i();
                    copyOnWriteArrayList = u.a();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (B.c != null) {
                    B.w.a(B.c);
                }
                i32.f();
                el3.c();
                S0();
                ox2.f(B);
                B = null;
                gh2.c().d();
                F = z;
                U().A0(null, copyOnWriteArrayList);
            }
        }
    }

    public void Z0(vw2 vw2Var, uu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, vw2Var, gVar) == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + vw2Var.j0());
            }
            d1(vw2Var);
            c1(vw2Var);
            d53.o().F(new UbcFlowEvent("na_pre_load_check"));
            yh3.d().i("na_pre_load_check");
            H0(new m(this, vw2Var, gVar));
        }
    }

    public final void y0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048645, this, str, prefetchEvent) != null) || !yf2.o()) {
            return;
        }
        ey1<?> ey1Var = this.i;
        if (ey1Var != null && n0()) {
            y82.i(PrefetchEvent.MODULE, "start prefetch slave");
            long j2 = 0;
            if (A) {
                j2 = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave start");
            }
            yb3 q2 = xb3.K().q();
            if (q2 == null) {
                return;
            }
            xg2 a2 = xg2.a(ey1Var, prefetchEvent, q2);
            if (sp3.S(ey1Var, a2.k)) {
                V0(ey1Var.a(), a2.b());
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "prefetch slave end");
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
            }
            y82.i(PrefetchEvent.MODULE, "prefetch slave finish");
        } else if (A) {
            Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
        }
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (si2.class) {
                y82.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
                if (A) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (B != null && !B.k0()) {
                    if (B.u == null) {
                        B.u = new a();
                    }
                    B.H0(B.u);
                    return;
                }
                xb3.K().y().Y(15);
                N0(false);
            }
        }
    }

    public static void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (B.o != null) {
                for (gy1 gy1Var : ((HashMap) B.o.clone()).values()) {
                    if (gy1Var != null) {
                        gy1Var.destroy();
                    }
                }
            }
            R0();
            if (B.i != null) {
                B.i = null;
            }
            if (B.j != null) {
                B.j = null;
            }
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.k && this.i == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.i = K0(getContext(), 0, new e(this));
            i0();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (p92.d() || fv2.o().N() || nl2.d.w() || !s0()) {
                return false;
            }
            boolean c2 = v.c();
            boolean exists = new File(Y()).exists();
            if (!c2 || !exists) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.p.isEmpty()) {
            return;
        }
        Iterator<yl2> it = this.p.iterator();
        while (it.hasNext()) {
            yl2 next = it.next();
            if (A) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.a);
            }
            U0(next);
        }
        this.p.clear();
    }

    @Nullable
    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slave-talos/index.js";
            if (la2.d()) {
                L(str, true);
            } else if (p92.d()) {
                return p92.b();
            } else {
                la2.g(str);
            }
            return qp3.w(str);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slaves/slaves.html";
            if (la2.d()) {
                L(str, true);
            } else if (p92.d()) {
                return p92.b();
            } else {
                la2.g(str);
            }
            return qp3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void i0() {
        ey1<?> ey1Var;
        ey1<?> ey1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (TextUtils.isEmpty(this.t) && (ey1Var2 = this.i) != null) {
                this.t = ey1Var2.getUserAgent();
            }
            if (TextUtils.isEmpty(this.t) && (ey1Var = this.j) != null) {
                this.t = ey1Var.getUserAgent();
            }
            if (!TextUtils.isEmpty(this.t)) {
                y82.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
            }
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (A) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                z = true;
            } else {
                z = false;
            }
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z &= extensionCore.isAvailable();
            }
            if (A) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "isSwanAvailable cost - " + (currentTimeMillis - j2) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (!fv2.w0().d() && rh3.a() != null) {
                boolean exists = new File(rh3.a()).exists();
                if (A) {
                    Log.d("V8LoadChecker", "is v8 load success: " + exists);
                }
                return exists;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void A0(Intent intent, CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, copyOnWriteArrayList) == null) {
            if (xb3.K().q().y0()) {
                y82.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + xb3.K().q().O());
                return;
            }
            m53.c().f();
            r53.e().f();
            if (m0()) {
                y82.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            y82.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = dl3.g(0);
                extensionCore = hm2.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                fv2.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                y82.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Y0(swanCoreVersion);
            if (extensionCore == null) {
                y82.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            X0(extensionCore);
            v.f();
            so3.k(new j(this), "prepare ab description");
            if (N()) {
                th3 c2 = rh3.c();
                if (!c2.b() && !c2.a()) {
                    R("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                I0();
            } else {
                J0(copyOnWriteArrayList);
            }
            y82.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public ud2 D0(boolean z, ma2 ma2Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, ma2Var)) == null) {
            ud2 h2 = this.v.h(getContext(), z ? 1 : 0);
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(X());
            h2.b(ma2Var);
            return h2;
        }
        return (ud2) invokeZL.objValue;
    }

    public final String L(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (z) {
                str2 = "slave";
            } else {
                str2 = "master";
            }
            if (!TextUtils.isEmpty(str)) {
                la2.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void E0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.q) {
                if (G) {
                    z2 = this.f.f();
                } else if (this.g != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!this.h && !z2) {
                    y82.k("SwanAppCoreRuntime", "prepareMaster start.");
                    d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f.j(z, new c(this));
                        return;
                    }
                    this.g = this.v.h(getContext(), z ? 1 : 0);
                    d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.g.loadUrl(X());
                    this.g.b(new d(this));
                }
            }
        }
    }

    public void X0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.b);
                }
                this.b = extensionCore;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.b);
                }
            } else if (A) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanAppCoreRuntime", sb.toString());
            }
        }
    }

    public void Y0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.a);
                }
                this.a = swanCoreVersion;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.a);
                }
            } else if (A) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
                Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
            }
        }
    }

    public void w0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            if (G) {
                z2 = this.f.f();
            } else if (this.g != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && !this.h && z2) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
                }
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.q) {
                    this.h = true;
                    Q();
                    v0();
                }
            } else if (!z && this.i != null && !this.k) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
                }
                d53.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.k = true;
                v0();
            }
        }
    }

    public void G0(ud2 ud2Var, vw2 vw2Var, uu2.g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, ud2Var, vw2Var, gVar) == null) {
            boolean l0 = l0();
            HybridUbcFlow o2 = d53.o();
            if (l0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            y82.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + l0);
            if (l0) {
                jf3.i(ud2Var, this.j, vw2Var, gVar);
                M0(this.i);
                return;
            }
            g gVar2 = new g(this, ud2Var, vw2Var, gVar);
            if (this.j != null) {
                K(gVar2);
                return;
            }
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, gVar2);
            i0();
        }
    }

    public void H0(s sVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            if (xb3.K().q().y0()) {
                y82.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + xb3.K().q().O());
                return;
            }
            m53.c().f();
            r53.e().f();
            if (sVar != null && !this.d.contains(sVar)) {
                this.d.add(sVar);
            }
            boolean m0 = m0();
            HybridUbcFlow o2 = d53.o();
            if (m0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            y82.k("SwanAppCoreRuntime", "prepareRuntime preload = " + m0);
            if (m0) {
                u0();
                return;
            }
            E = PreloadState.LOADING;
            d53.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            g1();
            boolean N = N();
            this.z = N;
            if (N) {
                th3 c2 = rh3.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            y82.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
            if (this.z) {
                E0(true);
            }
            if (this.c == null) {
                this.c = new q(this, z);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
                }
                this.w.b(this.c);
            }
        }
    }

    public final void J0(CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, copyOnWriteArrayList) == null) {
            if (this.d == null) {
                this.d = new CopyOnWriteArrayList();
            }
            Iterator<s> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!this.d.contains(next)) {
                    this.d.add(next);
                }
            }
            H0(new l(this));
        }
    }

    public final void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            y82.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.e == null) {
                t unused = u.e = new t(xb3.K().getMainLooper());
            }
            u.e.c();
            u.e.d(i2);
        }
    }

    @Override // com.baidu.tieba.nx2
    public void b(gy1 gy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, gy1Var) == null) {
            String a2 = gy1Var.a();
            this.o.remove(a2);
            if (gy1Var instanceof ey1) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
                U0(new am2(hashMap));
                y82.i("SwanApp", "onUnload");
            }
            gb3.a();
        }
    }

    public ey1 K0(Context context, int i2, ma2 ma2Var) {
        InterceptResult invokeLIL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, context, i2, ma2Var)) == null) {
            if (A) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            try {
                ey1 e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    d53.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    d53.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.b(ma2Var);
                String b0 = b0();
                if (i2 == 1) {
                    b0 = Z();
                }
                if (b0 != null) {
                    yb3 b02 = yb3.b0();
                    if (b02 != null && !TextUtils.isEmpty(b02.O())) {
                        String builder = Uri.parse(b0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, uu2.v(b02.O(), b02.k0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        b0 = builder;
                    }
                    e2.loadUrl(b0);
                }
                y82.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + b0);
                if (A) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prepareSlave cost - " + (currentTimeMillis - j2) + "ms");
                }
                return e2;
            } catch (NullPointerException e3) {
                la2.e(context);
                throw e3;
            }
        }
        return (ey1) invokeLIL.objValue;
    }

    public void P(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048592, this, z) != null) || !r.e()) {
            return;
        }
        if (!xb3.K().q().w0() && !xb3.K().q().y0()) {
            if (u.e != null && u.e.b()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && z2) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z + ", return.");
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + z2 + ", return.");
                }
            } else if (m0()) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                S(new h(this));
            }
        } else if (A) {
            Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame or web, return.");
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void U0(yl2 yl2Var) {
        wa2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, yl2Var) == null) {
            if (yl2Var == null) {
                if (!A) {
                    return;
                }
                throw new IllegalArgumentException("message must be non-null.");
            }
            synchronized (this.q) {
                if (!this.h) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + yl2Var.a)));
                    }
                    this.p.add(yl2Var);
                    return;
                }
                if (G) {
                    if (!this.f.g()) {
                        this.f.d(yl2Var);
                        return;
                    } else if (this.f.a() == 0) {
                        return;
                    } else {
                        d2 = ((ae2) this.f.a()).i().d();
                    }
                } else {
                    ud2 ud2Var = this.g;
                    if (ud2Var == null) {
                        return;
                    }
                    d2 = ud2Var.d();
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + yl2Var.a);
                }
                ul2.a(d2, yl2Var);
            }
        }
    }

    public void V0(String str, yl2 yl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, yl2Var) == null) {
            if (ee2.a(str)) {
                U0(yl2Var);
            } else if (od2.a(str)) {
                ul2.a(j92.k().l(), yl2Var);
            } else {
                gy1 gy1Var = this.o.get(str);
                if (gy1Var == null) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + yl2Var);
                        return;
                    }
                    return;
                }
                ul2.a(gy1Var.r(), yl2Var);
            }
        }
    }

    public final void h0() {
        boolean z;
        String O;
        boolean z2;
        Object valueOf;
        Object valueOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this.q) {
                z = false;
                this.h = false;
                if (G) {
                    this.f.reset();
                } else {
                    this.g = null;
                }
            }
            this.k = false;
            this.l = false;
            this.i = null;
            this.j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", il3.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", r0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = dl3.g(0);
                if (g2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueOf = StringUtil.NULL_STRING;
                } else {
                    valueOf = Long.valueOf(g2.swanCoreVersionCode);
                }
                jSONObject.put("swan app core", valueOf);
                SwanCoreVersion g3 = dl3.g(1);
                if (g3 == null) {
                    z = true;
                }
                if (z) {
                    valueOf2 = StringUtil.NULL_STRING;
                } else {
                    valueOf2 = Long.valueOf(g3.swanCoreVersionCode);
                }
                jSONObject.put("swan game core", valueOf2);
            } catch (JSONException e2) {
                if (A) {
                    e2.printStackTrace();
                }
            }
            gi3.b bVar = new gi3.b(10001);
            if (yb3.M() == null) {
                O = "null appKey";
            } else {
                O = yb3.M().O();
            }
            bVar.h(O);
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public final void t0(si2 si2Var, vw2 vw2Var, uu2.g gVar) {
        ud2 ud2Var;
        ey1<?> ey1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, si2Var, vw2Var, gVar) == null) {
            if (G) {
                be2<ae2> be2Var = si2Var.f;
                if (be2Var.h()) {
                    ud2Var = ((ae2) be2Var.e(vw2Var.f0())).i();
                } else {
                    ud2Var = null;
                }
            } else {
                ud2Var = si2Var.g;
            }
            if (ud2Var != null) {
                String d2 = jf3.d(lx2.T(), vw2Var, gVar.b);
                int c2 = ii2.c(d2);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "launchFirstPage: " + d2 + " salveType:" + c2);
                }
                if ((c2 == 0 || !ii2.d()) && (ey1Var = si2Var.i) != null) {
                    jf3.i(ud2Var, ey1Var, vw2Var, gVar);
                    M0(si2Var.j);
                } else if (c2 == 1) {
                    G0(ud2Var, vw2Var, gVar);
                }
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage mMasterManager=" + si2Var.g + " mSlaveManager=" + si2Var.i + " mNASlaveManager=" + si2Var.j);
            }
        }
    }

    public void x0(String str, PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048644, this, str, prefetchEvent, pMSAppInfo) == null) && G) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (m0() && o0()) {
                    ey1<?> ey1Var = this.i;
                    if (ey1Var != null) {
                        prefetchEvent.isT7Available = ey1Var.I();
                    } else {
                        prefetchEvent.isT7Available = p0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    bh2 d2 = bh2.d();
                    ch2.b a2 = ch2.a();
                    a2.h(RecordType.PREFETCH_EVENT);
                    a2.f(createMessage.a);
                    d2.f(str, a2.e());
                    String str3 = prefetchEvent.pageUrl;
                    Map<String, String> t2 = createMessage.t();
                    if (t2 != null) {
                        str2 = t2.get("pageRoutePath");
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str3 = str2;
                    }
                    if (!uu2.C(prefetchEvent.appPath, str3)) {
                        if (A) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str3 + " not exit");
                        }
                        y82.k("SwanAppCoreRuntime", "page path not exist - " + str3);
                        return;
                    }
                    if (createMessage.u()) {
                        x82.d();
                        y82.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f.b(str, createMessage, pMSAppInfo);
                    y0(str, prefetchEvent);
                    if (A) {
                        String str4 = this.a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str4);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                    if (!ii2.e() && !ii2.g()) {
                        return;
                    }
                    if (TextUtils.isEmpty(lx2.T().z()) && !ii2.h(yb3.b0())) {
                        if (A) {
                            Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                            return;
                        }
                        return;
                    } else if (ii2.c(str3) == 1) {
                        F0();
                        return;
                    } else {
                        return;
                    }
                }
                y82.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
            } else if (A) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }
}
