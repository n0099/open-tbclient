package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0104a {
        public String auA;
        public String dLO;
        public int dLP;
        public String dLQ;
        public String dLR;
        public int dLS;
        public String dLT;
        public String dLU;
        public String dLr;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0104a nl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0104a c0104a = new C0104a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0104a.dLQ = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0104a.dLr = optJSONObject.optString("content");
                c0104a.dLT = optJSONObject.optString("quote_content");
                c0104a.auA = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0104a.threadId = optJSONObject.optString("thread_id");
                c0104a.postId = optJSONObject.optString("post_id");
                c0104a.type = optJSONObject.optInt("type");
                c0104a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0104a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0104a.dLR = optJSONObject2.optString("id");
                    c0104a.dLU = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0104a.dLS = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0104a.dLO = optJSONObject3.optString("id");
                    c0104a.dLP = optJSONObject3.optInt("gender");
                }
            }
            return c0104a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
