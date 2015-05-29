package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int chr;
    private String chs;
    private int ciM;
    private String ciN;
    private a chN = new a();
    private ArrayList<t> ciO = new ArrayList<>();

    public int akJ() {
        return this.chr;
    }

    public String akk() {
        return this.chs;
    }

    public a akm() {
        return this.chN;
    }

    public ArrayList<t> akK() {
        return this.ciO;
    }

    public int akL() {
        return this.ciM;
    }

    public String akM() {
        return this.ciN;
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
                this.chN.parserJson(jSONObject.optJSONObject("error"));
                this.chr = jSONObject.optInt("show_dialog");
                this.chs = jSONObject.optString("sign_notice");
                this.ciM = jSONObject.optInt("is_timeout");
                this.ciN = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.ciO.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
