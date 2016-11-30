package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int dzE = 0;
    private int dzF = 0;
    private int dzG = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int aBt() {
        return this.dzE;
    }

    public int aBu() {
        return this.dzF;
    }

    public int aBv() {
        return this.dzG;
    }

    public int aBw() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dzE = jSONObject.optInt("replyme", 0);
                this.dzF = jSONObject.optInt("atme", 0);
                this.dzG = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
