package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0359a {
        public String clE;
        public String fLA;
        public int gWR;
        public String gWS;
        public String gWT;
        public int gWU;
        public String gWV;
        public String gWW;
        public String gWv;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0359a Ai(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0359a c0359a = new C0359a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0359a.gWS = optJSONObject.optString("title");
                c0359a.gWv = optJSONObject.optString("content");
                c0359a.gWV = optJSONObject.optString("quote_content");
                c0359a.clE = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0359a.threadId = optJSONObject.optString("thread_id");
                c0359a.postId = optJSONObject.optString("post_id");
                c0359a.type = optJSONObject.optInt("type");
                c0359a.title = optJSONObject.optString("title");
                c0359a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0359a.gWT = optJSONObject2.optString("id");
                    c0359a.gWW = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0359a.gWU = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0359a.fLA = optJSONObject3.optString("id");
                    c0359a.gWR = optJSONObject3.optInt("gender");
                }
            }
            return c0359a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
