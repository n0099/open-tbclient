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
    public static class C0247a {
        public String aOG;
        public String dQp;
        public String eVW;
        public int eWs;
        public String eWt;
        public String eWu;
        public int eWv;
        public String eWw;
        public String eWx;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0247a qi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0247a c0247a = new C0247a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0247a.eWt = optJSONObject.optString("title");
                c0247a.eVW = optJSONObject.optString("content");
                c0247a.eWw = optJSONObject.optString("quote_content");
                c0247a.aOG = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0247a.threadId = optJSONObject.optString("thread_id");
                c0247a.postId = optJSONObject.optString("post_id");
                c0247a.type = optJSONObject.optInt("type");
                c0247a.title = optJSONObject.optString("title");
                c0247a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0247a.eWu = optJSONObject2.optString("id");
                    c0247a.eWx = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0247a.eWv = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0247a.dQp = optJSONObject3.optString("id");
                    c0247a.eWs = optJSONObject3.optInt("gender");
                }
            }
            return c0247a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
