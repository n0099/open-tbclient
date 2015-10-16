package com.baidu.tieba.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int caA = 0;
    private int caB = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int acV() {
        return this.caA;
    }

    public int acW() {
        return this.caB;
    }

    public int acX() {
        return this.fans;
    }

    public int acY() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.caA = jSONObject.optInt("replyme", 0);
                this.caB = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
