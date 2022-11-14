package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ef4;
import com.baidu.tieba.gf4;
import com.baidu.tieba.jf4;
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
/* loaded from: classes4.dex */
public class jd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<yc4> l = qb4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (yc4 yc4Var : l) {
                        if (yc4Var.b) {
                            j2 = yc4Var.c;
                        } else {
                            gd4 b = lh4.b(yc4Var.a, yc4Var.d, yc4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", yc4Var.a);
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
                    cc4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", qb4.b().j(0));
            jSONObject.put("game_ext_vercode", qb4.b().j(1));
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
            jSONObject.put("swan_vercode", qb4.b().w(0));
            jSONObject.put("game_vercode", qb4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ef4 ef4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ef4Var)) == null) {
            if (ef4Var != null && ef4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ef4.a aVar : ef4Var.f()) {
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

    public static JSONObject e(gf4 gf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gf4Var)) == null) {
            if (gf4Var != null && gf4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (gf4.a aVar : gf4Var.f()) {
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
                        if (aVar instanceof jf4.b) {
                            jf4.b bVar = (jf4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<jf4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (jf4.a aVar2 : j) {
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

    public static HashMap<String, String> k(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, kf4Var)) == null) {
            if (kf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", kf4Var.f());
            hashMap.put("category", String.valueOf(kf4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(kf4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(kf4Var.j()));
            hashMap.put("sub_id", kf4Var.k());
            if (!TextUtils.equals(kf4Var.b(), "-1")) {
                hashMap.put("from", kf4Var.b());
            }
            if (TextUtils.isEmpty(kf4Var.i())) {
                kf4Var.m(h(kf4Var.a()));
            }
            if (!TextUtils.isEmpty(kf4Var.i())) {
                hashMap.put("framework_ver", kf4Var.i());
            }
            if (TextUtils.isEmpty(kf4Var.h())) {
                kf4Var.l(g(kf4Var.a()));
            }
            if (!TextUtils.isEmpty(kf4Var.h())) {
                hashMap.put("extension_ver", kf4Var.h());
            }
            long w = qb4.b().w(kf4Var.a());
            long j = qb4.b().j(kf4Var.a());
            if (kf4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (kf4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(kf4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(lf4 lf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, lf4Var)) == null) {
            if (lf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(lf4Var.b(), "-1")) {
                hashMap.put("from", lf4Var.b());
            }
            if (!TextUtils.equals(lf4Var.c(), "-1")) {
                hashMap.put("scene", lf4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = qb4.b().v(i);
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
            String J = qb4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(hf4 hf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, hf4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (hf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", hf4Var.g());
            hashMap.put("category", String.valueOf(hf4Var.a()));
            if (hf4Var.m() == -1) {
                pMSAppInfo = cc4.i().u(hf4Var.g());
                if (pMSAppInfo != null && cc4.i().o(ed4.class, hf4Var.g()) != null) {
                    hf4Var.u(pMSAppInfo.versionCode);
                } else {
                    hf4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(hf4Var.m()));
            if (hf4Var.a() == 0 && hf4Var.m() != -1 && hf4Var.m() != 0) {
                hashMap.put("dep", a(hf4Var.g(), hf4Var.m(), false).toString());
            }
            if (hf4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = cc4.i().u(hf4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    hf4Var.o(pMSAppInfo.appSign);
                } else {
                    hf4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(hf4Var.f()));
            if (hf4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(hf4Var.i()));
            }
            String k = hf4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(hf4Var.a());
                hf4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = qb4.b().w(hf4Var.a());
            long j = qb4.b().j(hf4Var.a());
            if (hf4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = hf4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(hf4Var.a());
                hf4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(hf4Var.l())) {
                hashMap.put("path", hf4Var.l());
            }
            if (!TextUtils.equals(hf4Var.b(), "-1")) {
                hashMap.put("from", hf4Var.b());
            }
            if (!TextUtils.equals(hf4Var.c(), "-1")) {
                hashMap.put("scene", hf4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(hf4Var.n()));
            hashMap.put("host_env", String.valueOf(qb4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(if4 if4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, if4Var)) == null) {
            if (if4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", if4Var.f());
            hashMap.put("category", String.valueOf(if4Var.a()));
            if (TextUtils.isEmpty(if4Var.h())) {
                if4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", if4Var.h());
            if (if4Var.g() >= 0) {
                hashMap.put("plugin_vercode", if4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
