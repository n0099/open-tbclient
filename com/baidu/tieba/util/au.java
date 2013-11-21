package com.baidu.tieba.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f2473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f2473a = netWorkCoreByBdHttp;
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
                    azVar = this.f2473a.d;
                    if (azVar.h || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        this.f2473a.f = true;
                        i2 = this.f2473a.i;
                        if (i2 == 1) {
                            this.f2473a.i = 2;
                            return;
                        }
                        return;
                    }
                    this.f2473a.f = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
