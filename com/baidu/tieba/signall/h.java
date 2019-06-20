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
    private int iPK;
    private String iPL;
    private int iRm;
    private String iRn;
    private a iQg = new a();
    private ArrayList<i> iRo = new ArrayList<>();

    public int cks() {
        return this.iPK;
    }

    public String cjQ() {
        return this.iPL;
    }

    public a cjS() {
        return this.iQg;
    }

    public ArrayList<i> ckt() {
        return this.iRo;
    }

    public int cku() {
        return this.iRm;
    }

    public String ckv() {
        return this.iRn;
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
                this.iQg.parserJson(jSONObject.optJSONObject("error"));
                this.iPK = jSONObject.optInt("show_dialog");
                this.iPL = jSONObject.optString("sign_notice");
                this.iRm = jSONObject.optInt("is_timeout");
                this.iRn = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iRo.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
