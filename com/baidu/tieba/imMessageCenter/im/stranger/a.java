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
        public String aux;
        public String cVQ;
        public String dXV;
        public int dYs;
        public String dYt;
        public String dYu;
        public int dYv;
        public String dYw;
        public String dYx;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0102a nw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0102a c0102a = new C0102a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0102a.dYt = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0102a.dXV = optJSONObject.optString("content");
                c0102a.dYw = optJSONObject.optString("quote_content");
                c0102a.aux = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0102a.threadId = optJSONObject.optString("thread_id");
                c0102a.postId = optJSONObject.optString("post_id");
                c0102a.type = optJSONObject.optInt("type");
                c0102a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0102a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0102a.dYu = optJSONObject2.optString("id");
                    c0102a.dYx = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0102a.dYv = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0102a.cVQ = optJSONObject3.optString("id");
                    c0102a.dYs = optJSONObject3.optInt("gender");
                }
            }
            return c0102a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
