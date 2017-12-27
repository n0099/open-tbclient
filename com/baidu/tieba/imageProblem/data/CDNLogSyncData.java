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
    private boolean aKp;
    private int aKq;
    private int aKr;
    private int aKs = 25;
    private int aKt = 25;
    private int aKu = 10;
    private int time;

    public int getSuccRank() {
        return this.aKs;
    }

    public void setSuccRank(int i) {
        this.aKs = i;
    }

    public int getErrRank() {
        return this.aKt;
    }

    public void setErrRank(int i) {
        this.aKt = i;
    }

    public int getSlowRank() {
        return this.aKu;
    }

    public void setSlowRank(int i) {
        this.aKu = i;
    }

    public boolean ismSwitch() {
        return this.aKp;
    }

    public void setmSwitch(boolean z) {
        if (this.aKp != z) {
            a nm = s.nm();
            nm.append("act", "fallback");
            nm.append("result", z ? "1" : "0");
            nm.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nm);
        }
        this.aKp = z;
    }

    public int getSlowNumber() {
        return this.aKq;
    }

    public void setSlowNumber(int i) {
        this.aKq = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aKr;
    }

    public void setErrNumber(int i) {
        this.aKr = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aKp = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aKp = true;
                } else {
                    this.aKp = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aKr = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aKq = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aKs = optJSONObject3.optInt("succ");
                    this.aKt = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aKu = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aKq <= 0 || this.aKr <= 0) {
                    this.aKp = false;
                }
            } catch (Exception e) {
                this.aKp = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
