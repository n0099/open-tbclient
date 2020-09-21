package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int meV;
    private String meW;
    private String mgA;
    private int mgz;
    private a mfq = new a();
    private ArrayList<i> mgB = new ArrayList<>();

    public int dyh() {
        return this.meV;
    }

    public String dxF() {
        return this.meW;
    }

    public a dxH() {
        return this.mfq;
    }

    public ArrayList<i> dyi() {
        return this.mgB;
    }

    public int dyj() {
        return this.mgz;
    }

    public String dyk() {
        return this.mgA;
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
                this.mfq.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.meV = jSONObject.optInt("show_dialog");
                this.meW = jSONObject.optString("sign_notice");
                this.mgz = jSONObject.optInt("is_timeout");
                this.mgA = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.mgB.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
