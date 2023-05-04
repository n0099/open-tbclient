package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.g72;
import com.baidu.tieba.n44;
import com.baidu.tieba.z34;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class x34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static volatile x34 k;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Object b;
    public SwanCoreVersion c;
    public ExtensionCore d;
    public z34 e;
    public List<f> f;
    public boolean g;
    public boolean h;
    public String i;

    /* loaded from: classes7.dex */
    public interface f {
        void onReady();
    }

    /* loaded from: classes7.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44.c a;
        public final /* synthetic */ x34 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b.h || this.a.b.e == null || (activity = kt2.U().getActivity()) == null || activity.isFinishing() || activity.Z() == null) {
                    return;
                }
                if (x34.j) {
                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + this.a.b.i);
                }
                this.a.b.e.k(activity);
                this.a.b.e.t(this.a.a);
                if (this.a.b.v()) {
                    this.a.b.F(activity);
                }
            }
        }

        public c(x34 x34Var, n44.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x34Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.x34.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c13.p("startup").F(new UbcFlowEvent("na_prepare_runtime_end"));
                rl3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(x34 x34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.x34.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && x34.j) {
                p73 f = p73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f0181);
                f.l(1);
                f.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(x34 x34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var};
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
                Intent addFlags = new Intent().putExtra("swan_error_type", "type_load_v8_failed").setComponent(new ComponentName(AppRuntime.getAppContext(), SwanAppErrorActivity.class)).addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (x73.M() != null) {
                    gk3.j(x73.M().w());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements z34.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x34 a;

        public d(x34 x34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x34Var;
        }

        @Override // com.baidu.tieba.z34.e
        public void a(ff2 ff2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ff2Var) == null) {
                if (x34.j) {
                    Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                }
                synchronized (this.a.b) {
                    this.a.g = true;
                    this.a.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(x34 x34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var};
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
                Toast.makeText(AppRuntime.getAppContext(), (int) R.string.obfuscated_res_0x7f0f0132, 1).show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249424, "Lcom/baidu/tieba/x34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249424, "Lcom/baidu/tieba/x34;");
                return;
            }
        }
        j = ho1.a;
    }

    public static x34 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (k == null) {
                synchronized (x34.class) {
                    if (k == null) {
                        k = new x34();
                    }
                }
            }
            return k;
        }
        return (x34) invokeV.objValue;
    }

    public void H() {
        z34 z34Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (z34Var = this.e) != null) {
            z34Var.o().D0();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                if (j) {
                    Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                }
                D(gi2.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            z34 z34Var = this.e;
            if (z34Var != null) {
                return z34Var.n();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ExtensionCore k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.c;
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                return this.c.swanCorePath;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public ff2 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            z34 z34Var = this.e;
            if (z34Var != null) {
                return z34Var.o();
            }
            return null;
        }
        return (ff2) invokeV.objValue;
    }

    public DuMixGameSurfaceView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            z34 z34Var = this.e;
            if (z34Var != null) {
                return z34Var.p();
            }
            return null;
        }
        return (DuMixGameSurfaceView) invokeV.objValue;
    }

    public SwanCoreVersion s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.b) {
                if (this.g && this.e != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.h || (r = r()) == null || r.getParent() != null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
            }
            z(null);
        }
    }

    public x34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = new Object();
        this.f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (x34.class) {
                if (j) {
                    Log.d("SwanGameCoreRuntime", "release");
                }
                if (k == null) {
                    return;
                }
                k.h = true;
                if (k.e != null) {
                    k.e.m();
                }
                k = null;
                m().y();
            }
        }
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a < 0) {
                er2.g0().getSwitch("swan_game_preload", 0);
                this.a = 0;
            }
            if (j) {
                Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.a);
            }
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            er2.g0().getSwitch("swan_game_startup_improvement", false);
            if (j) {
                Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:false");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.h || this.f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f.clear();
    }

    public void G(us2 us2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, us2Var) == null) {
            ExtensionCore extensionCore = this.d;
            if (extensionCore != null) {
                us2Var.C0(extensionCore);
            } else {
                this.d = us2Var.O();
            }
        }
    }

    public void h(Activity activity) {
        z34 z34Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, activity) == null) && (z34Var = this.e) != null) {
            z34Var.k(activity);
        }
    }

    public void i(JSEvent jSEvent) {
        z34 z34Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) && (z34Var = this.e) != null) {
            z34Var.o().dispatchEvent(jSEvent);
        }
    }

    public final boolean t(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, intent)) == null) {
            int p = p();
            if (p == 1) {
                return true;
            }
            if (p == 2 && intent == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.b) {
                if (!this.g && this.e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.h) {
                        return;
                    }
                    if (j) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + l);
                    }
                    z34 z34Var = new z34(l, "swan-game.js");
                    this.e = z34Var;
                    z34Var.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "prepareRuntime");
            }
            if (fVar != null && !this.f.contains(fVar)) {
                this.f.add(fVar);
            }
            if (u()) {
                w();
            } else {
                A();
            }
        }
    }

    public final void E(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, swanCoreVersion) == null) && swanCoreVersion != null && swanCoreVersion.isAvailable()) {
            this.c = swanCoreVersion;
            if (j) {
                Log.d("SwanGameCoreRuntime", "setSwanCoreVersion: " + this.c);
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        g72 Z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, swanAppActivity) != null) || swanAppActivity == null || swanAppActivity.isFinishing() || (Z = swanAppActivity.Z()) == null) {
            return;
        }
        g72.b h = Z.h();
        h.n(0, 0);
        h.f();
        h.j(u34.J3());
        h.b();
    }

    public void I(us2 us2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, us2Var) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.c;
            if (swanCoreVersion != null) {
                us2Var.Z0(swanCoreVersion);
            }
            if (j) {
                Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.c);
            }
        }
    }

    public void D(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (j) {
                    Log.d("SwanGameCoreRuntime", "setExtensionCore: " + this.d);
                }
                this.d = extensionCore;
            } else if (j) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanGameCoreRuntime", sb.toString());
            }
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (j) {
                String str = null;
                if (intent != null) {
                    str = intent.getStringExtra("bundle_key_preload_preload_scene");
                }
                Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
            }
            if (u() || !t(intent)) {
                return;
            }
            boolean b2 = qd3.c().b();
            boolean b3 = qd3.b();
            if (b2 && b3) {
                B(new a(this));
            }
        }
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (c44.a("package")) {
                if (TextUtils.isEmpty(this.i)) {
                    return null;
                }
                if (!new File(this.i, "swan-game.js").exists()) {
                    rl3.e0(new e(this));
                    return ch3.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!c44.a("normal") && !w33.h()) {
                return ch3.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = b44.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                if (j) {
                    Log.d("SwanGameCoreRuntime", "getPreGameCoreVersion DebugSwanGameCoreMode");
                }
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public void x(n44.c cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "onAppReady");
            }
            if (cVar != null && !TextUtils.isEmpty(cVar.a)) {
                this.i = cVar.a;
                HybridUbcFlow p = c13.p("startup");
                if (u()) {
                    str = "1";
                } else {
                    str = "0";
                }
                p.D("preload", str);
                c13.p("startup").F(new UbcFlowEvent("na_prepare_runtime_start"));
                boolean b2 = qd3.c().b();
                boolean b3 = qd3.b();
                if (b2 && b3) {
                    B(new c(this, cVar));
                    if (this.e != null) {
                        l64.b().f(this.e.o(), cVar);
                        return;
                    }
                    return;
                }
                if (x73.M() != null) {
                    ye3 ye3Var = new ye3();
                    ye3Var.q(qe3.n(1));
                    ye3Var.r(x73.M().Y());
                    ye3Var.l("gameCoreRuntime", "loadv8Failed");
                    qe3.R(ye3Var);
                }
                rl3.e0(new b(this));
            }
        }
    }
}
