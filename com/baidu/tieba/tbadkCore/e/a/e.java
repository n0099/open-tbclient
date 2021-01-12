package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.at;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OW;
    private String mAction;
    private JSONObject mParams;
    private String npr;
    private String nps;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.OW;
    }

    public void bW(String str) {
        this.OW = str;
    }

    public JSONObject dLW() {
        return this.mParams;
    }

    public void eK(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dLX() {
        return this.npr;
    }

    public void Sm(String str) {
        this.npr = str;
    }

    public void Sn(String str) {
        this.nps = str;
    }

    public String dLY() {
        return at.isEmpty(this.OW) ? this.mAction : this.OW + "/" + this.mAction;
    }
}
