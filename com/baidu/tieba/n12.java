package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public abstract class n12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile n12 b;
    public static ka3 c;
    public static Timer d;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void f(String str);

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n12 a;

        public a(n12 n12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n12Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (n12.a) {
                    Log.d("LocalDebugStatistic", "timer: send local debug ubc flow");
                }
                this.a.c();
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends n12 {
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

        @Override // com.baidu.tieba.n12
        public void f(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (n12.a) {
                Log.d("LocalDebugStatistic", "local-debug statistic event name is : " + str);
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
                        if (n12.c != null) {
                            la3.d(n12.c, str, d());
                            return;
                        }
                        return;
                    }
                    if (n12.c != null) {
                        la3.d(n12.c, "downloadfail", d());
                    }
                    c();
                    h();
                    return;
                }
                if (n12.c != null) {
                    la3.d(n12.c, "downloadsuccess", d());
                }
                c();
                h();
                return;
            }
            i();
            la3.d(n12.c, str, d());
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends n12 {
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

        @Override // com.baidu.tieba.n12
        public void f(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && !p12.k().m()) {
                if (n12.a) {
                    Log.d("LocalDebugStatistic", "local-debug statistic event name is : " + str);
                }
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 900970612) {
                    if (hashCode == 1415552890 && str.equals("unzipstart")) {
                        c = 0;
                    }
                } else if (str.equals("pageready")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (n12.c != null) {
                            la3.d(n12.c, str, d());
                            return;
                        }
                        return;
                    } else if (n12.c != null) {
                        la3.d(n12.c, str, d());
                        c();
                        h();
                        return;
                    } else {
                        return;
                    }
                }
                i();
                la3.d(n12.c, str, d());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949530, "Lcom/baidu/tieba/n12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949530, "Lcom/baidu/tieba/n12;");
                return;
            }
        }
        a = ok1.a;
    }

    public n12() {
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

    public void h() {
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

    public /* synthetic */ n12(a aVar) {
        this();
    }

    public static n12 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (b == null) {
                synchronized (rp2.class) {
                    if (b == null) {
                        if (nf1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (n12) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException e) {
                if (a) {
                    Log.d("LocalDebugStatistic", "add event content fail", e);
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || c != null) {
            return;
        }
        c = xa3.c("1153");
        a aVar = new a(this);
        Timer timer = new Timer();
        d = timer;
        try {
            timer.schedule(aVar, 40000L);
        } catch (Exception e) {
            if (a) {
                e.printStackTrace();
            }
        }
    }

    public static void g(JSONArray jSONArray) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && b != null) {
                b.f(str);
            }
        }
    }

    public void c() {
        String appId;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            e43 b0 = e43.b0();
            if (b0 == null) {
                appId = "";
            } else {
                appId = b0.getAppId();
            }
            jSONObject2.putOpt("appid", appId);
            jSONObject2.putOpt("from", "local-debug");
            wa3.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("LocalDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        la3.f(c, jSONObject.toString());
        la3.c(c);
    }
}
