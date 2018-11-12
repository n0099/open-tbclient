package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int eXL = 0;
    private int eXM = 0;
    private int eXN = 0;
    private int fans = 0;
    private int chat = 0;
    private int eXO = 0;

    public int aTX() {
        return this.eXL;
    }

    public int aTY() {
        return this.eXM;
    }

    public int aTZ() {
        return this.eXN;
    }

    public int aUa() {
        return this.fans;
    }

    public int aUb() {
        return this.eXO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eXL = jSONObject.optInt("agree", 0);
                this.eXM = jSONObject.optInt("replyme", 0);
                this.eXN = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eXO = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
