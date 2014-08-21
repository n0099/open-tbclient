package com.baidu.tieba.neighbors;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
