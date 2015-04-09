package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
public class co implements View.OnClickListener {
    private cn czd;
    private int position;

    public co(int i, cn cnVar) {
        this.position = i;
        this.czd = cnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.czd != null) {
            this.czd.iZ(this.position);
        }
    }
}
