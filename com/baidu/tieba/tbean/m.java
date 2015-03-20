package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.cqN = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.cqN.bbu = i;
        bVar = this.cqN.cqy;
        bVar.iA(i);
        bVar2 = this.cqN.cqy;
        bVar2.notifyDataSetChanged();
        this.cqN.adR();
    }
}
