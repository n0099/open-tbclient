package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int cOZ;
    private String cPa;
    private int cQt;
    private String cQu;
    private a cPv = new a();
    private ArrayList<q> cQv = new ArrayList<>();

    public int atI() {
        return this.cOZ;
    }

    public String atj() {
        return this.cPa;
    }

    public a atl() {
        return this.cPv;
    }

    public ArrayList<q> atJ() {
        return this.cQv;
    }

    public int atK() {
        return this.cQt;
    }

    public String atL() {
        return this.cQu;
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
                this.cPv.parserJson(jSONObject.optJSONObject("error"));
                this.cOZ = jSONObject.optInt("show_dialog");
                this.cPa = jSONObject.optString("sign_notice");
                this.cQt = jSONObject.optInt("is_timeout");
                this.cQu = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.cQv.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
