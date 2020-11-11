package com.baidu.yuyinala.privatemessage.implugin.f;

import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private static JSONObject mData;
    private static String mType;
    private static String oxI;
    private static int oxJ;
    private static int oxK;
    private static int oxL = -1;

    public static void Xv(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            oxL = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            if (oxL == 0) {
                mData = jSONObject.optJSONObject("data");
                if (mData != null) {
                    mType = mData.optString("type");
                    oxI = mData.optString("third_id");
                    oxJ = mData.optInt("has_sub");
                    oxK = mData.optInt("notify");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void bhh() {
        if (mData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mType);
                jSONObject.put("third_id", oxI);
                jSONObject.put("has_sub", "" + oxJ);
                jSONObject.put("notify", "" + oxK);
                mData = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getType() {
        return Xw("type") ? mType : "";
    }

    public static void zK(boolean z) {
        oxJ = z ? 1 : 0;
        bhh();
    }

    public static boolean isSubscribed() {
        return Xw("has_sub") && oxJ == 1;
    }

    public static String efz() {
        return Xw("third_id") ? oxI : "";
    }

    public static boolean isNeedNotify() {
        return Xw("notify") && oxK == 1;
    }

    private static boolean isDataValid() {
        return oxL == 0;
    }

    public static JSONObject getData() {
        if (isDataValid()) {
            return mData;
        }
        return null;
    }

    private static boolean Xw(String str) {
        return isDataValid() && mData != null && mData.has(str);
    }
}
