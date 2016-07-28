package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fSt = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        lVar = this.fSt.fSr;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0083a = this.fSt.fSs;
            if (interfaceC0083a != null) {
                interfaceC0083a2 = this.fSt.fSs;
                interfaceC0083a2.a(i, dVar);
            }
        }
        this.fSt.arO();
    }
}
