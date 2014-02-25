package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ FragmentTabWidget a;
    private final int b;

    private s(FragmentTabWidget fragmentTabWidget, int i) {
        this.a = fragmentTabWidget;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(FragmentTabWidget fragmentTabWidget, int i, s sVar) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.a.b;
        rVar.a(this.b, true);
    }
}
