package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gCJ;
    private String gCK;
    private int gEl;
    private String gEm;
    private a gDf = new a();
    private ArrayList<i> gEn = new ArrayList<>();

    public int buk() {
        return this.gCJ;
    }

    public String btJ() {
        return this.gCK;
    }

    public a btL() {
        return this.gDf;
    }

    public ArrayList<i> bul() {
        return this.gEn;
    }

    public int bum() {
        return this.gEl;
    }

    public String bun() {
        return this.gEm;
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
                this.gDf.parserJson(jSONObject.optJSONObject("error"));
                this.gCJ = jSONObject.optInt("show_dialog");
                this.gCK = jSONObject.optString("sign_notice");
                this.gEl = jSONObject.optInt("is_timeout");
                this.gEm = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gEn.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
