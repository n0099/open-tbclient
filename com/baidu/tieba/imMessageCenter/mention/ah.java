package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int dsC = 0;
    private int dsD = 0;
    private int dsE = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int ayZ() {
        return this.dsC;
    }

    public int aza() {
        return this.dsD;
    }

    public int azb() {
        return this.dsE;
    }

    public int azc() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dsC = jSONObject.optInt("replyme", 0);
                this.dsD = jSONObject.optInt("atme", 0);
                this.dsE = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
