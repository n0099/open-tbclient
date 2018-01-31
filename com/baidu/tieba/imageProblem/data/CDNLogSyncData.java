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
    private boolean aKq;
    private int aKr;
    private int aKs;
    private int aKt = 25;
    private int aKu = 25;
    private int aKv = 10;
    private int time;

    public int getSuccRank() {
        return this.aKt;
    }

    public void setSuccRank(int i) {
        this.aKt = i;
    }

    public int getErrRank() {
        return this.aKu;
    }

    public void setErrRank(int i) {
        this.aKu = i;
    }

    public int getSlowRank() {
        return this.aKv;
    }

    public void setSlowRank(int i) {
        this.aKv = i;
    }

    public boolean ismSwitch() {
        return this.aKq;
    }

    public void setmSwitch(boolean z) {
        if (this.aKq != z) {
            a nn = s.nn();
            nn.append("act", "fallback");
            nn.append("result", z ? "1" : "0");
            nn.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", nn);
        }
        this.aKq = z;
    }

    public int getSlowNumber() {
        return this.aKr;
    }

    public void setSlowNumber(int i) {
        this.aKr = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aKs;
    }

    public void setErrNumber(int i) {
        this.aKs = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aKq = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aKq = true;
                } else {
                    this.aKq = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aKs = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.aKr = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aKt = optJSONObject3.optInt("succ");
                    this.aKu = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aKv = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aKr <= 0 || this.aKs <= 0) {
                    this.aKq = false;
                }
            } catch (Exception e) {
                this.aKq = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
