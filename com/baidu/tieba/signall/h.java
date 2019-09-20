package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int iZA;
    private String iZB;
    private int jbc;
    private String jbd;
    private a iZW = new a();
    private ArrayList<i> jbe = new ArrayList<>();

    public int coo() {
        return this.iZA;
    }

    public String cnM() {
        return this.iZB;
    }

    public a cnO() {
        return this.iZW;
    }

    public ArrayList<i> cop() {
        return this.jbe;
    }

    public int coq() {
        return this.jbc;
    }

    public String cor() {
        return this.jbd;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
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
                this.iZW.parserJson(jSONObject.optJSONObject("error"));
                this.iZA = jSONObject.optInt("show_dialog");
                this.iZB = jSONObject.optString("sign_notice");
                this.jbc = jSONObject.optInt("is_timeout");
                this.jbd = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray(Config.LAUNCH_INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jbe.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
