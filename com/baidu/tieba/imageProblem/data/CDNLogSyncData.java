package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private boolean cOb;
    private int cOc;
    private int cOd;
    private int cOe = 25;
    private int cOf = 25;
    private int cOg = 10;
    private int time;

    public int getSuccRank() {
        return this.cOe;
    }

    public void setSuccRank(int i) {
        this.cOe = i;
    }

    public int getErrRank() {
        return this.cOf;
    }

    public void setErrRank(int i) {
        this.cOf = i;
    }

    public int getSlowRank() {
        return this.cOg;
    }

    public void setSlowRank(int i) {
        this.cOg = i;
    }

    public boolean ismSwitch() {
        return this.cOb;
    }

    public void setmSwitch(boolean z) {
        if (this.cOb != z) {
            a gs = s.gs();
            gs.append("act", "fallback");
            gs.append("result", z ? "1" : "0");
            gs.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gs);
        }
        this.cOb = z;
    }

    public int getSlowNumber() {
        return this.cOc;
    }

    public void setSlowNumber(int i) {
        this.cOc = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.cOd;
    }

    public void setErrNumber(int i) {
        this.cOd = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cOb = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cOb = true;
                } else {
                    this.cOb = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cOd = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cOc = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cOe = optJSONObject3.optInt("succ");
                    this.cOf = optJSONObject3.optInt("err");
                    this.cOg = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cOc <= 0 || this.cOd <= 0) {
                    this.cOb = false;
                }
            } catch (Exception e) {
                this.cOb = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
