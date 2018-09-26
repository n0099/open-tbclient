package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int gLx;
    private String gLy;
    private int gNa;
    private String gNb;
    private a gLT = new a();
    private ArrayList<i> gNc = new ArrayList<>();

    public int bvu() {
        return this.gLx;
    }

    public String buS() {
        return this.gLy;
    }

    public a buU() {
        return this.gLT;
    }

    public ArrayList<i> bvv() {
        return this.gNc;
    }

    public int bvw() {
        return this.gNa;
    }

    public String bvx() {
        return this.gNb;
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
                this.gLT.parserJson(jSONObject.optJSONObject("error"));
                this.gLx = jSONObject.optInt("show_dialog");
                this.gLy = jSONObject.optString("sign_notice");
                this.gNa = jSONObject.optInt("is_timeout");
                this.gNb = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.gNc.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
