package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.h.f;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.h.b.a;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.y;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class TTAdSdk {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f27813a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final TTAdManager f27814b = new v();
    public static AtomicBoolean isColdStartSdk = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    public static void b(Context context, TTAdConfig tTAdConfig, boolean z) {
        if (g.a()) {
            d.a(context);
            if (tTAdConfig.isSupportMultiProcess()) {
                b.a();
            }
            if (p.h().K()) {
                e.a(new com.bytedance.sdk.openadsdk.l.g("pre connect") { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String l = ak.l("/api/ad/union/ping");
                        try {
                            y.b bVar = new y.b();
                            bVar.a(10L, TimeUnit.SECONDS);
                            y c2 = bVar.c();
                            a0.a aVar = new a0.a();
                            aVar.e(l);
                            c a2 = c2.c(aVar.p()).a();
                            m.f29017d = a2.r();
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        u.b("TTAdSdk", "pre url=", l, " response code=", Integer.valueOf(m.f29017d));
                    }
                });
            }
            updateAdConfig(tTAdConfig);
            d(context, tTAdConfig);
            m.a();
        }
    }

    public static void c(final Context context, final TTAdConfig tTAdConfig) {
        e.a(new com.bytedance.sdk.openadsdk.l.g("init sync") { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.3
            @Override // java.lang.Runnable
            public void run() {
                h h2 = p.h();
                if (!h2.J()) {
                    synchronized (h2) {
                        if (!h2.J()) {
                            h2.a();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.i.e.c().f();
                com.bytedance.sdk.openadsdk.downloadnew.a.g.a(context);
                AppLogHelper.getInstance().initAppLog(context);
                i.d().h();
                TTAdSdk.updatePaid(tTAdConfig.isPaid());
                com.bytedance.sdk.openadsdk.i.e.c().e();
                com.bytedance.sdk.openadsdk.i.e.c().d();
                m.a(context);
                if (tTAdConfig.isDebug()) {
                    u.b();
                }
                e.a(true);
                e.a(new a());
                if (tTAdConfig.isDebug()) {
                    TTAdSdk.f27814b.openDebugMode();
                }
                com.bytedance.sdk.openadsdk.utils.d.a(context);
                com.bytedance.sdk.openadsdk.utils.i.a(context);
                com.bytedance.sdk.openadsdk.video.a.b.a.a(context, 20);
            }
        }, 10);
        m.b().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.4
            @Override // java.lang.Runnable
            public void run() {
                if (TTAdConfig.this.isSupportMultiProcess()) {
                    if (aa.a(context)) {
                        f.a(p.h()).c();
                        u.c("TTAdSdk", "Load setting in main process");
                    }
                } else {
                    f.a(p.h()).c();
                }
                com.bytedance.sdk.openadsdk.core.h.b.a().b();
                p.c().a();
                p.e().a();
                p.d().a();
            }
        }, 10000L);
    }

    public static void d(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            com.bytedance.sdk.openadsdk.i.e.a(tTAdConfig.getHttpStack());
        }
        m.f29014a = tTAdConfig.isAsyncInit();
        m.f29015b = tTAdConfig.getCustomController();
        f27814b.setAppId(tTAdConfig.getAppId()).setName(tTAdConfig.getAppName()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(tTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(tTAdConfig.isUseTextureView()).setTTDownloadEventLogger(tTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).setTTSecAbs(tTAdConfig.getTTSecAbs()).setCustomController(tTAdConfig.getCustomController());
        try {
            if (tTAdConfig.isDebug()) {
                f27814b.openDebugMode();
                com.bytedance.sdk.openadsdk.utils.p.a();
                com.bytedance.sdk.openadsdk.video.d.a.a();
            }
        } catch (Throwable unused) {
        }
    }

    public static TTAdManager getAdManager() {
        return f27814b;
    }

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            m.f29016c = true;
            if (f27813a) {
                return f27814b;
            }
            try {
                b(context, tTAdConfig);
                b(context, tTAdConfig, false);
                c(context, tTAdConfig);
                a(SystemClock.elapsedRealtime() - elapsedRealtime, false, tTAdConfig);
                f27813a = true;
            } catch (Throwable th) {
                th.printStackTrace();
                f27813a = false;
            }
            return f27814b;
        }
        throw new RuntimeException("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
    }

    public static boolean isInitSuccess() {
        return f27813a;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        if (tTAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            i.d().d(tTAdConfig.getData());
        }
        if (TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            return;
        }
        i.d().c(tTAdConfig.getKeywords());
    }

    public static void updatePaid(boolean z) {
        i.d().b(z);
    }

    public static void a(final long j, final boolean z, final TTAdConfig tTAdConfig) {
        e.a(new com.bytedance.sdk.openadsdk.l.g("initMustBeCall") { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.5
            @Override // java.lang.Runnable
            public void run() {
                if (p.h().v()) {
                    try {
                        boolean f2 = i.d().f();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("duration", j);
                        jSONObject.put("is_async", z);
                        jSONObject.put("is_multi_process", tTAdConfig.isSupportMultiProcess());
                        jSONObject.put("is_debug", tTAdConfig.isDebug());
                        jSONObject.put("is_use_texture_view", tTAdConfig.isUseTextureView());
                        jSONObject.put("is_activate_init", f2);
                        i.d().a(false);
                        com.bytedance.sdk.openadsdk.h.a.a().a("pangle_sdk_init", jSONObject);
                        u.b("TTAdSdk", "pangle_sdk_init = ", jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public static void b(Context context, TTAdConfig tTAdConfig) {
        z.a((Object) context, "Context is null, please check.");
        z.a(tTAdConfig, "TTAdConfig is null, please check.");
        p.a(context);
    }

    public static void init(final Context context, final TTAdConfig tTAdConfig, final InitCallback initCallback) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            m.f29016c = true;
            isColdStartSdk.set(true);
            if (f27813a) {
                if (initCallback != null) {
                    initCallback.success();
                    return;
                }
                return;
            }
            b(context, tTAdConfig);
            a(SystemClock.elapsedRealtime() - elapsedRealtime, true, tTAdConfig);
            m.b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TTAdSdk.b(context, tTAdConfig, true);
                        if (initCallback != null) {
                            initCallback.success();
                        }
                        TTAdSdk.c(context, tTAdConfig);
                        boolean unused = TTAdSdk.f27813a = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        InitCallback initCallback2 = initCallback;
                        if (initCallback2 != null) {
                            initCallback2.fail(4000, th.getMessage());
                        }
                        boolean unused2 = TTAdSdk.f27813a = false;
                    }
                }
            });
            return;
        }
        throw new RuntimeException("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
    }
}
