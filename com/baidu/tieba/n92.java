package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yu2;
import com.baidu.tieba.zw2;
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
public class n92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile n92 g;
    public transient /* synthetic */ FieldHolder $fh;
    public xd2 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes7.dex */
    public class a implements uj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;
        public final /* synthetic */ yd2 b;
        public final /* synthetic */ iy1 c;
        public final /* synthetic */ yu2.g d;
        public final /* synthetic */ n92 e;

        public a(n92 n92Var, zw2 zw2Var, yd2 yd2Var, iy1 iy1Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, zw2Var, yd2Var, iy1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n92Var;
            this.a = zw2Var;
            this.b = yd2Var;
            this.c = iy1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.uj2
        public void a(kj2 kj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kj2Var) == null) {
                this.e.d = true;
                l92.e().f("loaddebug");
                c92.k("LocalDebugger", "prepareDaemon finish.");
                dm2 j = this.e.j(this.a);
                this.e.t(j);
                if (n92.f) {
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
        public final /* synthetic */ yd2 a;
        public final /* synthetic */ iy1 b;
        public final /* synthetic */ zw2 c;
        public final /* synthetic */ yu2.g d;
        public final /* synthetic */ n92 e;

        public b(n92 n92Var, yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, yd2Var, iy1Var, zw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n92Var;
            this.a = yd2Var;
            this.b = iy1Var;
            this.c = zw2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (n92.f) {
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
        public final /* synthetic */ yd2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(n92 n92Var, yd2 yd2Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, yd2Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
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

    /* loaded from: classes7.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(n92 n92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && n92.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(n92 n92Var, iy1 iy1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, iy1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.jy1] */
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
        public final /* synthetic */ yd2 a;
        public final /* synthetic */ iy1 b;
        public final /* synthetic */ zw2 c;
        public final /* synthetic */ yu2.g d;
        public final /* synthetic */ n92 e;

        public f(n92 n92Var, yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, yd2Var, iy1Var, zw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n92Var;
            this.a = yd2Var;
            this.b = iy1Var;
            this.c = zw2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (n92.f) {
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
        public final /* synthetic */ yd2 a;
        public final /* synthetic */ iy1 b;
        public final /* synthetic */ zw2 c;
        public final /* synthetic */ yu2.g d;

        public g(n92 n92Var, yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n92Var, yd2Var, iy1Var, zw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
            this.b = iy1Var;
            this.c = zw2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nf3.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957218, "Lcom/baidu/tieba/n92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957218, "Lcom/baidu/tieba/n92;");
                return;
            }
        }
        f = ms1.a;
    }

    public n92() {
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

    public static n92 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (n92.class) {
                    if (g == null) {
                        g = new n92();
                    }
                }
            }
            return g;
        }
        return (n92) invokeV.objValue;
    }

    public kj2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xd2 xd2Var = this.a;
            if (xd2Var != null) {
                return xd2Var.a();
            }
            return null;
        }
        return (kj2) invokeV.objValue;
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
            c92.k("LocalDebugger", "releaseLocalDebugger");
            xd2 xd2Var = this.a;
            if (xd2Var != null) {
                xd2Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c92.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final dm2 j(@NonNull zw2<zw2.a> zw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zw2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", zw2Var.X());
                jSONObject.put("wsServerPort", zw2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new dm2("message", hashMap);
        }
        return (dm2) invokeL.objValue;
    }

    public final void n(yd2 yd2Var, iy1<?> iy1Var, zw2<zw2.a> zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, yd2Var, iy1Var, zw2Var, gVar) == null) {
            if (yd2Var != null && yd2Var.d() != null) {
                wp3.a0(new c(this, yd2Var, gs4.E(new File(j92.e())), new b(this, yd2Var, iy1Var, zw2Var, gVar)));
            } else {
                c92.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(iy1<?> iy1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iy1Var, valueCallback) == null) {
            if (iy1Var != null && iy1Var.r() != null) {
                String E = gs4.E(new File(j92.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                wp3.a0(new e(this, iy1Var, E, valueCallback));
                return;
            }
            c92.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(yd2 yd2Var, iy1<?> iy1Var, zw2<zw2.a> zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, yd2Var, iy1Var, zw2Var, gVar) == null) {
            o(iy1Var, new f(this, yd2Var, iy1Var, zw2Var, gVar));
        }
    }

    public final synchronized void u(yd2 yd2Var, iy1<?> iy1Var, zw2<zw2.a> zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, yd2Var, iy1Var, zw2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    c92.k("LocalDebugger", "startFirstPage");
                    wp3.a0(new g(this, yd2Var, iy1Var, zw2Var, gVar));
                }
            }
        }
    }

    public void q(yd2 yd2Var, iy1<?> iy1Var, zw2<zw2.a> zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, yd2Var, iy1Var, zw2Var, gVar) != null) || !wi2.U().q0()) {
            return;
        }
        c92.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(yd2Var, iy1Var, zw2Var, gVar);
            p(yd2Var, iy1Var, zw2Var, gVar);
            return;
        }
        xd2 d2 = wi2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, zw2Var, yd2Var, iy1Var, gVar));
    }

    public final void t(cm2 cm2Var) {
        xd2 xd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, cm2Var) == null) && (xd2Var = this.a) != null) {
            yl2.a(xd2Var.a(), cm2Var);
        }
    }
}
