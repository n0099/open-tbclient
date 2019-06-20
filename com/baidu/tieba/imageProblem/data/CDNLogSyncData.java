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
    private boolean bFa;
    private int bFb;
    private int bFc;
    private int bFd = 25;
    private int bFe = 25;
    private int bFf = 10;
    private int time;

    public int getSuccRank() {
        return this.bFd;
    }

    public void setSuccRank(int i) {
        this.bFd = i;
    }

    public int getErrRank() {
        return this.bFe;
    }

    public void setErrRank(int i) {
        this.bFe = i;
    }

    public int getSlowRank() {
        return this.bFf;
    }

    public void setSlowRank(int i) {
        this.bFf = i;
    }

    public boolean ismSwitch() {
        return this.bFa;
    }

    public void setmSwitch(boolean z) {
        if (this.bFa != z) {
            a iw = s.iw();
            iw.append(SocialConstants.PARAM_ACT, "fallback");
            iw.append("result", z ? "1" : "0");
            iw.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
        }
        this.bFa = z;
    }

    public int getSlowNumber() {
        return this.bFb;
    }

    public void setSlowNumber(int i) {
        this.bFb = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.bFc;
    }

    public void setErrNumber(int i) {
        this.bFc = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.bFa = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.bFa = true;
                } else {
                    this.bFa = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.bFc = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.bFb = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.bFd = optJSONObject3.optInt("succ");
                    this.bFe = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.bFf = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.bFb <= 0 || this.bFc <= 0) {
                    this.bFa = false;
                }
            } catch (Exception e) {
                this.bFa = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
