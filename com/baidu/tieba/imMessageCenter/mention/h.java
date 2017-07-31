package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dEq = 0;
    private int dEr = 0;
    private int fans = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int azu() {
        return this.dEq;
    }

    public int azv() {
        return this.dEr;
    }

    public int azw() {
        return this.fans;
    }

    public int azx() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dEq = jSONObject.optInt("replyme", 0);
                this.dEr = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
