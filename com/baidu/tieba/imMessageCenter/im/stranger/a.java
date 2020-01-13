package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0534a {
        public String fName;
        public String gBC;
        public int hLG;
        public String hLH;
        public String hLI;
        public int hLJ;
        public String hLK;
        public String hLL;
        public String hLk;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0534a Dt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0534a c0534a = new C0534a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0534a.hLH = optJSONObject.optString("title");
                c0534a.hLk = optJSONObject.optString("content");
                c0534a.hLK = optJSONObject.optString("quote_content");
                c0534a.fName = optJSONObject.optString("fname");
                c0534a.threadId = optJSONObject.optString("thread_id");
                c0534a.postId = optJSONObject.optString("post_id");
                c0534a.type = optJSONObject.optInt("type");
                c0534a.title = optJSONObject.optString("title");
                c0534a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0534a.hLI = optJSONObject2.optString("id");
                    c0534a.hLL = optJSONObject2.optString("portrait");
                    c0534a.hLJ = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0534a.gBC = optJSONObject3.optString("id");
                    c0534a.hLG = optJSONObject3.optInt("gender");
                }
            }
            return c0534a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
