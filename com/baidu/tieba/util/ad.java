package com.baidu.tieba.util;

import java.io.IOException;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f1893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f1893a = netWorkCoreByBdHttp;
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, HttpURLConnection httpURLConnection) {
        ah ahVar;
        boolean z = true;
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField("imgsrc");
                if (headerField == null || headerField.length() <= 0) {
                    z = false;
                }
                ahVar = this.f1893a.d;
                if (ahVar.h || z) {
                    byte[] bArr = new byte[23];
                    int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                    if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;") && httpURLConnection != null && httpURLConnection.getOutputStream() != null) {
                        httpURLConnection.getOutputStream().write(bArr, 0, read);
                    }
                }
                if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                    this.f1893a.f = true;
                } else {
                    this.f1893a.f = false;
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
