package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j bOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.bOm = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.bOm.aUv = i;
        bVar = this.bOm.bNX;
        bVar.hp(i);
        bVar2 = this.bOm.bNX;
        bVar2.notifyDataSetChanged();
        this.bOm.aaJ();
    }
}
