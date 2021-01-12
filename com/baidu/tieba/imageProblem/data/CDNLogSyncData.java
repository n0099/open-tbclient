package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.t;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CDNLogSyncData {
    private boolean eKr;
    private int eKs;
    private int eKt;
    private int eKu = 25;
    private int eKv = 25;
    private int eKw = 10;
    private int time;

    public int getSuccRank() {
        return this.eKu;
    }

    public void setSuccRank(int i) {
        this.eKu = i;
    }

    public int getErrRank() {
        return this.eKv;
    }

    public void setErrRank(int i) {
        this.eKv = i;
    }

    public int getSlowRank() {
        return this.eKw;
    }

    public void setSlowRank(int i) {
        this.eKw = i;
    }

    public boolean ismSwitch() {
        return this.eKr;
    }

    public void setmSwitch(boolean z) {
        if (this.eKr != z) {
            a pi = t.pi();
            pi.append("act", "fallback");
            pi.append("result", z ? "1" : "0");
            pi.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", pi);
        }
        this.eKr = z;
    }

    public int getSlowNumber() {
        return this.eKs;
    }

    public void setSlowNumber(int i) {
        this.eKs = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.eKt;
    }

    public void setErrNumber(int i) {
        this.eKt = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eKr = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eKr = true;
                } else {
                    this.eKr = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.eKt = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eKs = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eKu = optJSONObject3.optInt("succ");
                    this.eKv = optJSONObject3.optInt("err");
                    this.eKw = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eKs <= 0 || this.eKt <= 0) {
                    this.eKr = false;
                }
            } catch (Exception e) {
                this.eKr = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
