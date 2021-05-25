package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22695a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22696b;

    public ci(cg cgVar, int i2) {
        this.f22696b = cgVar;
        this.f22695a = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f22696b.f22692a.f22596h.get(this.f22695a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
