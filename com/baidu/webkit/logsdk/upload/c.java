package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d;
import java.io.File;
/* loaded from: classes5.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f27026a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f27027b;

    public c(b bVar, a aVar) {
        this.f27027b = bVar;
        this.f27026a = aVar;
    }

    @Override // com.baidu.webkit.logsdk.d
    public final void a(byte[] bArr) {
        if (bArr == null) {
            this.f27027b.a(this.f27026a);
            return;
        }
        b bVar = this.f27027b;
        a aVar = this.f27026a;
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "onUploadSuccess", null);
        com.baidu.webkit.logsdk.b.a aVar2 = aVar.f27020e;
        String str = aVar2.f26985a;
        if (aVar2.f26986b == 3) {
            com.baidu.webkit.logsdk.a.b.a().e();
            com.baidu.webkit.logsdk.b.b.a(str, System.currentTimeMillis());
            com.baidu.webkit.logsdk.a.b.a().h().c().a(str, false);
        }
        String str2 = aVar.f27023h;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.webkit.logsdk.a.b.a().h().b(str2);
            new File(com.baidu.webkit.logsdk.d.c.b(str2)).delete();
        }
        bVar.a(aVar.f27019d);
        com.baidu.webkit.logsdk.a.b.a().a(0L);
    }
}
