package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int bKe;
    private String bKf;
    private int bLw;
    private String bLx;
    private com.baidu.tieba.home.t bKA = new com.baidu.tieba.home.t();
    private ArrayList<t> bLy = new ArrayList<>();

    public int acY() {
        return this.bKe;
    }

    public String acz() {
        return this.bKf;
    }

    public com.baidu.tieba.home.t acB() {
        return this.bKA;
    }

    public ArrayList<t> acZ() {
        return this.bLy;
    }

    public int ada() {
        return this.bLw;
    }

    public String adb() {
        return this.bLx;
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
                this.bKA.parserJson(jSONObject.optJSONObject("error"));
                this.bKe = jSONObject.optInt("show_dialog");
                this.bKf = jSONObject.optString("sign_notice");
                this.bLw = jSONObject.optInt("is_timeout");
                this.bLx = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray(LoginActivityConfig.INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        t tVar = new t();
                        tVar.parserJson(jSONObject2);
                        this.bLy.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
