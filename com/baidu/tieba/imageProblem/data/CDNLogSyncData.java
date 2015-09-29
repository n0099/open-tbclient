package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private boolean Uw;
    private int Ux;
    private int Uy;
    private int time;
    private int Uz = 25;
    private int UA = 25;
    private int UB = 10;

    public int getSuccRank() {
        return this.Uz;
    }

    public void setSuccRank(int i) {
        this.Uz = i;
    }

    public int getErrRank() {
        return this.UA;
    }

    public void setErrRank(int i) {
        this.UA = i;
    }

    public int getSlowRank() {
        return this.UB;
    }

    public void setSlowRank(int i) {
        this.UB = i;
    }

    public boolean ismSwitch() {
        return this.Uw;
    }

    public void setmSwitch(boolean z) {
        if (this.Uw != z) {
            d hb = r.hb();
            hb.q("act", "fallback");
            hb.q("result", z ? "1" : "0");
            hb.q("type", "switch");
            a.hi().b("img", hb);
        }
        this.Uw = z;
    }

    public int getSlowNumber() {
        return this.Ux;
    }

    public void setSlowNumber(int i) {
        this.Ux = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Uy;
    }

    public void setErrNumber(int i) {
        this.Uy = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Uw = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Uw = true;
                } else {
                    this.Uw = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Uy = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Ux = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Uz = optJSONObject3.optInt("succ");
                    this.UA = optJSONObject3.optInt("err");
                    this.UB = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Ux <= 0 || this.Uy <= 0) {
                    this.Uw = false;
                }
            } catch (Exception e) {
                this.Uw = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
