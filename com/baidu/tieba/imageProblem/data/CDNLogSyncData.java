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
    private boolean amd;
    private int ame;
    private int amf;
    private int amg = 25;
    private int amh = 25;
    private int ami = 10;
    private int time;

    public int getSuccRank() {
        return this.amg;
    }

    public void setSuccRank(int i) {
        this.amg = i;
    }

    public int getErrRank() {
        return this.amh;
    }

    public void setErrRank(int i) {
        this.amh = i;
    }

    public int getSlowRank() {
        return this.ami;
    }

    public void setSlowRank(int i) {
        this.ami = i;
    }

    public boolean ismSwitch() {
        return this.amd;
    }

    public void setmSwitch(boolean z) {
        if (this.amd != z) {
            a jD = s.jD();
            jD.append(SocialConstants.PARAM_ACT, "fallback");
            jD.append("result", z ? "1" : "0");
            jD.append("type", "switch");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
        }
        this.amd = z;
    }

    public int getSlowNumber() {
        return this.ame;
    }

    public void setSlowNumber(int i) {
        this.ame = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.amf;
    }

    public void setErrNumber(int i) {
        this.amf = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.amd = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.amd = true;
                } else {
                    this.amd = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
                if (optJSONObject != null) {
                    this.amf = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt("time");
                    this.ame = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.amg = optJSONObject3.optInt("succ");
                    this.amh = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                    this.ami = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.ame <= 0 || this.amf <= 0) {
                    this.amd = false;
                }
            } catch (Exception e) {
                this.amd = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
