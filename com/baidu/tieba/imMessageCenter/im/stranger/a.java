package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0529a {
        public String fName;
        public String gys;
        public String hHH;
        public int hId;
        public String hIe;
        public String hIf;
        public int hIg;
        public String hIh;
        public String hIi;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0529a Dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0529a c0529a = new C0529a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0529a.hIe = optJSONObject.optString("title");
                c0529a.hHH = optJSONObject.optString("content");
                c0529a.hIh = optJSONObject.optString("quote_content");
                c0529a.fName = optJSONObject.optString("fname");
                c0529a.threadId = optJSONObject.optString("thread_id");
                c0529a.postId = optJSONObject.optString("post_id");
                c0529a.type = optJSONObject.optInt("type");
                c0529a.title = optJSONObject.optString("title");
                c0529a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0529a.hIf = optJSONObject2.optString("id");
                    c0529a.hIi = optJSONObject2.optString("portrait");
                    c0529a.hIg = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0529a.gys = optJSONObject3.optString("id");
                    c0529a.hId = optJSONObject3.optInt("gender");
                }
            }
            return c0529a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
