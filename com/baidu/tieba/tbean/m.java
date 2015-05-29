package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j cvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.cvh = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.cvh.beo = i;
        bVar = this.cvh.cuS;
        bVar.iZ(i);
        bVar2 = this.cvh.cuS;
        bVar2.notifyDataSetChanged();
        this.cvh.afl();
    }
}
