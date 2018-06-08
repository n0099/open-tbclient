package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gAs;
    private String gAt;
    private int gyQ;
    private String gyR;
    private a gzm = new a();
    private ArrayList<i> gAu = new ArrayList<>();

    public int btK() {
        return this.gyQ;
    }

    public String btj() {
        return this.gyR;
    }

    public a btl() {
        return this.gzm;
    }

    public ArrayList<i> btL() {
        return this.gAu;
    }

    public int btM() {
        return this.gAs;
    }

    public String btN() {
        return this.gAt;
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
                this.gzm.parserJson(jSONObject.optJSONObject("error"));
                this.gyQ = jSONObject.optInt("show_dialog");
                this.gyR = jSONObject.optString("sign_notice");
                this.gAs = jSONObject.optInt("is_timeout");
                this.gAt = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gAu.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
