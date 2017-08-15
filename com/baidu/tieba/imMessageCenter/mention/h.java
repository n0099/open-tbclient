package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dGn = 0;
    private int dGo = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int aAb() {
        return this.dGn;
    }

    public int aAc() {
        return this.dGo;
    }

    public int aAd() {
        return this.fans;
    }

    public int aAe() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dGn = jSONObject.optInt("replyme", 0);
                this.dGo = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
