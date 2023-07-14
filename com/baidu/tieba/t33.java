package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t33 extends u33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, vg3>> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u33
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class a implements s33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;

        /* renamed from: com.baidu.tieba.t33$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0483a implements s33 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0483a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.s33
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (t33.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.a(t33.g(true));
                }
            }
        }

        public a(oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq3Var;
        }

        @Override // com.baidu.tieba.s33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, vg3> g = t33.g(true);
                if (g.size() > 0) {
                    this.a.a(g);
                    if (t33.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                v82.k("SwanAppUpdateManager", "has not scope set，required request from server");
                r33.g().update(new C0483a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements s33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ oq3 b;
        public final /* synthetic */ String c;

        public b(String str, oq3 oq3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, oq3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = oq3Var;
            this.c = str2;
        }

        @Override // com.baidu.tieba.s33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y33.f().d(this.a);
                this.b.a(t33.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948130229, "Lcom/baidu/tieba/t33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948130229, "Lcom/baidu/tieba/t33;");
                return;
            }
        }
        a = fs1.a;
        b = new LruCache<>(6);
    }

    public t33() {
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

    public static ArrayMap<String, vg3> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 != null && !TextUtils.isEmpty(b0.b)) {
                return b.get(b0.b);
            }
            return null;
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            v82.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.baidu.tieba.u33
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v82.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.baidu.tieba.u33
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v82.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            v82.k("SwanAppUpdateManager", "cleanAccreditListData");
            vb3 M = vb3.M();
            if (M == null) {
                v82.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            v82.k("SwanAppUpdateManager", "prefName: " + M.e0().p() + ", cleanAccredit");
            r33.g().w(new t33());
            M.e0().B("node_data_accredit_list", "");
            o();
            r33.g().update();
        }
    }

    @NonNull
    public static Map<String, vg3> g(boolean z) {
        InterceptResult invokeZ;
        long j;
        int size;
        ArrayMap<String, vg3> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (z && (l = l()) != null) {
                return l;
            }
            if (a) {
                j = System.nanoTime();
            } else {
                j = 0;
            }
            ArrayMap arrayMap = new ArrayMap();
            vb3 M = vb3.M();
            if (M == null) {
                v82.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                return arrayMap;
            }
            String appId = M.getAppId();
            String q = M.e0().q("node_data_accredit_list", "");
            String q2 = M.e0().q("cur_request_id", "");
            v82.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + M.e0().p() + " requestId=" + q2 + " accreditList=" + q);
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                ArrayMap<String, vg3> m = m(new JSONObject(q), appId);
                if (a) {
                    long nanoTime = System.nanoTime();
                    StringBuilder sb = new StringBuilder();
                    sb.append("#getAccreditListData cost=");
                    sb.append((nanoTime - j) / 1000000.0d);
                    sb.append(" size=");
                    LruCache<String, ArrayMap<String, vg3>> lruCache = b;
                    if (lruCache == null) {
                        size = 0;
                    } else {
                        size = lruCache.size();
                    }
                    sb.append(size);
                    Log.d("SwanAppUpdateManager", sb.toString());
                }
                v82.k("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e) {
                v82.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull oq3<Map<String, vg3>> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, oq3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            r33.g().z(new a(oq3Var));
        }
    }

    @Nullable
    public static vg3 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return g(true).get(str);
        }
        return (vg3) invokeL.objValue;
    }

    public static void i(String str, @NonNull oq3<vg3> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, oq3Var) == null) {
            j(str, oq3Var, y33.f().b(str));
        }
    }

    public static void j(String str, @NonNull oq3<vg3> oq3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, oq3Var, str2) == null) {
            vg3 vg3Var = g(true).get(str);
            if (vg3Var != null) {
                y33.f().d(str2);
                oq3Var.a(vg3Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            v82.k("SwanAppUpdateManager", "has not scope node，required request from server");
            r33.g().update(new b(str2, oq3Var, str));
        }
    }

    public static ArrayMap<String, vg3> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, vg3> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                v82.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, vg3.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, vg3> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, arrayMap, str) != null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        v82.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + ub3.K().getAppId());
        b.put(str, arrayMap);
    }

    @Override // com.baidu.tieba.u33
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            v82.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                v82.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            vb3 M = vb3.M();
            if (M == null) {
                v82.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            v82.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + M.e0().p() + ", putAccredit = " + jSONObject2);
            M.e0().B("node_data_accredit_list", jSONObject2);
            eg3 e0 = M.e0();
            e0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
