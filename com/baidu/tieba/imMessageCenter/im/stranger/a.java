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
    public static class C0258a {
        public String aSh;
        public String dZI;
        public String ffC;
        public int ffY;
        public String ffZ;
        public String fga;
        public int fgb;
        public String fgc;
        public String fgd;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0258a qN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0258a c0258a = new C0258a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0258a.ffZ = optJSONObject.optString("title");
                c0258a.ffC = optJSONObject.optString("content");
                c0258a.fgc = optJSONObject.optString("quote_content");
                c0258a.aSh = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0258a.threadId = optJSONObject.optString("thread_id");
                c0258a.postId = optJSONObject.optString("post_id");
                c0258a.type = optJSONObject.optInt("type");
                c0258a.title = optJSONObject.optString("title");
                c0258a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0258a.fga = optJSONObject2.optString("id");
                    c0258a.fgd = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0258a.fgb = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0258a.dZI = optJSONObject3.optString("id");
                    c0258a.ffY = optJSONObject3.optInt("gender");
                }
            }
            return c0258a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
