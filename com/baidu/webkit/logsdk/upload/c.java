package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d;
import java.io.File;
/* loaded from: classes8.dex */
public final class c implements d {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    public c(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    @Override // com.baidu.webkit.logsdk.d
    public final void a(byte[] bArr) {
        if (bArr == null) {
            this.b.a(this.a);
            return;
        }
        b bVar = this.b;
        a aVar = this.a;
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "onUploadSuccess", null);
        String str = aVar.e.a;
        if (aVar.e.b == 3) {
            com.baidu.webkit.logsdk.a.b.a().e();
            com.baidu.webkit.logsdk.b.b.a(str, System.currentTimeMillis());
            com.baidu.webkit.logsdk.a.b.a().h().c().a(str, false);
        }
        String str2 = aVar.h;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.webkit.logsdk.a.b.a().h().b(str2);
            new File(com.baidu.webkit.logsdk.d.c.b(str2)).delete();
        }
        bVar.a(aVar.d);
        com.baidu.webkit.logsdk.a.b.a().a(0L);
    }
}
