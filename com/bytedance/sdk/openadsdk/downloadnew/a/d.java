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
import d.p.a.a.a.a.n;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements com.bytedance.sdk.openadsdk.downloadnew.core.a, am.a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f28911a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.b f28912b;

    /* renamed from: c  reason: collision with root package name */
    public final l f28913c;

    /* renamed from: d  reason: collision with root package name */
    public String f28914d;
    public IListenerManager j;
    public int k;
    public d.p.a.a.a.c.b l;
    public d.p.a.a.a.c.c m;
    public d.p.a.a.a.c.d n;
    public boolean o;
    public WeakReference<View> r;
    public HashSet<Integer> t;
    public com.bytedance.sdk.openadsdk.downloadnew.core.c u;
    public String x;
    public int y;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f28915e = new AtomicInteger(1);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f28916f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public boolean f28917g = false;
    public final AtomicLong p = new AtomicLong();
    public final AtomicBoolean q = new AtomicBoolean(false);
    public boolean s = false;
    public final am v = new am(Looper.getMainLooper(), this);
    public boolean w = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28918h = false;
    public boolean i = true;
    public final d.p.a.a.a.c.e z = new d.p.a.a.a.c.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.1
        @Override // d.p.a.a.a.c.e
        public void a() {
            d.this.f28915e.set(1);
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

        @Override // d.p.a.a.a.c.e
        public void b(d.p.a.a.a.d.e eVar, int i) {
            d.this.f28915e.set(4);
            d.this.f28916f.set(false);
            d.this.a(eVar.f67526a);
            d.c("onDownloadPaused: " + eVar.f67528c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f67529d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadPaused(eVar.f67528c, eVar.f67529d, eVar.f67530e, d.this.f28912b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadPaused", eVar.f67528c, eVar.f67529d, eVar.f67530e, dVar.f28912b.c());
        }

        @Override // d.p.a.a.a.c.e
        public void c(d.p.a.a.a.d.e eVar) {
            d.this.f28915e.set(6);
            d.this.a(eVar.f67526a);
            d.c("onDownloadFinished: " + eVar.f67528c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f67529d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadFinished(eVar.f67528c, eVar.f67530e, d.this.f28912b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadFinished", eVar.f67528c, eVar.f67529d, eVar.f67530e, dVar.f28912b.c());
        }

        @Override // d.p.a.a.a.c.e
        public void a(@NonNull d.p.a.a.a.c.d dVar, @Nullable d.p.a.a.a.c.b bVar) {
            d.this.f28915e.set(2);
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

        @Override // d.p.a.a.a.c.e
        public void b(d.p.a.a.a.d.e eVar) {
            d.this.f28915e.set(7);
            d.this.f28916f.set(true);
            d.this.a(eVar.f67526a);
            d.c("onInstalled: " + eVar.f67528c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f67529d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onInstalled(eVar.f67530e, d.this.f28912b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onInstalled", eVar.f67528c, eVar.f67529d, eVar.f67530e, dVar.f28912b.c());
        }

        @Override // d.p.a.a.a.c.e
        public void a(d.p.a.a.a.d.e eVar, int i) {
            d.this.f28915e.set(3);
            d.this.f28916f.set(false);
            d.this.a(eVar.f67526a);
            d.c("onDownloadActive: " + eVar.f67528c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f67529d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadActive(eVar.f67528c, eVar.f67529d, eVar.f67530e, d.this.f28912b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadActive", eVar.f67528c, eVar.f67529d, eVar.f67530e, dVar.f28912b.c());
        }

        @Override // d.p.a.a.a.c.e
        public void a(d.p.a.a.a.d.e eVar) {
            d.this.f28915e.set(5);
            d.this.a(eVar.f67526a);
            d.c("onDownloadFailed: " + eVar.f67528c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f67529d);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (d.this.u != null) {
                    d.this.u.onDownloadFailed(eVar.f67528c, eVar.f67529d, eVar.f67530e, d.this.f28912b.c());
                    return;
                }
                return;
            }
            d dVar = d.this;
            dVar.a("onDownloadFailed", eVar.f67528c, eVar.f67529d, eVar.f67530e, dVar.f28912b.c());
        }
    };
    public a A = new a();
    public List<ITTAppDownloadListener> B = new CopyOnWriteArrayList();
    public boolean C = false;
    public boolean D = true;

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.openadsdk.l.g {

        /* renamed from: a  reason: collision with root package name */
        public String f28929a;

        /* renamed from: b  reason: collision with root package name */
        public long f28930b;

        /* renamed from: c  reason: collision with root package name */
        public long f28931c;

        /* renamed from: d  reason: collision with root package name */
        public String f28932d;

        /* renamed from: e  reason: collision with root package name */
        public String f28933e;

        public a() {
            super("DownloadCallbackRunnable");
        }

        public void a(String str) {
            this.f28929a = str;
        }

        public void b(long j) {
            this.f28931c = j;
        }

        public void c(String str) {
            this.f28933e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.l().executeAppDownloadCallback(d.this.x, this.f28929a, this.f28930b, this.f28931c, this.f28932d, this.f28933e);
            } catch (Throwable th) {
                u.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }

        public void a(long j) {
            this.f28930b = j;
        }

        public void b(String str) {
            this.f28932d = str;
        }

        public a(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.f28929a = str;
            this.f28930b = j;
            this.f28931c = j2;
            this.f28932d = str2;
            this.f28933e = str3;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public d(Context context, l lVar, String str) {
        this.k = -1;
        this.f28911a = new WeakReference<>(context);
        this.f28913c = lVar;
        this.f28912b = lVar.an();
        this.f28914d = str;
        this.k = ak.c(lVar.ap());
        this.x = j.a(this.f28913c.hashCode() + this.f28913c.aL().toString());
        c("====tag===" + str);
        if (this.f28912b == null) {
            u.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (p.a() == null) {
            p.a(context);
        }
        this.u = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.n = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f28914d, this.f28913c, null).p();
        this.l = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f28913c).e();
        this.m = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f28913c, this.f28914d).d();
        a();
    }

    private void o() {
    }

    private void p() {
        c("tryReleaseResource==");
        WeakReference<Context> weakReference = this.f28911a;
        if (weakReference == null) {
            c("tryReleaseResource==  mContext is null");
            return;
        }
        Activity activity = weakReference.get() instanceof Activity ? (Activity) this.f28911a.get() : null;
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
        if (this.f28912b == null) {
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
        if (this.f28912b == null) {
            return;
        }
        this.q.get();
        this.q.set(true);
        g.d().d(m(), hashCode(), this.z, this.n);
    }

    private void s() {
        if (m() == null || this.f28912b == null) {
            return;
        }
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWriteExternal()) {
            try {
                String str = g.f28944a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null) {
                    if (!str.startsWith(absolutePath)) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (!this.f28913c.E() && g.a(m(), this.f28912b.b())) {
            c("changeDownloadStatus, not support pause/continue function");
            try {
                Toast.makeText(m(), "应用正在下载...", 0).show();
            } catch (Exception unused2) {
            }
        } else if (t()) {
            if (a(this.f28913c)) {
                a(this.f28913c, new b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                    public void a() {
                        g.d().g(d.this.f28912b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                    }
                });
            } else {
                g.d().g(this.f28912b.b(), this.n.d(), 2, this.m, this.l);
            }
        } else {
            c("changeDownloadStatus, the current status is1: " + this.f28915e);
            g.d().h(this.f28912b.b(), this.n.d(), 2, this.m, this.l, null, new n() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3
                @Override // d.p.a.a.a.a.n
                public void a(boolean z) {
                    if (z) {
                        d dVar = d.this;
                        if (dVar.a(dVar.f28913c)) {
                            d dVar2 = d.this;
                            dVar2.a(dVar2.f28913c, new b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3.1
                                @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                                public void a() {
                                    g.d().g(d.this.f28912b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                                }
                            });
                            return;
                        }
                    }
                    g.d().g(d.this.f28912b.b(), d.this.n.d(), 2, d.this.m, d.this.l);
                }
            });
            c("changeDownloadStatus, the current status is2: " + this.f28915e);
        }
    }

    private boolean t() {
        l lVar = this.f28913c;
        if (lVar == null) {
            return false;
        }
        return lVar.Z() == 4 && !TextUtils.isEmpty(this.f28913c.aA());
    }

    private boolean u() {
        if (this.f28912b == null || !h()) {
            return false;
        }
        boolean a2 = a(m(), this.f28912b.a(), this.f28913c, this.f28914d, this.f28918h);
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
        this.f28916f.set(true);
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
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f28912b;
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
        l lVar = this.f28913c;
        return (lVar == null || lVar.U() == null || this.f28912b == null || this.f28913c.U().b() != 3 || this.f28912b.a() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        if (this.f28915e.get() == 1) {
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
        if (this.f28915e.get() != 3 && this.f28915e.get() != 4) {
            if (this.f28915e.get() == 6) {
                this.f28916f.set(true);
            }
        } else {
            this.f28916f.set(false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f28912b;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && a(m(), d2)) {
            z = true;
            this.f28916f.set(true);
            if (!a(this.f28914d, "click_open", this.f28913c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.f28913c, this.f28914d, ak.h(this.f28913c), null);
            }
        }
        return z;
    }

    public boolean k() {
        if (this.f28913c.ao() != null) {
            String a2 = this.f28913c.ao().a();
            u.b("DMLibManager", "含有deeplink链接 " + this.f28918h);
            u.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.f28918h);
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f28918h) {
                    u.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "lp_open_dpl", a(a2));
                }
                if (ak.a(m(), intent)) {
                    u.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                    if (!(m() instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    try {
                        n();
                        if (!a(this.f28914d, "open_url_app", this.f28913c)) {
                            com.bytedance.sdk.openadsdk.c.d.i(m(), this.f28913c, this.f28914d, "open_url_app", null);
                        }
                        m().startActivity(intent);
                        k.a().a(this.f28913c, this.f28914d, this.f28918h);
                        if (this.f28918h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "lp_deeplink_success_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "deeplink_success_realtime");
                        }
                        return true;
                    } catch (Throwable unused) {
                        if (!TextUtils.isEmpty(this.f28913c.ac())) {
                            z.a(m(), this.f28913c.ac(), this.f28913c, ak.a(this.f28914d), this.f28914d, true, null);
                        }
                        if (this.f28918h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "lp_deeplink_fail_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.f28918h) {
                    u.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "lp_deeplink_fail_realtime");
                } else {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.f28913c, this.f28914d, "deeplink_fail_realtime");
                }
            }
            if (this.f28915e.get() != 4 && this.f28915e.get() != 3 && (!this.f28917g || this.f28916f.get())) {
                this.f28917g = true;
                if (!a(this.f28914d, "open_fallback_url", this.f28913c)) {
                    com.bytedance.sdk.openadsdk.c.d.i(m(), this.f28913c, this.f28914d, "open_fallback_url", null);
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
        WeakReference<Context> weakReference = this.f28911a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.f28911a.get();
    }

    public void n() {
        l lVar = this.f28913c;
        if (lVar == null || !lVar.aC() || this.f28918h || TTMiddlePageActivity.a(this.f28913c)) {
            return;
        }
        ak.a(this.f28913c, this.f28914d);
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
        WeakReference<Context> weakReference = this.f28911a;
        if (weakReference != null) {
            weakReference.clear();
            this.f28911a = null;
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
        if (m() == null || this.f28912b == null) {
            return;
        }
        if (!"feed_video_middle_page".equals(this.f28914d)) {
            TTMiddlePageActivity.b(m(), this.f28913c);
        }
        if (k()) {
            this.f28916f.set(true);
        } else if (j()) {
        } else {
            if (u()) {
                this.f28916f.set(true);
            } else if (b(this.w)) {
                this.f28916f.set(true);
            } else {
                z();
            }
        }
    }

    private void h(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "quickapp_fail");
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
        this.f28918h = z;
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
        if (this.f28912b == null) {
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
        this.i = z;
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
        this.f28911a = new WeakReference<>(activity);
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

    private boolean a(int i) {
        int e2 = p.h().e();
        if (e2 != -1) {
            if (e2 != 0) {
                if (e2 != 2) {
                    if (e2 != 3) {
                        if (i.d().b(i)) {
                            return false;
                        }
                        int i2 = 104857600;
                        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f28912b;
                        if (bVar != null && bVar.g() > 0) {
                            i2 = this.f28912b.g();
                        }
                        if (i2 <= p.h().f()) {
                            return false;
                        }
                    }
                } else if (i == 4) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return !i.d().b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        if (this.i) {
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
                if (this.f28918h || z3) {
                    return false;
                }
                this.y = 2;
                if (z2) {
                    return a2;
                }
                return true;
            } else if (this.f28918h) {
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
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.f28914d, "pop_up", v());
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
                com.bytedance.sdk.openadsdk.c.d.b(a4, lVar2, dVar.f28914d, "pop_up_download", dVar.v());
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                Context a4 = p.a();
                l lVar2 = lVar;
                d dVar = d.this;
                com.bytedance.sdk.openadsdk.c.d.b(a4, lVar2, dVar.f28914d, "pop_up_cancel", dVar.v());
            }
        }, a2, a3, z);
    }

    public boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            u.b("DMLibManager", "使用包名调起 " + this.f28918h);
            if (this.f28918h) {
                u.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
                com.bytedance.sdk.openadsdk.c.d.a(m(), this.f28913c, this.f28914d, "lp_open_dpl", str);
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
                        if (this.f28918h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl");
                        }
                        if (this.f28918h) {
                            k.a().a(this.f28913c, this.f28914d, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.f28913c.ac() != null) {
                            z.a(m(), this.f28913c.ac(), this.f28913c, ak.a(this.f28914d), this.f28914d, true, null);
                        }
                        if (this.f28918h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
                        }
                        return true;
                    }
                } else if (this.f28918h) {
                    u.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.f28913c, this.f28914d, "lp_openurl_failed");
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
    public void a(int i, a.InterfaceC0322a interfaceC0322a) {
        if (this.t == null) {
            this.t = new HashSet<>();
        }
        this.t.add(Integer.valueOf(i));
        g.a(i, interfaceC0322a);
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
