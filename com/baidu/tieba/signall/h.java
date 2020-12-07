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
    private int ncd;
    private String nce;
    private int ndG;
    private String ndH;
    private a ncy = new a();
    private ArrayList<i> ndI = new ArrayList<>();

    public int dMJ() {
        return this.ncd;
    }

    public String dMi() {
        return this.nce;
    }

    public a dMk() {
        return this.ncy;
    }

    public ArrayList<i> dMK() {
        return this.ndI;
    }

    public int dML() {
        return this.ndG;
    }

    public String dMM() {
        return this.ndH;
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
                this.ncy.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.ncd = jSONObject.optInt("show_dialog");
                this.nce = jSONObject.optString("sign_notice");
                this.ndG = jSONObject.optInt("is_timeout");
                this.ndH = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.ndI.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
