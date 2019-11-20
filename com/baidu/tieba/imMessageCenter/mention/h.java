package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gVs = 0;
    private int gVt = 0;
    private int gVu = 0;
    private int fans = 0;
    private int chat = 0;
    private int gVv = 0;

    public int bFF() {
        return this.gVs;
    }

    public int bFG() {
        return this.gVt;
    }

    public int bFH() {
        return this.gVu;
    }

    public int bFI() {
        return this.fans;
    }

    public int bFJ() {
        return this.gVv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gVs = jSONObject.optInt("agree", 0);
                this.gVt = jSONObject.optInt("replyme", 0);
                this.gVu = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gVv = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
