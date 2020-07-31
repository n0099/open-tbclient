package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class h {
    private int jpZ = 0;
    private int jqa = 0;
    private int jqb = 0;
    private int fans = 0;
    private int chat = 0;
    private int jqc = 0;

    public int cyU() {
        return this.jpZ;
    }

    public int cyV() {
        return this.jqa;
    }

    public int cyW() {
        return this.jqb;
    }

    public int cyX() {
        return this.fans;
    }

    public int cyY() {
        return this.jqc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jpZ = jSONObject.optInt("agree", 0);
                this.jqa = jSONObject.optInt("replyme", 0);
                this.jqb = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jqc = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
