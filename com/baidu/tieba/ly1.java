package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wj2;
import com.baidu.tieba.xl2;
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
/* loaded from: classes5.dex */
public class ly1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile ly1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public v22 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes5.dex */
    public class a implements s82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl2 a;
        public final /* synthetic */ w22 b;
        public final /* synthetic */ gn1 c;
        public final /* synthetic */ wj2.g d;
        public final /* synthetic */ ly1 e;

        public a(ly1 ly1Var, xl2 xl2Var, w22 w22Var, gn1 gn1Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, xl2Var, w22Var, gn1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ly1Var;
            this.a = xl2Var;
            this.b = w22Var;
            this.c = gn1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.s82
        public void a(i82 i82Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i82Var) == null) {
                this.e.d = true;
                jy1.e().f("loaddebug");
                ay1.k("LocalDebugger", "prepareDaemon finish.");
                bb2 j = this.e.j(this.a);
                this.e.t(j);
                if (ly1.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;
        public final /* synthetic */ gn1 b;
        public final /* synthetic */ xl2 c;
        public final /* synthetic */ wj2.g d;
        public final /* synthetic */ ly1 e;

        public b(ly1 ly1Var, w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, w22Var, gn1Var, xl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ly1Var;
            this.a = w22Var;
            this.b = gn1Var;
            this.c = xl2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ly1.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(ly1 ly1Var, w22 w22Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, w22Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w22Var;
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

    /* loaded from: classes5.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ly1 ly1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && ly1.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(ly1 ly1Var, gn1 gn1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, gn1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.hn1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;
        public final /* synthetic */ gn1 b;
        public final /* synthetic */ xl2 c;
        public final /* synthetic */ wj2.g d;
        public final /* synthetic */ ly1 e;

        public f(ly1 ly1Var, w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, w22Var, gn1Var, xl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ly1Var;
            this.a = w22Var;
            this.b = gn1Var;
            this.c = xl2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ly1.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;
        public final /* synthetic */ gn1 b;
        public final /* synthetic */ xl2 c;
        public final /* synthetic */ wj2.g d;

        public g(ly1 ly1Var, w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly1Var, w22Var, gn1Var, xl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w22Var;
            this.b = gn1Var;
            this.c = xl2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l43.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947959109, "Lcom/baidu/tieba/ly1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947959109, "Lcom/baidu/tieba/ly1;");
                return;
            }
        }
        f = kh1.a;
    }

    public ly1() {
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

    public static ly1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (ly1.class) {
                    if (g == null) {
                        g = new ly1();
                    }
                }
            }
            return g;
        }
        return (ly1) invokeV.objValue;
    }

    public final bb2 j(@NonNull xl2<xl2.a> xl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xl2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", xl2Var.X());
                jSONObject.put("wsServerPort", xl2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new bb2("message", hashMap);
        }
        return (bb2) invokeL.objValue;
    }

    public i82 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            v22 v22Var = this.a;
            if (v22Var != null) {
                return v22Var.a();
            }
            return null;
        }
        return (i82) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void n(w22 w22Var, gn1<?> gn1Var, xl2<xl2.a> xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, w22Var, gn1Var, xl2Var, gVar) == null) {
            if (w22Var != null && w22Var.e() != null) {
                ue3.a0(new c(this, w22Var, ch4.E(new File(hy1.e())), new b(this, w22Var, gn1Var, xl2Var, gVar)));
            } else {
                ay1.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(gn1<?> gn1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gn1Var, valueCallback) == null) {
            if (gn1Var != null && gn1Var.r() != null) {
                String E = ch4.E(new File(hy1.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                ue3.a0(new e(this, gn1Var, E, valueCallback));
                return;
            }
            ay1.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(w22 w22Var, gn1<?> gn1Var, xl2<xl2.a> xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, w22Var, gn1Var, xl2Var, gVar) == null) {
            o(gn1Var, new f(this, w22Var, gn1Var, xl2Var, gVar));
        }
    }

    public void q(w22 w22Var, gn1<?> gn1Var, xl2<xl2.a> xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, w22Var, gn1Var, xl2Var, gVar) == null) && u72.U().q0()) {
            ay1.k("LocalDebugger", "prepareDaemon start.");
            if (this.e && this.d && this.a != null) {
                n(w22Var, gn1Var, xl2Var, gVar);
                p(w22Var, gn1Var, xl2Var, gVar);
                return;
            }
            v22 d2 = u72.U().f0().d();
            this.a = d2;
            d2.c(new a(this, xl2Var, w22Var, gn1Var, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ay1.k("LocalDebugger", "releaseLocalDebugger");
            v22 v22Var = this.a;
            if (v22Var != null) {
                v22Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ay1.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final void t(ab2 ab2Var) {
        v22 v22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ab2Var) == null) || (v22Var = this.a) == null) {
            return;
        }
        wa2.a(v22Var.a(), ab2Var);
    }

    public final synchronized void u(w22 w22Var, gn1<?> gn1Var, xl2<xl2.a> xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, w22Var, gn1Var, xl2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    ay1.k("LocalDebugger", "startFirstPage");
                    ue3.a0(new g(this, w22Var, gn1Var, xl2Var, gVar));
                }
            }
        }
    }
}
