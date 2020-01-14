package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int jWE;
    private String jWF;
    private int jYg;
    private String jYh;
    private a jWZ = new a();
    private ArrayList<i> jYi = new ArrayList<>();

    public int cHs() {
        return this.jWE;
    }

    public String cGQ() {
        return this.jWF;
    }

    public a cGS() {
        return this.jWZ;
    }

    public ArrayList<i> cHt() {
        return this.jYi;
    }

    public int cHu() {
        return this.jYg;
    }

    public String cHv() {
        return this.jYh;
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
                this.jWZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jWE = jSONObject.optInt("show_dialog");
                this.jWF = jSONObject.optString("sign_notice");
                this.jYg = jSONObject.optInt("is_timeout");
                this.jYh = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jYi.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
