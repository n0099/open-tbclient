package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.j;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a dbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dbw = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        a.InterfaceC0079a interfaceC0079a;
        a.InterfaceC0079a interfaceC0079a2;
        jVar = this.dbw.dbt;
        com.baidu.tieba.write.album.b item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.b) {
            com.baidu.tieba.write.album.b bVar = item;
            interfaceC0079a = this.dbw.dbv;
            if (interfaceC0079a != null) {
                interfaceC0079a2 = this.dbw.dbv;
                interfaceC0079a2.a(i, bVar);
            }
        }
        this.dbw.WP();
    }
}
