package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.t;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CDNLogSyncData {
    private boolean ePc;
    private int ePd;
    private int ePe;
    private int ePf = 25;
    private int ePg = 25;
    private int ePh = 10;
    private int time;

    public int getSuccRank() {
        return this.ePf;
    }

    public void setSuccRank(int i) {
        this.ePf = i;
    }

    public int getErrRank() {
        return this.ePg;
    }

    public void setErrRank(int i) {
        this.ePg = i;
    }

    public int getSlowRank() {
        return this.ePh;
    }

    public void setSlowRank(int i) {
        this.ePh = i;
    }

    public boolean ismSwitch() {
        return this.ePc;
    }

    public void setmSwitch(boolean z) {
        if (this.ePc != z) {
            a pi = t.pi();
            pi.append("act", "fallback");
            pi.append("result", z ? "1" : "0");
            pi.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", pi);
        }
        this.ePc = z;
    }

    public int getSlowNumber() {
        return this.ePd;
    }

    public void setSlowNumber(int i) {
        this.ePd = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.ePe;
    }

    public void setErrNumber(int i) {
        this.ePe = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.ePc = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.ePc = true;
                } else {
                    this.ePc = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.ePe = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.ePd = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.ePf = optJSONObject3.optInt("succ");
                    this.ePg = optJSONObject3.optInt("err");
                    this.ePh = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.ePd <= 0 || this.ePe <= 0) {
                    this.ePc = false;
                }
            } catch (Exception e) {
                this.ePc = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
