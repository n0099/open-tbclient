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
    private int ixg;
    private String ixh;
    private int iyI;
    private String iyJ;
    private a ixC = new a();
    private ArrayList<i> iyK = new ArrayList<>();

    public int cco() {
        return this.ixg;
    }

    public String cbM() {
        return this.ixh;
    }

    public a cbO() {
        return this.ixC;
    }

    public ArrayList<i> ccp() {
        return this.iyK;
    }

    public int ccq() {
        return this.iyI;
    }

    public String ccr() {
        return this.iyJ;
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
                this.ixC.parserJson(jSONObject.optJSONObject("error"));
                this.ixg = jSONObject.optInt("show_dialog");
                this.ixh = jSONObject.optString("sign_notice");
                this.iyI = jSONObject.optInt("is_timeout");
                this.iyJ = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.iyK.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
