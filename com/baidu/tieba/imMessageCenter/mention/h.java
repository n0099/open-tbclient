package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int hQK = 0;
    private int hQL = 0;
    private int hQM = 0;
    private int fans = 0;
    private int chat = 0;
    private int hQN = 0;

    public int bZW() {
        return this.hQK;
    }

    public int bZX() {
        return this.hQL;
    }

    public int bZY() {
        return this.hQM;
    }

    public int bZZ() {
        return this.fans;
    }

    public int caa() {
        return this.hQN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hQK = jSONObject.optInt("agree", 0);
                this.hQL = jSONObject.optInt("replyme", 0);
                this.hQM = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hQN = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
