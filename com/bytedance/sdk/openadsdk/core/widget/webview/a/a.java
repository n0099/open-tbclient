package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
/* loaded from: classes6.dex */
public class a {
    public static void a() {
        b.a();
        d.a();
    }

    public static void b() {
        try {
            f.d();
            File e = b.e();
            if (e != null && e.exists()) {
                if (e.getParentFile() != null) {
                    l.c(e.getParentFile());
                } else {
                    l.c(e);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        d.a().a(lVar);
    }

    public static String c() {
        return c.c();
    }

    public static q a(String str) {
        return d.a().a(str);
    }

    public static Set<String> b(String str) {
        return d.a().b(str);
    }

    public static q b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.B() == null) {
            return null;
        }
        q a2 = d.a().a(lVar.B().b());
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
            return a2;
        }
        return a2;
    }

    private static void a(final q qVar) {
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                c.a().a(q.this);
            }
        }, 10);
    }

    public static p d() {
        return b.a().c();
    }

    public static boolean e() {
        return b.a().b();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WebResourceResponse a(String str, e.a aVar) {
        File file;
        if (e()) {
            for (p.a aVar2 : d().d()) {
                if (aVar2.a() != null && aVar2.a().equals(str)) {
                    file = new File(b.e(), j.a(aVar2.a()));
                    String a2 = j.a(file);
                    if (aVar2.b() == null || !aVar2.b().equals(a2)) {
                        file = null;
                    }
                    if (file != null) {
                        try {
                            return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(file));
                        } catch (Throwable th) {
                            u.c("TTDynamic", "get html WebResourceResponse error", th);
                        }
                    }
                    return null;
                }
            }
        }
        file = null;
        if (file != null) {
        }
        return null;
    }
}
