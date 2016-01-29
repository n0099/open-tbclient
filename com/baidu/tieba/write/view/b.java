package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a eqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eqd = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0092a interfaceC0092a;
        a.InterfaceC0092a interfaceC0092a2;
        lVar = this.eqd.eqb;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0092a = this.eqd.eqc;
            if (interfaceC0092a != null) {
                interfaceC0092a2 = this.eqd.eqc;
                interfaceC0092a2.a(i, dVar);
            }
        }
        this.eqd.afm();
    }
}
