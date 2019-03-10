package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gyj = 0;
    private int gyk = 0;
    private int gyl = 0;
    private int fans = 0;
    private int chat = 0;
    private int gym = 0;

    public int bxG() {
        return this.gyj;
    }

    public int bxH() {
        return this.gyk;
    }

    public int bxI() {
        return this.gyl;
    }

    public int bxJ() {
        return this.fans;
    }

    public int bxK() {
        return this.gym;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gyj = jSONObject.optInt("agree", 0);
                this.gyk = jSONObject.optInt("replyme", 0);
                this.gyl = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.gym = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
