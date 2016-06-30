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
    private boolean Nw;
    private int Nx;
    private int Ny;
    private int time;
    private int Nz = 25;
    private int NA = 25;
    private int NB = 10;

    public int getSuccRank() {
        return this.Nz;
    }

    public void setSuccRank(int i) {
        this.Nz = i;
    }

    public int getErrRank() {
        return this.NA;
    }

    public void setErrRank(int i) {
        this.NA = i;
    }

    public int getSlowRank() {
        return this.NB;
    }

    public void setSlowRank(int i) {
        this.NB = i;
    }

    public boolean ismSwitch() {
        return this.Nw;
    }

    public void setmSwitch(boolean z) {
        if (this.Nw != z) {
            d dH = v.dH();
            dH.q("act", "fallback");
            dH.q("result", z ? "1" : "0");
            dH.q("type", "switch");
            a.dO().b("img", dH);
        }
        this.Nw = z;
    }

    public int getSlowNumber() {
        return this.Nx;
    }

    public void setSlowNumber(int i) {
        this.Nx = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Ny;
    }

    public void setErrNumber(int i) {
        this.Ny = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Nw = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Nw = true;
                } else {
                    this.Nw = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Ny = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Nx = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Nz = optJSONObject3.optInt("succ");
                    this.NA = optJSONObject3.optInt("err");
                    this.NB = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Nx <= 0 || this.Ny <= 0) {
                    this.Nw = false;
                }
            } catch (Exception e) {
                this.Nw = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
