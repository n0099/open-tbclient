package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private boolean cOc;
    private int cOd;
    private int cOe;
    private int cOf = 25;
    private int cOg = 25;
    private int cOh = 10;
    private int time;

    public int getSuccRank() {
        return this.cOf;
    }

    public void setSuccRank(int i) {
        this.cOf = i;
    }

    public int getErrRank() {
        return this.cOg;
    }

    public void setErrRank(int i) {
        this.cOg = i;
    }

    public int getSlowRank() {
        return this.cOh;
    }

    public void setSlowRank(int i) {
        this.cOh = i;
    }

    public boolean ismSwitch() {
        return this.cOc;
    }

    public void setmSwitch(boolean z) {
        if (this.cOc != z) {
            a gs = s.gs();
            gs.append("act", "fallback");
            gs.append("result", z ? "1" : "0");
            gs.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gs);
        }
        this.cOc = z;
    }

    public int getSlowNumber() {
        return this.cOd;
    }

    public void setSlowNumber(int i) {
        this.cOd = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.cOe;
    }

    public void setErrNumber(int i) {
        this.cOe = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cOc = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cOc = true;
                } else {
                    this.cOc = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cOe = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cOd = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cOf = optJSONObject3.optInt("succ");
                    this.cOg = optJSONObject3.optInt("err");
                    this.cOh = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cOd <= 0 || this.cOe <= 0) {
                    this.cOc = false;
                }
            } catch (Exception e) {
                this.cOc = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
