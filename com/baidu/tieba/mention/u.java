package com.baidu.tieba.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int cbb = 0;
    private int cbc = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int adm() {
        return this.cbb;
    }

    public int adn() {
        return this.cbc;
    }

    public int ado() {
        return this.fans;
    }

    public int adp() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cbb = jSONObject.optInt("replyme", 0);
                this.cbc = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
