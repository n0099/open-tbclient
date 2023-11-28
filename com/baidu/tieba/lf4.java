package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gh4;
import com.baidu.tieba.ih4;
import com.baidu.tieba.lh4;
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
public class lf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<af4> l = sd4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (af4 af4Var : l) {
                        if (af4Var.b) {
                            j2 = af4Var.c;
                        } else {
                            if4 b = nj4.b(af4Var.a, af4Var.d, af4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", af4Var.a);
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
                    ee4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", sd4.b().j(0));
            jSONObject.put("game_ext_vercode", sd4.b().j(1));
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
            jSONObject.put("swan_vercode", sd4.b().w(0));
            jSONObject.put("game_vercode", sd4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(gh4 gh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gh4Var)) == null) {
            if (gh4Var != null && gh4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (gh4.a aVar : gh4Var.f()) {
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

    public static JSONObject e(ih4 ih4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ih4Var)) == null) {
            if (ih4Var != null && ih4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ih4.a aVar : ih4Var.f()) {
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
                        if (aVar instanceof lh4.b) {
                            lh4.b bVar = (lh4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<lh4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (lh4.a aVar2 : j) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.b());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", j.get(0).c());
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

    public static HashMap<String, String> k(mh4 mh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mh4Var)) == null) {
            if (mh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", mh4Var.f());
            hashMap.put("category", String.valueOf(mh4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(mh4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(mh4Var.j()));
            hashMap.put("sub_id", mh4Var.k());
            if (!TextUtils.equals(mh4Var.b(), "-1")) {
                hashMap.put("from", mh4Var.b());
            }
            if (TextUtils.isEmpty(mh4Var.i())) {
                mh4Var.m(h(mh4Var.a()));
            }
            if (!TextUtils.isEmpty(mh4Var.i())) {
                hashMap.put("framework_ver", mh4Var.i());
            }
            if (TextUtils.isEmpty(mh4Var.h())) {
                mh4Var.l(g(mh4Var.a()));
            }
            if (!TextUtils.isEmpty(mh4Var.h())) {
                hashMap.put("extension_ver", mh4Var.h());
            }
            long w = sd4.b().w(mh4Var.a());
            long j = sd4.b().j(mh4Var.a());
            if (mh4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (mh4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(mh4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(nh4 nh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nh4Var)) == null) {
            if (nh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(nh4Var.b(), "-1")) {
                hashMap.put("from", nh4Var.b());
            }
            if (!TextUtils.equals(nh4Var.c(), "-1")) {
                hashMap.put("scene", nh4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = sd4.b().v(i);
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
            String J = sd4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(jh4 jh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jh4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (jh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jh4Var.g());
            hashMap.put("category", String.valueOf(jh4Var.a()));
            if (jh4Var.m() == -1) {
                pMSAppInfo = ee4.i().u(jh4Var.g());
                if (pMSAppInfo != null && ee4.i().o(gf4.class, jh4Var.g()) != null) {
                    jh4Var.u(pMSAppInfo.versionCode);
                } else {
                    jh4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(jh4Var.m()));
            if (jh4Var.a() == 0 && jh4Var.m() != -1 && jh4Var.m() != 0) {
                hashMap.put("dep", a(jh4Var.g(), jh4Var.m(), false).toString());
            }
            if (jh4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = ee4.i().u(jh4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    jh4Var.o(pMSAppInfo.appSign);
                } else {
                    jh4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(jh4Var.f()));
            if (jh4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(jh4Var.i()));
            }
            String k = jh4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(jh4Var.a());
                jh4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = sd4.b().w(jh4Var.a());
            long j = sd4.b().j(jh4Var.a());
            if (jh4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = jh4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(jh4Var.a());
                jh4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(jh4Var.l())) {
                hashMap.put("path", jh4Var.l());
            }
            if (!TextUtils.equals(jh4Var.b(), "-1")) {
                hashMap.put("from", jh4Var.b());
            }
            if (!TextUtils.equals(jh4Var.c(), "-1")) {
                hashMap.put("scene", jh4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(jh4Var.n()));
            hashMap.put("host_env", String.valueOf(sd4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(kh4 kh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kh4Var)) == null) {
            if (kh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", kh4Var.f());
            hashMap.put("category", String.valueOf(kh4Var.a()));
            if (TextUtils.isEmpty(kh4Var.h())) {
                kh4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", kh4Var.h());
            if (kh4Var.g() >= 0) {
                hashMap.put("plugin_vercode", kh4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
