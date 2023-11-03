package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fh4;
import com.baidu.tieba.hh4;
import com.baidu.tieba.kh4;
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
public class kf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ze4> l = rd4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ze4 ze4Var : l) {
                        if (ze4Var.b) {
                            j2 = ze4Var.c;
                        } else {
                            hf4 b = mj4.b(ze4Var.a, ze4Var.d, ze4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ze4Var.a);
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
                    de4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", rd4.b().j(0));
            jSONObject.put("game_ext_vercode", rd4.b().j(1));
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
            jSONObject.put("swan_vercode", rd4.b().w(0));
            jSONObject.put("game_vercode", rd4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(fh4 fh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fh4Var)) == null) {
            if (fh4Var != null && fh4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (fh4.a aVar : fh4Var.f()) {
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

    public static JSONObject e(hh4 hh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hh4Var)) == null) {
            if (hh4Var != null && hh4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (hh4.a aVar : hh4Var.f()) {
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
                        if (aVar instanceof kh4.b) {
                            kh4.b bVar = (kh4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<kh4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (kh4.a aVar2 : j) {
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

    public static HashMap<String, String> k(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lh4Var)) == null) {
            if (lh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lh4Var.f());
            hashMap.put("category", String.valueOf(lh4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(lh4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(lh4Var.j()));
            hashMap.put("sub_id", lh4Var.k());
            if (!TextUtils.equals(lh4Var.b(), "-1")) {
                hashMap.put("from", lh4Var.b());
            }
            if (TextUtils.isEmpty(lh4Var.i())) {
                lh4Var.m(h(lh4Var.a()));
            }
            if (!TextUtils.isEmpty(lh4Var.i())) {
                hashMap.put("framework_ver", lh4Var.i());
            }
            if (TextUtils.isEmpty(lh4Var.h())) {
                lh4Var.l(g(lh4Var.a()));
            }
            if (!TextUtils.isEmpty(lh4Var.h())) {
                hashMap.put("extension_ver", lh4Var.h());
            }
            long w = rd4.b().w(lh4Var.a());
            long j = rd4.b().j(lh4Var.a());
            if (lh4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (lh4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(lh4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(mh4 mh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mh4Var)) == null) {
            if (mh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(mh4Var.b(), "-1")) {
                hashMap.put("from", mh4Var.b());
            }
            if (!TextUtils.equals(mh4Var.c(), "-1")) {
                hashMap.put("scene", mh4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = rd4.b().v(i);
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
            String J = rd4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ih4 ih4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ih4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ih4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ih4Var.g());
            hashMap.put("category", String.valueOf(ih4Var.a()));
            if (ih4Var.m() == -1) {
                pMSAppInfo = de4.i().u(ih4Var.g());
                if (pMSAppInfo != null && de4.i().o(ff4.class, ih4Var.g()) != null) {
                    ih4Var.u(pMSAppInfo.versionCode);
                } else {
                    ih4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ih4Var.m()));
            if (ih4Var.a() == 0 && ih4Var.m() != -1 && ih4Var.m() != 0) {
                hashMap.put("dep", a(ih4Var.g(), ih4Var.m(), false).toString());
            }
            if (ih4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = de4.i().u(ih4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ih4Var.o(pMSAppInfo.appSign);
                } else {
                    ih4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ih4Var.f()));
            if (ih4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ih4Var.i()));
            }
            String k = ih4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ih4Var.a());
                ih4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = rd4.b().w(ih4Var.a());
            long j = rd4.b().j(ih4Var.a());
            if (ih4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ih4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ih4Var.a());
                ih4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(ih4Var.l())) {
                hashMap.put("path", ih4Var.l());
            }
            if (!TextUtils.equals(ih4Var.b(), "-1")) {
                hashMap.put("from", ih4Var.b());
            }
            if (!TextUtils.equals(ih4Var.c(), "-1")) {
                hashMap.put("scene", ih4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ih4Var.n()));
            hashMap.put("host_env", String.valueOf(rd4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(jh4 jh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jh4Var)) == null) {
            if (jh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jh4Var.f());
            hashMap.put("category", String.valueOf(jh4Var.a()));
            if (TextUtils.isEmpty(jh4Var.h())) {
                jh4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", jh4Var.h());
            if (jh4Var.g() >= 0) {
                hashMap.put("plugin_vercode", jh4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
