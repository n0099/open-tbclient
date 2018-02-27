package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gQT;
    private String gQU;
    private int gSv;
    private String gSw;
    private a gRp = new a();
    private ArrayList<i> gSx = new ArrayList<>();

    public int btC() {
        return this.gQT;
    }

    public String btb() {
        return this.gQU;
    }

    public a btd() {
        return this.gRp;
    }

    public ArrayList<i> btD() {
        return this.gSx;
    }

    public int btE() {
        return this.gSv;
    }

    public String btF() {
        return this.gSw;
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
                this.gRp.parserJson(jSONObject.optJSONObject("error"));
                this.gQT = jSONObject.optInt("show_dialog");
                this.gQU = jSONObject.optString("sign_notice");
                this.gSv = jSONObject.optInt("is_timeout");
                this.gSw = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gSx.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
