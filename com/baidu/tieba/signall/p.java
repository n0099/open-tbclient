package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int cQU;
    private String cQV;
    private int cSo;
    private String cSp;
    private a cRq = new a();
    private ArrayList<q> cSq = new ArrayList<>();

    public int auq() {
        return this.cQU;
    }

    public String atR() {
        return this.cQV;
    }

    public a atT() {
        return this.cRq;
    }

    public ArrayList<q> aur() {
        return this.cSq;
    }

    public int aus() {
        return this.cSo;
    }

    public String aut() {
        return this.cSp;
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
                this.cRq.parserJson(jSONObject.optJSONObject("error"));
                this.cQU = jSONObject.optInt("show_dialog");
                this.cQV = jSONObject.optString("sign_notice");
                this.cSo = jSONObject.optInt("is_timeout");
                this.cSp = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.cSq.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
