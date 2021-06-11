package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.webkit.logsdk.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements Handler.Callback {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static b f26745d;
    public static final List<Message> m = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public c f26746a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f26747b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26748c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26749e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26750f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b f26751g;

    /* renamed from: h  reason: collision with root package name */
    public HandlerThread f26752h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.b f26753i;
    public com.baidu.webkit.logsdk.upload.b j;
    public a k;
    public com.baidu.webkit.logsdk.c.c l;
    public ConcurrentHashMap<String, String> n = new ConcurrentHashMap<>();

    public b() {
        HandlerThread handlerThread = new HandlerThread("BdLogSDK");
        this.f26752h = handlerThread;
        handlerThread.start();
        this.f26747b = new Handler(this.f26752h.getLooper(), this);
    }

    public static b a() {
        synchronized (b.class) {
            if (f26745d == null) {
                f26745d = new b();
            }
        }
        return f26745d;
    }

    public static Context d() {
        if (a().f26748c != null) {
            return a().f26748c;
        }
        throw new RuntimeException("LogSDK getContext null! please init first.");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[Catch: all -> 0x0079, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x0013, B:11:0x001e, B:13:0x002f, B:15:0x0039, B:19:0x0043, B:21:0x0054, B:23:0x0060, B:25:0x0066, B:27:0x0071, B:26:0x006c), top: B:33:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean i() {
        boolean z;
        z = true;
        if (!this.f26749e) {
            com.baidu.webkit.logsdk.c.c h2 = h();
            boolean z2 = h2.f26785a.isEmpty() && h2.f26787c.isEmpty();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = ".concat(String.valueOf(z2)));
            if (z2 && f().a() && this.n.isEmpty()) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = ".concat(String.valueOf(z)));
                if (z) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                    if (f26745d != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.f26752h.quitSafely();
                        } else {
                            this.f26752h.quit();
                        }
                        this.f26750f = false;
                        this.f26748c = null;
                        f26745d = null;
                    }
                }
            }
        }
        z = false;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = ".concat(String.valueOf(z)));
        if (z) {
        }
        return z;
    }

    private void j() {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "sendPendingMessages");
        while (true) {
            Message message = null;
            synchronized (m) {
                if (m.size() > 0) {
                    message = m.get(0);
                    m.remove(0);
                }
            }
            if (message == null) {
                return;
            }
            this.f26747b.sendMessage(message);
        }
    }

    public final void a(long j) {
        if (i()) {
            return;
        }
        this.f26747b.sendEmptyMessageDelayed(3, j);
    }

    public final void a(final com.baidu.webkit.logsdk.upload.a aVar, final long j, final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.baidu.webkit.logsdk.c.c h2 = b.this.h();
                com.baidu.webkit.logsdk.upload.a aVar2 = aVar;
                long j2 = j;
                boolean z2 = z;
                int i2 = aVar2.f26801e.f26767b;
                String str = aVar2.f26804h;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = ".concat(String.valueOf(str)));
                String l = (i2 == 1 || i2 == 2) ? Long.toString(j2) : i2 == 3 ? "upload" : null;
                if (!TextUtils.isEmpty(l)) {
                    String c2 = com.baidu.webkit.logsdk.d.c.c(aVar2.f26801e.f26766a, l);
                    String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = ".concat(String.valueOf(b2)));
                    StringBuilder sb = new StringBuilder();
                    int i3 = aVar2.f26798b;
                    if (z2) {
                        i3++;
                    } else if (c2.equals(str)) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                        return;
                    }
                    sb.append(i3);
                    sb.append(Part.CRLF);
                    sb.append(aVar2.f26802f);
                    sb.append(Part.CRLF);
                    sb.append(aVar2.f26805i);
                    sb.append(Part.CRLF);
                    sb.append(aVar2.f26797a);
                    com.baidu.webkit.logsdk.d.c.b(b2, sb.toString());
                    if (!TextUtils.isEmpty(str)) {
                        b.a().h().b(str);
                        if (i2 != 3) {
                            new File(com.baidu.webkit.logsdk.d.c.b(str)).delete();
                        }
                    }
                    try {
                        h2.c();
                    } catch (Exception e2) {
                        com.baidu.webkit.logsdk.d.c.a(e2);
                    }
                }
                b.a().f().a(aVar2.f26800d);
            }
        };
        Handler handler = this.f26747b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(4);
            obtainMessage.obj = runnable;
            this.f26747b.sendMessage(obtainMessage);
        }
    }

    public final void a(final String str, final String str2, final long j) {
        final String c2 = com.baidu.webkit.logsdk.d.c.c(str2 + j);
        if (!TextUtils.isEmpty(c2)) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog put key = ".concat(String.valueOf(c2)));
            this.n.put(c2, c2);
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.baidu.webkit.logsdk.c.c h2 = b.this.h();
                String str3 = str;
                String str4 = str2;
                long j2 = j;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = ".concat(String.valueOf(str3)));
                com.baidu.webkit.logsdk.b.a a2 = b.a().e().a(str3);
                int i2 = a2.f26767b;
                if (i2 == 1) {
                    if (com.baidu.webkit.logsdk.a.f26735b) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str4);
                    }
                    String a3 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a3)) {
                        h2.f26785a.add(new com.baidu.webkit.logsdk.upload.a(a2, a3));
                        com.baidu.webkit.logsdk.c.c.a(a2);
                        if ("frame_app".equals(a2.f26766a) && "app_pause".equals(str4)) {
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                            if (!h2.f26786b.isEmpty()) {
                                for (String str5 : h2.f26786b.keySet()) {
                                    com.baidu.webkit.logsdk.c.a aVar = h2.f26786b.get(str5);
                                    if (!aVar.f26781b.isEmpty()) {
                                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor destroy type = ".concat(String.valueOf(str5)));
                                        com.baidu.webkit.logsdk.b.a a4 = b.a().e().a(str5);
                                        int i3 = a4.f26767b;
                                        if (i3 == 2) {
                                            h2.f26785a.add(new com.baidu.webkit.logsdk.upload.a(a4, aVar.a()));
                                            aVar.f26781b.clear();
                                        } else if (i3 == 3) {
                                            h2.c(com.baidu.webkit.logsdk.d.c.c(aVar.f26780a, SapiOptions.KEY_CACHE));
                                            h2.f26788d.a(aVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 == 2) {
                    if (com.baidu.webkit.logsdk.a.f26734a) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str4);
                    }
                    String a5 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a5)) {
                        com.baidu.webkit.logsdk.c.a a6 = h2.a(a2.f26766a);
                        int a7 = a6.a(a5);
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = ".concat(String.valueOf(a7)));
                        long j3 = a7;
                        b.a().e();
                        if (j3 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                            h2.f26785a.add(new com.baidu.webkit.logsdk.upload.a(a2, a6.a()));
                            a6.f26781b.clear();
                            h2.a(2);
                            com.baidu.webkit.logsdk.c.c.a(a2);
                        }
                    }
                } else if (i2 == 3) {
                    if (com.baidu.webkit.logsdk.a.f26734a) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str4);
                    }
                    String a8 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a8)) {
                        final com.baidu.webkit.logsdk.c.a a9 = h2.a(a2.f26766a);
                        if (a9.a(a8) >= com.baidu.webkit.logsdk.d.a.f26791a) {
                            final b a10 = b.a();
                            Runnable runnable2 = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    b.this.h().b().a(a9);
                                }
                            };
                            Handler handler = a10.f26747b;
                            if (handler != null) {
                                Message obtainMessage = handler.obtainMessage(4);
                                obtainMessage.obj = runnable2;
                                a10.f26747b.sendMessage(obtainMessage);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(c2)) {
                    return;
                }
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + c2);
                b.this.n.remove(c2);
            }
        };
        Handler handler = this.f26747b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = runnable;
            if (b()) {
                this.f26747b.sendMessage(obtainMessage);
                return;
            }
            synchronized (m) {
                m.add(obtainMessage);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6 A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4 A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012b A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147 A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015c A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0184 A[Catch: Exception -> 0x019b, TryCatch #1 {Exception -> 0x019b, blocks: (B:12:0x004c, B:14:0x005f, B:16:0x0069, B:20:0x0074, B:22:0x0079, B:24:0x007f, B:26:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a6, B:35:0x00b0, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:45:0x00de, B:50:0x00f5, B:51:0x00f9, B:53:0x00ff, B:55:0x0109, B:60:0x0121, B:61:0x0125, B:63:0x012b, B:65:0x0135, B:68:0x013d, B:69:0x0141, B:71:0x0147, B:73:0x0151, B:74:0x0156, B:76:0x015c, B:78:0x0166, B:79:0x0169, B:81:0x016f, B:83:0x0179, B:84:0x017e, B:86:0x0184, B:88:0x018e, B:89:0x0191), top: B:116:0x004c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        b a2;
        String a3;
        JSONObject jSONObject;
        SharedPreferences.Editor edit;
        boolean z;
        b bVar2 = this;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
        if (!bVar2.f26749e) {
            if (context == null) {
                throw new RuntimeException("LogSDK init: Context null!");
            }
            if (bVar == null) {
                throw new RuntimeException("LogSDK init: ILogSDKListener null!");
            }
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
            try {
                bVar2.f26746a = null;
                bVar2.f26751g = bVar;
                bVar2.f26748c = context;
                com.baidu.webkit.logsdk.b.b e2 = e();
                String b2 = bVar.b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = "https://browserkernel.baidu.com/log/config_browser.json";
                }
                e2.f26773a = b2;
                try {
                    try {
                        jSONObject = new JSONObject("{    \"master\": \"1\",    \"net_level\": 3,    \"timeout\":\"30\",    \"filesize\":\"10\",    \"timeup\":\"1\",    \"threshold\":\"3\",    \"f1\":\"1_0\",    \"f2\":\"0_1\",    \"f3\":\"2_3\",    \"publickey\":\"test\",     \"array\": [        {\"log_type\": \"frame_event\", \"master\": \"0\", \"log_level\": 3},        {\"log_type\": \"frame_pv\", \"master\": \"0\", \"log_level\": 2},        {\"log_type\": \"frame_record\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_anr\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_app\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_reportinfo\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_t5timing\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_safe\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_sailor\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_sailorStat\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_whiteScreen\", \"master\": \"0\", \"log_level\": 1}    ],    \"params\": {        \"kernel\": {\"body\":[],                   \"url\": [] }    }}");
                        edit = com.baidu.webkit.logsdk.b.b.a().edit();
                    } catch (Exception e3) {
                        com.baidu.webkit.logsdk.d.c.a(e3);
                    }
                    if (jSONObject.has("master")) {
                        String string = jSONObject.getString("master");
                        if (!TextUtils.isEmpty(string)) {
                            z = !string.equals("0");
                            edit.putBoolean("master", z);
                            if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                                String string2 = jSONObject.getString(DpStatConstants.KEY_NET_LEVEL);
                                if (!TextUtils.isEmpty(string2)) {
                                    int parseInt = Integer.parseInt(string2);
                                    edit.putInt(DpStatConstants.KEY_NET_LEVEL, (parseInt < 0 || parseInt > 3) ? 3 : 3);
                                }
                            }
                            if (jSONObject.has("timeout")) {
                                String string3 = jSONObject.getString("timeout");
                                if (!TextUtils.isEmpty(string3)) {
                                    double parseDouble = Double.parseDouble(string3) * 8.64E7d;
                                    edit.putLong("timeout", (long) ((parseDouble < 3.456E8d || parseDouble > 2.592E9d) ? 6.048E8d : 6.048E8d));
                                }
                            }
                            if (jSONObject.has("filesize")) {
                                String string4 = jSONObject.getString("filesize");
                                if (!TextUtils.isEmpty(string4)) {
                                    double parseDouble2 = Double.parseDouble(string4) * 1024.0d;
                                    edit.putLong("filesize", (long) ((parseDouble2 < 1024.0d || parseDouble2 > 307200.0d) ? 10240.0d : 10240.0d));
                                }
                            }
                            if (jSONObject.has("timeup")) {
                                String string5 = jSONObject.getString("timeup");
                                if (!TextUtils.isEmpty(string5)) {
                                    double parseDouble3 = Double.parseDouble(string5) * 8.64E7d;
                                    edit.putLong("timeup", (long) ((parseDouble3 < 8.64E7d || parseDouble3 > 3.456E8d) ? 1.728E8d : 1.728E8d));
                                }
                            }
                            if (jSONObject.has("threshold")) {
                                String string6 = jSONObject.getString("threshold");
                                if (!TextUtils.isEmpty(string6)) {
                                    int parseInt2 = Integer.parseInt(string6);
                                    if (parseInt2 <= 0) {
                                        parseInt2 = 10;
                                    }
                                    edit.putLong("threshold", parseInt2);
                                }
                            }
                            if (jSONObject.has("publickey")) {
                                String string7 = jSONObject.getString("publickey");
                                if (!TextUtils.isEmpty(string7)) {
                                    edit.putString("publickey", string7);
                                    com.baidu.webkit.logsdk.b.b.f26771b = string7;
                                }
                            }
                            if (jSONObject.has("f1")) {
                                String string8 = jSONObject.getString("f1");
                                if (!TextUtils.isEmpty(string8)) {
                                    edit.putString("f1", string8);
                                }
                            }
                            if (jSONObject.has("f2")) {
                                String string9 = jSONObject.getString("f2");
                                if (!TextUtils.isEmpty(string9)) {
                                    edit.putString("f2", string9);
                                    com.baidu.webkit.logsdk.b.b.f26772c = string9;
                                }
                            }
                            if (jSONObject.has("f3")) {
                                String string10 = jSONObject.getString("f3");
                                if (!TextUtils.isEmpty(string10)) {
                                    edit.putString("f3", string10);
                                }
                            }
                            e2.a(jSONObject, edit);
                            e2.a(jSONObject, z, edit);
                            edit.apply();
                            a2 = a();
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                            a2.f26750f = true;
                            if (1 != 0 && a2.f26747b != null) {
                                a2.f26747b.sendMessage(a2.f26747b.obtainMessage(2));
                            }
                            com.baidu.webkit.logsdk.upload.b f2 = f();
                            a3 = bVar.a();
                            if (TextUtils.isEmpty(a3)) {
                                a3 = "https://browserkernel.baidu.com/logstat/stat/log";
                            }
                            f2.f26806a = a3;
                            g();
                            h();
                            bVar2 = this;
                            bVar2.f26749e = true;
                        }
                    }
                    z = true;
                    if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                    }
                    if (jSONObject.has("timeout")) {
                    }
                    if (jSONObject.has("filesize")) {
                    }
                    if (jSONObject.has("timeup")) {
                    }
                    if (jSONObject.has("threshold")) {
                    }
                    if (jSONObject.has("publickey")) {
                    }
                    if (jSONObject.has("f1")) {
                    }
                    if (jSONObject.has("f2")) {
                    }
                    if (jSONObject.has("f3")) {
                    }
                    e2.a(jSONObject, edit);
                    e2.a(jSONObject, z, edit);
                    edit.apply();
                    a2 = a();
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                    a2.f26750f = true;
                    if (1 != 0) {
                        a2.f26747b.sendMessage(a2.f26747b.obtainMessage(2));
                    }
                    com.baidu.webkit.logsdk.upload.b f22 = f();
                    a3 = bVar.a();
                    if (TextUtils.isEmpty(a3)) {
                    }
                    f22.f26806a = a3;
                    g();
                    h();
                    bVar2 = this;
                    bVar2.f26749e = true;
                } catch (Exception e4) {
                    e = e4;
                    bVar2 = this;
                    com.baidu.webkit.logsdk.d.c.a(e);
                    return bVar2.f26749e;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return bVar2.f26749e;
    }

    public final boolean b() {
        return this.f26749e && this.f26751g != null && this.f26748c != null && this.f26750f;
    }

    public final com.baidu.webkit.logsdk.b c() {
        com.baidu.webkit.logsdk.b bVar = this.f26751g;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("LogSDK getListener null! please init first.");
    }

    public final com.baidu.webkit.logsdk.b.b e() {
        if (this.f26753i == null) {
            this.f26753i = new com.baidu.webkit.logsdk.b.b();
        }
        return this.f26753i;
    }

    public final com.baidu.webkit.logsdk.upload.b f() {
        if (this.j == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "new BdLogUploadWorker");
            this.j = new com.baidu.webkit.logsdk.upload.b();
        }
        return this.j;
    }

    public final a g() {
        if (this.k == null) {
            this.k = new a(this.f26748c);
        }
        return this.k;
    }

    public final com.baidu.webkit.logsdk.c.c h() {
        com.baidu.webkit.logsdk.c.c cVar;
        synchronized (b.class) {
            if (this.l == null) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor getProcessor");
                this.l = new com.baidu.webkit.logsdk.c.c();
            }
            cVar = this.l;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0 != 5) goto L9;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        long j;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleMessage " + message.what);
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                j();
                h().a(3);
                h().b().a();
                Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.b()) {
                            com.baidu.webkit.logsdk.c.b b2 = b.this.h().b();
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
                            for (String str : b2.f26783a.keySet()) {
                                if (b2.f26783a.get(str).booleanValue()) {
                                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: ".concat(String.valueOf(str)));
                                    try {
                                        String c2 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c2));
                                        if (file.exists()) {
                                            com.baidu.webkit.logsdk.upload.a a2 = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                                            if (a2 != null) {
                                                a2.f26804h = c2;
                                                b2.f26784b.c(c2);
                                                b2.f26784b.a(a2);
                                            }
                                        } else {
                                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createFromCache: ".concat(String.valueOf(str)));
                                            b2.a(str);
                                        }
                                    } catch (Exception e2) {
                                        com.baidu.webkit.logsdk.d.c.a(e2);
                                    }
                                }
                            }
                        }
                    }
                };
                Handler handler = this.f26747b;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage(5);
                    obtainMessage.obj = runnable;
                    this.f26747b.sendMessageDelayed(obtainMessage, 3000L);
                }
            } else if (i2 != 3) {
                if (i2 != 4) {
                }
            } else if (h().a()) {
                j = 500;
                a(j);
            }
            return true;
        }
        Object obj = message.obj;
        if (obj instanceof Runnable) {
            ((Runnable) obj).run();
        }
        j = 0;
        a(j);
        return true;
    }
}
