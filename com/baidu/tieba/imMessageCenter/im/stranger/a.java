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
        public String cbs;
        public String fnR;
        public int gwS;
        public String gwT;
        public String gwU;
        public int gwV;
        public String gwW;
        public String gwX;
        public String gww;
        public String postId;
        public String threadId;
        public int threadType;
        public String title;
        public int type;
    }

    public static C0326a xH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0326a c0326a = new C0326a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0326a.gwT = optJSONObject.optString("title");
                c0326a.gww = optJSONObject.optString("content");
                c0326a.gwW = optJSONObject.optString("quote_content");
                c0326a.cbs = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0326a.threadId = optJSONObject.optString("thread_id");
                c0326a.postId = optJSONObject.optString("post_id");
                c0326a.type = optJSONObject.optInt("type");
                c0326a.title = optJSONObject.optString("title");
                c0326a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0326a.gwU = optJSONObject2.optString("id");
                    c0326a.gwX = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0326a.gwV = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0326a.fnR = optJSONObject3.optString("id");
                    c0326a.gwS = optJSONObject3.optInt("gender");
                }
            }
            return c0326a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
