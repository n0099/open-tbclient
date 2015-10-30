package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int cPy;
    private String cPz;
    private int cQS;
    private String cQT;
    private a cPU = new a();
    private ArrayList<q> cQU = new ArrayList<>();

    public int atK() {
        return this.cPy;
    }

    public String atl() {
        return this.cPz;
    }

    public a atn() {
        return this.cPU;
    }

    public ArrayList<q> atL() {
        return this.cQU;
    }

    public int atM() {
        return this.cQS;
    }

    public String atN() {
        return this.cQT;
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
                this.cPU.parserJson(jSONObject.optJSONObject("error"));
                this.cPy = jSONObject.optInt("show_dialog");
                this.cPz = jSONObject.optString("sign_notice");
                this.cQS = jSONObject.optInt("is_timeout");
                this.cQT = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.cQU.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
