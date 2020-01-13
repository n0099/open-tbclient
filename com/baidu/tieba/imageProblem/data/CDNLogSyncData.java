package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CDNLogSyncData {
    private boolean cJY;
    private int cJZ;
    private int cKa;
    private int cKb = 25;
    private int cKc = 25;
    private int cKd = 10;
    private int time;

    public int getSuccRank() {
        return this.cKb;
    }

    public void setSuccRank(int i) {
        this.cKb = i;
    }

    public int getErrRank() {
        return this.cKc;
    }

    public void setErrRank(int i) {
        this.cKc = i;
    }

    public int getSlowRank() {
        return this.cKd;
    }

    public void setSlowRank(int i) {
        this.cKd = i;
    }

    public boolean ismSwitch() {
        return this.cJY;
    }

    public void setmSwitch(boolean z) {
        if (this.cJY != z) {
            a gs = s.gs();
            gs.append("act", "fallback");
            gs.append("result", z ? "1" : "0");
            gs.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gs);
        }
        this.cJY = z;
    }

    public int getSlowNumber() {
        return this.cJZ;
    }

    public void setSlowNumber(int i) {
        this.cJZ = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.cKa;
    }

    public void setErrNumber(int i) {
        this.cKa = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cJY = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cJY = true;
                } else {
                    this.cJY = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cKa = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cJZ = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cKb = optJSONObject3.optInt("succ");
                    this.cKc = optJSONObject3.optInt("err");
                    this.cKd = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cJZ <= 0 || this.cKa <= 0) {
                    this.cJY = false;
                }
            } catch (Exception e) {
                this.cJY = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
