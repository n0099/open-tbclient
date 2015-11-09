package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.doF = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.album.j jVar;
        a.InterfaceC0082a interfaceC0082a;
        a.InterfaceC0082a interfaceC0082a2;
        jVar = this.doF.doC;
        com.baidu.tieba.write.album.b item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.b) {
            com.baidu.tieba.write.album.b bVar = item;
            interfaceC0082a = this.doF.doE;
            if (interfaceC0082a != null) {
                interfaceC0082a2 = this.doF.doE;
                interfaceC0082a2.a(i, bVar);
            }
        }
        this.doF.XP();
    }
}
