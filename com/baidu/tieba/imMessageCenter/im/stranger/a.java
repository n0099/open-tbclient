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
    public static class C0117a {
        public String auC;
        public String cWb;
        public int dZA;
        public String dZB;
        public String dZC;
        public String dZa;
        public int dZx;
        public String dZy;
        public String dZz;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0117a nw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0117a c0117a = new C0117a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0117a.dZy = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0117a.dZa = optJSONObject.optString("content");
                c0117a.dZB = optJSONObject.optString("quote_content");
                c0117a.auC = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0117a.threadId = optJSONObject.optString("thread_id");
                c0117a.postId = optJSONObject.optString("post_id");
                c0117a.type = optJSONObject.optInt("type");
                c0117a.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                c0117a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0117a.dZz = optJSONObject2.optString("id");
                    c0117a.dZC = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0117a.dZA = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0117a.cWb = optJSONObject3.optString("id");
                    c0117a.dZx = optJSONObject3.optInt("gender");
                }
            }
            return c0117a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
