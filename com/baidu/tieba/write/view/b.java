package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a geI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.geI = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0086a interfaceC0086a;
        a.InterfaceC0086a interfaceC0086a2;
        lVar = this.geI.geG;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0086a = this.geI.geH;
            if (interfaceC0086a != null) {
                interfaceC0086a2 = this.geI.geH;
                interfaceC0086a2.a(i, dVar);
            }
        }
        this.geI.axb();
    }
}
