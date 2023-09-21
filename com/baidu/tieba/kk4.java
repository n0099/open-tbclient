package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fm4;
import com.baidu.tieba.hm4;
import com.baidu.tieba.km4;
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
public class kk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<zj4> l = ri4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (zj4 zj4Var : l) {
                        if (zj4Var.b) {
                            j2 = zj4Var.c;
                        } else {
                            hk4 b = mo4.b(zj4Var.a, zj4Var.d, zj4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", zj4Var.a);
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
                    dj4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ri4.b().j(0));
            jSONObject.put("game_ext_vercode", ri4.b().j(1));
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
            jSONObject.put("swan_vercode", ri4.b().w(0));
            jSONObject.put("game_vercode", ri4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(fm4 fm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fm4Var)) == null) {
            if (fm4Var != null && fm4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (fm4.a aVar : fm4Var.f()) {
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

    public static JSONObject e(hm4 hm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hm4Var)) == null) {
            if (hm4Var != null && hm4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (hm4.a aVar : hm4Var.f()) {
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
                        if (aVar instanceof km4.b) {
                            km4.b bVar = (km4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<km4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (km4.a aVar2 : j) {
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

    public static HashMap<String, String> k(lm4 lm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lm4Var)) == null) {
            if (lm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lm4Var.f());
            hashMap.put("category", String.valueOf(lm4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(lm4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(lm4Var.j()));
            hashMap.put("sub_id", lm4Var.k());
            if (!TextUtils.equals(lm4Var.b(), "-1")) {
                hashMap.put("from", lm4Var.b());
            }
            if (TextUtils.isEmpty(lm4Var.i())) {
                lm4Var.m(h(lm4Var.a()));
            }
            if (!TextUtils.isEmpty(lm4Var.i())) {
                hashMap.put("framework_ver", lm4Var.i());
            }
            if (TextUtils.isEmpty(lm4Var.h())) {
                lm4Var.l(g(lm4Var.a()));
            }
            if (!TextUtils.isEmpty(lm4Var.h())) {
                hashMap.put("extension_ver", lm4Var.h());
            }
            long w = ri4.b().w(lm4Var.a());
            long j = ri4.b().j(lm4Var.a());
            if (lm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (lm4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(lm4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(mm4 mm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mm4Var)) == null) {
            if (mm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(mm4Var.b(), "-1")) {
                hashMap.put("from", mm4Var.b());
            }
            if (!TextUtils.equals(mm4Var.c(), "-1")) {
                hashMap.put("scene", mm4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ri4.b().v(i);
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
            String J = ri4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(im4 im4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, im4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (im4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", im4Var.g());
            hashMap.put("category", String.valueOf(im4Var.a()));
            if (im4Var.m() == -1) {
                pMSAppInfo = dj4.i().u(im4Var.g());
                if (pMSAppInfo != null && dj4.i().o(fk4.class, im4Var.g()) != null) {
                    im4Var.u(pMSAppInfo.versionCode);
                } else {
                    im4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(im4Var.m()));
            if (im4Var.a() == 0 && im4Var.m() != -1 && im4Var.m() != 0) {
                hashMap.put("dep", a(im4Var.g(), im4Var.m(), false).toString());
            }
            if (im4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = dj4.i().u(im4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    im4Var.o(pMSAppInfo.appSign);
                } else {
                    im4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(im4Var.f()));
            if (im4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(im4Var.i()));
            }
            String k = im4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(im4Var.a());
                im4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ri4.b().w(im4Var.a());
            long j = ri4.b().j(im4Var.a());
            if (im4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = im4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(im4Var.a());
                im4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(im4Var.l())) {
                hashMap.put("path", im4Var.l());
            }
            if (!TextUtils.equals(im4Var.b(), "-1")) {
                hashMap.put("from", im4Var.b());
            }
            if (!TextUtils.equals(im4Var.c(), "-1")) {
                hashMap.put("scene", im4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(im4Var.n()));
            hashMap.put("host_env", String.valueOf(ri4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jm4Var)) == null) {
            if (jm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jm4Var.f());
            hashMap.put("category", String.valueOf(jm4Var.a()));
            if (TextUtils.isEmpty(jm4Var.h())) {
                jm4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", jm4Var.h());
            if (jm4Var.g() >= 0) {
                hashMap.put("plugin_vercode", jm4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
