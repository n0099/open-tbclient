package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ah {
    private int dmB = 0;
    private int dmC = 0;
    private int dmD = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int atY() {
        return this.dmB;
    }

    public int atZ() {
        return this.dmC;
    }

    public int aua() {
        return this.dmD;
    }

    public int aub() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dmB = jSONObject.optInt("replyme", 0);
                this.dmC = jSONObject.optInt("atme", 0);
                this.dmD = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
