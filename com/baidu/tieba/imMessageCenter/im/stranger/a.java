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
    public static class C0342a {
        public String ckC;
        public String fIX;
        public String gTK;
        public int gUg;
        public String gUh;
        public String gUi;
        public int gUj;
        public String gUk;
        public String gUl;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0342a zI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0342a c0342a = new C0342a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0342a.gUh = optJSONObject.optString("title");
                c0342a.gTK = optJSONObject.optString("content");
                c0342a.gUk = optJSONObject.optString("quote_content");
                c0342a.ckC = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0342a.threadId = optJSONObject.optString("thread_id");
                c0342a.postId = optJSONObject.optString("post_id");
                c0342a.type = optJSONObject.optInt("type");
                c0342a.title = optJSONObject.optString("title");
                c0342a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0342a.gUi = optJSONObject2.optString("id");
                    c0342a.gUl = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0342a.gUj = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0342a.fIX = optJSONObject3.optString("id");
                    c0342a.gUg = optJSONObject3.optInt("gender");
                }
            }
            return c0342a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
