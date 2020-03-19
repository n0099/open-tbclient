package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0542a {
        public String fName;
        public String gEO;
        public String hOW;
        public int hPs;
        public String hPt;
        public String hPu;
        public int hPv;
        public String hPw;
        public String hPx;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0542a DK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0542a c0542a = new C0542a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0542a.hPt = optJSONObject.optString("title");
                c0542a.hOW = optJSONObject.optString("content");
                c0542a.hPw = optJSONObject.optString("quote_content");
                c0542a.fName = optJSONObject.optString("fname");
                c0542a.threadId = optJSONObject.optString("thread_id");
                c0542a.postId = optJSONObject.optString("post_id");
                c0542a.type = optJSONObject.optInt("type");
                c0542a.title = optJSONObject.optString("title");
                c0542a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0542a.hPu = optJSONObject2.optString("id");
                    c0542a.hPx = optJSONObject2.optString("portrait");
                    c0542a.hPv = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0542a.gEO = optJSONObject3.optString("id");
                    c0542a.hPs = optJSONObject3.optInt("gender");
                }
            }
            return c0542a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
