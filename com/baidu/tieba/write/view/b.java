package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a cwB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cwB = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.album.j jVar;
        e eVar;
        e eVar2;
        jVar = this.cwB.cwy;
        com.baidu.tieba.write.album.a item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.a) {
            com.baidu.tieba.write.album.a aVar = item;
            eVar = this.cwB.cwA;
            if (eVar != null) {
                eVar2 = this.cwB.cwA;
                eVar2.a(i, aVar);
            }
        }
        this.cwB.TS();
    }
}
