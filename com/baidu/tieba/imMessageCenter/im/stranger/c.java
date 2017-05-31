package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public static class a {
        public String dlA;
        public String dlB;
        public int dlC;
        public String dlD;
        public String dlE;
        public String dlF;
        public String dlb;
        public String dly;
        public int dlz;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a lt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.dlA = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.dlb = optJSONObject.optString("content");
                aVar.dlD = optJSONObject.optString("quote_content");
                aVar.dlF = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.dlB = optJSONObject2.optString("id");
                    aVar.dlE = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.dlC = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.dly = optJSONObject3.optString("id");
                    aVar.dlz = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
