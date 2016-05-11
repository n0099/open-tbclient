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
        public String cxH;
        public int cxI;
        public String cxJ;
        public String cxK;
        public int cxL;
        public String cxM;
        public String cxN;
        public String cxO;
        public String cxm;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a km(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.cxJ = optJSONObject.optString("title");
                aVar.cxm = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                aVar.cxM = optJSONObject.optString("quote_content");
                aVar.cxO = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString("title");
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.cxK = optJSONObject2.optString("id");
                    aVar.cxN = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.cxL = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.cxH = optJSONObject3.optString("id");
                    aVar.cxI = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
