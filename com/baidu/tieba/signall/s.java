package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int chs;
    private String cht;
    private int ciN;
    private String ciO;
    private a chO = new a();
    private ArrayList<t> ciP = new ArrayList<>();

    public int akK() {
        return this.chs;
    }

    public String akl() {
        return this.cht;
    }

    public a akn() {
        return this.chO;
    }

    public ArrayList<t> akL() {
        return this.ciP;
    }

    public int akM() {
        return this.ciN;
    }

    public String akN() {
        return this.ciO;
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
                this.chO.parserJson(jSONObject.optJSONObject("error"));
                this.chs = jSONObject.optInt("show_dialog");
                this.cht = jSONObject.optString("sign_notice");
                this.ciN = jSONObject.optInt("is_timeout");
                this.ciO = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.ciP.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
