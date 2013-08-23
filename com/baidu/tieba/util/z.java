package com.baidu.tieba.util;

import java.io.IOException;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f1813a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f1813a = netWorkCoreByBdHttp;
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, HttpURLConnection httpURLConnection) {
        ad adVar;
        if (httpURLConnection != null) {
            try {
                adVar = this.f1813a.d;
                if (adVar.h) {
                    byte[] bArr = new byte[23];
                    int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                    if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;") && httpURLConnection != null && httpURLConnection.getOutputStream() != null) {
                        httpURLConnection.getOutputStream().write(bArr, 0, read);
                    }
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
