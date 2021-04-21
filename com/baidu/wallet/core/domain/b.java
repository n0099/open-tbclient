package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class b implements a {
    public static final String i = "https://www.baifubao.com";
    public static final String j = "https:/chong.baidu.com";
    public static final String k = "https://xinyongka.baidu.com";
    public static final String l = "https://zhifu.duxiaoman.com";
    public static final String m = "https://comet.baifubao.com";
    public static final String n = "http://wappass.baidu.com";
    public static final String o = "https://www.dxmpay.com";
    public static final String p = "https://www.dxmpay.com";
    public static final String q = "https://www.dxmpay.com";
    public static final String r = "https://www.dxmpay.com";
    public static final String s = "https://app.duxiaoman.com";
    public static final Pattern t = Pattern.compile("^https://.*\\.com");
    public String A;
    public String B;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        return !TextUtils.isEmpty(this.x) ? this.x : "https://www.baifubao.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        return !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        return !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        return !TextUtils.isEmpty(this.A) ? this.A : m;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        return !TextUtils.isEmpty(this.v) ? this.v : k;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        return z ? TextUtils.isEmpty(this.x) ? s : this.x : "https://www.baifubao.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        return !TextUtils.isEmpty(this.u) ? this.u : "https://www.baifubao.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        return !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        return !TextUtils.isEmpty(this.B) ? this.B : "https://www.baifubao.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        return !TextUtils.isEmpty(this.w) ? this.w : j;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        return !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        return !TextUtils.isEmpty(this.x) ? this.x : "https://www.baifubao.com";
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        return !TextUtils.isEmpty(this.z) ? this.z : l;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && t.matcher(optString).matches()) {
                this.u = optString;
            } else {
                this.u = "";
            }
            String optString2 = jSONObject.optString(a.f23940b);
            if (!TextUtils.isEmpty(optString2) && t.matcher(optString2).matches()) {
                this.v = optString2;
            } else {
                this.v = "";
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && t.matcher(optString3).matches()) {
                this.w = optString3;
            } else {
                this.w = "";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && t.matcher(optString4).matches()) {
                this.x = optString4;
                com.baidu.apollon.heartbeat.a.c().a(this.x);
            } else {
                this.x = "";
                com.baidu.apollon.heartbeat.a.c().a("https://www.baifubao.com");
            }
            String optString5 = jSONObject.optString(a.f23943e);
            if (!TextUtils.isEmpty(optString5) && t.matcher(optString5).matches()) {
                this.y = optString5;
            } else {
                this.y = "";
            }
            String optString6 = jSONObject.optString(a.f23944f);
            if (!TextUtils.isEmpty(optString6) && t.matcher(optString6).matches()) {
                this.z = optString6;
            } else {
                this.z = "";
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && t.matcher(optString7).matches()) {
                this.A = optString7;
            } else {
                this.A = "";
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && t.matcher(optString8).matches()) {
                this.B = optString8;
            } else {
                this.B = "";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
