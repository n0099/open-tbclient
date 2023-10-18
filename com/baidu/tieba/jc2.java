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
import com.baidu.tieba.lo2;
import com.baidu.tieba.ta2;
import com.baidu.tieba.wa2;
import com.baidu.tieba.xb3;
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
/* loaded from: classes6.dex */
public final class jc2 implements er2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile jc2 B;
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
    public r42 c;
    public List<s> d;
    public final List<d42> e;
    public s72<r72> f;
    public l72 g;
    public boolean h;
    public wr1<?> i;
    public wr1<?> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, yr1> o;
    public LinkedList<pf2> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public rr1 v;
    public cs1 w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.er2
    public void a(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, yr1Var) == null) {
        }
    }

    @Override // com.baidu.tieba.er2
    public void c(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yr1Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.jc2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0356a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0356a(a aVar) {
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
                    jc2.O0(false);
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

        @Override // com.baidu.tieba.jc2.s
        public void c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc2Var) == null) {
                boolean z = !TextUtils.isEmpty(o53.K().getAppId());
                p22.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (!z) {
                    o53.K().y().Y(15);
                    jj3.e0(new RunnableC0356a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends d42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ mq2 b;
        public final /* synthetic */ lo2.g c;
        public final /* synthetic */ jc2 d;

        /* loaded from: classes6.dex */
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
                    l72 l72Var = gVar.a;
                    wr1 wr1Var = gVar.d.j;
                    g gVar2 = this.a;
                    a93.i(l72Var, wr1Var, gVar2.b, gVar2.c);
                    jc2 jc2Var = this.a.d;
                    jc2Var.N0(jc2Var.i);
                }
            }
        }

        public g(jc2 jc2Var, l72 l72Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, l72Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jc2Var;
            this.a = l72Var;
            this.b = mq2Var;
            this.c = gVar;
        }

        @Override // com.baidu.tieba.d42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.d.r) {
                this.d.l = true;
            }
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            p22.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            jj3.e0(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jc2 a;

            public a(k kVar, jc2 jc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, jc2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.f1();
            }
        }

        public k(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.jc2.s
        public void c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc2Var) == null) {
                if (jc2.A) {
                    nk4.b().e();
                    h53 f = h53.f(jc2.p(), R.string.obfuscated_res_0x7f0f01dc);
                    f.l(1);
                    f.G();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                jj3.a0(new a(this, jc2Var));
                if (jc2.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                k23.Q().Y(14);
                if (zb2.f() || zb2.g()) {
                    this.a.G0();
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

    /* loaded from: classes6.dex */
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ lo2.g b;
        public final /* synthetic */ jc2 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jc2 a;
            public final /* synthetic */ m b;

            public a(m mVar, jc2 jc2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, jc2Var};
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
                this.a = jc2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.m) {
                    return;
                }
                uy2.p("startup").F(new UbcFlowEvent("na_pre_load_ok"));
                pb3.d().i("na_pre_load_ok");
                uy2.h("preload", "startup");
                m mVar = this.b;
                mVar.c.u0(this.a, mVar.a, mVar.b);
                uy2.j(this.b.a, false);
            }
        }

        public m(jc2 jc2Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jc2Var;
            this.a = mq2Var;
            this.b = gVar;
        }

        @Override // com.baidu.tieba.jc2.s
        public void c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc2Var) == null) {
                jj3.e0(new a(this, jc2Var));
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

    /* loaded from: classes6.dex */
    public class q implements r42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ jc2 b;

        /* loaded from: classes6.dex */
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
                    if (jc2.A) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.a.b.m);
                    }
                    if (this.a.b.m) {
                        if (jc2.A) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.a.b.h1();
                    this.a.b.g1();
                    if (this.a.b.a != null) {
                        q qVar = this.a;
                        qVar.b.F0(qVar.a);
                        this.a.b.M0();
                        return;
                    }
                    PreloadState unused = jc2.E = PreloadState.LOAD_FAILED;
                    this.a.b.i0();
                }
            }
        }

        public q(jc2 jc2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc2Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.r42
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (jc2.A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                jj3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || o53.K().q().z0()) {
                    return;
                }
                if (jc2.B.n0()) {
                    p22.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    return;
                }
                boolean z = true;
                if (u.d >= 1) {
                    p22.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                if (!((u.e == null || !u.e.a()) ? false : false)) {
                    if (u.e == null) {
                        t unused = u.e = new t(o53.K().getMainLooper());
                    }
                    u.e.e(r.d());
                }
                p22.k("SwanAppCoreRuntime", "start retry runtime.");
                jc2.Q0();
                ih3 ih3Var = new ih3();
                ih3Var.k(5L);
                ih3Var.i(49L);
                ih3Var.f("start retry");
                u.j(ih3Var);
            }
        }

        /* loaded from: classes6.dex */
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || o53.K().q().z0()) {
                    return;
                }
                if (jc2.B.n0()) {
                    p22.k("SwanAppCoreRuntime", "Retry: successfully.");
                } else if (u.d >= 1) {
                    p22.k("SwanAppCoreRuntime", "isMasterReady:" + jc2.B.l0() + ",isSlaveReady:" + jc2.B.o0());
                    ih3 ih3Var = new ih3();
                    ih3Var.k(5L);
                    ih3Var.i(49L);
                    ih3Var.f("retry timeout");
                    u.j(ih3Var);
                    if (dr2.a().b()) {
                        jq2.e(jc2.p(), ih3Var, 0, o53.K().getAppId());
                        zb3.m(o53.K().q().X(), 0, ih3Var);
                        wo2.p0().flush(false);
                    }
                    yh3.j(o53.K().w());
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-694601697, "Lcom/baidu/tieba/jc2$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-694601697, "Lcom/baidu/tieba/jc2$u;");
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
                return new CopyOnWriteArrayList<>(jc2.B.d);
            }
            return (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                d++;
                p22.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + d);
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

        public static void j(ih3 ih3Var) {
            p53 q;
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65546, null, ih3Var) != null) || (q = o53.K().q()) == null || (k = q.k()) != 0) {
                return;
            }
            qc3 qc3Var = new qc3();
            qc3Var.p(ih3Var);
            qc3Var.r(q.Z());
            qc3Var.q(ic3.n(k));
            qc3Var.m(p53.h0());
            ic3.R(qc3Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u72<r72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public b(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u72
        /* renamed from: b */
        public void a(boolean z, r72 r72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, r72Var) != null) {
                return;
            }
            this.a.y = z;
            if (z) {
                uy2.p("startup").D("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.a82
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.w0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends d42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public d(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.d42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                p22.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.w0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends d42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public e(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.d42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                p22.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.w0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends d42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public f(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.d42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.a.r) {
                this.a.l = true;
            }
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            for (d42 d42Var : this.a.e) {
                d42Var.a(str);
            }
            this.a.e.clear();
            p22.k("SwanAppCoreRuntime", "prepareNaSlave finished");
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ik3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public h(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) != null) {
                return;
            }
            this.a.U0(u.h(bool));
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;

        public i(jc2 jc2Var, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = wo2.u0().a();
                if (jc2.A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a);
                }
                ik3 ik3Var = this.a;
                if (ik3Var != null) {
                    ik3Var.a(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
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
                ci3.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public l(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.baidu.tieba.jc2.s
        public void c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc2Var) == null) {
                if (zb2.f() || zb2.g()) {
                    this.a.G0();
                }
                if (jc2.A) {
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

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(jc2 jc2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, str};
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
                a93.k(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
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
                a93.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p53 a;
        public final /* synthetic */ jc2 b;

        public p(jc2 jc2Var, p53 p53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, p53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc2Var;
            this.a = p53Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean equals;
            l72 l72Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (zb2.d() && TextUtils.isEmpty(cr2.V().A()) && !zb2.h(this.a)) {
                    if (jc2.A) {
                        Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                        return;
                    }
                    return;
                }
                String d = a93.d(cr2.V(), this.a.Z(), this.a.R());
                int c = zb2.c(d);
                if (!this.b.O(c)) {
                    ec2.c(11);
                    return;
                }
                wr1 wr1Var = null;
                if (wa2.a.b()) {
                    equals = true;
                } else {
                    SwanAppConfigData R = this.a.R();
                    if (R != null) {
                        str = R.h(d);
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
                        ec2.c(i);
                    }
                }
                if (c != 0 || this.b.i == null) {
                    if (c == 1 && this.b.j != null) {
                        wr1Var = this.b.j;
                    }
                } else {
                    wr1Var = this.b.i;
                }
                wr1 wr1Var2 = wr1Var;
                if (wr1Var2 == null) {
                    return;
                }
                if (equals && this.a.R() != null) {
                    if (jc2.G) {
                        l72Var = ((r72) this.b.f.e(this.a.X().g0())).i();
                    } else {
                        l72Var = this.b.g;
                    }
                    xa2.c().b(l72Var, wr1Var2, this.a.Z(), this.a.R(), null, true);
                } else if (this.a.R() == null) {
                    ec2.c(15);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-694601790, "Lcom/baidu/tieba/jc2$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-694601790, "Lcom/baidu/tieba/jc2$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                wo2.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (jc2.A) {
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
                wo2.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (jc2.A) {
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
                wo2.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (jc2.A) {
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
                p22.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (a < 0) {
                    wo2.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    a = 0;
                }
                return a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class s implements ik3<jc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void c(jc2 jc2Var);

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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jc2Var) == null) {
                c(jc2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-694601666, "Lcom/baidu/tieba/jc2$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-694601666, "Lcom/baidu/tieba/jc2$v;");
                    return;
                }
            }
            boolean x = wo2.g0().x();
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
                if (jc2.A) {
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
                    return wo2.g0().x();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947878416, "Lcom/baidu/tieba/jc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947878416, "Lcom/baidu/tieba/jc2;");
                return;
            }
        }
        A = am1.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = p92.h();
        H = -1;
    }

    public static void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (G) {
                if (B.f != null) {
                    B.f.reset();
                }
            } else if (B.g != null) {
                if (B.g instanceof p72) {
                    B.g.destroy();
                }
                B.g = null;
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && zb2.d() && !m0() && this.j == null) {
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = L0(S(), 1, new f(this));
            j0();
        }
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!TextUtils.isEmpty(d0())) {
                return d0() + "runtime/index.js";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                p22.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Z0(ue3.g(0));
            }
        }
    }

    public jc2() {
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
        fr2.e(this);
        this.o = new HashMap<>();
        this.v = wo2.F0();
        this.w = gs1.a().b().a();
        if (G) {
            this.f = new d82();
        }
    }

    public String Y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            h1();
            if (s0()) {
                str = Z();
            } else {
                str = this.a.swanCorePath + File.separator + "master/master.html";
            }
            if (c42.d()) {
                L(str, false);
            } else if (g32.d()) {
                f32.k();
                f32.g().h("loadmaster");
                return g32.a();
            } else {
                c42.g(str);
            }
            return hj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.x) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                    return;
                }
                return;
            }
            boolean z = true;
            this.x = true;
            o53 K = o53.K();
            z = (K == null || !K.E()) ? false : false;
            boolean v2 = wo2.g0().v();
            if (!z && v2) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                ub2.n(S());
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + v2);
            }
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048642, this) != null) || this.d.isEmpty()) {
            return;
        }
        M();
        E = PreloadState.LOADED;
        u.k();
        R("event_preload_finish");
        uy2.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        e82.i().q();
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

    public static int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return D0().statsCode(F);
        }
        return invokeV.intValue;
    }

    public static PreloadState D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return E;
        }
        return (PreloadState) invokeV.objValue;
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (jc2.class) {
                p22.k("SwanAppCoreRuntime", "releaseAndRetry");
                P0(false, true);
            }
        }
    }

    public static Context S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static jc2 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (B == null) {
                synchronized (jc2.class) {
                    if (B == null) {
                        B = new jc2();
                    }
                }
            }
            return B;
        }
        return (jc2) invokeV.objValue;
    }

    public static /* synthetic */ Context p() {
        return S();
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I0(new k(this));
        }
    }

    public final void M() {
        s72<r72> s72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (s72Var = this.f) != null && E != PreloadState.LOADED) {
            s72Var.c(new b(this));
        }
    }

    @Nullable
    public ExtensionCore U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, yr1> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.o;
        }
        return (HashMap) invokeV.objValue;
    }

    public l72 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (G) {
                if (!this.f.g()) {
                    return null;
                }
                return ((r72) this.f.a()).i();
            }
            return this.g;
        }
        return (l72) invokeV.objValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            jj3.e0(new o(this));
        }
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.a == null) {
                return "";
            }
            return this.a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public rr1 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.v;
        }
        return (rr1) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                p22.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                Y0(yf2.c(0));
            }
        }
    }

    @Nullable
    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            j0();
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            synchronized (this.q) {
                z = this.h;
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
            synchronized (this.r) {
                z = this.l;
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

    public boolean o0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            synchronized (this.q) {
                z = this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (G) {
                return this.f.i();
            }
            return this.g instanceof p72;
        }
        return invokeV.booleanValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048643, this) != null) || this.d.isEmpty() || !n0()) {
            return;
        }
        v0();
    }

    public static synchronized void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            synchronized (jc2.class) {
                p22.k("SwanAppCoreRuntime", "release");
                P0(z, false);
            }
        }
    }

    public void A0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            B0(intent, null);
        }
    }

    public void K(@NonNull d42 d42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d42Var) == null) {
            this.e.add(d42Var);
        }
    }

    public final void N0(wr1<?> wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wr1Var) == null) {
            if (wr1Var != null) {
                ub2.p(wr1Var);
            }
            this.i = null;
            this.j = null;
        }
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 == 0 && n0() && this.i != null) {
                return true;
            }
            if (i2 == 1 && m0() && this.j != null) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", E.statsCode(F));
            o53.K().v(str, bundle);
        }
    }

    public final void T(ik3<Boolean> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ik3Var) == null) {
            ji3.k(new i(this, ik3Var), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    public void X0(@NonNull p53 p53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, p53Var) == null) {
            jj3.e0(new p(this, p53Var));
        }
    }

    public void c1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            jj3.e0(new n(this, str));
        }
    }

    @Override // com.baidu.tieba.er2
    public void d(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, yr1Var) == null) {
            this.o.put(yr1Var.a(), yr1Var);
        }
    }

    public void d1(mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, mq2Var) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null) {
                mq2Var.D0(extensionCore);
            } else {
                this.b = mq2Var.P();
            }
        }
    }

    public void e1(mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, mq2Var) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                mq2Var.a1(swanCoreVersion);
            } else {
                this.a = mq2Var.k0();
            }
        }
    }

    public yr1 f0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
            if (!this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                return this.o.get(str);
            }
            return null;
        }
        return (yr1) invokeL.objValue;
    }

    public void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.baidu.tieba.jc2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void P0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (jc2.class) {
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
                ax1.f();
                ve3.c();
                T0();
                fr2.f(B);
                B = null;
                xa2.c().d();
                F = z;
                V().B0(null, copyOnWriteArrayList);
            }
        }
    }

    public void a1(mq2 mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, mq2Var, gVar) == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + mq2Var.k0());
            }
            e1(mq2Var);
            d1(mq2Var);
            uy2.o().F(new UbcFlowEvent("na_pre_load_check"));
            pb3.d().i("na_pre_load_check");
            I0(new m(this, mq2Var, gVar));
        }
    }

    public final void z0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048646, this, str, prefetchEvent) != null) || !p92.o()) {
            return;
        }
        wr1<?> wr1Var = this.i;
        if (wr1Var != null && o0()) {
            p22.i(PrefetchEvent.MODULE, "start prefetch slave");
            long j2 = 0;
            if (A) {
                j2 = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave start");
            }
            p53 q2 = o53.K().q();
            if (q2 == null) {
                return;
            }
            oa2 a2 = oa2.a(wr1Var, prefetchEvent, q2);
            if (jj3.S(wr1Var, a2.k)) {
                W0(wr1Var.a(), a2.b());
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "prefetch slave end");
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
            }
            p22.i(PrefetchEvent.MODULE, "prefetch slave finish");
        } else if (A) {
            Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
        }
    }

    public static synchronized void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (jc2.class) {
                p22.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
                if (A) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (B != null && !B.l0()) {
                    if (B.u == null) {
                        B.u = new a();
                    }
                    B.I0(B.u);
                    return;
                }
                o53.K().y().Y(15);
                O0(false);
            }
        }
    }

    public static void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            if (B.o != null) {
                for (yr1 yr1Var : ((HashMap) B.o.clone()).values()) {
                    if (yr1Var != null) {
                        yr1Var.destroy();
                    }
                }
            }
            S0();
            if (B.i != null) {
                B.i = null;
            }
            if (B.j != null) {
                B.j = null;
            }
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.k && this.i == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.i = L0(S(), 0, new e(this));
            j0();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (g32.d() || wo2.o().N() || ef2.d.w() || !t0()) {
                return false;
            }
            boolean c2 = v.c();
            boolean exists = new File(Z()).exists();
            if (!c2 || !exists) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.p.isEmpty()) {
            return;
        }
        Iterator<pf2> it = this.p.iterator();
        while (it.hasNext()) {
            pf2 next = it.next();
            if (A) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.a);
            }
            V0(next);
        }
        this.p.clear();
    }

    @Nullable
    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            h1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slave-talos/index.js";
            if (c42.d()) {
                L(str, true);
            } else if (g32.d()) {
                return g32.b();
            } else {
                c42.g(str);
            }
            return hj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            h1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slaves/slaves.html";
            if (c42.d()) {
                L(str, true);
            } else if (g32.d()) {
                return g32.b();
            } else {
                c42.g(str);
            }
            return hj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void j0() {
        wr1<?> wr1Var;
        wr1<?> wr1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (TextUtils.isEmpty(this.t) && (wr1Var2 = this.i) != null) {
                this.t = wr1Var2.getUserAgent();
            }
            if (TextUtils.isEmpty(this.t) && (wr1Var = this.j) != null) {
                this.t = wr1Var.getUserAgent();
            }
            if (!TextUtils.isEmpty(this.t)) {
                p22.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
            }
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
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

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (!wo2.w0().d() && ib3.a() != null) {
                boolean exists = new File(ib3.a()).exists();
                if (A) {
                    Log.d("V8LoadChecker", "is v8 load success: " + exists);
                }
                return exists;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B0(Intent intent, CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, copyOnWriteArrayList) == null) {
            if (o53.K().q().z0()) {
                p22.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + o53.K().q().P());
                return;
            }
            dz2.c().f();
            iz2.e().f();
            if (n0()) {
                p22.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            p22.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = ue3.g(0);
                extensionCore = yf2.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                wo2.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                p22.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Z0(swanCoreVersion);
            if (extensionCore == null) {
                p22.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            Y0(extensionCore);
            v.f();
            ji3.k(new j(this), "prepare ab description");
            if (N()) {
                kb3 c2 = ib3.c();
                if (!c2.b() && !c2.a()) {
                    R("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                J0();
            } else {
                K0(copyOnWriteArrayList);
            }
            p22.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public l72 E0(boolean z, d42 d42Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, d42Var)) == null) {
            l72 h2 = this.v.h(S(), z ? 1 : 0);
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(Y());
            h2.b(d42Var);
            return h2;
        }
        return (l72) invokeZL.objValue;
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
                c42.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void F0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this.q) {
                if (G) {
                    z2 = this.f.f();
                } else if (this.g != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!this.h && !z2) {
                    p22.k("SwanAppCoreRuntime", "prepareMaster start.");
                    uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f.j(z, new c(this));
                        return;
                    }
                    this.g = this.v.h(S(), z ? 1 : 0);
                    uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.g.loadUrl(Y());
                    this.g.b(new d(this));
                }
            }
        }
    }

    public void Y0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, extensionCore) == null) {
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

    public void Z0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, swanCoreVersion) == null) {
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

    public void x0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
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
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.q) {
                    this.h = true;
                    Q();
                    w0();
                }
            } else if (!z && this.i != null && !this.k) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
                }
                uy2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.k = true;
                w0();
            }
        }
    }

    public void H0(l72 l72Var, mq2 mq2Var, lo2.g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, l72Var, mq2Var, gVar) == null) {
            boolean m0 = m0();
            HybridUbcFlow o2 = uy2.o();
            if (m0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            p22.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + m0);
            if (m0) {
                a93.i(l72Var, this.j, mq2Var, gVar);
                N0(this.i);
                return;
            }
            g gVar2 = new g(this, l72Var, mq2Var, gVar);
            if (this.j != null) {
                K(gVar2);
                return;
            }
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = L0(S(), 1, gVar2);
            j0();
        }
    }

    public void I0(s sVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            if (o53.K().q().z0()) {
                p22.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + o53.K().q().P());
                return;
            }
            dz2.c().f();
            iz2.e().f();
            if (sVar != null && !this.d.contains(sVar)) {
                this.d.add(sVar);
            }
            boolean n0 = n0();
            HybridUbcFlow o2 = uy2.o();
            if (n0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            p22.k("SwanAppCoreRuntime", "prepareRuntime preload = " + n0);
            if (n0) {
                v0();
                return;
            }
            E = PreloadState.LOADING;
            uy2.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            h1();
            boolean N = N();
            this.z = N;
            if (N) {
                kb3 c2 = ib3.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            p22.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
            if (this.z) {
                F0(true);
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

    public final void K0(CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, copyOnWriteArrayList) == null) {
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
            I0(new l(this));
        }
    }

    public final void U0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            p22.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.e == null) {
                t unused = u.e = new t(o53.K().getMainLooper());
            }
            u.e.c();
            u.e.d(i2);
        }
    }

    @Override // com.baidu.tieba.er2
    public void b(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, yr1Var) == null) {
            String a2 = yr1Var.a();
            this.o.remove(a2);
            if (yr1Var instanceof wr1) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
                V0(new rf2(hashMap));
                p22.i("SwanApp", "onUnload");
            }
            x43.a();
        }
    }

    public wr1 L0(Context context, int i2, d42 d42Var) {
        InterceptResult invokeLIL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048587, this, context, i2, d42Var)) == null) {
            if (A) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            try {
                wr1 e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    uy2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    uy2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.b(d42Var);
                String c0 = c0();
                if (i2 == 1) {
                    c0 = a0();
                }
                if (c0 != null) {
                    p53 c02 = p53.c0();
                    if (c02 != null && !TextUtils.isEmpty(c02.P())) {
                        String builder = Uri.parse(c0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, lo2.v(c02.P(), c02.l0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        c0 = builder;
                    }
                    e2.loadUrl(c0);
                }
                p22.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + c0);
                if (A) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prepareSlave cost - " + (currentTimeMillis - j2) + "ms");
                }
                return e2;
            } catch (NullPointerException e3) {
                c42.e(context);
                throw e3;
            }
        }
        return (wr1) invokeLIL.objValue;
    }

    public void P(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || !r.e()) {
            return;
        }
        if (!o53.K().q().x0() && !o53.K().q().z0()) {
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
            } else if (n0()) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                T(new h(this));
            }
        } else if (A) {
            Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame or web, return.");
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void V0(pf2 pf2Var) {
        n42 e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pf2Var) == null) {
            if (pf2Var == null) {
                if (!A) {
                    return;
                }
                throw new IllegalArgumentException("message must be non-null.");
            }
            synchronized (this.q) {
                if (!this.h) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + pf2Var.a)));
                    }
                    this.p.add(pf2Var);
                    return;
                }
                if (G) {
                    if (!this.f.g()) {
                        this.f.d(pf2Var);
                        return;
                    } else if (this.f.a() == 0) {
                        return;
                    } else {
                        e2 = ((r72) this.f.a()).i().e();
                    }
                } else {
                    l72 l72Var = this.g;
                    if (l72Var == null) {
                        return;
                    }
                    e2 = l72Var.e();
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + pf2Var.a);
                }
                lf2.a(e2, pf2Var);
            }
        }
    }

    public void W0(String str, pf2 pf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, pf2Var) == null) {
            if (v72.a(str)) {
                V0(pf2Var);
            } else if (f72.a(str)) {
                lf2.a(a32.k().l(), pf2Var);
            } else {
                yr1 yr1Var = this.o.get(str);
                if (yr1Var == null) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + pf2Var);
                        return;
                    }
                    return;
                }
                lf2.a(yr1Var.getWebView(), pf2Var);
            }
        }
    }

    public final void i0() {
        boolean z;
        String P;
        boolean z2;
        Object valueOf;
        Object valueOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
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
                jSONObject.put("swanjs version", ze3.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", s0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = ue3.g(0);
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
                SwanCoreVersion g3 = ue3.g(1);
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
            xb3.b bVar = new xb3.b(10001);
            if (p53.M() == null) {
                P = "null appKey";
            } else {
                P = p53.M().P();
            }
            bVar.h(P);
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public final void u0(jc2 jc2Var, mq2 mq2Var, lo2.g gVar) {
        l72 l72Var;
        wr1<?> wr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, jc2Var, mq2Var, gVar) == null) {
            if (G) {
                s72<r72> s72Var = jc2Var.f;
                if (s72Var.h()) {
                    l72Var = ((r72) s72Var.e(mq2Var.g0())).i();
                } else {
                    l72Var = null;
                }
            } else {
                l72Var = jc2Var.g;
            }
            if (l72Var != null) {
                String d2 = a93.d(cr2.V(), mq2Var, gVar.b);
                int c2 = zb2.c(d2);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "launchFirstPage: " + d2 + " salveType:" + c2);
                }
                if ((c2 == 0 || !zb2.d()) && (wr1Var = jc2Var.i) != null) {
                    a93.i(l72Var, wr1Var, mq2Var, gVar);
                    N0(jc2Var.j);
                } else if (c2 == 1) {
                    H0(l72Var, mq2Var, gVar);
                }
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage mMasterManager=" + jc2Var.g + " mSlaveManager=" + jc2Var.i + " mNASlaveManager=" + jc2Var.j);
            }
        }
    }

    public void y0(String str, PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048645, this, str, prefetchEvent, pMSAppInfo) == null) && G) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (n0() && p0()) {
                    wr1<?> wr1Var = this.i;
                    if (wr1Var != null) {
                        prefetchEvent.isT7Available = wr1Var.H();
                    } else {
                        prefetchEvent.isT7Available = q0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    sa2 d2 = sa2.d();
                    ta2.b a2 = ta2.a();
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
                    if (!lo2.C(prefetchEvent.appPath, str3)) {
                        if (A) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str3 + " not exit");
                        }
                        p22.k("SwanAppCoreRuntime", "page path not exist - " + str3);
                        return;
                    }
                    if (createMessage.u()) {
                        o22.d();
                        p22.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f.b(str, createMessage, pMSAppInfo);
                    z0(str, prefetchEvent);
                    if (A) {
                        String str4 = this.a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str4);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                    if (!zb2.e() && !zb2.g()) {
                        return;
                    }
                    if (TextUtils.isEmpty(cr2.V().A()) && !zb2.h(p53.c0())) {
                        if (A) {
                            Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                            return;
                        }
                        return;
                    } else if (zb2.c(str3) == 1) {
                        G0();
                        return;
                    } else {
                        return;
                    }
                }
                p22.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
            } else if (A) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }
}
