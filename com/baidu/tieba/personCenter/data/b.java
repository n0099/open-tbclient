package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    private int errorCode = -1;
    private String errorMsg = "";
    private int grA = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int OH() {
        return this.grA;
    }

    public void tB(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt("error_code", -1);
                this.errorMsg = jSONObject.optString("error_msg", "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.grA = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
