package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fk4;
import com.baidu.tieba.hk4;
import com.baidu.tieba.kk4;
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
public class ki4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<zh4> l = rg4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (zh4 zh4Var : l) {
                        if (zh4Var.b) {
                            j2 = zh4Var.c;
                        } else {
                            hi4 b = mm4.b(zh4Var.a, zh4Var.d, zh4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", zh4Var.a);
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
                    dh4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", rg4.b().j(0));
            jSONObject.put("game_ext_vercode", rg4.b().j(1));
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
            jSONObject.put("swan_vercode", rg4.b().w(0));
            jSONObject.put("game_vercode", rg4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(fk4 fk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fk4Var)) == null) {
            if (fk4Var != null && fk4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (fk4.a aVar : fk4Var.f()) {
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

    public static JSONObject e(hk4 hk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hk4Var)) == null) {
            if (hk4Var != null && hk4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (hk4.a aVar : hk4Var.f()) {
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
                        if (aVar instanceof kk4.b) {
                            kk4.b bVar = (kk4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<kk4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (kk4.a aVar2 : j) {
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

    public static HashMap<String, String> k(lk4 lk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lk4Var)) == null) {
            if (lk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lk4Var.f());
            hashMap.put("category", String.valueOf(lk4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(lk4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(lk4Var.j()));
            hashMap.put("sub_id", lk4Var.k());
            if (!TextUtils.equals(lk4Var.b(), "-1")) {
                hashMap.put("from", lk4Var.b());
            }
            if (TextUtils.isEmpty(lk4Var.i())) {
                lk4Var.m(h(lk4Var.a()));
            }
            if (!TextUtils.isEmpty(lk4Var.i())) {
                hashMap.put("framework_ver", lk4Var.i());
            }
            if (TextUtils.isEmpty(lk4Var.h())) {
                lk4Var.l(g(lk4Var.a()));
            }
            if (!TextUtils.isEmpty(lk4Var.h())) {
                hashMap.put("extension_ver", lk4Var.h());
            }
            long w = rg4.b().w(lk4Var.a());
            long j = rg4.b().j(lk4Var.a());
            if (lk4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (lk4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(lk4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(mk4 mk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mk4Var)) == null) {
            if (mk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(mk4Var.b(), "-1")) {
                hashMap.put("from", mk4Var.b());
            }
            if (!TextUtils.equals(mk4Var.c(), "-1")) {
                hashMap.put("scene", mk4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = rg4.b().v(i);
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
            String J = rg4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ik4 ik4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ik4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ik4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ik4Var.g());
            hashMap.put("category", String.valueOf(ik4Var.a()));
            if (ik4Var.m() == -1) {
                pMSAppInfo = dh4.i().u(ik4Var.g());
                if (pMSAppInfo != null && dh4.i().o(fi4.class, ik4Var.g()) != null) {
                    ik4Var.u(pMSAppInfo.versionCode);
                } else {
                    ik4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ik4Var.m()));
            if (ik4Var.a() == 0 && ik4Var.m() != -1 && ik4Var.m() != 0) {
                hashMap.put("dep", a(ik4Var.g(), ik4Var.m(), false).toString());
            }
            if (ik4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = dh4.i().u(ik4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ik4Var.o(pMSAppInfo.appSign);
                } else {
                    ik4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ik4Var.f()));
            if (ik4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ik4Var.i()));
            }
            String k = ik4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ik4Var.a());
                ik4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = rg4.b().w(ik4Var.a());
            long j = rg4.b().j(ik4Var.a());
            if (ik4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ik4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ik4Var.a());
                ik4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(ik4Var.l())) {
                hashMap.put("path", ik4Var.l());
            }
            if (!TextUtils.equals(ik4Var.b(), "-1")) {
                hashMap.put("from", ik4Var.b());
            }
            if (!TextUtils.equals(ik4Var.c(), "-1")) {
                hashMap.put("scene", ik4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ik4Var.n()));
            hashMap.put("host_env", String.valueOf(rg4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(jk4 jk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jk4Var)) == null) {
            if (jk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jk4Var.f());
            hashMap.put("category", String.valueOf(jk4Var.a()));
            if (TextUtils.isEmpty(jk4Var.h())) {
                jk4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", jk4Var.h());
            if (jk4Var.g() >= 0) {
                hashMap.put("plugin_vercode", jk4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
