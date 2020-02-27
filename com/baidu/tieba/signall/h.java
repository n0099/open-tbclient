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
    private int jXE;
    private String jXF;
    private int jZf;
    private String jZg;
    private a jXZ = new a();
    private ArrayList<i> jZh = new ArrayList<>();

    public int cIW() {
        return this.jXE;
    }

    public String cIu() {
        return this.jXF;
    }

    public a cIw() {
        return this.jXZ;
    }

    public ArrayList<i> cIX() {
        return this.jZh;
    }

    public int cIY() {
        return this.jZf;
    }

    public String cIZ() {
        return this.jZg;
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
                this.jXZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jXE = jSONObject.optInt("show_dialog");
                this.jXF = jSONObject.optString("sign_notice");
                this.jZf = jSONObject.optInt("is_timeout");
                this.jZg = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jZh.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
