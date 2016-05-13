package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int eis;
    private String eit;
    private int ejT;
    private String ejU;
    private a eiO = new a();
    private ArrayList<v> ejV = new ArrayList<>();

    public int aQr() {
        return this.eis;
    }

    public String aPQ() {
        return this.eit;
    }

    public a aPS() {
        return this.eiO;
    }

    public ArrayList<v> aQs() {
        return this.ejV;
    }

    public int aQt() {
        return this.ejT;
    }

    public String aQu() {
        return this.ejU;
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
                this.eiO.parserJson(jSONObject.optJSONObject("error"));
                this.eis = jSONObject.optInt("show_dialog");
                this.eit = jSONObject.optString("sign_notice");
                this.ejT = jSONObject.optInt("is_timeout");
                this.ejU = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        v vVar = new v();
                        vVar.parserJson(jSONObject2);
                        this.ejV.add(vVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
