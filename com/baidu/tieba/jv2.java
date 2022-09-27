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
/* loaded from: classes4.dex */
public class jv2 extends kv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, l83>> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements iv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;

        /* renamed from: com.baidu.tieba.jv2$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0311a implements iv2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0311a(a aVar) {
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

            @Override // com.baidu.tieba.iv2
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (jv2.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.a(jv2.g(true));
                }
            }
        }

        public a(ei3 ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ei3Var;
        }

        @Override // com.baidu.tieba.iv2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, l83> g = jv2.g(true);
                if (g.size() > 0) {
                    this.a.a(g);
                    if (jv2.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                l02.k("SwanAppUpdateManager", "has not scope set，required request from server");
                hv2.g().update(new C0311a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements iv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ei3 b;
        public final /* synthetic */ String c;

        public b(String str, ei3 ei3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, ei3Var, str2};
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
            this.b = ei3Var;
            this.c = str2;
        }

        @Override // com.baidu.tieba.iv2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ov2.f().d(this.a);
                this.b.a(jv2.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896675, "Lcom/baidu/tieba/jv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896675, "Lcom/baidu/tieba/jv2;");
                return;
            }
        }
        a = vj1.a;
        b = new LruCache<>(6);
    }

    public jv2() {
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

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            l02.k("SwanAppUpdateManager", "cleanAccreditListData");
            l33 M = l33.M();
            if (M == null) {
                l02.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            l02.k("SwanAppUpdateManager", "prefName: " + M.e0().p() + ", cleanAccredit");
            hv2.g().w(new jv2());
            M.e0().B("node_data_accredit_list", "");
            o();
            hv2.g().update();
        }
    }

    @NonNull
    public static Map<String, l83> g(boolean z) {
        InterceptResult invokeZ;
        ArrayMap<String, l83> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (!z || (l = l()) == null) {
                long nanoTime = a ? System.nanoTime() : 0L;
                ArrayMap arrayMap = new ArrayMap();
                l33 M = l33.M();
                if (M == null) {
                    l02.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                    return arrayMap;
                }
                String appId = M.getAppId();
                String q = M.e0().q("node_data_accredit_list", "");
                String q2 = M.e0().q("cur_request_id", "");
                l02.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + M.e0().p() + " requestId=" + q2 + " accreditList=" + q);
                if (TextUtils.isEmpty(q)) {
                    return arrayMap;
                }
                try {
                    ArrayMap<String, l83> m = m(new JSONObject(q), appId);
                    if (a) {
                        long nanoTime2 = System.nanoTime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("#getAccreditListData cost=");
                        sb.append((nanoTime2 - nanoTime) / 1000000.0d);
                        sb.append(" size=");
                        LruCache<String, ArrayMap<String, l83>> lruCache = b;
                        sb.append(lruCache == null ? 0 : lruCache.size());
                        Log.d("SwanAppUpdateManager", sb.toString());
                    }
                    l02.k("SwanAppUpdateManager", "getAccreditListData - from json");
                    return m;
                } catch (JSONException e) {
                    l02.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                    return arrayMap;
                }
            }
            return l;
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull ei3<Map<String, l83>> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ei3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            hv2.g().z(new a(ei3Var));
        }
    }

    public static void i(String str, @NonNull ei3<l83> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, ei3Var) == null) {
            j(str, ei3Var, ov2.f().b(str));
        }
    }

    public static void j(String str, @NonNull ei3<l83> ei3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, ei3Var, str2) == null) {
            l83 l83Var = g(true).get(str);
            if (l83Var != null) {
                ov2.f().d(str2);
                ei3Var.a(l83Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            l02.k("SwanAppUpdateManager", "has not scope node，required request from server");
            hv2.g().update(new b(str2, ei3Var, str));
        }
    }

    @Nullable
    public static l83 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? g(true).get(str) : (l83) invokeL.objValue;
    }

    public static ArrayMap<String, l83> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            l33 b0 = l33.b0();
            if (b0 == null || TextUtils.isEmpty(b0.b)) {
                return null;
            }
            return b.get(b0.b);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, l83> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, l83> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                l02.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, l83.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, l83> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, arrayMap, str) == null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        l02.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + k33.K().getAppId());
        b.put(str, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            l02.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.baidu.tieba.kv2
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kv2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l02.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.baidu.tieba.kv2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l02.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // com.baidu.tieba.kv2
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            l02.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                l02.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            l33 M = l33.M();
            if (M == null) {
                l02.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            l02.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + M.e0().p() + ", putAccredit = " + jSONObject2);
            M.e0().B("node_data_accredit_list", jSONObject2);
            u73 e0 = M.e0();
            e0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
