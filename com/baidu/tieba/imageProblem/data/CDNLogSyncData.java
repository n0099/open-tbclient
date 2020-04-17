package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private boolean dnv;
    private int dnw;
    private int dnx;
    private int time;
    private int dny = 25;
    private int dnz = 25;
    private int dnA = 10;

    public int getSuccRank() {
        return this.dny;
    }

    public void setSuccRank(int i) {
        this.dny = i;
    }

    public int getErrRank() {
        return this.dnz;
    }

    public void setErrRank(int i) {
        this.dnz = i;
    }

    public int getSlowRank() {
        return this.dnA;
    }

    public void setSlowRank(int i) {
        this.dnA = i;
    }

    public boolean ismSwitch() {
        return this.dnv;
    }

    public void setmSwitch(boolean z) {
        if (this.dnv != z) {
            a kW = s.kW();
            kW.append("act", "fallback");
            kW.append("result", z ? "1" : "0");
            kW.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", kW);
        }
        this.dnv = z;
    }

    public int getSlowNumber() {
        return this.dnw;
    }

    public void setSlowNumber(int i) {
        this.dnw = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.dnx;
    }

    public void setErrNumber(int i) {
        this.dnx = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dnv = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dnv = true;
                } else {
                    this.dnv = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dnx = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dnw = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dny = optJSONObject3.optInt("succ");
                    this.dnz = optJSONObject3.optInt("err");
                    this.dnA = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dnw <= 0 || this.dnx <= 0) {
                    this.dnv = false;
                }
            } catch (Exception e) {
                this.dnv = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
