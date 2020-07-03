package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0663a {
        public String fName;
        public String hQZ;
        public int jfL;
        public String jfM;
        public String jfN;
        public int jfO;
        public String jfP;
        public String jfQ;
        public String jfp;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0663a HG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0663a c0663a = new C0663a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0663a.jfM = optJSONObject.optString("title");
                c0663a.jfp = optJSONObject.optString("content");
                c0663a.jfP = optJSONObject.optString("quote_content");
                c0663a.fName = optJSONObject.optString("fname");
                c0663a.threadId = optJSONObject.optString("thread_id");
                c0663a.postId = optJSONObject.optString("post_id");
                c0663a.type = optJSONObject.optInt("type");
                c0663a.title = optJSONObject.optString("title");
                c0663a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0663a.jfN = optJSONObject2.optString("id");
                    c0663a.jfQ = optJSONObject2.optString("portrait");
                    c0663a.jfO = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0663a.hQZ = optJSONObject3.optString("id");
                    c0663a.jfL = optJSONObject3.optInt("gender");
                }
            }
            return c0663a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
