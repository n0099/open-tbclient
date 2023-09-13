package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gm4;
import com.baidu.tieba.im4;
import com.baidu.tieba.lm4;
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
/* loaded from: classes6.dex */
public class lk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ak4> l = si4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ak4 ak4Var : l) {
                        if (ak4Var.b) {
                            j2 = ak4Var.c;
                        } else {
                            ik4 b = no4.b(ak4Var.a, ak4Var.d, ak4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ak4Var.a);
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
                    ej4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", si4.b().j(0));
            jSONObject.put("game_ext_vercode", si4.b().j(1));
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
            jSONObject.put("swan_vercode", si4.b().w(0));
            jSONObject.put("game_vercode", si4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(gm4 gm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gm4Var)) == null) {
            if (gm4Var != null && gm4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (gm4.a aVar : gm4Var.f()) {
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

    public static JSONObject e(im4 im4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, im4Var)) == null) {
            if (im4Var != null && im4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (im4.a aVar : im4Var.f()) {
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
                        if (aVar instanceof lm4.b) {
                            lm4.b bVar = (lm4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<lm4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (lm4.a aVar2 : j) {
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

    public static HashMap<String, String> k(mm4 mm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mm4Var)) == null) {
            if (mm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", mm4Var.f());
            hashMap.put("category", String.valueOf(mm4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(mm4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(mm4Var.j()));
            hashMap.put("sub_id", mm4Var.k());
            if (!TextUtils.equals(mm4Var.b(), "-1")) {
                hashMap.put("from", mm4Var.b());
            }
            if (TextUtils.isEmpty(mm4Var.i())) {
                mm4Var.m(h(mm4Var.a()));
            }
            if (!TextUtils.isEmpty(mm4Var.i())) {
                hashMap.put("framework_ver", mm4Var.i());
            }
            if (TextUtils.isEmpty(mm4Var.h())) {
                mm4Var.l(g(mm4Var.a()));
            }
            if (!TextUtils.isEmpty(mm4Var.h())) {
                hashMap.put("extension_ver", mm4Var.h());
            }
            long w = si4.b().w(mm4Var.a());
            long j = si4.b().j(mm4Var.a());
            if (mm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (mm4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(mm4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(nm4 nm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nm4Var)) == null) {
            if (nm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(nm4Var.b(), "-1")) {
                hashMap.put("from", nm4Var.b());
            }
            if (!TextUtils.equals(nm4Var.c(), "-1")) {
                hashMap.put("scene", nm4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = si4.b().v(i);
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
            String J = si4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jm4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (jm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jm4Var.g());
            hashMap.put("category", String.valueOf(jm4Var.a()));
            if (jm4Var.m() == -1) {
                pMSAppInfo = ej4.i().u(jm4Var.g());
                if (pMSAppInfo != null && ej4.i().o(gk4.class, jm4Var.g()) != null) {
                    jm4Var.u(pMSAppInfo.versionCode);
                } else {
                    jm4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(jm4Var.m()));
            if (jm4Var.a() == 0 && jm4Var.m() != -1 && jm4Var.m() != 0) {
                hashMap.put("dep", a(jm4Var.g(), jm4Var.m(), false).toString());
            }
            if (jm4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = ej4.i().u(jm4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    jm4Var.o(pMSAppInfo.appSign);
                } else {
                    jm4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(jm4Var.f()));
            if (jm4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(jm4Var.i()));
            }
            String k = jm4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(jm4Var.a());
                jm4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = si4.b().w(jm4Var.a());
            long j = si4.b().j(jm4Var.a());
            if (jm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = jm4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(jm4Var.a());
                jm4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(jm4Var.l())) {
                hashMap.put("path", jm4Var.l());
            }
            if (!TextUtils.equals(jm4Var.b(), "-1")) {
                hashMap.put("from", jm4Var.b());
            }
            if (!TextUtils.equals(jm4Var.c(), "-1")) {
                hashMap.put("scene", jm4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(jm4Var.n()));
            hashMap.put("host_env", String.valueOf(si4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(km4 km4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, km4Var)) == null) {
            if (km4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", km4Var.f());
            hashMap.put("category", String.valueOf(km4Var.a()));
            if (TextUtils.isEmpty(km4Var.h())) {
                km4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", km4Var.h());
            if (km4Var.g() >= 0) {
                hashMap.put("plugin_vercode", km4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
