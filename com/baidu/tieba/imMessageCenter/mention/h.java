package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int kUd = 0;
    private int kUe = 0;
    private int kUf = 0;
    private int fans = 0;
    private int chat = 0;
    private int kUg = 0;

    public int cZz() {
        return this.kUd;
    }

    public int cZA() {
        return this.kUe;
    }

    public int cZB() {
        return this.kUf;
    }

    public int cZC() {
        return this.fans;
    }

    public int cZD() {
        return this.kUg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kUd = jSONObject.optInt("agree", 0);
                this.kUe = jSONObject.optInt("replyme", 0);
                this.kUf = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kUg = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
