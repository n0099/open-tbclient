package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String ozm;
    private static int ozn;
    private static int ozo;
    private static int ozp = -1;

    public static void Xg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ozp = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (ozp == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    ozm = mData.optString("third_id");
                    ozn = mData.optInt("has_sub");
                    ozo = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void bgA() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", ozm);
                jSONObject.put("has_sub", "" + ozn);
                jSONObject.put("notify", "" + ozo);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Xh("type") ? mType : "";
    }

    public static void zR(boolean z) {
        ozn = z ? 1 : 0;
        bgA();
    }

    public static boolean isSubscribed() {
        return Xh("has_sub") && ozn == 1;
    }

    public static String efx() {
        return Xh("third_id") ? ozm : "";
    }

    public static boolean isNeedNotify() {
        return Xh("notify") && ozo == 1;
    }

    private static boolean isDataValid() {
        return ozp == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Xh(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
