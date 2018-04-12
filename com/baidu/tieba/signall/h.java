package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gmp;
    private String gmq;
    private int gnR;
    private String gnS;
    private a gmL = new a();
    private ArrayList<i> gnT = new ArrayList<>();

    public int boM() {
        return this.gmp;
    }

    public String bol() {
        return this.gmq;
    }

    public a bon() {
        return this.gmL;
    }

    public ArrayList<i> boN() {
        return this.gnT;
    }

    public int boO() {
        return this.gnR;
    }

    public String boP() {
        return this.gnS;
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
                this.gmL.parserJson(jSONObject.optJSONObject("error"));
                this.gmp = jSONObject.optInt("show_dialog");
                this.gmq = jSONObject.optString("sign_notice");
                this.gnR = jSONObject.optInt("is_timeout");
                this.gnS = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gnT.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
