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
    private boolean aqr;
    private int aqs;
    private int aqt;
    private int aqu = 25;
    private int aqv = 25;
    private int aqw = 10;
    private int time;

    public int getSuccRank() {
        return this.aqu;
    }

    public void setSuccRank(int i) {
        this.aqu = i;
    }

    public int getErrRank() {
        return this.aqv;
    }

    public void setErrRank(int i) {
        this.aqv = i;
    }

    public int getSlowRank() {
        return this.aqw;
    }

    public void setSlowRank(int i) {
        this.aqw = i;
    }

    public boolean ismSwitch() {
        return this.aqr;
    }

    public void setmSwitch(boolean z) {
        if (this.aqr != z) {
            a jB = s.jB();
            jB.append(SocialConstants.PARAM_ACT, "fallback");
            jB.append("result", z ? "1" : "0");
            jB.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
        }
        this.aqr = z;
    }

    public int getSlowNumber() {
        return this.aqs;
    }

    public void setSlowNumber(int i) {
        this.aqs = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aqt;
    }

    public void setErrNumber(int i) {
        this.aqt = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aqr = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aqr = true;
                } else {
                    this.aqr = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aqt = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aqs = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.aqu = optJSONObject3.optInt("succ");
                    this.aqv = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.aqw = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aqs <= 0 || this.aqt <= 0) {
                    this.aqr = false;
                }
            } catch (Exception e) {
                this.aqr = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
