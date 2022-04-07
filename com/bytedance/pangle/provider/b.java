package com.bytedance.pangle.provider;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, Uri uri) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, uri)) == null) {
            if (str2 == null || TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                jSONObject.put(ContentProviderManager.PLUGIN_PKG_NAME, str2);
                jSONObject.put("uri", uri != null ? uri.toString() : "");
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
