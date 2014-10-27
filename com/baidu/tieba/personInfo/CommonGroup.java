package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CommonGroup implements Serializable {
    private static final long serialVersionUID = -4814545478903103288L;
    private String commonGroup;

    public String getCommonGroup() {
        return this.commonGroup;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.commonGroup = jSONObject.optString("groupname");
        }
    }

    public void parseProto(String str) {
        if (str != null) {
            this.commonGroup = str;
        }
    }
}
