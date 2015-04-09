package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int cdn;
    private String cdo;
    private int ceH;
    private String ceI;
    private a cdJ = new a();
    private ArrayList<t> ceJ = new ArrayList<>();

    public int aiZ() {
        return this.cdn;
    }

    public String aiA() {
        return this.cdo;
    }

    public a aiC() {
        return this.cdJ;
    }

    public ArrayList<t> aja() {
        return this.ceJ;
    }

    public int ajb() {
        return this.ceH;
    }

    public String ajc() {
        return this.ceI;
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
                this.cdJ.parserJson(jSONObject.optJSONObject("error"));
                this.cdn = jSONObject.optInt("show_dialog");
                this.cdo = jSONObject.optString("sign_notice");
                this.ceH = jSONObject.optInt("is_timeout");
                this.ceI = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.ceJ.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
