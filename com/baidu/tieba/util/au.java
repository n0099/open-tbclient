package com.baidu.tieba.util;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2473a;
    final /* synthetic */ long b;
    final /* synthetic */ NetWorkCoreByBdHttp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NetWorkCoreByBdHttp netWorkCoreByBdHttp, String str, long j) {
        this.c = netWorkCoreByBdHttp;
        this.f2473a = str;
        this.b = j;
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        az azVar;
        int i2;
        boolean z = false;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField != null && headerField.length() > 0) {
                        z = true;
                    }
                    azVar = this.c.d;
                    if (azVar.h || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        this.c.f = true;
                        i2 = this.c.i;
                        if (i2 == 1) {
                            this.c.i = 2;
                            return;
                        }
                        return;
                    }
                    this.c.f = false;
                    return;
                }
            } catch (IOException e) {
                y.a(this.f2473a, String.valueOf(System.currentTimeMillis() - this.b), SocialConstants.FALSE, e.getMessage(), "connection failed.");
                try {
                    y.a(this.f2473a, String.valueOf(System.currentTimeMillis() - this.b), String.valueOf(httpURLConnection.getContentLength()), httpURLConnection.getResponseCode() + ":" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage());
                } catch (IOException e2) {
                    y.a(this.f2473a, String.valueOf(System.currentTimeMillis() - this.b), String.valueOf(httpURLConnection.getContentLength()), "cann't get responseCode:" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage());
                }
                e.printStackTrace();
                return;
            }
        }
        y.a(this.f2473a, String.valueOf(System.currentTimeMillis() - this.b), SocialConstants.FALSE, "failed to open connection.", "connection failed.");
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(com.baidu.adp.lib.network.e eVar) {
    }

    @Override // com.baidu.adp.lib.network.c
    public void a() {
    }
}
