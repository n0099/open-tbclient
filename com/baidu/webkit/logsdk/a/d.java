package com.baidu.webkit.logsdk.a;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import java.io.File;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.baidu.webkit.logsdk.upload.a f26979a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f26980b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26981c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f26982d;

    public d(b bVar, com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        this.f26982d = bVar;
        this.f26979a = aVar;
        this.f26980b = j;
        this.f26981c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.webkit.logsdk.c.c h2 = this.f26982d.h();
        com.baidu.webkit.logsdk.upload.a aVar = this.f26979a;
        long j = this.f26980b;
        boolean z = this.f26981c;
        int i = aVar.f27021e.f26987b;
        String str = aVar.f27024h;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = " + str);
        String l = (i == 1 || i == 2) ? Long.toString(j) : i == 3 ? "upload" : null;
        if (!TextUtils.isEmpty(l)) {
            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.f27021e.f26986a, l);
            String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = " + b2);
            StringBuilder sb = new StringBuilder();
            int i2 = aVar.f27018b;
            if (z) {
                i2++;
            } else if (c2.equals(str)) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                return;
            }
            sb.append(i2);
            sb.append(Part.CRLF);
            sb.append(aVar.f27022f);
            sb.append(Part.CRLF);
            sb.append(aVar.i);
            sb.append(Part.CRLF);
            sb.append(aVar.f27017a);
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
        b.a().f().a(aVar.f27020d);
    }
}
