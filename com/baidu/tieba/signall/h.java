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
    private int jXS;
    private String jXT;
    private int jZt;
    private String jZu;
    private a jYn = new a();
    private ArrayList<i> jZv = new ArrayList<>();

    public int cIZ() {
        return this.jXS;
    }

    public String cIx() {
        return this.jXT;
    }

    public a cIz() {
        return this.jYn;
    }

    public ArrayList<i> cJa() {
        return this.jZv;
    }

    public int cJb() {
        return this.jZt;
    }

    public String cJc() {
        return this.jZu;
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
                this.jYn.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jXS = jSONObject.optInt("show_dialog");
                this.jXT = jSONObject.optString("sign_notice");
                this.jZt = jSONObject.optInt("is_timeout");
                this.jZu = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jZv.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
