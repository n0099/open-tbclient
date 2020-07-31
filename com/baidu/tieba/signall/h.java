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
    private int lDy;
    private String lDz;
    private int lFc;
    private String lFd;
    private a lDT = new a();
    private ArrayList<i> lFe = new ArrayList<>();

    public int diO() {
        return this.lDy;
    }

    public String dim() {
        return this.lDz;
    }

    public a dio() {
        return this.lDT;
    }

    public ArrayList<i> diP() {
        return this.lFe;
    }

    public int diQ() {
        return this.lFc;
    }

    public String diR() {
        return this.lFd;
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
                this.lDT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lDy = jSONObject.optInt("show_dialog");
                this.lDz = jSONObject.optString("sign_notice");
                this.lFc = jSONObject.optInt("is_timeout");
                this.lFd = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lFe.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
