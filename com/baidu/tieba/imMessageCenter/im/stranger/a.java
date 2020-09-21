package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0724a {
        public String fName;
        public String isp;
        public int jLP;
        public String jLQ;
        public String jLR;
        public int jLS;
        public String jLT;
        public String jLU;
        public String jLt;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0724a LQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0724a c0724a = new C0724a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0724a.jLQ = optJSONObject.optString("title");
                c0724a.jLt = optJSONObject.optString("content");
                c0724a.jLT = optJSONObject.optString("quote_content");
                c0724a.fName = optJSONObject.optString("fname");
                c0724a.threadId = optJSONObject.optString("thread_id");
                c0724a.postId = optJSONObject.optString("post_id");
                c0724a.type = optJSONObject.optInt("type");
                c0724a.title = optJSONObject.optString("title");
                c0724a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0724a.jLR = optJSONObject2.optString("id");
                    c0724a.jLU = optJSONObject2.optString("portrait");
                    c0724a.jLS = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0724a.isp = optJSONObject3.optString("id");
                    c0724a.jLP = optJSONObject3.optInt("gender");
                }
            }
            return c0724a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
