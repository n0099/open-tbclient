package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private final String gGK;
    private final int gGL;
    private final String gGM;
    private final String gGN;
    private final int gGO;
    private final String gGP;
    private final String gGQ;
    private final String gGR;
    private boolean gGS = false;
    private boolean gGT = false;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.gGK = jSONObject.optString("bIconN");
        this.gGL = jSONObject.optInt("bIconType");
        this.gGM = jSONObject.optString("bSelIcon");
        this.gGN = jSONObject.optString("bSelIconN");
        this.gGO = jSONObject.optInt("bSelIconType");
        this.gGP = jSONObject.optString("clickAction");
        this.gGQ = jSONObject.optString("preAction");
        this.gGR = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.gGK) && TextUtils.isEmpty(this.gGM) && TextUtils.isEmpty(this.gGN) && TextUtils.isEmpty(this.gGP) && TextUtils.isEmpty(this.gGQ) && TextUtils.isEmpty(this.gGR) && this.gGL == 0 && this.gGO == 0) ? false : true;
    }

    public String bzQ() {
        return this.gGP;
    }

    public String bzR() {
        return this.gGQ;
    }

    public boolean bzS() {
        return this.gGS;
    }

    public void lX(boolean z) {
        this.gGS = z;
    }

    public boolean bzT() {
        return this.gGT;
    }

    public void lY(boolean z) {
        this.gGT = z;
    }

    public String bzU() {
        return this.gGR;
    }

    public boolean bzV() {
        return bzX() > 0;
    }

    public String getImageUrl() {
        return this.gGS ? this.gGM : this.mIconUrl;
    }

    public String bzW() {
        return this.gGS ? this.gGN : this.gGK;
    }

    public int bzX() {
        return uO(this.gGS ? this.gGO : this.gGL);
    }

    private static int uO(int i) {
        return f.hu(i);
    }
}
