package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String OV;
    private String mAction;
    private JSONObject mParams;
    private String nom;
    private String non;

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

    public JSONObject dPR() {
        return this.mParams;
    }

    public void ew(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dPS() {
        return this.nom;
    }

    public void TL(String str) {
        this.nom = str;
    }

    public void TM(String str) {
        this.non = str;
    }

    public String dPT() {
        return au.isEmpty(this.OV) ? this.mAction : this.OV + "/" + this.mAction;
    }
}
