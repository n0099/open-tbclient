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
    public static class C0102a {
        public String dEN;
        public String dFk;
        public int dFl;
        public String dFm;
        public String dFn;
        public int dFo;
        public String dFp;
        public String dFq;
        public String dFr;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0102a mO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0102a c0102a = new C0102a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0102a.dFm = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0102a.dEN = optJSONObject.optString("content");
                c0102a.dFp = optJSONObject.optString("quote_content");
                c0102a.dFr = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0102a.threadId = optJSONObject.optString("thread_id");
                c0102a.postId = optJSONObject.optString("post_id");
                c0102a.type = optJSONObject.optInt("type");
                c0102a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0102a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0102a.dFn = optJSONObject2.optString("id");
                    c0102a.dFq = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0102a.dFo = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0102a.dFk = optJSONObject3.optString("id");
                    c0102a.dFl = optJSONObject3.optInt("gender");
                }
            }
            return c0102a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
