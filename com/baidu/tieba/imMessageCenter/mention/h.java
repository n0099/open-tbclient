package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eoy = 0;
    private int eoz = 0;
    private int eoA = 0;
    private int fans = 0;
    private int chat = 0;
    private int eoB = 0;

    public int aIz() {
        return this.eoy;
    }

    public int aIA() {
        return this.eoz;
    }

    public int aIB() {
        return this.eoA;
    }

    public int aIC() {
        return this.fans;
    }

    public int aID() {
        return this.eoB;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eoy = jSONObject.optInt("agree", 0);
                this.eoz = jSONObject.optInt("replyme", 0);
                this.eoA = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eoB = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
