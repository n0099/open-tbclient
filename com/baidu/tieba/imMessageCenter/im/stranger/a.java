package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0768a {
        public String fName;
        public String jBn;
        public String kPA;
        public int kPV;
        public String kPW;
        public String kPX;
        public int kPY;
        public String kPZ;
        public String kQa;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0768a Nq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0768a c0768a = new C0768a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0768a.kPW = optJSONObject.optString("title");
                c0768a.kPA = optJSONObject.optString("content");
                c0768a.kPZ = optJSONObject.optString("quote_content");
                c0768a.fName = optJSONObject.optString("fname");
                c0768a.threadId = optJSONObject.optString("thread_id");
                c0768a.postId = optJSONObject.optString("post_id");
                c0768a.type = optJSONObject.optInt("type");
                c0768a.title = optJSONObject.optString("title");
                c0768a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0768a.kPX = optJSONObject2.optString("id");
                    c0768a.kQa = optJSONObject2.optString("portrait");
                    c0768a.kPY = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0768a.jBn = optJSONObject3.optString("id");
                    c0768a.kPV = optJSONObject3.optInt("gender");
                }
            }
            return c0768a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
