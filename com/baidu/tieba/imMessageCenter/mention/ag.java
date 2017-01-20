package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private int djQ = 0;
    private int djR = 0;
    private int djS = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int avS() {
        return this.djQ;
    }

    public int avT() {
        return this.djR;
    }

    public int avU() {
        return this.djS;
    }

    public int avV() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.djQ = jSONObject.optInt("replyme", 0);
                this.djR = jSONObject.optInt("atme", 0);
                this.djS = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
