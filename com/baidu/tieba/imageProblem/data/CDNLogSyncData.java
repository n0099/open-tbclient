package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CDNLogSyncData {
    private boolean eOe;
    private int eOf;
    private int eOg;
    private int eOh = 25;
    private int eOi = 25;
    private int eOj = 10;
    private int time;

    public int getSuccRank() {
        return this.eOh;
    }

    public void setSuccRank(int i) {
        this.eOh = i;
    }

    public int getErrRank() {
        return this.eOi;
    }

    public void setErrRank(int i) {
        this.eOi = i;
    }

    public int getSlowRank() {
        return this.eOj;
    }

    public void setSlowRank(int i) {
        this.eOj = i;
    }

    public boolean ismSwitch() {
        return this.eOe;
    }

    public void setmSwitch(boolean z) {
        if (this.eOe != z) {
            a pg = u.pg();
            pg.append("act", "fallback");
            pg.append("result", z ? "1" : "0");
            pg.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", pg);
        }
        this.eOe = z;
    }

    public int getSlowNumber() {
        return this.eOf;
    }

    public void setSlowNumber(int i) {
        this.eOf = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.eOg;
    }

    public void setErrNumber(int i) {
        this.eOg = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eOe = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eOe = true;
                } else {
                    this.eOe = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eOg = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eOf = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eOh = optJSONObject3.optInt("succ");
                    this.eOi = optJSONObject3.optInt("err");
                    this.eOj = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eOf <= 0 || this.eOg <= 0) {
                    this.eOe = false;
                }
            } catch (Exception e) {
                this.eOe = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
