package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.v;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private boolean PZ;
    private int Qa;
    private int Qb;
    private int Qc = 25;
    private int Qd = 25;
    private int Qe = 10;
    private int time;

    public int getSuccRank() {
        return this.Qc;
    }

    public void setSuccRank(int i) {
        this.Qc = i;
    }

    public int getErrRank() {
        return this.Qd;
    }

    public void setErrRank(int i) {
        this.Qd = i;
    }

    public int getSlowRank() {
        return this.Qe;
    }

    public void setSlowRank(int i) {
        this.Qe = i;
    }

    public boolean ismSwitch() {
        return this.PZ;
    }

    public void setmSwitch(boolean z) {
        if (this.PZ != z) {
            d eB = v.eB();
            eB.q("act", "fallback");
            eB.q("result", z ? "1" : "0");
            eB.q("type", "switch");
            a.eI().b("img", eB);
        }
        this.PZ = z;
    }

    public int getSlowNumber() {
        return this.Qa;
    }

    public void setSlowNumber(int i) {
        this.Qa = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Qb;
    }

    public void setErrNumber(int i) {
        this.Qb = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.PZ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.PZ = true;
                } else {
                    this.PZ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Qb = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Qa = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Qc = optJSONObject3.optInt("succ");
                    this.Qd = optJSONObject3.optInt("err");
                    this.Qe = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Qa <= 0 || this.Qb <= 0) {
                    this.PZ = false;
                }
            } catch (Exception e) {
                this.PZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
