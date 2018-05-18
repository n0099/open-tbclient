package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gns;
    private String gnt;
    private int goU;
    private String goV;
    private a gnO = new a();
    private ArrayList<i> goW = new ArrayList<>();

    public int boK() {
        return this.gns;
    }

    public String boj() {
        return this.gnt;
    }

    public a bol() {
        return this.gnO;
    }

    public ArrayList<i> boL() {
        return this.goW;
    }

    public int boM() {
        return this.goU;
    }

    public String boN() {
        return this.goV;
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
                this.gnO.parserJson(jSONObject.optJSONObject("error"));
                this.gns = jSONObject.optInt("show_dialog");
                this.gnt = jSONObject.optString("sign_notice");
                this.goU = jSONObject.optInt("is_timeout");
                this.goV = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.goW.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
