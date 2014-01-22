package com.baidu.tieba.view.dialog;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ Button b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i, Button button) {
        this.c = dVar;
        this.a = i;
        this.b = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        fVar = this.c.c;
        fVar.a(this.c, this.a, this.b);
    }
}
