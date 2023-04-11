package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ti4;
import com.baidu.tieba.vi4;
import com.baidu.tieba.yi4;
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
public class yg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ng4> l = ff4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ng4 ng4Var : l) {
                        if (ng4Var.b) {
                            j2 = ng4Var.c;
                        } else {
                            vg4 b = al4.b(ng4Var.a, ng4Var.d, ng4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ng4Var.a);
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
                    rf4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ff4.b().j(0));
            jSONObject.put("game_ext_vercode", ff4.b().j(1));
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
            jSONObject.put("swan_vercode", ff4.b().w(0));
            jSONObject.put("game_vercode", ff4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ti4 ti4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ti4Var)) == null) {
            if (ti4Var != null && ti4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ti4.a aVar : ti4Var.f()) {
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

    public static JSONObject e(vi4 vi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vi4Var)) == null) {
            if (vi4Var != null && vi4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (vi4.a aVar : vi4Var.f()) {
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
                        if (aVar instanceof yi4.b) {
                            yi4.b bVar = (yi4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<yi4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (yi4.a aVar2 : j) {
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

    public static HashMap<String, String> k(zi4 zi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, zi4Var)) == null) {
            if (zi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", zi4Var.f());
            hashMap.put("category", String.valueOf(zi4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(zi4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(zi4Var.j()));
            hashMap.put("sub_id", zi4Var.k());
            if (!TextUtils.equals(zi4Var.b(), "-1")) {
                hashMap.put("from", zi4Var.b());
            }
            if (TextUtils.isEmpty(zi4Var.i())) {
                zi4Var.m(h(zi4Var.a()));
            }
            if (!TextUtils.isEmpty(zi4Var.i())) {
                hashMap.put("framework_ver", zi4Var.i());
            }
            if (TextUtils.isEmpty(zi4Var.h())) {
                zi4Var.l(g(zi4Var.a()));
            }
            if (!TextUtils.isEmpty(zi4Var.h())) {
                hashMap.put("extension_ver", zi4Var.h());
            }
            long w = ff4.b().w(zi4Var.a());
            long j = ff4.b().j(zi4Var.a());
            if (zi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (zi4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(zi4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(aj4 aj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aj4Var)) == null) {
            if (aj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(aj4Var.b(), "-1")) {
                hashMap.put("from", aj4Var.b());
            }
            if (!TextUtils.equals(aj4Var.c(), "-1")) {
                hashMap.put("scene", aj4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ff4.b().v(i);
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
            String J = ff4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(wi4 wi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, wi4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (wi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", wi4Var.g());
            hashMap.put("category", String.valueOf(wi4Var.a()));
            if (wi4Var.m() == -1) {
                pMSAppInfo = rf4.i().u(wi4Var.g());
                if (pMSAppInfo != null && rf4.i().o(tg4.class, wi4Var.g()) != null) {
                    wi4Var.u(pMSAppInfo.versionCode);
                } else {
                    wi4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(wi4Var.m()));
            if (wi4Var.a() == 0 && wi4Var.m() != -1 && wi4Var.m() != 0) {
                hashMap.put("dep", a(wi4Var.g(), wi4Var.m(), false).toString());
            }
            if (wi4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = rf4.i().u(wi4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    wi4Var.o(pMSAppInfo.appSign);
                } else {
                    wi4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(wi4Var.f()));
            if (wi4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(wi4Var.i()));
            }
            String k = wi4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(wi4Var.a());
                wi4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ff4.b().w(wi4Var.a());
            long j = ff4.b().j(wi4Var.a());
            if (wi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = wi4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(wi4Var.a());
                wi4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(wi4Var.l())) {
                hashMap.put("path", wi4Var.l());
            }
            if (!TextUtils.equals(wi4Var.b(), "-1")) {
                hashMap.put("from", wi4Var.b());
            }
            if (!TextUtils.equals(wi4Var.c(), "-1")) {
                hashMap.put("scene", wi4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(wi4Var.n()));
            hashMap.put("host_env", String.valueOf(ff4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(xi4 xi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, xi4Var)) == null) {
            if (xi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", xi4Var.f());
            hashMap.put("category", String.valueOf(xi4Var.a()));
            if (TextUtils.isEmpty(xi4Var.h())) {
                xi4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", xi4Var.h());
            if (xi4Var.g() >= 0) {
                hashMap.put("plugin_vercode", xi4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
