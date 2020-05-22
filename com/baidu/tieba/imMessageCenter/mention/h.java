package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int iPo = 0;
    private int iPp = 0;
    private int iPq = 0;
    private int fans = 0;
    private int chat = 0;
    private int iPr = 0;

    public int cqU() {
        return this.iPo;
    }

    public int cqV() {
        return this.iPp;
    }

    public int cqW() {
        return this.iPq;
    }

    public int cqX() {
        return this.fans;
    }

    public int cqY() {
        return this.iPr;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iPo = jSONObject.optInt("agree", 0);
                this.iPp = jSONObject.optInt("replyme", 0);
                this.iPq = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.iPr = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
