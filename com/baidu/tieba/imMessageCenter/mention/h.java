package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gWj = 0;
    private int gWk = 0;
    private int gWl = 0;
    private int fans = 0;
    private int chat = 0;
    private int gWm = 0;

    public int bFH() {
        return this.gWj;
    }

    public int bFI() {
        return this.gWk;
    }

    public int bFJ() {
        return this.gWl;
    }

    public int bFK() {
        return this.fans;
    }

    public int bFL() {
        return this.gWm;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gWj = jSONObject.optInt("agree", 0);
                this.gWk = jSONObject.optInt("replyme", 0);
                this.gWl = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gWm = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
