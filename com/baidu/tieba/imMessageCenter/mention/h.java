package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eHu = 0;
    private int eHv = 0;
    private int eHw = 0;
    private int fans = 0;
    private int chat = 0;
    private int eHx = 0;

    public int aOX() {
        return this.eHu;
    }

    public int aOY() {
        return this.eHv;
    }

    public int aOZ() {
        return this.eHw;
    }

    public int aPa() {
        return this.fans;
    }

    public int aPb() {
        return this.eHx;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHu = jSONObject.optInt("agree", 0);
                this.eHv = jSONObject.optInt("replyme", 0);
                this.eHw = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eHx = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
