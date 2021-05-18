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
                    if (this.f29052h) {
                        com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29047c, this.f29048d, "lp_open_dpl", str);
                    }
                    n();
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b2);
                    if (this.f29052h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29047c, this.f29048d, "lp_openurl");
                    }
                    if (this.f29052h) {
                        k.a().a(this.f29047c, this.f29048d, true);
                    }
                    return true;
                } catch (Exception unused) {
                    if (this.f29052h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29047c, this.f29048d, "lp_openurl_failed");
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29046b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && b(m(), d2)) {
            z = true;
            this.f29050f.set(true);
            if (!a(this.f29048d, "click_open", this.f29047c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f29047c, this.f29048d, ak.h(this.f29047c), null);
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.f29047c.ao() != null) {
            String a2 = this.f29047c.ao().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f29052h) {
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29047c, this.f29048d, "lp_open_dpl", a(a2));
                }
                try {
                    Context m = m();
                    if (!(m instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    if (!a(this.f29048d, "open_url_app", this.f29047c)) {
                        com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29047c, this.f29048d, "open_url_app", null);
                    }
                    n();
                    m.startActivity(intent);
                    k.a().a(this.f29047c, this.f29048d, this.f29052h);
                    if (this.f29052h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29047c, this.f29048d, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29047c, this.f29048d, "lp_deeplink_success_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29047c, this.f29048d, "deeplink_success_realtime");
                    }
                    return true;
                } catch (Throwable unused) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29047c, this.f29048d, "open_fallback_download");
                    if (this.f29052h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29047c, this.f29048d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29047c, this.f29048d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29047c, this.f29048d, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.f29049e.get() == 4 || this.f29049e.get() == 3) {
                return false;
            }
            if (!this.f29051g || this.f29050f.get()) {
                this.f29051g = true;
                if (a(this.f29048d, "open_fallback_url", this.f29047c)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29047c, this.f29048d, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
