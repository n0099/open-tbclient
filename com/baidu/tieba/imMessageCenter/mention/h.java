package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gWo = 0;
    private int gWp = 0;
    private int gWq = 0;
    private int fans = 0;
    private int chat = 0;
    private int gWr = 0;

    public int bIj() {
        return this.gWo;
    }

    public int bIk() {
        return this.gWp;
    }

    public int bIl() {
        return this.gWq;
    }

    public int bIm() {
        return this.fans;
    }

    public int bIn() {
        return this.gWr;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gWo = jSONObject.optInt("agree", 0);
                this.gWp = jSONObject.optInt("replyme", 0);
                this.gWq = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gWr = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
