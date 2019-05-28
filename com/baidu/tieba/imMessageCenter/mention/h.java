package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gPk = 0;
    private int gPl = 0;
    private int gPm = 0;
    private int fans = 0;
    private int chat = 0;
    private int gPn = 0;

    public int bFn() {
        return this.gPk;
    }

    public int bFo() {
        return this.gPl;
    }

    public int bFp() {
        return this.gPm;
    }

    public int bFq() {
        return this.fans;
    }

    public int bFr() {
        return this.gPn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gPk = jSONObject.optInt("agree", 0);
                this.gPl = jSONObject.optInt("replyme", 0);
                this.gPm = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gPn = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
