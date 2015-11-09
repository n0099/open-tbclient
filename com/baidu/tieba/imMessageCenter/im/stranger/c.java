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
        public String bOD;
        public int bOE;
        public String bOF;
        public String bOG;
        public int bOH;
        public String bOI;
        public String bOJ;
        public String bOK;
        public String bOi;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a iO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.bOF = optJSONObject.optString("title");
                aVar.bOi = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                aVar.bOI = optJSONObject.optString("quote_content");
                aVar.bOK = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString("title");
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.bOG = optJSONObject2.optString("id");
                    aVar.bOJ = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.bOH = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.bOD = optJSONObject3.optString("id");
                    aVar.bOE = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
