package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.v74;
import com.baidu.tieba.wi2;
import com.baidu.tieba.x74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class j74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public pi2 a;
    public DuMixGameSurfaceView b;
    public n32 c;
    public e d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes6.dex */
    public interface e {
        void a(pi2 pi2Var);
    }

    /* loaded from: classes6.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DuMixGameSurfaceView c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ V8Engine a;

            public a(c cVar, V8Engine v8Engine) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, v8Engine};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (j74.h) {
                        Log.d("SwanGameV8Master", "startEngineInternal");
                    }
                    this.a.startEngineInternal();
                }
            }
        }

        public c(j74 j74Var, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j74Var, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.c.u(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.c.x(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                if (j74.h) {
                    Log.d("SwanGameV8Master", "startV8Engine");
                }
                this.c.x(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j) == null) {
                this.c.v(runnable, j);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.getThread();
            }
            return (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends lj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ j74 c;

        /* loaded from: classes6.dex */
        public class a implements JsCodeCacheCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
            public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, jsCodeCacheResult) != null) {
                    return;
                }
                this.a.f(jsCodeCacheResult);
            }
        }

        public d(@NonNull j74 j74Var, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j74Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j74Var;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.mj2
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return u54.a("gameframe", getInitBasePath());
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // com.baidu.tieba.mj2
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        public void c(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pi2Var) == null) {
                m43.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.c.d != null) {
                    this.c.d.a(pi2Var);
                }
            }
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        public void d(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pi2Var) == null) {
                this.c.c.b(pi2Var, ou2.c());
                new n54().a(pi2Var, ou2.c());
                pi2Var.E0(new a(this));
                m43.p("preload").F(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, jsCodeCacheResult) != null) || jsCodeCacheResult == null) {
                return;
            }
            if (j74.h) {
                Log.d("SwanGameV8Master", "jsCodeCacheResult isCacheUsed:" + jsCodeCacheResult.isCacheUsed + " ,jsPath: " + jsCodeCacheResult.jsPath);
            }
            if (jsCodeCacheResult.isCacheUsed && !TextUtils.isEmpty(jsCodeCacheResult.jsPath)) {
                File file = new File(jsCodeCacheResult.jsPath);
                try {
                    if (!TextUtils.isEmpty(getInitBasePath()) && file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                        this.c.f = true;
                    } else if (!TextUtils.isEmpty(this.c.e) && file.getCanonicalPath().startsWith(new File(this.c.e).getCanonicalPath())) {
                        this.c.g = true;
                    }
                } catch (IOException e) {
                    if (j74.h) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j74 a;

        public a(j74 j74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r();
            this.a.s();
            this.a.u();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x74.c a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ j74 c;

        public b(j74 j74Var, x74.c cVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j74Var, cVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j74Var;
            this.a = cVar;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            v74 v74Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (j74.h) {
                    Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                }
                bb4 bb4Var = this.a.c;
                if (bb4Var == null) {
                    v74Var = null;
                } else {
                    v74Var = bb4Var.f;
                }
                v74.a f = v74.f(v74Var);
                if (f.b()) {
                    SwanInspectorEndpoint.v().r(v74Var, this.c.a, f, this.b);
                    return;
                }
                SwanInspectorEndpoint.v().w(f);
                this.b.run();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836194, "Lcom/baidu/tieba/j74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836194, "Lcom/baidu/tieba/j74;");
                return;
            }
        }
        h = rr1.a;
    }

    public final wi2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            wi2.b bVar = new wi2.b();
            bVar.c(2);
            bVar.b("master");
            return bVar.a();
        }
        return (wi2) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return u54.b(this.f, this.g);
        }
        return invokeV.intValue;
    }

    public pi2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (pi2) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (DuMixGameSurfaceView) invokeV.objValue;
    }

    public j74(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new n32();
        q(str, str2);
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = p74.b().a(AppRuntime.getAppContext());
            this.b = a2;
            a2.setRenderMode(1);
            pi2 b2 = vi2.b(l(), new d(this, str, str2), new c(this, this.b));
            this.a = b2;
            b2.B0(ou2.c());
            this.b.setV8Engine(this.a);
        }
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.c.a(activity);
        }
    }

    public void v(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
            }
            this.a.j0();
            if (!this.b.isAttachedToWindow()) {
                if (h) {
                    Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
                }
                this.b.q();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.y();
            this.a.D0(new ij2());
            this.a.G0();
            this.a.C0();
            this.a.A0(u54.a("gamejs", this.e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && h && g73.f() && new File(j64.b(), j64.d()).exists()) {
            this.a.V(j64.b().getAbsolutePath(), j64.d());
        }
    }

    public void t(x74.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) && cVar != null && !TextUtils.isEmpty(cVar.a)) {
            this.e = cVar.a;
            a aVar = new a(this);
            if (h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.a.runOnJSThread(new b(this, cVar, aVar));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
            }
            HybridUbcFlow p = m43.p("startup");
            p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.F(new UbcFlowEvent("na_load_index_js_start"));
            this.a.dispatchEvent(new i94());
            this.a.V(this.e, "index.js");
            this.a.dispatchEvent(new j94());
            m43.p("startup").F(new UbcFlowEvent("na_load_index_js_end"));
            if (h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
            }
            this.a.x0();
            this.b.p();
        }
    }
}
