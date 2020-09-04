package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean dXr;
    private int dXs;
    private int dXt;
    private int dXu = 25;
    private int dXv = 25;
    private int dXw = 10;
    private int time;

    public int getSuccRank() {
        return this.dXu;
    }

    public void setSuccRank(int i) {
        this.dXu = i;
    }

    public int getErrRank() {
        return this.dXv;
    }

    public void setErrRank(int i) {
        this.dXv = i;
    }

    public int getSlowRank() {
        return this.dXw;
    }

    public void setSlowRank(int i) {
        this.dXw = i;
    }

    public boolean ismSwitch() {
        return this.dXr;
    }

    public void setmSwitch(boolean z) {
        if (this.dXr != z) {
            a mN = u.mN();
            mN.append("act", "fallback");
            mN.append("result", z ? "1" : "0");
            mN.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mN);
        }
        this.dXr = z;
    }

    public int getSlowNumber() {
        return this.dXs;
    }

    public void setSlowNumber(int i) {
        this.dXs = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.dXt;
    }

    public void setErrNumber(int i) {
        this.dXt = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.dXr = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.dXr = true;
                } else {
                    this.dXr = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.dXt = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.dXs = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.dXu = optJSONObject3.optInt("succ");
                    this.dXv = optJSONObject3.optInt("err");
                    this.dXw = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.dXs <= 0 || this.dXt <= 0) {
                    this.dXr = false;
                }
            } catch (Exception e) {
                this.dXr = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
