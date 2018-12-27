package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int fhr = 0;
    private int fhs = 0;
    private int fht = 0;
    private int fans = 0;
    private int chat = 0;
    private int fhu = 0;

    public int aWC() {
        return this.fhr;
    }

    public int aWD() {
        return this.fhs;
    }

    public int aWE() {
        return this.fht;
    }

    public int aWF() {
        return this.fans;
    }

    public int aWG() {
        return this.fhu;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fhr = jSONObject.optInt("agree", 0);
                this.fhs = jSONObject.optInt("replyme", 0);
                this.fht = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.fhu = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
