package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private int dmk = 0;
    private int dml = 0;
    private int dmm = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int avo() {
        return this.dmk;
    }

    public int avp() {
        return this.dml;
    }

    public int avq() {
        return this.dmm;
    }

    public int avr() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dmk = jSONObject.optInt("replyme", 0);
                this.dml = jSONObject.optInt("atme", 0);
                this.dmm = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
