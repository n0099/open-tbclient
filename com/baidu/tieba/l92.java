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
/* loaded from: classes6.dex */
public abstract class l92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile l92 b;
    public static bi3 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void h(String str);

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l92 a;

        public a(l92 l92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l92Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (l92.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends l92 {
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

        @Override // com.baidu.tieba.l92
        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (l92.a) {
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
                        bi3 bi3Var = l92.c;
                        if (bi3Var != null) {
                            ci3.d(bi3Var, str, f());
                            return;
                        }
                        return;
                    }
                    e();
                    n();
                    return;
                }
                bi3 bi3Var2 = l92.c;
                if (bi3Var2 != null) {
                    ci3.b(bi3Var2);
                }
                n();
                return;
            }
            p(true);
            ci3.d(l92.c, str, f());
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends l92 {
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

        @Override // com.baidu.tieba.l92
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && !m92.c()) {
                if (l92.a) {
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
                        bi3 bi3Var = l92.c;
                        if (bi3Var != null) {
                            ci3.d(bi3Var, str, f());
                            return;
                        }
                        return;
                    }
                    bi3 bi3Var2 = l92.c;
                    if (bi3Var2 != null) {
                        ci3.d(bi3Var2, str, f());
                        e();
                        n();
                        return;
                    }
                    return;
                }
                if (vb3.b0() != null && (w = vb3.b0().w()) != null && !w.isFinishing()) {
                    z = false;
                }
                p(z);
                if (z) {
                    bi3 bi3Var3 = l92.c;
                    ci3.d(bi3Var3, str + "-destroy", f());
                    boolean unused = l92.e = false;
                } else if (l92.e) {
                    bi3 bi3Var4 = l92.c;
                    ci3.d(bi3Var4, str + "-preload", f());
                    boolean unused2 = l92.e = false;
                } else {
                    ci3.d(l92.c, str, f());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897636, "Lcom/baidu/tieba/l92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897636, "Lcom/baidu/tieba/l92;");
                return;
            }
        }
        a = fs1.a;
    }

    public l92() {
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
            yi3 yi3Var = new yi3();
            yi3Var.a = "swan";
            yi3Var.b = "launch";
            yi3Var.c = "remote-debug";
            yi3Var.e = "appready";
            oi3.onEvent(yi3Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            yi3 yi3Var = new yi3();
            yi3Var.a = "swan";
            yi3Var.b = "launch";
            yi3Var.c = "remote-debug";
            yi3Var.e = "loadmaster";
            oi3.onEvent(yi3Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            yi3 yi3Var = new yi3();
            yi3Var.a = "swan";
            yi3Var.b = "launch";
            yi3Var.c = "remote-debug";
            yi3Var.e = "downloadstart";
            oi3.onEvent(yi3Var);
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

    public /* synthetic */ l92(a aVar) {
        this();
    }

    public static l92 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (ix2.class) {
                    if (b == null) {
                        if (el1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (l92) invokeV.objValue;
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

    public static void m(tw2 tw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, tw2Var) == null) {
            yi3 yi3Var = new yi3();
            yi3Var.j(tw2Var);
            yi3Var.a = oi3.n(tw2Var.G());
            yi3Var.b = "launch";
            yi3Var.c = "remote-debug";
            yi3Var.e = "downloadsuccess";
            oi3.onEvent(yi3Var);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || c != null) {
            return;
        }
        bi3 c2 = oi3.c("1153");
        c = c2;
        if (!z) {
            ci3.d(c2, "downloadstart", f());
            ci3.d(c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        d = timer;
        timer.schedule(new a(this), 40000L);
    }

    public static void j(tw2 tw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tw2Var) == null) {
            tw2Var.s0().putString("aiapp_extra_need_download", "1");
            tw2Var.s0().putString("aiapp_extra_pkg_downloading", "0");
            tw2Var.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            yi3 yi3Var = new yi3();
            yi3Var.a = oi3.n(tw2Var.G());
            yi3Var.j(tw2Var);
            yi3Var.b = "launch";
            yi3Var.o = "1";
            yi3Var.c = "remote-debug";
            JSONObject k = oi3.k(tw2Var.W());
            yi3Var.d(tw2Var.s0().getString("ubc"));
            yi3Var.b(k);
            oi3.onEvent(yi3Var);
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
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                O = "";
            } else {
                O = b0.O();
            }
            jSONObject2.putOpt("appid", O);
            jSONObject2.putOpt("from", "remote-debug");
            ni3.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        ci3.f(c, jSONObject.toString());
        ci3.c(c);
    }
}
