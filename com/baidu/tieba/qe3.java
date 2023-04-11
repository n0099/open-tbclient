package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qe3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static final List<a> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ue3 a;
        public JSONObject b;
        public final long c;
        public final String d;

        public a(@NonNull ue3 ue3Var, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
            this.d = str;
            this.c = ue3Var.l();
            synchronized (qe3.c) {
                if (qe3.b) {
                    qe3.c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948088906, "Lcom/baidu/tieba/qe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948088906, "Lcom/baidu/tieba/qe3;");
                return;
            }
        }
        a = eo1.a;
        b = false;
        c = new ArrayList();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (c) {
                b = true;
                c.clear();
            }
        }
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, hybridUbcFlow) != null) || !"670".equals(hybridUbcFlow.l())) {
            return;
        }
        hybridUbcFlow.D("networkStatus", String.valueOf(hz2.c()));
        if (s13.f || (g = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
            return;
        }
        long g2 = g.g();
        synchronized (c) {
            if (a) {
                Log.d("SwanReqStatisticManager", "size=" + c.size());
            }
            b = false;
            JSONArray jSONArray = new JSONArray();
            for (a aVar : c) {
                if (aVar.c <= g2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", aVar.d);
                        if (aVar.a != null) {
                            aVar.a.p(jSONObject);
                        }
                        if (aVar.b != null) {
                            Iterator<String> keys = aVar.b.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject.put(next, aVar.b.get(next));
                            }
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        if (a) {
                            Log.e("SwanReqStatisticManager", "appendRequestRecord", e);
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                hybridUbcFlow.D("requests", jSONArray.toString());
            }
        }
    }
}
