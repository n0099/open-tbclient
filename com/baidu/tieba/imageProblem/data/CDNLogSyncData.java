package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.v;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private boolean ND;
    private int NE;
    private int NF;
    private int NG = 25;
    private int NH = 25;
    private int NI = 10;
    private int time;

    public int getSuccRank() {
        return this.NG;
    }

    public void setSuccRank(int i) {
        this.NG = i;
    }

    public int getErrRank() {
        return this.NH;
    }

    public void setErrRank(int i) {
        this.NH = i;
    }

    public int getSlowRank() {
        return this.NI;
    }

    public void setSlowRank(int i) {
        this.NI = i;
    }

    public boolean ismSwitch() {
        return this.ND;
    }

    public void setmSwitch(boolean z) {
        if (this.ND != z) {
            d dG = v.dG();
            dG.q("act", "fallback");
            dG.q("result", z ? "1" : "0");
            dG.q("type", "switch");
            a.dN().b("img", dG);
        }
        this.ND = z;
    }

    public int getSlowNumber() {
        return this.NE;
    }

    public void setSlowNumber(int i) {
        this.NE = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.NF;
    }

    public void setErrNumber(int i) {
        this.NF = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.ND = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.ND = true;
                } else {
                    this.ND = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.NF = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.NE = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.NG = optJSONObject3.optInt("succ");
                    this.NH = optJSONObject3.optInt("err");
                    this.NI = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.NE <= 0 || this.NF <= 0) {
                    this.ND = false;
                }
            } catch (Exception e) {
                this.ND = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
