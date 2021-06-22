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
/* loaded from: classes6.dex */
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
                    if (this.f29166h) {
                        com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "lp_open_dpl", str);
                    }
                    n();
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b2);
                    if (this.f29166h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl");
                    }
                    if (this.f29166h) {
                        k.a().a(this.f29161c, this.f29162d, true);
                    }
                    return true;
                } catch (Exception unused) {
                    if (this.f29166h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29160b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && b(m(), d2)) {
            z = true;
            this.f29164f.set(true);
            if (!a(this.f29162d, "click_open", this.f29161c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f29161c, this.f29162d, ak.h(this.f29161c), null);
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.f29161c.ao() != null) {
            String a2 = this.f29161c.ao().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f29166h) {
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "lp_open_dpl", a(a2));
                }
                try {
                    Context m = m();
                    if (!(m instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    if (!a(this.f29162d, "open_url_app", this.f29161c)) {
                        com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29161c, this.f29162d, "open_url_app", null);
                    }
                    n();
                    m.startActivity(intent);
                    k.a().a(this.f29161c, this.f29162d, this.f29166h);
                    if (this.f29166h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "lp_deeplink_success_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "deeplink_success_realtime");
                    }
                    return true;
                } catch (Throwable unused) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "open_fallback_download");
                    if (this.f29166h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.f29163e.get() == 4 || this.f29163e.get() == 3) {
                return false;
            }
            if (!this.f29165g || this.f29164f.get()) {
                this.f29165g = true;
                if (a(this.f29162d, "open_fallback_url", this.f29161c)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29161c, this.f29162d, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
