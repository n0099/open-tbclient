package com.baidu.tieba.util;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.browser.explorer.WebStorageSizeManager;
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
    private static Hashtable<Integer, String> c;
    private static final String d;
    private static final String e;
    private static y q;
    private static boolean r;
    private static boolean u;
    private StringBuffer f;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f2520a = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);
    private int g = 0;
    private int h = 0;
    private File i = null;
    private String j = "yyyy-MM-dd kk:mm:ss";
    private String k = "yyyyMMddkkmmss";
    private FileWriter l = null;
    private BufferedWriter m = null;
    private UtilHelper.NetworkStateInfo n = UtilHelper.NetworkStateInfo.UNAVAIL;
    private String o = "";
    private String p = null;
    private ad s = null;
    private ab t = null;

    static {
        c = null;
        if (c == null) {
            c = new Hashtable<>();
            c.put(1001, "上线");
            c.put(1002, "GROUP_UPDATE");
            c.put(1003, "PING");
            c.put(202003, "MESSAGE_SYNC");
            c.put(202001, "GROUP_CHAT_MSG");
            c.put(202006, "PUSH_NOTIFY");
            c.put(103002, "吧的群组列表界面网络请求");
            c.put(103004, "群资料页界面网络请求");
            c.put(103005, "根据群的ID获取群的成员列表");
            c.put(103112, "移除群的成员");
            c.put(103006, "根据群的id获取群的等级信息");
            c.put(103110, "加群申请");
            c.put(103111, "往群增加成员");
            c.put(103003, "进群页面接口");
            c.put(103007, "搜群");
            c.put(202004, "删系统群消息");
            c.put(103008, "建群权限获取");
            c.put(103101, "添加群组");
            c.put(103103, "举报群组");
            c.put(103102, "更新群组");
            c.put(202101, "反推计数上传");
        }
        d = af.f2480a + "/tieba/log";
        e = af.f2480a + "/tieba/logbak";
        r = false;
        u = false;
    }

    public static void a(boolean z) {
        u = z;
        com.baidu.tieba.sharedPref.b.a().b("debug_switcher", z);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        if (!r) {
            u = com.baidu.tieba.sharedPref.b.a().a("debug_switcher", false);
            r = true;
        }
        return u;
    }

    public static void a(String str, String str2, String str3) {
        if (a()) {
            e().b(0, 0, str, str2, str3, 0, null, 0L, 0, null);
        }
    }

    public static void a(String str, String str2, String str3, int i, String str4) {
        if (a()) {
            e().b(0, 0, str, str2, str3, i, str4, 0L, 0, null);
        }
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4) {
        if (a()) {
            e().b(i, i2, str, str2, str3, i3, str4, 0L, 0, null);
        }
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
        if (a()) {
            e().b(i, i2, str, str2, str3, i3, str4, j, 0, null);
        }
    }

    public static void a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        if (a()) {
            e().b(i, i2, str, str2, str3, i3, str4, j, i4, str5);
        }
    }

    public static void a(UtilHelper.NetworkStateInfo networkStateInfo) {
        if (a()) {
            e().b(networkStateInfo);
        }
    }

    public static void b() {
        if (a()) {
            e().b(true);
            r = false;
        }
    }

    private static synchronized y e() {
        y yVar;
        synchronized (y.class) {
            if (q == null) {
                q = new y();
            }
            yVar = q;
        }
        return yVar;
    }

    private y() {
        try {
            this.f = new StringBuffer();
            b(UtilHelper.i(TiebaApplication.g().getApplicationContext()));
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "初始化日志组建失败 ", e2);
        }
    }

    private void b(UtilHelper.NetworkStateInfo networkStateInfo) {
        try {
            this.n = networkStateInfo;
            this.o = com.baidu.adp.lib.g.a.a().c();
            if (a() && this.t == null) {
                this.t = new ab(this, c(false));
                this.t.execute(new String[0]);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "network", e2);
        }
    }

    private Hashtable<String, String> f() {
        new Hashtable();
        Hashtable<String, String> hashtable = new Hashtable<>();
        String A = TiebaApplication.A();
        String j = com.baidu.tieba.data.h.j();
        String charSequence = DateFormat.format(this.j, System.currentTimeMillis()).toString();
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
        hashtable.put("network", TextUtils.isEmpty(this.o) ? "" : this.o);
        hashtable.put("uid", TextUtils.isEmpty(A) ? "" : A);
        hashtable.put("version", TextUtils.isEmpty(j) ? "" : j);
        return hashtable;
    }

    private void b(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        Hashtable<String, String> f = f();
        f.put("cmd", String.valueOf(i));
        String str6 = "";
        if (c != null && c.containsKey(Integer.valueOf(i))) {
            str6 = c.get(Integer.valueOf(i));
        }
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        f.put("cmdRemark", str6);
        f.put("seqID", String.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        f.put("reason", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        f.put("action", str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        f.put("result", str3);
        f.put("errorCode", String.valueOf(i3));
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        f.put("errorMsg", str4);
        f.put("costTime", String.valueOf(j));
        f.put("size", String.valueOf(i4));
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        f.put("comment", str5);
        a(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!this.f2520a.get()) {
            this.g++;
        } else if (z) {
            com.baidu.adp.lib.f.c.a().a(new z(this));
        }
        if (this.g >= 20 || z) {
            String stringBuffer = this.f.toString();
            this.f = new StringBuffer(stringBuffer.length());
            this.g = 0;
            a(stringBuffer);
        }
    }

    private synchronized void a(Hashtable<String, String> hashtable) {
        try {
            this.f.append(b(hashtable));
            b(false);
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "hashTableToMemoryList error ", e2);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2520a.set(true);
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
        if (this.p == null || z) {
            this.p = g();
        }
        return this.p;
    }

    private String g() {
        return DateFormat.format(this.k, System.currentTimeMillis()).toString() + "-" + String.valueOf(UUID.randomUUID()) + ".log";
    }

    private boolean b(String str) {
        if (af.a("log", str) > WebStorageSizeManager.QUOTA_INCREASE_STEP) {
            if (this.n == UtilHelper.NetworkStateInfo.WIFI) {
                this.s = new ad(this, d + "/" + str);
                this.s.execute(new String[0]);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.h >= 6) {
            u = false;
            return;
        }
        try {
            try {
                boolean b = b(c(false));
                if (this.i == null) {
                    this.i = new File(d + "/" + c(b));
                }
                if (!this.i.exists()) {
                    af.k(d);
                    this.i.createNewFile();
                    if (this.n != UtilHelper.NetworkStateInfo.WIFI) {
                        d(d);
                    }
                }
                if (this.l == null) {
                    this.l = new FileWriter(this.i, true);
                }
                if (this.m == null) {
                    this.m = new BufferedWriter(this.l);
                }
                this.m.write(str);
                this.m.flush();
                this.l.flush();
                this.h = 0;
            } catch (Exception e2) {
                this.h++;
                com.baidu.adp.lib.h.d.a("DebugLogger", "write() ", e2);
            }
        } finally {
            h();
        }
    }

    private void h() {
        try {
            if (this.l != null) {
                this.l.close();
                this.l = null;
            }
            if (this.m != null) {
                this.m.close();
                this.m = null;
            }
            if (this.i != null) {
                this.i = null;
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "close() error  ", e2);
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
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("DebugLogger", "check file error ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (af.a(str, true) > 52428800) {
            a(str, 10485760L);
        }
    }
}
