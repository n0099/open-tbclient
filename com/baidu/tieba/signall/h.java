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
    private int jXG;
    private String jXH;
    private int jZh;
    private String jZi;
    private a jYb = new a();
    private ArrayList<i> jZj = new ArrayList<>();

    public int cIY() {
        return this.jXG;
    }

    public String cIw() {
        return this.jXH;
    }

    public a cIy() {
        return this.jYb;
    }

    public ArrayList<i> cIZ() {
        return this.jZj;
    }

    public int cJa() {
        return this.jZh;
    }

    public String cJb() {
        return this.jZi;
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
                this.jYb.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jXG = jSONObject.optInt("show_dialog");
                this.jXH = jSONObject.optString("sign_notice");
                this.jZh = jSONObject.optInt("is_timeout");
                this.jZi = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jZj.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
