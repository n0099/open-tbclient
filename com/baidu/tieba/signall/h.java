package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int gDU;
    private String gDV;
    private int gFx;
    private String gFy;
    private a gEq = new a();
    private ArrayList<i> gFz = new ArrayList<>();

    public int bsO() {
        return this.gDU;
    }

    public String bsn() {
        return this.gDV;
    }

    public a bsp() {
        return this.gEq;
    }

    public ArrayList<i> bsP() {
        return this.gFz;
    }

    public int bsQ() {
        return this.gFx;
    }

    public String bsR() {
        return this.gFy;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gEq.parserJson(jSONObject.optJSONObject("error"));
                this.gDU = jSONObject.optInt("show_dialog");
                this.gDV = jSONObject.optString("sign_notice");
                this.gFx = jSONObject.optInt("is_timeout");
                this.gFy = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gFz.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
