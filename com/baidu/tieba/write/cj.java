package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private ci bUR;
    private int position;

    public cj(int i, ci ciVar) {
        this.position = i;
        this.bUR = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUR != null) {
            this.bUR.hj(this.position);
        }
    }
}
