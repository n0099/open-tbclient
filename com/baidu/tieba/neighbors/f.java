package com.baidu.tieba.neighbors;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
