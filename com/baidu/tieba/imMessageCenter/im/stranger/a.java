package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a {
        public String atF;
        public String dIB;
        public String dIY;
        public int dIZ;
        public String dJa;
        public String dJb;
        public int dJc;
        public String dJd;
        public String dJe;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0103a mR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0103a c0103a = new C0103a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0103a.dJa = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0103a.dIB = optJSONObject.optString("content");
                c0103a.dJd = optJSONObject.optString("quote_content");
                c0103a.atF = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0103a.threadId = optJSONObject.optString("thread_id");
                c0103a.postId = optJSONObject.optString("post_id");
                c0103a.type = optJSONObject.optInt("type");
                c0103a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0103a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0103a.dJb = optJSONObject2.optString("id");
                    c0103a.dJe = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0103a.dJc = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0103a.dIY = optJSONObject3.optString("id");
                    c0103a.dIZ = optJSONObject3.optInt("gender");
                }
            }
            return c0103a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
