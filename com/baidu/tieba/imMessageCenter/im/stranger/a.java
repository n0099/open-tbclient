package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0774a {
        public String fName;
        public String jan;
        public int ktS;
        public String ktT;
        public String ktU;
        public int ktV;
        public String ktW;
        public String ktX;
        public String ktw;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0774a MV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0774a c0774a = new C0774a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0774a.ktT = optJSONObject.optString("title");
                c0774a.ktw = optJSONObject.optString("content");
                c0774a.ktW = optJSONObject.optString("quote_content");
                c0774a.fName = optJSONObject.optString("fname");
                c0774a.threadId = optJSONObject.optString("thread_id");
                c0774a.postId = optJSONObject.optString("post_id");
                c0774a.type = optJSONObject.optInt("type");
                c0774a.title = optJSONObject.optString("title");
                c0774a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0774a.ktU = optJSONObject2.optString("id");
                    c0774a.ktX = optJSONObject2.optString("portrait");
                    c0774a.ktV = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0774a.jan = optJSONObject3.optString("id");
                    c0774a.ktS = optJSONObject3.optInt("gender");
                }
            }
            return c0774a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
