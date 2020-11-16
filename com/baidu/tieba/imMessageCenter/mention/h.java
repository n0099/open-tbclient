package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class h {
    private int kvK = 0;
    private int kvL = 0;
    private int kvM = 0;
    private int fans = 0;
    private int chat = 0;
    private int kvN = 0;

    public int cWo() {
        return this.kvK;
    }

    public int cWp() {
        return this.kvL;
    }

    public int cWq() {
        return this.kvM;
    }

    public int cWr() {
        return this.fans;
    }

    public int cWs() {
        return this.kvN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kvK = jSONObject.optInt("agree", 0);
                this.kvL = jSONObject.optInt("replyme", 0);
                this.kvM = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kvN = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
