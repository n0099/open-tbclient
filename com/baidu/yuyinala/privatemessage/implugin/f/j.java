package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oUE;
    private static int oUF;
    private static int oUG;
    private static int oUH = -1;

    public static void Yk(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oUH = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oUH == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oUE = mData.optString("third_id");
                    oUF = mData.optInt("has_sub");
                    oUG = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void OH() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", oUE);
                jSONObject.put("has_sub", "" + oUF);
                jSONObject.put("notify", "" + oUG);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Yl("type") ? mType : "";
    }

    public static void Av(boolean z) {
        oUF = z ? 1 : 0;
        OH();
    }

    public static boolean elr() {
        return Yl("has_sub") && oUF == 1;
    }

    public static String elq() {
        return Yl("third_id") ? oUE : "";
    }

    public static boolean isNeedNotify() {
        return Yl("notify") && oUG == 1;
    }

    private static boolean isDataValid() {
        return oUH == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Yl(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
