package com.baidu.webkit.logsdk.a;

import java.io.File;
/* loaded from: classes4.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f5995a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f5995a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5995a.b()) {
            com.baidu.webkit.logsdk.c.b c = this.f5995a.h().c();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
            for (String str : c.f6004a.keySet()) {
                if (c.f6004a.get(str).booleanValue()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: " + str);
                    try {
                        String c2 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                        File file = new File(com.baidu.webkit.logsdk.d.c.b(c2));
                        if (file.exists()) {
                            com.baidu.webkit.logsdk.upload.a a2 = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                            if (a2 != null) {
                                a2.h = c2;
                                c.f6005b.c(c2);
                                c.f6005b.a(a2);
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
