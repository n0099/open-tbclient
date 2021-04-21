package com.baidu.webkit.logsdk.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f26669c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f26670d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f26671e;

    public c(b bVar, String str, String str2, long j, String str3) {
        this.f26671e = bVar;
        this.f26667a = str;
        this.f26668b = str2;
        this.f26669c = j;
        this.f26670d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap concurrentHashMap;
        com.baidu.webkit.logsdk.c.c h2 = this.f26671e.h();
        String str = this.f26667a;
        String str2 = this.f26668b;
        long j = this.f26669c;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = " + str);
        com.baidu.webkit.logsdk.b.a a2 = b.a().e().a(str);
        int i = a2.f26680b;
        if (i == 1) {
            if (com.baidu.webkit.logsdk.a.f26650b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str2);
            }
            String a3 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a3)) {
                h2.f26698a.add(new com.baidu.webkit.logsdk.upload.a(a2, a3));
                com.baidu.webkit.logsdk.c.c.a(a2);
                if ("frame_app".equals(a2.f26679a) && "app_pause".equals(str2)) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                    h2.a();
                }
            }
        } else if (i == 2) {
            if (com.baidu.webkit.logsdk.a.f26649a) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str2);
            }
            String a4 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a4)) {
                com.baidu.webkit.logsdk.c.a a5 = h2.a(a2.f26679a);
                int a6 = a5.a(a4);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = " + a6);
                long j2 = (long) a6;
                b.a().e();
                if (j2 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                    h2.f26698a.add(new com.baidu.webkit.logsdk.upload.a(a2, a5.a()));
                    a5.f26694b.clear();
                    h2.a(2);
                    com.baidu.webkit.logsdk.c.c.a(a2);
                }
            }
        } else if (i == 3) {
            if (com.baidu.webkit.logsdk.a.f26649a) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str2);
            }
            String a7 = com.baidu.webkit.logsdk.c.c.a(str2, j);
            if (!TextUtils.isEmpty(a7)) {
                com.baidu.webkit.logsdk.c.a a8 = h2.a(a2.f26679a);
                if (a8.a(a7) >= com.baidu.webkit.logsdk.d.a.f26704a) {
                    b a9 = b.a();
                    e eVar = new e(a9, a8);
                    Handler handler = a9.f26663c;
                    if (handler != null) {
                        Message obtainMessage = handler.obtainMessage(4);
                        obtainMessage.obj = eVar;
                        a9.f26663c.sendMessage(obtainMessage);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.f26670d)) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + this.f26670d);
        concurrentHashMap = this.f26671e.f26665f;
        concurrentHashMap.remove(this.f26670d);
    }
}
