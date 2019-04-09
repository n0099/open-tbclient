package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gxW = 0;
    private int gxX = 0;
    private int gxY = 0;
    private int fans = 0;
    private int chat = 0;
    private int gxZ = 0;

    public int bxC() {
        return this.gxW;
    }

    public int bxD() {
        return this.gxX;
    }

    public int bxE() {
        return this.gxY;
    }

    public int bxF() {
        return this.fans;
    }

    public int bxG() {
        return this.gxZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gxW = jSONObject.optInt("agree", 0);
                this.gxX = jSONObject.optInt("replyme", 0);
                this.gxY = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gxZ = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
