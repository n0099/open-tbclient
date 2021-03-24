package com.baidu.webkit.logsdk.a;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import java.io.File;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.baidu.webkit.logsdk.upload.a f26978a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f26979b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26980c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f26981d;

    public d(b bVar, com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        this.f26981d = bVar;
        this.f26978a = aVar;
        this.f26979b = j;
        this.f26980c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.webkit.logsdk.c.c h2 = this.f26981d.h();
        com.baidu.webkit.logsdk.upload.a aVar = this.f26978a;
        long j = this.f26979b;
        boolean z = this.f26980c;
        int i = aVar.f27020e.f26986b;
        String str = aVar.f27023h;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = " + str);
        String l = (i == 1 || i == 2) ? Long.toString(j) : i == 3 ? "upload" : null;
        if (!TextUtils.isEmpty(l)) {
            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.f27020e.f26985a, l);
            String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = " + b2);
            StringBuilder sb = new StringBuilder();
            int i2 = aVar.f27017b;
            if (z) {
                i2++;
            } else if (c2.equals(str)) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                return;
            }
            sb.append(i2);
            sb.append(Part.CRLF);
            sb.append(aVar.f27021f);
            sb.append(Part.CRLF);
            sb.append(aVar.i);
            sb.append(Part.CRLF);
            sb.append(aVar.f27016a);
            com.baidu.webkit.logsdk.d.c.b(b2, sb.toString());
            if (!TextUtils.isEmpty(str)) {
                b.a().h().b(str);
                if (i != 3) {
                    new File(com.baidu.webkit.logsdk.d.c.b(str)).delete();
                }
            }
            try {
                h2.d();
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
        b.a().f().a(aVar.f27019d);
    }
}
