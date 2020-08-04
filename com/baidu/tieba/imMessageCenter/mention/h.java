package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class h {
    private int jqb = 0;
    private int jqc = 0;
    private int jqd = 0;
    private int fans = 0;
    private int chat = 0;
    private int jqe = 0;

    public int cyU() {
        return this.jqb;
    }

    public int cyV() {
        return this.jqc;
    }

    public int cyW() {
        return this.jqd;
    }

    public int cyX() {
        return this.fans;
    }

    public int cyY() {
        return this.jqe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jqb = jSONObject.optInt("agree", 0);
                this.jqc = jSONObject.optInt("replyme", 0);
                this.jqd = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jqe = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
