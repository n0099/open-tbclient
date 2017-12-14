package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean VP;
    private int VQ;
    private int VR;
    private int VS = 25;
    private int VT = 25;
    private int VU = 10;
    private int time;

    public int getSuccRank() {
        return this.VS;
    }

    public void setSuccRank(int i) {
        this.VS = i;
    }

    public int getErrRank() {
        return this.VT;
    }

    public void setErrRank(int i) {
        this.VT = i;
    }

    public int getSlowRank() {
        return this.VU;
    }

    public void setSlowRank(int i) {
        this.VU = i;
    }

    public boolean ismSwitch() {
        return this.VP;
    }

    public void setmSwitch(boolean z) {
        if (this.VP != z) {
            a fK = s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.VP = z;
    }

    public int getSlowNumber() {
        return this.VQ;
    }

    public void setSlowNumber(int i) {
        this.VQ = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.VR;
    }

    public void setErrNumber(int i) {
        this.VR = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.VP = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.VP = true;
                } else {
                    this.VP = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.VR = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.VQ = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.VS = optJSONObject3.optInt("succ");
                    this.VT = optJSONObject3.optInt("err");
                    this.VU = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.VQ <= 0 || this.VR <= 0) {
                    this.VP = false;
                }
            } catch (Exception e) {
                this.VP = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
