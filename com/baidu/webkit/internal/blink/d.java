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
    public static d f26887f;

    /* renamed from: a  reason: collision with root package name */
    public a f26889a;

    /* renamed from: b  reason: collision with root package name */
    public b f26890b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f26891c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26892d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f26886e = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f26888g = new Object();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26893a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26894b;

        /* renamed from: c  reason: collision with root package name */
        public String f26895c;

        /* renamed from: d  reason: collision with root package name */
        public String f26896d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26897e;

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            if (z != this.f26897e) {
                this.f26897e = z;
            }
            if (this.f26897e) {
                if (this.f26894b.getFilesDir() == null) {
                    sb2 = null;
                } else {
                    if (this.f26894b.getApplicationInfo().nativeLibraryDir != null) {
                        sb = new StringBuilder();
                        sb.append(this.f26894b.getApplicationInfo().nativeLibraryDir);
                        sb.append("/libzeuswebviewchromium.so");
                    } else {
                        sb = new StringBuilder();
                        sb.append(this.f26894b.getFilesDir().getParent());
                        sb.append("/lib/libzeuswebviewchromium.so");
                    }
                    sb2 = sb.toString();
                }
                this.f26895c = sb2;
                this.f26896d = this.f26893a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.f26897e;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26898a;

        /* renamed from: c  reason: collision with root package name */
        public Context f26900c;

        public b(Context context) {
            this.f26900c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f26898a = true;
            synchronized (d.f26888g) {
                if (d.this.f26891c != null) {
                    d.this.f26891c.unzipFinished();
                    d.this.f26891c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                boolean z = true;
                if (this.f26900c != null && SevenZipUtils.getInstance().prepare(this.f26900c, d.this.f26889a.f26895c, d.this.f26889a.f26896d)) {
                    ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                    SevenZipUtils.getInstance().hook(true);
                    SevenZipUtils.getInstance().unzipWithMeta(d.this.f26889a.f26895c, d.this.f26889a.f26896d);
                    Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                    this.f26898a = true;
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
                if (this.f26900c != null) {
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
        this.f26889a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f26894b = applicationContext;
            aVar.f26893a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f26887f == null) {
                f26887f = new d(context);
            }
            dVar = f26887f;
        }
        return dVar;
    }

    private void d() {
        if (this.f26890b.isAlive() || this.f26890b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f26890b.start();
    }

    public final void a() {
        synchronized (f26886e) {
            if (this.f26890b != null && this.f26889a != null) {
                d();
            }
        }
    }

    public final void b() throws Exception {
        synchronized (f26886e) {
            try {
                try {
                    if (this.f26889a.a() && this.f26890b != null) {
                        d();
                        this.f26890b.join(15000L);
                        if (this.f26890b.f26898a) {
                            this.f26890b = null;
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
