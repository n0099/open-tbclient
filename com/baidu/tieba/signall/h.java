package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gRi;
    private String gRj;
    private int gSK;
    private String gSL;
    private a gRE = new a();
    private ArrayList<i> gSM = new ArrayList<>();

    public int btD() {
        return this.gRi;
    }

    public String btc() {
        return this.gRj;
    }

    public a bte() {
        return this.gRE;
    }

    public ArrayList<i> btE() {
        return this.gSM;
    }

    public int btF() {
        return this.gSK;
    }

    public String btG() {
        return this.gSL;
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
                this.gRE.parserJson(jSONObject.optJSONObject("error"));
                this.gRi = jSONObject.optInt("show_dialog");
                this.gRj = jSONObject.optString("sign_notice");
                this.gSK = jSONObject.optInt("is_timeout");
                this.gSL = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gSM.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
