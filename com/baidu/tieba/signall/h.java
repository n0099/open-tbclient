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
    private int lwh;
    private String lwi;
    private int lxL;
    private String lxM;
    private a lwC = new a();
    private ArrayList<i> lxN = new ArrayList<>();

    public int dfE() {
        return this.lwh;
    }

    public String dfc() {
        return this.lwi;
    }

    public a dfe() {
        return this.lwC;
    }

    public ArrayList<i> dfF() {
        return this.lxN;
    }

    public int dfG() {
        return this.lxL;
    }

    public String dfH() {
        return this.lxM;
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
                this.lwC.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lwh = jSONObject.optInt("show_dialog");
                this.lwi = jSONObject.optString("sign_notice");
                this.lxL = jSONObject.optInt("is_timeout");
                this.lxM = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lxN.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
