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
        public String att;
        public String dIK;
        public int dIL;
        public String dIM;
        public String dIN;
        public int dIO;
        public String dIP;
        public String dIQ;
        public String dIn;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0103a mQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0103a c0103a = new C0103a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0103a.dIM = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0103a.dIn = optJSONObject.optString("content");
                c0103a.dIP = optJSONObject.optString("quote_content");
                c0103a.att = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0103a.threadId = optJSONObject.optString("thread_id");
                c0103a.postId = optJSONObject.optString("post_id");
                c0103a.type = optJSONObject.optInt("type");
                c0103a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0103a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0103a.dIN = optJSONObject2.optString("id");
                    c0103a.dIQ = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0103a.dIO = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0103a.dIK = optJSONObject3.optString("id");
                    c0103a.dIL = optJSONObject3.optInt("gender");
                }
            }
            return c0103a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
