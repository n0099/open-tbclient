package com.baidu.webkit.logsdk.a;

import java.io.File;
/* loaded from: classes5.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f26678a;

    public f(b bVar) {
        this.f26678a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f26678a.b()) {
            com.baidu.webkit.logsdk.c.b c2 = this.f26678a.h().c();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
            for (String str : c2.f26696a.keySet()) {
                if (c2.f26696a.get(str).booleanValue()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: " + str);
                    try {
                        String c3 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c3));
                        if (file.exists()) {
                            com.baidu.webkit.logsdk.upload.a a2 = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                            if (a2 != null) {
                                a2.f26717h = c3;
                                c2.f26697b.c(c3);
                                c2.f26697b.a(a2);
                            }
                        } else {
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createFromCache: " + str);
                            c2.a(str);
                        }
                    } catch (Exception e2) {
                        com.baidu.webkit.logsdk.d.c.a(e2);
                    }
                }
            }
        }
    }
}
