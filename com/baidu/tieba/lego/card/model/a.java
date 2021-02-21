package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private final String lbK;
    private final int lbL;
    private final String lbM;
    private final String lbN;
    private final int lbO;
    private final String lbP;
    private final String lbQ;
    private final String lbR;
    private boolean lbS = false;
    private boolean lbT = false;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.lbK = jSONObject.optString("bIconN");
        this.lbL = jSONObject.optInt("bIconType");
        this.lbM = jSONObject.optString("bSelIcon");
        this.lbN = jSONObject.optString("bSelIconN");
        this.lbO = jSONObject.optInt("bSelIconType");
        this.lbP = jSONObject.optString("clickAction");
        this.lbQ = jSONObject.optString("preAction");
        this.lbR = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.lbK) && TextUtils.isEmpty(this.lbM) && TextUtils.isEmpty(this.lbN) && TextUtils.isEmpty(this.lbP) && TextUtils.isEmpty(this.lbQ) && TextUtils.isEmpty(this.lbR) && this.lbL == 0 && this.lbO == 0) ? false : true;
    }

    public String dbH() {
        return this.lbP;
    }

    public String dbI() {
        return this.lbQ;
    }

    public boolean dbJ() {
        return this.lbS;
    }

    public void tG(boolean z) {
        this.lbS = z;
    }

    public boolean dbK() {
        return this.lbT;
    }

    public void tH(boolean z) {
        this.lbT = z;
    }

    public String dbL() {
        return this.lbR;
    }

    public boolean dbM() {
        return dbO() > 0;
    }

    public String getImageUrl() {
        return this.lbS ? this.lbM : this.mIconUrl;
    }

    public String dbN() {
        return this.lbS ? this.lbN : this.lbK;
    }

    public int dbO() {
        return DS(this.lbS ? this.lbO : this.lbL);
    }

    private static int DS(int i) {
        return f.oA(i);
    }
}
