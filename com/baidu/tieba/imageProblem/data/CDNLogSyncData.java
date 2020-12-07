package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean eFm;
    private int eFn;
    private int eFo;
    private int eFp = 25;
    private int eFq = 25;
    private int eFr = 10;
    private int time;

    public int getSuccRank() {
        return this.eFp;
    }

    public void setSuccRank(int i) {
        this.eFp = i;
    }

    public int getErrRank() {
        return this.eFq;
    }

    public void setErrRank(int i) {
        this.eFq = i;
    }

    public int getSlowRank() {
        return this.eFr;
    }

    public void setSlowRank(int i) {
        this.eFr = i;
    }

    public boolean ismSwitch() {
        return this.eFm;
    }

    public void setmSwitch(boolean z) {
        if (this.eFm != z) {
            a mT = u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.eFm = z;
    }

    public int getSlowNumber() {
        return this.eFn;
    }

    public void setSlowNumber(int i) {
        this.eFn = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.eFo;
    }

    public void setErrNumber(int i) {
        this.eFo = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eFm = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eFm = true;
                } else {
                    this.eFm = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eFo = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eFn = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eFp = optJSONObject3.optInt("succ");
                    this.eFq = optJSONObject3.optInt("err");
                    this.eFr = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eFn <= 0 || this.eFo <= 0) {
                    this.eFm = false;
                }
            } catch (Exception e) {
                this.eFm = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
