package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OU;
    private String mAction;
    private JSONObject mParams;
    private String nzb;
    private String nzc;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.OU;
    }

    public void bW(String str) {
        this.OU = str;
    }

    public JSONObject dOh() {
        return this.mParams;
    }

    public void eL(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dOi() {
        return this.nzb;
    }

    public void Tk(String str) {
        this.nzb = str;
    }

    public void Tl(String str) {
        this.nzc = str;
    }

    public String dOj() {
        return au.isEmpty(this.OU) ? this.mAction : this.OU + "/" + this.mAction;
    }
}
