package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.webkit.logsdk.upload.BdLogNetRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b implements Handler.Callback {
    public static final List<Message> e = new ArrayList();
    @SuppressLint({"StaticFieldLeak"})
    private static b g;
    public com.baidu.webkit.logsdk.c b;
    public Handler c;
    public Context d;
    private com.baidu.webkit.logsdk.b i;
    private com.baidu.webkit.logsdk.b.b k;
    private com.baidu.webkit.logsdk.upload.b l;
    private a m;
    private com.baidu.webkit.logsdk.c.c n;
    private boolean h = false;
    public boolean a = false;
    public ConcurrentHashMap<String, String> f = new ConcurrentHashMap<>();
    private HandlerThread j = new HandlerThread("BdLogSDK");

    private b() {
        this.j.start();
        this.c = new Handler(this.j.getLooper(), this);
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public static Context d() {
        if (a().d == null) {
            throw new RuntimeException("LogSDK getContext null! please init first.");
        }
        return a().d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r6.f.isEmpty() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean i() {
        boolean z = true;
        synchronized (this) {
            if (!this.h) {
                com.baidu.webkit.logsdk.c.c h = h();
                boolean z2 = h.a.isEmpty() && h.b.isEmpty();
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = " + z2);
                if (z2) {
                    if (f().a()) {
                    }
                }
            }
            z = false;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = " + z);
            if (z) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                if (g != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.j.quitSafely();
                    } else {
                        this.j.quit();
                    }
                    this.a = false;
                    this.d = null;
                    g = null;
                }
            }
        }
        return z;
    }

    private void j() {
        Message message;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "sendPendingMessages");
        while (true) {
            synchronized (e) {
                if (e.size() > 0) {
                    message = e.get(0);
                    e.remove(0);
                } else {
                    message = null;
                }
            }
            if (message == null) {
                return;
            }
            this.c.sendMessage(message);
        }
    }

    public final void a(long j) {
        if (i()) {
            return;
        }
        this.c.sendEmptyMessageDelayed(3, j);
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        d dVar = new d(this, aVar, j, z);
        if (this.c != null) {
            Message obtainMessage = this.c.obtainMessage(4);
            obtainMessage.obj = dVar;
            this.c.sendMessage(obtainMessage);
        }
    }

    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
        if (!this.h) {
            if (context == null) {
                throw new RuntimeException("LogSDK init: Context null!");
            }
            if (bVar == null) {
                throw new RuntimeException("LogSDK init: ILogSDKListener null!");
            }
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
            try {
                this.b = null;
                this.i = bVar;
                this.d = context;
                com.baidu.webkit.logsdk.b.b e2 = e();
                String b = bVar.b();
                if (TextUtils.isEmpty(b)) {
                    e2.a = "https://browserkernel.baidu.com/log/config_browser.json";
                } else {
                    e2.a = b;
                }
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogConfigLoader loadFromServer " + e2.a);
                com.baidu.webkit.logsdk.b.c cVar = new com.baidu.webkit.logsdk.b.c(e2);
                if (a().b == null) {
                    BdLogNetRequest.requestConfig(e2.a, cVar);
                }
                com.baidu.webkit.logsdk.upload.b f = f();
                String a = bVar.a();
                if (TextUtils.isEmpty(a)) {
                    f.a = "https://browserkernel.baidu.com/logstat/stat/log";
                } else {
                    f.a = a;
                }
                g();
                h();
                this.h = true;
            } catch (Exception e3) {
                com.baidu.webkit.logsdk.d.c.a(e3);
            }
        }
        return this.h;
    }

    public final boolean b() {
        return this.h && this.i != null && this.d != null && this.a;
    }

    public final com.baidu.webkit.logsdk.b c() {
        if (this.i == null) {
            throw new RuntimeException("LogSDK getListener null! please init first.");
        }
        return this.i;
    }

    public final com.baidu.webkit.logsdk.b.b e() {
        if (this.k == null) {
            this.k = new com.baidu.webkit.logsdk.b.b();
        }
        return this.k;
    }

    public final com.baidu.webkit.logsdk.upload.b f() {
        if (this.l == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "new BdLogUploadWorker");
            this.l = new com.baidu.webkit.logsdk.upload.b();
        }
        return this.l;
    }

    public final a g() {
        if (this.m == null) {
            this.m = new a(this.d);
        }
        return this.m;
    }

    public final com.baidu.webkit.logsdk.c.c h() {
        if (this.n == null) {
            this.n = new com.baidu.webkit.logsdk.c.c();
        }
        return this.n;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleMessage " + message.what);
        switch (message.what) {
            case 1:
            case 4:
            case 5:
                if (message.obj instanceof Runnable) {
                    ((Runnable) message.obj).run();
                }
                a(0L);
                return true;
            case 2:
                j();
                h().a(3);
                h().c().a();
                f fVar = new f(this);
                if (this.c != null) {
                    Message obtainMessage = this.c.obtainMessage(5);
                    obtainMessage.obj = fVar;
                    this.c.sendMessageDelayed(obtainMessage, 3000L);
                    return true;
                }
                return true;
            case 3:
                if (h().b()) {
                    a(500L);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }
}
