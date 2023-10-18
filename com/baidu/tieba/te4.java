package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.og4;
import com.baidu.tieba.qg4;
import com.baidu.tieba.tg4;
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
public class te4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ie4> l = ad4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ie4 ie4Var : l) {
                        if (ie4Var.b) {
                            j2 = ie4Var.c;
                        } else {
                            qe4 b = vi4.b(ie4Var.a, ie4Var.d, ie4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ie4Var.a);
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
                    md4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ad4.b().j(0));
            jSONObject.put("game_ext_vercode", ad4.b().j(1));
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
            jSONObject.put("swan_vercode", ad4.b().w(0));
            jSONObject.put("game_vercode", ad4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(og4 og4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, og4Var)) == null) {
            if (og4Var != null && og4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (og4.a aVar : og4Var.f()) {
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

    public static JSONObject e(qg4 qg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qg4Var)) == null) {
            if (qg4Var != null && qg4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (qg4.a aVar : qg4Var.f()) {
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
                        if (aVar instanceof tg4.b) {
                            tg4.b bVar = (tg4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<tg4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (tg4.a aVar2 : j) {
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

    public static HashMap<String, String> k(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ug4Var)) == null) {
            if (ug4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ug4Var.f());
            hashMap.put("category", String.valueOf(ug4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(ug4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(ug4Var.j()));
            hashMap.put("sub_id", ug4Var.k());
            if (!TextUtils.equals(ug4Var.b(), "-1")) {
                hashMap.put("from", ug4Var.b());
            }
            if (TextUtils.isEmpty(ug4Var.i())) {
                ug4Var.m(h(ug4Var.a()));
            }
            if (!TextUtils.isEmpty(ug4Var.i())) {
                hashMap.put("framework_ver", ug4Var.i());
            }
            if (TextUtils.isEmpty(ug4Var.h())) {
                ug4Var.l(g(ug4Var.a()));
            }
            if (!TextUtils.isEmpty(ug4Var.h())) {
                hashMap.put("extension_ver", ug4Var.h());
            }
            long w = ad4.b().w(ug4Var.a());
            long j = ad4.b().j(ug4Var.a());
            if (ug4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (ug4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ug4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(vg4 vg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, vg4Var)) == null) {
            if (vg4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(vg4Var.b(), "-1")) {
                hashMap.put("from", vg4Var.b());
            }
            if (!TextUtils.equals(vg4Var.c(), "-1")) {
                hashMap.put("scene", vg4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ad4.b().v(i);
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
            String J = ad4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rg4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (rg4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", rg4Var.g());
            hashMap.put("category", String.valueOf(rg4Var.a()));
            if (rg4Var.m() == -1) {
                pMSAppInfo = md4.i().u(rg4Var.g());
                if (pMSAppInfo != null && md4.i().o(oe4.class, rg4Var.g()) != null) {
                    rg4Var.u(pMSAppInfo.versionCode);
                } else {
                    rg4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(rg4Var.m()));
            if (rg4Var.a() == 0 && rg4Var.m() != -1 && rg4Var.m() != 0) {
                hashMap.put("dep", a(rg4Var.g(), rg4Var.m(), false).toString());
            }
            if (rg4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = md4.i().u(rg4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    rg4Var.o(pMSAppInfo.appSign);
                } else {
                    rg4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(rg4Var.f()));
            if (rg4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(rg4Var.i()));
            }
            String k = rg4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(rg4Var.a());
                rg4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ad4.b().w(rg4Var.a());
            long j = ad4.b().j(rg4Var.a());
            if (rg4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = rg4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(rg4Var.a());
                rg4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(rg4Var.l())) {
                hashMap.put("path", rg4Var.l());
            }
            if (!TextUtils.equals(rg4Var.b(), "-1")) {
                hashMap.put("from", rg4Var.b());
            }
            if (!TextUtils.equals(rg4Var.c(), "-1")) {
                hashMap.put("scene", rg4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(rg4Var.n()));
            hashMap.put("host_env", String.valueOf(ad4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sg4Var)) == null) {
            if (sg4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", sg4Var.f());
            hashMap.put("category", String.valueOf(sg4Var.a()));
            if (TextUtils.isEmpty(sg4Var.h())) {
                sg4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", sg4Var.h());
            if (sg4Var.g() >= 0) {
                hashMap.put("plugin_vercode", sg4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
