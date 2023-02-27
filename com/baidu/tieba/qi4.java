package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.lk4;
import com.baidu.tieba.nk4;
import com.baidu.tieba.qk4;
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
/* loaded from: classes5.dex */
public class qi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<fi4> l = xg4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (fi4 fi4Var : l) {
                        if (fi4Var.b) {
                            j2 = fi4Var.c;
                        } else {
                            ni4 b = sm4.b(fi4Var.a, fi4Var.d, fi4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", fi4Var.a);
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
                    jh4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", xg4.b().j(0));
            jSONObject.put("game_ext_vercode", xg4.b().j(1));
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
            jSONObject.put("swan_vercode", xg4.b().w(0));
            jSONObject.put("game_vercode", xg4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(lk4 lk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lk4Var)) == null) {
            if (lk4Var != null && lk4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (lk4.a aVar : lk4Var.f()) {
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

    public static JSONObject e(nk4 nk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nk4Var)) == null) {
            if (nk4Var != null && nk4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (nk4.a aVar : nk4Var.f()) {
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
                        if (aVar instanceof qk4.b) {
                            qk4.b bVar = (qk4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<qk4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (qk4.a aVar2 : j) {
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

    public static HashMap<String, String> k(rk4 rk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, rk4Var)) == null) {
            if (rk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", rk4Var.f());
            hashMap.put("category", String.valueOf(rk4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(rk4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(rk4Var.j()));
            hashMap.put("sub_id", rk4Var.k());
            if (!TextUtils.equals(rk4Var.b(), "-1")) {
                hashMap.put("from", rk4Var.b());
            }
            if (TextUtils.isEmpty(rk4Var.i())) {
                rk4Var.m(h(rk4Var.a()));
            }
            if (!TextUtils.isEmpty(rk4Var.i())) {
                hashMap.put("framework_ver", rk4Var.i());
            }
            if (TextUtils.isEmpty(rk4Var.h())) {
                rk4Var.l(g(rk4Var.a()));
            }
            if (!TextUtils.isEmpty(rk4Var.h())) {
                hashMap.put("extension_ver", rk4Var.h());
            }
            long w = xg4.b().w(rk4Var.a());
            long j = xg4.b().j(rk4Var.a());
            if (rk4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (rk4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(rk4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(sk4 sk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sk4Var)) == null) {
            if (sk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(sk4Var.b(), "-1")) {
                hashMap.put("from", sk4Var.b());
            }
            if (!TextUtils.equals(sk4Var.c(), "-1")) {
                hashMap.put("scene", sk4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = xg4.b().v(i);
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
            String J = xg4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ok4 ok4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ok4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ok4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ok4Var.g());
            hashMap.put("category", String.valueOf(ok4Var.a()));
            if (ok4Var.m() == -1) {
                pMSAppInfo = jh4.i().u(ok4Var.g());
                if (pMSAppInfo != null && jh4.i().o(li4.class, ok4Var.g()) != null) {
                    ok4Var.u(pMSAppInfo.versionCode);
                } else {
                    ok4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ok4Var.m()));
            if (ok4Var.a() == 0 && ok4Var.m() != -1 && ok4Var.m() != 0) {
                hashMap.put("dep", a(ok4Var.g(), ok4Var.m(), false).toString());
            }
            if (ok4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = jh4.i().u(ok4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ok4Var.o(pMSAppInfo.appSign);
                } else {
                    ok4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ok4Var.f()));
            if (ok4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ok4Var.i()));
            }
            String k = ok4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ok4Var.a());
                ok4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = xg4.b().w(ok4Var.a());
            long j = xg4.b().j(ok4Var.a());
            if (ok4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ok4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ok4Var.a());
                ok4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(ok4Var.l())) {
                hashMap.put("path", ok4Var.l());
            }
            if (!TextUtils.equals(ok4Var.b(), "-1")) {
                hashMap.put("from", ok4Var.b());
            }
            if (!TextUtils.equals(ok4Var.c(), "-1")) {
                hashMap.put("scene", ok4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ok4Var.n()));
            hashMap.put("host_env", String.valueOf(xg4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(pk4 pk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pk4Var)) == null) {
            if (pk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", pk4Var.f());
            hashMap.put("category", String.valueOf(pk4Var.a()));
            if (TextUtils.isEmpty(pk4Var.h())) {
                pk4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", pk4Var.h());
            if (pk4Var.g() >= 0) {
                hashMap.put("plugin_vercode", pk4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
