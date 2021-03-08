package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static File f4629a;
    private static volatile b b;
    private AtomicBoolean c = new AtomicBoolean(true);
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private AtomicInteger f = new AtomicInteger(0);
    private AtomicLong g = new AtomicLong();

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private b() {
        f();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.j.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                f.a();
                b.this.c.set(false);
                b.this.g();
                b.this.d();
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        boolean z;
        u.b("TemplateManager", "check template usable1");
        q b2 = f.b();
        if (b2 == null || !b2.f()) {
            u.b("TemplateManager", "check template usable2");
            return;
        }
        for (q.a aVar : b2.e()) {
            String a2 = aVar.a();
            File file = new File(e(), j.a(a2));
            String a3 = j.a(file);
            if (!file.exists() || !file.isFile() || aVar.b() == null || !aVar.b().equals(a3)) {
                z = false;
                u.b("TemplateManager", "check template usable3: " + a2 + "," + file.getAbsolutePath());
                break;
            }
            while (r2.hasNext()) {
            }
        }
        z = true;
        if (!z) {
            f.d();
        }
        u.b("TemplateManager", "check template usable4: " + z);
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public q c() {
        return f.b();
    }

    public void d() {
        a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca A[Catch: Throwable -> 0x003c, TRY_LEAVE, TryCatch #0 {Throwable -> 0x003c, blocks: (B:6:0x0012, B:9:0x001c, B:10:0x0021, B:14:0x0047, B:16:0x005b, B:19:0x0076, B:21:0x0080, B:22:0x009a, B:24:0x00a6, B:42:0x0148, B:44:0x0152, B:27:0x00c0, B:28:0x00c4, B:30:0x00ca, B:33:0x0103, B:36:0x010c, B:39:0x012e, B:41:0x0134, B:67:0x01d9, B:68:0x01dd, B:70:0x01e3, B:73:0x021c, B:79:0x0228, B:45:0x0164, B:46:0x016c, B:48:0x0172, B:50:0x0182, B:51:0x0186, B:53:0x0190, B:55:0x0196, B:57:0x01a4, B:58:0x01a8, B:59:0x01b0, B:61:0x01b6, B:63:0x01c6, B:64:0x01ca, B:26:0x00b0, B:18:0x0061), top: B:87:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        o oVar;
        if (this.c.get()) {
            u.b("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.d.get()) {
                if (z) {
                    this.f.getAndIncrement();
                }
                u.b("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            this.d.set(true);
            q a2 = p.f().a();
            q b2 = f.b();
            if (a2 == null || !a2.f()) {
                this.d.set(false);
                a(109);
                u.b("TemplateManager", "loadTemplate error3");
            } else if (!f.b(a2.b())) {
                this.d.set(false);
                this.g.set(System.currentTimeMillis());
                u.b("TemplateManager", "loadTemplate error4");
            } else {
                ArrayList<q.a> arrayList = new ArrayList();
                ArrayList<q.a> arrayList2 = new ArrayList();
                if (b2 == null || b2.e().isEmpty()) {
                    arrayList2.addAll(a2.e());
                    u.b("TemplateManager", "loadTemplate update1");
                } else if (a2.e().isEmpty()) {
                    arrayList.addAll(b2.e());
                    u.b("TemplateManager", "loadTemplate update2");
                } else {
                    for (q.a aVar : a2.e()) {
                        if (!b2.e().contains(aVar)) {
                            arrayList2.add(aVar);
                        } else {
                            q.a a3 = f.a(aVar.a());
                            if (a3 != null && aVar.b() != null && !aVar.b().equals(a3.b())) {
                                arrayList2.add(aVar);
                            }
                        }
                    }
                    for (q.a aVar2 : b2.e()) {
                        if (!a2.e().contains(aVar2)) {
                            arrayList.add(aVar2);
                        }
                    }
                    u.b("TemplateManager", "loadTemplate update3");
                }
                for (q.a aVar3 : arrayList2) {
                    String a4 = aVar3.a();
                    File file = new File(e(), j.a(a4));
                    File file2 = new File(file + ".tmp");
                    if (file.exists()) {
                        try {
                            file.delete();
                        } catch (Throwable th) {
                        }
                    }
                    if (file2.exists()) {
                        try {
                            file2.delete();
                        } catch (Throwable th2) {
                        }
                    }
                    i eqX = i.eqX();
                    new com.bytedance.sdk.adnet.b.c(file.getAbsolutePath(), a4, eqX).build(com.bytedance.sdk.openadsdk.h.d.a(p.a()).c());
                    try {
                        oVar = eqX.get();
                    } catch (Throwable th3) {
                        oVar = null;
                    }
                    if (oVar == null || !oVar.a()) {
                        this.d.set(false);
                        a(arrayList2);
                        u.b("TemplateManager", "loadTemplate error5");
                        return;
                    }
                    while (r2.hasNext()) {
                    }
                }
                for (q.a aVar4 : arrayList) {
                    File file3 = new File(e(), j.a(aVar4.a()));
                    File file4 = new File(file3 + ".tmp");
                    if (file3.exists()) {
                        try {
                            file3.delete();
                        } catch (Throwable th4) {
                        }
                    }
                    if (file4.exists()) {
                        try {
                            file4.delete();
                        } catch (Throwable th5) {
                        }
                    }
                }
                f.a(a2);
                f.c();
                u.b("TemplateManager", "loadTemplate update success: " + a2.b());
                g();
                this.d.set(false);
                this.g.set(System.currentTimeMillis());
                h();
            }
        } catch (Throwable th6) {
            u.a("TemplateManager", "loadTemplate error: ", th6);
        }
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.g.a.a().h(com.bytedance.sdk.openadsdk.g.a.c.b().b(i).g(h.a(i)));
    }

    private void h() {
        if (this.f.getAndSet(0) > 0 && System.currentTimeMillis() - this.g.get() > 600000) {
            d();
        }
    }

    private void a(List<q.a> list) {
        if (list != null && !list.isEmpty()) {
            for (q.a aVar : list) {
                File file = new File(e(), j.a(aVar.a()));
                File file2 = new File(file + ".tmp");
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable th) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable th2) {
                    }
                }
            }
        }
    }

    public static File e() {
        File externalCacheDir;
        if (f4629a == null) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && p.a().getExternalCacheDir() != null) {
                    externalCacheDir = p.a().getExternalCacheDir();
                } else {
                    externalCacheDir = p.a().getCacheDir();
                }
                File file = new File(new File(externalCacheDir, "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f4629a = file;
            } catch (Throwable th) {
                u.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f4629a;
    }
}
