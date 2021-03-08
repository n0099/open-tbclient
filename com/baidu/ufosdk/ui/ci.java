package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes7.dex */
final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3709a;
    final /* synthetic */ cg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar, int i) {
        this.b = cgVar;
        this.f3709a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.b.f3707a.h.get(this.f3709a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
