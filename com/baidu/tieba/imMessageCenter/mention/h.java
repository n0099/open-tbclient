package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    private int hMY = 0;
    private int hMZ = 0;
    private int hNa = 0;
    private int fans = 0;
    private int chat = 0;
    private int hNb = 0;

    public int bYa() {
        return this.hMY;
    }

    public int bYb() {
        return this.hMZ;
    }

    public int bYc() {
        return this.hNa;
    }

    public int bYd() {
        return this.fans;
    }

    public int bYe() {
        return this.hNb;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hMY = jSONObject.optInt("agree", 0);
                this.hMZ = jSONObject.optInt("replyme", 0);
                this.hNa = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hNb = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
