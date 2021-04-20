package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f28661a = new Object();

    public static void a() {
        b.a();
        d.a();
    }

    public static void b() {
        try {
            f.d();
            File e2 = b.e();
            if (e2 != null && e2.exists()) {
                if (e2.getParentFile() != null) {
                    l.c(e2.getParentFile());
                } else {
                    l.c(e2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        return c.c();
    }

    public static t d(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.T() == null) {
            return null;
        }
        t a2 = d.a().a(lVar.T().b());
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
        }
        return a2;
    }

    public static boolean e() {
        return b.a().b();
    }

    public static t c(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.S() == null) {
            return null;
        }
        t a2 = d.a().a(lVar.S().b());
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
        }
        return a2;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        d.a().a(lVar);
    }

    public static t a(String str) {
        return d.a().a(str);
    }

    public static void a(final t tVar) {
        com.bytedance.sdk.openadsdk.l.e.a(new g("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.f28661a) {
                    c.a().a(tVar);
                }
            }
        }, 10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        if (r2.b().equals(r4) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WebResourceResponse a(String str, e.a aVar) {
        File file;
        if (e()) {
            Iterator<s.a> it = d().e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                s.a next = it.next();
                if (next.a() != null && next.a().equals(str)) {
                    file = new File(b.e(), j.a(next.a()));
                    String a2 = j.a(file);
                    if (next.b() != null) {
                    }
                }
            }
        }
        file = null;
        if (file != null) {
            try {
                return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(file));
            } catch (Throwable th) {
                u.c("TTDynamic", "get html WebResourceResponse error", th);
                return null;
            }
        }
        return null;
    }

    public static s d() {
        return b.a().c();
    }

    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        d.a().b(lVar);
    }

    public static Set<String> b(String str) {
        return d.a().b(str);
    }
}
