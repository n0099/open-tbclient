package com.baidu.wallet.lightapp.base.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.CheckUtils;
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
    public static String assembleFailResult(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
        return assembleResult((Map<String, Object>) hashMap, false);
    }

    public static String assembleFailResultWithErrCode(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(RouterCallback.KEY_ERROR_CODE, str);
        hashMap.put("des", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("data", hashMap.toString());
        return assembleResult((Map<String, Object>) hashMap2, false);
    }

    public static String assembleResult(Map<String, Object> map, boolean z) {
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

    public static String formatJSONForWebViewCallback(String str) {
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

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, String str4) {
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

    public static int parseJsonInt(String str, String str2) {
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

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static String assembleResult(int i2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", i2);
            jSONObject2.put("cnt", jSONObject);
        } catch (JSONException e2) {
            LogUtil.e("LightappUtils", "error", e2);
        }
        return jSONObject2.toString();
    }

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, Collection<String> collection) {
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RouterCallback.KEY_ERROR_CODE, str);
            hashMap.put("des", str2);
            iLightappInvokerCallback.onResult(1, assembleResult((Map<String, Object>) hashMap, false));
        }
        PayStatisticsUtil.onEventWithValues(str3, collection);
    }
}
