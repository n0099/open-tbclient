package com.baidu.tieba.view.dialog;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ int b;
    private final /* synthetic */ Button c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, int i, Button button) {
        this.a = dVar;
        this.b = i;
        this.c = button;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f fVar;
        fVar = this.a.c;
        d dVar = this.a;
        int i = this.b;
        Button button = this.c;
        fVar.a(dVar, i);
    }
}
