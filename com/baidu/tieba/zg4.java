package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ui4;
import com.baidu.tieba.wi4;
import com.baidu.tieba.zi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<og4> l = gf4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (og4 og4Var : l) {
                        if (og4Var.b) {
                            j2 = og4Var.c;
                        } else {
                            wg4 b = bl4.b(og4Var.a, og4Var.d, og4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", og4Var.a);
                            jSONObject.put("pkg_ver", j2);
                            if (z) {
                                jSONObject.put("category", 6);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException unused) {
                }
                if (!arrayList.isEmpty()) {
                    sf4.i().g(arrayList);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    @NonNull
    public static JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_ext_ver", g(0));
            jSONObject.put("game_ext_ver", g(1));
            jSONObject.put("swan_ext_vercode", gf4.b().j(0));
            jSONObject.put("game_ext_vercode", gf4.b().j(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static JSONObject c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_core_ver", h(0));
            jSONObject.put("swan_game_ver", h(1));
            jSONObject.put("swan_vercode", gf4.b().w(0));
            jSONObject.put("game_vercode", gf4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ui4 ui4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ui4Var)) == null) {
            if (ui4Var != null && ui4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ui4.a aVar : ui4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.a());
                        jSONObject2.put("category", aVar.b());
                        jSONObject2.put("pkg_ver", aVar.e());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("min_version", aVar.d());
                        jSONObject3.put("max_version", aVar.c());
                        jSONObject2.put("version_range", jSONObject3);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject e(wi4 wi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wi4Var)) == null) {
            if (wi4Var != null && wi4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (wi4.a aVar : wi4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.b());
                        if (aVar.c() != -1) {
                            jSONObject2.put("category", aVar.c());
                        }
                        jSONObject2.put("pkg_ver", aVar.d());
                        jSONObject2.put("app_sign", aVar.a());
                        if (aVar.c() == 0 && aVar.d() != -1 && aVar.d() != 0) {
                            jSONObject2.put("dep", a(aVar.b(), aVar.d(), true));
                        }
                        if (aVar instanceof zi4.b) {
                            zi4.b bVar = (zi4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<zi4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (zi4.a aVar2 : j) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.getType());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", j.get(0).b());
                            }
                            jSONObject2.put("sub_info", jSONObject3);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> k(aj4 aj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aj4Var)) == null) {
            if (aj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", aj4Var.f());
            hashMap.put("category", String.valueOf(aj4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(aj4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(aj4Var.j()));
            hashMap.put("sub_id", aj4Var.k());
            if (!TextUtils.equals(aj4Var.b(), "-1")) {
                hashMap.put("from", aj4Var.b());
            }
            if (TextUtils.isEmpty(aj4Var.i())) {
                aj4Var.m(h(aj4Var.a()));
            }
            if (!TextUtils.isEmpty(aj4Var.i())) {
                hashMap.put("framework_ver", aj4Var.i());
            }
            if (TextUtils.isEmpty(aj4Var.h())) {
                aj4Var.l(g(aj4Var.a()));
            }
            if (!TextUtils.isEmpty(aj4Var.h())) {
                hashMap.put("extension_ver", aj4Var.h());
            }
            long w = gf4.b().w(aj4Var.a());
            long j = gf4.b().j(aj4Var.a());
            if (aj4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (aj4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(aj4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(bj4 bj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bj4Var)) == null) {
            if (bj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(bj4Var.b(), "-1")) {
                hashMap.put("from", bj4Var.b());
            }
            if (!TextUtils.equals(bj4Var.c(), "-1")) {
                hashMap.put("scene", bj4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = gf4.b().v(i);
            if (TextUtils.isEmpty(v)) {
                return "0";
            }
            return v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = gf4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(xi4 xi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, xi4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (xi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", xi4Var.g());
            hashMap.put("category", String.valueOf(xi4Var.a()));
            if (xi4Var.m() == -1) {
                pMSAppInfo = sf4.i().u(xi4Var.g());
                if (pMSAppInfo != null && sf4.i().o(ug4.class, xi4Var.g()) != null) {
                    xi4Var.u(pMSAppInfo.versionCode);
                } else {
                    xi4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(xi4Var.m()));
            if (xi4Var.a() == 0 && xi4Var.m() != -1 && xi4Var.m() != 0) {
                hashMap.put("dep", a(xi4Var.g(), xi4Var.m(), false).toString());
            }
            if (xi4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = sf4.i().u(xi4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    xi4Var.o(pMSAppInfo.appSign);
                } else {
                    xi4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(xi4Var.f()));
            if (xi4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(xi4Var.i()));
            }
            String k = xi4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(xi4Var.a());
                xi4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = gf4.b().w(xi4Var.a());
            long j = gf4.b().j(xi4Var.a());
            if (xi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = xi4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(xi4Var.a());
                xi4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(xi4Var.l())) {
                hashMap.put("path", xi4Var.l());
            }
            if (!TextUtils.equals(xi4Var.b(), "-1")) {
                hashMap.put("from", xi4Var.b());
            }
            if (!TextUtils.equals(xi4Var.c(), "-1")) {
                hashMap.put("scene", xi4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(xi4Var.n()));
            hashMap.put("host_env", String.valueOf(gf4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, yi4Var)) == null) {
            if (yi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", yi4Var.f());
            hashMap.put("category", String.valueOf(yi4Var.a()));
            if (TextUtils.isEmpty(yi4Var.h())) {
                yi4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", yi4Var.h());
            if (yi4Var.g() >= 0) {
                hashMap.put("plugin_vercode", yi4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
