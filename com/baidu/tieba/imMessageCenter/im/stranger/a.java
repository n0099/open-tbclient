package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0742a {
        public String fName;
        public String iHi;
        public int kaN;
        public String kaO;
        public String kaP;
        public int kaQ;
        public String kaR;
        public String kaS;
        public String kaq;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0742a MF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0742a c0742a = new C0742a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0742a.kaO = optJSONObject.optString("title");
                c0742a.kaq = optJSONObject.optString("content");
                c0742a.kaR = optJSONObject.optString("quote_content");
                c0742a.fName = optJSONObject.optString("fname");
                c0742a.threadId = optJSONObject.optString("thread_id");
                c0742a.postId = optJSONObject.optString("post_id");
                c0742a.type = optJSONObject.optInt("type");
                c0742a.title = optJSONObject.optString("title");
                c0742a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0742a.kaP = optJSONObject2.optString("id");
                    c0742a.kaS = optJSONObject2.optString("portrait");
                    c0742a.kaQ = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0742a.iHi = optJSONObject3.optString("id");
                    c0742a.kaN = optJSONObject3.optInt("gender");
                }
            }
            return c0742a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
