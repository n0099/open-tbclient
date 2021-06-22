package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class c implements a {
    public static final Pattern H = Pattern.compile("^https://.*\\.com");
    public static c I = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f24053i = "life_host";
    public static final String j = "my_host";
    public static final String k = "credit_card_host";
    public static final String l = "app_host";
    public static final String m = "nfc_host";
    public static final String n = "app_pay_host";
    public static final String o = "m_host";
    public static final String p = "co_host";
    public static final String q = "qianbao_host";
    public static final String r = "zhifuhost";
    public static final String s = "comet_host";
    public static final String t = "wallet_web_cache_host";
    public static final String u = "https://www.baifubao.com";
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String v = "https://www.baifubao.com";
    public String w = "https://www.baifubao.com";
    public String x = b.k;
    public String y = "https://www.baifubao.com";
    public String z = "https://chong.baidu.com";
    public String A = "https://www.dxmpay.com";
    public String B = b.m;
    public String C = "https://www.dxmpay.com";
    public String D = "https://www.dxmpay.com";
    public String E = "https://www.dxmpay.com";
    public String F = "https://cp01-ocean-1481.epc.baidu.com:8443";
    public String G = b.l;

    public static c a() {
        if (I == null) {
            I = new c();
        }
        return I;
    }

    public void b(String str) {
        this.K = str;
    }

    public void c(String str) {
        this.L = str;
    }

    public void d(String str) {
        this.M = str;
    }

    public void e(String str) {
        this.N = str;
    }

    public void f(String str) {
        this.O = str;
    }

    public void g(String str) {
        this.P = str;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        if (!TextUtils.isEmpty(this.M)) {
            return this.M;
        }
        return this.y;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        if (!TextUtils.isEmpty(this.O)) {
            return this.O;
        }
        return this.A;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        if (!TextUtils.isEmpty(this.Q)) {
            return this.Q;
        }
        return this.E;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        if (!TextUtils.isEmpty(this.T)) {
            return this.T;
        }
        return this.B;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        if (!TextUtils.isEmpty(this.L)) {
            return this.L;
        }
        return this.x;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        if (TextUtils.isEmpty(this.M)) {
            return z ? this.y : "https://www.baifubao.com";
        }
        return this.M;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        if (!TextUtils.isEmpty(this.J)) {
            return this.J;
        }
        return this.v;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        if (!TextUtils.isEmpty(this.P)) {
            return this.P;
        }
        return this.C;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        if (!TextUtils.isEmpty(this.K)) {
            return this.K;
        }
        return this.w;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        if (!TextUtils.isEmpty(this.N)) {
            return this.N;
        }
        return this.z;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        if (!TextUtils.isEmpty(this.R)) {
            return this.R;
        }
        return this.D;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        if (!TextUtils.isEmpty(this.U)) {
            return this.U;
        }
        return this.F;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        if (!TextUtils.isEmpty(this.S)) {
            return this.S;
        }
        return this.G;
    }

    public void h(String str) {
        this.Q = str;
    }

    public void i(String str) {
        this.R = str;
    }

    public void j(String str) {
        this.S = str;
    }

    public void k(String str) {
        this.T = str;
    }

    public void l(String str) {
        this.U = str;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && H.matcher(optString).matches()) {
                this.v = optString;
            } else {
                this.v = "https://www.baifubao.com";
            }
            String optString2 = jSONObject.optString(a.f24045b);
            if (!TextUtils.isEmpty(optString2) && H.matcher(optString2).matches()) {
                this.x = optString2;
            } else {
                this.x = b.k;
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && H.matcher(optString3).matches()) {
                this.z = optString3;
            } else {
                this.z = "https://chong.baidu.com";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && H.matcher(optString4).matches()) {
                this.y = optString4;
                com.baidu.apollon.heartbeat.a.c().a(this.M);
            } else {
                this.y = "https://www.baifubao.com";
                com.baidu.apollon.heartbeat.a.c().a(this.y);
            }
            String optString5 = jSONObject.optString(a.f24048e);
            if (!TextUtils.isEmpty(optString5) && H.matcher(optString5).matches()) {
                this.A = optString5;
                this.C = optString5;
                this.E = optString5;
                this.D = optString5;
            } else {
                this.A = "https://www.baifubao.com";
                this.C = "https://m.baifubao.com";
                this.E = "https://co.baifubao.com";
                this.D = "https://qianbao.baidu.com";
            }
            String optString6 = jSONObject.optString(a.f24049f);
            if (!TextUtils.isEmpty(optString6) && H.matcher(optString6).matches()) {
                this.G = optString6;
            } else {
                this.G = WapPayActivity.HOST;
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && H.matcher(optString7).matches()) {
                this.B = optString7;
            } else {
                this.B = b.m;
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && H.matcher(optString8).matches()) {
                this.w = optString8;
            } else {
                this.w = "https://www.baifubao.com";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        this.J = str;
    }
}
