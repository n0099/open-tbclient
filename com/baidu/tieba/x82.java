package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class x82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile x82 b;
    public static nh3 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void h(String str);

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 a;

        public a(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x82Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (x82.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends x82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.x82
        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (x82.a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c = 2;
                }
            } else if (str.equals("downloadstart")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        nh3 nh3Var = x82.c;
                        if (nh3Var != null) {
                            oh3.d(nh3Var, str, f());
                            return;
                        }
                        return;
                    }
                    e();
                    n();
                    return;
                }
                nh3 nh3Var2 = x82.c;
                if (nh3Var2 != null) {
                    oh3.b(nh3Var2);
                }
                n();
                return;
            }
            p(true);
            oh3.d(x82.c, str, f());
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends x82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.x82
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && !y82.c()) {
                if (x82.a) {
                    Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
                }
                char c = 65535;
                int hashCode = str.hashCode();
                boolean z = true;
                if (hashCode != 511060680) {
                    if (hashCode == 900970612 && str.equals("pageready")) {
                        c = 1;
                    }
                } else if (str.equals("loadmaster")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        nh3 nh3Var = x82.c;
                        if (nh3Var != null) {
                            oh3.d(nh3Var, str, f());
                            return;
                        }
                        return;
                    }
                    nh3 nh3Var2 = x82.c;
                    if (nh3Var2 != null) {
                        oh3.d(nh3Var2, str, f());
                        e();
                        n();
                        return;
                    }
                    return;
                }
                if (hb3.b0() != null && (w = hb3.b0().w()) != null && !w.isFinishing()) {
                    z = false;
                }
                p(z);
                if (z) {
                    nh3 nh3Var3 = x82.c;
                    oh3.d(nh3Var3, str + "-destroy", f());
                    boolean unused = x82.e = false;
                } else if (x82.e) {
                    nh3 nh3Var4 = x82.c;
                    oh3.d(nh3Var4, str + "-preload", f());
                    boolean unused2 = x82.e = false;
                } else {
                    oh3.d(x82.c, str, f());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254167, "Lcom/baidu/tieba/x82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254167, "Lcom/baidu/tieba/x82;");
                return;
            }
        }
        a = rr1.a;
    }

    public x82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ki3 ki3Var = new ki3();
            ki3Var.a = "swan";
            ki3Var.b = "launch";
            ki3Var.c = "remote-debug";
            ki3Var.e = "appready";
            ai3.onEvent(ki3Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            ki3 ki3Var = new ki3();
            ki3Var.a = "swan";
            ki3Var.b = "launch";
            ki3Var.c = "remote-debug";
            ki3Var.e = "loadmaster";
            ai3.onEvent(ki3Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            ki3 ki3Var = new ki3();
            ki3Var.a = "swan";
            ki3Var.b = "launch";
            ki3Var.c = "remote-debug";
            ki3Var.e = "downloadstart";
            ai3.onEvent(ki3Var);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = d;
            if (timer != null) {
                timer.cancel();
                d = null;
            }
            b = null;
            c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e = true;
        }
    }

    public /* synthetic */ x82(a aVar) {
        this();
    }

    public static x82 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (uw2.class) {
                    if (b == null) {
                        if (qk1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (x82) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                if (a) {
                    Log.d("RemoteDebugStatistic", "add event content fail", e2);
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void i(JSONArray jSONArray) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && b != null) {
                b.h(str);
            }
        }
    }

    public static void m(fw2 fw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, fw2Var) == null) {
            ki3 ki3Var = new ki3();
            ki3Var.j(fw2Var);
            ki3Var.a = ai3.n(fw2Var.G());
            ki3Var.b = "launch";
            ki3Var.c = "remote-debug";
            ki3Var.e = "downloadsuccess";
            ai3.onEvent(ki3Var);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || c != null) {
            return;
        }
        nh3 c2 = ai3.c("1153");
        c = c2;
        if (!z) {
            oh3.d(c2, "downloadstart", f());
            oh3.d(c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        d = timer;
        timer.schedule(new a(this), 40000L);
    }

    public static void j(fw2 fw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, fw2Var) == null) {
            fw2Var.s0().putString("aiapp_extra_need_download", "1");
            fw2Var.s0().putString("aiapp_extra_pkg_downloading", "0");
            fw2Var.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            ki3 ki3Var = new ki3();
            ki3Var.a = ai3.n(fw2Var.G());
            ki3Var.j(fw2Var);
            ki3Var.b = "launch";
            ki3Var.o = "1";
            ki3Var.c = "remote-debug";
            JSONObject k = ai3.k(fw2Var.W());
            ki3Var.d(fw2Var.s0().getString("ubc"));
            ki3Var.b(k);
            ai3.onEvent(ki3Var);
        }
    }

    public void e() {
        String O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                O = "";
            } else {
                O = b0.O();
            }
            jSONObject2.putOpt("appid", O);
            jSONObject2.putOpt("from", "remote-debug");
            zh3.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        oh3.f(c, jSONObject.toString());
        oh3.c(c);
    }
}
