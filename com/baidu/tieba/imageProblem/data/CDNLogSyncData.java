package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private boolean UU;
    private int UV;
    private int UW;
    private int UX = 25;
    private int UY = 25;
    private int UZ = 10;
    private int time;

    public int getSuccRank() {
        return this.UX;
    }

    public void setSuccRank(int i) {
        this.UX = i;
    }

    public int getErrRank() {
        return this.UY;
    }

    public void setErrRank(int i) {
        this.UY = i;
    }

    public int getSlowRank() {
        return this.UZ;
    }

    public void setSlowRank(int i) {
        this.UZ = i;
    }

    public boolean ismSwitch() {
        return this.UU;
    }

    public void setmSwitch(boolean z) {
        if (this.UU != z) {
            c fM = u.fM();
            fM.p("act", "fallback");
            fM.p("result", z ? "1" : "0");
            fM.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fM);
        }
        this.UU = z;
    }

    public int getSlowNumber() {
        return this.UV;
    }

    public void setSlowNumber(int i) {
        this.UV = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.UW;
    }

    public void setErrNumber(int i) {
        this.UW = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UU = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UU = true;
                } else {
                    this.UU = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UW = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UV = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UX = optJSONObject3.optInt("succ");
                    this.UY = optJSONObject3.optInt("err");
                    this.UZ = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UV <= 0 || this.UW <= 0) {
                    this.UU = false;
                }
            } catch (Exception e) {
                this.UU = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
