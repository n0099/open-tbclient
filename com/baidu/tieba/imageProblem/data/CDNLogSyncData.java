package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CDNLogSyncData {
    private boolean cOq;
    private int cOr;
    private int cOs;
    private int cOt = 25;
    private int cOu = 25;
    private int cOv = 10;
    private int time;

    public int getSuccRank() {
        return this.cOt;
    }

    public void setSuccRank(int i) {
        this.cOt = i;
    }

    public int getErrRank() {
        return this.cOu;
    }

    public void setErrRank(int i) {
        this.cOu = i;
    }

    public int getSlowRank() {
        return this.cOv;
    }

    public void setSlowRank(int i) {
        this.cOv = i;
    }

    public boolean ismSwitch() {
        return this.cOq;
    }

    public void setmSwitch(boolean z) {
        if (this.cOq != z) {
            a gs = s.gs();
            gs.append("act", "fallback");
            gs.append("result", z ? "1" : "0");
            gs.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", gs);
        }
        this.cOq = z;
    }

    public int getSlowNumber() {
        return this.cOr;
    }

    public void setSlowNumber(int i) {
        this.cOr = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.cOs;
    }

    public void setErrNumber(int i) {
        this.cOs = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.cOq = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.cOq = true;
                } else {
                    this.cOq = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.cOs = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.cOr = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.cOt = optJSONObject3.optInt("succ");
                    this.cOu = optJSONObject3.optInt("err");
                    this.cOv = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.cOr <= 0 || this.cOs <= 0) {
                    this.cOq = false;
                }
            } catch (Exception e) {
                this.cOq = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
