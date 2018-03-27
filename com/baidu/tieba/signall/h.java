package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gRj;
    private String gRk;
    private int gSL;
    private String gSM;
    private a gRF = new a();
    private ArrayList<i> gSN = new ArrayList<>();

    public int btD() {
        return this.gRj;
    }

    public String btc() {
        return this.gRk;
    }

    public a bte() {
        return this.gRF;
    }

    public ArrayList<i> btE() {
        return this.gSN;
    }

    public int btF() {
        return this.gSL;
    }

    public String btG() {
        return this.gSM;
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
                this.gRF.parserJson(jSONObject.optJSONObject("error"));
                this.gRj = jSONObject.optInt("show_dialog");
                this.gRk = jSONObject.optString("sign_notice");
                this.gSL = jSONObject.optInt("is_timeout");
                this.gSM = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gSN.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
