package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223446, "Lcom/baidu/tieba/w73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223446, "Lcom/baidu/tieba/w73;");
                return;
            }
        }
        a = is1.a;
    }

    public static void j() {
        hb2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (U = lx2.T().U()) != null && (U.m() instanceof ib2)) {
            lx2.T().getActivity().onBackPressed();
        }
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, map, str) != null) || map == null) {
            return;
        }
        String b = b(map, "dynamicLibPath", 3);
        String b2 = b(map, "dynamicLibConfig", 3);
        String b3 = b(map, "pluginPath", 4);
        String b4 = b(map, "dependenciesPath", 6);
        String b5 = b(map, "dependenciesConfig", 6);
        if (!TextUtils.isEmpty(str) && a) {
            q73.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
        }
    }

    public static String b(Map<String, String> map, String str, int i) {
        InterceptResult invokeLLI;
        String str2;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            yb3 M = yb3.M();
            if (M != null) {
                str2 = M.U().e(str, null);
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
                return str2;
            }
            if (M != null) {
                swanAppConfigData = M.Q();
            } else {
                swanAppConfigData = null;
            }
            if (i == 3) {
                f73.m(swanAppConfigData, false);
                str2 = i(str, null);
            } else if (i == 4) {
                str2 = l(swanAppConfigData);
            } else if (i == 6) {
                d73.a(swanAppConfigData);
                str2 = i(str, null);
            }
            map.put(str, str2);
            return str2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        yb3 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !TextUtils.isEmpty(str) && (M = yb3.M()) != null) {
            M.U().j(str, str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            yb3 M = yb3.M();
            if (M != null && !TextUtils.isEmpty(str)) {
                return M.U().e(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(List<u73> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (SELECT * from ");
            sb.append("swan_plugin");
            sb.append(" ORDER BY update_time) group by bundle_id having bundle_id in ");
            sb.append("(");
            for (int i = 0; i < size; i++) {
                sb.append("'");
                sb.append(list.get(i).a);
                sb.append("'");
                if (i == size - 1) {
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    sb.append(",");
                }
            }
            sb.append(ParamableElem.DIVIDE_PARAM);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            zk4 g = g(str);
            if (g != null && !TextUtils.isEmpty(g.r)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return g.r;
            }
            q73.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static zk4 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        List<zk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!p92.d() && !x73.H() && !x73.D()) {
                return g(str);
            }
            yb3 M = yb3.M();
            if (M != null && (Q = M.Q()) != null && (list = Q.l) != null) {
                for (zk4 zk4Var : list) {
                    if (TextUtils.equals(str, zk4Var.g)) {
                        return zk4Var;
                    }
                }
            }
            return null;
        }
        return (zk4) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = kc3.b(str);
            if (b == null) {
                q73.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                q73.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                q73.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static zk4 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f73.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (zk4) invokeL.objValue;
    }

    public static List<zk4> k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                if (length == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("plugin_id");
                        if (!TextUtils.isEmpty(optString)) {
                            zk4 zk4Var = new zk4();
                            zk4Var.g = optString;
                            zk4Var.i = optJSONObject.optLong("version_code", 0L);
                            zk4Var.j = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.kuaishou.weapon.p0.q1.e);
                            zk4Var.p = optJSONObject.optString("token");
                            zk4Var.q = optJSONObject.optString("domains");
                            zk4Var.h = 4;
                            zk4Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            zk4Var.s = optJSONObject.optString("app_name");
                            zk4Var.l = "";
                            zk4Var.m = "";
                            zk4Var.n = "";
                            arrayList.add(zk4Var);
                            if (z) {
                                vj4.i().m(zk4Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                q73.b(Log.getStackTraceString(e));
                return null;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                q73.b("parse app.json is null");
                return null;
            }
            List<u73> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (u73 u73Var : i) {
                    if (u73Var != null && u73Var.a()) {
                        yo3.f(jSONObject, u73Var.a, u73Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            q73.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
