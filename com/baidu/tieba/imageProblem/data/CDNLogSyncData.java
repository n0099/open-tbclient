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
    private boolean UQ;
    private int UR;
    private int US;
    private int UT = 25;
    private int UU = 25;
    private int UV = 10;
    private int time;

    public int getSuccRank() {
        return this.UT;
    }

    public void setSuccRank(int i) {
        this.UT = i;
    }

    public int getErrRank() {
        return this.UU;
    }

    public void setErrRank(int i) {
        this.UU = i;
    }

    public int getSlowRank() {
        return this.UV;
    }

    public void setSlowRank(int i) {
        this.UV = i;
    }

    public boolean ismSwitch() {
        return this.UQ;
    }

    public void setmSwitch(boolean z) {
        if (this.UQ != z) {
            d he = v.he();
            he.q("act", "fallback");
            he.q("result", z ? "1" : "0");
            he.q("type", "switch");
            a.hl().b("img", he);
        }
        this.UQ = z;
    }

    public int getSlowNumber() {
        return this.UR;
    }

    public void setSlowNumber(int i) {
        this.UR = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.US;
    }

    public void setErrNumber(int i) {
        this.US = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.UQ = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.UQ = true;
                } else {
                    this.UQ = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.US = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.UR = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.UT = optJSONObject3.optInt("succ");
                    this.UU = optJSONObject3.optInt("err");
                    this.UV = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.UR <= 0 || this.US <= 0) {
                    this.UQ = false;
                }
            } catch (Exception e) {
                this.UQ = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
