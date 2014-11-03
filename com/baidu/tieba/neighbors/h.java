package com.baidu.tieba.neighbors;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NeighborsActivity neighborsActivity) {
        this.buj = neighborsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.buj.VU();
    }
}
