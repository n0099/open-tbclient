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
    public static class C0184a {
        public String aFh;
        public String duL;
        public String exZ;
        public String eyA;
        public String eyB;
        public int eyw;
        public String eyx;
        public String eyy;
        public int eyz;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0184a oV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0184a c0184a = new C0184a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0184a.eyx = optJSONObject.optString("title");
                c0184a.exZ = optJSONObject.optString("content");
                c0184a.eyA = optJSONObject.optString("quote_content");
                c0184a.aFh = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0184a.threadId = optJSONObject.optString("thread_id");
                c0184a.postId = optJSONObject.optString("post_id");
                c0184a.type = optJSONObject.optInt("type");
                c0184a.title = optJSONObject.optString("title");
                c0184a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0184a.eyy = optJSONObject2.optString("id");
                    c0184a.eyB = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0184a.eyz = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0184a.duL = optJSONObject3.optString("id");
                    c0184a.eyw = optJSONObject3.optInt("gender");
                }
            }
            return c0184a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
