package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes5.dex */
public class b extends d {
    public b(Context context, l lVar, String str) {
        super(context, lVar, str);
    }

    private boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Intent b2 = ak.b(context, str);
                    if (b2 == null) {
                        return false;
                    }
                    if (this.f29807h) {
                        com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29802c, this.f29803d, "lp_open_dpl", str);
                    }
                    n();
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b2);
                    if (this.f29807h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29802c, this.f29803d, "lp_openurl");
                    }
                    if (this.f29807h) {
                        k.a().a(this.f29802c, this.f29803d, true);
                    }
                    return true;
                } catch (Exception unused) {
                    if (this.f29807h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29802c, this.f29803d, "lp_openurl_failed");
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29801b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && b(m(), d2)) {
            z = true;
            this.f29805f.set(true);
            if (!a(this.f29803d, "click_open", this.f29802c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f29802c, this.f29803d, ak.h(this.f29802c), null);
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.f29802c.ao() != null) {
            String a2 = this.f29802c.ao().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f29807h) {
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29802c, this.f29803d, "lp_open_dpl", a(a2));
                }
                try {
                    Context m = m();
                    if (!(m instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    if (!a(this.f29803d, "open_url_app", this.f29802c)) {
                        com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29802c, this.f29803d, "open_url_app", null);
                    }
                    n();
                    m.startActivity(intent);
                    k.a().a(this.f29802c, this.f29803d, this.f29807h);
                    if (this.f29807h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29802c, this.f29803d, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29802c, this.f29803d, "lp_deeplink_success_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29802c, this.f29803d, "deeplink_success_realtime");
                    }
                    return true;
                } catch (Throwable unused) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29802c, this.f29803d, "open_fallback_download");
                    if (this.f29807h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29802c, this.f29803d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29802c, this.f29803d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29802c, this.f29803d, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.f29804e.get() == 4 || this.f29804e.get() == 3) {
                return false;
            }
            if (!this.f29806g || this.f29805f.get()) {
                this.f29806g = true;
                if (a(this.f29803d, "open_fallback_url", this.f29802c)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29802c, this.f29803d, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
