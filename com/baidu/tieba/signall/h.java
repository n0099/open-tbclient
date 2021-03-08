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
    private int npt;
    private String npu;
    private int nqW;
    private String nqX;
    private a npO = new a();
    private ArrayList<i> nqY = new ArrayList<>();

    public int dLm() {
        return this.npt;
    }

    public String dKL() {
        return this.npu;
    }

    public a dKN() {
        return this.npO;
    }

    public ArrayList<i> dLn() {
        return this.nqY;
    }

    public int dLo() {
        return this.nqW;
    }

    public String dLp() {
        return this.nqX;
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
                this.npO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.npt = jSONObject.optInt("show_dialog");
                this.npu = jSONObject.optString("sign_notice");
                this.nqW = jSONObject.optInt("is_timeout");
                this.nqX = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.nqY.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
