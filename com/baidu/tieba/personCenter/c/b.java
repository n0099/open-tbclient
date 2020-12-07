package com.baidu.tieba.personCenter.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    private int errorCode = -1;
    private String errorMsg = "";
    private int mjS = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int bEL() {
        return this.mjS;
    }

    public void QW(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt("error_code", -1);
                this.errorMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.mjS = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
