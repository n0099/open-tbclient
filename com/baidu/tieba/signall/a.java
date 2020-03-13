package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private int jXK = -1;
    private String errorMsg = null;
    private String userMsg = null;

    public int getErrorNumber() {
        return this.jXK;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jXK = jSONObject.optInt("errno");
                this.errorMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.userMsg = jSONObject.optString("usermsg");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
