package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fNF = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0079a interfaceC0079a;
        a.InterfaceC0079a interfaceC0079a2;
        lVar = this.fNF.fNC;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0079a = this.fNF.fNE;
            if (interfaceC0079a != null) {
                interfaceC0079a2 = this.fNF.fNE;
                interfaceC0079a2.a(i, dVar);
            }
        }
        this.fNF.atY();
    }
}
