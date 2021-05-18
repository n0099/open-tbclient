package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22766a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22767b;

    public ci(cg cgVar, int i2) {
        this.f22767b = cgVar;
        this.f22766a = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f22767b.f22763a.f22667h.get(this.f22766a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
