package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int jZu;
    private String jZv;
    private int kaW;
    private String kaX;
    private a jZP = new a();
    private ArrayList<i> kaY = new ArrayList<>();

    public int cJt() {
        return this.jZu;
    }

    public String cIR() {
        return this.jZv;
    }

    public a cIT() {
        return this.jZP;
    }

    public ArrayList<i> cJu() {
        return this.kaY;
    }

    public int cJv() {
        return this.kaW;
    }

    public String cJw() {
        return this.kaX;
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
                this.jZP.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jZu = jSONObject.optInt("show_dialog");
                this.jZv = jSONObject.optString("sign_notice");
                this.kaW = jSONObject.optInt("is_timeout");
                this.kaX = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.kaY.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
