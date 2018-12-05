package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int hbn;
    private String hbo;
    private int hcP;
    private String hcQ;
    private a hbJ = new a();
    private ArrayList<i> hcR = new ArrayList<>();

    public int bzZ() {
        return this.hbn;
    }

    public String bzx() {
        return this.hbo;
    }

    public a bzz() {
        return this.hbJ;
    }

    public ArrayList<i> bAa() {
        return this.hcR;
    }

    public int bAb() {
        return this.hcP;
    }

    public String bAc() {
        return this.hcQ;
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
                this.hbJ.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.hbn = jSONObject.optInt("show_dialog");
                this.hbo = jSONObject.optString("sign_notice");
                this.hcP = jSONObject.optInt("is_timeout");
                this.hcQ = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.hcR.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
