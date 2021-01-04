package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int nhL;
    private String nhM;
    private int njp;
    private String njq;
    private a nih = new a();
    private ArrayList<i> njr = new ArrayList<>();

    public int dMC() {
        return this.nhL;
    }

    public String dMb() {
        return this.nhM;
    }

    public a dMd() {
        return this.nih;
    }

    public ArrayList<i> dMD() {
        return this.njr;
    }

    public int dME() {
        return this.njp;
    }

    public String dMF() {
        return this.njq;
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
                this.nih.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.nhL = jSONObject.optInt("show_dialog");
                this.nhM = jSONObject.optString("sign_notice");
                this.njp = jSONObject.optInt("is_timeout");
                this.njq = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.njr.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
