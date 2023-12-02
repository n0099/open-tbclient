package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gp2;
import com.baidu.tieba.hr2;
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
/* loaded from: classes8.dex */
public class v32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile v32 g;
    public transient /* synthetic */ FieldHolder $fh;
    public f82 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes8.dex */
    public class a implements ce2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ g82 b;
        public final /* synthetic */ rs1 c;
        public final /* synthetic */ gp2.g d;
        public final /* synthetic */ v32 e;

        public a(v32 v32Var, hr2 hr2Var, g82 g82Var, rs1 rs1Var, gp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, hr2Var, g82Var, rs1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v32Var;
            this.a = hr2Var;
            this.b = g82Var;
            this.c = rs1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.ce2
        public void a(sd2 sd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sd2Var) == null) {
                this.e.d = true;
                t32.e().f("loaddebug");
                k32.k("LocalDebugger", "prepareDaemon finish.");
                lg2 j = this.e.j(this.a);
                this.e.t(j);
                if (v32.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g82 a;
        public final /* synthetic */ rs1 b;
        public final /* synthetic */ hr2 c;
        public final /* synthetic */ gp2.g d;
        public final /* synthetic */ v32 e;

        public b(v32 v32Var, g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, g82Var, rs1Var, hr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v32Var;
            this.a = g82Var;
            this.b = rs1Var;
            this.c = hr2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (v32.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g82 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(v32 v32Var, g82 g82Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, g82Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g82Var;
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

    /* loaded from: classes8.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(v32 v32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && v32.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(v32 v32Var, rs1 rs1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, rs1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.ss1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getWebView().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g82 a;
        public final /* synthetic */ rs1 b;
        public final /* synthetic */ hr2 c;
        public final /* synthetic */ gp2.g d;
        public final /* synthetic */ v32 e;

        public f(v32 v32Var, g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, g82Var, rs1Var, hr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v32Var;
            this.a = g82Var;
            this.b = rs1Var;
            this.c = hr2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (v32.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g82 a;
        public final /* synthetic */ rs1 b;
        public final /* synthetic */ hr2 c;
        public final /* synthetic */ gp2.g d;

        public g(v32 v32Var, g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v32Var, g82Var, rs1Var, hr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g82Var;
            this.b = rs1Var;
            this.c = hr2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v93.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189780, "Lcom/baidu/tieba/v32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189780, "Lcom/baidu/tieba/v32;");
                return;
            }
        }
        f = vm1.a;
    }

    public v32() {
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

    public static v32 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (v32.class) {
                    if (g == null) {
                        g = new v32();
                    }
                }
            }
            return g;
        }
        return (v32) invokeV.objValue;
    }

    public sd2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f82 f82Var = this.a;
            if (f82Var != null) {
                return f82Var.a();
            }
            return null;
        }
        return (sd2) invokeV.objValue;
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
            k32.k("LocalDebugger", "releaseLocalDebugger");
            f82 f82Var = this.a;
            if (f82Var != null) {
                f82Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k32.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final lg2 j(@NonNull hr2<hr2.a> hr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hr2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", hr2Var.Y());
                jSONObject.put("wsServerPort", hr2Var.Z());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new lg2("message", hashMap);
        }
        return (lg2) invokeL.objValue;
    }

    public final void n(g82 g82Var, rs1<?> rs1Var, hr2<hr2.a> hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, g82Var, rs1Var, hr2Var, gVar) == null) {
            if (g82Var != null && g82Var.e() != null) {
                ek3.a0(new c(this, g82Var, nm4.E(new File(r32.e())), new b(this, g82Var, rs1Var, hr2Var, gVar)));
            } else {
                k32.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(rs1<?> rs1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, rs1Var, valueCallback) == null) {
            if (rs1Var != null && rs1Var.getWebView() != null) {
                String E = nm4.E(new File(r32.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                ek3.a0(new e(this, rs1Var, E, valueCallback));
                return;
            }
            k32.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(g82 g82Var, rs1<?> rs1Var, hr2<hr2.a> hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, g82Var, rs1Var, hr2Var, gVar) == null) {
            o(rs1Var, new f(this, g82Var, rs1Var, hr2Var, gVar));
        }
    }

    public final synchronized void u(g82 g82Var, rs1<?> rs1Var, hr2<hr2.a> hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, g82Var, rs1Var, hr2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    k32.k("LocalDebugger", "startFirstPage");
                    ek3.a0(new g(this, g82Var, rs1Var, hr2Var, gVar));
                }
            }
        }
    }

    public void q(g82 g82Var, rs1<?> rs1Var, hr2<hr2.a> hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, g82Var, rs1Var, hr2Var, gVar) != null) || !ed2.V().r0()) {
            return;
        }
        k32.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(g82Var, rs1Var, hr2Var, gVar);
            p(g82Var, rs1Var, hr2Var, gVar);
            return;
        }
        f82 d2 = ed2.V().g0().d();
        this.a = d2;
        d2.c(new a(this, hr2Var, g82Var, rs1Var, gVar));
    }

    public final void t(kg2 kg2Var) {
        f82 f82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, kg2Var) == null) && (f82Var = this.a) != null) {
            gg2.a(f82Var.a(), kg2Var);
        }
    }
}
