package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private final String gGJ;
    private final int gGK;
    private final String gGL;
    private final String gGM;
    private final int gGN;
    private final String gGO;
    private final String gGP;
    private final String gGQ;
    private boolean gGR = false;
    private boolean gGS = false;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.gGJ = jSONObject.optString("bIconN");
        this.gGK = jSONObject.optInt("bIconType");
        this.gGL = jSONObject.optString("bSelIcon");
        this.gGM = jSONObject.optString("bSelIconN");
        this.gGN = jSONObject.optInt("bSelIconType");
        this.gGO = jSONObject.optString("clickAction");
        this.gGP = jSONObject.optString("preAction");
        this.gGQ = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.gGJ) && TextUtils.isEmpty(this.gGL) && TextUtils.isEmpty(this.gGM) && TextUtils.isEmpty(this.gGO) && TextUtils.isEmpty(this.gGP) && TextUtils.isEmpty(this.gGQ) && this.gGK == 0 && this.gGN == 0) ? false : true;
    }

    public String bzP() {
        return this.gGO;
    }

    public String bzQ() {
        return this.gGP;
    }

    public boolean bzR() {
        return this.gGR;
    }

    public void lX(boolean z) {
        this.gGR = z;
    }

    public boolean bzS() {
        return this.gGS;
    }

    public void lY(boolean z) {
        this.gGS = z;
    }

    public String bzT() {
        return this.gGQ;
    }

    public boolean bzU() {
        return bzW() > 0;
    }

    public String getImageUrl() {
        return this.gGR ? this.gGL : this.mIconUrl;
    }

    public String bzV() {
        return this.gGR ? this.gGM : this.gGJ;
    }

    public int bzW() {
        return uO(this.gGR ? this.gGN : this.gGK);
    }

    private static int uO(int i) {
        return f.hu(i);
    }
}
