package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private int errorCode = 0;
    private String errorString = null;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.errorCode = jSONObject.optInt("errno");
            this.errorString = jSONObject.optString("usermsg");
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
