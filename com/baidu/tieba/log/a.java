package com.baidu.tieba.log;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.y;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private static a n;
    private StringBuffer e;
    private static final String c = y.a + "/tieba/log";
    private static final String d = y.a + "/tieba/logbak";
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

    public static void a(boolean z) {
    }

    public static boolean a() {
        if (TiebaApplication.h().b()) {
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
        if (a()) {
            g().b(networkStateInfo);
        }
    }

    public static void b() {
        if (a()) {
            g().b(true);
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
        g().c(str);
    }

    public static void b(String str) {
        g().c(str);
    }

    public static void c() {
        g().d();
    }

    public void d() {
        try {
            b(UtilHelper.g(TiebaApplication.h().getApplicationContext()));
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("BdLogger", "初始化日志组建失败 ", e);
        }
    }

    private a() {
        try {
            this.e = new StringBuffer();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("BdLogger", "初始化日志组建失败 ", e);
        }
    }

    private void b(UtilHelper.NetworkStateInfo networkStateInfo) {
        try {
            this.l = networkStateInfo;
            g.a();
            if (a() && this.q == null) {
                this.q = new d(this, c(false));
                this.q.execute(new String[0]);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("BdLogger", "network", e);
        }
    }

    public synchronized void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.e.append(str);
                b(false);
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a("BdLogger", "hashTableToMemoryList error ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!this.a.get()) {
            this.f++;
        } else if (z) {
            com.baidu.adp.lib.f.d.a().a(new b(this));
        }
        if (this.f >= 20 || z) {
            String stringBuffer = this.e.toString();
            this.e = new StringBuffer(stringBuffer.length());
            this.f = 0;
            d(stringBuffer);
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TiebaApplication.h().b()) {
                com.baidu.adp.lib.h.e.d(str);
            }
            this.a.set(true);
            com.baidu.adp.lib.f.d.a().a(new c(this, str));
        }
    }

    private String c(boolean z) {
        if (this.m == null || z) {
            this.m = h();
        }
        return this.m;
    }

    private String h() {
        return DateFormat.format(this.i, System.currentTimeMillis()).toString() + "-" + String.valueOf(UUID.randomUUID()) + ".log";
    }

    private boolean e(String str) {
        if (y.g("log", str) > 102400) {
            if (this.l == UtilHelper.NetworkStateInfo.WIFI) {
                this.p = new f(this, c + "/" + str);
                this.p.execute(new String[0]);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (this.g >= 6) {
            r = false;
            return;
        }
        try {
            boolean e = e(c(false));
            if (this.h == null) {
                this.h = new File(c + "/" + c(e));
            }
            if (!this.h.exists()) {
                y.k(c);
                this.h.createNewFile();
                if (this.l != UtilHelper.NetworkStateInfo.WIFI) {
                    g(c);
                }
            }
            if (this.j == null) {
                this.j = new FileWriter(this.h, true);
            }
            if (this.k == null) {
                this.k = new BufferedWriter(this.j);
            }
            this.k.write(str);
            this.k.flush();
            this.j.flush();
            this.g = 0;
        } catch (Exception e2) {
            this.g++;
            com.baidu.adp.lib.h.e.a("BdLogger", "write() ", e2);
        } finally {
            i();
        }
    }

    private void i() {
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
            com.baidu.adp.lib.h.e.a("BdLogger", "close() error  ", e);
        }
    }

    private void a(String str, long j) {
        try {
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                long j2 = 0;
                for (File file : listFiles) {
                    if (file.isFile()) {
                        long b = y.b(file);
                        if (y.c(file)) {
                            j2 += b;
                            if (j2 >= j && j > 0) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("BdLogger", "check file error ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (y.a(str, true) > 26214400) {
            a(str, 10485760L);
        }
    }
}
