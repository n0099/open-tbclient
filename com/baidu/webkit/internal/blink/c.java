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
    public static c f26759f;

    /* renamed from: a  reason: collision with root package name */
    public a f26761a;

    /* renamed from: b  reason: collision with root package name */
    public b f26762b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26763c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26764d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26758e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26760g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26766a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26767b;

        /* renamed from: c  reason: collision with root package name */
        public String f26768c;

        /* renamed from: d  reason: collision with root package name */
        public String f26769d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26770e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26770e) {
                this.f26770e = z;
            }
            if (this.f26770e) {
                if (this.f26767b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26767b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26767b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26767b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26768c = sb2;
                this.f26769d = this.f26766a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26770e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26771a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26773c;

        public b(Context context) {
            this.f26773c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26771a = true;
            synchronized (c.f26760g) {
                if (c.this.f26763c != null) {
                    c.this.f26763c.unzipFinished();
                    c.this.f26763c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26773c != null && SevenZipUtils.getInstance().prepare(this.f26773c, c.this.f26761a.f26768c, c.this.f26761a.f26769d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(c.this.f26761a.f26768c, c.this.f26761a.f26769d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26771a = true;
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
                if (this.f26773c != null) {
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
        this.f26761a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26767b = applicationContext;
            aVar.f26766a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f26759f == null) {
                f26759f = new c(context);
            }
            cVar = f26759f;
        }
        return cVar;
    }

    private void d() {
        if (this.f26762b.isAlive() || this.f26762b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26762b.start();
    }

    public final void a() {
        synchronized (f26758e) {
            if (this.f26762b != null && this.f26761a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26758e) {
            try {
                try {
                    if (this.f26761a.a() && this.f26762b != null) {
                        d();
                        this.f26762b.join(15000L);
                        if (this.f26762b.f26771a) {
                            this.f26762b = null;
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
