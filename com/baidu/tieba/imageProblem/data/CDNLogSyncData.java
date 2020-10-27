package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class CDNLogSyncData {
    private boolean eud;
    private int eue;
    private int euf;
    private int eug = 25;
    private int euh = 25;
    private int eui = 10;
    private int time;

    public int getSuccRank() {
        return this.eug;
    }

    public void setSuccRank(int i) {
        this.eug = i;
    }

    public int getErrRank() {
        return this.euh;
    }

    public void setErrRank(int i) {
        this.euh = i;
    }

    public int getSlowRank() {
        return this.eui;
    }

    public void setSlowRank(int i) {
        this.eui = i;
    }

    public boolean ismSwitch() {
        return this.eud;
    }

    public void setmSwitch(boolean z) {
        if (this.eud != z) {
            a mT = u.mT();
            mT.append("act", "fallback");
            mT.append("result", z ? "1" : "0");
            mT.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", mT);
        }
        this.eud = z;
    }

    public int getSlowNumber() {
        return this.eue;
    }

    public void setSlowNumber(int i) {
        this.eue = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.euf;
    }

    public void setErrNumber(int i) {
        this.euf = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.eud = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.eud = true;
                } else {
                    this.eud = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.euf = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.eue = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.eug = optJSONObject3.optInt("succ");
                    this.euh = optJSONObject3.optInt("err");
                    this.eui = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.eue <= 0 || this.euf <= 0) {
                    this.eud = false;
                }
            } catch (Exception e) {
                this.eud = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
