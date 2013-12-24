package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ FragmentTabWidget a;
    private final int b;

    private z(FragmentTabWidget fragmentTabWidget, int i) {
        this.a = fragmentTabWidget;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        yVar = this.a.b;
        yVar.a(this.b, true);
    }
}
