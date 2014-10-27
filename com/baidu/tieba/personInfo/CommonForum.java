package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CommonForum implements Serializable {
    private static final long serialVersionUID = 4172994953913285173L;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("forumname");
        }
    }

    public void parseProto(String str) {
        if (str != null) {
            this.mForumName = str;
        }
    }
}
