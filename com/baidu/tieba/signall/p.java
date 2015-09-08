package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int cIe;
    private String cIf;
    private int cJy;
    private String cJz;
    private a cIA = new a();
    private ArrayList<q> cJA = new ArrayList<>();

    public int aru() {
        return this.cIe;
    }

    public String aqV() {
        return this.cIf;
    }

    public a aqX() {
        return this.cIA;
    }

    public ArrayList<q> arv() {
        return this.cJA;
    }

    public int arw() {
        return this.cJy;
    }

    public String arx() {
        return this.cJz;
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
                this.cIA.parserJson(jSONObject.optJSONObject("error"));
                this.cIe = jSONObject.optInt("show_dialog");
                this.cIf = jSONObject.optString("sign_notice");
                this.cJy = jSONObject.optInt("is_timeout");
                this.cJz = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(jSONObject2);
                        this.cJA.add(qVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
