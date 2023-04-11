package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialOperation;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070647, "Lcom/baidu/tieba/r33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070647, "Lcom/baidu/tieba/r33;");
                return;
            }
        }
        a = eo1.a;
    }

    public static String a(String str, long j, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2})) == null) {
            u73 M = u73.M();
            if (M == null) {
                str3 = "";
            } else {
                str3 = wz1.a(M.O());
            }
            String[] strArr = {str3, str, String.valueOf(j), str2};
            Arrays.sort(strArr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(strArr[i]);
            }
            try {
                return mk3.c("SHA-1", sb.toString().getBytes(), false);
            } catch (NoSuchAlgorithmException e) {
                if (!a) {
                    return "";
                }
                Log.e("SwanPluginHostSign", "getSignature occurs exception:", e);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean c(String str, String str2, vg4 vg4Var) {
        InterceptResult invokeLLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, vg4Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && vg4Var != null) {
                String str3 = vg4Var.q;
                if (TextUtils.isEmpty(str3)) {
                    return false;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str);
                    if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return l83.b(new URI(str2).getHost(), arrayList);
                } catch (URISyntaxException | JSONException e) {
                    m33.b(Log.getStackTraceString(e));
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String b(vg4 vg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vg4Var)) == null) {
            if (vg4Var == null) {
                return "";
            }
            String str = vg4Var.p;
            JSONObject jSONObject = new JSONObject();
            String uuid = UUID.randomUUID().toString();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                jSONObject.put("noncestr", uuid);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put(SocialOperation.GAME_SIGNATURE, a(uuid, currentTimeMillis, str));
            } catch (JSONException e) {
                m33.b(Log.getStackTraceString(e));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
