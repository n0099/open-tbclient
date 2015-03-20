package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a bnX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bnX = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        e eVar;
        e eVar2;
        int i2;
        cVar = this.bnX.bnT;
        Object item = cVar.getItem(i);
        if (item instanceof com.baidu.tieba.im.data.d) {
            com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) item;
            eVar = this.bnX.bnW;
            if (eVar != null) {
                eVar2 = this.bnX.bnW;
                i2 = this.bnX.bnU;
                eVar2.a(i2, dVar);
            }
        }
    }
}
