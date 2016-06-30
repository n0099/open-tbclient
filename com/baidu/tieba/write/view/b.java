package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fGs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fGs = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        a.InterfaceC0085a interfaceC0085a;
        a.InterfaceC0085a interfaceC0085a2;
        lVar = this.fGs.fGq;
        com.baidu.tieba.write.album.d item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.d) {
            com.baidu.tieba.write.album.d dVar = item;
            interfaceC0085a = this.fGs.fGr;
            if (interfaceC0085a != null) {
                interfaceC0085a2 = this.fGs.fGr;
                interfaceC0085a2.a(i, dVar);
            }
        }
        this.fGs.arc();
    }
}
