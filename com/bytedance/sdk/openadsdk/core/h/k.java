package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.q;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ae;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private String f6596a;

    /* renamed from: b  reason: collision with root package name */
    private c f6597b;

    @Override // com.bytedance.sdk.openadsdk.core.h.e
    public void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.f6596a = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_dns_settings", "dnsinfo", "");
            c();
            return;
        }
        this.f6596a = e().b("dnsinfo", "");
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.h.e
    public void a(@NonNull JSONObject jSONObject) {
        this.f6597b = c.a(jSONObject);
        if (this.f6597b != null) {
            this.f6596a = this.f6597b.c().toString();
        }
        d();
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f6596a)) {
            try {
                this.f6597b = c.a(new JSONObject(this.f6596a));
            } catch (Exception e) {
            }
        }
    }

    private void d() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (!TextUtils.isEmpty(this.f6596a)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_dns_settings", "dnsinfo", this.f6596a);
                return;
            }
            return;
        }
        ae e = e();
        if (!TextUtils.isEmpty(this.f6596a)) {
            e.a("dnsinfo", this.f6596a);
        }
    }

    private ae e() {
        return ae.a("tt_dns_settings", p.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            d dVar = null;
            if (this.f6597b != null && this.f6597b.f6581b != null) {
                dVar = this.f6597b.f6581b.get(str);
            }
            if (dVar == null) {
                if (str.equals("is.snssdk.com")) {
                    h.a(this).a();
                }
            } else if (dVar.d()) {
                h.a(this).a();
            } else {
                str = dVar.e();
                if (TextUtils.isEmpty(str)) {
                    h.a(this).a();
                } else {
                    a(dVar, System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
        return str;
    }

    private void a(d dVar, long j) {
        if (dVar != null && !dVar.g() && !TextUtils.isEmpty(dVar.a())) {
            dVar.a(true);
            com.bytedance.sdk.openadsdk.h.a.a aVar = new com.bytedance.sdk.openadsdk.h.a.a();
            aVar.a("dns_resolution_time");
            aVar.a("dns_host", dVar.a());
            aVar.a("dns_duration", Long.valueOf(j));
            com.bytedance.sdk.openadsdk.h.a.a().a(aVar);
        }
    }

    public void b() {
        com.bytedance.sdk.openadsdk.i.e.a(p.a()).a(new q() { // from class: com.bytedance.sdk.openadsdk.core.h.k.1
            @Override // com.bytedance.sdk.adnet.core.q
            public String a(String str) {
                return k.this.a(str);
            }
        });
    }
}
