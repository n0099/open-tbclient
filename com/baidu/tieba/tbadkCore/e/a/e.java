package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String Qt;
    private String mAction;
    private JSONObject mParams;
    private String nBG;
    private String nBH;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.Qt;
    }

    public void ca(String str) {
        this.Qt = str;
    }

    public JSONObject dOy() {
        return this.mParams;
    }

    public void eO(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dOz() {
        return this.nBG;
    }

    public void TD(String str) {
        this.nBG = str;
    }

    public void TE(String str) {
        this.nBH = str;
    }

    public String dOA() {
        return au.isEmpty(this.Qt) ? this.mAction : this.Qt + "/" + this.mAction;
    }
}
