package com.baidu.webkit.logsdk.a;

import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ String d;
    final /* synthetic */ b e;

    public c(b bVar, String str, String str2, long j, String str3) {
        this.e = bVar;
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap concurrentHashMap;
        com.baidu.webkit.logsdk.c.c h = this.e.h();
        String str = this.a;
        String str2 = this.b;
        long j = this.c;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = " + str);
        com.baidu.webkit.logsdk.b.a b = b.a().e().b(str);
        switch (b.b) {
            case 1:
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str2);
                }
                String a = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a)) {
                    h.a.add(new com.baidu.webkit.logsdk.upload.a(b, a));
                    h.a(1);
                    com.baidu.webkit.logsdk.c.c.a(b);
                    if ("frame_app".equals(b.a) && "app_pause".equals(str2)) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                        h.a();
                        break;
                    }
                }
                break;
            case 2:
                if (com.baidu.webkit.logsdk.a.a) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str2);
                }
                String a2 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a2)) {
                    com.baidu.webkit.logsdk.c.a a3 = h.a(b.a);
                    int a4 = a3.a(a2);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = " + a4);
                    long j2 = a4;
                    b.a().e();
                    if (j2 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                        h.a.add(new com.baidu.webkit.logsdk.upload.a(b, a3.a()));
                        a3.b.clear();
                        h.a(2);
                        com.baidu.webkit.logsdk.c.c.a(b);
                        break;
                    }
                }
                break;
            case 3:
                if (com.baidu.webkit.logsdk.a.a) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str2);
                }
                String a5 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a5)) {
                    com.baidu.webkit.logsdk.c.a a6 = h.a(b.a);
                    if (a6.a(a5) >= com.baidu.webkit.logsdk.d.a.a) {
                        b a7 = b.a();
                        e eVar = new e(a7, a6);
                        if (a7.c != null) {
                            Message obtainMessage = a7.c.obtainMessage(4);
                            obtainMessage.obj = eVar;
                            a7.c.sendMessage(obtainMessage);
                            break;
                        }
                    }
                }
                break;
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + this.d);
        concurrentHashMap = this.e.f;
        concurrentHashMap.remove(this.d);
    }
}
