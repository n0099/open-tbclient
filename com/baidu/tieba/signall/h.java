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
    private int iPE;
    private String iPF;
    private int iRg;
    private String iRh;
    private a iQa = new a();
    private ArrayList<i> iRi = new ArrayList<>();

    public int ckp() {
        return this.iPE;
    }

    public String cjN() {
        return this.iPF;
    }

    public a cjP() {
        return this.iQa;
    }

    public ArrayList<i> ckq() {
        return this.iRi;
    }

    public int ckr() {
        return this.iRg;
    }

    public String cks() {
        return this.iRh;
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
                this.iQa.parserJson(jSONObject.optJSONObject("error"));
                this.iPE = jSONObject.optInt("show_dialog");
                this.iPF = jSONObject.optString("sign_notice");
                this.iRg = jSONObject.optInt("is_timeout");
                this.iRh = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iRi.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
