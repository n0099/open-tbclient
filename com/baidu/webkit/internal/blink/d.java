package com.baidu.webkit.internal.blink;

import android.content.Context;
import android.os.Handler;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public final class d {
    public a a;
    public b b;
    public WebViewFactory.WebKitUnzipCallback c = null;
    public Handler d;
    private static d f = null;
    public static final Object e = new Object();
    private static final Object g = new Object();

    /* loaded from: classes9.dex */
    public static class a {
        Context b;
        String a = null;
        private boolean e = false;
        String c = null;
        public String d = null;

        public final synchronized void a(boolean z) {
            if (z != this.e) {
                this.e = z;
            }
            if (this.e) {
                this.c = this.b.getFilesDir() == null ? null : this.b.getApplicationInfo().nativeLibraryDir != null ? this.b.getApplicationInfo().nativeLibraryDir + "/libzeuswebviewchromium.so" : this.b.getFilesDir().getParent() + "/lib/libzeuswebviewchromium.so";
                this.d = this.a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
        }

        public final synchronized boolean a() {
            return this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends Thread {
        boolean a = false;
        private Context c;

        public b(Context context) {
            this.c = null;
            this.c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.a = true;
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
                if (this.c == null || !SevenZipUtils.getInstance().prepare(this.c, d.this.a.c, d.this.a.d)) {
                    LoadErrorCode.getInstance().trace("502:" + (this.c == null));
                    a();
                    return;
                }
                ZeusPerformanceTiming.unzipStart();
                SevenZipUtils.getInstance().hook(true);
                SevenZipUtils.getInstance().unzipWithMeta(d.this.a.c, d.this.a.d);
                Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                this.a = true;
                int errorCode = SevenZipUtils.getInstance().getErrorCode();
                if (errorCode != 0) {
                    LoadErrorCode.getInstance().set(100, "res=" + errorCode);
                }
                Thread thread = new Thread(new f(this));
                thread.setName("T7@BlinkUnzip");
                thread.start();
                ZeusPerformanceTiming.unzipEnd();
            } catch (Throwable th) {
                a();
            }
        }
    }

    private d(Context context) {
        this.a = null;
        this.a = new a();
        a aVar = this.a;
        try {
            aVar.b = context.getApplicationContext();
            aVar.a = aVar.b.getFilesDir().toString();
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
        if (this.b.isAlive() || this.b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.b.start();
    }

    public final void a() {
        synchronized (e) {
            if (this.b == null || this.a == null) {
                return;
            }
            d();
        }
    }

    public final void b() throws Exception {
        synchronized (e) {
            try {
                if (!this.a.a() || this.b == null) {
                    return;
                }
                d();
                this.b.join(15000L);
                if (this.b.a) {
                    this.b = null;
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
