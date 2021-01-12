package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int ndf;
    private String ndg;
    private int neJ;
    private String neK;
    private a ndA = new a();
    private ArrayList<i> neL = new ArrayList<>();

    public int dIL() {
        return this.ndf;
    }

    public String dIk() {
        return this.ndg;
    }

    public a dIm() {
        return this.ndA;
    }

    public ArrayList<i> dIM() {
        return this.neL;
    }

    public int dIN() {
        return this.neJ;
    }

    public String dIO() {
        return this.neK;
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
                this.ndA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.ndf = jSONObject.optInt("show_dialog");
                this.ndg = jSONObject.optString("sign_notice");
                this.neJ = jSONObject.optInt("is_timeout");
                this.neK = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.neL.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
