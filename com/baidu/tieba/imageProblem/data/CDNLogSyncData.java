package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean bXu;
    private int bXv;
    private int bXw;
    private int bXx = 25;
    private int bXy = 25;
    private int bXz = 10;
    private int time;

    public int getSuccRank() {
        return this.bXx;
    }

    public void setSuccRank(int i) {
        this.bXx = i;
    }

    public int getErrRank() {
        return this.bXy;
    }

    public void setErrRank(int i) {
        this.bXy = i;
    }

    public int getSlowRank() {
        return this.bXz;
    }

    public void setSlowRank(int i) {
        this.bXz = i;
    }

    public boolean ismSwitch() {
        return this.bXu;
    }

    public void setmSwitch(boolean z) {
        if (this.bXu != z) {
            a fU = s.fU();
            fU.append("act", "fallback");
            fU.append("result", z ? "1" : "0");
            fU.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fU);
        }
        this.bXu = z;
    }

    public int getSlowNumber() {
        return this.bXv;
    }

    public void setSlowNumber(int i) {
        this.bXv = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.bXw;
    }

    public void setErrNumber(int i) {
        this.bXw = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bXu = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bXu = true;
                } else {
                    this.bXu = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.bXw = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.bXv = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bXx = optJSONObject3.optInt("succ");
                    this.bXy = optJSONObject3.optInt("err");
                    this.bXz = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bXv <= 0 || this.bXw <= 0) {
                    this.bXu = false;
                }
            } catch (Exception e) {
                this.bXu = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
