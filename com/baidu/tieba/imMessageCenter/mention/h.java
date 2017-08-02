package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dCZ = 0;
    private int dDa = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int azj() {
        return this.dCZ;
    }

    public int azk() {
        return this.dDa;
    }

    public int azl() {
        return this.fans;
    }

    public int azm() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dCZ = jSONObject.optInt("replyme", 0);
                this.dDa = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
