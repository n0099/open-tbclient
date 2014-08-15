package com.baidu.tieba.neighbors;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.j();
    }
}
