package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gPm = 0;
    private int gPn = 0;
    private int gPo = 0;
    private int fans = 0;
    private int chat = 0;
    private int gPp = 0;

    public int bFo() {
        return this.gPm;
    }

    public int bFp() {
        return this.gPn;
    }

    public int bFq() {
        return this.gPo;
    }

    public int bFr() {
        return this.fans;
    }

    public int bFs() {
        return this.gPp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gPm = jSONObject.optInt("agree", 0);
                this.gPn = jSONObject.optInt("replyme", 0);
                this.gPo = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gPp = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
