package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.um4;
import com.baidu.tieba.wm4;
import com.baidu.tieba.zm4;
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
/* loaded from: classes8.dex */
public class zk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ok4> l = gj4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ok4 ok4Var : l) {
                        if (ok4Var.b) {
                            j2 = ok4Var.c;
                        } else {
                            wk4 b = bp4.b(ok4Var.a, ok4Var.d, ok4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ok4Var.a);
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
                    sj4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", gj4.b().j(0));
            jSONObject.put("game_ext_vercode", gj4.b().j(1));
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
            jSONObject.put("swan_vercode", gj4.b().w(0));
            jSONObject.put("game_vercode", gj4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(um4 um4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, um4Var)) == null) {
            if (um4Var != null && um4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (um4.a aVar : um4Var.f()) {
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

    public static JSONObject e(wm4 wm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wm4Var)) == null) {
            if (wm4Var != null && wm4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (wm4.a aVar : wm4Var.f()) {
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
                        if (aVar instanceof zm4.b) {
                            zm4.b bVar = (zm4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<zm4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (zm4.a aVar2 : j) {
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

    public static HashMap<String, String> k(an4 an4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, an4Var)) == null) {
            if (an4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", an4Var.f());
            hashMap.put("category", String.valueOf(an4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(an4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(an4Var.j()));
            hashMap.put("sub_id", an4Var.k());
            if (!TextUtils.equals(an4Var.b(), "-1")) {
                hashMap.put("from", an4Var.b());
            }
            if (TextUtils.isEmpty(an4Var.i())) {
                an4Var.m(h(an4Var.a()));
            }
            if (!TextUtils.isEmpty(an4Var.i())) {
                hashMap.put("framework_ver", an4Var.i());
            }
            if (TextUtils.isEmpty(an4Var.h())) {
                an4Var.l(g(an4Var.a()));
            }
            if (!TextUtils.isEmpty(an4Var.h())) {
                hashMap.put("extension_ver", an4Var.h());
            }
            long w = gj4.b().w(an4Var.a());
            long j = gj4.b().j(an4Var.a());
            if (an4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (an4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(an4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(bn4 bn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bn4Var)) == null) {
            if (bn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(bn4Var.b(), "-1")) {
                hashMap.put("from", bn4Var.b());
            }
            if (!TextUtils.equals(bn4Var.c(), "-1")) {
                hashMap.put("scene", bn4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = gj4.b().v(i);
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
            String J = gj4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(xm4 xm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, xm4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (xm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", xm4Var.g());
            hashMap.put("category", String.valueOf(xm4Var.a()));
            if (xm4Var.m() == -1) {
                pMSAppInfo = sj4.i().u(xm4Var.g());
                if (pMSAppInfo != null && sj4.i().o(uk4.class, xm4Var.g()) != null) {
                    xm4Var.u(pMSAppInfo.versionCode);
                } else {
                    xm4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(xm4Var.m()));
            if (xm4Var.a() == 0 && xm4Var.m() != -1 && xm4Var.m() != 0) {
                hashMap.put("dep", a(xm4Var.g(), xm4Var.m(), false).toString());
            }
            if (xm4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = sj4.i().u(xm4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    xm4Var.o(pMSAppInfo.appSign);
                } else {
                    xm4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(xm4Var.f()));
            if (xm4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(xm4Var.i()));
            }
            String k = xm4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(xm4Var.a());
                xm4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = gj4.b().w(xm4Var.a());
            long j = gj4.b().j(xm4Var.a());
            if (xm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = xm4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(xm4Var.a());
                xm4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(xm4Var.l())) {
                hashMap.put("path", xm4Var.l());
            }
            if (!TextUtils.equals(xm4Var.b(), "-1")) {
                hashMap.put("from", xm4Var.b());
            }
            if (!TextUtils.equals(xm4Var.c(), "-1")) {
                hashMap.put("scene", xm4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(xm4Var.n()));
            hashMap.put("host_env", String.valueOf(gj4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(ym4 ym4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ym4Var)) == null) {
            if (ym4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ym4Var.f());
            hashMap.put("category", String.valueOf(ym4Var.a()));
            if (TextUtils.isEmpty(ym4Var.h())) {
                ym4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", ym4Var.h());
            if (ym4Var.g() >= 0) {
                hashMap.put("plugin_vercode", ym4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
