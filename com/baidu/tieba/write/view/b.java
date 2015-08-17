package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.j;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a cSI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cSI = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        a.InterfaceC0076a interfaceC0076a;
        a.InterfaceC0076a interfaceC0076a2;
        jVar = this.cSI.cSF;
        com.baidu.tieba.write.album.b item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.b) {
            com.baidu.tieba.write.album.b bVar = item;
            interfaceC0076a = this.cSI.cSH;
            if (interfaceC0076a != null) {
                interfaceC0076a2 = this.cSI.cSH;
                interfaceC0076a2.a(i, bVar);
            }
        }
        this.cSI.WN();
    }
}
