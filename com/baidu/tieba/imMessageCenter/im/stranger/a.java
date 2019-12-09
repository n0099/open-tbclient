package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0443a {
        public String cxN;
        public String fKd;
        public String gTE;
        public int gUa;
        public String gUb;
        public String gUc;
        public int gUd;
        public String gUe;
        public String gUf;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0443a yA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0443a c0443a = new C0443a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0443a.gUb = optJSONObject.optString("title");
                c0443a.gTE = optJSONObject.optString("content");
                c0443a.gUe = optJSONObject.optString("quote_content");
                c0443a.cxN = optJSONObject.optString("fname");
                c0443a.threadId = optJSONObject.optString("thread_id");
                c0443a.postId = optJSONObject.optString("post_id");
                c0443a.type = optJSONObject.optInt("type");
                c0443a.title = optJSONObject.optString("title");
                c0443a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0443a.gUc = optJSONObject2.optString("id");
                    c0443a.gUf = optJSONObject2.optString("portrait");
                    c0443a.gUd = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0443a.fKd = optJSONObject3.optString("id");
                    c0443a.gUa = optJSONObject3.optInt("gender");
                }
            }
            return c0443a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
