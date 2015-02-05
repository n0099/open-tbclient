package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private ci chy;
    private int position;

    public cj(int i, ci ciVar) {
        this.position = i;
        this.chy = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.chy != null) {
            this.chy.hB(this.position);
        }
    }
}
