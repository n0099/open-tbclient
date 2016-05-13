package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int cyE = 0;
    private int cyF = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int alm() {
        return this.cyE;
    }

    public int aln() {
        return this.cyF;
    }

    public int alo() {
        return this.fans;
    }

    public int alp() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cyE = jSONObject.optInt("replyme", 0);
                this.cyF = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
