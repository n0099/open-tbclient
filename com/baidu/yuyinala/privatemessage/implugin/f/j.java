package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oOu;
    private static int oOv;
    private static int oOw;
    private static int oOx = -1;

    public static void YB(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oOx = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oOx == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oOu = mData.optString("third_id");
                    oOv = mData.optInt("has_sub");
                    oOw = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void bjF() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", oOu);
                jSONObject.put("has_sub", "" + oOv);
                jSONObject.put("notify", "" + oOw);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return YC("type") ? mType : "";
    }

    public static void Av(boolean z) {
        oOv = z ? 1 : 0;
        bjF();
    }

    public static boolean elm() {
        return YC("has_sub") && oOv == 1;
    }

    public static String ell() {
        return YC("third_id") ? oOu : "";
    }

    public static boolean isNeedNotify() {
        return YC("notify") && oOw == 1;
    }

    private static boolean isDataValid() {
        return oOx == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean YC(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
