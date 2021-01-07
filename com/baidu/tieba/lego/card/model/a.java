package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private final String kXY;
    private final int kXZ;
    private final String kYa;
    private final String kYb;
    private final int kYc;
    private final String kYd;
    private final String kYe;
    private final String kYf;
    private boolean kYg = false;
    private boolean kYh = false;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.kXY = jSONObject.optString("bIconN");
        this.kXZ = jSONObject.optInt("bIconType");
        this.kYa = jSONObject.optString("bSelIcon");
        this.kYb = jSONObject.optString("bSelIconN");
        this.kYc = jSONObject.optInt("bSelIconType");
        this.kYd = jSONObject.optString("clickAction");
        this.kYe = jSONObject.optString("preAction");
        this.kYf = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.kXY) && TextUtils.isEmpty(this.kYa) && TextUtils.isEmpty(this.kYb) && TextUtils.isEmpty(this.kYd) && TextUtils.isEmpty(this.kYe) && TextUtils.isEmpty(this.kYf) && this.kXZ == 0 && this.kYc == 0) ? false : true;
    }

    public String ddu() {
        return this.kYd;
    }

    public String ddv() {
        return this.kYe;
    }

    public boolean ddw() {
        return this.kYg;
    }

    public void tx(boolean z) {
        this.kYg = z;
    }

    public boolean ddx() {
        return this.kYh;
    }

    public void ty(boolean z) {
        this.kYh = z;
    }

    public String ddy() {
        return this.kYf;
    }

    public boolean ddz() {
        return ddB() > 0;
    }

    public String getImageUrl() {
        return this.kYg ? this.kYa : this.mIconUrl;
    }

    public String ddA() {
        return this.kYg ? this.kYb : this.kXY;
    }

    public int ddB() {
        return Fg(this.kYg ? this.kYc : this.kXZ);
    }

    private static int Fg(int i) {
        return f.qc(i);
    }
}
