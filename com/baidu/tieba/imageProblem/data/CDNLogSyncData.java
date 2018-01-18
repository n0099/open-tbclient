package com.baidu.tieba.imageProblem.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean aKn;
    private int aKo;
    private int aKp;
    private int aKq = 25;
    private int aKr = 25;
    private int aKs = 10;
    private int time;

    public int getSuccRank() {
        return this.aKq;
    }

    public void setSuccRank(int i) {
        this.aKq = i;
    }

    public int getErrRank() {
        return this.aKr;
    }

    public void setErrRank(int i) {
        this.aKr = i;
    }

    public int getSlowRank() {
        return this.aKs;
    }

    public void setSlowRank(int i) {
        this.aKs = i;
    }

    public boolean ismSwitch() {
        return this.aKn;
    }

    public void setmSwitch(boolean z) {
        if (this.aKn != z) {
            a nm = s.nm();
            nm.append("act", "fallback");
            nm.append("result", z ? "1" : "0");
            nm.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nm);
        }
        this.aKn = z;
    }

    public int getSlowNumber() {
        return this.aKo;
    }

    public void setSlowNumber(int i) {
        this.aKo = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aKp;
    }

    public void setErrNumber(int i) {
        this.aKp = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aKn = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aKn = true;
                } else {
                    this.aKn = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aKp = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aKo = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aKq = optJSONObject3.optInt("succ");
                    this.aKr = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aKs = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aKo <= 0 || this.aKp <= 0) {
                    this.aKn = false;
                }
            } catch (Exception e) {
                this.aKn = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
