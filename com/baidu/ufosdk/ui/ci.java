package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f23118b;

    public ci(cg cgVar, int i) {
        this.f23118b = cgVar;
        this.f23117a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f23118b.f23114a.f23021h.get(this.f23117a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
