package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0758a {
        public String fName;
        public String iTE;
        public String kmQ;
        public int knm;
        public String knn;
        public String kno;
        public int knp;
        public String knq;
        public String knr;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0758a Nd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0758a c0758a = new C0758a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0758a.knn = optJSONObject.optString("title");
                c0758a.kmQ = optJSONObject.optString("content");
                c0758a.knq = optJSONObject.optString("quote_content");
                c0758a.fName = optJSONObject.optString("fname");
                c0758a.threadId = optJSONObject.optString("thread_id");
                c0758a.postId = optJSONObject.optString("post_id");
                c0758a.type = optJSONObject.optInt("type");
                c0758a.title = optJSONObject.optString("title");
                c0758a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0758a.kno = optJSONObject2.optString("id");
                    c0758a.knr = optJSONObject2.optString("portrait");
                    c0758a.knp = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0758a.iTE = optJSONObject3.optString("id");
                    c0758a.knm = optJSONObject3.optInt("gender");
                }
            }
            return c0758a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
