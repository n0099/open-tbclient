package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
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
/* loaded from: classes4.dex */
public class j02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile j02 g;
    public transient /* synthetic */ FieldHolder $fh;
    public t42 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes4.dex */
    public class a implements qa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;
        public final /* synthetic */ u42 b;
        public final /* synthetic */ ep1 c;
        public final /* synthetic */ ul2.g d;
        public final /* synthetic */ j02 e;

        public a(j02 j02Var, vn2 vn2Var, u42 u42Var, ep1 ep1Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, vn2Var, u42Var, ep1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j02Var;
            this.a = vn2Var;
            this.b = u42Var;
            this.c = ep1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.qa2
        public void a(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ga2Var) == null) {
                this.e.d = true;
                h02.e().f("loaddebug");
                yz1.k("LocalDebugger", "prepareDaemon finish.");
                zc2 j = this.e.j(this.a);
                this.e.t(j);
                if (j02.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;
        public final /* synthetic */ ep1 b;
        public final /* synthetic */ vn2 c;
        public final /* synthetic */ ul2.g d;
        public final /* synthetic */ j02 e;

        public b(j02 j02Var, u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, u42Var, ep1Var, vn2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j02Var;
            this.a = u42Var;
            this.b = ep1Var;
            this.c = vn2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (j02.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(j02 j02Var, u42 u42Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, u42Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
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

    /* loaded from: classes4.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && j02.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(j02 j02Var, ep1 ep1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, ep1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.fp1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;
        public final /* synthetic */ ep1 b;
        public final /* synthetic */ vn2 c;
        public final /* synthetic */ ul2.g d;
        public final /* synthetic */ j02 e;

        public f(j02 j02Var, u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, u42Var, ep1Var, vn2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j02Var;
            this.a = u42Var;
            this.b = ep1Var;
            this.c = vn2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (j02.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;
        public final /* synthetic */ ep1 b;
        public final /* synthetic */ vn2 c;
        public final /* synthetic */ ul2.g d;

        public g(j02 j02Var, u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j02Var, u42Var, ep1Var, vn2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
            this.b = ep1Var;
            this.c = vn2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947829405, "Lcom/baidu/tieba/j02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947829405, "Lcom/baidu/tieba/j02;");
                return;
            }
        }
        f = ij1.a;
    }

    public j02() {
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

    public static j02 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (j02.class) {
                    if (g == null) {
                        g = new j02();
                    }
                }
            }
            return g;
        }
        return (j02) invokeV.objValue;
    }

    public final zc2 j(@NonNull vn2<vn2.a> vn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vn2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", vn2Var.X());
                jSONObject.put("wsServerPort", vn2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new zc2("message", hashMap);
        }
        return (zc2) invokeL.objValue;
    }

    public ga2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t42 t42Var = this.a;
            if (t42Var != null) {
                return t42Var.a();
            }
            return null;
        }
        return (ga2) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void n(u42 u42Var, ep1<?> ep1Var, vn2<vn2.a> vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, u42Var, ep1Var, vn2Var, gVar) == null) {
            if (u42Var != null && u42Var.f() != null) {
                sg3.a0(new c(this, u42Var, cj4.E(new File(f02.e())), new b(this, u42Var, ep1Var, vn2Var, gVar)));
            } else {
                yz1.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(ep1<?> ep1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ep1Var, valueCallback) == null) {
            if (ep1Var != null && ep1Var.r() != null) {
                String E = cj4.E(new File(f02.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                sg3.a0(new e(this, ep1Var, E, valueCallback));
                return;
            }
            yz1.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(u42 u42Var, ep1<?> ep1Var, vn2<vn2.a> vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, u42Var, ep1Var, vn2Var, gVar) == null) {
            o(ep1Var, new f(this, u42Var, ep1Var, vn2Var, gVar));
        }
    }

    public void q(u42 u42Var, ep1<?> ep1Var, vn2<vn2.a> vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, u42Var, ep1Var, vn2Var, gVar) == null) && s92.U().q0()) {
            yz1.k("LocalDebugger", "prepareDaemon start.");
            if (this.e && this.d && this.a != null) {
                n(u42Var, ep1Var, vn2Var, gVar);
                p(u42Var, ep1Var, vn2Var, gVar);
                return;
            }
            t42 d2 = s92.U().f0().d();
            this.a = d2;
            d2.c(new a(this, vn2Var, u42Var, ep1Var, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yz1.k("LocalDebugger", "releaseLocalDebugger");
            t42 t42Var = this.a;
            if (t42Var != null) {
                t42Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            yz1.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final void t(yc2 yc2Var) {
        t42 t42Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, yc2Var) == null) || (t42Var = this.a) == null) {
            return;
        }
        uc2.a(t42Var.a(), yc2Var);
    }

    public final synchronized void u(u42 u42Var, ep1<?> ep1Var, vn2<vn2.a> vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, u42Var, ep1Var, vn2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    yz1.k("LocalDebugger", "startFirstPage");
                    sg3.a0(new g(this, u42Var, ep1Var, vn2Var, gVar));
                }
            }
        }
    }
}
