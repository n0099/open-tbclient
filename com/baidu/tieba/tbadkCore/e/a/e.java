package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.at;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OY;
    private String mAction;
    private JSONObject mParams;
    private String ntX;
    private String ntY;

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

    public JSONObject dPN() {
        return this.mParams;
    }

    public void eK(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dPO() {
        return this.ntX;
    }

    public void Tv(String str) {
        this.ntX = str;
    }

    public void Tw(String str) {
        this.ntY = str;
    }

    public String dPP() {
        return at.isEmpty(this.OY) ? this.mAction : this.OY + "/" + this.mAction;
    }
}
