package com.baidu.tieba.util;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class y {
    private static y p;
    private StringBuffer e;
    private static final String c = af.f2463a + "/tieba/log";
    private static final String d = af.f2463a + "/tieba/logbak";
    private static boolean q = false;
    private static boolean t = false;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f2503a = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);
    private int f = 0;
    private int g = 0;
    private File h = null;
    private String i = "yyyy-MM-dd kk:mm:ss";
    private String j = "yyyyMMddkkmmss";
    private FileWriter k = null;
    private BufferedWriter l = null;
    private UtilHelper.NetworkStateInfo m = UtilHelper.NetworkStateInfo.UNAVAIL;
    private String n = "";
    private String o = null;
    private ad r = null;
    private ab s = null;

    public static void a(boolean z) {
        t = z;
        com.baidu.tieba.sharedPref.b.a().b("debug_switcher", z);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        if (!q) {
            t = com.baidu.tieba.sharedPref.b.a().a("debug_switcher", false);
            q = true;
        }
        return t;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        if (a()) {
            g().b(str, str2, str3, str4, str5);
        }
    }

    public static void a(String str, String str2, String str3) {
    }

    public static void a(String str, String str2, String str3, int i, String str4) {
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4) {
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
    }

    public static void a(UtilHelper.NetworkStateInfo networkStateInfo) {
        if (a()) {
            g().b(networkStateInfo);
        }
    }

    public static void b() {
        if (a()) {
            g().b(true);
            q = false;
        }
    }

    private static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (p == null) {
                p = new y();
            }
            yVar = p;
        }
        return yVar;
    }

    public static void c() {
        g().d();
    }

    public void d() {
        try {
            b(UtilHelper.i(TiebaApplication.g().getApplicationContext()));
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "初始化日志组建失败 ", e);
        }
    }

    private y() {
        try {
            this.e = new StringBuffer();
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "初始化日志组建失败 ", e);
        }
    }

    private void b(UtilHelper.NetworkStateInfo networkStateInfo) {
        try {
            this.m = networkStateInfo;
            this.n = com.baidu.adp.lib.g.a.a().c();
            if (a() && this.s == null) {
                this.s = new ab(this, c(false));
                this.s.execute(new String[0]);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "network", e);
        }
    }

    private Hashtable<String, String> h() {
        new Hashtable();
        Hashtable<String, String> hashtable = new Hashtable<>();
        String A = TiebaApplication.A();
        String j = com.baidu.tieba.data.h.j();
        String charSequence = DateFormat.format(this.i, System.currentTimeMillis()).toString();
        String a2 = com.baidu.tieba.im.i.a();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        hashtable.put("time", charSequence);
        hashtable.put(SocialConstants.PARAM_CUID, TextUtils.isEmpty(a2) ? "" : a2);
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashtable.put("model", str);
        hashtable.put("network", TextUtils.isEmpty(this.n) ? "" : this.n);
        hashtable.put("uid", TextUtils.isEmpty(A) ? "" : A);
        hashtable.put("version", TextUtils.isEmpty(j) ? "" : j);
        return hashtable;
    }

    private void b(String str, String str2, String str3, String str4, String str5) {
        Hashtable<String, String> h = h();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        h.put(SocialConstants.PARAM_URL, str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        h.put("downloadTime", str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        h.put("dataSize", str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        h.put("errMsg", str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        h.put("remark", str5);
        a(h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!this.f2503a.get()) {
            this.f++;
        } else if (z) {
            com.baidu.adp.lib.f.c.a().a(new z(this));
        }
        if (this.f >= 20 || z) {
            String stringBuffer = this.e.toString();
            this.e = new StringBuffer(stringBuffer.length());
            this.f = 0;
            a(stringBuffer);
        }
    }

    private synchronized void a(Hashtable<String, String> hashtable) {
        try {
            this.e.append(b(hashtable));
            b(false);
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "hashTableToMemoryList error ", e);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2503a.set(true);
            com.baidu.adp.lib.f.c.a().a(new aa(this, str));
        }
    }

    private String b(Hashtable<String, String> hashtable) {
        if (hashtable == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<String> it = hashtable.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String next = it.next();
                sb.append((i2 > 0 ? "\t" : "") + next + "=" + hashtable.get(next));
                i = i2 + 1;
            } else {
                sb.append("\n");
                return sb.toString();
            }
        }
    }

    private String c(boolean z) {
        if (this.o == null || z) {
            this.o = i();
        }
        return this.o;
    }

    private String i() {
        return DateFormat.format(this.j, System.currentTimeMillis()).toString() + "-" + String.valueOf(UUID.randomUUID()) + ".log";
    }

    private boolean b(String str) {
        if (af.a("log", str) > 102400) {
            if (this.m == UtilHelper.NetworkStateInfo.WIFI) {
                this.r = new ad(this, c + "/" + str);
                this.r.execute(new String[0]);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.g >= 6) {
            t = false;
            return;
        }
        try {
            try {
                boolean b = b(c(false));
                if (this.h == null) {
                    this.h = new File(c + "/" + c(b));
                }
                if (!this.h.exists()) {
                    af.k(c);
                    this.h.createNewFile();
                    if (this.m != UtilHelper.NetworkStateInfo.WIFI) {
                        d(c);
                    }
                }
                if (this.k == null) {
                    this.k = new FileWriter(this.h, true);
                }
                if (this.l == null) {
                    this.l = new BufferedWriter(this.k);
                }
                this.l.write(str);
                this.l.flush();
                this.k.flush();
                this.g = 0;
            } catch (Exception e) {
                this.g++;
                com.baidu.adp.lib.h.d.a("DebugLogger", "write() ", e);
            }
        } finally {
            j();
        }
    }

    private void j() {
        try {
            if (this.k != null) {
                this.k.close();
                this.k = null;
            }
            if (this.l != null) {
                this.l.close();
                this.l = null;
            }
            if (this.h != null) {
                this.h = null;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "close() error  ", e);
        }
    }

    private void a(String str, long j) {
        try {
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                long j2 = 0;
                for (File file : listFiles) {
                    if (file.isFile()) {
                        long b = af.b(file);
                        if (af.c(file)) {
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
            com.baidu.adp.lib.h.d.a("DebugLogger", "check file error ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (af.a(str, true) > 26214400) {
            a(str, 10485760L);
        }
    }
}
