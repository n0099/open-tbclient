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
    private int kIH;
    private String kII;
    private int kKl;
    private String kKm;
    private a kJc = new a();
    private ArrayList<i> kKn = new ArrayList<>();

    public int cTX() {
        return this.kIH;
    }

    public String cTu() {
        return this.kII;
    }

    public a cTw() {
        return this.kJc;
    }

    public ArrayList<i> cTY() {
        return this.kKn;
    }

    public int cTZ() {
        return this.kKl;
    }

    public String cUa() {
        return this.kKm;
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
                this.kJc.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.kIH = jSONObject.optInt("show_dialog");
                this.kII = jSONObject.optString("sign_notice");
                this.kKl = jSONObject.optInt("is_timeout");
                this.kKm = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.kKn.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
