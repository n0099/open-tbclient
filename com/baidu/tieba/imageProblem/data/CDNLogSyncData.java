package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean elD;
    private int elE;
    private int elF;
    private int elG = 25;
    private int elH = 25;
    private int elI = 10;
    private int time;

    public int getSuccRank() {
        return this.elG;
    }

    public void setSuccRank(int i) {
        this.elG = i;
    }

    public int getErrRank() {
        return this.elH;
    }

    public void setErrRank(int i) {
        this.elH = i;
    }

    public int getSlowRank() {
        return this.elI;
    }

    public void setSlowRank(int i) {
        this.elI = i;
    }

    public boolean ismSwitch() {
        return this.elD;
    }

    public void setmSwitch(boolean z) {
        if (this.elD != z) {
            a mT = u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.elD = z;
    }

    public int getSlowNumber() {
        return this.elE;
    }

    public void setSlowNumber(int i) {
        this.elE = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.elF;
    }

    public void setErrNumber(int i) {
        this.elF = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.elD = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.elD = true;
                } else {
                    this.elD = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.elF = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.elE = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.elG = optJSONObject3.optInt("succ");
                    this.elH = optJSONObject3.optInt("err");
                    this.elI = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.elE <= 0 || this.elF <= 0) {
                    this.elD = false;
                }
            } catch (Exception e) {
                this.elD = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
