package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int cBa;
    private String cBb;
    private int czG;
    private String czH;
    private a cAc = new a();
    private ArrayList<q> cBc = new ArrayList<>();

    public int anl() {
        return this.czG;
    }

    public String amM() {
        return this.czH;
    }

    public a amO() {
        return this.cAc;
    }

    public ArrayList<q> anm() {
        return this.cBc;
    }

    public int ann() {
        return this.cBa;
    }

    public String ano() {
        return this.cBb;
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
                this.cAc.parserJson(jSONObject.optJSONObject("error"));
                this.czG = jSONObject.optInt("show_dialog");
                this.czH = jSONObject.optString("sign_notice");
                this.cBa = jSONObject.optInt("is_timeout");
                this.cBb = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.cBc.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
