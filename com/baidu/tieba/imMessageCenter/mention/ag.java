package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private int cxF = 0;
    private int cxG = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int ale() {
        return this.cxF;
    }

    public int alf() {
        return this.cxG;
    }

    public int alg() {
        return this.fans;
    }

    public int alh() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cxF = jSONObject.optInt("replyme", 0);
                this.cxG = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
