package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private int dcF = 0;
    private int dcG = 0;
    private int dcH = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int auM() {
        return this.dcF;
    }

    public int auN() {
        return this.dcG;
    }

    public int auO() {
        return this.dcH;
    }

    public int auP() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dcF = jSONObject.optInt("replyme", 0);
                this.dcG = jSONObject.optInt("atme", 0);
                this.dcH = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
