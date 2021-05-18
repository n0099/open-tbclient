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
    public static c f26645f;

    /* renamed from: a  reason: collision with root package name */
    public a f26647a;

    /* renamed from: b  reason: collision with root package name */
    public b f26648b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26649c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26650d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26644e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26646g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26652a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26653b;

        /* renamed from: c  reason: collision with root package name */
        public String f26654c;

        /* renamed from: d  reason: collision with root package name */
        public String f26655d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26656e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26656e) {
                this.f26656e = z;
            }
            if (this.f26656e) {
                if (this.f26653b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26653b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26653b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26653b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26654c = sb2;
                this.f26655d = this.f26652a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26656e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26657a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26659c;

        public b(Context context) {
            this.f26659c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26657a = true;
            synchronized (c.f26646g) {
                if (c.this.f26649c != null) {
                    c.this.f26649c.unzipFinished();
                    c.this.f26649c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26659c != null && SevenZipUtils.getInstance().prepare(this.f26659c, c.this.f26647a.f26654c, c.this.f26647a.f26655d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(c.this.f26647a.f26654c, c.this.f26647a.f26655d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26657a = true;
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
                if (this.f26659c != null) {
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
        this.f26647a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26653b = applicationContext;
            aVar.f26652a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f26645f == null) {
                f26645f = new c(context);
            }
            cVar = f26645f;
        }
        return cVar;
    }

    private void d() {
        if (this.f26648b.isAlive() || this.f26648b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26648b.start();
    }

    public final void a() {
        synchronized (f26644e) {
            if (this.f26648b != null && this.f26647a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26644e) {
            try {
                try {
                    if (this.f26647a.a() && this.f26648b != null) {
                        d();
                        this.f26648b.join(15000L);
                        if (this.f26648b.f26657a) {
                            this.f26648b = null;
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
