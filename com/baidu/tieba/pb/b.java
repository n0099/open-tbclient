package com.baidu.tieba.pb;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a {
        public static String hFW = "c12585";
        public static String hFX = "c12586";
    }

    public static CustomDialogData cn(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("tb_hudong")) == null || TextUtils.isEmpty(optJSONObject.optString("content"))) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(Uri.decode(optJSONObject.optString("content")));
            if (jSONObject2 != null) {
                return CustomDialogData.praseJSON(jSONObject2);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
