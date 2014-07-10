package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        r rVar;
        r rVar2;
        int i2;
        pVar = this.a.f;
        Object item = pVar.getItem(i);
        if (item instanceof com.baidu.tieba.im.data.l) {
            com.baidu.tieba.im.data.l lVar = (com.baidu.tieba.im.data.l) item;
            rVar = this.a.i;
            if (rVar != null) {
                rVar2 = this.a.i;
                i2 = this.a.g;
                rVar2.a(i2, lVar);
            }
        }
    }
}
