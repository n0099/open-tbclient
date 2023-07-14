package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class li1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static List<ii1> i;
    public static Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                li1.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ch1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh1 a;
        public final /* synthetic */ dh1 b;

        @Override // com.baidu.tieba.ch1
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }

        public b(eh1 eh1Var, dh1 dh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh1Var, dh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eh1Var;
            this.b = dh1Var;
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                li1.l(this.a.b(), this.b.b());
                ki1.g().h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends ch1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ JSONArray b;

        public c(JSONObject jSONObject, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = jSONArray;
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.put(this.a);
                ui1.g("localObject" + this.a);
            }
        }

        @Override // com.baidu.tieba.ch1
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                ui1.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943733, "Lcom/baidu/tieba/li1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943733, "Lcom/baidu/tieba/li1;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<ii1> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && (list = i) != null) {
            list.clear();
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            mi1.a(new a());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a = null;
            b = null;
            e = null;
            f = null;
            g = null;
            h = null;
        }
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (li1.class) {
                List<ii1> list = i;
                if (list != null && !list.isEmpty()) {
                    dh1 g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (ii1 ii1Var : i) {
                            JSONObject d2 = ii1Var.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", jh1.a()));
                        c();
                    }
                    eh1 h2 = h();
                    if (wi1.d()) {
                        n();
                        new ji1().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        ki1.g().h();
                    }
                }
            }
        }
    }

    public static dh1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            dh1 dh1Var = new dh1();
            dh1Var.d(com.kuaishou.weapon.p0.u.A, "cashier");
            dh1Var.d("os", "android");
            dh1Var.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(g)) {
                dh1Var.d("n", g);
            }
            String b2 = lh1.b();
            if (!TextUtils.isEmpty(b2)) {
                dh1Var.d("nv", b2);
            }
            if (!TextUtils.isEmpty(h)) {
                dh1Var.d("ss", h);
            }
            if (!TextUtils.isEmpty(b)) {
                dh1Var.d("d", b);
            }
            if (!TextUtils.isEmpty(e)) {
                dh1Var.d("dt", e);
            }
            if (!TextUtils.isEmpty(f)) {
                dh1Var.d(com.kuaishou.weapon.p0.u.v, f);
            }
            if (!TextUtils.isEmpty(c)) {
                dh1Var.d("ak", c);
            }
            if (!TextUtils.isEmpty(d)) {
                dh1Var.d(Config.DEVICE_ID_SEC, d);
            }
            return dh1Var;
        }
        return (dh1) invokeV.objValue;
    }

    public static void e(ii1 ii1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ii1Var) == null) {
            if (i == null) {
                i = new ArrayList();
            }
            if (ii1Var != null) {
                synchronized (j) {
                    i.add(ii1Var);
                }
            }
        }
    }

    public static eh1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            eh1 eh1Var = new eh1();
            if (!TextUtils.isEmpty(a)) {
                eh1Var.d("Cookie", "BDUSS=" + a);
            }
            return eh1Var;
        }
        return (eh1) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(yi1.a().getFilesDir(), "poly_cashier_statistics.json");
            if (!file.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(si1.b(file));
                try {
                    file.delete();
                } catch (Exception unused) {
                }
                return jSONArray;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void j(int i2, String str, String str2) {
        ii1 ii1Var;
        ii1 ii1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        ii1Var = null;
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exceptionType", str2);
                            jSONObject.put("msg", str);
                        } catch (JSONException unused) {
                        }
                        ii1Var2 = new ii1("3");
                        ii1Var2.c(jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("selects", gi1.a);
                        gi1.a = 0;
                        jSONObject2.put("hbit", gi1.b);
                        gi1.b = "0";
                    } catch (JSONException unused2) {
                    }
                    ii1Var2 = new ii1("4");
                    ii1Var2.c(jSONObject2);
                }
                ii1Var = ii1Var2;
            } else {
                ii1Var = new ii1("2");
            }
            if (ii1Var != null) {
                e(ii1Var);
            }
        }
    }

    public static void l(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, map, map2) == null) {
            try {
                JSONArray i2 = i();
                if (i2 != null) {
                    if (i2.length() >= 20) {
                        i2.remove(0);
                    }
                } else {
                    i2 = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b2 = vi1.b(map);
                JSONObject b3 = vi1.b(map2);
                jSONObject.put("header", b2);
                jSONObject.put("body", b3);
                i2.put(jSONObject);
                m(i2);
            } catch (Exception unused) {
            }
        }
    }

    public static void m(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            ui1.g("localArray" + jSONArray.length() + jSONArray.toString());
            si1.d(jSONArray.toString(), new File(yi1.a().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            JSONArray i2 = i();
            if (i2 == null || i2.length() == 0) {
                return true;
            }
            try {
                jSONArray = new JSONArray();
                for (int i3 = 0; i3 < i2.length(); i3++) {
                    JSONObject jSONObject = i2.getJSONObject(i3);
                    eh1 eh1Var = new eh1();
                    eh1Var.e(vi1.d(jSONObject.optJSONObject("header")));
                    dh1 dh1Var = new dh1();
                    dh1Var.e(vi1.d(jSONObject.optJSONObject("body")));
                    new ji1().a(eh1Var, dh1Var, new c(jSONObject, jSONArray));
                }
            } catch (Exception unused) {
            }
            if (jSONArray.length() == 0) {
                return true;
            }
            m(jSONArray);
            return false;
        }
        return invokeV.booleanValue;
    }
}
