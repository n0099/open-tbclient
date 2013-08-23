package com.baidu.tieba.util;

import android.os.Handler;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class aa implements com.baidu.adp.lib.network.c {

    /* renamed from: a  reason: collision with root package name */
    int f1775a = 0;
    int b = 0;
    int c = 0;
    final /* synthetic */ NetWorkCoreByBdHttp d;
    private final /* synthetic */ Handler e;
    private final /* synthetic */ int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(NetWorkCoreByBdHttp netWorkCoreByBdHttp, Handler handler, int i) {
        this.d = netWorkCoreByBdHttp;
        this.e = handler;
        this.f = i;
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && i > 0) {
            this.f1775a = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.b += i - this.c;
        this.c = i;
        if (this.e != null) {
            if (this.b > this.f1775a || i == i2) {
                this.b = 0;
                this.e.sendMessage(this.e.obtainMessage(this.f, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.c
    public void a(com.baidu.adp.lib.network.e eVar) {
        aq.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(eVar.b));
    }

    @Override // com.baidu.adp.lib.network.c
    public void a() {
    }
}
