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
    private boolean bGb;
    private int bGc;
    private int bGd;
    private int bGe = 25;
    private int bGf = 25;
    private int bGg = 10;
    private int time;

    public int getSuccRank() {
        return this.bGe;
    }

    public void setSuccRank(int i) {
        this.bGe = i;
    }

    public int getErrRank() {
        return this.bGf;
    }

    public void setErrRank(int i) {
        this.bGf = i;
    }

    public int getSlowRank() {
        return this.bGg;
    }

    public void setSlowRank(int i) {
        this.bGg = i;
    }

    public boolean ismSwitch() {
        return this.bGb;
    }

    public void setmSwitch(boolean z) {
        if (this.bGb != z) {
            a iF = s.iF();
            iF.append(SocialConstants.PARAM_ACT, "fallback");
            iF.append("result", z ? "1" : "0");
            iF.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
        }
        this.bGb = z;
    }

    public int getSlowNumber() {
        return this.bGc;
    }

    public void setSlowNumber(int i) {
        this.bGc = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.bGd;
    }

    public void setErrNumber(int i) {
        this.bGd = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bGb = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bGb = true;
                } else {
                    this.bGb = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bGd = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bGc = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bGe = optJSONObject3.optInt("succ");
                    this.bGf = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bGg = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bGc <= 0 || this.bGd <= 0) {
                    this.bGb = false;
                }
            } catch (Exception e) {
                this.bGb = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
