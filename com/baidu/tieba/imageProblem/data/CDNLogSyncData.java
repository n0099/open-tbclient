package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean ezW;
    private int ezX;
    private int ezY;
    private int time;
    private int ezZ = 25;
    private int eAa = 25;
    private int eAb = 10;

    public int getSuccRank() {
        return this.ezZ;
    }

    public void setSuccRank(int i) {
        this.ezZ = i;
    }

    public int getErrRank() {
        return this.eAa;
    }

    public void setErrRank(int i) {
        this.eAa = i;
    }

    public int getSlowRank() {
        return this.eAb;
    }

    public void setSlowRank(int i) {
        this.eAb = i;
    }

    public boolean ismSwitch() {
        return this.ezW;
    }

    public void setmSwitch(boolean z) {
        if (this.ezW != z) {
            a mT = u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.ezW = z;
    }

    public int getSlowNumber() {
        return this.ezX;
    }

    public void setSlowNumber(int i) {
        this.ezX = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.ezY;
    }

    public void setErrNumber(int i) {
        this.ezY = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.ezW = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.ezW = true;
                } else {
                    this.ezW = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.ezY = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.ezX = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.ezZ = optJSONObject3.optInt("succ");
                    this.eAa = optJSONObject3.optInt("err");
                    this.eAb = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.ezX <= 0 || this.ezY <= 0) {
                    this.ezW = false;
                }
            } catch (Exception e) {
                this.ezW = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
