package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gxV = 0;
    private int gxW = 0;
    private int gxX = 0;
    private int fans = 0;
    private int chat = 0;
    private int gxY = 0;

    public int bxC() {
        return this.gxV;
    }

    public int bxD() {
        return this.gxW;
    }

    public int bxE() {
        return this.gxX;
    }

    public int bxF() {
        return this.fans;
    }

    public int bxG() {
        return this.gxY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gxV = jSONObject.optInt("agree", 0);
                this.gxW = jSONObject.optInt("replyme", 0);
                this.gxX = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gxY = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
