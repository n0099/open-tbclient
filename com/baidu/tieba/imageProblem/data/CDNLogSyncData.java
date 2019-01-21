package com.baidu.tieba.imageProblem.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNLogSyncData {
    private boolean aqU;
    private int aqV;
    private int aqW;
    private int aqX = 25;
    private int aqY = 25;
    private int aqZ = 10;
    private int time;

    public int getSuccRank() {
        return this.aqX;
    }

    public void setSuccRank(int i) {
        this.aqX = i;
    }

    public int getErrRank() {
        return this.aqY;
    }

    public void setErrRank(int i) {
        this.aqY = i;
    }

    public int getSlowRank() {
        return this.aqZ;
    }

    public void setSlowRank(int i) {
        this.aqZ = i;
    }

    public boolean ismSwitch() {
        return this.aqU;
    }

    public void setmSwitch(boolean z) {
        if (this.aqU != z) {
            a jB = s.jB();
            jB.append(SocialConstants.PARAM_ACT, "fallback");
            jB.append("result", z ? "1" : "0");
            jB.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
        }
        this.aqU = z;
    }

    public int getSlowNumber() {
        return this.aqV;
    }

    public void setSlowNumber(int i) {
        this.aqV = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aqW;
    }

    public void setErrNumber(int i) {
        this.aqW = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aqU = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aqU = true;
                } else {
                    this.aqU = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aqW = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aqV = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aqX = optJSONObject3.optInt("succ");
                    this.aqY = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aqZ = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aqV <= 0 || this.aqW <= 0) {
                    this.aqU = false;
                }
            } catch (Exception e) {
                this.aqU = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
