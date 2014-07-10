package com.baidu.tieba.im.widget;

import com.baidu.tbadk.data.ShareFromPBMsgData;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a<T> {
    private String a;
    private int b;
    private T c;

    /* JADX WARN: Type inference failed for: r1v7, types: [T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    public void a(String str, String str2) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 3) {
                    this.a = jSONArray.optString(0);
                    this.b = jSONArray.optInt(1);
                    if (1 == this.b) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(2);
                        ?? r1 = (T) new ShareFromPBMsgData();
                        r1.setContent(optJSONObject.optString("themeContent"));
                        r1.setForumName(optJSONObject.optString("forumName"));
                        r1.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        r1.setPostId(optJSONObject.optString("postID"));
                        r1.setThreadId(optJSONObject.optString("themeID"));
                        r1.setTitle(optJSONObject.optString("themeTitle"));
                        this.c = r1;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public int a() {
        return this.b;
    }

    public T b() {
        return this.c;
    }
}
