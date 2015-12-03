package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int dpr;
    private String dps;
    private int dqL;
    private String dqM;
    private a dpN = new a();
    private ArrayList<q> dqN = new ArrayList<>();

    public int azS() {
        return this.dpr;
    }

    public String azt() {
        return this.dps;
    }

    public a azv() {
        return this.dpN;
    }

    public ArrayList<q> azT() {
        return this.dqN;
    }

    public int azU() {
        return this.dqL;
    }

    public String azV() {
        return this.dqM;
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
                this.dpN.parserJson(jSONObject.optJSONObject("error"));
                this.dpr = jSONObject.optInt("show_dialog");
                this.dps = jSONObject.optString("sign_notice");
                this.dqL = jSONObject.optInt("is_timeout");
                this.dqM = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.dqN.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
