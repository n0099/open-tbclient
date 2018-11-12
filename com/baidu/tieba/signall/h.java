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
    private int gUv;
    private String gUw;
    private int gVX;
    private String gVY;
    private a gUR = new a();
    private ArrayList<i> gVZ = new ArrayList<>();

    public int byf() {
        return this.gUv;
    }

    public String bxD() {
        return this.gUw;
    }

    public a bxF() {
        return this.gUR;
    }

    public ArrayList<i> byg() {
        return this.gVZ;
    }

    public int byh() {
        return this.gVX;
    }

    public String byi() {
        return this.gVY;
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
                this.gUR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.gUv = jSONObject.optInt("show_dialog");
                this.gUw = jSONObject.optString("sign_notice");
                this.gVX = jSONObject.optInt("is_timeout");
                this.gVY = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gVZ.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
