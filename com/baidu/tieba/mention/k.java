package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        int i2;
        e eVar = (e) ((ListView) adapterView).getAdapter();
        long itemId = eVar.getItemId(i);
        if (itemId == -1) {
            this.a.b();
        } else if (itemId == -2) {
            h hVar = this.a;
            i2 = hVar.g;
            hVar.g = i2 + 1;
            this.a.o = 4;
            this.a.d();
        } else {
            com.baidu.tieba.a.p pVar = (com.baidu.tieba.a.p) eVar.getItem(i);
            if (pVar != null) {
                oVar = this.a.q;
                oVar.a(pVar);
                this.a.a(pVar);
            }
        }
    }
}
