package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class bl implements AdapterView.OnItemClickListener {
    final /* synthetic */ bj a;
    private final /* synthetic */ com.baidu.tieba.pb.ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar, com.baidu.tieba.pb.ah ahVar) {
        this.a = bjVar;
        this.b = ahVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.b == null || !this.b.b() || j != this.b.getCount() - 1) {
            return;
        }
        this.a.a(this.b.d(), this.b.e().c(), 10, this.b);
    }
}
