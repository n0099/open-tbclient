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
    public static class C0326a {
        public String cbv;
        public String fnD;
        public int gwG;
        public String gwH;
        public String gwI;
        public int gwJ;
        public String gwK;
        public String gwL;
        public String gwk;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0326a xG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0326a c0326a = new C0326a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0326a.gwH = optJSONObject.optString("title");
                c0326a.gwk = optJSONObject.optString("content");
                c0326a.gwK = optJSONObject.optString("quote_content");
                c0326a.cbv = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0326a.threadId = optJSONObject.optString("thread_id");
                c0326a.postId = optJSONObject.optString("post_id");
                c0326a.type = optJSONObject.optInt("type");
                c0326a.title = optJSONObject.optString("title");
                c0326a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0326a.gwI = optJSONObject2.optString("id");
                    c0326a.gwL = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0326a.gwJ = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0326a.fnD = optJSONObject3.optString("id");
                    c0326a.gwG = optJSONObject3.optInt("gender");
                }
            }
            return c0326a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
