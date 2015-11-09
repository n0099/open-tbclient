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
    private int UB;
    private int UC = 25;
    private int UD = 25;
    private int UE = 10;
    private boolean Uz;
    private int time;

    public int getSuccRank() {
        return this.UC;
    }

    public void setSuccRank(int i) {
        this.UC = i;
    }

    public int getErrRank() {
        return this.UD;
    }

    public void setErrRank(int i) {
        this.UD = i;
    }

    public int getSlowRank() {
        return this.UE;
    }

    public void setSlowRank(int i) {
        this.UE = i;
    }

    public boolean ismSwitch() {
        return this.Uz;
    }

    public void setmSwitch(boolean z) {
        if (this.Uz != z) {
            d hc = r.hc();
            hc.q("act", "fallback");
            hc.q("result", z ? "1" : "0");
            hc.q("type", "switch");
            a.hj().b("img", hc);
        }
        this.Uz = z;
    }

    public int getSlowNumber() {
        return this.UA;
    }

    public void setSlowNumber(int i) {
        this.UA = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.UB;
    }

    public void setErrNumber(int i) {
        this.UB = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Uz = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Uz = true;
                } else {
                    this.Uz = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UB = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UA = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UC = optJSONObject3.optInt("succ");
                    this.UD = optJSONObject3.optInt("err");
                    this.UE = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UA <= 0 || this.UB <= 0) {
                    this.Uz = false;
                }
            } catch (Exception e) {
                this.Uz = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
