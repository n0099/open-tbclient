package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int lck;
    private String lcl;
    private int ldO;
    private String ldP;
    private a lcF = new a();
    private ArrayList<i> ldQ = new ArrayList<>();

    public int dbp() {
        return this.lck;
    }

    public String daM() {
        return this.lcl;
    }

    public a daO() {
        return this.lcF;
    }

    public ArrayList<i> dbq() {
        return this.ldQ;
    }

    public int dbr() {
        return this.ldO;
    }

    public String dbs() {
        return this.ldP;
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
                this.lcF.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lck = jSONObject.optInt("show_dialog");
                this.lcl = jSONObject.optString("sign_notice");
                this.ldO = jSONObject.optInt("is_timeout");
                this.ldP = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.ldQ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
