package com.baidu.tieba.imageProblem.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.s;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private int aLA;
    private int aLB;
    private int aLC = 25;
    private int aLD = 25;
    private int aLE = 10;
    private boolean aLz;
    private int time;

    public int getSuccRank() {
        return this.aLC;
    }

    public void setSuccRank(int i) {
        this.aLC = i;
    }

    public int getErrRank() {
        return this.aLD;
    }

    public void setErrRank(int i) {
        this.aLD = i;
    }

    public int getSlowRank() {
        return this.aLE;
    }

    public void setSlowRank(int i) {
        this.aLE = i;
    }

    public boolean ismSwitch() {
        return this.aLz;
    }

    public void setmSwitch(boolean z) {
        if (this.aLz != z) {
            a nn = s.nn();
            nn.append(SocialConstants.PARAM_ACT, "fallback");
            nn.append("result", z ? "1" : "0");
            nn.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nn);
        }
        this.aLz = z;
    }

    public int getSlowNumber() {
        return this.aLA;
    }

    public void setSlowNumber(int i) {
        this.aLA = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aLB;
    }

    public void setErrNumber(int i) {
        this.aLB = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aLz = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aLz = true;
                } else {
                    this.aLz = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aLB = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aLA = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aLC = optJSONObject3.optInt("succ");
                    this.aLD = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aLE = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aLA <= 0 || this.aLB <= 0) {
                    this.aLz = false;
                }
            } catch (Exception e) {
                this.aLz = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
