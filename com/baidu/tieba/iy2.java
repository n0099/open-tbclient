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
/* loaded from: classes6.dex */
public class iy2 extends jy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, kb3>> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jy2
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static class a implements hy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;

        /* renamed from: com.baidu.tieba.iy2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0359a implements hy2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0359a(a aVar) {
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

            @Override // com.baidu.tieba.hy2
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (iy2.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.a(iy2.g(true));
                }
            }
        }

        public a(dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl3Var;
        }

        @Override // com.baidu.tieba.hy2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, kb3> g = iy2.g(true);
                if (g.size() > 0) {
                    this.a.a(g);
                    if (iy2.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                k32.k("SwanAppUpdateManager", "has not scope set，required request from server");
                gy2.g().B(new C0359a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements hy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dl3 b;
        public final /* synthetic */ String c;

        public b(String str, dl3 dl3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dl3Var, str2};
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
            this.b = dl3Var;
            this.c = str2;
        }

        @Override // com.baidu.tieba.hy2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ny2.f().d(this.a);
                this.b.a(iy2.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947869767, "Lcom/baidu/tieba/iy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947869767, "Lcom/baidu/tieba/iy2;");
                return;
            }
        }
        a = vm1.a;
        b = new LruCache<>(6);
    }

    public iy2() {
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

    public static ArrayMap<String, kb3> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 != null && !TextUtils.isEmpty(c0.b)) {
                return b.get(c0.b);
            }
            return null;
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            k32.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.baidu.tieba.jy2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k32.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.baidu.tieba.jy2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k32.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            k32.k("SwanAppUpdateManager", "cleanAccreditListData");
            k63 M = k63.M();
            if (M == null) {
                k32.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            k32.k("SwanAppUpdateManager", "prefName: " + M.f0().p() + ", cleanAccredit");
            gy2.g().w(new iy2());
            M.f0().B("node_data_accredit_list", "");
            o();
            gy2.g().A();
        }
    }

    @NonNull
    public static Map<String, kb3> g(boolean z) {
        InterceptResult invokeZ;
        long j;
        int size;
        ArrayMap<String, kb3> l;
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
            k63 M = k63.M();
            if (M == null) {
                k32.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                return arrayMap;
            }
            String appId = M.getAppId();
            String q = M.f0().q("node_data_accredit_list", "");
            String q2 = M.f0().q("cur_request_id", "");
            k32.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + M.f0().p() + " requestId=" + q2 + " accreditList=" + q);
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                ArrayMap<String, kb3> m = m(new JSONObject(q), appId);
                if (a) {
                    long nanoTime = System.nanoTime();
                    StringBuilder sb = new StringBuilder();
                    sb.append("#getAccreditListData cost=");
                    sb.append((nanoTime - j) / 1000000.0d);
                    sb.append(" size=");
                    LruCache<String, ArrayMap<String, kb3>> lruCache = b;
                    if (lruCache == null) {
                        size = 0;
                    } else {
                        size = lruCache.size();
                    }
                    sb.append(size);
                    Log.d("SwanAppUpdateManager", sb.toString());
                }
                k32.k("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e) {
                k32.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull dl3<Map<String, kb3>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, dl3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            gy2.g().z(new a(dl3Var));
        }
    }

    @Nullable
    public static kb3 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return g(true).get(str);
        }
        return (kb3) invokeL.objValue;
    }

    public static void i(String str, @NonNull dl3<kb3> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, dl3Var) == null) {
            j(str, dl3Var, ny2.f().b(str));
        }
    }

    public static void j(String str, @NonNull dl3<kb3> dl3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, dl3Var, str2) == null) {
            kb3 kb3Var = g(true).get(str);
            if (kb3Var != null) {
                ny2.f().d(str2);
                dl3Var.a(kb3Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            k32.k("SwanAppUpdateManager", "has not scope node，required request from server");
            gy2.g().B(new b(str2, dl3Var, str));
        }
    }

    public static ArrayMap<String, kb3> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, kb3> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                k32.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, kb3.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, kb3> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, arrayMap, str) != null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        k32.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + j63.K().getAppId());
        b.put(str, arrayMap);
    }

    @Override // com.baidu.tieba.jy2
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            k32.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                k32.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            k63 M = k63.M();
            if (M == null) {
                k32.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            k32.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + M.f0().p() + ", putAccredit = " + jSONObject2);
            M.f0().B("node_data_accredit_list", jSONObject2);
            ta3 f0 = M.f0();
            f0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
