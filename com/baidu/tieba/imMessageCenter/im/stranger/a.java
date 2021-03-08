package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0775a {
        public String fName;
        public String jDk;
        public String kRQ;
        public int kSl;
        public String kSm;
        public String kSn;
        public int kSo;
        public String kSp;
        public String kSq;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0775a Nx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0775a c0775a = new C0775a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0775a.kSm = optJSONObject.optString("title");
                c0775a.kRQ = optJSONObject.optString("content");
                c0775a.kSp = optJSONObject.optString("quote_content");
                c0775a.fName = optJSONObject.optString("fname");
                c0775a.threadId = optJSONObject.optString("thread_id");
                c0775a.postId = optJSONObject.optString("post_id");
                c0775a.type = optJSONObject.optInt("type");
                c0775a.title = optJSONObject.optString("title");
                c0775a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0775a.kSn = optJSONObject2.optString("id");
                    c0775a.kSq = optJSONObject2.optString("portrait");
                    c0775a.kSo = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0775a.jDk = optJSONObject3.optString("id");
                    c0775a.kSl = optJSONObject3.optInt("gender");
                }
            }
            return c0775a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
