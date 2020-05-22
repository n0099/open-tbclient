package com.baidu.tieba.personCenter.c;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private int errorCode = -1;
    private String errorMsg = "";
    private int kkZ = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int bfj() {
        return this.kkZ;
    }

    public void Kc(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt("error_code", -1);
                this.errorMsg = jSONObject.optString("error_msg", "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.kkZ = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
