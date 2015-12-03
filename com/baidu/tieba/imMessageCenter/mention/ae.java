package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private int ceB = 0;
    private int ceC = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int ads() {
        return this.ceB;
    }

    public int adt() {
        return this.ceC;
    }

    public int adu() {
        return this.fans;
    }

    public int adv() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ceB = jSONObject.optInt("replyme", 0);
                this.ceC = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
