package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int iwQ;
    private String iwR;
    private int iys;
    private String iyt;
    private a ixm = new a();
    private ArrayList<i> iyu = new ArrayList<>();

    public int cck() {
        return this.iwQ;
    }

    public String cbI() {
        return this.iwR;
    }

    public a cbK() {
        return this.ixm;
    }

    public ArrayList<i> ccl() {
        return this.iyu;
    }

    public int ccm() {
        return this.iys;
    }

    public String ccn() {
        return this.iyt;
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
                this.ixm.parserJson(jSONObject.optJSONObject("error"));
                this.iwQ = jSONObject.optInt("show_dialog");
                this.iwR = jSONObject.optString("sign_notice");
                this.iys = jSONObject.optInt("is_timeout");
                this.iyt = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iyu.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
