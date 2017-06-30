package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ah {
    private int dux = 0;
    private int duy = 0;
    private int duz = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int axG() {
        return this.dux;
    }

    public int axH() {
        return this.duy;
    }

    public int axI() {
        return this.duz;
    }

    public int axJ() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dux = jSONObject.optInt("replyme", 0);
                this.duy = jSONObject.optInt("atme", 0);
                this.duz = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
