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
        public String dsX;
        public String dtA;
        public String dtB;
        public String dtu;
        public int dtv;
        public String dtw;
        public String dtx;
        public int dty;
        public String dtz;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a mq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.dtw = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.dsX = optJSONObject.optString("content");
                aVar.dtz = optJSONObject.optString("quote_content");
                aVar.dtB = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.dtx = optJSONObject2.optString("id");
                    aVar.dtA = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.dty = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.dtu = optJSONObject3.optString("id");
                    aVar.dtv = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
