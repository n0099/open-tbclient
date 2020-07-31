package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0675a {
        public String fName;
        public String hWY;
        public String jnL;
        public int joh;
        public String joi;
        public String joj;
        public int jok;
        public String jol;
        public String jom;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0675a Iv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0675a c0675a = new C0675a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0675a.joi = optJSONObject.optString("title");
                c0675a.jnL = optJSONObject.optString("content");
                c0675a.jol = optJSONObject.optString("quote_content");
                c0675a.fName = optJSONObject.optString("fname");
                c0675a.threadId = optJSONObject.optString("thread_id");
                c0675a.postId = optJSONObject.optString("post_id");
                c0675a.type = optJSONObject.optInt("type");
                c0675a.title = optJSONObject.optString("title");
                c0675a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0675a.joj = optJSONObject2.optString("id");
                    c0675a.jom = optJSONObject2.optString("portrait");
                    c0675a.jok = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0675a.hWY = optJSONObject3.optString("id");
                    c0675a.joh = optJSONObject3.optInt("gender");
                }
            }
            return c0675a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
