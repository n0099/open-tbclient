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
    private int gSV;
    private String gSW;
    private a gTr = new a();
    private ArrayList<i> gUA = new ArrayList<>();
    private int gUy;
    private String gUz;

    public int byJ() {
        return this.gSV;
    }

    public String byh() {
        return this.gSW;
    }

    public a byj() {
        return this.gTr;
    }

    public ArrayList<i> byK() {
        return this.gUA;
    }

    public int byL() {
        return this.gUy;
    }

    public String byM() {
        return this.gUz;
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
                this.gTr.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.gSV = jSONObject.optInt("show_dialog");
                this.gSW = jSONObject.optString("sign_notice");
                this.gUy = jSONObject.optInt("is_timeout");
                this.gUz = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gUA.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
