package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private final String kTA;
    private boolean kTB = false;
    private boolean kTC = false;
    private final String kTt;
    private final int kTu;
    private final String kTv;
    private final String kTw;
    private final int kTx;
    private final String kTy;
    private final String kTz;
    private final String mIconUrl;

    public a(JSONObject jSONObject) {
        this.mIconUrl = jSONObject.optString("bIcon");
        this.kTt = jSONObject.optString("bIconN");
        this.kTu = jSONObject.optInt("bIconType");
        this.kTv = jSONObject.optString("bSelIcon");
        this.kTw = jSONObject.optString("bSelIconN");
        this.kTx = jSONObject.optInt("bSelIconType");
        this.kTy = jSONObject.optString("clickAction");
        this.kTz = jSONObject.optString("preAction");
        this.kTA = jSONObject.optString("statKey");
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mIconUrl) && TextUtils.isEmpty(this.kTt) && TextUtils.isEmpty(this.kTv) && TextUtils.isEmpty(this.kTw) && TextUtils.isEmpty(this.kTy) && TextUtils.isEmpty(this.kTz) && TextUtils.isEmpty(this.kTA) && this.kTu == 0 && this.kTx == 0) ? false : true;
    }

    public String cZC() {
        return this.kTy;
    }

    public String cZD() {
        return this.kTz;
    }

    public boolean cZE() {
        return this.kTB;
    }

    public void tt(boolean z) {
        this.kTB = z;
    }

    public boolean cZF() {
        return this.kTC;
    }

    public void tu(boolean z) {
        this.kTC = z;
    }

    public String cZG() {
        return this.kTA;
    }

    public boolean cZH() {
        return cZJ() > 0;
    }

    public String getImageUrl() {
        return this.kTB ? this.kTv : this.mIconUrl;
    }

    public String cZI() {
        return this.kTB ? this.kTw : this.kTt;
    }

    public int cZJ() {
        return DA(this.kTB ? this.kTx : this.kTu);
    }

    private static int DA(int i) {
        return f.ov(i);
    }
}
