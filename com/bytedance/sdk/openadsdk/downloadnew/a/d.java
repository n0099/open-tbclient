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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
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
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import d.o.a.a.a.a.n;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.bytedance.sdk.openadsdk.downloadnew.core.a, am.a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f29159a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.b f29160b;

    /* renamed from: c  reason: collision with root package name */
    public final l f29161c;

    /* renamed from: d  reason: collision with root package name */
    public String f29162d;
    public IListenerManager j;
    public int k;
    public d.o.a.a.a.c.b l;
    public d.o.a.a.a.c.c m;
    public d.o.a.a.a.c.d n;
    public boolean o;
    public WeakReference<View> r;
    public HashSet<Integer> t;
    public com.bytedance.sdk.openadsdk.downloadnew.core.c u;
    public String x;
    public int y;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f29163e = new AtomicInteger(1);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f29164f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public boolean f29165g = false;
    public final AtomicLong p = new AtomicLong();
    public final AtomicBoolean q = new AtomicBoolean(false);
    public boolean s = false;
    public final am v = new am(Looper.getMainLooper(), this);
    public boolean w = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29166h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29167i = true;
    public final d.o.a.a.a.c.e z = new d.o.a.a.a.c.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.1
        @Override // d.o.a.a.a.c.e
        public void a() {
            d.this.f29163e.set(1);
            d.c("onIdle");
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onIdle();
                    return;
                }
                return;
            }
            d.this.a("onIdle", 0L, 0L, (String) null, (String) null);
        }

        @Override // d.o.a.a.a.c.e
        public void b(d.o.a.a.a.d.e eVar, int i2) {
            d.this.f29163e.set(4);
            d.this.f29164f.set(false);
            d.this.a(eVar.f70481a);
            d.c("onDownloadPaused: " + eVar.f70483c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f70484d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadPaused(eVar.f70483c, eVar.f70484d, eVar.f70485e, d.this.f29160b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadPaused", eVar.f70483c, eVar.f70484d, eVar.f70485e, dVar.f29160b.c());
        }

        @Override // d.o.a.a.a.c.e
        public void c(d.o.a.a.a.d.e eVar) {
            d.this.f29163e.set(6);
            d.this.a(eVar.f70481a);
            d.c("onDownloadFinished: " + eVar.f70483c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f70484d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadFinished(eVar.f70483c, eVar.f70485e, d.this.f29160b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadFinished", eVar.f70483c, eVar.f70484d, eVar.f70485e, dVar.f29160b.c());
        }

        @Override // d.o.a.a.a.c.e
        public void a(@NonNull d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar) {
            d.this.f29163e.set(2);
            d.c("onDownloadStart: " + dVar.d());
            d.this.a(dVar.d());
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onIdle();
                    return;
                }
                return;
            }
            d.this.a("onIdle", 0L, 0L, (String) null, (String) null);
        }

        @Override // d.o.a.a.a.c.e
        public void b(d.o.a.a.a.d.e eVar) {
            d.this.f29163e.set(7);
            d.this.f29164f.set(true);
            d.this.a(eVar.f70481a);
            d.c("onInstalled: " + eVar.f70483c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f70484d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onInstalled(eVar.f70485e, d.this.f29160b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onInstalled", eVar.f70483c, eVar.f70484d, eVar.f70485e, dVar.f29160b.c());
        }

        @Override // d.o.a.a.a.c.e
        public void a(d.o.a.a.a.d.e eVar, int i2) {
            d.this.f29163e.set(3);
            d.this.f29164f.set(false);
            d.this.a(eVar.f70481a);
            d.c("onDownloadActive: " + eVar.f70483c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f70484d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadActive(eVar.f70483c, eVar.f70484d, eVar.f70485e, d.this.f29160b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadActive", eVar.f70483c, eVar.f70484d, eVar.f70485e, dVar.f29160b.c());
        }

        @Override // d.o.a.a.a.c.e
        public void a(d.o.a.a.a.d.e eVar) {
            d.this.f29163e.set(5);
            d.this.a(eVar.f70481a);
            d.c("onDownloadFailed: " + eVar.f70483c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f70484d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadFailed(eVar.f70483c, eVar.f70484d, eVar.f70485e, d.this.f29160b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadFailed", eVar.f70483c, eVar.f70484d, eVar.f70485e, dVar.f29160b.c());
        }
    };
    public a A = new a();
    public List<ITTAppDownloadListener> B = new CopyOnWriteArrayList();
    public boolean C = false;
    public boolean D = true;

    /* loaded from: classes6.dex */
    public class a extends com.bytedance.sdk.openadsdk.l.g {

        /* renamed from: a  reason: collision with root package name */
        public String f29178a;

        /* renamed from: b  reason: collision with root package name */
        public long f29179b;

        /* renamed from: c  reason: collision with root package name */
        public long f29180c;

        /* renamed from: d  reason: collision with root package name */
        public String f29181d;

        /* renamed from: e  reason: collision with root package name */
        public String f29182e;

        public a() {
            super("DownloadCallbackRunnable");
        }

        public void a(String str) {
            this.f29178a = str;
        }

        public void b(long j) {
            this.f29180c = j;
        }

        public void c(String str) {
            this.f29182e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.l().executeAppDownloadCallback(d.this.x, this.f29178a, this.f29179b, this.f29180c, this.f29181d, this.f29182e);
            } catch (Throwable th) {
                u.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }

        public void a(long j) {
            this.f29179b = j;
        }

        public void b(String str) {
            this.f29181d = str;
        }

        public a(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.f29178a = str;
            this.f29179b = j;
            this.f29180c = j2;
            this.f29181d = str2;
            this.f29182e = str3;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public d(Context context, l lVar, String str) {
        this.k = -1;
        this.f29159a = new WeakReference<>(context);
        this.f29161c = lVar;
        this.f29160b = lVar.an();
        this.f29162d = str;
        this.k = ak.c(lVar.ap());
        this.x = j.a(this.f29161c.hashCode() + this.f29161c.aL().toString());
        c("====tag===" + str);
        if (this.f29160b == null) {
            u.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (p.a() == null) {
            p.a(context);
        }
        this.u = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.n = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f29162d, this.f29161c, null).p();
        this.l = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f29161c).e();
        this.m = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f29161c, this.f29162d).d();
        a();
    }

    private void o() {
    }

    private void p() {
        c("tryReleaseResource==");
        WeakReference<Context> weakReference = this.f29159a;
        if (weakReference == null) {
            c("tryReleaseResource==  mContext is null");
            return;
        }
        Activity activity = weakReference.get() instanceof Activity ? (Activity) this.f29159a.get() : null;
        if (activity == null) {
            c("tryReleaseResource==  activity is null");
        } else if (i.d().a(activity)) {
            c("tryReleaseResource==  isActivityAlive is true");
        } else {
            y();
        }
    }

    private synchronized void q() {
        c("unbindDownload==" + this.q.get());
        if (this.f29160b == null) {
            return;
        }
        if (this.q.get()) {
            this.q.set(false);
            g.d().f(this.n.a(), hashCode());
        }
        p();
    }

    private synchronized void r() {
        c("bindDownload==" + this.q.get());
        if (this.f29160b == null) {
            return;
        }
        this.q.get();
        this.q.set(true);
        g.d().d(m(), hashCode(), this.z, this.n);
    }

    private void s() {
        if (m() == null || this.f29160b == null) {
            return;
        }
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWriteExternal()) {
            try {
                String str = g.f29193a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null) {
                    if (!str.startsWith(absolutePath)) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (!this.f29161c.E() && g.a(m(), this.f29160b.b())) {
            c("changeDownloadStatus, not support pause/continue function");
            try {
                Toast.makeText(m(), "应用正在下载...", 0).show();
            } catch (Exception unused2) {
            }
        } else if (t()) {
            if (a(this.f29161c)) {
                a(this.f29161c, new b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                    public void a() {
                        g.d().g(d.this.f29160b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                    }
                });
            } else {
                g.d().g(this.f29160b.b(), this.n.d(), 2, this.m, this.l);
            }
        } else {
            c("changeDownloadStatus, the current status is1: " + this.f29163e);
            g.d().h(this.f29160b.b(), this.n.d(), 2, this.m, this.l, null, new n() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3
                @Override // d.o.a.a.a.a.n
                public void a(boolean z) {
                    if (z) {
                        d dVar = d.this;
                        if (dVar.a(dVar.f29161c)) {
                            d dVar2 = d.this;
                            dVar2.a(dVar2.f29161c, new b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3.1
                                @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                                public void a() {
                                    g.d().g(d.this.f29160b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                                }
                            });
                            return;
                        }
                    }
                    g.d().g(d.this.f29160b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                }
            });
            c("changeDownloadStatus, the current status is2: " + this.f29163e);
        }
    }

    private boolean t() {
        l lVar = this.f29161c;
        if (lVar == null) {
            return false;
        }
        return lVar.Z() == 4 && !TextUtils.isEmpty(this.f29161c.aA());
    }

    private boolean u() {
        if (this.f29160b == null || !h()) {
            return false;
        }
        boolean a2 = a(m(), this.f29160b.a(), this.f29161c, this.f29162d, this.f29166h);
        if (a2) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.v.sendMessageDelayed(obtain, 3000L);
        } else {
            h(false);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", this.y);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private void w() {
        x();
        this.f29164f.set(true);
    }

    private void x() {
        e();
    }

    private void y() {
        u.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.x);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.c().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.6
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager asInterface = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
                    try {
                        u.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                        if (asInterface == null || d.this.B.size() <= 0) {
                            return;
                        }
                        for (ITTAppDownloadListener iTTAppDownloadListener : d.this.B) {
                            asInterface.unregisterTTAppDownloadListener(d.this.x, iTTAppDownloadListener);
                        }
                        d.this.B.clear();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    private void z() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29160b;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        l lVar = this.f29161c;
        return (lVar == null || lVar.U() == null || this.f29160b == null || this.f29161c.U().b() != 3 || this.f29160b.a() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        if (this.f29163e.get() == 1) {
            if (x.c(m()) == 0) {
                try {
                    Toast.makeText(m(), ad.b(m(), "tt_no_network"), 0).show();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
            if (ak.c(m())) {
                n();
            }
            w();
            return true;
        }
        if (ak.c(m())) {
            n();
        }
        e();
        if (this.f29163e.get() != 3 && this.f29163e.get() != 4) {
            if (this.f29163e.get() == 6) {
                this.f29164f.set(true);
            }
        } else {
            this.f29164f.set(false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29160b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && a(m(), d2)) {
            z = true;
            this.f29164f.set(true);
            if (!a(this.f29162d, "click_open", this.f29161c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f29161c, this.f29162d, ak.h(this.f29161c), null);
            }
        }
        return z;
    }

    public boolean k() {
        if (this.f29161c.ao() != null) {
            String a2 = this.f29161c.ao().a();
            u.b("DMLibManager", "含有deeplink链接 " + this.f29166h);
            u.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.f29166h);
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f29166h) {
                    u.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "lp_open_dpl", a(a2));
                }
                if (ak.a(m(), intent)) {
                    u.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                    if (!(m() instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    try {
                        n();
                        if (!a(this.f29162d, "open_url_app", this.f29161c)) {
                            com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29161c, this.f29162d, "open_url_app", null);
                        }
                        m().startActivity(intent);
                        k.a().a(this.f29161c, this.f29162d, this.f29166h);
                        if (this.f29166h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "lp_deeplink_success_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "deeplink_success_realtime");
                        }
                        return true;
                    } catch (Throwable unused) {
                        if (!TextUtils.isEmpty(this.f29161c.ac())) {
                            z.a(m(), this.f29161c.ac(), this.f29161c, ak.a(this.f29162d), this.f29162d, true, null);
                        }
                        if (this.f29166h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "lp_deeplink_fail_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.f29166h) {
                    u.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "lp_deeplink_fail_realtime");
                } else {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f29161c, this.f29162d, "deeplink_fail_realtime");
                }
            }
            if (this.f29163e.get() != 4 && this.f29163e.get() != 3 && (!this.f29165g || this.f29164f.get())) {
                this.f29165g = true;
                if (!a(this.f29162d, "open_fallback_url", this.f29161c)) {
                    com.bytedance.sdk.openadsdk.c.d.i(m(), this.f29161c, this.f29162d, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    public IListenerManager l() {
        if (this.j == null) {
            this.j = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
        }
        return this.j;
    }

    public Context m() {
        WeakReference<Context> weakReference = this.f29159a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.f29159a.get();
    }

    public void n() {
        l lVar = this.f29161c;
        if (lVar == null || !lVar.aC() || this.f29166h || TTMiddlePageActivity.a(this.f29161c)) {
            return;
        }
        ak.a(this.f29161c, this.f29162d);
    }

    public static void c(String str) {
        u.b("DMLibManager", str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.u;
        if (cVar != null) {
            cVar.a();
        }
        q();
        HashSet<Integer> hashSet = this.t;
        if (hashSet != null) {
            Iterator<Integer> it = hashSet.iterator();
            while (it.hasNext()) {
                g.a(it.next().intValue());
                it.remove();
            }
        }
        WeakReference<Context> weakReference = this.f29159a;
        if (weakReference != null) {
            weakReference.clear();
            this.f29159a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        b(0L);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        if (m() == null || this.f29160b == null) {
            return;
        }
        if (!"feed_video_middle_page".equals(this.f29162d)) {
            TTMiddlePageActivity.b(m(), this.f29161c);
        }
        if (k()) {
            this.f29164f.set(true);
        } else if (j()) {
        } else {
            if (u()) {
                this.f29164f.set(true);
            } else if (b(this.w)) {
                this.f29164f.set(true);
            } else {
                z();
            }
        }
    }

    private void h(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "quickapp_fail");
        }
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

    public void e(boolean z) {
        this.D = z;
    }

    public void f(boolean z) {
        this.f29166h = z;
    }

    public void c(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2, String str2, String str3) {
        a aVar = this.A;
        if (aVar == null) {
            this.A = new a(str, j, j2, str2, str3);
        } else {
            aVar.a(str);
            this.A.a(j);
            this.A.b(j2);
            this.A.b(str2);
            this.A.c(str3);
        }
        com.bytedance.sdk.openadsdk.l.e.c().execute(this.A);
    }

    public void b(long j) {
        if (this.f29160b == null) {
            return;
        }
        this.q.set(false);
        g.d().i(this.n.a(), true);
        r();
    }

    private void b(final TTAppDownloadListener tTAppDownloadListener) {
        u.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.x);
        if (!com.bytedance.sdk.openadsdk.multipro.b.b() || tTAppDownloadListener == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.c().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a());
                com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(tTAppDownloadListener);
                IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(3));
                if (asInterface != null) {
                    try {
                        asInterface.registerTTAppDownloadListener(d.this.x, eVar);
                        d.this.B.add(eVar);
                        u.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        r();
        o();
    }

    public void g(boolean z) {
        this.f29167i = z;
    }

    public void d(boolean z) {
        this.C = z;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(@NonNull Activity activity) {
        u.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
        if (activity == null) {
            return;
        }
        this.f29159a = new WeakReference<>(activity);
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        if (view != null) {
            this.r = new WeakReference<>(view);
        }
    }

    public void a(long j) {
        this.p.set(j);
    }

    public static boolean a(Context context, String str, l lVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            if (lVar.aC() && !z) {
                ak.a(lVar, str2);
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        this.w = z;
        return u();
    }

    private boolean a(int i2) {
        int e2 = p.h().e();
        if (e2 != -1) {
            if (e2 != 0) {
                if (e2 != 2) {
                    if (e2 != 3) {
                        if (i.d().b(i2)) {
                            return false;
                        }
                        int i3 = 104857600;
                        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f29160b;
                        if (bVar != null && bVar.g() > 0) {
                            i3 = this.f29160b.g();
                        }
                        if (i3 <= p.h().f()) {
                            return false;
                        }
                    }
                } else if (i2 == 4) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return !i.d().b(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        if (this.f29167i) {
            int c2 = x.c(m());
            if (c2 == 0) {
                try {
                    Toast.makeText(m(), ad.b(m(), "tt_no_network"), 0).show();
                } catch (Exception unused) {
                }
            }
            boolean a2 = a(c2);
            boolean z = lVar.J() == 0;
            boolean z2 = lVar.K() == 0;
            boolean z3 = lVar.K() == 2;
            boolean z4 = lVar.L() == 0;
            if (t()) {
                if (this.f29166h || z3) {
                    return false;
                }
                this.y = 2;
                if (z2) {
                    return a2;
                }
                return true;
            } else if (this.f29166h) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final l lVar, final b bVar) {
        if (lVar == null) {
            return;
        }
        String W = lVar.W();
        String a2 = f.a(lVar);
        com.bytedance.sdk.openadsdk.core.d.k aa = lVar.aa();
        String a3 = aa != null ? aa.a() : "";
        boolean z = lVar.Z() == 4;
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.f29162d, "pop_up", v());
        com.bytedance.sdk.openadsdk.utils.g.a(m(), lVar.am(), W, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.4
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                Context a4 = p.a();
                l lVar2 = lVar;
                d dVar = d.this;
                com.bytedance.sdk.openadsdk.c.d.b(a4, lVar2, dVar.f29162d, "pop_up_download", dVar.v());
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                Context a4 = p.a();
                l lVar2 = lVar;
                d dVar = d.this;
                com.bytedance.sdk.openadsdk.c.d.b(a4, lVar2, dVar.f29162d, "pop_up_cancel", dVar.v());
            }
        }, a2, a3, z);
    }

    public boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            u.b("DMLibManager", "使用包名调起 " + this.f29166h);
            if (this.f29166h) {
                u.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
                com.bytedance.sdk.openadsdk.c.d.a(m(), this.f29161c, this.f29162d, "lp_open_dpl", str);
            }
            try {
                if (ak.c(context, str)) {
                    try {
                        Intent b2 = ak.b(context, str);
                        if (b2 == null) {
                            return false;
                        }
                        n();
                        b2.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(b2);
                        if (this.f29166h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl");
                        }
                        if (this.f29166h) {
                            k.a().a(this.f29161c, this.f29162d, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.f29161c.ac() != null) {
                            z.a(m(), this.f29161c.ac(), this.f29161c, ak.a(this.f29162d), this.f29162d, true, null);
                        }
                        if (this.f29166h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                        }
                        return true;
                    }
                } else if (this.f29166h) {
                    u.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f29161c, this.f29162d, "lp_openurl_failed");
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    public boolean a(String str, String str2, l lVar) {
        return g.a(str, str2, lVar, (Object) 1);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        a(tTAppDownloadListener, true);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        if (tTAppDownloadListener == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.u;
        if (cVar != null) {
            cVar.a(tTAppDownloadListener);
        }
        if (z) {
            b(tTAppDownloadListener);
        }
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i2, a.InterfaceC0308a interfaceC0308a) {
        if (this.t == null) {
            this.t = new HashSet<>();
        }
        this.t.add(Integer.valueOf(i2));
        g.a(i2, interfaceC0308a);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what != 9) {
            return;
        }
        if (i.d() != null && !i.d().a()) {
            h(false);
            boolean z = this.w;
            if (!z || b(z)) {
                return;
            }
            z();
            return;
        }
        h(true);
    }

    public String a(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase();
    }
}
