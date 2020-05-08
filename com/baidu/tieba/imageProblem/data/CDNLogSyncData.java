package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private int dnA;
    private int dnB;
    private int dnC = 25;
    private int dnD = 25;
    private int dnE = 10;
    private boolean dnz;
    private int time;

    public int getSuccRank() {
        return this.dnC;
    }

    public void setSuccRank(int i) {
        this.dnC = i;
    }

    public int getErrRank() {
        return this.dnD;
    }

    public void setErrRank(int i) {
        this.dnD = i;
    }

    public int getSlowRank() {
        return this.dnE;
    }

    public void setSlowRank(int i) {
        this.dnE = i;
    }

    public boolean ismSwitch() {
        return this.dnz;
    }

    public void setmSwitch(boolean z) {
        if (this.dnz != z) {
            a kW = s.kW();
            kW.append("act", "fallback");
            kW.append("result", z ? "1" : "0");
            kW.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", kW);
        }
        this.dnz = z;
    }

    public int getSlowNumber() {
        return this.dnA;
    }

    public void setSlowNumber(int i) {
        this.dnA = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.dnB;
    }

    public void setErrNumber(int i) {
        this.dnB = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dnz = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dnz = true;
                } else {
                    this.dnz = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dnB = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dnA = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dnC = optJSONObject3.optInt("succ");
                    this.dnD = optJSONObject3.optInt("err");
                    this.dnE = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dnA <= 0 || this.dnB <= 0) {
                    this.dnz = false;
                }
            } catch (Exception e) {
                this.dnz = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
