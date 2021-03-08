package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
/* loaded from: classes6.dex */
public class b extends d {
    public b(Context context, l lVar, String str) {
        super(context, lVar, str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.c.ai() != null) {
            String a2 = this.c.ai().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.h) {
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", a(a2));
                }
                try {
                    Context m = m();
                    if (!(m instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    if (!a(this.d, "open_url_app", this.c)) {
                        com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_url_app", null);
                    }
                    n();
                    m.startActivity(intent);
                    k.a().a(this.c, this.d, this.h);
                    if (this.h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_success_realtime");
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_success_realtime");
                    return true;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "open_fallback_download");
                    if (this.h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.e.get() != 4 && this.e.get() != 3 && (!this.g || this.f.get())) {
                this.g = true;
                if (!a(this.d, "open_fallback_url", this.c)) {
                    com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        if (this.b == null) {
            return false;
        }
        String d = this.b.d();
        if (TextUtils.isEmpty(d) || !b(m(), d)) {
            return false;
        }
        this.f.set(true);
        if (!a(this.d, "click_open", this.c)) {
            com.bytedance.sdk.openadsdk.c.d.j(m(), this.c, this.d, aj.h(this.c), null);
        }
        return true;
    }

    private boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Intent b = aj.b(context, str);
                if (b != null) {
                    if (this.h) {
                        com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", str);
                    }
                    n();
                    b.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b);
                    if (this.h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                    }
                    if (this.h) {
                        k.a().a(this.c, this.d, true);
                    }
                    return true;
                }
                return false;
            } catch (Exception e) {
                if (this.h) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
