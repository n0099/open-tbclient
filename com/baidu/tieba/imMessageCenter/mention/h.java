package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int ezP = 0;
    private int ezQ = 0;
    private int ezR = 0;
    private int fans = 0;
    private int chat = 0;
    private int ezS = 0;

    public int aNu() {
        return this.ezP;
    }

    public int aNv() {
        return this.ezQ;
    }

    public int aNw() {
        return this.ezR;
    }

    public int aNx() {
        return this.fans;
    }

    public int aNy() {
        return this.ezS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ezP = jSONObject.optInt("agree", 0);
                this.ezQ = jSONObject.optInt("replyme", 0);
                this.ezR = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.ezS = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
