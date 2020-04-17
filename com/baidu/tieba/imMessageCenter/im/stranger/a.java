package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0579a {
        public String fName;
        public String hok;
        public String iyN;
        public int izj;
        public String izk;
        public String izl;
        public int izm;
        public String izn;
        public String izo;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0579a Fs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0579a c0579a = new C0579a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0579a.izk = optJSONObject.optString("title");
                c0579a.iyN = optJSONObject.optString("content");
                c0579a.izn = optJSONObject.optString("quote_content");
                c0579a.fName = optJSONObject.optString("fname");
                c0579a.threadId = optJSONObject.optString("thread_id");
                c0579a.postId = optJSONObject.optString("post_id");
                c0579a.type = optJSONObject.optInt("type");
                c0579a.title = optJSONObject.optString("title");
                c0579a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0579a.izl = optJSONObject2.optString("id");
                    c0579a.izo = optJSONObject2.optString("portrait");
                    c0579a.izm = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0579a.hok = optJSONObject3.optString("id");
                    c0579a.izj = optJSONObject3.optInt("gender");
                }
            }
            return c0579a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
