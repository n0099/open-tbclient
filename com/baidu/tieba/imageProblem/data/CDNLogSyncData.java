package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean bYl;
    private int bYm;
    private int bYn;
    private int bYo = 25;
    private int bYp = 25;
    private int bYq = 10;
    private int time;

    public int getSuccRank() {
        return this.bYo;
    }

    public void setSuccRank(int i) {
        this.bYo = i;
    }

    public int getErrRank() {
        return this.bYp;
    }

    public void setErrRank(int i) {
        this.bYp = i;
    }

    public int getSlowRank() {
        return this.bYq;
    }

    public void setSlowRank(int i) {
        this.bYq = i;
    }

    public boolean ismSwitch() {
        return this.bYl;
    }

    public void setmSwitch(boolean z) {
        if (this.bYl != z) {
            a fU = s.fU();
            fU.append("act", "fallback");
            fU.append("result", z ? "1" : "0");
            fU.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fU);
        }
        this.bYl = z;
    }

    public int getSlowNumber() {
        return this.bYm;
    }

    public void setSlowNumber(int i) {
        this.bYm = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.bYn;
    }

    public void setErrNumber(int i) {
        this.bYn = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bYl = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bYl = true;
                } else {
                    this.bYl = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.bYn = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.bYm = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bYo = optJSONObject3.optInt("succ");
                    this.bYp = optJSONObject3.optInt("err");
                    this.bYq = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bYm <= 0 || this.bYn <= 0) {
                    this.bYl = false;
                }
            } catch (Exception e) {
                this.bYl = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
