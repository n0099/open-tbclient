package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eSR = 0;
    private int eSS = 0;
    private int eST = 0;
    private int fans = 0;
    private int chat = 0;
    private int eSU = 0;

    public int aNy() {
        return this.eSR;
    }

    public int aNz() {
        return this.eSS;
    }

    public int aNA() {
        return this.eST;
    }

    public int aNB() {
        return this.fans;
    }

    public int aNC() {
        return this.eSU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eSR = jSONObject.optInt("agreeme", 0);
                this.eSS = jSONObject.optInt("replyme", 0);
                this.eST = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eSU = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
