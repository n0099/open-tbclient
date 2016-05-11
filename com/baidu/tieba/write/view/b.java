package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a faQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.faQ = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        lVar = this.faQ.faO;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0083a = this.faQ.faP;
            if (interfaceC0083a != null) {
                interfaceC0083a2 = this.faQ.faP;
                interfaceC0083a2.a(i, dVar);
            }
        }
        this.faQ.aiN();
    }
}
