package com.baidu.tieba.util;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements com.baidu.adp.lib.network.d {
    final /* synthetic */ NetWorkCoreByBdHttp a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NetWorkCoreByBdHttp netWorkCoreByBdHttp, String str, long j) {
        this.a = netWorkCoreByBdHttp;
        this.b = str;
        this.c = j;
    }

    @Override // com.baidu.adp.lib.network.d
    public final void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        bj bjVar;
        int i2;
        boolean z = false;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField != null && headerField.length() > 0) {
                        z = true;
                    }
                    bjVar = this.a.d;
                    if (bjVar.h || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        this.a.f = true;
                        i2 = this.a.i;
                        if (i2 == 1) {
                            this.a.i = 2;
                            return;
                        }
                        return;
                    }
                    this.a.f = false;
                    return;
                }
            } catch (IOException e) {
                com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), SocialConstants.FALSE, e.getMessage(), "connection failed."));
                try {
                    com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), String.valueOf(httpURLConnection.getContentLength()), String.valueOf(httpURLConnection.getResponseCode()) + ":" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage()));
                } catch (IOException e2) {
                    com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), String.valueOf(httpURLConnection.getContentLength()), "cann't get responseCode:" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage()));
                }
                e.printStackTrace();
                return;
            }
        }
        com.baidu.tieba.log.a.a(com.baidu.tieba.log.j.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), SocialConstants.FALSE, "failed to open connection.", "connection failed."));
    }

    @Override // com.baidu.adp.lib.network.d
    public final void a(int i, int i2) {
    }

    @Override // com.baidu.adp.lib.network.d
    public final void a(com.baidu.adp.lib.network.f fVar) {
    }
}
