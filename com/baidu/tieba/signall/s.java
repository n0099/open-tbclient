package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int bQd;
    private String bQe;
    private int bRw;
    private String bRx;
    private com.baidu.tieba.home.t bQz = new com.baidu.tieba.home.t();
    private ArrayList<t> bRy = new ArrayList<>();

    public int adT() {
        return this.bQd;
    }

    public String adt() {
        return this.bQe;
    }

    public com.baidu.tieba.home.t adv() {
        return this.bQz;
    }

    public ArrayList<t> adU() {
        return this.bRy;
    }

    public int adV() {
        return this.bRw;
    }

    public String adW() {
        return this.bRx;
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
                this.bQz.parserJson(jSONObject.optJSONObject("error"));
                this.bQd = jSONObject.optInt("show_dialog");
                this.bQe = jSONObject.optString("sign_notice");
                this.bRw = jSONObject.optInt("is_timeout");
                this.bRx = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.bRy.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
