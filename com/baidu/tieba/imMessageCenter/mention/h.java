package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gYi = 0;
    private int gYj = 0;
    private int gYk = 0;
    private int fans = 0;
    private int chat = 0;
    private int gYl = 0;

    public int bIX() {
        return this.gYi;
    }

    public int bIY() {
        return this.gYj;
    }

    public int bIZ() {
        return this.gYk;
    }

    public int bJa() {
        return this.fans;
    }

    public int bJb() {
        return this.gYl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gYi = jSONObject.optInt("agree", 0);
                this.gYj = jSONObject.optInt("replyme", 0);
                this.gYk = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gYl = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
