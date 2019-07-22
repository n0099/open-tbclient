package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gVw = 0;
    private int gVx = 0;
    private int gVy = 0;
    private int fans = 0;
    private int chat = 0;
    private int gVz = 0;

    public int bHV() {
        return this.gVw;
    }

    public int bHW() {
        return this.gVx;
    }

    public int bHX() {
        return this.gVy;
    }

    public int bHY() {
        return this.fans;
    }

    public int bHZ() {
        return this.gVz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gVw = jSONObject.optInt("agree", 0);
                this.gVx = jSONObject.optInt("replyme", 0);
                this.gVy = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gVz = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
