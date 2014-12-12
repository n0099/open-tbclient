package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private ci cfZ;
    private int position;

    public cj(int i, ci ciVar) {
        this.position = i;
        this.cfZ = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cfZ != null) {
            this.cfZ.hs(this.position);
        }
    }
}
