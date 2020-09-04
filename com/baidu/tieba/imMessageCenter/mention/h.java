package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class h {
    private int jFf = 0;
    private int jFg = 0;
    private int jFh = 0;
    private int fans = 0;
    private int chat = 0;
    private int jFi = 0;

    public int cJM() {
        return this.jFf;
    }

    public int cJN() {
        return this.jFg;
    }

    public int cJO() {
        return this.jFh;
    }

    public int cJP() {
        return this.fans;
    }

    public int cJQ() {
        return this.jFi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jFf = jSONObject.optInt("agree", 0);
                this.jFg = jSONObject.optInt("replyme", 0);
                this.jFh = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jFi = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
