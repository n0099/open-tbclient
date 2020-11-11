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
    private int mNe;
    private String mNf;
    private int mOH;
    private String mOI;
    private a mNz = new a();
    private ArrayList<i> mOJ = new ArrayList<>();

    public int dHC() {
        return this.mNe;
    }

    public String dHa() {
        return this.mNf;
    }

    public a dHc() {
        return this.mNz;
    }

    public ArrayList<i> dHD() {
        return this.mOJ;
    }

    public int dHE() {
        return this.mOH;
    }

    public String dHF() {
        return this.mOI;
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
                this.mNz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.mNe = jSONObject.optInt("show_dialog");
                this.mNf = jSONObject.optString("sign_notice");
                this.mOH = jSONObject.optInt("is_timeout");
                this.mOI = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.mOJ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
