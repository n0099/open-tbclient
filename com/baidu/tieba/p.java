package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.pushservice.PushManager;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.NetWorkCore;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.BannerData;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.AppsActivity;
import com.baidu.tieba.pb.main.bj;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.SDCardChangeReceiver;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.switchs.features.LogSwitchStatic;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    private int A;
    private PersonChangeData I;
    private static p f = new p();
    private static final byte[] J = new byte[0];
    private static volatile Boolean K = null;
    private int e = 0;
    private HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.b>> g = null;
    private int h = 1;
    private boolean i = false;
    private com.baidu.tieba.util.p j = null;
    private com.baidu.tieba.util.p k = null;
    private long l = 0;
    private boolean m = false;
    private VersionData n = null;
    private CombineDownload o = null;
    private BannerData p = null;
    public long a = 0;
    private int q = 0;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private boolean u = false;
    private com.baidu.adp.lib.cache.s<String> v = null;
    private int w = 10;
    private int x = 0;
    private boolean y = false;
    private boolean z = true;
    private boolean B = false;
    private Boolean C = false;
    private int D = 0;
    private Hashtable<String, Integer> E = null;
    private Hashtable<String, Integer> F = null;
    private Hashtable<String, Integer> G = null;
    private boolean H = false;
    public Handler b = new Handler(new q(this));
    com.baidu.adp.lib.c.d c = new t(this);
    boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005005, new u());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005006, new v());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2005007, new x());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask3);
    }

    public final void a(boolean z) {
        this.B = z;
    }

    public final boolean b() {
        return this.B;
    }

    public static p c() {
        return f;
    }

    public final void a(Application application) {
        if (application != null) {
            DatabaseManager.a(new y());
            new ac((byte) 0).execute(new String[0]);
            NetWorkCore.h();
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            a.a(new com.baidu.tbadk.b.d(0));
            a.a(new com.baidu.tbadk.b.a(0));
            a.a(new com.baidu.tbadk.b.c(0));
            a.a(new com.baidu.tbadk.b.b(0));
            if (TbadkApplication.j().m()) {
                com.baidu.tbadk.core.sharedPref.b.a();
                com.baidu.tbadk.core.sharedPref.b.b();
            }
            com.baidu.tbadk.s.a();
            this.q = com.baidu.tbadk.s.a("image_quality", 0);
            TbadkApplication j = TbadkApplication.j();
            com.baidu.tbadk.s.a();
            j.y = com.baidu.tbadk.s.a("view_image_quality", 0);
            com.baidu.tbadk.s.a();
            this.r = com.baidu.tbadk.s.a("show_images", true);
            com.baidu.tbadk.s.a();
            this.h = com.baidu.tbadk.s.a("new_display_photo", 1);
            TbadkApplication j2 = TbadkApplication.j();
            com.baidu.tbadk.s.a();
            j2.b(com.baidu.tbadk.s.a("skin", 0));
            com.baidu.tbadk.s.a();
            this.l = com.baidu.tbadk.s.a("message_id", 0L);
            com.baidu.tbadk.s.a();
            this.u = com.baidu.tbadk.s.a("app_switcher", false);
            com.baidu.tbadk.s.a();
            this.y = com.baidu.tbadk.s.a("manage_mode", false);
            com.baidu.tbadk.s.a();
            this.s = com.baidu.tbadk.s.a("location_on", true);
            com.baidu.tbadk.s.a();
            this.t = com.baidu.tbadk.s.a("has_showed_del_ga_tip", false);
            com.baidu.tbadk.s.a();
            this.x = com.baidu.tbadk.s.a("new_vcode_webview_crash_count", 0);
            com.baidu.tbadk.s.a();
            this.z = com.baidu.tbadk.s.a("search_mode", true);
            com.baidu.tbadk.s.a();
            this.A = com.baidu.tbadk.s.a("search_mode_int", 0);
            com.baidu.tbadk.s.a();
            this.w = com.baidu.tbadk.s.a("perform_sample_count", 0);
            com.baidu.tbadk.s.a();
            boolean a2 = com.baidu.tbadk.s.a("bd_loc_switcher", true);
            if (Build.VERSION.SDK_INT <= 4) {
                a2 = false;
            }
            com.baidu.adp.lib.c.a.a().a(a2);
            com.baidu.tbadk.core.h.a().b();
            com.baidu.adp.lib.a.f.a().b(LogSwitchStatic.LOG);
            com.baidu.tbadk.core.log.a.a();
            com.baidu.tbadk.s.a();
            this.H = com.baidu.tbadk.s.a("has_show_mutiimage_tip", false);
            bn.a(TbadkApplication.j());
            com.baidu.tbadk.core.data.n.c(TbadkApplication.j());
            com.baidu.tbadk.core.data.n.b(TbadkApplication.j());
            try {
                Thread.setDefaultUncaughtExceptionHandler(new com.baidu.tieba.util.q());
            } catch (SecurityException e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
            PushManager.initFromAKSK(application, "GXGROE8KmWiRmcWFpiWTmUbE");
            this.b.sendEmptyMessageDelayed(LocationClientOption.MIN_SCAN_SPAN, 1000L);
            if (TbadkApplication.j().m()) {
                TiebaStatic.a(TbadkApplication.j());
                if (TbadkApplication.j().T()) {
                    com.baidu.adp.lib.a.f.a().b();
                    if (!TbadkApplication.j().aw()) {
                        TiebaStatic.a(TbadkApplication.j().b(), "LocalWebpUnSupport", "");
                    } else {
                        TiebaStatic.a(TbadkApplication.j().b(), "LocalWebpSupport", "");
                    }
                }
                com.baidu.tbadk.imageManager.e.a().a(50, com.baidu.tbadk.core.data.n.i());
                this.g = new HashMap<>();
                com.baidu.tbadk.core.a.l.a().a(TbadkApplication.j());
                com.baidu.tieba.util.k.n();
                TbadkApplication.j().ao();
                this.j = new com.baidu.tieba.util.p(300);
                this.k = new com.baidu.tieba.util.p(100);
                com.baidu.tbadk.coreExtra.messageCenter.a.a().b();
                r();
                if (this.E == null) {
                    this.E = new Hashtable<>();
                }
                if (this.F == null) {
                    this.F = new Hashtable<>();
                }
                if (this.G == null) {
                    this.G = new Hashtable<>();
                }
                E();
                new ax("open").start();
                SDCardChangeReceiver sDCardChangeReceiver = new SDCardChangeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                TbadkApplication.j().registerReceiver(sDCardChangeReceiver, intentFilter);
            } else {
                TbadkApplication.j().r = new ArrayList<>();
            }
            com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a(2012000, new z(this));
            aVar.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            com.baidu.adp.framework.c.a().a(aVar);
            com.baidu.tbadk.c.a aVar2 = new com.baidu.tbadk.c.a(2012100, new aa(this));
            aVar2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            com.baidu.adp.framework.c.a().a(aVar2);
            TbImageView.setSkinMode(TbadkApplication.j().l());
            if (TbadkApplication.j().m()) {
                TbadkApplication.j().p();
                com.baidu.adp.lib.c.a.a().a(true, this.c);
            }
        }
    }

    public static Application d() {
        return TbadkApplication.j().b();
    }

    public static Context e() {
        return TbadkApplication.j();
    }

    public final void f() {
        a(TbadkApplication.j());
    }

    public final boolean a(String str) {
        return (this.E == null || str == null || !this.E.containsKey(str)) ? false : true;
    }

    public final void a(String str, int i, int i2) {
        if (!a(str) && this.E != null && str != null) {
            if (this.E.size() > 100) {
                this.E.clear();
                this.F.clear();
            }
            this.E.put(str, Integer.valueOf(i));
            this.F.put(str, Integer.valueOf(i2));
        }
    }

    public final void g() {
        if (this.E != null) {
            this.E.clear();
        }
        if (this.F != null) {
            this.F.clear();
        }
    }

    public final int b(String str) {
        if (a(str)) {
            return this.E.get(str).intValue();
        }
        return 0;
    }

    public final int c(String str) {
        if (a(str)) {
            return this.F.get(str).intValue();
        }
        return -1;
    }

    public final int h() {
        if (this.E != null) {
            return this.E.size();
        }
        return 0;
    }

    public final int d(String str) {
        if (this.G == null || str == null || !this.G.containsKey(str)) {
            return 0;
        }
        return this.G.get(str).intValue();
    }

    public final void e(String str) {
        if (this.G != null && str != null) {
            this.G.put(str, 1);
            this.i = true;
            if (this.G.size() > 200) {
                this.G.clear();
            }
        }
    }

    public final void f(String str) {
        if (this.G != null && str != null) {
            this.G.put(str, -1);
            this.i = true;
            if (this.G.size() > 200) {
                this.G.clear();
            }
        }
    }

    public final void b(boolean z) {
        this.z = z;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("search_mode", z);
    }

    public final boolean i() {
        return this.z;
    }

    public final boolean j() {
        return this.s;
    }

    public static void c(boolean z) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("moplus_service", z);
    }

    public final void d(boolean z) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("app_switcher", z);
        this.u = z;
    }

    public final boolean k() {
        return this.u;
    }

    public final com.baidu.adp.widget.ImageView.b g(String str) {
        SoftReference<com.baidu.adp.widget.ImageView.b> softReference = this.g.get(str);
        if (softReference != null && softReference.get() != null) {
            return softReference.get();
        }
        com.baidu.adp.widget.ImageView.b a = TbFaceManager.a().a(str);
        if (a != null) {
            this.g.put(str, new SoftReference<>(a));
            return a;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(AccountData accountData) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().d();
        if (accountData != null) {
            TiebaStatic.a(accountData.getAccount(), accountData.getID(), TbadkApplication.D());
        }
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005002));
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005001));
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start_once"));
        com.baidu.tbadk.editortool.ac.a().b();
        bj.a().f();
    }

    public static void l() {
        Date date = new Date();
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("tdatabasecreatetime", date.getTime());
    }

    public final void e(boolean z) {
        this.i = z;
    }

    public final boolean m() {
        return this.i;
    }

    public static void f(boolean z) {
        if (TbadkApplication.j().A != z) {
            TbadkApplication.j().A = z;
        }
    }

    public static void g(boolean z) {
        TbadkApplication.j().B = z;
    }

    public static void h(String str) {
        TbadkApplication.j().C = str;
    }

    public static void i(String str) {
        TbadkApplication.j().D = str;
    }

    public static void h(boolean z) {
        TbadkApplication.j().z = z;
    }

    public static int n() {
        if (!TbadkApplication.j().A && !TbadkApplication.j().z) {
            return 0;
        }
        if (TbadkApplication.j().A && !TbadkApplication.j().z) {
            return 1;
        }
        if (!TbadkApplication.j().A && TbadkApplication.j().z) {
            return 2;
        }
        return 3;
    }

    public static void a(int i) {
        if (i == 0) {
            p pVar = f;
            f(false);
            p pVar2 = f;
            TbadkApplication.j().z = false;
        } else if (i == 1) {
            p pVar3 = f;
            f(true);
            p pVar4 = f;
            TbadkApplication.j().z = false;
        } else if (i == 2) {
            p pVar5 = f;
            f(false);
            p pVar6 = f;
            TbadkApplication.j().z = true;
        } else {
            p pVar7 = f;
            f(true);
            p pVar8 = f;
            TbadkApplication.j().z = true;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    public final void b(int i) {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "setMsgFrequence", new StringBuilder().append(i).toString());
        if (i == 0) {
            TbadkApplication.j().t = i;
            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(true);
            this.b.sendMessage(this.b.obtainMessage(3));
            return;
        }
        TbadkApplication.j().t = 300;
        this.b.sendMessage(this.b.obtainMessage(2));
    }

    public static void i(boolean z) {
        TbadkApplication.j().u = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
        }
    }

    public static void j(boolean z) {
        TbadkApplication.j().v = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
        }
    }

    public static void k(boolean z) {
        TbadkApplication.j().x = z;
    }

    public static void l(boolean z) {
        TbadkApplication.j().w = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().b(0);
        }
    }

    public static void m(boolean z) {
        TbadkApplication.j().s = z;
        if (!z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().e(0);
        }
    }

    public static boolean o() {
        com.baidu.tbadk.s.a();
        return com.baidu.tbadk.s.a("alert_sign_on", false);
    }

    public final void n(boolean z) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("alert_sign_on", z);
        r();
    }

    public final int p() {
        com.baidu.tbadk.s.a();
        int a = com.baidu.tbadk.s.a("alert_sign_hours", -1);
        if (a == -1) {
            P();
            com.baidu.tbadk.s.a();
            return com.baidu.tbadk.s.a("alert_sign_hours", 12);
        }
        return a;
    }

    private void P() {
        Calendar calendar = Calendar.getInstance();
        a(calendar.get(11), calendar.get(12));
    }

    public final int q() {
        com.baidu.tbadk.s.a();
        int a = com.baidu.tbadk.s.a("alert_sign_mins", -1);
        if (a == -1) {
            P();
            com.baidu.tbadk.s.a();
            return com.baidu.tbadk.s.a("alert_sign_mins", 30);
        }
        return a;
    }

    public final void a(int i, int i2) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("alert_sign_hours", i);
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("alert_sign_mins", i2);
        r();
    }

    public final void r() {
        AlarmManager alarmManager = (AlarmManager) TbadkApplication.j().getSystemService("alarm");
        Intent intent = new Intent(com.baidu.tieba.data.d.e());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkApplication.j(), SignAlertReceiver.class);
        if (o()) {
            Calendar calendar = Calendar.getInstance();
            int p = p();
            int i = calendar.get(11);
            int q = q();
            int i2 = calendar.get(12);
            calendar.set(11, p);
            calendar.set(12, q);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= p && (i != p || i2 >= q)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(TbadkApplication.j(), 0, intent, 268435456));
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("sign-alert alarm set to :" + bc.a(calendar.getTime()));
                return;
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkApplication.j(), 0, intent, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("sign-alert alarm cancelled.");
            }
        }
    }

    public final boolean s() {
        return this.r;
    }

    public final void c(int i) {
        AppsActivity.a();
        TbadkApplication.j().b(i);
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("skin", i);
        TbImageView.setSkinMode(i);
        Intent intent = new Intent();
        intent.setAction(com.baidu.tieba.data.d.c());
        intent.putExtra("skin_type", i);
        TbadkApplication.j().sendBroadcast(intent);
    }

    public final int t() {
        return this.w;
    }

    public final void d(int i) {
        this.w = i;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("perform_sample_count", i);
    }

    public final int u() {
        return this.x;
    }

    public final void e(int i) {
        this.x = i;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("new_vcode_webview_crash_count", i);
    }

    public final void v() {
        com.baidu.tbadk.s.a();
        int a = com.baidu.tbadk.s.a("bd_loc_crash_count", 0) + 1;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("bd_loc_crash_count", a);
        if (a > 3) {
            com.baidu.adp.lib.c.a.a().a(false);
            com.baidu.tbadk.s.a();
            com.baidu.tbadk.s.b("bd_loc_switcher", false);
        }
    }

    public final boolean w() {
        return this.m;
    }

    public final void o(boolean z) {
        this.m = true;
    }

    public final void a(CombineDownload combineDownload) {
        this.o = combineDownload;
    }

    public final CombineDownload x() {
        return this.o;
    }

    public final VersionData y() {
        return this.n;
    }

    public final void a(VersionData versionData) {
        this.n = versionData;
    }

    public final com.baidu.tieba.util.p z() {
        return this.j;
    }

    public static String A() {
        String d;
        if (!com.baidu.tbadk.core.util.x.a("/package.last")) {
            com.baidu.tbadk.s.a();
            d = com.baidu.tbadk.s.b("active_version", "");
        } else {
            d = com.baidu.tbadk.core.util.x.d("/package.last");
        }
        if ("active_clear".equals(d)) {
            return null;
        }
        return d;
    }

    public static void B() {
    }

    public static boolean C() {
        com.baidu.tbadk.s.a();
        return com.baidu.tbadk.s.a("first_sync_image_quality", true);
    }

    public static void D() {
        TbadkApplication.j();
        TbadkApplication.g("active_clear");
    }

    public static void f(int i) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("kn_vote_cd", i);
    }

    public static void j(String str) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.a("socket_reconn_strategy", str);
    }

    public static void k(String str) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.a("socket_heartbeat_strategy", str);
    }

    public static void l(String str) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.a("socket_getmsg_strategy", str);
    }

    public static void m(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.a("lcs_switch_strategy", str);
    }

    public static void E() {
        com.baidu.tbadk.s.a();
        String b = com.baidu.tbadk.s.b("lcs_switch_strategy", (String) null);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.ae aeVar = new com.baidu.tieba.model.ae();
            try {
                aeVar.a(new JSONObject(b));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(aeVar.getClass().getName(), "parserJson", e.getMessage());
            }
            com.baidu.tbadk.coreExtra.d.g d = com.baidu.tbadk.coreExtra.d.g.d();
            d.a(aeVar.a() == 1);
            d.b(aeVar.b());
            d.a(aeVar.c() * LocationClientOption.MIN_SCAN_SPAN);
            if (aeVar.d() != null) {
                d.a(aeVar.d());
            }
        }
    }

    public final void a(int[] iArr) {
        if (iArr != null && iArr.length == 3) {
            StringBuilder sb = new StringBuilder(20);
            for (int i : iArr) {
                sb.append(i);
                sb.append("|");
            }
            com.baidu.tbadk.s.a();
            com.baidu.tbadk.s.a("socket_time_out", sb.toString());
            this.b.post(new ab(this, iArr));
        }
    }

    public static void g(int i) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("kn_vote_max", i);
    }

    public static void h(int i) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("kn_vote_rate", i);
    }

    public static void a(long j) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("banner_date", j);
    }

    public static long F() {
        com.baidu.tbadk.s.a();
        return com.baidu.tbadk.s.a("banner_date", 0L);
    }

    public final com.baidu.adp.lib.cache.s<String> G() {
        if (this.v == null) {
            this.v = BdCacheService.a().a("tb.global", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.v;
    }

    public static void H() {
        try {
            TbadkApplication.j().startService(new Intent(TbadkApplication.j(), ClearTempService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
        }
    }

    public static void I() {
        TbadkApplication.j().startService(new Intent(TbadkApplication.j(), TiebaSyncService.class));
    }

    public static void J() {
        TbadkApplication.j().stopService(new Intent(TbadkApplication.j(), TiebaSyncService.class));
    }

    public static void K() {
        TbadkApplication.j().startService(new Intent(TbadkApplication.j(), TiebaActiveService.class));
    }

    public static void L() {
        TbadkApplication.j().stopService(new Intent(TbadkApplication.j(), TiebaActiveService.class));
    }

    public final void a(PersonChangeData personChangeData) {
        this.I = personChangeData;
    }

    public final PersonChangeData M() {
        return this.I;
    }

    public final void p(boolean z) {
        this.H = true;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("has_show_mutiimage_tip", true);
    }

    public final boolean N() {
        return this.H;
    }
}
