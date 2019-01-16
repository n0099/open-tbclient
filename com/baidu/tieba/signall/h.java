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
    private int hfv;
    private String hfw;
    private int hgX;
    private String hgY;
    private a hfR = new a();
    private ArrayList<i> hgZ = new ArrayList<>();

    public int bBx() {
        return this.hfv;
    }

    public String bAV() {
        return this.hfw;
    }

    public a bAX() {
        return this.hfR;
    }

    public ArrayList<i> bBy() {
        return this.hgZ;
    }

    public int bBz() {
        return this.hgX;
    }

    public String bBA() {
        return this.hgY;
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
                this.hfR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.hfv = jSONObject.optInt("show_dialog");
                this.hfw = jSONObject.optString("sign_notice");
                this.hgX = jSONObject.optInt("is_timeout");
                this.hgY = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.hgZ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
