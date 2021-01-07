package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.at;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OY;
    private String mAction;
    private JSONObject mParams;
    private String ntW;
    private String ntX;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.OY;
    }

    public void bW(String str) {
        this.OY = str;
    }

    public JSONObject dPO() {
        return this.mParams;
    }

    public void eK(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dPP() {
        return this.ntW;
    }

    public void Tu(String str) {
        this.ntW = str;
    }

    public void Tv(String str) {
        this.ntX = str;
    }

    public String dPQ() {
        return at.isEmpty(this.OY) ? this.mAction : this.OY + "/" + this.mAction;
    }
}
