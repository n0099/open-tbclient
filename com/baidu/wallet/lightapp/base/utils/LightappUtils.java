package com.baidu.wallet.lightapp.base.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.router.RouterCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class LightappUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LightappUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String assembleFailResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
            return assembleResult((Map<String, Object>) hashMap, false);
        }
        return (String) invokeL.objValue;
    }

    public static String assembleFailResultWithErrCode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RouterCallback.KEY_ERROR_CODE, str);
            hashMap.put("des", str2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("data", hashMap.toString());
            return assembleResult((Map<String, Object>) hashMap2, false);
        }
        return (String) invokeLL.objValue;
    }

    public static String assembleResult(Map<String, Object> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, map, z)) == null) {
            if (map == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put("cnt", new JSONObject(map));
            } catch (JSONException e2) {
                LogUtil.e("LightappUtils", "error", e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String formatJSONForWebViewCallback(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                    str = str.replaceAll("\\\\", "\\\\\\\\");
                }
                if (str.contains("'")) {
                    str = str.replaceAll("'", "\\\\'");
                }
                if (str.contains("\"")) {
                    str = str.replaceAll("\"", "\\\\\"");
                }
                if (str.contains(Part.CRLF)) {
                    str = str.replaceAll(Part.CRLF, "\\u000d\\u000a");
                }
                if (str.contains("\n")) {
                    str = str.replaceAll("\n", "\\u000a");
                }
                com.baidu.apollon.utils.LogUtil.d(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, iLightappInvokerCallback, str, str2, str3, str4) == null) {
            if (iLightappInvokerCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(RouterCallback.KEY_ERROR_CODE, str2);
                hashMap.put("des", str3);
                iLightappInvokerCallback.onResult(1, assembleResult((Map<String, Object>) hashMap, false));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str));
            arrayList.add(str3);
            PayStatisticsUtil.onEventWithValues(str4, arrayList);
        }
    }

    public static int parseJsonInt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(new JSONObject(str).getString(str2));
                } catch (JSONException e2) {
                    com.baidu.apollon.utils.LogUtil.d("LightappUtils", e2.getMessage());
                } catch (Throwable th) {
                    com.baidu.apollon.utils.LogUtil.d("LightappUtils", th.getMessage());
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static String assembleResult(int i2, JSONObject jSONObject) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", i2);
                jSONObject2.put("cnt", jSONObject);
            } catch (JSONException e2) {
                LogUtil.e("LightappUtils", "error", e2);
            }
            return jSONObject2.toString();
        }
        return (String) invokeIL.objValue;
    }

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, iLightappInvokerCallback, str, str2, str3, collection) == null) {
            if (iLightappInvokerCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(RouterCallback.KEY_ERROR_CODE, str);
                hashMap.put("des", str2);
                iLightappInvokerCallback.onResult(1, assembleResult((Map<String, Object>) hashMap, false));
            }
            PayStatisticsUtil.onEventWithValues(str3, collection);
        }
    }
}
