package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.tbadk.core.util.au;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String Oa;
    private String mAction;
    private JSONObject mParams;
    private String nak;
    private String nal;

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public String getModule() {
        return this.Oa;
    }

    public void ca(String str) {
        this.Oa = str;
    }

    public JSONObject dKy() {
        return this.mParams;
    }

    public void eu(JSONObject jSONObject) {
        this.mParams = jSONObject;
    }

    public String dKz() {
        return this.nak;
    }

    public void Sw(String str) {
        this.nak = str;
    }

    public void Sx(String str) {
        this.nal = str;
    }

    public String dKA() {
        return au.isEmpty(this.Oa) ? this.mAction : this.Oa + "/" + this.mAction;
    }
}
