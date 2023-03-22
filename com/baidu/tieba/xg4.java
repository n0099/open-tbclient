package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.si4;
import com.baidu.tieba.ui4;
import com.baidu.tieba.xi4;
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
public class xg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<mg4> l = ef4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (mg4 mg4Var : l) {
                        if (mg4Var.b) {
                            j2 = mg4Var.c;
                        } else {
                            ug4 b = zk4.b(mg4Var.a, mg4Var.d, mg4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", mg4Var.a);
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
                    qf4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ef4.b().j(0));
            jSONObject.put("game_ext_vercode", ef4.b().j(1));
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
            jSONObject.put("swan_vercode", ef4.b().w(0));
            jSONObject.put("game_vercode", ef4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(si4 si4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, si4Var)) == null) {
            if (si4Var != null && si4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (si4.a aVar : si4Var.f()) {
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

    public static JSONObject e(ui4 ui4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ui4Var)) == null) {
            if (ui4Var != null && ui4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ui4.a aVar : ui4Var.f()) {
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
                        if (aVar instanceof xi4.b) {
                            xi4.b bVar = (xi4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<xi4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (xi4.a aVar2 : j) {
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

    public static HashMap<String, String> k(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yi4Var)) == null) {
            if (yi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", yi4Var.f());
            hashMap.put("category", String.valueOf(yi4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(yi4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(yi4Var.j()));
            hashMap.put("sub_id", yi4Var.k());
            if (!TextUtils.equals(yi4Var.b(), "-1")) {
                hashMap.put("from", yi4Var.b());
            }
            if (TextUtils.isEmpty(yi4Var.i())) {
                yi4Var.m(h(yi4Var.a()));
            }
            if (!TextUtils.isEmpty(yi4Var.i())) {
                hashMap.put("framework_ver", yi4Var.i());
            }
            if (TextUtils.isEmpty(yi4Var.h())) {
                yi4Var.l(g(yi4Var.a()));
            }
            if (!TextUtils.isEmpty(yi4Var.h())) {
                hashMap.put("extension_ver", yi4Var.h());
            }
            long w = ef4.b().w(yi4Var.a());
            long j = ef4.b().j(yi4Var.a());
            if (yi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (yi4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(yi4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(zi4 zi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, zi4Var)) == null) {
            if (zi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(zi4Var.b(), "-1")) {
                hashMap.put("from", zi4Var.b());
            }
            if (!TextUtils.equals(zi4Var.c(), "-1")) {
                hashMap.put("scene", zi4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ef4.b().v(i);
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
            String J = ef4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(vi4 vi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, vi4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (vi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", vi4Var.g());
            hashMap.put("category", String.valueOf(vi4Var.a()));
            if (vi4Var.m() == -1) {
                pMSAppInfo = qf4.i().u(vi4Var.g());
                if (pMSAppInfo != null && qf4.i().o(sg4.class, vi4Var.g()) != null) {
                    vi4Var.u(pMSAppInfo.versionCode);
                } else {
                    vi4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(vi4Var.m()));
            if (vi4Var.a() == 0 && vi4Var.m() != -1 && vi4Var.m() != 0) {
                hashMap.put("dep", a(vi4Var.g(), vi4Var.m(), false).toString());
            }
            if (vi4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = qf4.i().u(vi4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    vi4Var.o(pMSAppInfo.appSign);
                } else {
                    vi4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(vi4Var.f()));
            if (vi4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(vi4Var.i()));
            }
            String k = vi4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(vi4Var.a());
                vi4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ef4.b().w(vi4Var.a());
            long j = ef4.b().j(vi4Var.a());
            if (vi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = vi4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(vi4Var.a());
                vi4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(vi4Var.l())) {
                hashMap.put("path", vi4Var.l());
            }
            if (!TextUtils.equals(vi4Var.b(), "-1")) {
                hashMap.put("from", vi4Var.b());
            }
            if (!TextUtils.equals(vi4Var.c(), "-1")) {
                hashMap.put("scene", vi4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(vi4Var.n()));
            hashMap.put("host_env", String.valueOf(ef4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(wi4 wi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, wi4Var)) == null) {
            if (wi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", wi4Var.f());
            hashMap.put("category", String.valueOf(wi4Var.a()));
            if (TextUtils.isEmpty(wi4Var.h())) {
                wi4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", wi4Var.h());
            if (wi4Var.g() >= 0) {
                hashMap.put("plugin_vercode", wi4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
