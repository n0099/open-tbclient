package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int efh;
    private String efi;
    private int egI;
    private String egJ;
    private a efD = new a();
    private ArrayList<v> egK = new ArrayList<>();

    public int aPX() {
        return this.efh;
    }

    public String aPx() {
        return this.efi;
    }

    public a aPz() {
        return this.efD;
    }

    public ArrayList<v> aPY() {
        return this.egK;
    }

    public int aPZ() {
        return this.egI;
    }

    public String aQa() {
        return this.egJ;
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
                this.efD.parserJson(jSONObject.optJSONObject("error"));
                this.efh = jSONObject.optInt("show_dialog");
                this.efi = jSONObject.optString("sign_notice");
                this.egI = jSONObject.optInt("is_timeout");
                this.egJ = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        v vVar = new v();
                        vVar.parserJson(jSONObject2);
                        this.egK.add(vVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
