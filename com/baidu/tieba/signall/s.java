package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int bQe;
    private String bQf;
    private int bRx;
    private String bRy;
    private com.baidu.tieba.home.t bQA = new com.baidu.tieba.home.t();
    private ArrayList<t> bRz = new ArrayList<>();

    public int adY() {
        return this.bQe;
    }

    public String ady() {
        return this.bQf;
    }

    public com.baidu.tieba.home.t adA() {
        return this.bQA;
    }

    public ArrayList<t> adZ() {
        return this.bRz;
    }

    public int aea() {
        return this.bRx;
    }

    public String aeb() {
        return this.bRy;
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
                this.bQA.parserJson(jSONObject.optJSONObject("error"));
                this.bQe = jSONObject.optInt("show_dialog");
                this.bQf = jSONObject.optString("sign_notice");
                this.bRx = jSONObject.optInt("is_timeout");
                this.bRy = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.bRz.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
