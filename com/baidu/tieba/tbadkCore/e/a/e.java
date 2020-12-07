package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OV;
    private String mAction;
    private JSONObject mParams;
    private String nok;
    private String nol;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.OV;
    }

    public void cd(String str) {
        this.OV = str;
    }

    public JSONObject dPQ() {
        return this.mParams;
    }

    public void ew(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dPR() {
        return this.nok;
    }

    public void TL(String str) {
        this.nok = str;
    }

    public void TM(String str) {
        this.nol = str;
    }

    public String dPS() {
        return au.isEmpty(this.OV) ? this.mAction : this.OV + "/" + this.mAction;
    }
}
