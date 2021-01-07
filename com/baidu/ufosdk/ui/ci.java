package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.Map;
/* loaded from: classes8.dex */
final class ci implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5775a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cg f5776b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar, int i) {
        this.f5776b = cgVar;
        this.f5775a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.f5776b.f5772a.h.get(this.f5775a)).put("ask", 2);
        new Thread(new cj(this)).start();
    }
}
