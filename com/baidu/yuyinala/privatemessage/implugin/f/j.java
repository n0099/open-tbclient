package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oQc;
    private static int oQd;
    private static int oQe;
    private static int oQf = -1;

    public static void Xc(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oQf = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oQf == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oQc = mData.optString("third_id");
                    oQd = mData.optInt("has_sub");
                    oQe = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void KM() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", oQc);
                jSONObject.put("has_sub", "" + oQd);
                jSONObject.put("notify", "" + oQe);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Xd("type") ? mType : "";
    }

    public static void Ar(boolean z) {
        oQd = z ? 1 : 0;
        KM();
    }

    public static boolean ehx() {
        return Xd("has_sub") && oQd == 1;
    }

    public static String ehw() {
        return Xd("third_id") ? oQc : "";
    }

    public static boolean isNeedNotify() {
        return Xd("notify") && oQe == 1;
    }

    private static boolean isDataValid() {
        return oQf == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Xd(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
