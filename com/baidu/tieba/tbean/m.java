package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.crd = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.crd.bbK = i;
        bVar = this.crd.cqO;
        bVar.iD(i);
        bVar2 = this.crd.cqO;
        bVar2.notifyDataSetChanged();
        this.crd.aeg();
    }
}
