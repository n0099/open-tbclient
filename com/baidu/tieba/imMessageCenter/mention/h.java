package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gPi = 0;
    private int gPj = 0;
    private int gPk = 0;
    private int fans = 0;
    private int chat = 0;
    private int gPl = 0;

    public int bFk() {
        return this.gPi;
    }

    public int bFl() {
        return this.gPj;
    }

    public int bFm() {
        return this.gPk;
    }

    public int bFn() {
        return this.fans;
    }

    public int bFo() {
        return this.gPl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gPi = jSONObject.optInt("agree", 0);
                this.gPj = jSONObject.optInt("replyme", 0);
                this.gPk = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gPl = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
