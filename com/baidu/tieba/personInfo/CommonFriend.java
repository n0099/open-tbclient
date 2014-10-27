package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CommonFriend implements Serializable {
    private static final long serialVersionUID = 6399641393891383192L;
    private String commonFriend;

    public String getCommonFriend() {
        return this.commonFriend;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.commonFriend = jSONObject.optString("friendname");
        }
    }

    public void parseProto(String str) {
        if (str != null) {
            this.commonFriend = str;
        }
    }
}
