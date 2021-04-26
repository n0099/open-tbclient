package com.baidu.webkit.internal.blink;

import android.content.Context;
import android.os.Handler;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f27388f;

    /* renamed from: a  reason: collision with root package name */
    public a f27390a;

    /* renamed from: b  reason: collision with root package name */
    public b f27391b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f27392c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f27393d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f27387e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f27389g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f27394a;

        /* renamed from: b  reason: collision with root package name */
        public Context f27395b;

        /* renamed from: c  reason: collision with root package name */
        public String f27396c;

        /* renamed from: d  reason: collision with root package name */
        public String f27397d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27398e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f27398e) {
                this.f27398e = z;
            }
            if (this.f27398e) {
                if (this.f27395b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f27395b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f27395b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f27395b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f27396c = sb2;
                this.f27397d = this.f27394a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f27398e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f27399a;

        /* renamed from: c  reason: collision with root package name */
        public Context f27401c;

        public b(Context context) {
            this.f27401c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f27399a = true;
            synchronized (d.f27389g) {
                if (d.this.f27392c != null) {
                    d.this.f27392c.unzipFinished();
                    d.this.f27392c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f27401c != null && SevenZipUtils.getInstance().prepare(this.f27401c, d.this.f27390a.f27396c, d.this.f27390a.f27397d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(d.this.f27390a.f27396c, d.this.f27390a.f27397d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f27399a = true;
                    int errorCode = SevenZipUtils.getInstance().getErrorCode();
                    if (errorCode != 0) {
                        LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                        loadErrorCode.set(100, "res=" + errorCode);
                    }
                    Thread thread = new Thread(new f(this));
                    thread.setName("T7@BlinkUnzip");
                    thread.start();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_UNZIP);
                    return;
                }
                LoadErrorCode loadErrorCode2 = LoadErrorCode.getInstance();
                StringBuilder sb = new StringBuilder("502:");
                if (this.f27401c != null) {
                    z = false;
                }
                sb.append(z);
                loadErrorCode2.trace(sb.toString());
                ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                a();
            } catch (Throwable unused) {
                a();
            }
        }
    }

    public d(Context context) {
        a aVar = new a();
        this.f27390a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f27395b = applicationContext;
            aVar.f27394a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f27388f == null) {
                f27388f = new d(context);
            }
            dVar = f27388f;
        }
        return dVar;
    }

    private void d() {
        if (this.f27391b.isAlive() || this.f27391b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f27391b.start();
    }

    public final void a() {
        synchronized (f27387e) {
            if (this.f27391b != null && this.f27390a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f27387e) {
            try {
                try {
                    if (this.f27390a.a() && this.f27391b != null) {
                        d();
                        this.f27391b.join(15000L);
                        if (this.f27391b.f27399a) {
                            this.f27391b = null;
                        } else {
                            LoadErrorCode.getInstance().set(102);
                            throw new TimeoutException("unzip task not finished.");
                        }
                    }
                } catch (Exception e2) {
                    LoadErrorCode.getInstance().set(103);
                    throw e2;
                }
            } finally {
            }
        }
    }
}
