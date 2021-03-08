package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String pcV;
    private static int pcW;
    private static int pcX;
    private static int pcY = -1;

    public static void Yx(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            pcY = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (pcY == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    pcV = mData.optString("third_id");
                    pcW = mData.optInt("has_sub");
                    pcX = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void Mn() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", pcV);
                jSONObject.put("has_sub", "" + pcW);
                jSONObject.put("notify", "" + pcX);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Yy("type") ? mType : "";
    }

    public static void AJ(boolean z) {
        pcW = z ? 1 : 0;
        Mn();
    }

    public static boolean ekj() {
        return Yy("has_sub") && pcW == 1;
    }

    public static String eki() {
        return Yy("third_id") ? pcV : "";
    }

    public static boolean isNeedNotify() {
        return Yy("notify") && pcX == 1;
    }

    private static boolean isDataValid() {
        return pcY == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Yy(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
