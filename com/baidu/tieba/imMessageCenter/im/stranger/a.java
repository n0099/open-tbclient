package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0772a {
        public String fName;
        public String iZB;
        public String ksM;
        public int kti;
        public String ktj;
        public String ktk;
        public int ktl;
        public String ktm;
        public String ktn;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0772a Nu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0772a c0772a = new C0772a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0772a.ktj = optJSONObject.optString("title");
                c0772a.ksM = optJSONObject.optString("content");
                c0772a.ktm = optJSONObject.optString("quote_content");
                c0772a.fName = optJSONObject.optString("fname");
                c0772a.threadId = optJSONObject.optString("thread_id");
                c0772a.postId = optJSONObject.optString("post_id");
                c0772a.type = optJSONObject.optInt("type");
                c0772a.title = optJSONObject.optString("title");
                c0772a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0772a.ktk = optJSONObject2.optString("id");
                    c0772a.ktn = optJSONObject2.optString("portrait");
                    c0772a.ktl = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0772a.iZB = optJSONObject3.optString("id");
                    c0772a.kti = optJSONObject3.optInt("gender");
                }
            }
            return c0772a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
