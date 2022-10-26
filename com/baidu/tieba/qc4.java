package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.le4;
import com.baidu.tieba.ne4;
import com.baidu.tieba.qe4;
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
public class qc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<fc4> l = xa4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (fc4 fc4Var : l) {
                        if (fc4Var.b) {
                            j2 = fc4Var.c;
                        } else {
                            nc4 b = sg4.b(fc4Var.a, fc4Var.d, fc4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", fc4Var.a);
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
                    jb4.i().g(arrayList);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    public static JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_ext_ver", g(0));
            jSONObject.put("game_ext_ver", g(1));
            jSONObject.put("swan_ext_vercode", xa4.b().j(0));
            jSONObject.put("game_ext_vercode", xa4.b().j(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_core_ver", h(0));
            jSONObject.put("swan_game_ver", h(1));
            jSONObject.put("swan_vercode", xa4.b().w(0));
            jSONObject.put("game_vercode", xa4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(le4 le4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, le4Var)) == null) {
            if (le4Var != null && le4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (le4.a aVar : le4Var.f()) {
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

    public static JSONObject e(ne4 ne4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ne4Var)) == null) {
            if (ne4Var != null && ne4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ne4.a aVar : ne4Var.f()) {
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
                        if (aVar instanceof qe4.b) {
                            qe4.b bVar = (qe4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<qe4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (qe4.a aVar2 : j) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.getType());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", ((qe4.a) j.get(0)).b());
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

    public static HashMap k(re4 re4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, re4Var)) == null) {
            if (re4Var == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("bundle_id", re4Var.f());
            hashMap.put("category", String.valueOf(re4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(re4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(re4Var.j()));
            hashMap.put("sub_id", re4Var.k());
            if (!TextUtils.equals(re4Var.b(), "-1")) {
                hashMap.put("from", re4Var.b());
            }
            if (TextUtils.isEmpty(re4Var.i())) {
                re4Var.m(h(re4Var.a()));
            }
            if (!TextUtils.isEmpty(re4Var.i())) {
                hashMap.put("framework_ver", re4Var.i());
            }
            if (TextUtils.isEmpty(re4Var.h())) {
                re4Var.l(g(re4Var.a()));
            }
            if (!TextUtils.isEmpty(re4Var.h())) {
                hashMap.put("extension_ver", re4Var.h());
            }
            long w = xa4.b().w(re4Var.a());
            long j = xa4.b().j(re4Var.a());
            if (re4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (re4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(re4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap f(se4 se4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, se4Var)) == null) {
            if (se4Var == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.equals(se4Var.b(), "-1")) {
                hashMap.put("from", se4Var.b());
            }
            if (!TextUtils.equals(se4Var.c(), "-1")) {
                hashMap.put("scene", se4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = xa4.b().v(i);
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
            String J = xa4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap i(oe4 oe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, oe4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (oe4Var == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("bundle_id", oe4Var.g());
            hashMap.put("category", String.valueOf(oe4Var.a()));
            if (oe4Var.m() == -1) {
                pMSAppInfo = jb4.i().u(oe4Var.g());
                if (pMSAppInfo != null && jb4.i().o(lc4.class, oe4Var.g()) != null) {
                    oe4Var.u(pMSAppInfo.versionCode);
                } else {
                    oe4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(oe4Var.m()));
            if (oe4Var.a() == 0 && oe4Var.m() != -1 && oe4Var.m() != 0) {
                hashMap.put("dep", a(oe4Var.g(), oe4Var.m(), false).toString());
            }
            if (oe4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = jb4.i().u(oe4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    oe4Var.o(pMSAppInfo.appSign);
                } else {
                    oe4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(oe4Var.f()));
            if (oe4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(oe4Var.i()));
            }
            String k = oe4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(oe4Var.a());
                oe4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = xa4.b().w(oe4Var.a());
            long j = xa4.b().j(oe4Var.a());
            if (oe4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = oe4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(oe4Var.a());
                oe4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(oe4Var.l())) {
                hashMap.put("path", oe4Var.l());
            }
            if (!TextUtils.equals(oe4Var.b(), "-1")) {
                hashMap.put("from", oe4Var.b());
            }
            if (!TextUtils.equals(oe4Var.c(), "-1")) {
                hashMap.put("scene", oe4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(oe4Var.n()));
            hashMap.put("host_env", String.valueOf(xa4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap j(pe4 pe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pe4Var)) == null) {
            if (pe4Var == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("bundle_id", pe4Var.f());
            hashMap.put("category", String.valueOf(pe4Var.a()));
            if (TextUtils.isEmpty(pe4Var.h())) {
                pe4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", pe4Var.h());
            if (pe4Var.g() >= 0) {
                hashMap.put("plugin_vercode", pe4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
