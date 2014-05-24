package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ com.baidu.tieba.data.ai d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(az azVar, int i, int i2, com.baidu.tieba.data.ai aiVar) {
        this.a = azVar;
        this.b = i;
        this.c = i2;
        this.d = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.d.d(Math.min(this.b + 5, this.c));
        this.a.notifyDataSetChanged();
    }
}
