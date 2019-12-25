package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNLogSyncData {
    private boolean cJN;
    private int cJO;
    private int cJP;
    private int cJQ = 25;
    private int cJR = 25;
    private int cJS = 10;
    private int time;

    public int getSuccRank() {
        return this.cJQ;
    }

    public void setSuccRank(int i) {
        this.cJQ = i;
    }

    public int getErrRank() {
        return this.cJR;
    }

    public void setErrRank(int i) {
        this.cJR = i;
    }

    public int getSlowRank() {
        return this.cJS;
    }

    public void setSlowRank(int i) {
        this.cJS = i;
    }

    public boolean ismSwitch() {
        return this.cJN;
    }

    public void setmSwitch(boolean z) {
        if (this.cJN != z) {
            a gt = s.gt();
            gt.append("act", "fallback");
            gt.append("result", z ? "1" : "0");
            gt.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gt);
        }
        this.cJN = z;
    }

    public int getSlowNumber() {
        return this.cJO;
    }

    public void setSlowNumber(int i) {
        this.cJO = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.cJP;
    }

    public void setErrNumber(int i) {
        this.cJP = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cJN = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cJN = true;
                } else {
                    this.cJN = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cJP = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cJO = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cJQ = optJSONObject3.optInt("succ");
                    this.cJR = optJSONObject3.optInt("err");
                    this.cJS = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cJO <= 0 || this.cJP <= 0) {
                    this.cJN = false;
                }
            } catch (Exception e) {
                this.cJN = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
