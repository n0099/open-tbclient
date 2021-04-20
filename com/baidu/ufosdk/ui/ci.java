package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22804b;

    public ci(cg cgVar, int i) {
        this.f22804b = cgVar;
        this.f22803a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f22804b.f22800a.f22707h.get(this.f22803a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
