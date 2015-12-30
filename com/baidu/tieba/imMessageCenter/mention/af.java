package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private int ciD = 0;
    private int ciE = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int aeA() {
        return this.ciD;
    }

    public int aeB() {
        return this.ciE;
    }

    public int aeC() {
        return this.fans;
    }

    public int aeD() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ciD = jSONObject.optInt("replyme", 0);
                this.ciE = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
