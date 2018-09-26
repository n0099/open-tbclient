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
    public static class C0187a {
        public String aJo;
        public String dHn;
        public String eMV;
        public int eNr;
        public String eNs;
        public String eNt;
        public int eNu;
        public String eNv;
        public String eNw;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0187a pF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0187a c0187a = new C0187a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0187a.eNs = optJSONObject.optString("title");
                c0187a.eMV = optJSONObject.optString("content");
                c0187a.eNv = optJSONObject.optString("quote_content");
                c0187a.aJo = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0187a.threadId = optJSONObject.optString("thread_id");
                c0187a.postId = optJSONObject.optString("post_id");
                c0187a.type = optJSONObject.optInt("type");
                c0187a.title = optJSONObject.optString("title");
                c0187a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0187a.eNt = optJSONObject2.optString("id");
                    c0187a.eNw = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0187a.eNu = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0187a.dHn = optJSONObject3.optString("id");
                    c0187a.eNr = optJSONObject3.optInt("gender");
                }
            }
            return c0187a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
