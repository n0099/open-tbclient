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
        public String ilh;
        public String jCL;
        public int jDh;
        public String jDi;
        public String jDj;
        public int jDk;
        public String jDl;
        public String jDm;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0727a Ln(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0727a c0727a = new C0727a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0727a.jDi = optJSONObject.optString("title");
                c0727a.jCL = optJSONObject.optString("content");
                c0727a.jDl = optJSONObject.optString("quote_content");
                c0727a.fName = optJSONObject.optString("fname");
                c0727a.threadId = optJSONObject.optString("thread_id");
                c0727a.postId = optJSONObject.optString("post_id");
                c0727a.type = optJSONObject.optInt("type");
                c0727a.title = optJSONObject.optString("title");
                c0727a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0727a.jDj = optJSONObject2.optString("id");
                    c0727a.jDm = optJSONObject2.optString("portrait");
                    c0727a.jDk = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0727a.ilh = optJSONObject3.optString("id");
                    c0727a.jDh = optJSONObject3.optInt("gender");
                }
            }
            return c0727a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
