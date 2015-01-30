package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ccq = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.ccq.aXn = i;
        bVar = this.ccq.ccb;
        bVar.ii(i);
        bVar2 = this.ccq.ccb;
        bVar2.notifyDataSetChanged();
        this.ccq.abI();
    }
}
