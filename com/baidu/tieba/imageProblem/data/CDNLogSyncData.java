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
    private boolean Vq;
    private int Vr;
    private int Vs;
    private int Vt = 25;
    private int Vu = 25;
    private int Vv = 10;
    private int time;

    public int getSuccRank() {
        return this.Vt;
    }

    public void setSuccRank(int i) {
        this.Vt = i;
    }

    public int getErrRank() {
        return this.Vu;
    }

    public void setErrRank(int i) {
        this.Vu = i;
    }

    public int getSlowRank() {
        return this.Vv;
    }

    public void setSlowRank(int i) {
        this.Vv = i;
    }

    public boolean ismSwitch() {
        return this.Vq;
    }

    public void setmSwitch(boolean z) {
        if (this.Vq != z) {
            d he = v.he();
            he.q("act", "fallback");
            he.q("result", z ? "1" : "0");
            he.q("type", "switch");
            a.hl().b("img", he);
        }
        this.Vq = z;
    }

    public int getSlowNumber() {
        return this.Vr;
    }

    public void setSlowNumber(int i) {
        this.Vr = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getErrNumber() {
        return this.Vs;
    }

    public void setErrNumber(int i) {
        this.Vs = i;
    }

    public void parseJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseJson(new JSONObject(str));
            }
        } catch (Exception e) {
            this.Vq = false;
            BdLog.e(e.getMessage());
        }
    }

    private void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.Vq = true;
                } else {
                    this.Vq = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.Vs = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.time = optJSONObject2.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    this.Vr = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.Vt = optJSONObject3.optInt("succ");
                    this.Vu = optJSONObject3.optInt("err");
                    this.Vv = optJSONObject3.optInt("slow");
                }
                if (this.time <= 0 || this.Vr <= 0 || this.Vs <= 0) {
                    this.Vq = false;
                }
            } catch (Exception e) {
                this.Vq = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
