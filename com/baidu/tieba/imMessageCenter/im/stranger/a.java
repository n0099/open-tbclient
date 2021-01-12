package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0766a {
        public String fName;
        public String jvH;
        public int kHS;
        public String kHT;
        public String kHU;
        public int kHV;
        public String kHW;
        public String kHX;
        public String kHw;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0766a MB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0766a c0766a = new C0766a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0766a.kHT = optJSONObject.optString("title");
                c0766a.kHw = optJSONObject.optString("content");
                c0766a.kHW = optJSONObject.optString("quote_content");
                c0766a.fName = optJSONObject.optString("fname");
                c0766a.threadId = optJSONObject.optString("thread_id");
                c0766a.postId = optJSONObject.optString("post_id");
                c0766a.type = optJSONObject.optInt("type");
                c0766a.title = optJSONObject.optString("title");
                c0766a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0766a.kHU = optJSONObject2.optString("id");
                    c0766a.kHX = optJSONObject2.optString("portrait");
                    c0766a.kHV = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0766a.jvH = optJSONObject3.optString("id");
                    c0766a.kHS = optJSONObject3.optInt("gender");
                }
            }
            return c0766a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
