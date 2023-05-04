package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Set<kf6> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            HashSet hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(PrefetchEvent.MODULE);
            if (optJSONObject == null) {
                return hashSet;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    String str = null;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("since");
                    if (optJSONObject3 != null) {
                        str = optJSONObject3.optString("android", "");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = com.kuaishou.weapon.p0.q1.e;
                    }
                    kf6 kf6Var = new kf6(next, optJSONObject2.optString("method", "GET"), str);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("headers");
                    if (optJSONObject4 != null) {
                        Iterator<String> keys2 = optJSONObject4.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2)) {
                                kf6Var.a(next2, optJSONObject4.optString(next2));
                            }
                        }
                    }
                    hashSet.add(kf6Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static void b(String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            jf6.c().b();
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            if (mg6.c(jSONArray)) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("url", "");
                    if (!TextUtils.isEmpty(optString)) {
                        Set<kf6> a = a(optJSONObject);
                        if6 if6Var = new if6();
                        if (!mg6.a(a)) {
                            if6Var.a = a;
                            if6Var.d = optString;
                            jf6.c().a(optString, if6Var);
                        } else {
                            jf6.c().a(optString, if6Var);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public static List<Pair<String, Long>> c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            wg6 wg6Var = (wg6) ServiceManager.getService(wg6.a);
            if (wg6Var != null && URLUtil.isNetworkUrl(str)) {
                return wg6Var.a(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
