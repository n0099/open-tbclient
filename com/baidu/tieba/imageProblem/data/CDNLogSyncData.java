package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.u;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CDNLogSyncData {
    private boolean Vb;
    private int Vc;
    private int Vd;
    private int Ve = 25;
    private int Vf = 25;
    private int Vg = 10;
    private int time;

    public int getSuccRank() {
        return this.Ve;
    }

    public void setSuccRank(int i) {
        this.Ve = i;
    }

    public int getErrRank() {
        return this.Vf;
    }

    public void setErrRank(int i) {
        this.Vf = i;
    }

    public int getSlowRank() {
        return this.Vg;
    }

    public void setSlowRank(int i) {
        this.Vg = i;
    }

    public boolean ismSwitch() {
        return this.Vb;
    }

    public void setmSwitch(boolean z) {
        if (this.Vb != z) {
            d hm = u.hm();
            hm.r("act", "fallback");
            hm.r("result", z ? "1" : "0");
            hm.r("type", "switch");
            a.ht().b("img", hm);
        }
        this.Vb = z;
    }

    public int getSlowNumber() {
        return this.Vc;
    }

    public void setSlowNumber(int i) {
        this.Vc = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Vd;
    }

    public void setErrNumber(int i) {
        this.Vd = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vb = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vb = true;
                } else {
                    this.Vb = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vd = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vc = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Ve = optJSONObject3.optInt("succ");
                    this.Vf = optJSONObject3.optInt("err");
                    this.Vg = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vc <= 0 || this.Vd <= 0) {
                    this.Vb = false;
                }
            } catch (Exception e) {
                this.Vb = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
