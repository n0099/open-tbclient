package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private int dtZ = 0;
    private int dua = 0;
    private int dub = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int azx() {
        return this.dtZ;
    }

    public int azy() {
        return this.dua;
    }

    public int azz() {
        return this.dub;
    }

    public int azA() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dtZ = jSONObject.optInt("replyme", 0);
                this.dua = jSONObject.optInt("atme", 0);
                this.dub = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
