package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gmm;
    private String gmn;
    private int gnO;
    private String gnP;
    private a gmI = new a();
    private ArrayList<i> gnQ = new ArrayList<>();

    public int boM() {
        return this.gmm;
    }

    public String bol() {
        return this.gmn;
    }

    public a bon() {
        return this.gmI;
    }

    public ArrayList<i> boN() {
        return this.gnQ;
    }

    public int boO() {
        return this.gnO;
    }

    public String boP() {
        return this.gnP;
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
                this.gmI.parserJson(jSONObject.optJSONObject("error"));
                this.gmm = jSONObject.optInt("show_dialog");
                this.gmn = jSONObject.optString("sign_notice");
                this.gnO = jSONObject.optInt("is_timeout");
                this.gnP = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gnQ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
