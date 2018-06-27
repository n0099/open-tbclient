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
    public static class C0186a {
        public String aGb;
        public String dxU;
        public String eBP;
        public int eCl;
        public String eCm;
        public String eCn;
        public int eCo;
        public String eCp;
        public String eCq;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0186a oW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0186a c0186a = new C0186a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0186a.eCm = optJSONObject.optString("title");
                c0186a.eBP = optJSONObject.optString("content");
                c0186a.eCp = optJSONObject.optString("quote_content");
                c0186a.aGb = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0186a.threadId = optJSONObject.optString("thread_id");
                c0186a.postId = optJSONObject.optString("post_id");
                c0186a.type = optJSONObject.optInt("type");
                c0186a.title = optJSONObject.optString("title");
                c0186a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0186a.eCn = optJSONObject2.optString("id");
                    c0186a.eCq = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0186a.eCo = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0186a.dxU = optJSONObject3.optString("id");
                    c0186a.eCl = optJSONObject3.optInt("gender");
                }
            }
            return c0186a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
