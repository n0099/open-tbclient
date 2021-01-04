package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class b implements com.bytedance.sdk.openadsdk.downloadnew.core.a, am.a {

    /* renamed from: a  reason: collision with root package name */
    protected IListenerManager f7382a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f7383b;
    private final com.bytedance.sdk.openadsdk.core.d.b c;
    private final l d;
    private String e;
    private int f;
    private com.ss.android.a.a.b.a g;
    private com.ss.android.a.a.b.b h;
    private com.ss.android.a.a.b.c i;
    private boolean m;
    private WeakReference<View> p;
    private HashSet<Integer> r;
    private com.bytedance.sdk.openadsdk.downloadnew.core.c s;
    private String v;
    private final AtomicInteger j = new AtomicInteger(1);
    private final AtomicBoolean k = new AtomicBoolean(false);
    private boolean l = false;
    private final AtomicLong n = new AtomicLong();
    private final AtomicBoolean o = new AtomicBoolean(false);
    private boolean q = false;
    private final am t = new am(Looper.getMainLooper(), this);
    private boolean u = true;
    private boolean w = false;
    private boolean x = true;
    private final com.ss.android.a.a.b.d y = new com.ss.android.a.a.b.d() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.1
        @Override // com.ss.android.a.a.b.d
        public void a() {
            b.this.j.set(1);
            b.b("onIdle");
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (b.this.s != null) {
                b.this.s.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(@NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar) {
            b.this.j.set(2);
            b.b("onDownloadStart: " + cVar.d());
            b.this.a(cVar.d());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (b.this.s != null) {
                b.this.s.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(com.ss.android.a.a.d.e eVar, int i) {
            b.this.j.set(3);
            b.this.k.set(false);
            b.this.a(eVar.f13204a);
            b.b("onDownloadActive: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onDownloadActive", eVar.c, eVar.d, eVar.e, b.this.c.c());
            } else if (b.this.s != null) {
                b.this.s.onDownloadActive(eVar.c, eVar.d, eVar.e, b.this.c.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(com.ss.android.a.a.d.e eVar, int i) {
            b.this.j.set(4);
            b.this.k.set(false);
            b.this.a(eVar.f13204a);
            b.b("onDownloadPaused: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onDownloadPaused", eVar.c, eVar.d, eVar.e, b.this.c.c());
            } else if (b.this.s != null) {
                b.this.s.onDownloadPaused(eVar.c, eVar.d, eVar.e, b.this.c.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(com.ss.android.a.a.d.e eVar) {
            b.this.j.set(5);
            b.this.a(eVar.f13204a);
            b.b("onDownloadFailed: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onDownloadFailed", eVar.c, eVar.d, eVar.e, b.this.c.c());
            } else if (b.this.s != null) {
                b.this.s.onDownloadFailed(eVar.c, eVar.d, eVar.e, b.this.c.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(com.ss.android.a.a.d.e eVar) {
            b.this.j.set(7);
            b.this.k.set(true);
            b.this.a(eVar.f13204a);
            b.b("onInstalled: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onInstalled", eVar.c, eVar.d, eVar.e, b.this.c.c());
            } else if (b.this.s != null) {
                b.this.s.onInstalled(eVar.e, b.this.c.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void c(com.ss.android.a.a.d.e eVar) {
            b.this.j.set(6);
            b.this.a(eVar.f13204a);
            b.b("onDownloadFinished: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b.this.a("onDownloadFinished", eVar.c, eVar.d, eVar.e, b.this.c.c());
            } else if (b.this.s != null) {
                b.this.s.onDownloadFinished(eVar.c, eVar.e, b.this.c.c());
            }
        }
    };
    private a z = new a();
    private List<ITTAppDownloadListener> A = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2, String str2, String str3) {
        if (this.z == null) {
            this.z = new a(str, j, j2, str2, str3);
        } else {
            this.z.a(str);
            this.z.a(j);
            this.z.b(j2);
            this.z.b(str2);
            this.z.c(str3);
        }
        com.bytedance.sdk.openadsdk.k.a.a().a((Runnable) this.z, 5);
    }

    protected IListenerManager k() {
        if (this.f7382a == null) {
            this.f7382a = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
        }
        return this.f7382a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        u.b("DMLibManager", str);
    }

    public b(Context context, l lVar, String str) {
        this.f = -1;
        this.f7383b = new WeakReference<>(context);
        this.d = lVar;
        this.c = lVar.U();
        this.e = str;
        this.f = aj.c(lVar.W());
        this.v = j.a(this.d.hashCode() + this.d.am().toString());
        b("====tag===" + str);
        if (this.c == null) {
            u.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (p.a() == null) {
            p.a(context);
        }
        this.s = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.i = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.e, this.d, null).eFc();
        this.g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d).eFa();
        this.h = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d, this.e).eFb();
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        p();
        m();
    }

    private void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        if (p.a() == null) {
            p.a(s());
        }
        this.m = true;
        p();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        if (this.s != null) {
            this.s.a();
        }
        o();
        if (this.r != null) {
            Iterator<Integer> it = this.r.iterator();
            while (it.hasNext()) {
                e.a(it.next().intValue());
                it.remove();
            }
        }
        if (this.f7383b != null) {
            this.f7383b.clear();
            this.f7383b = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(@NonNull Activity activity) {
        u.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
        if (activity != null) {
            this.f7383b = new WeakReference<>(activity);
            p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        if (view != null) {
            this.p = new WeakReference<>(view);
        }
    }

    private void n() {
        b("tryReleaseResource==");
        Activity activity = null;
        if (this.f7383b == null) {
            b("tryReleaseResource==  mContext is null");
            return;
        }
        if (this.f7383b.get() instanceof Activity) {
            activity = (Activity) this.f7383b.get();
        }
        if (activity == null) {
            b("tryReleaseResource==  activity is null");
        } else if (i.c().a(activity)) {
            b("tryReleaseResource==  isActivityAlive is true");
        } else {
            v();
        }
    }

    public void c(boolean z) {
        this.q = z;
    }

    private synchronized void o() {
        b("unbindDownload==" + this.o.get());
        if (this.c != null) {
            if (this.o.get()) {
                this.o.set(false);
                e.d().a(this.i.a(), hashCode());
            }
            n();
        }
    }

    private synchronized void p() {
        b("bindDownload==" + this.o.get());
        if (this.c != null) {
            if (this.o.get()) {
            }
            this.o.set(true);
            e.d().a(s(), hashCode(), this.y, this.i);
        }
    }

    public void a(long j) {
        this.n.set(j);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.d)) {
            b(this.d);
        } else {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (s() != null && this.c != null) {
            TTCustomController d = i.c().d();
            if (d != null && !d.isCanUseWriteExternal()) {
                try {
                    String str = e.f7396a;
                    String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                    if (str != null) {
                        if (!str.startsWith(absolutePath)) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (!this.d.u() && e.a(s(), this.c.b())) {
                b("changeDownloadStatus, not support pause/continue function");
                try {
                    Toast.makeText(s(), "应用正在下载...", 0).show();
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            b("changeDownloadStatus, the current status is1: " + this.j);
            e.d().a(this.c.b(), this.i.d(), 2, this.h, this.g);
            b("changeDownloadStatus, the current status is2: " + this.j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        b(0L);
    }

    public void b(long j) {
        if (this.c != null) {
            this.o.set(false);
            e.d().a(this.i.a(), true);
            p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        if (s() != null && this.c != null) {
            if (l()) {
                this.k.set(true);
            } else if (!j()) {
                if (r()) {
                    this.k.set(true);
                } else if (b(this.u)) {
                    this.k.set(true);
                } else {
                    w();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        if (this.d == null || this.d.C() == null || this.c == null || this.d.C().b() != 3 || this.c.a() == null) {
            return false;
        }
        return true;
    }

    private boolean r() {
        if (this.c == null || !h()) {
            return false;
        }
        boolean a2 = a(s(), this.c.a(), this.d, this.e, this.w);
        if (a2) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.t.sendMessageDelayed(obtain, IMConnection.RETRY_DELAY_TIMES);
            return a2;
        }
        f(false);
        return a2;
    }

    public static boolean a(Context context, String str, l lVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            if (p.h().d() && !z) {
                aj.a(lVar, str2);
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private Context s() {
        return (this.f7383b == null || this.f7383b.get() == null) ? p.a() : this.f7383b.get();
    }

    public boolean l() {
        if (this.d.V() != null) {
            String a2 = this.d.V().a();
            u.b("DMLibManager", "含有deeplink链接 " + this.w);
            u.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.w);
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.w) {
                    u.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + c(a2));
                    com.bytedance.sdk.openadsdk.c.d.a(s(), this.d, this.e, "lp_open_dpl", c(a2));
                }
                if (aj.a(s(), intent)) {
                    u.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                    if (!(s() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        if (p.h().d() && !this.w) {
                            aj.a(this.d, this.e);
                        }
                        s().startActivity(intent);
                        if (!a(this.e, "open_url_app", this.d)) {
                            com.bytedance.sdk.openadsdk.c.d.i(s(), this.d, this.e, "open_url_app", null);
                        }
                        if (this.w) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl");
                        }
                        k.a().a(this.d, this.e, this.w);
                        return true;
                    } catch (Throwable th) {
                        if (this.d.K() != null) {
                            z.a(s(), this.d.K(), this.d, aj.a(this.e), this.e, true);
                        }
                        if (this.w) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl_failed");
                        }
                        return false;
                    }
                } else if (this.w) {
                    u.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl_failed");
                }
            }
            if (this.j.get() != 4 && this.j.get() != 3 && (!this.l || this.k.get())) {
                this.l = true;
                if (!a(this.e, "open_fallback_url", this.d)) {
                    com.bytedance.sdk.openadsdk.c.d.i(s(), this.d, this.e, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        this.u = z;
        return r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        if (this.j.get() == 1) {
            if (x.c(s()) == 0) {
                try {
                    Toast.makeText(s(), ac.b(s(), "tt_no_network"), 0).show();
                    return true;
                } catch (Exception e) {
                    return true;
                }
            }
            t();
            return true;
        }
        e();
        if (this.j.get() == 3 || this.j.get() == 4) {
            this.k.set(false);
            return false;
        }
        if (this.j.get() == 6) {
            this.k.set(true);
        }
        return false;
    }

    private boolean a(int i) {
        switch (p.h().f()) {
            case -1:
                return !i.c().b(i);
            case 0:
                return false;
            case 1:
            default:
                if (!i.c().b(i)) {
                    int i2 = 104857600;
                    if (this.c != null && this.c.g() > 0) {
                        i2 = this.c.g();
                    }
                    if (i2 > p.h().g()) {
                        return true;
                    }
                }
                return false;
            case 2:
                return i != 4;
            case 3:
                return true;
        }
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        int c = x.c(s());
        if (c == 0) {
            try {
                Toast.makeText(s(), ac.b(s(), "tt_no_network"), 0).show();
            } catch (Exception e) {
            }
        }
        boolean a2 = a(c);
        boolean z = lVar.y() == 0;
        boolean z2 = lVar.z() == 0;
        boolean z3 = lVar.z() == 2;
        boolean z4 = lVar.A() == 0;
        int H = lVar.H();
        String ag = lVar.ag();
        if (H == 4 && !TextUtils.isEmpty(ag)) {
            if (!this.w && !z3) {
                if (z2) {
                    return a2;
                }
                return true;
            }
            return false;
        } else if (this.w) {
            return this.x && !z4;
        } else if (z) {
            return a2;
        } else {
            return true;
        }
    }

    private void b(l lVar) {
        if (lVar != null) {
            String E = lVar.E();
            String a2 = d.a(lVar);
            String str = "";
            com.bytedance.sdk.openadsdk.core.d.k I = lVar.I();
            if (I != null) {
                str = I.a();
            }
            g.a(lVar.T(), E, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.2
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    b.this.q();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }
            }, a2, str, lVar.H() == 4);
        }
    }

    private void t() {
        if (p.h().d() && !this.w) {
            aj.a(this.d, this.e);
        }
        u();
        this.k.set(true);
    }

    private void u() {
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        if (this.c == null) {
            return false;
        }
        String d = this.c.d();
        if (TextUtils.isEmpty(d) || !a(s(), d)) {
            return false;
        }
        this.k.set(true);
        if (!a(this.e, "click_open", this.d)) {
            com.bytedance.sdk.openadsdk.c.d.j(s(), this.d, this.e, aj.g(this.d), null);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        return false;
    }

    public boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        u.b("DMLibManager", "使用包名调起 " + this.w);
        if (this.w) {
            u.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
            com.bytedance.sdk.openadsdk.c.d.a(s(), this.d, this.e, "lp_open_dpl", str);
        }
        if (aj.b(context, str)) {
            try {
                Intent a2 = aj.a(context, str);
                if (a2 == null) {
                    return false;
                }
                if (p.h().d() && !this.w) {
                    aj.a(this.d, this.e);
                }
                a2.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(a2);
                if (this.w) {
                    u.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                    com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl");
                }
                if (this.w) {
                    k.a().a(this.d, this.e, true);
                }
                return true;
            } catch (Exception e) {
                if (this.d.K() != null) {
                    z.a(s(), this.d.K(), this.d, aj.a(this.e), this.e, true);
                }
                if (this.w) {
                    u.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl_failed");
                }
                return true;
            }
        }
        if (this.w) {
            u.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
            com.bytedance.sdk.openadsdk.c.d.b(s(), this.d, this.e, "lp_openurl_failed");
        }
        return false;
    }

    private boolean a(String str, String str2, l lVar) {
        return e.a(str, str2, lVar, 1);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        a(tTAppDownloadListener, true);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        if (tTAppDownloadListener != null) {
            if (this.s != null) {
                this.s.a(tTAppDownloadListener);
            }
            if (z) {
                b(tTAppDownloadListener);
            }
            o();
            p();
        }
    }

    private void b(final TTAppDownloadListener tTAppDownloadListener) {
        u.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.v);
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && tTAppDownloadListener != null) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a());
                    com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(tTAppDownloadListener);
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a2.a(3));
                    if (asInterface != null) {
                        try {
                            asInterface.registerTTAppDownloadListener(b.this.v, eVar);
                            b.this.A.add(eVar);
                            u.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + b.this.A.size());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    private void v() {
        u.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.v);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
                    try {
                        u.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + b.this.A.size());
                        if (asInterface != null && b.this.A.size() > 0) {
                            for (ITTAppDownloadListener iTTAppDownloadListener : b.this.A) {
                                asInterface.unregisterTTAppDownloadListener(b.this.v, iTTAppDownloadListener);
                            }
                            b.this.A.clear();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.InterfaceC0992a interfaceC0992a) {
        if (this.r == null) {
            this.r = new HashSet<>();
        }
        this.r.add(Integer.valueOf(i));
        e.a(i, interfaceC0992a);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        switch (message.what) {
            case 9:
                if (i.c() != null && !i.c().a()) {
                    f(false);
                    if (this.u && !b(this.u)) {
                        w();
                        return;
                    }
                    return;
                }
                f(true);
                return;
            default:
                return;
        }
    }

    public void d(boolean z) {
        this.w = z;
    }

    public void e(boolean z) {
        this.x = z;
    }

    private void f(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.c.d.a(s(), this.d, this.e, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.c.d.a(s(), this.d, this.e, "quickapp_fail");
        }
    }

    private void w() {
        if (this.c != null && this.c.b() != null) {
            i();
        }
    }

    private static String c(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) {
            return "";
        }
        return parse.getScheme().toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f7389a;

        /* renamed from: b  reason: collision with root package name */
        long f7390b;
        long c;
        String d;
        String e;

        public a() {
        }

        public a(String str, long j, long j2, String str2, String str3) {
            this.f7389a = str;
            this.f7390b = j;
            this.c = j2;
            this.d = str2;
            this.e = str3;
        }

        public void a(String str) {
            this.f7389a = str;
        }

        public void a(long j) {
            this.f7390b = j;
        }

        public void b(long j) {
            this.c = j;
        }

        public void b(String str) {
            this.d = str;
        }

        public void c(String str) {
            this.e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.k().executeAppDownloadCallback(b.this.v, this.f7389a, this.f7390b, this.c, this.d, this.e);
            } catch (Throwable th) {
                u.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }
}
