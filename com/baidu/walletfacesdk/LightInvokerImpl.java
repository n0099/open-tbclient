package com.baidu.walletfacesdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.walletfacesdk.LivenessManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LightInvokerImpl {
    public static final String CALL_NATIVE_VOICE = "callNativeVoice";
    public static String KEY_PASS_APIKEY = "itokhjnkuc58d3bzfh0il2uo89pdppyy";
    public static String KEY_PASS_TPL = "baiduwalletapp";
    public static final String LIVENESSSERVICE_ID = "livenessServiceId";
    public static final String LIVENESS_SERVIVETYPE = "serviceType";
    public static final String LIVENESS_SHOW_GUIDE_PAGE = "showGuidePage";
    public static final String METHOD_NAME = "method_name";
    public static final String RANDOM_ACTION = "randomAction";
    public static final String RECORD_VIDEO = "recordVideo";
    public static final String SP_PARAMS = "spParams";
    public static final String START_IDENTIFY = "startIdentify";
    public static final String STOKEN_KEY = "stoken";
    public static final String SWITCH_VIDEO = "switchVideo";
    public static final String TAG = "LightInvokerImpl";
    public static final String VOICE_ACTIONTYPE = "actionType";
    public static final String VOICE_BARSTYLE = "barStyle";
    public static final String VOICE_PRODUCTID = "productId";

    /* loaded from: classes5.dex */
    public interface IResultListener {
        void onResult(int i, JSONObject jSONObject);
    }

    public static String assembleResult(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", i);
            jSONObject2.put("cnt", jSONObject);
        } catch (JSONException e2) {
            Log.e(TAG, "error", e2);
        }
        return jSONObject2.toString();
    }

    public static void callNativeVoice(Context context, String str, boolean z, final IResultListener iResultListener) {
        JSONObject jSONObject;
        final JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage());
            jSONObject = null;
        }
        if (!jSONObject.has(START_IDENTIFY)) {
            try {
                jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 103);
                jSONObject2.put("des", PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                iResultListener.onResult(1, jSONObject2);
                return;
            } catch (Exception e3) {
                Log.e(TAG, "error", e3);
                return;
            }
        }
        try {
            jSONObject3 = new JSONObject(jSONObject.optString(START_IDENTIFY));
        } catch (Exception e4) {
            Log.e(TAG, e4.getMessage());
        }
        if (jSONObject3.has(VOICE_ACTIONTYPE)) {
            if (!(!TextUtils.isEmpty(jSONObject3.optString(VOICE_ACTIONTYPE)) ? jSONObject3.optString(VOICE_ACTIONTYPE) : "").equals("2")) {
                try {
                    jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 103);
                    jSONObject2.put("des", PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    iResultListener.onResult(1, jSONObject2);
                    return;
                } catch (Exception e5) {
                    Log.e(TAG, "error", e5);
                    return;
                }
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("stoken", jSONObject.optString("stoken"));
        String optString = !TextUtils.isEmpty(jSONObject3.optString("productId")) ? jSONObject3.optString("productId") : "default";
        hashMap.put(LIVENESS_SERVIVETYPE, !TextUtils.isEmpty(jSONObject3.optString(LIVENESS_SERVIVETYPE)) ? jSONObject3.optString(LIVENESS_SERVIVETYPE) : "1008");
        if (!jSONObject3.has(LIVENESS_SHOW_GUIDE_PAGE) || TextUtils.isEmpty(jSONObject3.optString(LIVENESS_SHOW_GUIDE_PAGE))) {
            hashMap.put(LIVENESS_SHOW_GUIDE_PAGE, (!TextUtils.isEmpty(jSONObject3.optString(VOICE_BARSTYLE)) ? jSONObject3.optString(VOICE_BARSTYLE) : "0").equals("1") ^ true ? "1" : "0");
        } else {
            hashMap.put(LIVENESS_SHOW_GUIDE_PAGE, jSONObject3.optString(LIVENESS_SHOW_GUIDE_PAGE));
        }
        String optString2 = jSONObject3.optString(LIVENESSSERVICE_ID);
        String optString3 = jSONObject3.optString(SP_PARAMS);
        if (!TextUtils.isEmpty(optString2)) {
            hashMap.put(LIVENESSSERVICE_ID, optString2);
        }
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put(SP_PARAMS, optString3);
        }
        if (!TextUtils.isEmpty(jSONObject3.optString(RANDOM_ACTION))) {
            hashMap.put(RANDOM_ACTION, jSONObject3.optString(RANDOM_ACTION));
        }
        if (!TextUtils.isEmpty(jSONObject3.optString(SWITCH_VIDEO))) {
            hashMap.put(SWITCH_VIDEO, jSONObject3.optString(SWITCH_VIDEO));
        }
        if (!TextUtils.isEmpty(jSONObject3.optString(RECORD_VIDEO))) {
            hashMap.put(RECORD_VIDEO, jSONObject3.optString(RECORD_VIDEO));
        }
        new LivenessManager(context, z, optString).livenessRecognize(hashMap, new LivenessManager.IvoiceListener() { // from class: com.baidu.walletfacesdk.LightInvokerImpl.2
            @Override // com.baidu.walletfacesdk.LivenessManager.IvoiceListener
            public void onResult(int i, int i2, String str2, Object obj) {
                if (obj != null) {
                    try {
                        jSONObject2.put("data", obj);
                    } catch (Exception e6) {
                        Log.e(LightInvokerImpl.TAG, "error", e6);
                        return;
                    }
                }
                jSONObject2.put(RouterCallback.KEY_ERROR_CODE, i2);
                jSONObject2.put("des", str2);
                iResultListener.onResult(i, jSONObject2);
            }
        });
    }

    public static void invokeBdWalletNative(Context context, String str, boolean z, final LightInvokerCallback lightInvokerCallback) {
        if (context == null || str == null || lightInvokerCallback == null) {
            return;
        }
        try {
            if (new JSONObject(str).optString("method_name").equalsIgnoreCase("callNativeVoice")) {
                callNativeVoice(context, str, z, new IResultListener() { // from class: com.baidu.walletfacesdk.LightInvokerImpl.1
                    @Override // com.baidu.walletfacesdk.LightInvokerImpl.IResultListener
                    public void onResult(int i, JSONObject jSONObject) {
                        if (jSONObject != null) {
                            LightInvokerCallback.this.onResult(i, LightInvokerImpl.assembleResult(i, jSONObject));
                        }
                    }
                });
            }
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage());
        }
    }

    public static void setProduct(String str, String str2) {
        KEY_PASS_TPL = str;
        KEY_PASS_APIKEY = str2;
    }
}
