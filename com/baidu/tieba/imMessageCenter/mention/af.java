package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private int cnd = 0;
    private int cne = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int ahK() {
        return this.cnd;
    }

    public int ahL() {
        return this.cne;
    }

    public int ahM() {
        return this.fans;
    }

    public int ahN() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cnd = jSONObject.optInt("replyme", 0);
                this.cne = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
