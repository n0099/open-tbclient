package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import d.c.c.b.b.i;
import d.c.c.b.d.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static File f28978a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f28979b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f28980c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f28981d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public boolean f28982e = false;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f28983f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    public AtomicLong f28984g = new AtomicLong();

    public b() {
        f();
    }

    public static File e() {
        File externalCacheDir;
        if (f28978a == null) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && p.a().getExternalCacheDir() != null) {
                    externalCacheDir = p.a().getExternalCacheDir();
                } else {
                    externalCacheDir = p.a().getCacheDir();
                }
                File file = new File(new File(externalCacheDir, "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f28978a = file;
            } catch (Throwable th) {
                u.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f28978a;
    }

    private void f() {
        com.bytedance.sdk.openadsdk.l.e.a(new g("init") { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                f.a();
                b.this.f28980c.set(false);
                b.this.g();
                b.this.d();
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        u.b("TemplateManager", "check template usable1");
        s b2 = f.b();
        if (b2 != null && b2.f()) {
            boolean z = true;
            for (s.a aVar : b2.e()) {
                String a2 = aVar.a();
                File file = new File(e(), j.a(a2));
                String a3 = j.a(file);
                if (!file.exists() || !file.isFile() || aVar.b() == null || !aVar.b().equals(a3)) {
                    z = false;
                    u.b("TemplateManager", "check template usable3: " + a2 + "," + file.getAbsolutePath());
                    break;
                }
                while (r1.hasNext()) {
                }
            }
            if (!z) {
                f.d();
            }
            u.b("TemplateManager", "check template usable4: " + z);
            this.f28982e = z;
            return;
        }
        u.b("TemplateManager", "check template usable2");
    }

    private void h() {
        if (this.f28983f.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f28984g.get() <= 600000) {
            return;
        }
        d();
    }

    public s c() {
        return f.b();
    }

    public void d() {
        a(false);
    }

    public static b a() {
        if (f28979b == null) {
            synchronized (b.class) {
                if (f28979b == null) {
                    f28979b = new b();
                }
            }
        }
        return f28979b;
    }

    public boolean b() {
        return this.f28982e;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123 A[Catch: all -> 0x021f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x021f, blocks: (B:6:0x0010, B:9:0x001a, B:10:0x001f, B:12:0x0034, B:14:0x0049, B:17:0x0051, B:19:0x005b, B:21:0x006f, B:23:0x007b, B:26:0x0087, B:28:0x0091, B:50:0x0117, B:51:0x011b, B:54:0x0123, B:57:0x0157, B:60:0x0160, B:65:0x0180, B:67:0x0186, B:69:0x0194, B:70:0x0198, B:72:0x019e, B:75:0x01d2, B:79:0x01dc, B:29:0x009f, B:30:0x00a7, B:32:0x00ad, B:34:0x00bd, B:35:0x00c1, B:37:0x00cb, B:39:0x00d1, B:41:0x00df, B:42:0x00e3, B:43:0x00eb, B:45:0x00f1, B:47:0x0101, B:48:0x0105, B:49:0x010b, B:80:0x020f), top: B:99:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        Iterator<s.a> it;
        o oVar;
        if (this.f28980c.get()) {
            u.b("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.f28981d.get()) {
                if (z) {
                    this.f28983f.getAndIncrement();
                }
                u.b("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            this.f28981d.set(true);
            s a2 = p.f().a();
            s b2 = f.b();
            if (a2 != null && a2.f()) {
                if (!f.b(a2.b())) {
                    this.f28981d.set(false);
                    this.f28984g.set(System.currentTimeMillis());
                    u.b("TemplateManager", "loadTemplate error4");
                    return;
                }
                ArrayList<s.a> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (b2 != null && !b2.e().isEmpty()) {
                    if (a2.e().isEmpty()) {
                        arrayList.addAll(b2.e());
                        u.b("TemplateManager", "loadTemplate update2");
                    } else {
                        for (s.a aVar : a2.e()) {
                            if (!b2.e().contains(aVar)) {
                                arrayList2.add(aVar);
                            } else {
                                s.a a3 = f.a(aVar.a());
                                if (a3 != null && aVar.b() != null && !aVar.b().equals(a3.b())) {
                                    arrayList2.add(aVar);
                                }
                            }
                        }
                        for (s.a aVar2 : b2.e()) {
                            if (!a2.e().contains(aVar2)) {
                                arrayList.add(aVar2);
                            }
                        }
                        u.b("TemplateManager", "loadTemplate update3");
                    }
                    it = arrayList2.iterator();
                    do {
                        if (!it.hasNext()) {
                            String a4 = it.next().a();
                            File file = new File(e(), j.a(a4));
                            File file2 = new File(file + ".tmp");
                            if (file.exists()) {
                                try {
                                    file.delete();
                                } catch (Throwable unused) {
                                }
                            }
                            if (file2.exists()) {
                                try {
                                    file2.delete();
                                } catch (Throwable unused2) {
                                }
                            }
                            i c2 = i.c();
                            new d.c.c.b.b.c(file.getAbsolutePath(), a4, c2).build(com.bytedance.sdk.openadsdk.i.e.c().d());
                            try {
                                oVar = c2.get();
                            } catch (Throwable unused3) {
                                oVar = null;
                            }
                            if (oVar == null) {
                                break;
                            }
                        } else {
                            for (s.a aVar3 : arrayList) {
                                File file3 = new File(e(), j.a(aVar3.a()));
                                File file4 = new File(file3 + ".tmp");
                                if (file3.exists()) {
                                    try {
                                        file3.delete();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (file4.exists()) {
                                    try {
                                        file4.delete();
                                    } catch (Throwable unused5) {
                                    }
                                }
                            }
                            f.a(a2);
                            f.c();
                            u.b("TemplateManager", "loadTemplate update success: " + a2.b());
                            g();
                            this.f28981d.set(false);
                            this.f28984g.set(System.currentTimeMillis());
                            h();
                            return;
                        }
                    } while (oVar.f());
                    this.f28981d.set(false);
                    a(arrayList2);
                    u.b("TemplateManager", "loadTemplate error5");
                    return;
                }
                arrayList2.addAll(a2.e());
                u.b("TemplateManager", "loadTemplate update1");
                it = arrayList2.iterator();
                do {
                    if (!it.hasNext()) {
                    }
                } while (oVar.f());
                this.f28981d.set(false);
                a(arrayList2);
                u.b("TemplateManager", "loadTemplate error5");
                return;
            }
            this.f28981d.set(false);
            a(109);
            u.b("TemplateManager", "loadTemplate error3");
        } catch (Throwable th) {
            u.a("TemplateManager", "loadTemplate error: ", th);
        }
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.h.a.a().h(com.bytedance.sdk.openadsdk.h.a.c.b().b(i).g(h.a(i)));
    }

    private void a(List<s.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (s.a aVar : list) {
            File file = new File(e(), j.a(aVar.a()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
