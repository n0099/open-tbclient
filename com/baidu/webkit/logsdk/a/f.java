package com.baidu.webkit.logsdk.a;

import java.io.File;
/* loaded from: classes11.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f3954a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3954a.b()) {
            com.baidu.webkit.logsdk.c.b c = this.f3954a.h().c();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
            for (String str : c.f3959a.keySet()) {
                if (c.f3959a.get(str).booleanValue()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: " + str);
                    try {
                        String c2 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c2));
                        if (file.exists()) {
                            com.baidu.webkit.logsdk.upload.a a2 = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                            if (a2 != null) {
                                a2.h = c2;
                                c.b.c(c2);
                                c.b.a(a2);
                            }
                        } else {
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createFromCache: " + str);
                            c.a(str);
                        }
                    } catch (Exception e) {
                        com.baidu.webkit.logsdk.d.c.a(e);
                    }
                }
            }
        }
    }
}
