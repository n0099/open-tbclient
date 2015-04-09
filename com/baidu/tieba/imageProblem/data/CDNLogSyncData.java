package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private int PA = 25;
    private int PC = 25;
    private int PD = 10;
    private boolean Px;
    private int Py;
    private int Pz;
    private int time;

    public int getSuccRank() {
        return this.PA;
    }

    public void setSuccRank(int i) {
        this.PA = i;
    }

    public int getErrRank() {
        return this.PC;
    }

    public void setErrRank(int i) {
        this.PC = i;
    }

    public int getSlowRank() {
        return this.PD;
    }

    public void setSlowRank(int i) {
        this.PD = i;
    }

    public boolean ismSwitch() {
        return this.Px;
    }

    public void setmSwitch(boolean z) {
        if (this.Px != z) {
            q hC = t.hC();
            hC.r("act", "fallback");
            hC.r("result", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("type", "switch");
            f.hP().a("img", hC);
        }
        this.Px = z;
    }

    public int getSlowNumber() {
        return this.Py;
    }

    public void setSlowNumber(int i) {
        this.Py = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Pz;
    }

    public void setErrNumber(int i) {
        this.Pz = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Px = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Px = true;
                } else {
                    this.Px = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Pz = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Py = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.PA = optJSONObject3.optInt("succ");
                    this.PC = optJSONObject3.optInt("err");
                    this.PD = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Py <= 0 || this.Pz <= 0) {
                    this.Px = false;
                }
            } catch (Exception e) {
                this.Px = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
