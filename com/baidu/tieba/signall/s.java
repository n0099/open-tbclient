package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int ccY;
    private String ccZ;
    private int ces;
    private String cet;
    private a cdu = new a();
    private ArrayList<t> ceu = new ArrayList<>();

    public int aiK() {
        return this.ccY;
    }

    public String ail() {
        return this.ccZ;
    }

    public a ain() {
        return this.cdu;
    }

    public ArrayList<t> aiL() {
        return this.ceu;
    }

    public int aiM() {
        return this.ces;
    }

    public String aiN() {
        return this.cet;
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
                this.cdu.parserJson(jSONObject.optJSONObject("error"));
                this.ccY = jSONObject.optInt("show_dialog");
                this.ccZ = jSONObject.optString("sign_notice");
                this.ces = jSONObject.optInt("is_timeout");
                this.cet = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.ceu.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
