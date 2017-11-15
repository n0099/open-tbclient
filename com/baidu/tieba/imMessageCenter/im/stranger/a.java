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
    public static class C0101a {
        public String atX;
        public String cMC;
        public int dQD;
        public String dQE;
        public String dQF;
        public int dQG;
        public String dQH;
        public String dQI;
        public String dQg;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0101a nn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0101a c0101a = new C0101a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0101a.dQE = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0101a.dQg = optJSONObject.optString("content");
                c0101a.dQH = optJSONObject.optString("quote_content");
                c0101a.atX = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0101a.threadId = optJSONObject.optString("thread_id");
                c0101a.postId = optJSONObject.optString("post_id");
                c0101a.type = optJSONObject.optInt("type");
                c0101a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0101a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0101a.dQF = optJSONObject2.optString("id");
                    c0101a.dQI = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0101a.dQG = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0101a.cMC = optJSONObject3.optString("id");
                    c0101a.dQD = optJSONObject3.optInt("gender");
                }
            }
            return c0101a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
