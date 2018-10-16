package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0221a {
        public String aNQ;
        public String dPm;
        public String eUD;
        public int eUZ;
        public String eVa;
        public String eVb;
        public int eVc;
        public String eVd;
        public String eVe;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0221a qh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0221a c0221a = new C0221a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0221a.eVa = optJSONObject.optString("title");
                c0221a.eUD = optJSONObject.optString("content");
                c0221a.eVd = optJSONObject.optString("quote_content");
                c0221a.aNQ = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0221a.threadId = optJSONObject.optString("thread_id");
                c0221a.postId = optJSONObject.optString("post_id");
                c0221a.type = optJSONObject.optInt("type");
                c0221a.title = optJSONObject.optString("title");
                c0221a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0221a.eVb = optJSONObject2.optString("id");
                    c0221a.eVe = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0221a.eVc = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0221a.dPm = optJSONObject3.optString("id");
                    c0221a.eUZ = optJSONObject3.optInt("gender");
                }
            }
            return c0221a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
