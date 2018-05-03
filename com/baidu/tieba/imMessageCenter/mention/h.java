package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int enp = 0;
    private int enq = 0;
    private int enr = 0;
    private int fans = 0;
    private int chat = 0;
    private int ens = 0;

    public int aIA() {
        return this.enp;
    }

    public int aIB() {
        return this.enq;
    }

    public int aIC() {
        return this.enr;
    }

    public int aID() {
        return this.fans;
    }

    public int aIE() {
        return this.ens;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.enp = jSONObject.optInt("agree", 0);
                this.enq = jSONObject.optInt("replyme", 0);
                this.enr = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.ens = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
