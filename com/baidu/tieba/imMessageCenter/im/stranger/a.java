package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0790a {
        public String fName;
        public String jnP;
        public String kGS;
        public int kHo;
        public String kHp;
        public String kHq;
        public int kHr;
        public String kHs;
        public String kHt;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0790a Od(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0790a c0790a = new C0790a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0790a.kHp = optJSONObject.optString("title");
                c0790a.kGS = optJSONObject.optString("content");
                c0790a.kHs = optJSONObject.optString("quote_content");
                c0790a.fName = optJSONObject.optString("fname");
                c0790a.threadId = optJSONObject.optString("thread_id");
                c0790a.postId = optJSONObject.optString("post_id");
                c0790a.type = optJSONObject.optInt("type");
                c0790a.title = optJSONObject.optString("title");
                c0790a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0790a.kHq = optJSONObject2.optString("id");
                    c0790a.kHt = optJSONObject2.optString("portrait");
                    c0790a.kHr = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0790a.jnP = optJSONObject3.optString("id");
                    c0790a.kHo = optJSONObject3.optInt("gender");
                }
            }
            return c0790a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
