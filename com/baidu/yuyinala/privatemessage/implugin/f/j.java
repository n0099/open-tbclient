package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String paP;
    private static int paQ;
    private static int paR;
    private static int paS = -1;

    public static void Yq(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            paS = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (paS == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    paP = mData.optString("third_id");
                    paQ = mData.optInt("has_sub");
                    paR = mData.optInt("notify");
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
                jSONObject.put("third_id", paP);
                jSONObject.put("has_sub", "" + paQ);
                jSONObject.put("notify", "" + paR);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Yr("type") ? mType : "";
    }

    public static void AK(boolean z) {
        paQ = z ? 1 : 0;
        Mk();
    }

    public static boolean ejZ() {
        return Yr("has_sub") && paQ == 1;
    }

    public static String ejY() {
        return Yr("third_id") ? paP : "";
    }

    public static boolean isNeedNotify() {
        return Yr("notify") && paR == 1;
    }

    private static boolean isDataValid() {
        return paS == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Yr(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
