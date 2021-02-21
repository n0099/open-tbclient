package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0769a {
        public String fName;
        public String jBB;
        public String kPO;
        public int kQj;
        public String kQk;
        public String kQl;
        public int kQm;
        public String kQn;
        public String kQo;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0769a Nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0769a c0769a = new C0769a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0769a.kQk = optJSONObject.optString("title");
                c0769a.kPO = optJSONObject.optString("content");
                c0769a.kQn = optJSONObject.optString("quote_content");
                c0769a.fName = optJSONObject.optString("fname");
                c0769a.threadId = optJSONObject.optString("thread_id");
                c0769a.postId = optJSONObject.optString("post_id");
                c0769a.type = optJSONObject.optInt("type");
                c0769a.title = optJSONObject.optString("title");
                c0769a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0769a.kQl = optJSONObject2.optString("id");
                    c0769a.kQo = optJSONObject2.optString("portrait");
                    c0769a.kQm = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0769a.jBB = optJSONObject3.optString("id");
                    c0769a.kQj = optJSONObject3.optInt("gender");
                }
            }
            return c0769a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
