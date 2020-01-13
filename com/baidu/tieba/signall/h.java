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
    private String jWA;
    private int jWz;
    private int jYb;
    private String jYc;
    private a jWU = new a();
    private ArrayList<i> jYd = new ArrayList<>();

    public int cHq() {
        return this.jWz;
    }

    public String cGO() {
        return this.jWA;
    }

    public a cGQ() {
        return this.jWU;
    }

    public ArrayList<i> cHr() {
        return this.jYd;
    }

    public int cHs() {
        return this.jYb;
    }

    public String cHt() {
        return this.jYc;
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
                this.jWU.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jWz = jSONObject.optInt("show_dialog");
                this.jWA = jSONObject.optString("sign_notice");
                this.jYb = jSONObject.optInt("is_timeout");
                this.jYc = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jYd.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
