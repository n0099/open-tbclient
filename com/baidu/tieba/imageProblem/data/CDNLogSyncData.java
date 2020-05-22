package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private boolean dBA;
    private int dBB;
    private int dBC;
    private int dBD = 25;
    private int dBE = 25;
    private int dBF = 10;
    private int time;

    public int getSuccRank() {
        return this.dBD;
    }

    public void setSuccRank(int i) {
        this.dBD = i;
    }

    public int getErrRank() {
        return this.dBE;
    }

    public void setErrRank(int i) {
        this.dBE = i;
    }

    public int getSlowRank() {
        return this.dBF;
    }

    public void setSlowRank(int i) {
        this.dBF = i;
    }

    public boolean ismSwitch() {
        return this.dBA;
    }

    public void setmSwitch(boolean z) {
        if (this.dBA != z) {
            a kY = s.kY();
            kY.append("act", "fallback");
            kY.append("result", z ? "1" : "0");
            kY.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", kY);
        }
        this.dBA = z;
    }

    public int getSlowNumber() {
        return this.dBB;
    }

    public void setSlowNumber(int i) {
        this.dBB = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.dBC;
    }

    public void setErrNumber(int i) {
        this.dBC = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dBA = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dBA = true;
                } else {
                    this.dBA = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dBC = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dBB = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dBD = optJSONObject3.optInt("succ");
                    this.dBE = optJSONObject3.optInt("err");
                    this.dBF = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dBB <= 0 || this.dBC <= 0) {
                    this.dBA = false;
                }
            } catch (Exception e) {
                this.dBA = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
