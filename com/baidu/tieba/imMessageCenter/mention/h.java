package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eOK = 0;
    private int eOL = 0;
    private int eOM = 0;
    private int fans = 0;
    private int chat = 0;
    private int eON = 0;

    public int aRm() {
        return this.eOK;
    }

    public int aRn() {
        return this.eOL;
    }

    public int aRo() {
        return this.eOM;
    }

    public int aRp() {
        return this.fans;
    }

    public int aRq() {
        return this.eON;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eOK = jSONObject.optInt("agree", 0);
                this.eOL = jSONObject.optInt("replyme", 0);
                this.eOM = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eON = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
