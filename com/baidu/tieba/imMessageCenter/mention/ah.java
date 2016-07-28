package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int dgW = 0;
    private int dgX = 0;
    private int fans = 0;
    private int dgY = 0;
    private int bookmark = 0;

    public int aul() {
        return this.dgW;
    }

    public int aum() {
        return this.dgX;
    }

    public int aun() {
        return this.fans;
    }

    public int auo() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dgW = jSONObject.optInt("replyme", 0);
                this.dgX = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.dgY = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
