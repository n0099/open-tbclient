package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int muy;
    private String muz;
    private int mwc;
    private String mwd;
    private a muT = new a();
    private ArrayList<i> mwe = new ArrayList<>();

    public int dBS() {
        return this.muy;
    }

    public String dBq() {
        return this.muz;
    }

    public a dBs() {
        return this.muT;
    }

    public ArrayList<i> dBT() {
        return this.mwe;
    }

    public int dBU() {
        return this.mwc;
    }

    public String dBV() {
        return this.mwd;
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
                this.muT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.muy = jSONObject.optInt("show_dialog");
                this.muz = jSONObject.optString("sign_notice");
                this.mwc = jSONObject.optInt("is_timeout");
                this.mwd = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.mwe.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
