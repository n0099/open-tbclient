package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private int errorCode = -1;
    private String errorMsg = "";
    private int fUs = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int Kg() {
        return this.fUs;
    }

    public void rP(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, -1);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.fUs = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
