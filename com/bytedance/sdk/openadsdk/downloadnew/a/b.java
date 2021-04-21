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
                    if (this.f28918h) {
                        com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "lp_open_dpl", str);
                    }
                    n();
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b2);
                    if (this.f28918h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl");
                    }
                    if (this.f28918h) {
                        k.a().a(this.f28913c, this.f28914d, true);
                    }
                    return true;
                } catch (Exception unused) {
                    if (this.f28918h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f28912b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && b(m(), d2)) {
            z = true;
            this.f28916f.set(true);
            if (!a(this.f28914d, "click_open", this.f28913c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f28913c, this.f28914d, ak.h(this.f28913c), null);
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        if (this.f28913c.ao() != null) {
            String a2 = this.f28913c.ao().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f28918h) {
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "lp_open_dpl", a(a2));
                }
                try {
                    Context m = m();
                    if (!(m instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    if (!a(this.f28914d, "open_url_app", this.f28913c)) {
                        com.bytedance.sdk.openadsdk.c.d.i(m(), this.f28913c, this.f28914d, "open_url_app", null);
                    }
                    n();
                    m.startActivity(intent);
                    k.a().a(this.f28913c, this.f28914d, this.f28918h);
                    if (this.f28918h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "lp_deeplink_success_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "deeplink_success_realtime");
                    }
                    return true;
                } catch (Throwable unused) {
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "open_fallback_download");
                    if (this.f28918h) {
                        com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.f28915e.get() == 4 || this.f28915e.get() == 3) {
                return false;
            }
            if (!this.f28917g || this.f28916f.get()) {
                this.f28917g = true;
                if (a(this.f28914d, "open_fallback_url", this.f28913c)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.c.d.i(m(), this.f28913c, this.f28914d, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
