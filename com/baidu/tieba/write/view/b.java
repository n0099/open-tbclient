package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.m;
import com.baidu.tieba.write.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a fPK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fPK = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        a.InterfaceC0085a interfaceC0085a;
        a.InterfaceC0085a interfaceC0085a2;
        mVar = this.fPK.fPH;
        com.baidu.tieba.write.album.e item = mVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.e) {
            com.baidu.tieba.write.album.e eVar = item;
            interfaceC0085a = this.fPK.fPJ;
            if (interfaceC0085a != null) {
                interfaceC0085a2 = this.fPK.fPJ;
                interfaceC0085a2.a(i, eVar);
            }
        }
        this.fPK.arN();
    }
}
