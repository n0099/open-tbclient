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
    private boolean UW;
    private int UX;
    private int UY;
    private int UZ = 25;
    private int Va = 25;
    private int Vb = 10;
    private int time;

    public int getSuccRank() {
        return this.UZ;
    }

    public void setSuccRank(int i) {
        this.UZ = i;
    }

    public int getErrRank() {
        return this.Va;
    }

    public void setErrRank(int i) {
        this.Va = i;
    }

    public int getSlowRank() {
        return this.Vb;
    }

    public void setSlowRank(int i) {
        this.Vb = i;
    }

    public boolean ismSwitch() {
        return this.UW;
    }

    public void setmSwitch(boolean z) {
        if (this.UW != z) {
            a fK = s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.UW = z;
    }

    public int getSlowNumber() {
        return this.UX;
    }

    public void setSlowNumber(int i) {
        this.UX = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.UY;
    }

    public void setErrNumber(int i) {
        this.UY = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UW = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UW = true;
                } else {
                    this.UW = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UY = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UX = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UZ = optJSONObject3.optInt("succ");
                    this.Va = optJSONObject3.optInt("err");
                    this.Vb = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UX <= 0 || this.UY <= 0) {
                    this.UW = false;
                }
            } catch (Exception e) {
                this.UW = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
