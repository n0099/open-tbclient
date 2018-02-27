package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eSC = 0;
    private int eSD = 0;
    private int eSE = 0;
    private int fans = 0;
    private int chat = 0;
    private int eSF = 0;

    public int aNx() {
        return this.eSC;
    }

    public int aNy() {
        return this.eSD;
    }

    public int aNz() {
        return this.eSE;
    }

    public int aNA() {
        return this.fans;
    }

    public int aNB() {
        return this.eSF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eSC = jSONObject.optInt("agreeme", 0);
                this.eSD = jSONObject.optInt("replyme", 0);
                this.eSE = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eSF = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
