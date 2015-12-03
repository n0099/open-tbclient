package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a dNL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dNL = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0091a interfaceC0091a;
        a.InterfaceC0091a interfaceC0091a2;
        lVar = this.dNL.dNI;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0091a = this.dNL.dNK;
            if (interfaceC0091a != null) {
                interfaceC0091a2 = this.dNL.dNK;
                interfaceC0091a2.a(i, dVar);
            }
        }
        this.dNL.aaV();
    }
}
