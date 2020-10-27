package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class h {
    private int kpe = 0;
    private int kpf = 0;
    private int kpg = 0;
    private int fans = 0;
    private int chat = 0;
    private int kph = 0;

    public int cUh() {
        return this.kpe;
    }

    public int cUi() {
        return this.kpf;
    }

    public int cUj() {
        return this.kpg;
    }

    public int cUk() {
        return this.fans;
    }

    public int cUl() {
        return this.kph;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kpe = jSONObject.optInt("agree", 0);
                this.kpf = jSONObject.optInt("replyme", 0);
                this.kpg = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kph = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
