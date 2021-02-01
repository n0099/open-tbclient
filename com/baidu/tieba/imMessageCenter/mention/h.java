package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int kRN = 0;
    private int kRO = 0;
    private int kRP = 0;
    private int fans = 0;
    private int chat = 0;
    private int kRQ = 0;

    public int cZl() {
        return this.kRN;
    }

    public int cZm() {
        return this.kRO;
    }

    public int cZn() {
        return this.kRP;
    }

    public int cZo() {
        return this.fans;
    }

    public int cZp() {
        return this.kRQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kRN = jSONObject.optInt("agree", 0);
                this.kRO = jSONObject.optInt("replyme", 0);
                this.kRP = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kRQ = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
