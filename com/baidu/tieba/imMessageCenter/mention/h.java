package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class h {
    private int jNH = 0;
    private int jNI = 0;
    private int jNJ = 0;
    private int fans = 0;
    private int chat = 0;
    private int jNK = 0;

    public int cNs() {
        return this.jNH;
    }

    public int cNt() {
        return this.jNI;
    }

    public int cNu() {
        return this.jNJ;
    }

    public int cNv() {
        return this.fans;
    }

    public int cNw() {
        return this.jNK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jNH = jSONObject.optInt("agree", 0);
                this.jNI = jSONObject.optInt("replyme", 0);
                this.jNJ = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jNK = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
