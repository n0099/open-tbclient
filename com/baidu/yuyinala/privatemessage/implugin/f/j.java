package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oOs;
    private static int oOt;
    private static int oOu;
    private static int oOv = -1;

    public static void YB(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oOv = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oOv == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oOs = mData.optString("third_id");
                    oOt = mData.optInt("has_sub");
                    oOu = mData.optInt("notify");
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
                jSONObject.put("third_id", oOs);
                jSONObject.put("has_sub", "" + oOt);
                jSONObject.put("notify", "" + oOu);
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
        oOt = z ? 1 : 0;
        bjF();
    }

    public static boolean ell() {
        return YC("has_sub") && oOt == 1;
    }

    public static String elk() {
        return YC("third_id") ? oOs : "";
    }

    public static boolean isNeedNotify() {
        return YC("notify") && oOu == 1;
    }

    private static boolean isDataValid() {
        return oOv == 0;
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
