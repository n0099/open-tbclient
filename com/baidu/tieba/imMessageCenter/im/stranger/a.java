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
    public static class C0263a {
        public String cbs;
        public String fnS;
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

    public static C0263a xI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0263a c0263a = new C0263a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c0263a.gwT = optJSONObject.optString("title");
                c0263a.gww = optJSONObject.optString("content");
                c0263a.gwW = optJSONObject.optString("quote_content");
                c0263a.cbs = optJSONObject.optString(ImageViewerConfig.FORUM_NAME);
                c0263a.threadId = optJSONObject.optString("thread_id");
                c0263a.postId = optJSONObject.optString("post_id");
                c0263a.type = optJSONObject.optInt("type");
                c0263a.title = optJSONObject.optString("title");
                c0263a.threadType = optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    c0263a.gwU = optJSONObject2.optString("id");
                    c0263a.gwX = optJSONObject2.optString(IntentConfig.PORTRAIT);
                    c0263a.gwV = optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    c0263a.fnS = optJSONObject3.optString("id");
                    c0263a.gwS = optJSONObject3.optInt("gender");
                }
            }
            return c0263a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
