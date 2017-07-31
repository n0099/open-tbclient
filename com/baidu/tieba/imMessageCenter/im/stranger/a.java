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
        public String dCQ;
        public String dDn;
        public int dDo;
        public String dDp;
        public String dDq;
        public int dDr;
        public String dDs;
        public String dDt;
        public String dDu;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0101a mK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0101a c0101a = new C0101a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0101a.dDp = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0101a.dCQ = optJSONObject.optString("content");
                c0101a.dDs = optJSONObject.optString("quote_content");
                c0101a.dDu = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0101a.threadId = optJSONObject.optString("thread_id");
                c0101a.postId = optJSONObject.optString("post_id");
                c0101a.type = optJSONObject.optInt("type");
                c0101a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0101a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0101a.dDq = optJSONObject2.optString("id");
                    c0101a.dDt = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0101a.dDr = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0101a.dDn = optJSONObject3.optString("id");
                    c0101a.dDo = optJSONObject3.optInt("gender");
                }
            }
            return c0101a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
