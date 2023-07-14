package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.webkit.logsdk.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements Handler.Callback {
    @SuppressLint({"StaticFieldLeak"})
    public static b d;
    public static final List<Message> m = new ArrayList();
    public c a;
    public Handler b;
    public Context c;
    public boolean e;
    public boolean f;
    public com.baidu.webkit.logsdk.b g;
    public HandlerThread h;
    public com.baidu.webkit.logsdk.b.b i;
    public com.baidu.webkit.logsdk.upload.b j;
    public a k;
    public com.baidu.webkit.logsdk.c.c l;
    public ConcurrentHashMap<String, String> n = new ConcurrentHashMap<>();

    public b() {
        HandlerThread handlerThread = new HandlerThread("BdLogSDK");
        this.h = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.h.getLooper(), this);
    }

    public static b a() {
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
        }
        return d;
    }

    public static Context d() {
        if (a().c != null) {
            return a().c;
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
        if (!this.e) {
            com.baidu.webkit.logsdk.c.c h = h();
            boolean z2 = h.a.isEmpty() && h.c.isEmpty();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = ".concat(String.valueOf(z2)));
            if (z2 && f().a() && this.n.isEmpty()) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = ".concat(String.valueOf(z)));
                if (z) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                    if (d != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.h.quitSafely();
                        } else {
                            this.h.quit();
                        }
                        this.f = false;
                        this.c = null;
                        d = null;
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
            this.b.sendMessage(message);
        }
    }

    public final void a(long j) {
        if (i()) {
            return;
        }
        this.b.sendEmptyMessageDelayed(3, j);
    }

    public final void a(final com.baidu.webkit.logsdk.upload.a aVar, final long j, final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.baidu.webkit.logsdk.c.c h = b.this.h();
                com.baidu.webkit.logsdk.upload.a aVar2 = aVar;
                long j2 = j;
                boolean z2 = z;
                int i = aVar2.e.b;
                String str = aVar2.h;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = ".concat(String.valueOf(str)));
                String l = (i == 1 || i == 2) ? Long.toString(j2) : i == 3 ? "upload" : null;
                if (!TextUtils.isEmpty(l)) {
                    String c = com.baidu.webkit.logsdk.d.c.c(aVar2.e.a, l);
                    String b = com.baidu.webkit.logsdk.d.c.b(c);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = ".concat(String.valueOf(b)));
                    StringBuilder sb = new StringBuilder();
                    int i2 = aVar2.b;
                    if (z2) {
                        i2++;
                    } else if (c.equals(str)) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                        return;
                    }
                    sb.append(i2);
                    sb.append("\r\n");
                    sb.append(aVar2.f);
                    sb.append("\r\n");
                    sb.append(aVar2.i);
                    sb.append("\r\n");
                    sb.append(aVar2.a);
                    com.baidu.webkit.logsdk.d.c.b(b, sb.toString());
                    if (!TextUtils.isEmpty(str)) {
                        b.a().h().b(str);
                        if (i != 3) {
                            new File(com.baidu.webkit.logsdk.d.c.b(str)).delete();
                        }
                    }
                    try {
                        h.c();
                    } catch (Exception e) {
                        com.baidu.webkit.logsdk.d.c.a(e);
                    }
                }
                b.a().f().a(aVar2.d);
            }
        };
        Handler handler = this.b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(4);
            obtainMessage.obj = runnable;
            this.b.sendMessage(obtainMessage);
        }
    }

    public final void a(final String str, final String str2, final long j) {
        final String c = com.baidu.webkit.logsdk.d.c.c(str2 + j);
        if (!TextUtils.isEmpty(c)) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog put key = ".concat(String.valueOf(c)));
            this.n.put(c, c);
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.baidu.webkit.logsdk.c.c h = b.this.h();
                String str3 = str;
                String str4 = str2;
                long j2 = j;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = ".concat(String.valueOf(str3)));
                com.baidu.webkit.logsdk.b.a a = b.a().e().a(str3);
                int i = a.b;
                if (i == 1) {
                    if (com.baidu.webkit.logsdk.a.b) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str4);
                    }
                    String a2 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a2)) {
                        h.a.add(new com.baidu.webkit.logsdk.upload.a(a, a2));
                        com.baidu.webkit.logsdk.c.c.a(a);
                        if ("frame_app".equals(a.a) && "app_pause".equals(str4)) {
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                            if (!h.b.isEmpty()) {
                                for (String str5 : h.b.keySet()) {
                                    com.baidu.webkit.logsdk.c.a aVar = h.b.get(str5);
                                    if (!aVar.b.isEmpty()) {
                                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor destroy type = ".concat(String.valueOf(str5)));
                                        com.baidu.webkit.logsdk.b.a a3 = b.a().e().a(str5);
                                        int i2 = a3.b;
                                        if (i2 == 2) {
                                            h.a.add(new com.baidu.webkit.logsdk.upload.a(a3, aVar.a()));
                                            aVar.b.clear();
                                        } else if (i2 == 3) {
                                            h.c(com.baidu.webkit.logsdk.d.c.c(aVar.a, "cache"));
                                            h.d.a(aVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i == 2) {
                    if (com.baidu.webkit.logsdk.a.a) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str4);
                    }
                    String a4 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a4)) {
                        com.baidu.webkit.logsdk.c.a a5 = h.a(a.a);
                        int a6 = a5.a(a4);
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = ".concat(String.valueOf(a6)));
                        long j3 = a6;
                        b.a().e();
                        if (j3 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                            h.a.add(new com.baidu.webkit.logsdk.upload.a(a, a5.a()));
                            a5.b.clear();
                            h.a(2);
                            com.baidu.webkit.logsdk.c.c.a(a);
                        }
                    }
                } else if (i == 3) {
                    if (com.baidu.webkit.logsdk.a.a) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str4);
                    }
                    String a7 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                    if (!TextUtils.isEmpty(a7)) {
                        final com.baidu.webkit.logsdk.c.a a8 = h.a(a.a);
                        if (a8.a(a7) >= com.baidu.webkit.logsdk.d.a.a) {
                            final b a9 = b.a();
                            Runnable runnable2 = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    b.this.h().b().a(a8);
                                }
                            };
                            Handler handler = a9.b;
                            if (handler != null) {
                                Message obtainMessage = handler.obtainMessage(4);
                                obtainMessage.obj = runnable2;
                                a9.b.sendMessage(obtainMessage);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(c)) {
                    return;
                }
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + c);
                b.this.n.remove(c);
            }
        };
        Handler handler = this.b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = runnable;
            if (b()) {
                this.b.sendMessage(obtainMessage);
                return;
            }
            synchronized (m) {
                m.add(obtainMessage);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012e A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014a A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015f A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0172 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0187 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:12:0x004f, B:14:0x0062, B:16:0x006c, B:20:0x0077, B:22:0x007c, B:24:0x0082, B:26:0x008c, B:30:0x0096, B:31:0x0099, B:33:0x00a9, B:35:0x00b3, B:40:0x00cb, B:41:0x00d1, B:43:0x00d7, B:45:0x00e1, B:50:0x00f8, B:51:0x00fc, B:53:0x0102, B:55:0x010c, B:60:0x0124, B:61:0x0128, B:63:0x012e, B:65:0x0138, B:68:0x0140, B:69:0x0144, B:71:0x014a, B:73:0x0154, B:74:0x0159, B:76:0x015f, B:78:0x0169, B:79:0x016c, B:81:0x0172, B:83:0x017c, B:84:0x0181, B:86:0x0187, B:88:0x0191, B:89:0x0194), top: B:116:0x004f, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        com.baidu.webkit.logsdk.b.b e;
        b a;
        String a2;
        JSONObject jSONObject;
        SharedPreferences.Editor edit;
        boolean z;
        b bVar2 = this;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
        if (!bVar2.e) {
            if (context == null) {
                throw new RuntimeException("LogSDK init: Context null!");
            }
            if (bVar == null) {
                throw new RuntimeException("LogSDK init: ILogSDKListener null!");
            }
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
            try {
                bVar2.a = null;
                bVar2.g = bVar;
                bVar2.c = context;
                e = e();
                String b = bVar.b();
                if (TextUtils.isEmpty(b)) {
                    b = "https://browserkernel.baidu.com/log/config_browser.json";
                }
                e.a = b;
            } catch (Exception e2) {
                e = e2;
            }
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
                                com.baidu.webkit.logsdk.b.b.b = string7;
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
                                com.baidu.webkit.logsdk.b.b.c = string9;
                            }
                        }
                        if (jSONObject.has("f3")) {
                            String string10 = jSONObject.getString("f3");
                            if (!TextUtils.isEmpty(string10)) {
                                edit.putString("f3", string10);
                            }
                        }
                        e.a(jSONObject, edit);
                        e.a(jSONObject, z, edit);
                        edit.apply();
                        a = a();
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                        a.f = true;
                        if (1 != 0 && a.b != null) {
                            a.b.sendMessage(a.b.obtainMessage(2));
                        }
                        com.baidu.webkit.logsdk.upload.b f = f();
                        a2 = bVar.a();
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "https://browserkernel.baidu.com/logstat/stat/log";
                        }
                        f.a = a2;
                        g();
                        h();
                        bVar2 = this;
                        bVar2.e = true;
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
                e.a(jSONObject, edit);
                e.a(jSONObject, z, edit);
                edit.apply();
                a = a();
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                a.f = true;
                if (1 != 0) {
                    a.b.sendMessage(a.b.obtainMessage(2));
                }
                com.baidu.webkit.logsdk.upload.b f2 = f();
                a2 = bVar.a();
                if (TextUtils.isEmpty(a2)) {
                }
                f2.a = a2;
                g();
                h();
                bVar2 = this;
                bVar2.e = true;
            } catch (Exception e4) {
                e = e4;
                bVar2 = this;
                com.baidu.webkit.logsdk.d.c.a(e);
                return bVar2.e;
            }
        }
        return bVar2.e;
    }

    public final boolean b() {
        return this.e && this.g != null && this.c != null && this.f;
    }

    public final com.baidu.webkit.logsdk.b c() {
        com.baidu.webkit.logsdk.b bVar = this.g;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("LogSDK getListener null! please init first.");
    }

    public final com.baidu.webkit.logsdk.b.b e() {
        if (this.i == null) {
            this.i = new com.baidu.webkit.logsdk.b.b();
        }
        return this.i;
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
            this.k = new a(this.c);
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
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                j();
                h().a(3);
                h().b().a();
                Runnable runnable = new Runnable() { // from class: com.baidu.webkit.logsdk.a.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.b()) {
                            com.baidu.webkit.logsdk.c.b b = b.this.h().b();
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
                            for (String str : b.a.keySet()) {
                                if (b.a.get(str).booleanValue()) {
                                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: ".concat(String.valueOf(str)));
                                    try {
                                        String c = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c));
                                        if (file.exists()) {
                                            com.baidu.webkit.logsdk.upload.a a = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                                            if (a != null) {
                                                a.h = c;
                                                b.b.c(c);
                                                b.b.a(a);
                                            }
                                        } else {
                                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createFromCache: ".concat(String.valueOf(str)));
                                            b.a(str);
                                        }
                                    } catch (Exception e) {
                                        com.baidu.webkit.logsdk.d.c.a(e);
                                    }
                                }
                            }
                        }
                    }
                };
                Handler handler = this.b;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage(5);
                    obtainMessage.obj = runnable;
                    this.b.sendMessageDelayed(obtainMessage, 3000L);
                }
            } else if (i != 3) {
                if (i != 4) {
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
