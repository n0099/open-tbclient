package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int iQb = 0;
    private int iQc = 0;
    private int iQd = 0;
    private int fans = 0;
    private int chat = 0;
    private int iQe = 0;

    public int crd() {
        return this.iQb;
    }

    public int cre() {
        return this.iQc;
    }

    public int crf() {
        return this.iQd;
    }

    public int crg() {
        return this.fans;
    }

    public int crh() {
        return this.iQe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iQb = jSONObject.optInt("agree", 0);
                this.iQc = jSONObject.optInt("replyme", 0);
                this.iQd = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.iQe = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
