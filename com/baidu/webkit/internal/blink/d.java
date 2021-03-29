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
    public static d f26888f;

    /* renamed from: a  reason: collision with root package name */
    public a f26890a;

    /* renamed from: b  reason: collision with root package name */
    public b f26891b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26892c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26893d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26887e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26889g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26894a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26895b;

        /* renamed from: c  reason: collision with root package name */
        public String f26896c;

        /* renamed from: d  reason: collision with root package name */
        public String f26897d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26898e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26898e) {
                this.f26898e = z;
            }
            if (this.f26898e) {
                if (this.f26895b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26895b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26895b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26895b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26896c = sb2;
                this.f26897d = this.f26894a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26898e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26899a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26901c;

        public b(Context context) {
            this.f26901c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26899a = true;
            synchronized (d.f26889g) {
                if (d.this.f26892c != null) {
                    d.this.f26892c.unzipFinished();
                    d.this.f26892c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26901c != null && SevenZipUtils.getInstance().prepare(this.f26901c, d.this.f26890a.f26896c, d.this.f26890a.f26897d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(d.this.f26890a.f26896c, d.this.f26890a.f26897d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26899a = true;
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
                if (this.f26901c != null) {
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
        this.f26890a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26895b = applicationContext;
            aVar.f26894a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f26888f == null) {
                f26888f = new d(context);
            }
            dVar = f26888f;
        }
        return dVar;
    }

    private void d() {
        if (this.f26891b.isAlive() || this.f26891b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26891b.start();
    }

    public final void a() {
        synchronized (f26887e) {
            if (this.f26891b != null && this.f26890a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26887e) {
            try {
                try {
                    if (this.f26890a.a() && this.f26891b != null) {
                        d();
                        this.f26891b.join(15000L);
                        if (this.f26891b.f26899a) {
                            this.f26891b = null;
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
