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
    private int lbb;
    private String lbc;
    private int lcF;
    private String lcG;
    private a lbw = new a();
    private ArrayList<i> lcH = new ArrayList<>();

    public int daZ() {
        return this.lbb;
    }

    public String daw() {
        return this.lbc;
    }

    public a day() {
        return this.lbw;
    }

    public ArrayList<i> dba() {
        return this.lcH;
    }

    public int dbb() {
        return this.lcF;
    }

    public String dbc() {
        return this.lcG;
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
                this.lbw.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lbb = jSONObject.optInt("show_dialog");
                this.lbc = jSONObject.optString("sign_notice");
                this.lcF = jSONObject.optInt("is_timeout");
                this.lcG = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lcH.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
