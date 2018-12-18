package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int feA = 0;
    private int feB = 0;
    private int feC = 0;
    private int fans = 0;
    private int chat = 0;
    private int feD = 0;

    public int aVO() {
        return this.feA;
    }

    public int aVP() {
        return this.feB;
    }

    public int aVQ() {
        return this.feC;
    }

    public int aVR() {
        return this.fans;
    }

    public int aVS() {
        return this.feD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.feA = jSONObject.optInt("agree", 0);
                this.feB = jSONObject.optInt("replyme", 0);
                this.feC = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.feD = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
