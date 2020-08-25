package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int lVe;
    private String lVf;
    private int lWJ;
    private String lWK;
    private a lVz = new a();
    private ArrayList<i> lWL = new ArrayList<>();

    public int duj() {
        return this.lVe;
    }

    public String dtH() {
        return this.lVf;
    }

    public a dtJ() {
        return this.lVz;
    }

    public ArrayList<i> duk() {
        return this.lWL;
    }

    public int dul() {
        return this.lWJ;
    }

    public String dum() {
        return this.lWK;
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
                this.lVz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.lVe = jSONObject.optInt("show_dialog");
                this.lVf = jSONObject.optString("sign_notice");
                this.lWJ = jSONObject.optInt("is_timeout");
                this.lWK = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.lWL.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
