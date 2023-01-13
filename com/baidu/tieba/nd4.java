package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.if4;
import com.baidu.tieba.kf4;
import com.baidu.tieba.nf4;
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
public class nd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<cd4> l = ub4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (cd4 cd4Var : l) {
                        if (cd4Var.b) {
                            j2 = cd4Var.c;
                        } else {
                            kd4 b = ph4.b(cd4Var.a, cd4Var.d, cd4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", cd4Var.a);
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
                    gc4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ub4.b().j(0));
            jSONObject.put("game_ext_vercode", ub4.b().j(1));
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
            jSONObject.put("swan_vercode", ub4.b().w(0));
            jSONObject.put("game_vercode", ub4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(if4 if4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, if4Var)) == null) {
            if (if4Var != null && if4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (if4.a aVar : if4Var.f()) {
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

    public static JSONObject e(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kf4Var)) == null) {
            if (kf4Var != null && kf4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (kf4.a aVar : kf4Var.f()) {
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
                        if (aVar instanceof nf4.b) {
                            nf4.b bVar = (nf4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<nf4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (nf4.a aVar2 : j) {
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

    public static HashMap<String, String> k(of4 of4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, of4Var)) == null) {
            if (of4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", of4Var.f());
            hashMap.put("category", String.valueOf(of4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(of4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(of4Var.j()));
            hashMap.put("sub_id", of4Var.k());
            if (!TextUtils.equals(of4Var.b(), "-1")) {
                hashMap.put("from", of4Var.b());
            }
            if (TextUtils.isEmpty(of4Var.i())) {
                of4Var.m(h(of4Var.a()));
            }
            if (!TextUtils.isEmpty(of4Var.i())) {
                hashMap.put("framework_ver", of4Var.i());
            }
            if (TextUtils.isEmpty(of4Var.h())) {
                of4Var.l(g(of4Var.a()));
            }
            if (!TextUtils.isEmpty(of4Var.h())) {
                hashMap.put("extension_ver", of4Var.h());
            }
            long w = ub4.b().w(of4Var.a());
            long j = ub4.b().j(of4Var.a());
            if (of4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (of4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(of4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(pf4 pf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pf4Var)) == null) {
            if (pf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(pf4Var.b(), "-1")) {
                hashMap.put("from", pf4Var.b());
            }
            if (!TextUtils.equals(pf4Var.c(), "-1")) {
                hashMap.put("scene", pf4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ub4.b().v(i);
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
            String J = ub4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(lf4 lf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lf4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (lf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lf4Var.g());
            hashMap.put("category", String.valueOf(lf4Var.a()));
            if (lf4Var.m() == -1) {
                pMSAppInfo = gc4.i().u(lf4Var.g());
                if (pMSAppInfo != null && gc4.i().o(id4.class, lf4Var.g()) != null) {
                    lf4Var.u(pMSAppInfo.versionCode);
                } else {
                    lf4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(lf4Var.m()));
            if (lf4Var.a() == 0 && lf4Var.m() != -1 && lf4Var.m() != 0) {
                hashMap.put("dep", a(lf4Var.g(), lf4Var.m(), false).toString());
            }
            if (lf4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = gc4.i().u(lf4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    lf4Var.o(pMSAppInfo.appSign);
                } else {
                    lf4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(lf4Var.f()));
            if (lf4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(lf4Var.i()));
            }
            String k = lf4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(lf4Var.a());
                lf4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ub4.b().w(lf4Var.a());
            long j = ub4.b().j(lf4Var.a());
            if (lf4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = lf4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(lf4Var.a());
                lf4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(lf4Var.l())) {
                hashMap.put("path", lf4Var.l());
            }
            if (!TextUtils.equals(lf4Var.b(), "-1")) {
                hashMap.put("from", lf4Var.b());
            }
            if (!TextUtils.equals(lf4Var.c(), "-1")) {
                hashMap.put("scene", lf4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(lf4Var.n()));
            hashMap.put("host_env", String.valueOf(ub4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(mf4 mf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mf4Var)) == null) {
            if (mf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", mf4Var.f());
            hashMap.put("category", String.valueOf(mf4Var.a()));
            if (TextUtils.isEmpty(mf4Var.h())) {
                mf4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", mf4Var.h());
            if (mf4Var.g() >= 0) {
                hashMap.put("plugin_vercode", mf4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
