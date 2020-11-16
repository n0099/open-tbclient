package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int mNX;
    private String mNY;
    private int mPC;
    private String mPD;
    private a mOs = new a();
    private ArrayList<i> mPE = new ArrayList<>();

    public int dHt() {
        return this.mNX;
    }

    public String dGR() {
        return this.mNY;
    }

    public a dGT() {
        return this.mOs;
    }

    public ArrayList<i> dHu() {
        return this.mPE;
    }

    public int dHv() {
        return this.mPC;
    }

    public String dHw() {
        return this.mPD;
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
                this.mOs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.mNX = jSONObject.optInt("show_dialog");
                this.mNY = jSONObject.optString("sign_notice");
                this.mPC = jSONObject.optInt("is_timeout");
                this.mPD = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.mPE.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
