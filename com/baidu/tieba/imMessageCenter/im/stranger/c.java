package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static d hr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                dVar.btI = optJSONObject.optString("title");
                dVar.replyContent = optJSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                dVar.btL = optJSONObject.optString("quote_content");
                dVar.btN = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                dVar.threadId = optJSONObject.optString("thread_id");
                dVar.postId = optJSONObject.optString("post_id");
                dVar.type = optJSONObject.optInt("type");
                dVar.title = optJSONObject.optString("title");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    dVar.btJ = optJSONObject2.optString("id");
                    dVar.btM = optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    dVar.btK = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    dVar.btG = optJSONObject3.optString("id");
                    dVar.btH = optJSONObject3.optInt("gender");
                }
            }
            return dVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
