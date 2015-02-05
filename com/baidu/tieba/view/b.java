package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ceE = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.album.j jVar;
        e eVar;
        e eVar2;
        jVar = this.ceE.ceB;
        com.baidu.tieba.album.a item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.album.a) {
            com.baidu.tieba.album.a aVar = item;
            eVar = this.ceE.ceD;
            if (eVar != null) {
                eVar2 = this.ceE.ceD;
                eVar2.a(i, aVar);
            }
        }
        this.ceE.TF();
    }
}
