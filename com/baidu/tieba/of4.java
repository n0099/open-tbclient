package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.jh4;
import com.baidu.tieba.lh4;
import com.baidu.tieba.oh4;
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
public class of4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<df4> l = vd4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (df4 df4Var : l) {
                        if (df4Var.b) {
                            j2 = df4Var.c;
                        } else {
                            lf4 b = qj4.b(df4Var.a, df4Var.d, df4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", df4Var.a);
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
                    he4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", vd4.b().j(0));
            jSONObject.put("game_ext_vercode", vd4.b().j(1));
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
            jSONObject.put("swan_vercode", vd4.b().w(0));
            jSONObject.put("game_vercode", vd4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(jh4 jh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jh4Var)) == null) {
            if (jh4Var != null && jh4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (jh4.a aVar : jh4Var.f()) {
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

    public static JSONObject e(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lh4Var)) == null) {
            if (lh4Var != null && lh4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (lh4.a aVar : lh4Var.f()) {
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
                        if (aVar instanceof oh4.b) {
                            oh4.b bVar = (oh4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<oh4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (oh4.a aVar2 : j) {
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

    public static HashMap<String, String> k(ph4 ph4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ph4Var)) == null) {
            if (ph4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ph4Var.f());
            hashMap.put("category", String.valueOf(ph4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(ph4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(ph4Var.j()));
            hashMap.put("sub_id", ph4Var.k());
            if (!TextUtils.equals(ph4Var.b(), "-1")) {
                hashMap.put("from", ph4Var.b());
            }
            if (TextUtils.isEmpty(ph4Var.i())) {
                ph4Var.m(h(ph4Var.a()));
            }
            if (!TextUtils.isEmpty(ph4Var.i())) {
                hashMap.put("framework_ver", ph4Var.i());
            }
            if (TextUtils.isEmpty(ph4Var.h())) {
                ph4Var.l(g(ph4Var.a()));
            }
            if (!TextUtils.isEmpty(ph4Var.h())) {
                hashMap.put("extension_ver", ph4Var.h());
            }
            long w = vd4.b().w(ph4Var.a());
            long j = vd4.b().j(ph4Var.a());
            if (ph4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (ph4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ph4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(qh4 qh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, qh4Var)) == null) {
            if (qh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(qh4Var.b(), "-1")) {
                hashMap.put("from", qh4Var.b());
            }
            if (!TextUtils.equals(qh4Var.c(), "-1")) {
                hashMap.put("scene", qh4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = vd4.b().v(i);
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
            String J = vd4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(mh4 mh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mh4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (mh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", mh4Var.g());
            hashMap.put("category", String.valueOf(mh4Var.a()));
            if (mh4Var.m() == -1) {
                pMSAppInfo = he4.i().u(mh4Var.g());
                if (pMSAppInfo != null && he4.i().o(jf4.class, mh4Var.g()) != null) {
                    mh4Var.u(pMSAppInfo.versionCode);
                } else {
                    mh4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(mh4Var.m()));
            if (mh4Var.a() == 0 && mh4Var.m() != -1 && mh4Var.m() != 0) {
                hashMap.put("dep", a(mh4Var.g(), mh4Var.m(), false).toString());
            }
            if (mh4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = he4.i().u(mh4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    mh4Var.o(pMSAppInfo.appSign);
                } else {
                    mh4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(mh4Var.f()));
            if (mh4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(mh4Var.i()));
            }
            String k = mh4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(mh4Var.a());
                mh4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = vd4.b().w(mh4Var.a());
            long j = vd4.b().j(mh4Var.a());
            if (mh4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = mh4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(mh4Var.a());
                mh4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(mh4Var.l())) {
                hashMap.put("path", mh4Var.l());
            }
            if (!TextUtils.equals(mh4Var.b(), "-1")) {
                hashMap.put("from", mh4Var.b());
            }
            if (!TextUtils.equals(mh4Var.c(), "-1")) {
                hashMap.put("scene", mh4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(mh4Var.n()));
            hashMap.put("host_env", String.valueOf(vd4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(nh4 nh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, nh4Var)) == null) {
            if (nh4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", nh4Var.f());
            hashMap.put("category", String.valueOf(nh4Var.a()));
            if (TextUtils.isEmpty(nh4Var.h())) {
                nh4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", nh4Var.h());
            if (nh4Var.g() >= 0) {
                hashMap.put("plugin_vercode", nh4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
