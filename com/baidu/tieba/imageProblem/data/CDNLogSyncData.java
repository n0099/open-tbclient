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
    private boolean bxN;
    private int bxO;
    private int bxP;
    private int bxQ = 25;
    private int bxR = 25;
    private int bxS = 10;
    private int time;

    public int getSuccRank() {
        return this.bxQ;
    }

    public void setSuccRank(int i) {
        this.bxQ = i;
    }

    public int getErrRank() {
        return this.bxR;
    }

    public void setErrRank(int i) {
        this.bxR = i;
    }

    public int getSlowRank() {
        return this.bxS;
    }

    public void setSlowRank(int i) {
        this.bxS = i;
    }

    public boolean ismSwitch() {
        return this.bxN;
    }

    public void setmSwitch(boolean z) {
        if (this.bxN != z) {
            a jC = s.jC();
            jC.append(SocialConstants.PARAM_ACT, "fallback");
            jC.append("result", z ? "1" : "0");
            jC.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
        }
        this.bxN = z;
    }

    public int getSlowNumber() {
        return this.bxO;
    }

    public void setSlowNumber(int i) {
        this.bxO = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.bxP;
    }

    public void setErrNumber(int i) {
        this.bxP = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bxN = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bxN = true;
                } else {
                    this.bxN = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bxP = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bxO = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bxQ = optJSONObject3.optInt("succ");
                    this.bxR = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bxS = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bxO <= 0 || this.bxP <= 0) {
                    this.bxN = false;
                }
            } catch (Exception e) {
                this.bxN = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
