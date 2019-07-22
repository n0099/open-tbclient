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
    private int iWb;
    private String iWc;
    private int iXD;
    private String iXE;
    private a iWx = new a();
    private ArrayList<i> iXF = new ArrayList<>();

    public int cnj() {
        return this.iWb;
    }

    public String cmH() {
        return this.iWc;
    }

    public a cmJ() {
        return this.iWx;
    }

    public ArrayList<i> cnk() {
        return this.iXF;
    }

    public int cnl() {
        return this.iXD;
    }

    public String cnm() {
        return this.iXE;
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
                this.iWx.parserJson(jSONObject.optJSONObject("error"));
                this.iWb = jSONObject.optInt("show_dialog");
                this.iWc = jSONObject.optString("sign_notice");
                this.iXD = jSONObject.optInt("is_timeout");
                this.iXE = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray(Config.LAUNCH_INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iXF.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
