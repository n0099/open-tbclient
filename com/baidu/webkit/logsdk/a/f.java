package com.baidu.webkit.logsdk.a;

import java.io.File;
/* loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.b()) {
            com.baidu.webkit.logsdk.c.b c = this.a.h().c();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
            for (String str : c.a.keySet()) {
                if (c.a.get(str).booleanValue()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: " + str);
                    try {
                        String c2 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c2));
                        if (file.exists()) {
                            com.baidu.webkit.logsdk.upload.a a = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().b(str));
                            if (a != null) {
                                a.h = c2;
                                c.b.c(c2);
                                c.b.a(a);
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
