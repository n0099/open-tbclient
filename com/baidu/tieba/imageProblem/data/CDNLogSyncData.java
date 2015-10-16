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
    private int UA;
    private int UB = 25;
    private int UC = 25;
    private int UD = 10;
    private boolean Uy;
    private int Uz;
    private int time;

    public int getSuccRank() {
        return this.UB;
    }

    public void setSuccRank(int i) {
        this.UB = i;
    }

    public int getErrRank() {
        return this.UC;
    }

    public void setErrRank(int i) {
        this.UC = i;
    }

    public int getSlowRank() {
        return this.UD;
    }

    public void setSlowRank(int i) {
        this.UD = i;
    }

    public boolean ismSwitch() {
        return this.Uy;
    }

    public void setmSwitch(boolean z) {
        if (this.Uy != z) {
            d hb = r.hb();
            hb.q("act", "fallback");
            hb.q("result", z ? "1" : "0");
            hb.q("type", "switch");
            a.hi().b("img", hb);
        }
        this.Uy = z;
    }

    public int getSlowNumber() {
        return this.Uz;
    }

    public void setSlowNumber(int i) {
        this.Uz = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.UA;
    }

    public void setErrNumber(int i) {
        this.UA = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Uy = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Uy = true;
                } else {
                    this.Uy = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UA = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Uz = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UB = optJSONObject3.optInt("succ");
                    this.UC = optJSONObject3.optInt("err");
                    this.UD = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Uz <= 0 || this.UA <= 0) {
                    this.Uy = false;
                }
            } catch (Exception e) {
                this.Uy = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
