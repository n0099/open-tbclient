package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int lDA;
    private String lDB;
    private int lFe;
    private String lFf;
    private a lDV = new a();
    private ArrayList<i> lFg = new ArrayList<>();

    public int diO() {
        return this.lDA;
    }

    public String dim() {
        return this.lDB;
    }

    public a dio() {
        return this.lDV;
    }

    public ArrayList<i> diP() {
        return this.lFg;
    }

    public int diQ() {
        return this.lFe;
    }

    public String diR() {
        return this.lFf;
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
                this.lDV.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lDA = jSONObject.optInt("show_dialog");
                this.lDB = jSONObject.optString("sign_notice");
                this.lFe = jSONObject.optInt("is_timeout");
                this.lFf = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lFg.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
