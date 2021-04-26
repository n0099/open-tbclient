package com.baidu.webkit.logsdk.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f27477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f27478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f27479c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f27480d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f27481e;

    public c(b bVar, String str, String str2, long j, String str3) {
        this.f27481e = bVar;
        this.f27477a = str;
        this.f27478b = str2;
        this.f27479c = j;
        this.f27480d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap concurrentHashMap;
        com.baidu.webkit.logsdk.c.c h2 = this.f27481e.h();
        String str = this.f27477a;
        String str2 = this.f27478b;
        long j = this.f27479c;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = " + str);
        com.baidu.webkit.logsdk.b.a a2 = b.a().e().a(str);
        int i2 = a2.f27490b;
        if (i2 == 1) {
            if (com.baidu.webkit.logsdk.a.f27458b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str2);
            }
            String a3 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a3)) {
                h2.f27508a.add(new com.baidu.webkit.logsdk.upload.a(a2, a3));
                com.baidu.webkit.logsdk.c.c.a(a2);
                if ("frame_app".equals(a2.f27489a) && "app_pause".equals(str2)) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                    h2.a();
                }
            }
        } else if (i2 == 2) {
            if (com.baidu.webkit.logsdk.a.f27457a) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str2);
            }
            String a4 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a4)) {
                com.baidu.webkit.logsdk.c.a a5 = h2.a(a2.f27489a);
                int a6 = a5.a(a4);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = " + a6);
                long j2 = (long) a6;
                b.a().e();
                if (j2 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                    h2.f27508a.add(new com.baidu.webkit.logsdk.upload.a(a2, a5.a()));
                    a5.f27504b.clear();
                    h2.a(2);
                    com.baidu.webkit.logsdk.c.c.a(a2);
                }
            }
        } else if (i2 == 3) {
            if (com.baidu.webkit.logsdk.a.f27457a) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str2);
            }
            String a7 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a7)) {
                com.baidu.webkit.logsdk.c.a a8 = h2.a(a2.f27489a);
                if (a8.a(a7) >= com.baidu.webkit.logsdk.d.a.f27514a) {
                    b a9 = b.a();
                    e eVar = new e(a9, a8);
                    Handler handler = a9.f27472c;
                    if (handler != null) {
                        Message obtainMessage = handler.obtainMessage(4);
                        obtainMessage.obj = eVar;
                        a9.f27472c.sendMessage(obtainMessage);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.f27480d)) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + this.f27480d);
        concurrentHashMap = this.f27481e.f27474f;
        concurrentHashMap.remove(this.f27480d);
    }
}
