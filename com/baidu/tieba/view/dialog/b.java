package com.baidu.tieba.view.dialog;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ Button b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i, Button button) {
        this.c = aVar;
        this.a = i;
        this.b = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        cVar = this.c.c;
        cVar.a(this.c, this.a, this.b);
    }
}
