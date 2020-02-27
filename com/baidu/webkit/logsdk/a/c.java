package com.baidu.webkit.logsdk.a;

import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
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
        com.baidu.webkit.logsdk.b.a a = b.a().e().a(str);
        switch (a.b) {
            case 1:
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str2);
                }
                String a2 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a2)) {
                    h.a.add(new com.baidu.webkit.logsdk.upload.a(a, a2));
                    h.a(1);
                    com.baidu.webkit.logsdk.c.c.a(a);
                    if ("frame_app".equals(a.a) && "app_pause".equals(str2)) {
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
                String a3 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a3)) {
                    com.baidu.webkit.logsdk.c.a a4 = h.a(a.a);
                    int a5 = a4.a(a3);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = " + a5);
                    long j2 = a5;
                    b.a().e();
                    if (j2 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                        h.a.add(new com.baidu.webkit.logsdk.upload.a(a, a4.a()));
                        a4.b.clear();
                        h.a(2);
                        com.baidu.webkit.logsdk.c.c.a(a);
                        break;
                    }
                }
                break;
            case 3:
                if (com.baidu.webkit.logsdk.a.a) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str2);
                }
                String a6 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a6)) {
                    com.baidu.webkit.logsdk.c.a a7 = h.a(a.a);
                    if (a7.a(a6) >= com.baidu.webkit.logsdk.d.a.a) {
                        b a8 = b.a();
                        e eVar = new e(a8, a7);
                        if (a8.c != null) {
                            Message obtainMessage = a8.c.obtainMessage(4);
                            obtainMessage.obj = eVar;
                            a8.c.sendMessage(obtainMessage);
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
