package com.baidu.tieba.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class av implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    int f2491a = 0;
    int b = 0;
    int c = 0;
    final /* synthetic */ Handler d;
    final /* synthetic */ int e;
    final /* synthetic */ NetWorkCoreByBdHttp f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NetWorkCoreByBdHttp netWorkCoreByBdHttp, Handler handler, int i) {
        this.f = netWorkCoreByBdHttp;
        this.d = handler;
        this.e = i;
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.f2491a = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.b += i - this.c;
        this.c = i;
        if (this.d != null) {
            if (this.b > this.f2491a || i == i2) {
                this.b = 0;
                this.d.sendMessage(this.d.obtainMessage(this.e, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(com.baidu.adp.lib.network.e eVar) {
        bg.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(eVar.b));
    }

    @Override // com.baidu.adp.lib.network.c
    public void a() {
    }
}
