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
    private boolean aeX;
    private int aeY;
    private int aeZ;
    private int afa = 25;
    private int afb = 25;
    private int afc = 10;
    private int time;

    public int getSuccRank() {
        return this.afa;
    }

    public void setSuccRank(int i) {
        this.afa = i;
    }

    public int getErrRank() {
        return this.afb;
    }

    public void setErrRank(int i) {
        this.afb = i;
    }

    public int getSlowRank() {
        return this.afc;
    }

    public void setSlowRank(int i) {
        this.afc = i;
    }

    public boolean ismSwitch() {
        return this.aeX;
    }

    public void setmSwitch(boolean z) {
        if (this.aeX != z) {
            a ih = t.ih();
            ih.append(SocialConstants.PARAM_ACT, "fallback");
            ih.append("result", z ? "1" : "0");
            ih.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", ih);
        }
        this.aeX = z;
    }

    public int getSlowNumber() {
        return this.aeY;
    }

    public void setSlowNumber(int i) {
        this.aeY = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.aeZ;
    }

    public void setErrNumber(int i) {
        this.aeZ = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.aeX = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.aeX = true;
                } else {
                    this.aeX = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.aeZ = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.aeY = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.afa = optJSONObject3.optInt("succ");
                    this.afb = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.afc = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.aeY <= 0 || this.aeZ <= 0) {
                    this.aeX = false;
                }
            } catch (Exception e) {
                this.aeX = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
