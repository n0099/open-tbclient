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
    private boolean Pv;
    private int Pw;
    private int Px;
    private int time;
    private int Py = 25;
    private int Pz = 25;
    private int PA = 10;

    public int getSuccRank() {
        return this.Py;
    }

    public void setSuccRank(int i) {
        this.Py = i;
    }

    public int getErrRank() {
        return this.Pz;
    }

    public void setErrRank(int i) {
        this.Pz = i;
    }

    public int getSlowRank() {
        return this.PA;
    }

    public void setSlowRank(int i) {
        this.PA = i;
    }

    public boolean ismSwitch() {
        return this.Pv;
    }

    public void setmSwitch(boolean z) {
        if (this.Pv != z) {
            q hC = t.hC();
            hC.r("act", "fallback");
            hC.r("result", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("type", "switch");
            f.hP().a("img", hC);
        }
        this.Pv = z;
    }

    public int getSlowNumber() {
        return this.Pw;
    }

    public void setSlowNumber(int i) {
        this.Pw = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Px;
    }

    public void setErrNumber(int i) {
        this.Px = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Pv = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Pv = true;
                } else {
                    this.Pv = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Px = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Pw = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Py = optJSONObject3.optInt("succ");
                    this.Pz = optJSONObject3.optInt("err");
                    this.PA = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Pw <= 0 || this.Px <= 0) {
                    this.Pv = false;
                }
            } catch (Exception e) {
                this.Pv = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
