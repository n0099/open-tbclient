package com.baidu.webkit.logsdk;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5984a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5985b;

    public static void a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
        String c = com.baidu.webkit.logsdk.d.c.c(str2 + currentTimeMillis);
        if (!TextUtils.isEmpty(c)) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog put key = " + c);
            a2.f.put(c, c);
        }
        com.baidu.webkit.logsdk.a.c cVar = new com.baidu.webkit.logsdk.a.c(a2, str, str2, currentTimeMillis, c);
        if (a2.c != null) {
            Message obtainMessage = a2.c.obtainMessage(1);
            obtainMessage.obj = cVar;
            if (a2.b()) {
                a2.c.sendMessage(obtainMessage);
                return;
            }
            synchronized (com.baidu.webkit.logsdk.a.b.e) {
                com.baidu.webkit.logsdk.a.b.e.add(obtainMessage);
            }
        }
    }

    public static boolean a(Context context, b bVar) {
        return com.baidu.webkit.logsdk.a.b.a().a(context, bVar);
    }
}
