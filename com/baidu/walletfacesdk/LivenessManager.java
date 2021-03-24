package com.baidu.walletfacesdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessManager {
    public Context mContext;
    public String mPassProductId;

    /* loaded from: classes5.dex */
    public interface IvoiceListener {
        public static final int RESULT_FAIL = 1;
        public static final int RESULT_SUCC = 0;

        void onResult(int i, int i2, String str, Object obj);
    }

    public LivenessManager(Context context, boolean z, String str) {
        this.mContext = context;
        this.mPassProductId = str;
    }

    public void livenessRecognize(Map map, final IvoiceListener ivoiceListener) {
        if (map != null && map.containsKey("stoken") && TextUtils.isEmpty((String) map.get("stoken"))) {
            PayStatisticsUtil.onEvent("wallet_face_stoken_empty", "1");
        }
        PASSMethodCallTransfer pASSMethodCallTransfer = new PASSMethodCallTransfer();
        PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "bduss");
        hashMap.put("supPro", this.mPassProductId);
        hashMap.putAll(map);
        paramsWap.param = hashMap;
        HashMap hashMap2 = new HashMap();
        paramsWap.attributes = hashMap2;
        hashMap2.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
        paramsWap.attributes.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
        pASSMethodCallTransfer.dynamicCallMethod(BaiduRIM.getInstance(), new Object[]{this.mContext, paramsWap, new RimServiceCallback() { // from class: com.baidu.walletfacesdk.LivenessManager.1
            @Override // com.baidu.fsg.api.RimServiceCallback
            public void onResult(int i, Map<String, Object> map2) {
                IvoiceListener ivoiceListener2;
                if (i == 0) {
                    IvoiceListener ivoiceListener3 = ivoiceListener;
                    if (ivoiceListener3 != null) {
                        ivoiceListener3.onResult(0, 0, "ok", LivenessManager.this.toJSONObject(map2));
                    }
                } else if (map2 == null || (ivoiceListener2 = ivoiceListener) == null) {
                } else {
                    ivoiceListener2.onResult(1, ((Integer) map2.get(BaiduRimConstants.RETCODE_KEY)).intValue(), (String) map2.get("retMsg"), null);
                }
            }
        }}, "accessRimService", new PASSMethodCallTransfer.DynamicCallbak() { // from class: com.baidu.walletfacesdk.LivenessManager.2
            @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
            public void onFailure(int i, String str) {
                int i2;
                String str2;
                PayStatisticsUtil.onEventWithValue("callNativeVoiceTransferFail", String.valueOf(i));
                if (i == -1001) {
                    i2 = 101;
                    str2 = "请重新登录！";
                } else if (i == -1003) {
                    i2 = 10001;
                    str2 = "参数非法";
                } else {
                    i2 = 10003;
                    str2 = "内部错误";
                }
                ivoiceListener.onResult(1, i2, str2, null);
            }
        }, Context.class, Map.class, RimServiceCallback.class);
    }

    public JSONObject toJSONObject(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject(map);
        try {
            jSONObject.put("result", new JSONObject((String) map.get("result")));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
