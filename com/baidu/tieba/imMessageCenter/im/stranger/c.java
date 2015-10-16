package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a {
        public String bNN;
        public String bOi;
        public int bOj;
        public String bOk;
        public String bOl;
        public int bOm;
        public String bOn;
        public String bOo;
        public String bOp;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a iM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.bOk = optJSONObject.optString("title");
                aVar.bNN = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                aVar.bOn = optJSONObject.optString("quote_content");
                aVar.bOp = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString("title");
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.bOl = optJSONObject2.optString("id");
                    aVar.bOo = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.bOm = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.bOi = optJSONObject3.optString("id");
                    aVar.bOj = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
