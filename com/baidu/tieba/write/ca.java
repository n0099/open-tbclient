package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    private int a;
    private bz b;

    public ca(int i, bz bzVar) {
        this.a = i;
        this.b = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.c(this.a);
        }
    }
}
