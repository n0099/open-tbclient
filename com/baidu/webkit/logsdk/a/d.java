package com.baidu.webkit.logsdk.a;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import java.io.File;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.baidu.webkit.logsdk.upload.a f27482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f27483b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f27484c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f27485d;

    public d(b bVar, com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        this.f27485d = bVar;
        this.f27482a = aVar;
        this.f27483b = j;
        this.f27484c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.webkit.logsdk.c.c h2 = this.f27485d.h();
        com.baidu.webkit.logsdk.upload.a aVar = this.f27482a;
        long j = this.f27483b;
        boolean z = this.f27484c;
        int i2 = aVar.f27524e.f27490b;
        String str = aVar.f27527h;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = " + str);
        String l = (i2 == 1 || i2 == 2) ? Long.toString(j) : i2 == 3 ? "upload" : null;
        if (!TextUtils.isEmpty(l)) {
            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.f27524e.f27489a, l);
            String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = " + b2);
            StringBuilder sb = new StringBuilder();
            int i3 = aVar.f27521b;
            if (z) {
                i3++;
            } else if (c2.equals(str)) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                return;
            }
            sb.append(i3);
            sb.append(Part.CRLF);
            sb.append(aVar.f27525f);
            sb.append(Part.CRLF);
            sb.append(aVar.f27528i);
            sb.append(Part.CRLF);
            sb.append(aVar.f27520a);
            com.baidu.webkit.logsdk.d.c.b(b2, sb.toString());
            if (!TextUtils.isEmpty(str)) {
                b.a().h().b(str);
                if (i2 != 3) {
                    new File(com.baidu.webkit.logsdk.d.c.b(str)).delete();
                }
            }
            try {
                h2.d();
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
        b.a().f().a(aVar.f27523d);
    }
}
