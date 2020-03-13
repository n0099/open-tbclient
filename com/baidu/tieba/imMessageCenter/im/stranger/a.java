package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0541a {
        public String fName;
        public String gDQ;
        public int hNS;
        public String hNT;
        public String hNU;
        public int hNV;
        public String hNW;
        public String hNX;
        public String hNw;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0541a DK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0541a c0541a = new C0541a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0541a.hNT = optJSONObject.optString("title");
                c0541a.hNw = optJSONObject.optString("content");
                c0541a.hNW = optJSONObject.optString("quote_content");
                c0541a.fName = optJSONObject.optString("fname");
                c0541a.threadId = optJSONObject.optString("thread_id");
                c0541a.postId = optJSONObject.optString("post_id");
                c0541a.type = optJSONObject.optInt("type");
                c0541a.title = optJSONObject.optString("title");
                c0541a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0541a.hNU = optJSONObject2.optString("id");
                    c0541a.hNX = optJSONObject2.optString("portrait");
                    c0541a.hNV = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0541a.gDQ = optJSONObject3.optString("id");
                    c0541a.hNS = optJSONObject3.optInt("gender");
                }
            }
            return c0541a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
