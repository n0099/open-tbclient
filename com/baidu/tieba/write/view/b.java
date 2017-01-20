package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fJm = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0080a interfaceC0080a;
        a.InterfaceC0080a interfaceC0080a2;
        lVar = this.fJm.fJj;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0080a = this.fJm.fJl;
            if (interfaceC0080a != null) {
                interfaceC0080a2 = this.fJm.fJl;
                interfaceC0080a2.a(i, dVar);
            }
        }
        this.fJm.auD();
    }
}
