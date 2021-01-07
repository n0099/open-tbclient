package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0783a {
        public String fName;
        public String jAn;
        public int kMA;
        public String kMB;
        public String kMC;
        public String kMb;
        public int kMx;
        public String kMy;
        public String kMz;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0783a NJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0783a c0783a = new C0783a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0783a.kMy = optJSONObject.optString("title");
                c0783a.kMb = optJSONObject.optString("content");
                c0783a.kMB = optJSONObject.optString("quote_content");
                c0783a.fName = optJSONObject.optString("fname");
                c0783a.threadId = optJSONObject.optString("thread_id");
                c0783a.postId = optJSONObject.optString("post_id");
                c0783a.type = optJSONObject.optInt("type");
                c0783a.title = optJSONObject.optString("title");
                c0783a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0783a.kMz = optJSONObject2.optString("id");
                    c0783a.kMC = optJSONObject2.optString("portrait");
                    c0783a.kMA = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0783a.jAn = optJSONObject3.optString("id");
                    c0783a.kMx = optJSONObject3.optInt("gender");
                }
            }
            return c0783a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
