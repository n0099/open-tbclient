package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.r;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean VR;
    private int VS;
    private int VT;
    private int VU = 25;
    private int VV = 25;
    private int VW = 10;
    private int time;

    public int getSuccRank() {
        return this.VU;
    }

    public void setSuccRank(int i) {
        this.VU = i;
    }

    public int getErrRank() {
        return this.VV;
    }

    public void setErrRank(int i) {
        this.VV = i;
    }

    public int getSlowRank() {
        return this.VW;
    }

    public void setSlowRank(int i) {
        this.VW = i;
    }

    public boolean ismSwitch() {
        return this.VR;
    }

    public void setmSwitch(boolean z) {
        if (this.VR != z) {
            a fV = r.fV();
            fV.p("act", "fallback");
            fV.p("result", z ? "1" : "0");
            fV.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fV);
        }
        this.VR = z;
    }

    public int getSlowNumber() {
        return this.VS;
    }

    public void setSlowNumber(int i) {
        this.VS = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.VT;
    }

    public void setErrNumber(int i) {
        this.VT = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VR = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VR = true;
                } else {
                    this.VR = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VT = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VS = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VU = optJSONObject3.optInt("succ");
                    this.VV = optJSONObject3.optInt("err");
                    this.VW = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VS <= 0 || this.VT <= 0) {
                    this.VR = false;
                }
            } catch (Exception e) {
                this.VR = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
