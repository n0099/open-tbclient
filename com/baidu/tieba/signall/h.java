package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int nhK;
    private String nhL;
    private int njo;
    private String njp;
    private a nig = new a();
    private ArrayList<i> njq = new ArrayList<>();

    public int dMD() {
        return this.nhK;
    }

    public String dMc() {
        return this.nhL;
    }

    public a dMe() {
        return this.nig;
    }

    public ArrayList<i> dME() {
        return this.njq;
    }

    public int dMF() {
        return this.njo;
    }

    public String dMG() {
        return this.njp;
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
                this.nig.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.nhK = jSONObject.optInt("show_dialog");
                this.nhL = jSONObject.optString("sign_notice");
                this.njo = jSONObject.optInt("is_timeout");
                this.njp = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.njq.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
