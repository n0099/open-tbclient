package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    private int a;
    private ca b;

    public cb(int i, ca caVar) {
        this.a = i;
        this.b = caVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.c(this.a);
        }
    }
}
