package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vu2;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile k92 g;
    public transient /* synthetic */ FieldHolder $fh;
    public ud2 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes6.dex */
    public class a implements rj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 a;
        public final /* synthetic */ vd2 b;
        public final /* synthetic */ fy1 c;
        public final /* synthetic */ vu2.g d;
        public final /* synthetic */ k92 e;

        public a(k92 k92Var, ww2 ww2Var, vd2 vd2Var, fy1 fy1Var, vu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, ww2Var, vd2Var, fy1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k92Var;
            this.a = ww2Var;
            this.b = vd2Var;
            this.c = fy1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.rj2
        public void a(hj2 hj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hj2Var) == null) {
                this.e.d = true;
                i92.e().f("loaddebug");
                z82.k("LocalDebugger", "prepareDaemon finish.");
                am2 j = this.e.j(this.a);
                this.e.t(j);
                if (k92.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ fy1 b;
        public final /* synthetic */ ww2 c;
        public final /* synthetic */ vu2.g d;
        public final /* synthetic */ k92 e;

        public b(k92 k92Var, vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, vd2Var, fy1Var, ww2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k92Var;
            this.a = vd2Var;
            this.b = fy1Var;
            this.c = ww2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (k92.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(k92 k92Var, vd2 vd2Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, vd2Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd2Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
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
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k92.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(k92 k92Var, fy1 fy1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, fy1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fy1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.gy1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ fy1 b;
        public final /* synthetic */ ww2 c;
        public final /* synthetic */ vu2.g d;
        public final /* synthetic */ k92 e;

        public f(k92 k92Var, vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, vd2Var, fy1Var, ww2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k92Var;
            this.a = vd2Var;
            this.b = fy1Var;
            this.c = ww2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (k92.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ fy1 b;
        public final /* synthetic */ ww2 c;
        public final /* synthetic */ vu2.g d;

        public g(k92 k92Var, vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, vd2Var, fy1Var, ww2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd2Var;
            this.b = fy1Var;
            this.c = ww2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf3.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867845, "Lcom/baidu/tieba/k92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867845, "Lcom/baidu/tieba/k92;");
                return;
            }
        }
        f = js1.a;
    }

    public k92() {
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
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
    }

    public static k92 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (k92.class) {
                    if (g == null) {
                        g = new k92();
                    }
                }
            }
            return g;
        }
        return (k92) invokeV.objValue;
    }

    public hj2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ud2 ud2Var = this.a;
            if (ud2Var != null) {
                return ud2Var.a();
            }
            return null;
        }
        return (hj2) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            z82.k("LocalDebugger", "releaseLocalDebugger");
            ud2 ud2Var = this.a;
            if (ud2Var != null) {
                ud2Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            z82.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final am2 j(@NonNull ww2<ww2.a> ww2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ww2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", ww2Var.X());
                jSONObject.put("wsServerPort", ww2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new am2("message", hashMap);
        }
        return (am2) invokeL.objValue;
    }

    public final void n(vd2 vd2Var, fy1<?> fy1Var, ww2<ww2.a> ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, vd2Var, fy1Var, ww2Var, gVar) == null) {
            if (vd2Var != null && vd2Var.d() != null) {
                tp3.a0(new c(this, vd2Var, ds4.E(new File(g92.e())), new b(this, vd2Var, fy1Var, ww2Var, gVar)));
            } else {
                z82.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(fy1<?> fy1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fy1Var, valueCallback) == null) {
            if (fy1Var != null && fy1Var.r() != null) {
                String E = ds4.E(new File(g92.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                tp3.a0(new e(this, fy1Var, E, valueCallback));
                return;
            }
            z82.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(vd2 vd2Var, fy1<?> fy1Var, ww2<ww2.a> ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, vd2Var, fy1Var, ww2Var, gVar) == null) {
            o(fy1Var, new f(this, vd2Var, fy1Var, ww2Var, gVar));
        }
    }

    public final synchronized void u(vd2 vd2Var, fy1<?> fy1Var, ww2<ww2.a> ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, vd2Var, fy1Var, ww2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    z82.k("LocalDebugger", "startFirstPage");
                    tp3.a0(new g(this, vd2Var, fy1Var, ww2Var, gVar));
                }
            }
        }
    }

    public void q(vd2 vd2Var, fy1<?> fy1Var, ww2<ww2.a> ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, vd2Var, fy1Var, ww2Var, gVar) != null) || !ti2.U().q0()) {
            return;
        }
        z82.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(vd2Var, fy1Var, ww2Var, gVar);
            p(vd2Var, fy1Var, ww2Var, gVar);
            return;
        }
        ud2 d2 = ti2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, ww2Var, vd2Var, fy1Var, gVar));
    }

    public final void t(zl2 zl2Var) {
        ud2 ud2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, zl2Var) == null) && (ud2Var = this.a) != null) {
            vl2.a(ud2Var.a(), zl2Var);
        }
    }
}
