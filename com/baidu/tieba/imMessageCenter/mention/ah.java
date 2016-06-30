package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int dea = 0;
    private int deb = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int atz() {
        return this.dea;
    }

    public int atA() {
        return this.deb;
    }

    public int atB() {
        return this.fans;
    }

    public int atC() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dea = jSONObject.optInt("replyme", 0);
                this.deb = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
