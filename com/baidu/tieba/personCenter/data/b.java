package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private int errorCode = -1;
    private String errorMsg = "";
    private int ilB = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int awu() {
        return this.ilB;
    }

    public void Bw(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt("error_code", -1);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.ilB = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
