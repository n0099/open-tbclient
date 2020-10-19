package com.baidu.webkit.logsdk.a;

import android.text.TextUtils;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.upload.a f3952a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        this.d = bVar;
        this.f3952a = aVar;
        this.b = j;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.webkit.logsdk.c.c h = this.d.h();
        com.baidu.webkit.logsdk.upload.a aVar = this.f3952a;
        long j = this.b;
        boolean z = this.c;
        String str = null;
        int i = aVar.e.b;
        String str2 = aVar.h;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = " + str2);
        if (i == 1 || i == 2) {
            str = Long.toString(j);
        } else if (i == 3) {
            str = "upload";
        }
        if (!TextUtils.isEmpty(str)) {
            String c = com.baidu.webkit.logsdk.d.c.c(aVar.e.f3955a, str);
            String b = com.baidu.webkit.logsdk.d.c.b(c);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = " + b);
            StringBuilder sb = new StringBuilder();
            int i2 = aVar.b;
            if (z) {
                i2++;
            } else if (c.equals(str2)) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                return;
            }
            sb.append(i2);
            sb.append("\r\n");
            sb.append(aVar.f);
            sb.append("\r\n");
            sb.append(aVar.i);
            sb.append("\r\n");
            sb.append(aVar.f3965a);
            com.baidu.webkit.logsdk.d.c.b(b, sb.toString());
            if (!TextUtils.isEmpty(str2)) {
                b.a().h().b(str2);
                if (i != 3) {
                    new File(com.baidu.webkit.logsdk.d.c.b(str2)).delete();
                }
            }
            try {
                h.d();
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
        b.a().f().a(aVar.d);
    }
}
