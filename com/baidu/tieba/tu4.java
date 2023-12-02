package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, webView)) == null) {
            if (webView == null) {
                return BdActivityStack.getInst().currentActivity();
            }
            Activity a = fj6.a(webView.getContext());
            if (a == null) {
                a = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            if (a == null) {
                a = BdActivityStack.getInst().currentActivity();
            }
            if (a == null) {
                return webView.getContext();
            }
            return a;
        }
        return (Context) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && str.startsWith(cs4.a)) {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        return str;
                    }
                    String queryParameter = parse.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        return queryParameter;
                    }
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static Bitmap b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            if (bitmap == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static HashMap<String, Boolean> e(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("blockList");
            HashMap<String, Boolean> hashMap = new HashMap<>();
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        Object opt = optJSONObject.opt(next);
                        if (opt instanceof String) {
                            hashMap.put(next, Boolean.valueOf("1".equals(opt)));
                        } else {
                            hashMap.put(next, Boolean.FALSE);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @NonNull
    public static String f(@NonNull JSONObject jSONObject, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            return jSONObject.optString(str);
        }
        return (String) invokeLL.objValue;
    }
}
