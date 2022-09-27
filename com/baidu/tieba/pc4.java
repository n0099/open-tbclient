package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ke4;
import com.baidu.tieba.me4;
import com.baidu.tieba.pe4;
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
public class pc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ec4> l = wa4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ec4 ec4Var : l) {
                        if (ec4Var.b) {
                            j2 = ec4Var.c;
                        } else {
                            mc4 b = rg4.b(ec4Var.a, ec4Var.d, ec4Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ec4Var.a);
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
                    ib4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", wa4.b().j(0));
            jSONObject.put("game_ext_vercode", wa4.b().j(1));
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
            jSONObject.put("swan_vercode", wa4.b().w(0));
            jSONObject.put("game_vercode", wa4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ke4 ke4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ke4Var)) == null) {
            if (ke4Var != null && ke4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ke4.a aVar : ke4Var.f()) {
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

    public static JSONObject e(me4 me4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, me4Var)) == null) {
            if (me4Var != null && me4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (me4.a aVar : me4Var.f()) {
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
                        if (aVar instanceof pe4.b) {
                            pe4.b bVar = (pe4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<pe4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (pe4.a aVar2 : j) {
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

    public static HashMap<String, String> f(re4 re4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, re4Var)) == null) {
            if (re4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(re4Var.b(), "-1")) {
                hashMap.put("from", re4Var.b());
            }
            if (!TextUtils.equals(re4Var.c(), "-1")) {
                hashMap.put("scene", re4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = wa4.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = wa4.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ne4 ne4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ne4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ne4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ne4Var.g());
            hashMap.put("category", String.valueOf(ne4Var.a()));
            if (ne4Var.m() == -1) {
                pMSAppInfo = ib4.i().u(ne4Var.g());
                if (pMSAppInfo != null && ib4.i().o(kc4.class, ne4Var.g()) != null) {
                    ne4Var.u(pMSAppInfo.versionCode);
                } else {
                    ne4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ne4Var.m()));
            if (ne4Var.a() == 0 && ne4Var.m() != -1 && ne4Var.m() != 0) {
                hashMap.put("dep", a(ne4Var.g(), ne4Var.m(), false).toString());
            }
            if (ne4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = ib4.i().u(ne4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ne4Var.o(pMSAppInfo.appSign);
                } else {
                    ne4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ne4Var.f()));
            if (ne4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ne4Var.i()));
            }
            String k = ne4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ne4Var.a());
                ne4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = wa4.b().w(ne4Var.a());
            long j = wa4.b().j(ne4Var.a());
            if (ne4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ne4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ne4Var.a());
                ne4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ne4Var.l())) {
                hashMap.put("path", ne4Var.l());
            }
            if (!TextUtils.equals(ne4Var.b(), "-1")) {
                hashMap.put("from", ne4Var.b());
            }
            if (!TextUtils.equals(ne4Var.c(), "-1")) {
                hashMap.put("scene", ne4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ne4Var.n()));
            hashMap.put("host_env", String.valueOf(wa4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(oe4 oe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, oe4Var)) == null) {
            if (oe4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", oe4Var.f());
            hashMap.put("category", String.valueOf(oe4Var.a()));
            if (TextUtils.isEmpty(oe4Var.h())) {
                oe4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", oe4Var.h());
            if (oe4Var.g() >= 0) {
                hashMap.put("plugin_vercode", oe4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(qe4 qe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, qe4Var)) == null) {
            if (qe4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", qe4Var.f());
            hashMap.put("category", String.valueOf(qe4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(qe4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(qe4Var.j()));
            hashMap.put("sub_id", qe4Var.k());
            if (!TextUtils.equals(qe4Var.b(), "-1")) {
                hashMap.put("from", qe4Var.b());
            }
            if (TextUtils.isEmpty(qe4Var.i())) {
                qe4Var.m(h(qe4Var.a()));
            }
            if (!TextUtils.isEmpty(qe4Var.i())) {
                hashMap.put("framework_ver", qe4Var.i());
            }
            if (TextUtils.isEmpty(qe4Var.h())) {
                qe4Var.l(g(qe4Var.a()));
            }
            if (!TextUtils.isEmpty(qe4Var.h())) {
                hashMap.put("extension_ver", qe4Var.h());
            }
            long w = wa4.b().w(qe4Var.a());
            long j = wa4.b().j(qe4Var.a());
            if (qe4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (qe4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(qe4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
