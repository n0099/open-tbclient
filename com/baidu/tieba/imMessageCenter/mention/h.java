package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int hOY = 0;
    private int hOZ = 0;
    private int hPa = 0;
    private int fans = 0;
    private int chat = 0;
    private int hPb = 0;

    public int bZD() {
        return this.hOY;
    }

    public int bZE() {
        return this.hOZ;
    }

    public int bZF() {
        return this.hPa;
    }

    public int bZG() {
        return this.fans;
    }

    public int bZH() {
        return this.hPb;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hOY = jSONObject.optInt("agree", 0);
                this.hOZ = jSONObject.optInt("replyme", 0);
                this.hPa = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hPb = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
