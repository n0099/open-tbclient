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
    private int iYB;
    private String iYC;
    private int jad;
    private String jae;
    private a iYW = new a();
    private ArrayList<i> jaf = new ArrayList<>();

    public int cmc() {
        return this.iYB;
    }

    public String clA() {
        return this.iYC;
    }

    public a clC() {
        return this.iYW;
    }

    public ArrayList<i> cmd() {
        return this.jaf;
    }

    public int cme() {
        return this.jad;
    }

    public String cmf() {
        return this.jae;
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
                this.iYW.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.iYB = jSONObject.optInt("show_dialog");
                this.iYC = jSONObject.optString("sign_notice");
                this.jad = jSONObject.optInt("is_timeout");
                this.jae = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray(Config.LAUNCH_INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jaf.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
