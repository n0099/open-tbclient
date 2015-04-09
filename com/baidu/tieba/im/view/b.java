package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a bon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bon = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        e eVar;
        e eVar2;
        int i2;
        cVar = this.bon.boj;
        Object item = cVar.getItem(i);
        if (item instanceof com.baidu.tieba.im.data.d) {
            com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) item;
            eVar = this.bon.bom;
            if (eVar != null) {
                eVar2 = this.bon.bom;
                i2 = this.bon.bok;
                eVar2.a(i2, dVar);
            }
        }
    }
}
