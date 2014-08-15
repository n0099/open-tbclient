package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ bf a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ com.baidu.tieba.data.an d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, int i, int i2, com.baidu.tieba.data.an anVar) {
        this.a = bfVar;
        this.b = i;
        this.c = i2;
        this.d = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.d.c(Math.min(this.b + 5, this.c));
        this.a.notifyDataSetChanged();
    }
}
