package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private int errorCode = -1;
    private String errorMsg = "";
    private int fUm = 0;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int Kh() {
        return this.fUm;
    }

    public void rS(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, -1);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.fUm = optJSONObject.optInt("msg_count");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
