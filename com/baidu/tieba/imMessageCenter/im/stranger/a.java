package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0127a {
        public String bjc;
        public String dMS;
        public String eMH;
        public int eNe;
        public String eNf;
        public String eNg;
        public int eNh;
        public String eNi;
        public String eNj;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0127a nI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0127a c0127a = new C0127a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0127a.eNf = optJSONObject.optString("title");
                c0127a.eMH = optJSONObject.optString("content");
                c0127a.eNi = optJSONObject.optString("quote_content");
                c0127a.bjc = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0127a.threadId = optJSONObject.optString("thread_id");
                c0127a.postId = optJSONObject.optString("post_id");
                c0127a.type = optJSONObject.optInt("type");
                c0127a.title = optJSONObject.optString("title");
                c0127a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0127a.eNg = optJSONObject2.optString("id");
                    c0127a.eNj = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0127a.eNh = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0127a.dMS = optJSONObject3.optString("id");
                    c0127a.eNe = optJSONObject3.optInt("gender");
                }
            }
            return c0127a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
