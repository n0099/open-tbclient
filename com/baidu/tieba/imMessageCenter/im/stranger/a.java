package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0600a {
        public String fName;
        public String hoq;
        public String iyT;
        public int izp;
        public String izq;
        public String izr;
        public int izs;
        public String izt;
        public String izu;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0600a Fv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0600a c0600a = new C0600a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0600a.izq = optJSONObject.optString("title");
                c0600a.iyT = optJSONObject.optString("content");
                c0600a.izt = optJSONObject.optString("quote_content");
                c0600a.fName = optJSONObject.optString("fname");
                c0600a.threadId = optJSONObject.optString("thread_id");
                c0600a.postId = optJSONObject.optString("post_id");
                c0600a.type = optJSONObject.optInt("type");
                c0600a.title = optJSONObject.optString("title");
                c0600a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0600a.izr = optJSONObject2.optString("id");
                    c0600a.izu = optJSONObject2.optString("portrait");
                    c0600a.izs = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0600a.hoq = optJSONObject3.optString("id");
                    c0600a.izp = optJSONObject3.optInt("gender");
                }
            }
            return c0600a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
