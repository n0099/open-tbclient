package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22881b;

    public ci(cg cgVar, int i2) {
        this.f22881b = cgVar;
        this.f22880a = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f22881b.f22877a.f22781h.get(this.f22880a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
