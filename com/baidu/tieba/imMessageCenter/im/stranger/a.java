package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0727a {
        public String fName;
        public String iln;
        public String jCR;
        public int jDn;
        public String jDo;
        public String jDp;
        public int jDq;
        public String jDr;
        public String jDs;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0727a Lo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0727a c0727a = new C0727a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0727a.jDo = optJSONObject.optString("title");
                c0727a.jCR = optJSONObject.optString("content");
                c0727a.jDr = optJSONObject.optString("quote_content");
                c0727a.fName = optJSONObject.optString("fname");
                c0727a.threadId = optJSONObject.optString("thread_id");
                c0727a.postId = optJSONObject.optString("post_id");
                c0727a.type = optJSONObject.optInt("type");
                c0727a.title = optJSONObject.optString("title");
                c0727a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0727a.jDp = optJSONObject2.optString("id");
                    c0727a.jDs = optJSONObject2.optString("portrait");
                    c0727a.jDq = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0727a.iln = optJSONObject3.optString("id");
                    c0727a.jDn = optJSONObject3.optInt("gender");
                }
            }
            return c0727a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
