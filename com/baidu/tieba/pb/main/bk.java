package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ bc a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ com.baidu.tieba.data.am d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bc bcVar, int i, int i2, com.baidu.tieba.data.am amVar) {
        this.a = bcVar;
        this.b = i;
        this.c = i2;
        this.d = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.d.d(Math.min(this.b + 5, this.c));
        this.a.notifyDataSetChanged();
    }
}
