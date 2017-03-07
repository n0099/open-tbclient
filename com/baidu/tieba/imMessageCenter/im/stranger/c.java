package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a {
        public String dkN;
        public String dli;
        public int dlj;
        public String dlk;
        public String dll;
        public int dlm;
        public String dln;
        public String dlo;
        public String dlp;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a kY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.dlk = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.dkN = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                aVar.dln = optJSONObject.optString("quote_content");
                aVar.dlp = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                aVar.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.dll = optJSONObject2.optString("id");
                    aVar.dlo = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.dlm = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.dli = optJSONObject3.optString("id");
                    aVar.dlj = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
