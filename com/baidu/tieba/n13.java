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
/* loaded from: classes7.dex */
public class n13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949561, "Lcom/baidu/tieba/n13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949561, "Lcom/baidu/tieba/n13;");
                return;
            }
        }
        a = am1.a;
    }

    public static void j() {
        y42 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (W = cr2.V().W()) != null && (W.m() instanceof z42)) {
            cr2.V().getActivity().onBackPressed();
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
            h13.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
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
            p53 M = p53.M();
            if (M != null) {
                str2 = M.V().e(str, null);
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
                return str2;
            }
            if (M != null) {
                swanAppConfigData = M.R();
            } else {
                swanAppConfigData = null;
            }
            if (i == 3) {
                w03.m(swanAppConfigData, false);
                str2 = i(str, null);
            } else if (i == 4) {
                str2 = l(swanAppConfigData);
            } else if (i == 6) {
                u03.a(swanAppConfigData);
                str2 = i(str, null);
            }
            map.put(str, str2);
            return str2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        p53 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !TextUtils.isEmpty(str) && (M = p53.M()) != null) {
            M.V().j(str, str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            p53 M = p53.M();
            if (M != null && !TextUtils.isEmpty(str)) {
                return M.V().e(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(List<l13> list) {
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
            qe4 g = g(str);
            if (g != null && !TextUtils.isEmpty(g.r)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return g.r;
            }
            h13.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static qe4 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData R;
        List<qe4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!g32.d() && !o13.H() && !o13.D()) {
                return g(str);
            }
            p53 M = p53.M();
            if (M != null && (R = M.R()) != null && (list = R.l) != null) {
                for (qe4 qe4Var : list) {
                    if (TextUtils.equals(str, qe4Var.g)) {
                        return qe4Var;
                    }
                }
            }
            return null;
        }
        return (qe4) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = b63.b(str);
            if (b == null) {
                h13.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                h13.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                h13.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static qe4 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return w03.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (qe4) invokeL.objValue;
    }

    public static List<qe4> k(String str, boolean z) {
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
                            qe4 qe4Var = new qe4();
                            qe4Var.g = optString;
                            qe4Var.i = optJSONObject.optLong("version_code", 0L);
                            qe4Var.j = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.kuaishou.weapon.p0.q1.e);
                            qe4Var.p = optJSONObject.optString("token");
                            qe4Var.q = optJSONObject.optString("domains");
                            qe4Var.h = 4;
                            qe4Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            qe4Var.s = optJSONObject.optString("app_name");
                            qe4Var.l = "";
                            qe4Var.m = "";
                            qe4Var.n = "";
                            arrayList.add(qe4Var);
                            if (z) {
                                md4.i().m(qe4Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                h13.b(Log.getStackTraceString(e));
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
                h13.b("parse app.json is null");
                return null;
            }
            List<l13> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (l13 l13Var : i) {
                    if (l13Var != null && l13Var.a()) {
                        pi3.f(jSONObject, l13Var.a, l13Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            h13.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
