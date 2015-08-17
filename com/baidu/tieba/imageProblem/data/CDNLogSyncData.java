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
    private boolean UG;
    private int UH;
    private int UI;
    private int UJ = 25;
    private int UK = 25;
    private int UL = 10;
    private int time;

    public int getSuccRank() {
        return this.UJ;
    }

    public void setSuccRank(int i) {
        this.UJ = i;
    }

    public int getErrRank() {
        return this.UK;
    }

    public void setErrRank(int i) {
        this.UK = i;
    }

    public int getSlowRank() {
        return this.UL;
    }

    public void setSlowRank(int i) {
        this.UL = i;
    }

    public boolean ismSwitch() {
        return this.UG;
    }

    public void setmSwitch(boolean z) {
        if (this.UG != z) {
            d hd = r.hd();
            hd.q("act", "fallback");
            hd.q("result", z ? "1" : "0");
            hd.q("type", "switch");
            a.hk().b("img", hd);
        }
        this.UG = z;
    }

    public int getSlowNumber() {
        return this.UH;
    }

    public void setSlowNumber(int i) {
        this.UH = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.UI;
    }

    public void setErrNumber(int i) {
        this.UI = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UG = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UG = true;
                } else {
                    this.UG = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.UI = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UH = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UJ = optJSONObject3.optInt("succ");
                    this.UK = optJSONObject3.optInt("err");
                    this.UL = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UH <= 0 || this.UI <= 0) {
                    this.UG = false;
                }
            } catch (Exception e) {
                this.UG = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
