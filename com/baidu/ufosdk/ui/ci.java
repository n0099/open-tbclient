package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f23522b;

    public ci(cg cgVar, int i2) {
        this.f23522b = cgVar;
        this.f23521a = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f23522b.f23518a.f23422h.get(this.f23521a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
