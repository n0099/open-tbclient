package com.baidu.tieba.imageProblem.data;

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
    private boolean WW;
    private int WX;
    private int WY;
    private int WZ = 25;
    private int Xa = 25;
    private int Xb = 10;
    private int time;

    public int getSuccRank() {
        return this.WZ;
    }

    public void setSuccRank(int i) {
        this.WZ = i;
    }

    public int getErrRank() {
        return this.Xa;
    }

    public void setErrRank(int i) {
        this.Xa = i;
    }

    public int getSlowRank() {
        return this.Xb;
    }

    public void setSlowRank(int i) {
        this.Xb = i;
    }

    public boolean ismSwitch() {
        return this.WW;
    }

    public void setmSwitch(boolean z) {
        if (this.WW != z) {
            a fq = s.fq();
            fq.append(SocialConstants.PARAM_ACT, "fallback");
            fq.append("result", z ? "1" : "0");
            fq.append("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fq);
        }
        this.WW = z;
    }

    public int getSlowNumber() {
        return this.WX;
    }

    public void setSlowNumber(int i) {
        this.WX = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.WY;
    }

    public void setErrNumber(int i) {
        this.WY = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.WW = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.WW = true;
                } else {
                    this.WW = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.WY = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.WX = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.WZ = optJSONObject3.optInt("succ");
                    this.Xa = optJSONObject3.optInt("err");
                    this.Xb = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.WX <= 0 || this.WY <= 0) {
                    this.WW = false;
                }
            } catch (Exception e) {
                this.WW = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
