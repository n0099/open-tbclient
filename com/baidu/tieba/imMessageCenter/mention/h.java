package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int hOW = 0;
    private int hOX = 0;
    private int hOY = 0;
    private int fans = 0;
    private int chat = 0;
    private int hOZ = 0;

    public int bZB() {
        return this.hOW;
    }

    public int bZC() {
        return this.hOX;
    }

    public int bZD() {
        return this.hOY;
    }

    public int bZE() {
        return this.fans;
    }

    public int bZF() {
        return this.hOZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hOW = jSONObject.optInt("agree", 0);
                this.hOX = jSONObject.optInt("replyme", 0);
                this.hOY = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hOZ = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
