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
    public static d f26573f;

    /* renamed from: a  reason: collision with root package name */
    public a f26575a;

    /* renamed from: b  reason: collision with root package name */
    public b f26576b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26577c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26578d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26572e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26574g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26579a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26580b;

        /* renamed from: c  reason: collision with root package name */
        public String f26581c;

        /* renamed from: d  reason: collision with root package name */
        public String f26582d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26583e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26583e) {
                this.f26583e = z;
            }
            if (this.f26583e) {
                if (this.f26580b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26580b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26580b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26580b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26581c = sb2;
                this.f26582d = this.f26579a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26583e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26584a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26586c;

        public b(Context context) {
            this.f26586c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26584a = true;
            synchronized (d.f26574g) {
                if (d.this.f26577c != null) {
                    d.this.f26577c.unzipFinished();
                    d.this.f26577c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26586c != null && SevenZipUtils.getInstance().prepare(this.f26586c, d.this.f26575a.f26581c, d.this.f26575a.f26582d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(d.this.f26575a.f26581c, d.this.f26575a.f26582d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26584a = true;
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
                if (this.f26586c != null) {
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
        this.f26575a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26580b = applicationContext;
            aVar.f26579a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f26573f == null) {
                f26573f = new d(context);
            }
            dVar = f26573f;
        }
        return dVar;
    }

    private void d() {
        if (this.f26576b.isAlive() || this.f26576b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26576b.start();
    }

    public final void a() {
        synchronized (f26572e) {
            if (this.f26576b != null && this.f26575a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26572e) {
            try {
                try {
                    if (this.f26575a.a() && this.f26576b != null) {
                        d();
                        this.f26576b.join(15000L);
                        if (this.f26576b.f26584a) {
                            this.f26576b = null;
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
