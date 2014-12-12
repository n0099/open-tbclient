package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int bOu;
    private String bOv;
    private int bPN;
    private String bPO;
    private com.baidu.tieba.home.u bOQ = new com.baidu.tieba.home.u();
    private ArrayList<t> bPP = new ArrayList<>();

    public int adu() {
        return this.bOu;
    }

    public String acU() {
        return this.bOv;
    }

    public com.baidu.tieba.home.u acW() {
        return this.bOQ;
    }

    public ArrayList<t> adv() {
        return this.bPP;
    }

    public int adw() {
        return this.bPN;
    }

    public String adx() {
        return this.bPO;
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
                this.bOQ.parserJson(jSONObject.optJSONObject("error"));
                this.bOu = jSONObject.optInt("show_dialog");
                this.bOv = jSONObject.optString("sign_notice");
                this.bPN = jSONObject.optInt("is_timeout");
                this.bPO = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.bPP.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
