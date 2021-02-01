package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String pao;
    private static int pap;
    private static int paq;
    private static int par = -1;

    public static void Ye(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            par = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (par == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    pao = mData.optString("third_id");
                    pap = mData.optInt("has_sub");
                    paq = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void Mk() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", pao);
                jSONObject.put("has_sub", "" + pap);
                jSONObject.put("notify", "" + paq);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Yf("type") ? mType : "";
    }

    public static void AK(boolean z) {
        pap = z ? 1 : 0;
        Mk();
    }

    public static boolean ejR() {
        return Yf("has_sub") && pap == 1;
    }

    public static String ejQ() {
        return Yf("third_id") ? pao : "";
    }

    public static boolean isNeedNotify() {
        return Yf("notify") && paq == 1;
    }

    private static boolean isDataValid() {
        return par == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Yf(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
