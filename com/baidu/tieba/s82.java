package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
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
/* loaded from: classes7.dex */
public class s82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile s82 g;
    public transient /* synthetic */ FieldHolder $fh;
    public cd2 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes7.dex */
    public class a implements zi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ dd2 b;
        public final /* synthetic */ nx1 c;
        public final /* synthetic */ du2.g d;
        public final /* synthetic */ s82 e;

        public a(s82 s82Var, ew2 ew2Var, dd2 dd2Var, nx1 nx1Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, ew2Var, dd2Var, nx1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s82Var;
            this.a = ew2Var;
            this.b = dd2Var;
            this.c = nx1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.zi2
        public void a(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pi2Var) == null) {
                this.e.d = true;
                q82.e().f("loaddebug");
                h82.k("LocalDebugger", "prepareDaemon finish.");
                il2 j = this.e.j(this.a);
                this.e.t(j);
                if (s82.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;
        public final /* synthetic */ nx1 b;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ du2.g d;
        public final /* synthetic */ s82 e;

        public b(s82 s82Var, dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, dd2Var, nx1Var, ew2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s82Var;
            this.a = dd2Var;
            this.b = nx1Var;
            this.c = ew2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (s82.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(s82 s82Var, dd2 dd2Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, dd2Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(s82 s82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && s82.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(s82 s82Var, nx1 nx1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, nx1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.ox1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;
        public final /* synthetic */ nx1 b;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ du2.g d;
        public final /* synthetic */ s82 e;

        public f(s82 s82Var, dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, dd2Var, nx1Var, ew2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s82Var;
            this.a = dd2Var;
            this.b = nx1Var;
            this.c = ew2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (s82.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;
        public final /* synthetic */ nx1 b;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ du2.g d;

        public g(s82 s82Var, dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s82Var, dd2Var, nx1Var, ew2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
            this.b = nx1Var;
            this.c = ew2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                se3.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105212, "Lcom/baidu/tieba/s82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105212, "Lcom/baidu/tieba/s82;");
                return;
            }
        }
        f = rr1.a;
    }

    public s82() {
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

    public static s82 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (s82.class) {
                    if (g == null) {
                        g = new s82();
                    }
                }
            }
            return g;
        }
        return (s82) invokeV.objValue;
    }

    public pi2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cd2 cd2Var = this.a;
            if (cd2Var != null) {
                return cd2Var.a();
            }
            return null;
        }
        return (pi2) invokeV.objValue;
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
            h82.k("LocalDebugger", "releaseLocalDebugger");
            cd2 cd2Var = this.a;
            if (cd2Var != null) {
                cd2Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h82.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final il2 j(@NonNull ew2<ew2.a> ew2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ew2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", ew2Var.X());
                jSONObject.put("wsServerPort", ew2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new il2("message", hashMap);
        }
        return (il2) invokeL.objValue;
    }

    public final void n(dd2 dd2Var, nx1<?> nx1Var, ew2<ew2.a> ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, dd2Var, nx1Var, ew2Var, gVar) == null) {
            if (dd2Var != null && dd2Var.e() != null) {
                bp3.a0(new c(this, dd2Var, lr4.E(new File(o82.e())), new b(this, dd2Var, nx1Var, ew2Var, gVar)));
            } else {
                h82.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(nx1<?> nx1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, nx1Var, valueCallback) == null) {
            if (nx1Var != null && nx1Var.r() != null) {
                String E = lr4.E(new File(o82.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                bp3.a0(new e(this, nx1Var, E, valueCallback));
                return;
            }
            h82.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(dd2 dd2Var, nx1<?> nx1Var, ew2<ew2.a> ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, dd2Var, nx1Var, ew2Var, gVar) == null) {
            o(nx1Var, new f(this, dd2Var, nx1Var, ew2Var, gVar));
        }
    }

    public final synchronized void u(dd2 dd2Var, nx1<?> nx1Var, ew2<ew2.a> ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, dd2Var, nx1Var, ew2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    h82.k("LocalDebugger", "startFirstPage");
                    bp3.a0(new g(this, dd2Var, nx1Var, ew2Var, gVar));
                }
            }
        }
    }

    public void q(dd2 dd2Var, nx1<?> nx1Var, ew2<ew2.a> ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, dd2Var, nx1Var, ew2Var, gVar) != null) || !bi2.U().q0()) {
            return;
        }
        h82.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(dd2Var, nx1Var, ew2Var, gVar);
            p(dd2Var, nx1Var, ew2Var, gVar);
            return;
        }
        cd2 d2 = bi2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, ew2Var, dd2Var, nx1Var, gVar));
    }

    public final void t(hl2 hl2Var) {
        cd2 cd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, hl2Var) == null) && (cd2Var = this.a) != null) {
            dl2.a(cd2Var.a(), hl2Var);
        }
    }
}
