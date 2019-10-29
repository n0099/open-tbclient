package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0448a {
        public String cyE;
        public String fKU;
        public int gUR;
        public String gUS;
        public String gUT;
        public int gUU;
        public String gUV;
        public String gUW;
        public String gUv;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0448a yA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0448a c0448a = new C0448a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0448a.gUS = optJSONObject.optString("title");
                c0448a.gUv = optJSONObject.optString("content");
                c0448a.gUV = optJSONObject.optString("quote_content");
                c0448a.cyE = optJSONObject.optString("fname");
                c0448a.threadId = optJSONObject.optString("thread_id");
                c0448a.postId = optJSONObject.optString("post_id");
                c0448a.type = optJSONObject.optInt("type");
                c0448a.title = optJSONObject.optString("title");
                c0448a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0448a.gUT = optJSONObject2.optString("id");
                    c0448a.gUW = optJSONObject2.optString("portrait");
                    c0448a.gUU = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0448a.fKU = optJSONObject3.optString("id");
                    c0448a.gUR = optJSONObject3.optInt("gender");
                }
            }
            return c0448a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
