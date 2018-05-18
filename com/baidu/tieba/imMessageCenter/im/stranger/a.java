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
    public static class C0168a {
        public String awU;
        public String dlx;
        public String emH;
        public int ene;
        public String enf;
        public String eng;
        public int enh;
        public String eni;
        public String enj;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0168a oi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0168a c0168a = new C0168a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0168a.enf = optJSONObject.optString("title");
                c0168a.emH = optJSONObject.optString("content");
                c0168a.eni = optJSONObject.optString("quote_content");
                c0168a.awU = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0168a.threadId = optJSONObject.optString("thread_id");
                c0168a.postId = optJSONObject.optString("post_id");
                c0168a.type = optJSONObject.optInt("type");
                c0168a.title = optJSONObject.optString("title");
                c0168a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0168a.eng = optJSONObject2.optString("id");
                    c0168a.enj = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0168a.enh = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0168a.dlx = optJSONObject3.optString("id");
                    c0168a.ene = optJSONObject3.optInt("gender");
                }
            }
            return c0168a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
