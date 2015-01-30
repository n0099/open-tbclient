package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a ceF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ceF = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.album.j jVar;
        e eVar;
        e eVar2;
        jVar = this.ceF.ceC;
        com.baidu.tieba.album.a item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.album.a) {
            com.baidu.tieba.album.a aVar = item;
            eVar = this.ceF.ceE;
            if (eVar != null) {
                eVar2 = this.ceF.ceE;
                eVar2.a(i, aVar);
            }
        }
        this.ceF.TK();
    }
}
