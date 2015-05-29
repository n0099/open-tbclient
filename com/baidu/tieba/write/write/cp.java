package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    private co cDv;
    private int position;

    public cp(int i, co coVar) {
        this.position = i;
        this.cDv = coVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cDv != null) {
            this.cDv.jv(this.position);
        }
    }
}
