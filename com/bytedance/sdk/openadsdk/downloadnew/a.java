package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.downloadnew.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import d.o.a.d.f.a.a;
/* loaded from: classes6.dex */
public class a {
    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, l lVar, String str) {
        if (ak.c(context)) {
            return new d(context, lVar, str);
        }
        return new b(context, lVar, str);
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.b b(Context context, l lVar, String str) {
        if (ak.c(context)) {
            return new c(context, lVar, str);
        }
        return new com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, str);
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, String str, l lVar, String str2) {
        return new e(context, str, lVar, str2);
    }

    public static boolean a(Activity activity, final ExitInstallListener exitInstallListener) {
        return d.o.a.d.f.a.a.a().h(activity, false, new a.b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.1
            @Override // d.o.a.d.f.a.a.b
            public void a() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }

    @NonNull
    public static String a() {
        try {
            return g.d().o();
        } catch (Exception e2) {
            u.a("TTDownloadFactory", "get download sdk version error", e2);
            return "0.0.0";
        }
    }
}
