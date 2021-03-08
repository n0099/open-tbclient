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
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
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
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.bytedance.sdk.openadsdk.downloadnew.core.a, al.a {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Context> f4716a;
    protected final com.bytedance.sdk.openadsdk.core.d.b b;
    protected final l c;
    protected String d;
    protected IListenerManager j;
    private int k;
    private com.ss.android.a.a.b.a l;
    private com.ss.android.a.a.b.b m;
    private com.ss.android.a.a.b.c n;
    private boolean o;
    private WeakReference<View> r;
    private HashSet<Integer> t;
    private com.bytedance.sdk.openadsdk.downloadnew.core.c u;
    private String x;
    private int y;
    protected final AtomicInteger e = new AtomicInteger(1);
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected boolean g = false;
    private final AtomicLong p = new AtomicLong();
    private final AtomicBoolean q = new AtomicBoolean(false);
    private boolean s = false;
    private final al v = new al(Looper.getMainLooper(), this);
    private boolean w = true;
    protected boolean h = false;
    protected boolean i = true;
    private final com.ss.android.a.a.b.d z = new com.ss.android.a.a.b.d() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.1
        @Override // com.ss.android.a.a.b.d
        public void a() {
            d.this.e.set(1);
            d.c("onIdle");
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (d.this.u != null) {
                d.this.u.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(@NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar) {
            d.this.e.set(2);
            d.c("onDownloadStart: " + cVar.d());
            d.this.a(cVar.d());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (d.this.u != null) {
                d.this.u.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(com.ss.android.a.a.d.e eVar, int i) {
            d.this.e.set(3);
            d.this.f.set(false);
            d.this.a(eVar.f7678a);
            d.c("onDownloadActive: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadActive", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadActive(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(com.ss.android.a.a.d.e eVar, int i) {
            d.this.e.set(4);
            d.this.f.set(false);
            d.this.a(eVar.f7678a);
            d.c("onDownloadPaused: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadPaused", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadPaused(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(com.ss.android.a.a.d.e eVar) {
            d.this.e.set(5);
            d.this.a(eVar.f7678a);
            d.c("onDownloadFailed: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadFailed", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadFailed(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(com.ss.android.a.a.d.e eVar) {
            d.this.e.set(7);
            d.this.f.set(true);
            d.this.a(eVar.f7678a);
            d.c("onInstalled: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onInstalled", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onInstalled(eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void c(com.ss.android.a.a.d.e eVar) {
            d.this.e.set(6);
            d.this.a(eVar.f7678a);
            d.c("onDownloadFinished: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadFinished", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadFinished(eVar.c, eVar.e, d.this.b.c());
            }
        }
    };
    private a A = new a();
    private List<ITTAppDownloadListener> B = new ArrayList();
    private boolean C = false;
    private boolean D = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2, String str2, String str3) {
        if (this.A == null) {
            this.A = new a(str, j, j2, str2, str3);
        } else {
            this.A.a(str);
            this.A.a(j);
            this.A.b(j2);
            this.A.b(str2);
            this.A.c(str3);
        }
        com.bytedance.sdk.openadsdk.j.e.b().execute(this.A);
    }

    protected IListenerManager l() {
        if (this.j == null) {
            this.j = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        u.b("DMLibManager", str);
    }

    public d(Context context, l lVar, String str) {
        this.k = -1;
        this.f4716a = new WeakReference<>(context);
        this.c = lVar;
        this.b = lVar.ah();
        this.d = str;
        this.k = aj.c(lVar.aj());
        this.x = j.a(this.c.hashCode() + this.c.aE().toString());
        c("====tag===" + str);
        if (this.b == null) {
            u.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (p.a() == null) {
            p.a(context);
        }
        this.u = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.n = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d, this.c, null).eEs();
        this.l = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.c).eEq();
        this.m = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.c, this.d).eEr();
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        r();
        o();
    }

    private void o() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        if (p.a() == null) {
            p.a(m());
        }
        this.o = true;
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        this.o = false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        if (this.u != null) {
            this.u.a();
        }
        q();
        if (this.t != null) {
            Iterator<Integer> it = this.t.iterator();
            while (it.hasNext()) {
                g.a(it.next().intValue());
                it.remove();
            }
        }
        if (this.f4716a != null) {
            this.f4716a.clear();
            this.f4716a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(@NonNull Activity activity) {
        u.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
        if (activity != null) {
            this.f4716a = new WeakReference<>(activity);
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        if (view != null) {
            this.r = new WeakReference<>(view);
        }
    }

    private void p() {
        c("tryReleaseResource==");
        Activity activity = null;
        if (this.f4716a == null) {
            c("tryReleaseResource==  mContext is null");
            return;
        }
        if (this.f4716a.get() instanceof Activity) {
            activity = (Activity) this.f4716a.get();
        }
        if (activity == null) {
            c("tryReleaseResource==  activity is null");
        } else if (i.d().a(activity)) {
            c("tryReleaseResource==  isActivityAlive is true");
        } else {
            x();
        }
    }

    public void c(boolean z) {
        this.s = z;
    }

    private synchronized void q() {
        c("unbindDownload==" + this.q.get());
        if (this.b != null) {
            if (this.q.get()) {
                this.q.set(false);
                g.d().a(this.n.a(), hashCode());
            }
            p();
        }
    }

    private synchronized void r() {
        c("bindDownload==" + this.q.get());
        if (this.b != null) {
            if (this.q.get()) {
            }
            this.q.set(true);
            g.d().a(m(), hashCode(), this.z, this.n);
        }
    }

    public void a(long j) {
        this.p.set(j);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.c)) {
            b(this.c);
        } else {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (m() != null && this.b != null) {
            TTCustomController e = i.d().e();
            if (e != null && !e.isCanUseWriteExternal()) {
                try {
                    String str = g.f4724a;
                    String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                    if (str != null) {
                        if (!str.startsWith(absolutePath)) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (!this.c.E() && g.a(m(), this.b.b())) {
                c("changeDownloadStatus, not support pause/continue function");
                try {
                    Toast.makeText(m(), "应用正在下载...", 0).show();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            c("changeDownloadStatus, the current status is1: " + this.e);
            g.d().a(this.b.b(), this.n.d(), 2, this.m, this.l);
            c("changeDownloadStatus, the current status is2: " + this.e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        b(0L);
    }

    public void b(long j) {
        if (this.b != null) {
            this.q.set(false);
            g.d().a(this.n.a(), true);
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        if (m() != null && this.b != null) {
            if (!"feed_video_middle_page".equals(this.d)) {
                TTMiddlePageActivity.b(m(), this.c);
            }
            if (k()) {
                this.f.set(true);
            } else if (!j()) {
                if (t()) {
                    this.f.set(true);
                } else if (b(this.w)) {
                    this.f.set(true);
                } else {
                    y();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        if (this.c == null || this.c.O() == null || this.b == null || this.c.O().b() != 3 || this.b.a() == null) {
            return false;
        }
        return true;
    }

    private boolean t() {
        if (this.b == null || !h()) {
            return false;
        }
        boolean a2 = a(m(), this.b.a(), this.c, this.d, this.h);
        if (a2) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.v.sendMessageDelayed(obtain, IMConnection.RETRY_DELAY_TIMES);
            return a2;
        }
        h(false);
        return a2;
    }

    public static boolean a(Context context, String str, l lVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            if (lVar.av() && !z) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public Context m() {
        return (this.f4716a == null || this.f4716a.get() == null) ? p.a() : this.f4716a.get();
    }

    public boolean k() {
        if (this.c.ai() != null) {
            String a2 = this.c.ai().a();
            u.b("DMLibManager", "含有deeplink链接 " + this.h);
            u.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.h);
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.h) {
                    u.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", a(a2));
                }
                if (aj.a(m(), intent)) {
                    u.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                    if (!(m() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        n();
                        if (!a(this.d, "open_url_app", this.c)) {
                            com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_url_app", null);
                        }
                        m().startActivity(intent);
                        k.a().a(this.c, this.d, this.h);
                        if (this.h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_success_realtime");
                            return true;
                        }
                        com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_success_realtime");
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.c.W())) {
                            z.a(m(), this.c.W(), this.c, aj.a(this.d), this.d, true, null);
                        }
                        if (this.h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.h) {
                    u.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                } else {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                }
            }
            if (this.e.get() != 4 && this.e.get() != 3 && (!this.g || this.f.get())) {
                this.g = true;
                if (!a(this.d, "open_fallback_url", this.c)) {
                    com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        this.w = z;
        return t();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        if (this.e.get() == 1) {
            if (x.c(m()) == 0) {
                try {
                    Toast.makeText(m(), ac.b(m(), "tt_no_network"), 0).show();
                    return true;
                } catch (Exception e) {
                    return true;
                }
            }
            if (aj.c(m())) {
                n();
            }
            v();
            return true;
        }
        if (aj.c(m())) {
            n();
        }
        e();
        if (this.e.get() == 3 || this.e.get() == 4) {
            this.f.set(false);
            return false;
        }
        if (this.e.get() == 6) {
            this.f.set(true);
        }
        return false;
    }

    private boolean a(int i) {
        switch (p.h().e()) {
            case -1:
                return !i.d().b(i);
            case 0:
                return false;
            case 1:
            default:
                if (!i.d().b(i)) {
                    int i2 = 104857600;
                    if (this.b != null && this.b.g() > 0) {
                        i2 = this.b.g();
                    }
                    if (i2 > p.h().f()) {
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
        if (this.i) {
            int c = x.c(m());
            if (c == 0) {
                try {
                    Toast.makeText(m(), ac.b(m(), "tt_no_network"), 0).show();
                } catch (Exception e) {
                }
            }
            boolean a2 = a(c);
            boolean z = lVar.J() == 0;
            boolean z2 = lVar.K() == 0;
            boolean z3 = lVar.K() == 2;
            boolean z4 = lVar.L() == 0;
            int T = lVar.T();
            String at = lVar.at();
            if (T == 4 && !TextUtils.isEmpty(at)) {
                if (!this.h && !z3) {
                    this.y = 2;
                    if (z2) {
                        return a2;
                    }
                    return true;
                }
                return false;
            } else if (this.h) {
                if (z4) {
                    return false;
                }
                this.y = 3;
                return true;
            } else {
                this.y = 1;
                if (z) {
                    return a2;
                }
                if (lVar.J() == 2 && this.C && !this.D) {
                    return a2;
                }
                return true;
            }
        }
        return false;
    }

    private void b(final l lVar) {
        if (lVar != null) {
            String Q = lVar.Q();
            String a2 = f.a(lVar);
            String str = "";
            com.bytedance.sdk.openadsdk.core.d.k U = lVar.U();
            if (U != null) {
                str = U.a();
            }
            boolean z = lVar.T() == 4;
            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.d, "pop_up", u());
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), Q, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.2
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    d.this.s();
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, d.this.d, "pop_up_download", d.this.u());
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, d.this.d, "pop_up_cancel", d.this.u());
                }
            }, a2, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", this.y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void v() {
        w();
        this.f.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.c != null && this.c.av() && !this.h && !TTMiddlePageActivity.a(this.c)) {
            aj.a(this.c, this.d);
        }
    }

    private void w() {
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        if (this.b == null) {
            return false;
        }
        String d = this.b.d();
        if (TextUtils.isEmpty(d) || !a(m(), d)) {
            return false;
        }
        this.f.set(true);
        if (!a(this.d, "click_open", this.c)) {
            com.bytedance.sdk.openadsdk.c.d.j(m(), this.c, this.d, aj.h(this.c), null);
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
        u.b("DMLibManager", "使用包名调起 " + this.h);
        if (this.h) {
            u.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", str);
        }
        if (aj.c(context, str)) {
            try {
                Intent b = aj.b(context, str);
                if (b == null) {
                    return false;
                }
                n();
                b.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(b);
                if (this.h) {
                    u.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                }
                if (this.h) {
                    k.a().a(this.c, this.d, true);
                }
                return true;
            } catch (Exception e) {
                if (this.c.W() != null) {
                    z.a(m(), this.c.W(), this.c, aj.a(this.d), this.d, true, null);
                }
                if (this.h) {
                    u.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                }
                return true;
            }
        }
        if (this.h) {
            u.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, String str2, l lVar) {
        return g.a(str, str2, lVar, (Object) 1);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        a(tTAppDownloadListener, true);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        if (tTAppDownloadListener != null) {
            if (this.u != null) {
                this.u.a(tTAppDownloadListener);
            }
            if (z) {
                b(tTAppDownloadListener);
            }
            r();
        }
    }

    private void b(final TTAppDownloadListener tTAppDownloadListener) {
        u.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.x);
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && tTAppDownloadListener != null) {
            com.bytedance.sdk.openadsdk.j.e.b().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a());
                    com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(tTAppDownloadListener);
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a2.a(3));
                    if (asInterface != null) {
                        try {
                            asInterface.registerTTAppDownloadListener(d.this.x, eVar);
                            d.this.B.add(eVar);
                            u.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void d(boolean z) {
        this.C = z;
    }

    public void e(boolean z) {
        this.D = z;
    }

    private void x() {
        u.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.x);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.j.e.b().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
                    try {
                        u.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                        if (asInterface != null && d.this.B.size() > 0) {
                            for (ITTAppDownloadListener iTTAppDownloadListener : d.this.B) {
                                asInterface.unregisterTTAppDownloadListener(d.this.x, iTTAppDownloadListener);
                            }
                            d.this.B.clear();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.InterfaceC1029a interfaceC1029a) {
        if (this.t == null) {
            this.t = new HashSet<>();
        }
        this.t.add(Integer.valueOf(i));
        g.a(i, interfaceC1029a);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        switch (message.what) {
            case 9:
                if (i.d() != null && !i.d().a()) {
                    h(false);
                    if (this.w && !b(this.w)) {
                        y();
                        return;
                    }
                    return;
                }
                h(true);
                return;
            default:
                return;
        }
    }

    public void f(boolean z) {
        this.h = z;
    }

    public void g(boolean z) {
        this.i = z;
    }

    private void h(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "quickapp_fail");
        }
    }

    private void y() {
        if (this.b != null && this.b.b() != null) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) {
            return "";
        }
        return parse.getScheme().toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends com.bytedance.sdk.openadsdk.j.g {

        /* renamed from: a  reason: collision with root package name */
        String f4721a;
        long b;
        long c;
        String d;
        String e;

        public a() {
        }

        public a(String str, long j, long j2, String str2, String str3) {
            this.f4721a = str;
            this.b = j;
            this.c = j2;
            this.d = str2;
            this.e = str3;
        }

        public void a(String str) {
            this.f4721a = str;
        }

        public void a(long j) {
            this.b = j;
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
                d.this.l().executeAppDownloadCallback(d.this.x, this.f4721a, this.b, this.c, this.d, this.e);
            } catch (Throwable th) {
                u.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }
}
