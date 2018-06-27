package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eDF = 0;
    private int eDG = 0;
    private int eDH = 0;
    private int fans = 0;
    private int chat = 0;
    private int eDI = 0;

    public int aOa() {
        return this.eDF;
    }

    public int aOb() {
        return this.eDG;
    }

    public int aOc() {
        return this.eDH;
    }

    public int aOd() {
        return this.fans;
    }

    public int aOe() {
        return this.eDI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eDF = jSONObject.optInt("agree", 0);
                this.eDG = jSONObject.optInt("replyme", 0);
                this.eDH = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eDI = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
