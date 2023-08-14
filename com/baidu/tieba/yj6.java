package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static vj6 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            File m = rj6.n().m();
            File file = new File(m, str + "/" + str2);
            if (!file.exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            Map<String, ak6> b = b(file);
            if (!f(file, b)) {
                return null;
            }
            return new vj6(file, str2, b);
        }
        return (vj6) invokeLL.objValue;
    }

    public static Map<String, ak6> b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            File file2 = new File(file, "router.json");
            if (!file2.exists()) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(hl6.d(file2));
                Map<String, ak6> d = d(jSONObject.optJSONObject("config"));
                Map<String, ak6> d2 = d(jSONObject.optJSONObject("proxyConfig"));
                if (!fl6.b(d2)) {
                    d.putAll(d2);
                }
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static Set<String> c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            HashSet hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data_urls");
            if (!fl6.c(optJSONArray)) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i, ""));
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0048 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    public static Map<String, ak6> d(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            HashMap hashMap = new HashMap();
            if (jSONObject == null) {
                return hashMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !hashMap.containsKey(next)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        String optString = jSONObject2.optString("module", "");
                        String optString2 = jSONObject2.optString("path", "");
                        ?? optInt = jSONObject2.optInt("proxyMode", 0);
                        if (jSONObject2.has("proxySwitch") && (optJSONObject = jSONObject2.optJSONObject("proxySwitch")) != null) {
                            optInt = ml6.a(optJSONObject.optString("android", ""), TbConfig.getVersion());
                        }
                        ak6 ak6Var = new ak6();
                        if (jSONObject2.optInt("proxyMode", 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ak6Var.i = z;
                        if (optInt == 1) {
                            ak6Var.h = true;
                            ak6Var.a = kk6.a(jSONObject2);
                        } else {
                            ak6Var.h = false;
                            ak6Var.b = c(jSONObject2);
                        }
                        ak6Var.c = optString;
                        ak6Var.d = optString2;
                        ak6Var.f = e(next, jSONObject2);
                        hashMap.put(next, ak6Var);
                        lw9.a().j(next, next);
                        lw9.a().k(next, optString2);
                    } catch (JSONException unused) {
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Set<String> e(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject)) == null) {
            HashSet<String> hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("source");
            if (!fl6.c(optJSONArray)) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i, ""));
                }
            }
            String optString = jSONObject.optString("staticPrePath", "");
            for (String str2 : hashSet) {
                if (!TextUtils.isEmpty(str2)) {
                    lw9 a = lw9.a();
                    a.j(optString + "/" + str2, str);
                    lw9 a2 = lw9.a();
                    a2.k(optString + "/" + str2, str2);
                }
            }
            return hashSet;
        }
        return (Set) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[Catch: Exception -> 0x00e0, TryCatch #0 {Exception -> 0x00e0, blocks: (B:12:0x0023, B:15:0x002e, B:18:0x003c, B:21:0x0045, B:22:0x0052, B:24:0x0058, B:25:0x008e, B:27:0x0094, B:29:0x00a2, B:30:0x00ae, B:32:0x00ba, B:34:0x00c0), top: B:44:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(File file, Map<String, ak6> map) {
        InterceptResult invokeLL;
        String d;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, file, map)) == null) {
            File file2 = new File(file, "staticSources.json");
            if (fl6.b(map) || !file2.exists() || !file2.isFile()) {
                return false;
            }
            try {
                d = hl6.d(file2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(d)) {
                return false;
            }
            JSONObject optJSONObject2 = new JSONObject(d).optJSONObject("sources");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(SmsLoginView.f.j)) == null) {
                return true;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ak6> entry : map.entrySet()) {
                ak6 value = entry.getValue();
                HashSet<String> hashSet = new HashSet(value.f);
                hashSet.add(value.d);
                Log.e("newHybrid", "-------------------------：" + entry.getKey());
                for (String str : hashSet) {
                    String str2 = (String) hashMap.get(str);
                    if (str2 == null) {
                        str2 = gl6.b(new File(file, str));
                        hashMap.put(str, str2);
                    }
                    String optString = optJSONObject.optString(str, "");
                    if (TextUtils.isEmpty(optString) || !optString.equalsIgnoreCase(str2)) {
                        Log.e("newHybrid", str + "," + optString + "_" + str2);
                        return false;
                    }
                    while (r5.hasNext()) {
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
