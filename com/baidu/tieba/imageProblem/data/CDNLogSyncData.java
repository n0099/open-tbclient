package com.baidu.tieba.imageProblem.data;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.t;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean afm;
    private int afn;
    private int afo;
    private int afp = 25;
    private int afq = 25;
    private int afr = 10;
    private int time;

    public int getSuccRank() {
        return this.afp;
    }

    public void setSuccRank(int i) {
        this.afp = i;
    }

    public int getErrRank() {
        return this.afq;
    }

    public void setErrRank(int i) {
        this.afq = i;
    }

    public int getSlowRank() {
        return this.afr;
    }

    public void setSlowRank(int i) {
        this.afr = i;
    }

    public boolean ismSwitch() {
        return this.afm;
    }

    public void setmSwitch(boolean z) {
        if (this.afm != z) {
            a ih = t.ih();
            ih.append(SocialConstants.PARAM_ACT, "fallback");
            ih.append("result", z ? "1" : "0");
            ih.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
        }
        this.afm = z;
    }

    public int getSlowNumber() {
        return this.afn;
    }

    public void setSlowNumber(int i) {
        this.afn = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.afo;
    }

    public void setErrNumber(int i) {
        this.afo = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.afm = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.afm = true;
                } else {
                    this.afm = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.afo = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.afn = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.afp = optJSONObject3.optInt("succ");
                    this.afq = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.afr = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.afn <= 0 || this.afo <= 0) {
                    this.afm = false;
                }
            } catch (Exception e) {
                this.afm = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
