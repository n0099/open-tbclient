package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int iZs;
    private String iZt;
    private int jaU;
    private String jaV;
    private a iZN = new a();
    private ArrayList<i> jaW = new ArrayList<>();

    public int cme() {
        return this.iZs;
    }

    public String clC() {
        return this.iZt;
    }

    public a clE() {
        return this.iZN;
    }

    public ArrayList<i> cmf() {
        return this.jaW;
    }

    public int cmg() {
        return this.jaU;
    }

    public String cmh() {
        return this.jaV;
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
                this.iZN.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.iZs = jSONObject.optInt("show_dialog");
                this.iZt = jSONObject.optString("sign_notice");
                this.jaU = jSONObject.optInt("is_timeout");
                this.jaV = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray(Config.LAUNCH_INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jaW.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
