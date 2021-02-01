package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private final int lbA;
    private final String lbB;
    private final String lbC;
    private final String lbD;
    private boolean lbE = false;
    private boolean lbF = false;
    private final String lbw;
    private final int lbx;
    private final String lby;
    private final String lbz;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.lbw = jSONObject.optString("bIconN");
        this.lbx = jSONObject.optInt("bIconType");
        this.lby = jSONObject.optString("bSelIcon");
        this.lbz = jSONObject.optString("bSelIconN");
        this.lbA = jSONObject.optInt("bSelIconType");
        this.lbB = jSONObject.optString("clickAction");
        this.lbC = jSONObject.optString("preAction");
        this.lbD = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.lbw) && TextUtils.isEmpty(this.lby) && TextUtils.isEmpty(this.lbz) && TextUtils.isEmpty(this.lbB) && TextUtils.isEmpty(this.lbC) && TextUtils.isEmpty(this.lbD) && this.lbx == 0 && this.lbA == 0) ? false : true;
    }

    public String dbA() {
        return this.lbB;
    }

    public String dbB() {
        return this.lbC;
    }

    public boolean dbC() {
        return this.lbE;
    }

    public void tG(boolean z) {
        this.lbE = z;
    }

    public boolean dbD() {
        return this.lbF;
    }

    public void tH(boolean z) {
        this.lbF = z;
    }

    public String dbE() {
        return this.lbD;
    }

    public boolean dbF() {
        return dbH() > 0;
    }

    public String getImageUrl() {
        return this.lbE ? this.lby : this.mIconUrl;
    }

    public String dbG() {
        return this.lbE ? this.lbz : this.lbw;
    }

    public int dbH() {
        return DS(this.lbE ? this.lbA : this.lbx);
    }

    private static int DS(int i) {
        return f.oA(i);
    }
}
