package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int ncf;
    private String ncg;
    private int ndI;
    private String ndJ;
    private a ncA = new a();
    private ArrayList<i> ndK = new ArrayList<>();

    public int dMK() {
        return this.ncf;
    }

    public String dMj() {
        return this.ncg;
    }

    public a dMl() {
        return this.ncA;
    }

    public ArrayList<i> dML() {
        return this.ndK;
    }

    public int dMM() {
        return this.ndI;
    }

    public String dMN() {
        return this.ndJ;
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
                this.ncA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.ncf = jSONObject.optInt("show_dialog");
                this.ncg = jSONObject.optString("sign_notice");
                this.ndI = jSONObject.optInt("is_timeout");
                this.ndJ = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.ndK.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
