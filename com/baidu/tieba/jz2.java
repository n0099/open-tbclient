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
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900519, "Lcom/baidu/tieba/jz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900519, "Lcom/baidu/tieba/jz2;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, map, str) == null) || map == null) {
            return;
        }
        String b = b(map, "dynamicLibPath", 3);
        String b2 = b(map, "dynamicLibConfig", 3);
        String b3 = b(map, "pluginPath", 4);
        String b4 = b(map, "dependenciesPath", 6);
        String b5 = b(map, "dependenciesConfig", 6);
        if (TextUtils.isEmpty(str) || !a) {
            return;
        }
        dz2.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
    }

    public static String b(Map<String, String> map, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            l33 M = l33.M();
            String e = M != null ? M.U().e(str, null) : null;
            if (!TextUtils.isEmpty(e)) {
                map.put(str, e);
                return e;
            }
            SwanAppConfigData Q = M != null ? M.Q() : null;
            if (i == 3) {
                sy2.m(Q, false);
                e = i(str, null);
            } else if (i == 4) {
                e = l(Q);
            } else if (i == 6) {
                qy2.a(Q);
                e = i(str, null);
            }
            map.put(str, e);
            return e;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        l33 M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (M = l33.M()) == null) {
            return;
        }
        M.U().j(str, str2);
    }

    public static String d(List<hz2> list) {
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

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = x33.b(str);
            if (b == null) {
                dz2.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                dz2.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                dz2.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            mc4 g = g(str);
            if ((g == null || TextUtils.isEmpty(g.r)) ? false : true) {
                return g.r;
            }
            dz2.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static mc4 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return sy2.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (mc4) invokeL.objValue;
    }

    public static mc4 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        List<mc4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!c12.d() && !kz2.H() && !kz2.D()) {
                return g(str);
            }
            l33 M = l33.M();
            if (M != null && (Q = M.Q()) != null && (list = Q.l) != null) {
                for (mc4 mc4Var : list) {
                    if (TextUtils.equals(str, mc4Var.g)) {
                        return mc4Var;
                    }
                }
            }
            return null;
        }
        return (mc4) invokeL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            l33 M = l33.M();
            if (M == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return M.U().e(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void j() {
        u22 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (V = yo2.U().V()) != null && (V.m() instanceof v22)) {
            yo2.U().getActivity().onBackPressed();
        }
    }

    public static List<mc4> k(String str, boolean z) {
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
                            mc4 mc4Var = new mc4();
                            mc4Var.g = optString;
                            mc4Var.i = optJSONObject.optLong("version_code", 0L);
                            mc4Var.j = optJSONObject.optString("version_name", com.kuaishou.weapon.p0.q1.e);
                            mc4Var.p = optJSONObject.optString("token");
                            mc4Var.q = optJSONObject.optString("domains");
                            mc4Var.h = 4;
                            mc4Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            mc4Var.s = optJSONObject.optString("app_name");
                            mc4Var.l = "";
                            mc4Var.m = "";
                            mc4Var.n = "";
                            arrayList.add(mc4Var);
                            if (z) {
                                ib4.i().m(mc4Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                dz2.b(Log.getStackTraceString(e));
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
                dz2.b("parse app.json is null");
                return null;
            }
            List<hz2> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (hz2 hz2Var : i) {
                    if (hz2Var != null && hz2Var.a()) {
                        lg3.f(jSONObject, hz2Var.a, hz2Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            dz2.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
