package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0185a {
        public String aGb;
        public String dAG;
        public String eFJ;
        public int eGf;
        public String eGg;
        public String eGh;
        public int eGi;
        public String eGj;
        public String eGk;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0185a oY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0185a c0185a = new C0185a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0185a.eGg = optJSONObject.optString("title");
                c0185a.eFJ = optJSONObject.optString("content");
                c0185a.eGj = optJSONObject.optString("quote_content");
                c0185a.aGb = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0185a.threadId = optJSONObject.optString("thread_id");
                c0185a.postId = optJSONObject.optString("post_id");
                c0185a.type = optJSONObject.optInt("type");
                c0185a.title = optJSONObject.optString("title");
                c0185a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0185a.eGh = optJSONObject2.optString("id");
                    c0185a.eGk = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0185a.eGi = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0185a.dAG = optJSONObject3.optString("id");
                    c0185a.eGf = optJSONObject3.optInt("gender");
                }
            }
            return c0185a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
