package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private final String ldN;
    private final int ldO;
    private final String ldP;
    private final String ldQ;
    private final int ldR;
    private final String ldS;
    private final String ldT;
    private final String ldU;
    private boolean ldV = false;
    private boolean ldW = false;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.ldN = jSONObject.optString("bIconN");
        this.ldO = jSONObject.optInt("bIconType");
        this.ldP = jSONObject.optString("bSelIcon");
        this.ldQ = jSONObject.optString("bSelIconN");
        this.ldR = jSONObject.optInt("bSelIconType");
        this.ldS = jSONObject.optString("clickAction");
        this.ldT = jSONObject.optString("preAction");
        this.ldU = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.ldN) && TextUtils.isEmpty(this.ldP) && TextUtils.isEmpty(this.ldQ) && TextUtils.isEmpty(this.ldS) && TextUtils.isEmpty(this.ldT) && TextUtils.isEmpty(this.ldU) && this.ldO == 0 && this.ldR == 0) ? false : true;
    }

    public String dbQ() {
        return this.ldS;
    }

    public String dbR() {
        return this.ldT;
    }

    public boolean dbS() {
        return this.ldV;
    }

    public void tG(boolean z) {
        this.ldV = z;
    }

    public boolean dbT() {
        return this.ldW;
    }

    public void tH(boolean z) {
        this.ldW = z;
    }

    public String dbU() {
        return this.ldU;
    }

    public boolean dbV() {
        return dbX() > 0;
    }

    public String getImageUrl() {
        return this.ldV ? this.ldP : this.mIconUrl;
    }

    public String dbW() {
        return this.ldV ? this.ldQ : this.ldN;
    }

    public int dbX() {
        return DV(this.ldV ? this.ldR : this.ldO);
    }

    private static int DV(int i) {
        return f.oB(i);
    }
}
