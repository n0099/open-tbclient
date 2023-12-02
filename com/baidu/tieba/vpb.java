package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.net.MailTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vpb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile vpb c;
    public transient /* synthetic */ FieldHolder $fh;
    public wpb a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Map<String, JSONObject> b;

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
                    return;
                }
            }
            this.a = 0;
            this.b = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249889, "Lcom/baidu/tieba/vpb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249889, "Lcom/baidu/tieba/vpb;");
                return;
            }
        }
        b = zpb.m();
    }

    public vpb() {
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

    public static vpb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (vpb.class) {
                    if (c == null) {
                        c = new vpb();
                    }
                }
            }
            return c;
        }
        return (vpb) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            epb o = epb.o();
            if (o != null && !o.g("2980", 32)) {
                return false;
            }
            if (o != null && o.d("2980")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            epb o = epb.o();
            if (o != null && !o.g("2980", 32)) {
                return false;
            }
            if (o != null && o.d("2980")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str) || !b()) {
            return;
        }
        this.a.c(str, z);
    }

    public boolean d(jqb jqbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jqbVar)) == null) {
            if (jqbVar == null || jqbVar.w() || !c()) {
                return false;
            }
            this.a.f();
            Map<String, a> v = this.a.v(7);
            if (v != null && v.size() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    boolean z = false;
                    for (String str : v.keySet()) {
                        a aVar = v.get(str);
                        if (aVar != null && !TextUtils.isEmpty(str)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            for (JSONObject jSONObject3 : aVar.b.values()) {
                                jSONArray.put(jSONObject3);
                            }
                            jSONObject2.put("total", aVar.a);
                            jSONObject2.put("data", jSONArray);
                            jSONObject.put(str.replace("-", ""), jSONObject2);
                            z = true;
                        }
                    }
                    if (z) {
                        lpb lpbVar = new lpb("2980");
                        lpbVar.y(jSONObject);
                        lpbVar.B(System.currentTimeMillis());
                        jqbVar.c(lpbVar, lpbVar.g());
                        jqbVar.a(v.keySet());
                        return true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(Map<String, a> map, String str, String str2, int i, int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{map, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || map == null) {
            return;
        }
        if (map.containsKey(str)) {
            aVar = map.get(str);
        } else {
            a aVar2 = new a();
            map.put(str, aVar2);
            aVar = aVar2;
        }
        Map<String, JSONObject> map2 = aVar.b;
        if (map2.containsKey(str2) && b) {
            Log.e("UBCArrivalStatics", "*******duplicate ubc id record: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str2);
            jSONObject.put("c", i);
            jSONObject.put(MailTo.CC, i2);
            aVar.a += i;
            map2.put(str2, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void g(wpb wpbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wpbVar) == null) {
            this.a = wpbVar;
        }
    }
}
