package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d;
import java.io.File;
/* loaded from: classes4.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f5720a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5721b;

    public c(b bVar, a aVar) {
        this.f5721b = bVar;
        this.f5720a = aVar;
    }

    @Override // com.baidu.webkit.logsdk.d
    public final void a(byte[] bArr) {
        if (bArr == null) {
            this.f5721b.a(this.f5720a);
            return;
        }
        b bVar = this.f5721b;
        a aVar = this.f5720a;
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "onUploadSuccess", null);
        String str = aVar.e.f5699a;
        if (aVar.e.f5700b == 3) {
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
