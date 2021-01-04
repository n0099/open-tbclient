package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int kOp = 0;
    private int kOq = 0;
    private int kOr = 0;
    private int fans = 0;
    private int chat = 0;
    private int kOs = 0;

    public int dbe() {
        return this.kOp;
    }

    public int dbf() {
        return this.kOq;
    }

    public int dbg() {
        return this.kOr;
    }

    public int dbh() {
        return this.fans;
    }

    public int dbi() {
        return this.kOs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kOp = jSONObject.optInt("agree", 0);
                this.kOq = jSONObject.optInt("replyme", 0);
                this.kOr = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kOs = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
