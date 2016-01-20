package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a {
        public String chG;
        public int chH;
        public String chI;
        public String chJ;
        public int chK;
        public String chL;
        public String chM;
        public String chN;
        public String chl;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static a jw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                aVar.chI = optJSONObject.optString("title");
                aVar.chl = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                aVar.chL = optJSONObject.optString("quote_content");
                aVar.chN = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                aVar.threadId = optJSONObject.optString("thread_id");
                aVar.postId = optJSONObject.optString("post_id");
                aVar.type = optJSONObject.optInt("type");
                aVar.title = optJSONObject.optString("title");
                aVar.threadType = optJSONObject.optInt(PbActivityConfig.KEY_THREAD_TYPE);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    aVar.chJ = optJSONObject2.optString("id");
                    aVar.chM = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    aVar.chK = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    aVar.chG = optJSONObject3.optString("id");
                    aVar.chH = optJSONObject3.optInt("gender");
                }
            }
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
