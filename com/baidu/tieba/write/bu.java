package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public final class bu implements View.OnClickListener {
    private int a;
    private bt b;

    public bu(int i, bt btVar) {
        this.a = i;
        this.b = btVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b != null) {
            this.b.c(this.a);
        }
    }
}
