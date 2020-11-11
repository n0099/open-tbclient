package com.baidu.webkit.logsdk.a;

import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3951a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ String d;
    final /* synthetic */ b e;

    public c(b bVar, String str, String str2, long j, String str3) {
        this.e = bVar;
        this.f3951a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap concurrentHashMap;
        com.baidu.webkit.logsdk.c.c h = this.e.h();
        String str = this.f3951a;
        String str2 = this.b;
        long j = this.c;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = " + str);
        com.baidu.webkit.logsdk.b.a a2 = b.a().e().a(str);
        switch (a2.b) {
            case 1:
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str2);
                }
                String a3 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a3)) {
                    h.f3960a.add(new com.baidu.webkit.logsdk.upload.a(a2, a3));
                    com.baidu.webkit.logsdk.c.c.a(a2);
                    if ("frame_app".equals(a2.f3955a) && "app_pause".equals(str2)) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                        h.a();
                        break;
                    }
                }
                break;
            case 2:
                if (com.baidu.webkit.logsdk.a.f3948a) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str2);
                }
                String a4 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a4)) {
                    com.baidu.webkit.logsdk.c.a a5 = h.a(a2.f3955a);
                    int a6 = a5.a(a4);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = " + a6);
                    long j2 = a6;
                    b.a().e();
                    if (j2 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                        h.f3960a.add(new com.baidu.webkit.logsdk.upload.a(a2, a5.a()));
                        a5.b.clear();
                        h.a(2);
                        com.baidu.webkit.logsdk.c.c.a(a2);
                        break;
                    }
                }
                break;
            case 3:
                if (com.baidu.webkit.logsdk.a.f3948a) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str2);
                }
                String a7 = com.baidu.webkit.logsdk.c.c.a(str2, j);
                if (!TextUtils.isEmpty(a7)) {
                    com.baidu.webkit.logsdk.c.a a8 = h.a(a2.f3955a);
                    if (a8.a(a7) >= com.baidu.webkit.logsdk.d.a.f3962a) {
                        b a9 = b.a();
                        e eVar = new e(a9, a8);
                        if (a9.c != null) {
                            Message obtainMessage = a9.c.obtainMessage(4);
                            obtainMessage.obj = eVar;
                            a9.c.sendMessage(obtainMessage);
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
