package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.s;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CDNLogSyncData {
    private boolean Vo;
    private int Vp;
    private int Vq;
    private int Vr = 25;
    private int Vs = 25;
    private int Vt = 10;
    private int time;

    public int getSuccRank() {
        return this.Vr;
    }

    public void setSuccRank(int i) {
        this.Vr = i;
    }

    public int getErrRank() {
        return this.Vs;
    }

    public void setErrRank(int i) {
        this.Vs = i;
    }

    public int getSlowRank() {
        return this.Vt;
    }

    public void setSlowRank(int i) {
        this.Vt = i;
    }

    public boolean ismSwitch() {
        return this.Vo;
    }

    public void setmSwitch(boolean z) {
        if (this.Vo != z) {
            a fK = s.fK();
            fK.p("act", "fallback");
            fK.p("result", z ? "1" : "0");
            fK.p("type", "switch");
            BdStatisticsManager.getInstance().debug("img", fK);
        }
        this.Vo = z;
    }

    public int getSlowNumber() {
        return this.Vp;
    }

    public void setSlowNumber(int i) {
        this.Vp = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Vq;
    }

    public void setErrNumber(int i) {
        this.Vq = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vo = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vo = true;
                } else {
                    this.Vo = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vq = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vp = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Vr = optJSONObject3.optInt("succ");
                    this.Vs = optJSONObject3.optInt("err");
                    this.Vt = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vp <= 0 || this.Vq <= 0) {
                    this.Vo = false;
                }
            } catch (Exception e) {
                this.Vo = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
