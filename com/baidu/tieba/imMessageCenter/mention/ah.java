package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ah {
    private int dhf = 0;
    private int dhg = 0;
    private int dhh = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int atd() {
        return this.dhf;
    }

    public int ate() {
        return this.dhg;
    }

    public int atf() {
        return this.dhh;
    }

    public int atg() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dhf = jSONObject.optInt("replyme", 0);
                this.dhg = jSONObject.optInt("atme", 0);
                this.dhh = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
