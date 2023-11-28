package com.baidu.webkit.internal.blink;

import android.content.Context;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public final class c {
    public static c b;
    public static final Object e = new Object();
    public static final Object f = new Object();
    public a a;
    public b c;
    public WebViewFactory.WebKitUnzipCallback d;

    /* loaded from: classes9.dex */
    public static class a {
        public String a;
        public Context b;
        public String c;
        public String d;
        public boolean e;

        public final synchronized boolean a() {
            return this.e;
        }

        public final synchronized void b() {
            StringBuilder sb;
            String sb2;
            if (this.e) {
                this.e = false;
            }
            if (this.e) {
                if (this.b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.c = sb2;
                this.d = this.a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Thread {
        public boolean a;
        public final /* synthetic */ c b;
        public Context c;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.a = true;
            synchronized (c.f) {
                if (this.b.d != null) {
                    this.b.d.unzipFinished();
                    c.b(this.b);
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.c != null && SevenZipUtils.getInstance().prepare(this.c, this.b.a.c, this.b.a.d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, "unzip");
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(this.b.a.c, this.b.a.d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.a = true;
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
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, "unzip");
                    return;
                }
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                StringBuilder sb = new StringBuilder("502:");
                if (this.c != null) {
                    z = false;
                }
                sb.append(z);
                loadErrorCode.trace(sb.toString());
                ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                a();
            } catch (Throwable th) {
                LoadErrorCode loadErrorCode2 = LoadErrorCode.getInstance();
                loadErrorCode2.trace("518:" + th.toString());
                a();
            }
        }
    }

    public c(Context context) {
        a aVar = new a();
        this.a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.b = applicationContext;
            aVar.a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c(context);
            }
            cVar = b;
        }
        return cVar;
    }

    public static /* synthetic */ WebViewFactory.WebKitUnzipCallback b(c cVar) {
        cVar.d = null;
        return null;
    }

    private void d() {
        if (this.c.isAlive() || this.c.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.c.start();
    }

    public final void a() {
        synchronized (e) {
            if (this.c != null && this.a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (e) {
            try {
                try {
                    if (this.a.a() && this.c != null) {
                        d();
                        this.c.join(15000L);
                        if (this.c.a) {
                            this.c = null;
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
