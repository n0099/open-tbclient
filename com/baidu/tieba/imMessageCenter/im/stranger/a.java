package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.tieba.imMessageCenter.im.stranger.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0343a {
        public String cjw;
        public String fDY;
        public int gNT;
        public String gNU;
        public String gNV;
        public int gNW;
        public String gNX;
        public String gNY;
        public String gNx;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0343a yV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0343a c0343a = new C0343a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0343a.gNU = optJSONObject.optString("title");
                c0343a.gNx = optJSONObject.optString("content");
                c0343a.gNX = optJSONObject.optString("quote_content");
                c0343a.cjw = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0343a.threadId = optJSONObject.optString("thread_id");
                c0343a.postId = optJSONObject.optString("post_id");
                c0343a.type = optJSONObject.optInt("type");
                c0343a.title = optJSONObject.optString("title");
                c0343a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0343a.gNV = optJSONObject2.optString("id");
                    c0343a.gNY = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0343a.gNW = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0343a.fDY = optJSONObject3.optString("id");
                    c0343a.gNT = optJSONObject3.optInt("gender");
                }
            }
            return c0343a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
