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
    private int kIL;
    private String kIM;
    private int kKp;
    private String kKq;
    private a kJg = new a();
    private ArrayList<i> kKr = new ArrayList<>();

    public int cTV() {
        return this.kIL;
    }

    public String cTs() {
        return this.kIM;
    }

    public a cTu() {
        return this.kJg;
    }

    public ArrayList<i> cTW() {
        return this.kKr;
    }

    public int cTX() {
        return this.kKp;
    }

    public String cTY() {
        return this.kKq;
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
                this.kJg.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.kIL = jSONObject.optInt("show_dialog");
                this.kIM = jSONObject.optString("sign_notice");
                this.kKp = jSONObject.optInt("is_timeout");
                this.kKq = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.kKr.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
