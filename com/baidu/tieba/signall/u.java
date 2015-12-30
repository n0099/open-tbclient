package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int dwD;
    private String dwE;
    private int dyf;
    private String dyg;
    private a dwZ = new a();
    private ArrayList<v> dyh = new ArrayList<>();

    public int aCa() {
        return this.dwD;
    }

    public String aBA() {
        return this.dwE;
    }

    public a aBC() {
        return this.dwZ;
    }

    public ArrayList<v> aCb() {
        return this.dyh;
    }

    public int aCc() {
        return this.dyf;
    }

    public String aCd() {
        return this.dyg;
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
                this.dwZ.parserJson(jSONObject.optJSONObject("error"));
                this.dwD = jSONObject.optInt("show_dialog");
                this.dwE = jSONObject.optString("sign_notice");
                this.dyf = jSONObject.optInt("is_timeout");
                this.dyg = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        v vVar = new v();
                        vVar.parserJson(jSONObject2);
                        this.dyh.add(vVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
