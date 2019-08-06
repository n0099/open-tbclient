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
    private int iXf;
    private String iXg;
    private int iYH;
    private String iYI;
    private a iXB = new a();
    private ArrayList<i> iYJ = new ArrayList<>();

    public int cnB() {
        return this.iXf;
    }

    public String cmZ() {
        return this.iXg;
    }

    public a cnb() {
        return this.iXB;
    }

    public ArrayList<i> cnC() {
        return this.iYJ;
    }

    public int cnD() {
        return this.iYH;
    }

    public String cnE() {
        return this.iYI;
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
                this.iXB.parserJson(jSONObject.optJSONObject("error"));
                this.iXf = jSONObject.optInt("show_dialog");
                this.iXg = jSONObject.optString("sign_notice");
                this.iYH = jSONObject.optInt("is_timeout");
                this.iYI = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray(Config.LAUNCH_INFO);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iYJ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
