package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a gcy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gcy = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        lVar = this.gcy.gcw;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0083a = this.gcy.gcx;
            if (interfaceC0083a != null) {
                interfaceC0083a2 = this.gcy.gcx;
                interfaceC0083a2.a(i, dVar);
            }
        }
        this.gcy.awC();
    }
}
