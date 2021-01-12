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
/* loaded from: classes14.dex */
public final class d {
    private static d f;

    /* renamed from: a  reason: collision with root package name */
    public a f5653a = new a();

    /* renamed from: b  reason: collision with root package name */
    public b f5654b;
    public WebViewFactory.WebKitUnzipCallback c;
    public Handler d;
    public static final Object e = new Object();
    private static final Object g = new Object();

    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f5655a;

        /* renamed from: b  reason: collision with root package name */
        Context f5656b;
        String c;
        public String d;
        private boolean e;

        public final synchronized void a(boolean z) {
            if (z != this.e) {
                this.e = z;
            }
            if (this.e) {
                this.c = this.f5656b.getFilesDir() == null ? null : this.f5656b.getApplicationInfo().nativeLibraryDir != null ? this.f5656b.getApplicationInfo().nativeLibraryDir + "/libzeuswebviewchromium.so" : this.f5656b.getFilesDir().getParent() + "/lib/libzeuswebviewchromium.so";
                this.d = this.f5655a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        boolean f5657a;
        private Context c;

        public b(Context context) {
            this.c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f5657a = true;
            synchronized (d.g) {
                if (d.this.c != null) {
                    d.this.c.unzipFinished();
                    d.this.c = null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.c == null || !SevenZipUtils.getInstance().prepare(this.c, d.this.f5653a.c, d.this.f5653a.d)) {
                    LoadErrorCode.getInstance().trace("502:" + (this.c == null));
                    ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                    a();
                    return;
                }
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                SevenZipUtils.getInstance().hook(true);
                SevenZipUtils.getInstance().unzipWithMeta(d.this.f5653a.c, d.this.f5653a.d);
                Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                this.f5657a = true;
                int errorCode = SevenZipUtils.getInstance().getErrorCode();
                if (errorCode != 0) {
                    LoadErrorCode.getInstance().set(100, "res=" + errorCode);
                }
                Thread thread = new Thread(new f(this));
                thread.setName("T7@BlinkUnzip");
                thread.start();
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_UNZIP);
            } catch (Throwable th) {
                a();
            }
        }
    }

    private d(Context context) {
        a aVar = this.f5653a;
        try {
            aVar.f5656b = context.getApplicationContext();
            aVar.f5655a = aVar.f5656b.getFilesDir().toString();
        } catch (Exception e2) {
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f == null) {
                f = new d(context);
            }
            dVar = f;
        }
        return dVar;
    }

    private void d() {
        if (this.f5654b.isAlive() || this.f5654b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f5654b.start();
    }

    public final void a() {
        synchronized (e) {
            if (this.f5654b == null || this.f5653a == null) {
                return;
            }
            d();
        }
    }

    public final void b() throws Exception {
        synchronized (e) {
            try {
                if (!this.f5653a.a() || this.f5654b == null) {
                    return;
                }
                d();
                this.f5654b.join(15000L);
                if (this.f5654b.f5657a) {
                    this.f5654b = null;
                } else {
                    LoadErrorCode.getInstance().set(102);
                    throw new TimeoutException("unzip task not finished.");
                }
            } catch (Exception e2) {
                LoadErrorCode.getInstance().set(103);
                throw e2;
            }
        }
    }
}
