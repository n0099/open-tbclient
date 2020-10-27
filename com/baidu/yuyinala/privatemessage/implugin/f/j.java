package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oon;
    private static int ooo;
    private static int oop;
    private static int ooq = -1;

    public static void WR(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ooq = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (ooq == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oon = mData.optString("third_id");
                    ooo = mData.optInt("has_sub");
                    oop = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void beH() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", oon);
                jSONObject.put("has_sub", "" + ooo);
                jSONObject.put("notify", "" + oop);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return WS("type") ? mType : "";
    }

    public static void zz(boolean z) {
        ooo = z ? 1 : 0;
        beH();
    }

    public static boolean isSubscribed() {
        return WS("has_sub") && ooo == 1;
    }

    public static String ebK() {
        return WS("third_id") ? oon : "";
    }

    public static boolean isNeedNotify() {
        return WS("notify") && oop == 1;
    }

    private static boolean isDataValid() {
        return ooq == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean WS(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
