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
    private int nmN;
    private String nmO;
    private int noq;
    private String nor;
    private a nni = new a();
    private ArrayList<i> nos = new ArrayList<>();

    public int dKW() {
        return this.nmN;
    }

    public String dKv() {
        return this.nmO;
    }

    public a dKx() {
        return this.nni;
    }

    public ArrayList<i> dKX() {
        return this.nos;
    }

    public int dKY() {
        return this.noq;
    }

    public String dKZ() {
        return this.nor;
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
                this.nni.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.nmN = jSONObject.optInt("show_dialog");
                this.nmO = jSONObject.optString("sign_notice");
                this.noq = jSONObject.optInt("is_timeout");
                this.nor = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.nos.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
