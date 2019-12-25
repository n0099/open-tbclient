package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int jSX;
    private String jSY;
    private String jUA;
    private int jUz;
    private a jTs = new a();
    private ArrayList<i> jUB = new ArrayList<>();

    public int cGm() {
        return this.jSX;
    }

    public String cFK() {
        return this.jSY;
    }

    public a cFM() {
        return this.jTs;
    }

    public ArrayList<i> cGn() {
        return this.jUB;
    }

    public int cGo() {
        return this.jUz;
    }

    public String cGp() {
        return this.jUA;
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
                this.jTs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.jSX = jSONObject.optInt("show_dialog");
                this.jSY = jSONObject.optString("sign_notice");
                this.jUz = jSONObject.optInt("is_timeout");
                this.jUA = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.jUB.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
