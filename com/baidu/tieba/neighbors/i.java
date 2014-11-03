package com.baidu.tieba.neighbors;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NeighborsActivity neighborsActivity) {
        this.buj = neighborsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.buj.finish();
    }
}
