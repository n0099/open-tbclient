package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int hPk = 0;
    private int hPl = 0;
    private int hPm = 0;
    private int fans = 0;
    private int chat = 0;
    private int hPn = 0;

    public int bZE() {
        return this.hPk;
    }

    public int bZF() {
        return this.hPl;
    }

    public int bZG() {
        return this.hPm;
    }

    public int bZH() {
        return this.fans;
    }

    public int bZI() {
        return this.hPn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hPk = jSONObject.optInt("agree", 0);
                this.hPl = jSONObject.optInt("replyme", 0);
                this.hPm = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hPn = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
