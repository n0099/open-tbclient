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
    private int NA = 25;
    private int NB = 25;
    private int NC = 10;
    private boolean Nx;
    private int Ny;
    private int Nz;
    private int time;

    public int getSuccRank() {
        return this.NA;
    }

    public void setSuccRank(int i) {
        this.NA = i;
    }

    public int getErrRank() {
        return this.NB;
    }

    public void setErrRank(int i) {
        this.NB = i;
    }

    public int getSlowRank() {
        return this.NC;
    }

    public void setSlowRank(int i) {
        this.NC = i;
    }

    public boolean ismSwitch() {
        return this.Nx;
    }

    public void setmSwitch(boolean z) {
        if (this.Nx != z) {
            d dG = v.dG();
            dG.q("act", "fallback");
            dG.q("result", z ? "1" : "0");
            dG.q("type", "switch");
            a.dN().b("img", dG);
        }
        this.Nx = z;
    }

    public int getSlowNumber() {
        return this.Ny;
    }

    public void setSlowNumber(int i) {
        this.Ny = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Nz;
    }

    public void setErrNumber(int i) {
        this.Nz = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Nx = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Nx = true;
                } else {
                    this.Nx = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Nz = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Ny = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.NA = optJSONObject3.optInt("succ");
                    this.NB = optJSONObject3.optInt("err");
                    this.NC = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Ny <= 0 || this.Nz <= 0) {
                    this.Nx = false;
                }
            } catch (Exception e) {
                this.Nx = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
