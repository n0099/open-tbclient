package com.baidu.tieba.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class bd implements com.baidu.adp.lib.network.d {
    int a = 0;
    int b = 0;
    int c = 0;
    final /* synthetic */ NetWorkCoreByBdHttp d;
    private final /* synthetic */ Handler e;
    private final /* synthetic */ int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NetWorkCoreByBdHttp netWorkCoreByBdHttp, Handler handler, int i) {
        this.d = netWorkCoreByBdHttp;
        this.e = handler;
        this.f = i;
    }

    @Override // com.baidu.adp.lib.network.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.a = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.b += i - this.c;
        this.c = i;
        if (this.e != null) {
            if (this.b > this.a || i == i2) {
                this.b = 0;
                this.e.sendMessage(this.e.obtainMessage(this.f, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.d
    public void a(com.baidu.adp.lib.network.f fVar) {
        com.baidu.adp.lib.util.f.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(fVar.b));
    }

    @Override // com.baidu.adp.lib.network.d
    public void a() {
    }
}
