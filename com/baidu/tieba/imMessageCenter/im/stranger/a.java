package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0650a {
        public String fName;
        public String hDe;
        public String iNA;
        public int iNW;
        public String iNX;
        public String iNY;
        public int iNZ;
        public String iOa;
        public String iOb;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0650a He(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0650a c0650a = new C0650a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0650a.iNX = optJSONObject.optString("title");
                c0650a.iNA = optJSONObject.optString("content");
                c0650a.iOa = optJSONObject.optString("quote_content");
                c0650a.fName = optJSONObject.optString("fname");
                c0650a.threadId = optJSONObject.optString("thread_id");
                c0650a.postId = optJSONObject.optString("post_id");
                c0650a.type = optJSONObject.optInt("type");
                c0650a.title = optJSONObject.optString("title");
                c0650a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0650a.iNY = optJSONObject2.optString("id");
                    c0650a.iOb = optJSONObject2.optString("portrait");
                    c0650a.iNZ = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0650a.hDe = optJSONObject3.optString("id");
                    c0650a.iNW = optJSONObject3.optInt("gender");
                }
            }
            return c0650a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
