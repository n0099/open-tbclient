package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int ens = 0;
    private int ent = 0;
    private int enu = 0;
    private int fans = 0;
    private int chat = 0;
    private int env = 0;

    public int aIA() {
        return this.ens;
    }

    public int aIB() {
        return this.ent;
    }

    public int aIC() {
        return this.enu;
    }

    public int aID() {
        return this.fans;
    }

    public int aIE() {
        return this.env;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ens = jSONObject.optInt("agree", 0);
                this.ent = jSONObject.optInt("replyme", 0);
                this.enu = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.env = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
