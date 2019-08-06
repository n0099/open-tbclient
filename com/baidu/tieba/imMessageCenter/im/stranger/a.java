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
    public static class C0348a {
        public String ckJ;
        public String fJL;
        public String gUC;
        public int gUY;
        public String gUZ;
        public String gVa;
        public int gVb;
        public String gVc;
        public String gVd;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0348a zJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0348a c0348a = new C0348a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0348a.gUZ = optJSONObject.optString("title");
                c0348a.gUC = optJSONObject.optString("content");
                c0348a.gVc = optJSONObject.optString("quote_content");
                c0348a.ckJ = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0348a.threadId = optJSONObject.optString("thread_id");
                c0348a.postId = optJSONObject.optString("post_id");
                c0348a.type = optJSONObject.optInt("type");
                c0348a.title = optJSONObject.optString("title");
                c0348a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0348a.gVa = optJSONObject2.optString("id");
                    c0348a.gVd = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0348a.gVb = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0348a.fJL = optJSONObject3.optString("id");
                    c0348a.gUY = optJSONObject3.optInt("gender");
                }
            }
            return c0348a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
