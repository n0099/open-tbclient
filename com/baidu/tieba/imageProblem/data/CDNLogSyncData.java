package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean dXn;
    private int dXo;
    private int dXp;
    private int dXq = 25;
    private int dXr = 25;
    private int dXs = 10;
    private int time;

    public int getSuccRank() {
        return this.dXq;
    }

    public void setSuccRank(int i) {
        this.dXq = i;
    }

    public int getErrRank() {
        return this.dXr;
    }

    public void setErrRank(int i) {
        this.dXr = i;
    }

    public int getSlowRank() {
        return this.dXs;
    }

    public void setSlowRank(int i) {
        this.dXs = i;
    }

    public boolean ismSwitch() {
        return this.dXn;
    }

    public void setmSwitch(boolean z) {
        if (this.dXn != z) {
            a mN = u.mN();
            mN.append("act", "fallback");
            mN.append("result", z ? "1" : "0");
            mN.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mN);
        }
        this.dXn = z;
    }

    public int getSlowNumber() {
        return this.dXo;
    }

    public void setSlowNumber(int i) {
        this.dXo = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.dXp;
    }

    public void setErrNumber(int i) {
        this.dXp = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dXn = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dXn = true;
                } else {
                    this.dXn = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dXp = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dXo = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dXq = optJSONObject3.optInt("succ");
                    this.dXr = optJSONObject3.optInt("err");
                    this.dXs = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dXo <= 0 || this.dXp <= 0) {
                    this.dXn = false;
                }
            } catch (Exception e) {
                this.dXn = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
