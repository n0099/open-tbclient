package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.m;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fXG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fXG = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        a.InterfaceC0088a interfaceC0088a;
        a.InterfaceC0088a interfaceC0088a2;
        mVar = this.fXG.fXD;
        com.baidu.tieba.write.album.e item = mVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.e) {
            com.baidu.tieba.write.album.e eVar = item;
            interfaceC0088a = this.fXG.fXF;
            if (interfaceC0088a != null) {
                interfaceC0088a2 = this.fXG.fXF;
                interfaceC0088a2.a(i, eVar);
            }
        }
        this.fXG.asL();
    }
}
