package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f23119b;

    public ci(cg cgVar, int i) {
        this.f23119b = cgVar;
        this.f23118a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f23119b.f23115a.f23022h.get(this.f23118a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
