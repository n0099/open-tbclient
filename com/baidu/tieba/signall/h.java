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
    private int her;
    private String hes;
    private int hfT;
    private String hfU;
    private a heN = new a();
    private ArrayList<i> hfV = new ArrayList<>();

    public int bAO() {
        return this.her;
    }

    public String bAm() {
        return this.hes;
    }

    public a bAo() {
        return this.heN;
    }

    public ArrayList<i> bAP() {
        return this.hfV;
    }

    public int bAQ() {
        return this.hfT;
    }

    public String bAR() {
        return this.hfU;
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
                this.heN.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.her = jSONObject.optInt("show_dialog");
                this.hes = jSONObject.optString("sign_notice");
                this.hfT = jSONObject.optInt("is_timeout");
                this.hfU = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.hfV.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
