package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int fig = 0;
    private int fih = 0;
    private int fii = 0;
    private int fans = 0;
    private int chat = 0;
    private int fij = 0;

    public int aXc() {
        return this.fig;
    }

    public int aXd() {
        return this.fih;
    }

    public int aXe() {
        return this.fii;
    }

    public int aXf() {
        return this.fans;
    }

    public int aXg() {
        return this.fij;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fig = jSONObject.optInt("agree", 0);
                this.fih = jSONObject.optInt("replyme", 0);
                this.fii = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.fij = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
