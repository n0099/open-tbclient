package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fRK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fRK = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0078a interfaceC0078a;
        a.InterfaceC0078a interfaceC0078a2;
        lVar = this.fRK.fRH;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0078a = this.fRK.fRJ;
            if (interfaceC0078a != null) {
                interfaceC0078a2 = this.fRK.fRJ;
                interfaceC0078a2.a(i, dVar);
            }
        }
        this.fRK.auS();
    }
}
