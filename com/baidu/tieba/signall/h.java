package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class h {
    private int errorCode;
    private String errorMsg;
    private int mHe;
    private String mHf;
    private int mIM;
    private String mIN;
    private a mHz = new a();
    private ArrayList<i> mIO = new ArrayList<>();

    public int dFa() {
        return this.mHe;
    }

    public String dEy() {
        return this.mHf;
    }

    public a dEA() {
        return this.mHz;
    }

    public ArrayList<i> dFb() {
        return this.mIO;
    }

    public int dFc() {
        return this.mIM;
    }

    public String dFd() {
        return this.mIN;
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
                this.mHz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.mHe = jSONObject.optInt("show_dialog");
                this.mHf = jSONObject.optString("sign_notice");
                this.mIM = jSONObject.optInt("is_timeout");
                this.mIN = jSONObject.optString("timeout_notice");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        i iVar = new i();
                        iVar.parserJson(jSONObject2);
                        this.mIO.add(iVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
