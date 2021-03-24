package com.baidu.webkit.logsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26955a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f26956b;

    public static void a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
        String c2 = com.baidu.webkit.logsdk.d.c.c(str2 + currentTimeMillis);
        if (!TextUtils.isEmpty(c2)) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog put key = " + c2);
            a2.f26971f.put(c2, c2);
        }
        com.baidu.webkit.logsdk.a.c cVar = new com.baidu.webkit.logsdk.a.c(a2, str, str2, currentTimeMillis, c2);
        Handler handler = a2.f26969c;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = cVar;
            if (a2.b()) {
                a2.f26969c.sendMessage(obtainMessage);
                return;
            }
            synchronized (com.baidu.webkit.logsdk.a.b.f26965e) {
                com.baidu.webkit.logsdk.a.b.f26965e.add(obtainMessage);
            }
        }
    }

    public static boolean a(Context context, b bVar) {
        return com.baidu.webkit.logsdk.a.b.a().a(context, bVar);
    }
}
