package com.baidu.tieba.log;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class a {
    private static a n;
    private StringBuffer e;
    private static final String c = af.a + "/" + com.baidu.tieba.data.i.k() + "/log";
    private static final String d = af.a + "/" + com.baidu.tieba.data.i.k() + "/logbak";
    private static boolean o = false;
    private static boolean r = false;
    private AtomicBoolean a = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);
    private int f = 0;
    private int g = 0;
    private File h = null;
    private String i = "yyyyMMddkkmmss";
    private FileWriter j = null;
    private BufferedWriter k = null;
    private UtilHelper.NetworkStateInfo l = UtilHelper.NetworkStateInfo.UNAVAIL;
    private String m = null;
    private f p = null;
    private d q = null;

    public static void a() {
    }

    private static boolean f() {
        if (TiebaApplication.g().d()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        if (!o) {
            r = true;
            o = true;
        }
        return r;
    }

    public static void a(UtilHelper.NetworkStateInfo networkStateInfo) {
        if (f()) {
            g().b(networkStateInfo);
        }
    }

    public static void b() {
        if (f()) {
            g().a(true);
            o = false;
        }
    }

    private static synchronized a g() {
        a aVar;
        synchronized (a.class) {
            if (n == null) {
                n = new a();
            }
            aVar = n;
        }
        return aVar;
    }

    public static void a(String str) {
        if (f()) {
            g().c(str);
        }
    }

    public static void b(String str) {
        if (f()) {
            g().c(str);
        }
    }

    public static void c() {
        try {
            g().b(UtilHelper.h(TiebaApplication.g().b().getApplicationContext()));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a("BdLogger", "初始化日志组建失败 ", e);
        }
    }

    private a() {
        try {
            this.e = new StringBuffer();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a("BdLogger", "初始化日志组建失败 ", e);
        }
    }

    private void b(UtilHelper.NetworkStateInfo networkStateInfo) {
        try {
            this.l = networkStateInfo;
            g.a();
            if (f() && this.q == null) {
                this.q = new d(this, b(false));
                this.q.execute(new String[0]);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a("BdLogger", "network", e);
        }
    }

    private synchronized void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.e.append(str);
                a(false);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a("BdLogger", "hashTableToMemoryList error ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.a.get()) {
            this.f++;
        } else if (z) {
            com.baidu.adp.lib.f.d.a();
            com.baidu.adp.lib.f.d.a(new b(this));
        }
        if (this.f >= 20 || z) {
            String stringBuffer = this.e.toString();
            this.e = new StringBuffer(stringBuffer.length());
            this.f = 0;
            if (!TextUtils.isEmpty(stringBuffer)) {
                if (TiebaApplication.g().d()) {
                    com.baidu.adp.lib.util.e.e(stringBuffer);
                }
                this.a.set(true);
                com.baidu.adp.lib.f.d.a();
                com.baidu.adp.lib.f.d.a(new c(this, stringBuffer));
            }
        }
    }

    private String b(boolean z) {
        if (this.m == null || z) {
            this.m = String.valueOf(DateFormat.format(this.i, System.currentTimeMillis()).toString()) + "-" + String.valueOf(UUID.randomUUID()) + ".log";
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, String str) {
        boolean z = true;
        if (aVar.g >= 6) {
            r = false;
            return;
        }
        try {
            String b = aVar.b(false);
            if (af.g("log", b) <= 102400) {
                z = false;
            } else if (aVar.l == UtilHelper.NetworkStateInfo.WIFI) {
                aVar.p = new f(aVar, String.valueOf(c) + "/" + b);
                aVar.p.execute(new String[0]);
            }
            if (aVar.h == null) {
                aVar.h = new File(String.valueOf(c) + "/" + aVar.b(z));
            }
            if (!aVar.h.exists()) {
                af.l(c);
                aVar.h.createNewFile();
                if (aVar.l != UtilHelper.NetworkStateInfo.WIFI) {
                    aVar.d(c);
                }
            }
            if (aVar.j == null) {
                aVar.j = new FileWriter(aVar.h, true);
            }
            if (aVar.k == null) {
                aVar.k = new BufferedWriter(aVar.j);
            }
            aVar.k.write(str);
            aVar.k.flush();
            aVar.j.flush();
            aVar.g = 0;
        } catch (Exception e) {
            aVar.g++;
            com.baidu.adp.lib.util.e.a("BdLogger", "write() ", e);
        } finally {
            aVar.h();
        }
    }

    private void h() {
        try {
            if (this.j != null) {
                this.j.close();
                this.j = null;
            }
            if (this.k != null) {
                this.k.close();
                this.k = null;
            }
            if (this.h != null) {
                this.h = null;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a("BdLogger", "close() error  ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (af.a(str, true) > 26214400) {
            try {
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null) {
                    long j = 0;
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            long b = af.b(file);
                            if (af.c(file)) {
                                j += b;
                                if (j >= 10485760 && 10485760 > 0) {
                                    return;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a("BdLogger", "check file error ", e);
            }
        }
    }
}
