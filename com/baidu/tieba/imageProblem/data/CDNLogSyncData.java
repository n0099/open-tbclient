package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean eyn;
    private int eyo;
    private int eyp;
    private int eyq = 25;
    private int eyr = 25;
    private int eys = 10;
    private int time;

    public int getSuccRank() {
        return this.eyq;
    }

    public void setSuccRank(int i) {
        this.eyq = i;
    }

    public int getErrRank() {
        return this.eyr;
    }

    public void setErrRank(int i) {
        this.eyr = i;
    }

    public int getSlowRank() {
        return this.eys;
    }

    public void setSlowRank(int i) {
        this.eys = i;
    }

    public boolean ismSwitch() {
        return this.eyn;
    }

    public void setmSwitch(boolean z) {
        if (this.eyn != z) {
            a mT = u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.eyn = z;
    }

    public int getSlowNumber() {
        return this.eyo;
    }

    public void setSlowNumber(int i) {
        this.eyo = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.eyp;
    }

    public void setErrNumber(int i) {
        this.eyp = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eyn = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eyn = true;
                } else {
                    this.eyn = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eyp = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eyo = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eyq = optJSONObject3.optInt("succ");
                    this.eyr = optJSONObject3.optInt("err");
                    this.eys = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eyo <= 0 || this.eyp <= 0) {
                    this.eyn = false;
                }
            } catch (Exception e) {
                this.eyn = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
