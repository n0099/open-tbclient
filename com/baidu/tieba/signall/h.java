package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int iPG;
    private String iPH;
    private int iRi;
    private String iRj;
    private a iQc = new a();
    private ArrayList<i> iRk = new ArrayList<>();

    public int ckr() {
        return this.iPG;
    }

    public String cjP() {
        return this.iPH;
    }

    public a cjR() {
        return this.iQc;
    }

    public ArrayList<i> cks() {
        return this.iRk;
    }

    public int ckt() {
        return this.iRi;
    }

    public String cku() {
        return this.iRj;
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
                this.iQc.parserJson(jSONObject.optJSONObject("error"));
                this.iPG = jSONObject.optInt("show_dialog");
                this.iPH = jSONObject.optString("sign_notice");
                this.iRi = jSONObject.optInt("is_timeout");
                this.iRj = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iRk.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
