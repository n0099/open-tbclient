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
    public static class C0128a {
        public String biL;
        public String dIq;
        public int eLE;
        public String eLF;
        public String eLG;
        public int eLH;
        public String eLI;
        public String eLJ;
        public String eLh;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0128a nF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0128a c0128a = new C0128a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0128a.eLF = optJSONObject.optString("title");
                c0128a.eLh = optJSONObject.optString("content");
                c0128a.eLI = optJSONObject.optString("quote_content");
                c0128a.biL = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0128a.threadId = optJSONObject.optString("thread_id");
                c0128a.postId = optJSONObject.optString("post_id");
                c0128a.type = optJSONObject.optInt("type");
                c0128a.title = optJSONObject.optString("title");
                c0128a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0128a.eLG = optJSONObject2.optString("id");
                    c0128a.eLJ = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0128a.eLH = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0128a.dIq = optJSONObject3.optString("id");
                    c0128a.eLE = optJSONObject3.optInt("gender");
                }
            }
            return c0128a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
