package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im2;
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
public class x02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile x02 g;
    public transient /* synthetic */ FieldHolder $fh;
    public h52 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes6.dex */
    public class a implements eb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;
        public final /* synthetic */ i52 b;
        public final /* synthetic */ sp1 c;
        public final /* synthetic */ im2.g d;
        public final /* synthetic */ x02 e;

        public a(x02 x02Var, jo2 jo2Var, i52 i52Var, sp1 sp1Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, jo2Var, i52Var, sp1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x02Var;
            this.a = jo2Var;
            this.b = i52Var;
            this.c = sp1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.eb2
        public void a(ua2 ua2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ua2Var) == null) {
                this.e.d = true;
                v02.e().f("loaddebug");
                m02.k("LocalDebugger", "prepareDaemon finish.");
                nd2 j = this.e.j(this.a);
                this.e.t(j);
                if (x02.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i52 a;
        public final /* synthetic */ sp1 b;
        public final /* synthetic */ jo2 c;
        public final /* synthetic */ im2.g d;
        public final /* synthetic */ x02 e;

        public b(x02 x02Var, i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, i52Var, sp1Var, jo2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x02Var;
            this.a = i52Var;
            this.b = sp1Var;
            this.c = jo2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (x02.f) {
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
        public final /* synthetic */ i52 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(x02 x02Var, i52 i52Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, i52Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i52Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(x02 x02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && x02.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(x02 x02Var, sp1 sp1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, sp1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp1Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ValueCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i52 a;
        public final /* synthetic */ sp1 b;
        public final /* synthetic */ jo2 c;
        public final /* synthetic */ im2.g d;
        public final /* synthetic */ x02 e;

        public f(x02 x02Var, i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, i52Var, sp1Var, jo2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x02Var;
            this.a = i52Var;
            this.b = sp1Var;
            this.c = jo2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (x02.f) {
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
        public final /* synthetic */ i52 a;
        public final /* synthetic */ sp1 b;
        public final /* synthetic */ jo2 c;
        public final /* synthetic */ im2.g d;

        public g(x02 x02Var, i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x02Var, i52Var, sp1Var, jo2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i52Var;
            this.b = sp1Var;
            this.c = jo2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x63.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246479, "Lcom/baidu/tieba/x02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246479, "Lcom/baidu/tieba/x02;");
                return;
            }
        }
        f = wj1.a;
    }

    public x02() {
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

    public static x02 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (x02.class) {
                    if (g == null) {
                        g = new x02();
                    }
                }
            }
            return g;
        }
        return (x02) invokeV.objValue;
    }

    public ua2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h52 h52Var = this.a;
            if (h52Var != null) {
                return h52Var.a();
            }
            return null;
        }
        return (ua2) invokeV.objValue;
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
            m02.k("LocalDebugger", "releaseLocalDebugger");
            h52 h52Var = this.a;
            if (h52Var != null) {
                h52Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m02.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final nd2 j(jo2 jo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jo2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", jo2Var.X());
                jSONObject.put("wsServerPort", jo2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new nd2("message", hashMap);
        }
        return (nd2) invokeL.objValue;
    }

    public final void n(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, i52Var, sp1Var, jo2Var, gVar) == null) {
            if (i52Var != null && i52Var.f() != null) {
                gh3.a0(new c(this, i52Var, qj4.E(new File(t02.e())), new b(this, i52Var, sp1Var, jo2Var, gVar)));
            } else {
                m02.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(sp1 sp1Var, ValueCallback valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sp1Var, valueCallback) == null) {
            if (sp1Var != null && sp1Var.r() != null) {
                String E = qj4.E(new File(t02.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                gh3.a0(new e(this, sp1Var, E, valueCallback));
                return;
            }
            m02.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, i52Var, sp1Var, jo2Var, gVar) == null) {
            o(sp1Var, new f(this, i52Var, sp1Var, jo2Var, gVar));
        }
    }

    public final synchronized void u(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, i52Var, sp1Var, jo2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    m02.k("LocalDebugger", "startFirstPage");
                    gh3.a0(new g(this, i52Var, sp1Var, jo2Var, gVar));
                }
            }
        }
    }

    public void q(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, i52Var, sp1Var, jo2Var, gVar) != null) || !ga2.U().q0()) {
            return;
        }
        m02.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(i52Var, sp1Var, jo2Var, gVar);
            p(i52Var, sp1Var, jo2Var, gVar);
            return;
        }
        h52 d2 = ga2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, jo2Var, i52Var, sp1Var, gVar));
    }

    public final void t(md2 md2Var) {
        h52 h52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, md2Var) == null) && (h52Var = this.a) != null) {
            id2.a(h52Var.a(), md2Var);
        }
    }
}
