package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int dMH;
    private String dMI;
    private int dOj;
    private String dOk;
    private a dNd = new a();
    private ArrayList<v> dOl = new ArrayList<>();

    public int aJh() {
        return this.dMH;
    }

    public String aIH() {
        return this.dMI;
    }

    public a aIJ() {
        return this.dNd;
    }

    public ArrayList<v> aJi() {
        return this.dOl;
    }

    public int aJj() {
        return this.dOj;
    }

    public String aJk() {
        return this.dOk;
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
                this.dNd.parserJson(jSONObject.optJSONObject("error"));
                this.dMH = jSONObject.optInt("show_dialog");
                this.dMI = jSONObject.optString("sign_notice");
                this.dOj = jSONObject.optInt("is_timeout");
                this.dOk = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        v vVar = new v();
                        vVar.parserJson(jSONObject2);
                        this.dOl.add(vVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
