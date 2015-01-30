package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private ci chz;
    private int position;

    public cj(int i, ci ciVar) {
        this.position = i;
        this.chz = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.chz != null) {
            this.chz.hB(this.position);
        }
    }
}
