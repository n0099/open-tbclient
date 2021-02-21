package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OU;
    private String mAction;
    private JSONObject mParams;
    private String nzB;
    private String nzC;

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

    public JSONObject dOp() {
        return this.mParams;
    }

    public void eL(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dOq() {
        return this.nzB;
    }

    public void Tw(String str) {
        this.nzB = str;
    }

    public void Tx(String str) {
        this.nzC = str;
    }

    public String dOr() {
        return au.isEmpty(this.OU) ? this.mAction : this.OU + "/" + this.mAction;
    }
}
