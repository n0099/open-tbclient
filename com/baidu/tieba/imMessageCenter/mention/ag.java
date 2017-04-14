package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private int dkJ = 0;
    private int dkK = 0;
    private int dkL = 0;
    private int chat = 0;
    private int bookmark = 0;

    public int avh() {
        return this.dkJ;
    }

    public int avi() {
        return this.dkK;
    }

    public int avj() {
        return this.dkL;
    }

    public int avk() {
        return this.bookmark;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dkJ = jSONObject.optInt("replyme", 0);
                this.dkK = jSONObject.optInt("atme", 0);
                this.dkL = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.bookmark = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
