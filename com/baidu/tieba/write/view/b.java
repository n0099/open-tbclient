package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.m;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a giG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.giG = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        a.InterfaceC0090a interfaceC0090a;
        a.InterfaceC0090a interfaceC0090a2;
        mVar = this.giG.giD;
        com.baidu.tieba.write.album.e item = mVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.e) {
            com.baidu.tieba.write.album.e eVar = item;
            interfaceC0090a = this.giG.giF;
            if (interfaceC0090a != null) {
                interfaceC0090a2 = this.giG.giF;
                interfaceC0090a2.a(i, eVar);
            }
        }
        this.giG.aww();
    }
}
