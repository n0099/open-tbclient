package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class h {
    private int kcF = 0;
    private int kcG = 0;
    private int kcH = 0;
    private int fans = 0;
    private int chat = 0;
    private int kcI = 0;

    public int cRa() {
        return this.kcF;
    }

    public int cRb() {
        return this.kcG;
    }

    public int cRc() {
        return this.kcH;
    }

    public int cRd() {
        return this.fans;
    }

    public int cRe() {
        return this.kcI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kcF = jSONObject.optInt("agree", 0);
                this.kcG = jSONObject.optInt("replyme", 0);
                this.kcH = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kcI = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
