package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private int dna = 0;
    private int dnb = 0;
    private int dnc = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int awi() {
        return this.dna;
    }

    public int awj() {
        return this.dnb;
    }

    public int awk() {
        return this.dnc;
    }

    public int awl() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dna = jSONObject.optInt("replyme", 0);
                this.dnb = jSONObject.optInt("atme", 0);
                this.dnc = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
