package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ com.baidu.tieba.data.ah d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, int i, int i2, com.baidu.tieba.data.ah ahVar) {
        this.a = azVar;
        this.b = i;
        this.c = i2;
        this.d = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.d.c(Math.min(this.b + 5, this.c));
        this.a.notifyDataSetChanged();
    }
}
