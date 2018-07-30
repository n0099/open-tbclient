package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eHz = 0;
    private int eHA = 0;
    private int eHB = 0;
    private int fans = 0;
    private int chat = 0;
    private int eHC = 0;

    public int aPa() {
        return this.eHz;
    }

    public int aPb() {
        return this.eHA;
    }

    public int aPc() {
        return this.eHB;
    }

    public int aPd() {
        return this.fans;
    }

    public int aPe() {
        return this.eHC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHz = jSONObject.optInt("agree", 0);
                this.eHA = jSONObject.optInt("replyme", 0);
                this.eHB = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eHC = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
