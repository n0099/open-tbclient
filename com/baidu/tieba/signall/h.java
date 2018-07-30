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
    private int gDR;
    private String gDS;
    private int gFu;
    private String gFv;
    private a gEn = new a();
    private ArrayList<i> gFw = new ArrayList<>();

    public int bsN() {
        return this.gDR;
    }

    public String bsm() {
        return this.gDS;
    }

    public a bso() {
        return this.gEn;
    }

    public ArrayList<i> bsO() {
        return this.gFw;
    }

    public int bsP() {
        return this.gFu;
    }

    public String bsQ() {
        return this.gFv;
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
                this.gEn.parserJson(jSONObject.optJSONObject("error"));
                this.gDR = jSONObject.optInt("show_dialog");
                this.gDS = jSONObject.optString("sign_notice");
                this.gFu = jSONObject.optInt("is_timeout");
                this.gFv = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gFw.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
