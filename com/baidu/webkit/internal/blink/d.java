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
    public static d f26581f;

    /* renamed from: a  reason: collision with root package name */
    public a f26583a;

    /* renamed from: b  reason: collision with root package name */
    public b f26584b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26585c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26586d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26580e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26582g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26587a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26588b;

        /* renamed from: c  reason: collision with root package name */
        public String f26589c;

        /* renamed from: d  reason: collision with root package name */
        public String f26590d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26591e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26591e) {
                this.f26591e = z;
            }
            if (this.f26591e) {
                if (this.f26588b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26588b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26588b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26588b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26589c = sb2;
                this.f26590d = this.f26587a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26591e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26592a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26594c;

        public b(Context context) {
            this.f26594c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26592a = true;
            synchronized (d.f26582g) {
                if (d.this.f26585c != null) {
                    d.this.f26585c.unzipFinished();
                    d.this.f26585c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26594c != null && SevenZipUtils.getInstance().prepare(this.f26594c, d.this.f26583a.f26589c, d.this.f26583a.f26590d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(d.this.f26583a.f26589c, d.this.f26583a.f26590d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26592a = true;
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
                if (this.f26594c != null) {
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
        this.f26583a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26588b = applicationContext;
            aVar.f26587a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f26581f == null) {
                f26581f = new d(context);
            }
            dVar = f26581f;
        }
        return dVar;
    }

    private void d() {
        if (this.f26584b.isAlive() || this.f26584b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26584b.start();
    }

    public final void a() {
        synchronized (f26580e) {
            if (this.f26584b != null && this.f26583a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26580e) {
            try {
                try {
                    if (this.f26583a.a() && this.f26584b != null) {
                        d();
                        this.f26584b.join(15000L);
                        if (this.f26584b.f26592a) {
                            this.f26584b = null;
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
