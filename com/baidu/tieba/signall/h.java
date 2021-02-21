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
    private int nnn;
    private String nno;
    private int noS;
    private String noT;
    private a nnI = new a();
    private ArrayList<i> noU = new ArrayList<>();

    public int dLe() {
        return this.nnn;
    }

    public String dKD() {
        return this.nno;
    }

    public a dKF() {
        return this.nnI;
    }

    public ArrayList<i> dLf() {
        return this.noU;
    }

    public int dLg() {
        return this.noS;
    }

    public String dLh() {
        return this.noT;
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
                this.nnI.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.nnn = jSONObject.optInt("show_dialog");
                this.nno = jSONObject.optString("sign_notice");
                this.noS = jSONObject.optInt("is_timeout");
                this.noT = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.noU.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
