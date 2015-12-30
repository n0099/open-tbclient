package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a dVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dVk = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0087a interfaceC0087a;
        a.InterfaceC0087a interfaceC0087a2;
        lVar = this.dVk.dVh;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0087a = this.dVk.dVj;
            if (interfaceC0087a != null) {
                interfaceC0087a2 = this.dVk.dVj;
                interfaceC0087a2.a(i, dVar);
            }
        }
        this.dVk.ace();
    }
}
