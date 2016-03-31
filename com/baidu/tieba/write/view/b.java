package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a eJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eJZ = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0090a interfaceC0090a;
        a.InterfaceC0090a interfaceC0090a2;
        lVar = this.eJZ.eJX;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0090a = this.eJZ.eJY;
            if (interfaceC0090a != null) {
                interfaceC0090a2 = this.eJZ.eJY;
                interfaceC0090a2.a(i, dVar);
            }
        }
        this.eJZ.aiG();
    }
}
