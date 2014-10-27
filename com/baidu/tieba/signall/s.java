package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int bJP;
    private String bJQ;
    private int bLh;
    private String bLi;
    private com.baidu.tieba.home.t bKl = new com.baidu.tieba.home.t();
    private ArrayList<t> bLj = new ArrayList<>();

    public int acV() {
        return this.bJP;
    }

    public String acw() {
        return this.bJQ;
    }

    public com.baidu.tieba.home.t acy() {
        return this.bKl;
    }

    public ArrayList<t> acW() {
        return this.bLj;
    }

    public int acX() {
        return this.bLh;
    }

    public String acY() {
        return this.bLi;
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
                this.bKl.parserJson(jSONObject.optJSONObject("error"));
                this.bJP = jSONObject.optInt("show_dialog");
                this.bJQ = jSONObject.optString("sign_notice");
                this.bLh = jSONObject.optInt("is_timeout");
                this.bLi = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.bLj.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
