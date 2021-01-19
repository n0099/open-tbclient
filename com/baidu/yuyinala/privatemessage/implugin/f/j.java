package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oQd;
    private static int oQe;
    private static int oQf;
    private static int oQg = -1;

    public static void Xd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oQg = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oQg == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oQd = mData.optString("third_id");
                    oQe = mData.optInt("has_sub");
                    oQf = mData.optInt("notify");
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
                jSONObject.put("third_id", oQd);
                jSONObject.put("has_sub", "" + oQe);
                jSONObject.put("notify", "" + oQf);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Xe("type") ? mType : "";
    }

    public static void Ar(boolean z) {
        oQe = z ? 1 : 0;
        KM();
    }

    public static boolean ehx() {
        return Xe("has_sub") && oQe == 1;
    }

    public static String ehw() {
        return Xe("third_id") ? oQd : "";
    }

    public static boolean isNeedNotify() {
        return Xe("notify") && oQf == 1;
    }

    private static boolean isDataValid() {
        return oQg == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Xe(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
