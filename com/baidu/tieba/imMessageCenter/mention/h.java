package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    private int hJv = 0;
    private int hJw = 0;
    private int hJx = 0;
    private int fans = 0;
    private int chat = 0;
    private int hJy = 0;

    public int bWR() {
        return this.hJv;
    }

    public int bWS() {
        return this.hJw;
    }

    public int bWT() {
        return this.hJx;
    }

    public int bWU() {
        return this.fans;
    }

    public int bWV() {
        return this.hJy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hJv = jSONObject.optInt("agree", 0);
                this.hJw = jSONObject.optInt("replyme", 0);
                this.hJx = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.hJy = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
