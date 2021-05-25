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
public final class c {

    /* renamed from: f  reason: collision with root package name */
    public static c f26574f;

    /* renamed from: a  reason: collision with root package name */
    public a f26576a;

    /* renamed from: b  reason: collision with root package name */
    public b f26577b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26578c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26579d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26573e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26575g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26581a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26582b;

        /* renamed from: c  reason: collision with root package name */
        public String f26583c;

        /* renamed from: d  reason: collision with root package name */
        public String f26584d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26585e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26585e) {
                this.f26585e = z;
            }
            if (this.f26585e) {
                if (this.f26582b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26582b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26582b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26582b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26583c = sb2;
                this.f26584d = this.f26581a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26585e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26586a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26588c;

        public b(Context context) {
            this.f26588c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26586a = true;
            synchronized (c.f26575g) {
                if (c.this.f26578c != null) {
                    c.this.f26578c.unzipFinished();
                    c.this.f26578c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26588c != null && SevenZipUtils.getInstance().prepare(this.f26588c, c.this.f26576a.f26583c, c.this.f26576a.f26584d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(c.this.f26576a.f26583c, c.this.f26576a.f26584d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26586a = true;
                    int errorCode = SevenZipUtils.getInstance().getErrorCode();
                    if (errorCode != 0) {
                        LoadErrorCode.getInstance().set(100, "res=".concat(String.valueOf(errorCode)));
                    }
                    Thread thread = new Thread(new Runnable() { // from class: com.baidu.webkit.internal.blink.c.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebViewFactory.getProvider();
                            b.this.a();
                        }
                    });
                    thread.setName("T7@BlinkUnzip");
                    thread.start();
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_UNZIP);
                    return;
                }
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                StringBuilder sb = new StringBuilder("502:");
                if (this.f26588c != null) {
                    z = false;
                }
                sb.append(z);
                loadErrorCode.trace(sb.toString());
                ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                a();
            } catch (Throwable unused) {
                a();
            }
        }
    }

    public c(Context context) {
        a aVar = new a();
        this.f26576a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26582b = applicationContext;
            aVar.f26581a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f26574f == null) {
                f26574f = new c(context);
            }
            cVar = f26574f;
        }
        return cVar;
    }

    private void d() {
        if (this.f26577b.isAlive() || this.f26577b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26577b.start();
    }

    public final void a() {
        synchronized (f26573e) {
            if (this.f26577b != null && this.f26576a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26573e) {
            try {
                try {
                    if (this.f26576a.a() && this.f26577b != null) {
                        d();
                        this.f26577b.join(15000L);
                        if (this.f26577b.f26586a) {
                            this.f26577b = null;
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
