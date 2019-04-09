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
    private int iwR;
    private String iwS;
    private int iyt;
    private String iyu;
    private a ixn = new a();
    private ArrayList<i> iyv = new ArrayList<>();

    public int cck() {
        return this.iwR;
    }

    public String cbI() {
        return this.iwS;
    }

    public a cbK() {
        return this.ixn;
    }

    public ArrayList<i> ccl() {
        return this.iyv;
    }

    public int ccm() {
        return this.iyt;
    }

    public String ccn() {
        return this.iyu;
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
                this.ixn.parserJson(jSONObject.optJSONObject("error"));
                this.iwR = jSONObject.optInt("show_dialog");
                this.iwS = jSONObject.optString("sign_notice");
                this.iyt = jSONObject.optInt("is_timeout");
                this.iyu = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iyv.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
