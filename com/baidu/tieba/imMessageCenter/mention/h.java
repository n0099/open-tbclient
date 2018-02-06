package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eSO = 0;
    private int eSP = 0;
    private int eSQ = 0;
    private int fans = 0;
    private int chat = 0;
    private int eSR = 0;

    public int aNy() {
        return this.eSO;
    }

    public int aNz() {
        return this.eSP;
    }

    public int aNA() {
        return this.eSQ;
    }

    public int aNB() {
        return this.fans;
    }

    public int aNC() {
        return this.eSR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eSO = jSONObject.optInt("agreeme", 0);
                this.eSP = jSONObject.optInt("replyme", 0);
                this.eSQ = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eSR = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
