package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.i;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a dmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dmX = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        a.InterfaceC0082a interfaceC0082a;
        a.InterfaceC0082a interfaceC0082a2;
        iVar = this.dmX.dmU;
        com.baidu.tieba.write.album.a item = iVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.a) {
            com.baidu.tieba.write.album.a aVar = item;
            interfaceC0082a = this.dmX.dmW;
            if (interfaceC0082a != null) {
                interfaceC0082a2 = this.dmX.dmW;
                interfaceC0082a2.a(i, aVar);
            }
        }
        this.dmX.Xu();
    }
}
