package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private int laT = -1;
    private String errorMsg = null;
    private String userMsg = null;

    public int getErrorNumber() {
        return this.laT;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.laT = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.errorMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.userMsg = jSONObject.optString("usermsg");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
